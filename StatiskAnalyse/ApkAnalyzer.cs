using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;
using Newtonsoft.Json;

namespace StatiskAnalyse
{
    internal class ApkAnalysis
    {
        internal static readonly string[] Trackers;

        public static string BakSmaliPath = Path.GetFullPath("../../TOOLS/baksmali-2.2.0.jar");

        public static string AaptPah = Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData) + "\\Android\\sdk\\build-tools\\25.0.2\\aapt.exe";

        public static string SavePath = Path.GetFullPath("/STAN");

        static ApkAnalysis()
        {
            Trackers = File.ReadLines("../../trackers.txt").ToArray();
        }

        public static double LowestInterestingEntropy { get; set; }

        public static string[] CriticalLibs { get; set; } =
        {
            "org/spongycastle",
            "org/bouncycastle",
            "de/blinkt/openvpn",
            "okhttp3",
            "okhttp",
            "javax"
        };

        public static string[] LinuxCommandList { get; set; } =
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
            "head",
            "hostname",
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
            "touch",
            "top",
            "traceroute",
            "tr",
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
            "xargs"
        };

        public static int MaxSearchesPerApp { get; set; } = 25;

        public ApkStats Stats { get; set; }
        public List<string> CriticalLibsUsed { get; } = new List<string>();
        public List<string> TrackersUsed { get; } = new List<string>();
        public List<string> PermissionsUsed { get; set; } = new List<string>();
        public List<SearchResult.Use> LinuxCommands { get; set; } = new List<SearchResult.Use>();
        public List<GoogleSearch> GoogleSearchResults { get; set; } = new List<GoogleSearch>();
        public List<Tuple<string, double>> HighEntropyWords { get; set; } = new List<Tuple<string, double>>();
        public List<SearchResult> Results { get; private set; }
        public ClassFileDirectory Root { get; private set; }
        public string Name { get; private set; }

        public void GenerateJson()
        {
            File.WriteAllText(Path.Combine(SavePath, Name, "permissions.json"),
                JsonConvert.SerializeObject(PermissionsUsed, Formatting.Indented));

            File.WriteAllText(Path.Combine(SavePath, Name, "stats.json"),
                JsonConvert.SerializeObject(Stats, Formatting.Indented));

            if (CriticalLibsUsed.Count != 0)
                File.WriteAllText(Path.Combine(SavePath, Name, "libraries.json"),
                    JsonConvert.SerializeObject(CriticalLibsUsed, Formatting.Indented));

            if (TrackersUsed.Count != 0)
                File.WriteAllText(Path.Combine(SavePath, Name, "trackers.json"),
                    JsonConvert.SerializeObject(TrackersUsed, Formatting.Indented));

            if (GoogleSearchResults.Count != 0)
                File.WriteAllText(Path.Combine(SavePath, Name, "googlesearch.json"),
                    JsonConvert.SerializeObject(GoogleSearchResults, Formatting.Indented));

            if (HighEntropyWords.Count != 0)
                File.WriteAllText(Path.Combine(SavePath, Name, "highentropywords.json"),
                    JsonConvert.SerializeObject(HighEntropyWords, Formatting.Indented));

            if (LinuxCommands.Count != 0)
                File.WriteAllText(Path.Combine(SavePath, Name, "linuxCommands.json"),
                    JsonConvert.SerializeObject(LinuxCommands, Formatting.Indented));

            File.WriteAllText(Path.Combine(SavePath, Name, "search.json"),
                JsonConvert.SerializeObject(Results.Where(r => r.Pattern != "\".*\"" && r.Uses.Count != 0).OrderBy(r => r.Pattern),
                    Formatting.Indented));

            File.WriteAllText(Path.Combine(SavePath, Name, "stringsearch.json"),
                JsonConvert.SerializeObject(Results.Where(r => r.Pattern == "\".*\"" && r.Uses.Count != 0).OrderBy(r => r.Pattern),
                    Formatting.Indented));
            Clear();
        }

        private void Clear()
        {
            Root.Directories.Clear();
            Root.Files.Clear();
            CriticalLibsUsed.Clear();
            TrackersUsed.Clear();
            LinuxCommands.Clear();
            GoogleSearchResults.Clear();
            HighEntropyWords.Clear();
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
                .Where(x => LinuxCommandList.Any(y => x.SampleLine == y || x.SampleLine.StartsWith(y + " "))).ToList();

            var stringSearchResults = aa.Results.First(r => r.Pattern == "\".*\"")
                .Uses.Where(u => u.SampleLine.Length > 16 &&
                                 (u.SampleLine.IndexOf(" ", StringComparison.Ordinal) == -1 ||
                                  u.SampleLine.IndexOf(" ", StringComparison.Ordinal) > 15) &&
                                 !u.SampleLine.Contains("java") && !u.SampleLine.Contains("system") &&
                                 !u.SampleLine.Contains("cordova") && !u.SampleLine.Contains("Lorg") &&
                                 !u.SampleLine.Contains("android") && !u.SampleLine.Contains("facebook"))
                .Distinct(new SearchResult.UseComparer());

            aa.HighEntropyWords = stringSearchResults
                .Where(x => !x.SampleLine.Contains(" ") && !x.SampleLine.Contains("abcdefghijkmnopqrstxyz"))
                .Select(x => new Tuple<string, double>(x.SampleLine, GetEntropy(x.SampleLine)))
                .Where(x => x.Item2 > LowestInterestingEntropy)
                .OrderByDescending(x => x.Item2)
                .ToList();

            aa.GoogleSearchResults = MaxSearchesPerApp == -1
                ? aa.HighEntropyWords.Select(s => new GoogleSearch(s.Item1)).Where(g => g.Results != -1).ToList()
                : aa.HighEntropyWords.Take(MaxSearchesPerApp).Select(s => new GoogleSearch(s.Item1)).Where(g => g.Results != -1).ToList();

            aa.Stats = new ApkStats
            {
                IsObfuscated = IsObfuscatedHelper(aa.Root),
                TrackerCount = aa.TrackersUsed.Count,
                HighEntropyWordCount = aa.HighEntropyWords.Count,
                LinuxCommandCount = aa.LinuxCommands.Count
            };

            return aa;
        }


        // Shannon entropy
        private static double GetEntropy(string s)
        {
            var map = new Dictionary<char, int>();
            foreach (var c in s)
                if (!map.ContainsKey(c))
                    map.Add(c, 1);
                else
                    map[c] += 1;

            var result = 0.0;
            var len = s.Length;
            foreach (var item in map)
            {
                var frequency = (double) item.Value / len;
                result -= frequency * (Math.Log(frequency) / Math.Log(2));
            }

            return result;
        }

        private static ApkAnalysis InternalSmaliToolChain(string path)
        {
            Directory.CreateDirectory(SavePath);
            var aa = new ApkAnalysis {Name = Path.GetFileNameWithoutExtension(path)};
            var o = Path.Combine(SavePath, aa.Name, "out");
            
            aa.PermissionsUsed = AndroidPermissionExtracter.ExtractPermissions(path);
            if (!Directory.Exists(o))
                BakSmali(path, o);

            aa.Root = ClassFileDirectory.LoadFromDirectory(o, "smali");
            AnalyzeTrackerUse(aa);
            AnalyzeCryptoLibUse(aa);
            return aa;
        }
        
        private static bool IsObfuscatedHelper(ClassFileDirectory cfd)
        {
            return cfd.Files.Any(f => f.Name == "a") || cfd.Directories.Any(IsObfuscatedHelper);
        }

        private static void BakSmali(string inputDex, string output)
        {
            var cmd = $"-jar \"{BakSmaliPath}\" disassemble \"{inputDex}\" -o \"{output}\"";
            var pstart = new ProcessStartInfo("java")
            {
                WorkingDirectory = output,
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
                        if (root.Directories.Any(d => d.Name == s))
                            found = true;
                        else
                            break;
                    var ro = root.Directories.FirstOrDefault(d => d.Name == s);
                    if (ro != null)
                        root = ro;
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
                        root = ro;
                }
                if (!found) continue;
                var saveCLib = cLib;
                aa.CriticalLibsUsed.Add(saveCLib);
            }
        }

        #endregion

        internal class ApkStats
        {
            public bool IsObfuscated { get; set; }
            public int TrackerCount { get; set; }
            public int HighEntropyWordCount { get; set; }
            public int LinuxCommandCount { get; set; }
        }
    }
}