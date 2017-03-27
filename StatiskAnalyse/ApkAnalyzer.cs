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
        private static readonly List<string> Permissions;

        static ApkAnalysis()
        {
            Permissions = File.ReadLines("../../perms.txt").Select(l => l.Substring(31, l.Length - 34)).ToList();
        }

        private static readonly string EnjarifyPath = Path.GetFullPath("../../TOOLS/enjarify");
        private static readonly string TempPath = Path.GetFullPath("TEMP");
        private static readonly string ReportPath = Path.GetFullPath("REPORTS");
        private static readonly int TempPathLength = TempPath.Length + 1;

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

            var founds = Results.Where(r => r.Uses.Count != 0).OrderBy(r => r.Pattern);
            var notFounds = Results.Where(r => r.Uses.Count == 0).OrderBy(r => r.Pattern);

            foreach (var searchResult in founds)
            {
                rb.AppendLine($"\t{searchResult.Uses.Count} use(s) of '{searchResult.Pattern}':");
                foreach (var use in searchResult.Uses)
                    rb.AppendLine($"\t\t'{MakePathRelative(use.FoundIn.FilePath)}' :: {use.Index}");/*  =>  '{use.Sample}'");*/
                rb.AppendLine();
            }

            if (notFounds.Any()) rb.AppendLine("\nNo results found for:");
            foreach (var searchResult in notFounds)
                rb.AppendLine("\t" + searchResult.Pattern);
            File.WriteAllText(Path.Combine(ReportPath, Name + ".txt"), rb.ToString());
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
            Directory.CreateDirectory(TempPath);
            Directory.CreateDirectory(ReportPath);
            var aa = new ApkAnalysis
            {
                Name = Path.GetFileNameWithoutExtension(path)
            };
            var d = Path.Combine(TempPath, aa.Name);
            if (!Directory.Exists(d))
            {

                var am = UnzipFile(path, "AndroidManifest.xml");
                AnalyzeManifest(am, aa);
                var c = UnzipFile(path, "classes.dex");
                var jar = Enjarify(c);
                Unzip(jar);
            }
            aa.Root = ClassFileDirectory.LoadFromDirectory(d, "class");
            return aa;
        }

        private static string UnzipFile(string apkPath, string file)
        {
            if (!File.Exists(apkPath))
                throw new FileNotFoundException("Not found", apkPath);
            var dp = Path.Combine(TempPath, Path.GetFileNameWithoutExtension(apkPath));
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
            return dp;
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

        private static string Enjarify(string dexPath)
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
            return filename;
        }

        #endregion
        private static void Unzip(string jarPath)
        {
            if (!File.Exists(jarPath)) throw new FileNotFoundException("Not found", jarPath);
            var dp = Path.Combine(Path.GetDirectoryName(jarPath), "UNPACKED");
            Directory.CreateDirectory(dp);
            ZipFile zf = null;
            try
            {
                var fs = File.OpenRead(jarPath);
                zf = new ZipFile(fs);
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
    }
}