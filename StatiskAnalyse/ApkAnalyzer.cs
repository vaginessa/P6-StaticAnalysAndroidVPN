using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.IO.Compression;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using ICSharpCode.SharpZipLib.Core;
using ICSharpCode.SharpZipLib.Zip;

namespace StatiskAnalyse
{
    class ApkAnalysis
    {
        private static readonly string[] Permissions;
        private static readonly string[] Trackers;

        static ApkAnalysis()
        {
            Permissions = File.ReadLines("../../perms.txt").Select(l => l.Substring(31, l.Length - 34)).ToArray();
            Trackers = File.ReadLines("../../trackers.txt").ToArray();
            CriticalLibs = new[]
            {
                "org/spongycastle",
                "de/blinkt/openvpn",
                "okhttp3",
                "okhttp"
            };
        }

        public static string[] CriticalLibs { get; set; }


        private static readonly string EnjarifyPath = Path.GetFullPath("../../TOOLS/enjarify");
        private static readonly string SavePath = Path.GetFullPath("/STAN");
        //private static readonly string ReportPath = Path.GetFullPath("/REPORTS");
        private static readonly int TempPathLength = SavePath.Length + 1;
        
        public List<string> CriticalLibsUsed { get; } = new List<string>();
        public List<string> TrackersUsed { get; } = new List<string>();
        public List<string> PermissionsUsed { get; } = new List<string>();
        public List<SearchResult> Results { get; private set; }
        public ClassFileDirectory Root { get; private set; }
        public string Name { get; private set; }

        public void GenerateReport()
        {
            var rb = new StringBuilder();
            rb.AppendLine("Analysis of '" + Name + "'\n");

            rb.AppendLine("\tPermissions used:");
            foreach (var per in PermissionsUsed)
            {
                rb.AppendLine("\t\t" + per);
            }
            rb.AppendLine();
            
            rb.AppendLine("\tCritical libraries:");
            foreach (var clib in CriticalLibsUsed)
            {
                rb.AppendLine("\t\t" + clib);
            }
            rb.AppendLine();

            rb.AppendLine("\tTrackers found:");
            foreach (var track in TrackersUsed)
            {
                rb.AppendLine("\t\t" + track);
            }
            rb.AppendLine();

            var founds = Results.Where(r => r.Uses.Count != 0).OrderBy(r => r.Pattern);
            var notFounds = Results.Where(r => r.Uses.Count == 0).OrderBy(r => r.Pattern);

            rb.AppendLine("\tSearch patterns found:");
            foreach (var searchResult in founds)
            {
                rb.AppendLine($"\t\t{searchResult.Uses.Count} use(s) of '{searchResult.Pattern}'");
            }
            rb.AppendLine();

            if (notFounds.Any()) rb.AppendLine("\n\tSearch patterns not found:");
            foreach (var searchResult in notFounds)
                rb.AppendLine("\t\t" + searchResult.Pattern);

            rb.AppendLine();
            foreach (var searchResult in founds)
            {
                rb.AppendLine($"\tUses of '{searchResult.Pattern}'");
                foreach (var use in searchResult.Uses)
                    rb.AppendLine($"\t\t'{MakePathRelative(use.FoundIn.FilePath)}' :: {use.Index}");/*  =>  '{use.Sample}'");*/
                rb.AppendLine();
            }

            File.WriteAllText(Path.Combine(SavePath, Name, "Report.txt"), rb.ToString());
        }
        
        private static string MakePathRelative(string path)
        {
            return path.Substring(TempPathLength);
        }

        #region Enjarify toolchain

        public static ApkAnalysis LoadApkEnjarify(string path, params string[] lookFor)
        {
            var aa = InternalEnjarifyToolChain(path);
            aa.Results = aa.Root.FindUses(lookFor);
            return aa;
        }

        public static ApkAnalysis LoadApkEnjarify(string path, params Regex[] lookFor)
        {
            var aa = InternalEnjarifyToolChain(path);
            aa.Results = aa.Root.FindUses(lookFor);
            return aa;
        }

        private static ApkAnalysis InternalEnjarifyToolChain(string path)
        {
            Directory.CreateDirectory(SavePath);
            //Directory.CreateDirectory(ReportPath);
            var aa = new ApkAnalysis { Name = Path.GetFileNameWithoutExtension(path) };
            var d = Path.Combine(SavePath, aa.Name);
            var am = Path.Combine(d, "AndroidManifest.xml");
            var c = Path.Combine(d, "classes.dex");
            var jaf = Path.Combine(d, "classes.jar");
            var dd = Path.Combine(d, "UNPACKED");

            if (!File.Exists(am))
                UnzipFile(path, "AndroidManifest.xml");
            if (!File.Exists(c))
                UnzipFile(path, "classes.dex");
            if (!File.Exists(jaf))
                Enjarify(c);
            if (!Directory.Exists(dd))
                Unzip(jaf);

            AnalyzeManifest(am, aa);
            aa.Root = ClassFileDirectory.LoadFromDirectory(dd, "class");
            AnalyzeTrackerUse(aa);
            AnalyzeCryptoLibUse(aa);
            return aa;
        }

        private static void AnalyzeTrackerUse(ApkAnalysis aa)
        {
            foreach (var tracker in Trackers)
            {
                var found = false;
                var tt = tracker.Split('/');
                var root = aa.Root;
                for (var i = 0; i < tt.Length; i++)
                {
                    var s = tt[i];
                    if (i == tt.Length - 1)
                    {
                        if (root.Directories.Any(d => d.Name == s))
                            found = true;
                        else
                        {
                            break;
                        }
                    }
                    var ro = root.Directories.FirstOrDefault(d => d.Name == s);
                    if (ro != null)
                    {
                        root = ro;
                    }
                }
                if (found)
                    aa.TrackersUsed.Add(tracker);
            }
        }
        private static void AnalyzeCryptoLibUse(ApkAnalysis aa)
        {
            foreach (var cLib in CriticalLibs)
            {
                var found = false;
                var tt = cLib.Split('/');
                var root = aa.Root;
                for (var i = 0; i < tt.Length; i++)
                {
                    var s = tt[i];
                    if (i == tt.Length - 1)
                    {
                        if (root.Directories.Any(d => d.Name == s))
                            found = true;
                        break;
                    }
                    var ro = root.Directories.FirstOrDefault(d => d.Name == s);
                    if (ro != null)
                    {
                        root = ro;
                    }
                }
                if (found)
                {
                    var saveCLib = cLib;
                    if (cLib == "okhttp3")
                    {
                        var dd =
                            root.Directories.FirstOrDefault(r => r.Name == cLib)?.Directories[0].Files.FirstOrDefault(
                                f => f.Name == "Version");
                        if (dd != null)
                        {
                            var m = _okHttpVersionRegex.Match(dd.Source);
                            if (m.Success)
                            {
                                saveCLib += m.Value.Replace("okhttp/", " ");
                            }
                        }
                    }
                    aa.CriticalLibsUsed.Add(saveCLib);
                }
            }
        }

        private static Regex _okHttpVersionRegex = new Regex("okhttp/[0-9]+.[0-9]+.[0-9]+", RegexOptions.Compiled);
        
        private static void UnzipFile(string apkPath, string file)
        {
            if (!File.Exists(apkPath))
                throw new FileNotFoundException("Not found", apkPath);
            var dp = Path.Combine(SavePath, Path.GetFileNameWithoutExtension(apkPath));
            Directory.CreateDirectory(dp);
            ZipFile zf = null;
            try
            {
                var fs = File.OpenRead(apkPath);
                zf = new ZipFile(fs);
                var zipEntry = zf.GetEntry(file);
                var buffer = new byte[4096];
                var zipStream = zf.GetInputStream(zipEntry);
                dp = Path.Combine(dp, file);
                using (var streamWriter = File.Create(dp))
                    StreamUtils.Copy(zipStream, streamWriter, buffer);
            }
            finally
            {
                if (zf != null)
                {
                    zf.IsStreamOwner = true;
                    zf.Close();
                }
            }
        }

        private static void AnalyzeManifest(string maniPath, ApkAnalysis aa)
        {
            var manifest = AndroidDecompress.DecompressXml(File.ReadAllBytes(maniPath));
            foreach (var permission in Permissions)
            {
                if (manifest.Contains(permission))
                {
                    aa.PermissionsUsed.Add(permission);
                }
            }
        }

        private static void Enjarify(string dexPath)
        {
            var filename = dexPath.Replace(".dex", ".jar");
            var cmd = $"-O -m enjarify.main \"{dexPath}\" -o \"{filename}\"";
            var pstart = new ProcessStartInfo("python")
            {
                WorkingDirectory = EnjarifyPath,
                Arguments = cmd,
                CreateNoWindow = true,
                WindowStyle = ProcessWindowStyle.Hidden
            };
            var p = Process.Start(pstart);
            p?.WaitForExit();
        }

        private static void Unzip(string jarPath)
        {
            if (!File.Exists(jarPath)) throw new FileNotFoundException("Not found", jarPath);
            var dp = Path.Combine(Path.GetDirectoryName(jarPath), "UNPACKED");
            Directory.CreateDirectory(dp);
            ZipFile zf = null;
            try
            {
                var fs = File.OpenRead(jarPath);
                zf = new ZipFile(fs) {UseZip64 = UseZip64.Dynamic};
                foreach (ZipEntry zipEntry in zf)
                {
                    if (!zipEntry.IsFile)
                    {
                        continue;           // Ignore directories
                    }
                    var entryFileName = zipEntry.Name;
                    // to remove the folder from the entry:- entryFileName = Path.GetFileName(entryFileName);
                    // Optionally match entrynames against a selection list here to skip as desired.
                    // The unpacked length is available in the zipEntry.Size property.
                    var buffer = new byte[4096];     // 4K is optimum
                    var zipStream = zf.GetInputStream(zipEntry);
                    // Manipulate the output filename here as desired.
                    var fullZipToPath = Path.Combine(dp, entryFileName);
                    var directoryName = Path.GetDirectoryName(fullZipToPath);
                    if (directoryName.Length > 0)
                        Directory.CreateDirectory(directoryName);
                    // Unzip file in buffered chunks. This is just as fast as unpacking to a buffer the full size
                    // of the file, but does not waste memory.
                    // The "using" will close the stream even if an exception occurs.
                    using (var streamWriter = File.Create(fullZipToPath))
                    {
                        StreamUtils.Copy(zipStream, streamWriter, buffer);
                    }
                }
            }
            finally
            {
                if (zf != null)
                {
                    zf.IsStreamOwner = true; // Makes close also shut the underlying stream
                    zf.Close(); // Ensure we release resources
                }
            }
        }

        #endregion
    }
}