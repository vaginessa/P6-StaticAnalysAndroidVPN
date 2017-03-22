using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using ICSharpCode.SharpZipLib.Core;
using ICSharpCode.SharpZipLib.Zip;

namespace StatiskAnalyse
{
    class ApkAnalysis
    {
        private const string EnjarifyPath = "../../TOOLS/enjarify";
        private const string ProcyonPath = "../../TOOLS/procyon-decompiler.jar";
        private const string JadxPath = "../../TOOLS/jadx/bin/jadx.bat";
        private const string TempPath = "TEMP";
        private const string ReportPath = "REPORTS";

        private static readonly int TempPathLength = TempPath.Length + 1;

        public List<SearchResult> Results { get; private set; }
        public ClassFileDirectory Root { get; private set; }
        public string Name { get; private set; }

        public void GenerateReport()
        {
            var rb = new StringBuilder();
            rb.AppendLine("Analysis of '" + Name + "'\n");

            var founds = Results.Where(r => r.Uses.Count != 0).OrderBy(r => r.Pattern);
            var notFounds = Results.Where(r => r.Uses.Count == 0).OrderBy(r => r.Pattern); ;

            foreach (var searchResult in founds)
            {
                rb.AppendLine($"\t{searchResult.Uses.Count} use(s) of '{searchResult.Pattern}':");
                foreach (var use in searchResult.Uses)
                    rb.AppendLine($"\t\t{MakePathRelative(use.FoundIn.FilePath)} at index {use.Index}   ( {use.Sample} )");
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
        #region Jadx toolchain

        public static ApkAnalysis LoadApkJadx(string apkPath, params string[] lookFor)
        {
            Directory.CreateDirectory(TempPath);
            Directory.CreateDirectory(ReportPath);
            var sw = new Stopwatch();
            sw.Start();
            var aa = new ApkAnalysis
            {
                Name = Path.GetFileNameWithoutExtension(apkPath)
            };
            var d = Path.Combine(TempPath, Path.GetFileNameWithoutExtension(apkPath));
            if (!Directory.Exists(d))
            {
                var dex = UnzipClassesDex(apkPath);
                DecompileJadx(dex, d);
            }
            aa.Root = ClassFileDirectory.LoadFromDirectory(d, "java");
            aa.Results = aa.Root.FindUses(lookFor);
            sw.Stop();
            Console.WriteLine("LoadApkJadx took " + sw.ElapsedMilliseconds + " ms.");
            return aa;
        }
        public static ApkAnalysis LoadApkJadx(string apkPath, params Regex[] lookFor)
        {
            var aa = new ApkAnalysis
            {
                Name = Path.GetFileNameWithoutExtension(apkPath)
            };
            var d = Path.Combine(TempPath, Path.GetFileNameWithoutExtension(apkPath));
            if (!Directory.Exists(d))
            {
                var dex = UnzipClassesDex(apkPath);
                DecompileJadx(dex, d);
            }
            aa.Root = ClassFileDirectory.LoadFromDirectory(d, "java");
            aa.Results = aa.Root.FindUses(lookFor);
            return aa;
        }


        private static void DecompileJadx(string classesDex, string outPath)
        {
            if (!File.Exists(classesDex))
                throw new FileNotFoundException("Not found", classesDex);
            var cmd = $"\"{classesDex}\" -d \"{outPath}\"";
            var pstart = new ProcessStartInfo(Path.GetFullPath(JadxPath))
            {
                Arguments = cmd,
                CreateNoWindow = true,
                WindowStyle = ProcessWindowStyle.Hidden
            };
            var p = Process.Start(pstart);
            p?.WaitForExit();
            File.Delete(classesDex);
        }

        private static string UnzipClassesDex(string apkPath)
        {
            if (!File.Exists(apkPath))
                throw new FileNotFoundException("Not found", apkPath);
            var dp = Path.GetFileNameWithoutExtension(apkPath);
            
            ZipFile zf = null;
            try
            {
                var fs = File.OpenRead(apkPath);
                zf = new ZipFile(fs);
                var zipEntry = zf.GetEntry("classes.dex");
                var buffer = new byte[4096];
                var zipStream = zf.GetInputStream(zipEntry);
                dp = Path.Combine(Path.GetFullPath(TempPath), dp + "-classes.dex");
                using (var streamWriter = File.Create(dp))
                    StreamUtils.Copy(zipStream, streamWriter, buffer);
            }
            finally
            {
                if (zf != null)
                {
                    zf.IsStreamOwner = true; // Makes close also shut the underlying stream
                    zf.Close(); // Ensure we release resources
                }
            }
            return dp;
        }

        #endregion

        #region Enjarify -> Procyon toolchain

        public static ApkAnalysis LoadApkEnjarify(string path, params string[] lookFor)
        {
            Directory.CreateDirectory(TempPath);
            Directory.CreateDirectory(ReportPath);
            var sw = new Stopwatch();
            sw.Start();
            var aa = new ApkAnalysis();
            aa.Name = Path.GetFileNameWithoutExtension(path);
            var d = Path.Combine(TempPath, Path.GetFileNameWithoutExtension(path));
            if (!Directory.Exists(d))
            {
                var jar = Enjarify(path);
                d = Unzip(jar);
            }
            aa.Root = ClassFileDirectory.LoadFromDirectory(d, "class");
            aa.Results = aa.Root.FindUses(lookFor);
            sw.Stop();
            Console.WriteLine("LoadApkEnjarify took " + sw.ElapsedMilliseconds + " ms.");
            return aa;
        }

        public static ApkAnalysis LoadApkEnjarify(string path, params Regex[] lookFor)
        {
            var aa = new ApkAnalysis();
            aa.Name = Path.GetFileNameWithoutExtension(path);
            var d = Path.Combine(TempPath, Path.GetFileNameWithoutExtension(path));
            if (!Directory.Exists(d))
            {
                var jar = Enjarify(path);
                d = Unzip(jar);
            }
            aa.Root = ClassFileDirectory.LoadFromDirectory(d, "class");
            aa.Results = aa.Root.FindUses(lookFor);
            return aa;
        }

        //public static ApkAnalysis LoadApkEnjarifyProcyon(string path, params string[] lookFor)
        //{
        //    var aa = new ApkAnalysis();
        //    aa.Name = Path.GetFileNameWithoutExtension(path);
        //    var d = Path.Combine(TempPath, Path.GetFileNameWithoutExtension(path));
        //    if (!Directory.Exists(d))
        //    {
        //        var jar = Enjarify(path);
        //        DecompileProcyon(jar);
        //    }
        //    aa.Root = ClassFileDirectory.LoadFromDirectory(d, "java");
        //    aa.Results = aa.Root.FindUses(lookFor);
        //    return aa;
        //}

        private static string Enjarify(string apkPath)
        {
            var filename = Path.Combine(Path.GetFullPath(TempPath), Path.GetFileNameWithoutExtension(apkPath)) + ".jar";
            var cmd = $"-O -m enjarify.main \"{apkPath}\" -o \"{filename}\"";
            var pstart = new ProcessStartInfo("python")
            {
                WorkingDirectory = Path.GetFullPath(EnjarifyPath),
                Arguments = cmd,
                CreateNoWindow = true,
                WindowStyle = ProcessWindowStyle.Hidden
            };
            var p = Process.Start(pstart);
            p?.WaitForExit();
            return filename;
        }

        //private static void DecompileProcyon(string jarPath)
        //{
        //    var d = Path.Combine(TempPath, Path.GetFileNameWithoutExtension(jarPath));
        //    Console.WriteLine("Decompiling..");
        //    var cmd = $"-jar \"{Path.GetFullPath(ProcyonPath)}\" -jar \"{jarPath}\" -o \"{d}\"";
        //    var pstart = new ProcessStartInfo("java")
        //    {
        //        Arguments = cmd,
        //        CreateNoWindow = true,
        //        WindowStyle = ProcessWindowStyle.Hidden
        //    };
        //    var p = Process.Start(pstart);
        //    p?.WaitForExit();
        //    Console.WriteLine("Done decompiling");
        //}

        private static string Unzip(string jarPath)
        {
            if (!File.Exists(jarPath)) throw new FileNotFoundException("Not found", jarPath);
            var dp = jarPath.Replace(".jar", "");
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
                File.Delete(jarPath);
            }
            return dp;
        }

        #endregion
    }
}