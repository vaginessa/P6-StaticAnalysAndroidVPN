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
using Newtonsoft.Json;

namespace StatiskAnalyse
{
    class ApkAnalysis
    {
        internal static readonly string[] Trackers;

        static ApkAnalysis()
        {
            Trackers = File.ReadLines("../../trackers.txt").ToArray();
        }
        
        public static string[] CriticalLibs { get; } = {
            "org/spongycastle",
            "org/bouncycastle",
            "de/blinkt/openvpn",
            "okhttp3",
            "okhttp",
            "javax"
        };

        private static readonly string BakSmaliPath = Path.GetFullPath("../../TOOLS/baksmali-2.2.0.jar");
        private static readonly string SavePath = Path.GetFullPath("/STAN");
        
        public List<string> CriticalLibsUsed { get; } = new List<string>();
        public List<string> TrackersUsed { get; } = new List<string>();
        public List<string> PermissionsUsed { get; } = new List<string>();
        public List<SearchResult> Results { get; private set; }
        public ClassFileDirectory Root { get; private set; }
        public string Name { get; private set; }
        
        public void GenerateJson()
        {
            File.WriteAllText(Path.Combine(SavePath, Name, "permissions.json"), JsonConvert.SerializeObject(PermissionsUsed, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "libraries.json"), JsonConvert.SerializeObject(CriticalLibsUsed, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "trackers.json"), JsonConvert.SerializeObject(TrackersUsed, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "search.json"), JsonConvert.SerializeObject(Results.Where(r => r.Uses.Count != 0).OrderBy(r => r.Pattern), Formatting.Indented));
            Clear();
        }

        private void Clear()
        {
            Root.Directories.Clear();
            Root.Files.Clear();
            CriticalLibsUsed.Clear();
            TrackersUsed.Clear();
            PermissionsUsed.Clear();
            Results.Clear();
        }
        
        #region Enjarify toolchain

        public static ApkAnalysis LoadApkBakSmali(string path, params string[] lookFor)
        {
            var aa = InternalSmaliToolChain(path);
            aa.Results = aa.Root.FindUses(lookFor);
            return aa;
        }

        public static ApkAnalysis LoadApkBakSmali(string path, params Regex[] lookFor)
        {
            var aa = InternalSmaliToolChain(path);
            aa.Results = aa.Root.FindUses(lookFor);
            return aa;
        }

        private static ApkAnalysis InternalSmaliToolChain(string path)
        {
            Directory.CreateDirectory(SavePath);
            //Directory.CreateDirectory(ReportPath);
            var aa = new ApkAnalysis { Name = Path.GetFileNameWithoutExtension(path) };
            var d = Path.Combine(SavePath, aa.Name);
            var am = Path.Combine(d, "AndroidManifest.xml");
            var c = Path.Combine(d, "classes.dex");
            var o = Path.Combine(d, "out");

            if (!File.Exists(am))
            {
                UnzipFile(path, "AndroidManifest.xml");
                var manifest = AndroidDecompress.DecompressXml(File.ReadAllBytes(am));
                File.WriteAllText(am, manifest);
            }
            if (!File.Exists(c))
                UnzipFile(path, "classes.dex");
            if (!Directory.Exists(o))
                BakSmali(c);

            AnalyzeManifest(am, aa);
            aa.Root = ClassFileDirectory.LoadFromDirectory(o, "smali");
            AnalyzeTrackerUse(aa);
            AnalyzeCryptoLibUse(aa);
            return aa;
        }

        private static void BakSmali(string inputDex)
        {
            var cmd = $"-jar \"{BakSmaliPath}\" disassemble \"{inputDex}\"";
            var pstart = new ProcessStartInfo("java")
            { 
                WorkingDirectory = Path.GetDirectoryName(inputDex),
                Arguments = cmd,
                CreateNoWindow = true,
                WindowStyle = ProcessWindowStyle.Hidden
            };
            var p = Process.Start(pstart);
            p?.WaitForExit();
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
                            var m = OkHttpVersionRegex.Match(dd.Source);
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

        private static readonly Regex OkHttpVersionRegex = new Regex("okhttp/[0-9]+.[0-9]+.[0-9]+", RegexOptions.Compiled);
        private static readonly Regex Permissions = new Regex("<uses-permission name=\"([a-zA-Z0-9.,_]+)\">", RegexOptions.Compiled);
        private static readonly Regex IntentPermission = new Regex("permission=\"([a-zA-Z0-9.,_]+)\"", RegexOptions.Compiled);
        
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
            var manifest = File.ReadAllText(maniPath);
            var results = Permissions.Matches(manifest);
            var iResults = IntentPermission.Matches(manifest);
            foreach (Match res in results)
            {
                aa.PermissionsUsed.Add(res.Groups[1].Value);
            }
            foreach (Match res in iResults)
            {
                aa.PermissionsUsed.Add(res.Groups[1].Value);
            }
        }

        #endregion
    }
}