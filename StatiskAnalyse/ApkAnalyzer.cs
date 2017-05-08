using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
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

        public static string[] LinuxCommandList { get; } =
        {
            "adduser",
            "arch",
            "awk",
            "bc",
            "cal",
            "cat",
            "chdir",
            "chgrp",
            "chkconfig",
            "chmod",
            "chown",
            "chroot",
            "cksum",
            "clear",
            "cmp",
            "comm",
            "cp",
            "cron",
            "crontab",
            "csplit",
            "cut",
            "date",
            "dc",
            "dd",
            "df",
            "diff",
            "diff3",
            "dir",
            "dircolors",
            "dirname",
            "du",
            "echo",
            "ed",
            "egrep",
            "eject",
            "env",
            "expand",
            "expr",
            "factor",
            "false",
            "fdformat",
            "fdisk",
            "fgrep",
            "find",
            "fmt",
            "fold",
            "format",
            "free",
            "fsck",
            "gawk",
            "grep",
            "groups",
            "gzip",
            "head",
            "hostname",
            "id",
            "info",
            "install",
            "join",
            "kill",
            "less",
            "ln",
            "locate",
            "logname",
            "lpc",
            "lpr",
            "lprm",
            "ls",
            "man",
            "mkdir",
            "mkfifo",
            "mknod",
            "more",
            "mount",
            "mv",
            "nice",
            "nl",
            "nohup",
            "passwd",
            "paste",
            "pathchk",
            "pr",
            "printcap",
            "printenv",
            "printf",
            "ps",
            "pwd",
            "quota",
            "quotacheck",
            "quotactl",
            "ram",
            "rcp",
            "rm",
            "rmdir",
            "rpm",
            "rsync",
            "screen",
            "sdiff",
            "sed",
            "select",
            "seq",
            "shutdown",
            "sleep",
            "sort",
            "split",
            "su",
            "sum",
            "symlink",
            "sync",
            "tac",
            "tail",
            "tar",
            "tee",
            "test",
            "time",
            "touch",
            "top",
            "traceroute",
            "tr",
            "true",
            "tsort",
            "tty",
            "umount",
            "uname",
            "unexpand",
            "uniq",
            "units",
            "unshar",
            "useradd",
            "usermod",
            "users",
            "uuencode",
            "uudecode",
            "vdir",
            "watch",
            "wc",
            "whereis",
            "which",
            "who",
            "whoami",
            "xargs",
            "yes"
        };

        public static readonly string BakSmaliPath = Path.GetFullPath("../../TOOLS/baksmali-2.2.0.jar");
        public static readonly string AaptPah = Path.GetFullPath("C:\\Users\\Malte\\AppData\\Local\\Android\\sdk\\build-tools\\25.0.2\\aapt.exe");
        public static readonly string SavePath = Path.GetFullPath("/STAN");
        
        public List<string> CriticalLibsUsed { get; } = new List<string>();
        public List<string> TrackersUsed { get; } = new List<string>();
        public List<string> PermissionsUsed { get; set; } = new List<string>();
        public List<SearchResult.Use> LinuxCommands { get; set; } = new List<SearchResult.Use>();
        public List<GoogleSearch> GoogleSearchResults { get; set; } = new List<GoogleSearch>();
        public List<SearchResult> Results { get; private set; }
        public ClassFileDirectory Root { get; private set; }
        public string Name { get; private set; }
        
        public void  GenerateJson(params string[] dangClass)
        {
            File.WriteAllText(Path.Combine(SavePath, Name, "permissions.json"), JsonConvert.SerializeObject(PermissionsUsed, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "libraries.json"), JsonConvert.SerializeObject(CriticalLibsUsed, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "trackers.json"), JsonConvert.SerializeObject(TrackersUsed, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "googlesearch.json"), JsonConvert.SerializeObject(GoogleSearchResults, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "linuxCommands.json"), JsonConvert.SerializeObject(LinuxCommands, Formatting.Indented));
            File.WriteAllText(Path.Combine(SavePath, Name, "javaClasses.json"), JsonConvert.SerializeObject(dangClass.Where(x => Results.Any(y => y.Pattern == x)), Formatting.Indented));
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
        
        #region BakSmali toolchain

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
            aa.LinuxCommands = aa.Results.First(r => r.Pattern == "\".*\"").Uses
                .Where(x => LinuxCommandList.Any(x.SampleLine.Contains)).ToList();

            var stringSearchResults = aa.Results.First(r => r.Pattern == "\".*\"")
                .Uses.Where(u => u.SampleLine.Length > 16 && (u.SampleLine.IndexOf(" ", StringComparison.Ordinal) == -1 ||
                                                              u.SampleLine.IndexOf(" ", StringComparison.Ordinal) > 15) &&
                                 !u.SampleLine.Contains("java") && !u.SampleLine.Contains("system") &&
                                 !u.SampleLine.Contains("cordova") && !u.SampleLine.Contains("Lorg") &&
                                 !u.SampleLine.Contains("android"))
                .Distinct(new SearchResult.UseComparer());

            var entropies = stringSearchResults
                .Select(x => new Tuple<string, double>(x.SampleLine, GetEntropy(x.SampleLine))).Where(x => x.Item2 > 3)
                .OrderByDescending(x => x.Item2);

            var gss = MaxSearchesPerApp == -1
                ? entropies.Select(s => new GoogleSearch(s.Item1)).ToList()
                : entropies.Take(MaxSearchesPerApp).Select(s => new GoogleSearch(s.Item1)).ToList();

            aa.GoogleSearchResults = gss;
            return aa;
        }


        public static int MaxSearchesPerApp { get; set; } = 25;

        // Shannon entropy
        private static double GetEntropy(string s)
        {
            var map = new Dictionary<char, int>();
            foreach (var c in s)
            {
                if (!map.ContainsKey(c))
                    map.Add(c, 1);
                else
                    map[c] += 1;
            }

            double result = 0.0;
            int len = s.Length;
            foreach (var item in map)
            {
                var frequency = (double)item.Value / len;
                result -= frequency * (Math.Log(frequency) / Math.Log(2));
            }

            return result;
        }

        private static ApkAnalysis InternalSmaliToolChain(string path)
        {
            Directory.CreateDirectory(SavePath);
            var aa = new ApkAnalysis { Name = Path.GetFileNameWithoutExtension(path) };
            var d = Path.Combine(SavePath, aa.Name);
            var o = Path.Combine(d, "out");


            aa.PermissionsUsed = AndroidPermissionExtracter.ExtractPermissions(path);
            if (!Directory.Exists(o))
                BakSmali(path);
            
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
                if (!found) continue;
                var saveCLib = cLib;
                aa.CriticalLibsUsed.Add(saveCLib);
            }
        }
        #endregion
    }
}