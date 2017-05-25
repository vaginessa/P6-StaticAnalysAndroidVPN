using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;
using Newtonsoft.Json;

namespace StatiskAnalyse
{
    //public abstract class SearchHandler<TSearchResult> where TSearchResult : FileResultWrapper
    //{
    //    private Func<List<TSearchResult>, List<TSearchResult>> _filter;

    //    protected SearchHandler(Regex regex, Func<List<TSearchResult>, List<TSearchResult>> filter)
    //    {
    //        Regex = regex;
    //        _filter = filter;
    //    }
    //    public Regex Regex { get; }
    //    public List<TSearchResult> Results { get; } = new List<TSearchResult>();

    //    protected static void SaveResults(string outputname, string apkName, object resultContainer)
    //    {

    //        File.WriteAllText(Path.Combine(ApkAnalysis.SavePath, apkName, outputname + ".json"),
    //            JsonConvert.SerializeObject(resultContainer, Formatting.Indented));
    //    }
    //}
    

    internal class Program
    {
        private static void Main(string[] args)
        {
            GoogleSearch.ApiKey = "AIzaSyDrqFQq2jnMtCtiNPiI5D6KDCWJT_Fyrt4";
            ApkAnalysis.LowestInterestingEntropy = 4.75;
            ApkAnalysis.MaxSearchesPerApp = 1;
            ApkAnalysis.SavePath = "R:\\test";
            var ApkFolder = "C:\\Users\\Malte\\Desktop\\apks";

            var unwantedLinuxCmds = new[]
            {
                "chown",
                "chmod",
                "mkdir",
                "rm",
                "mv",
                "cat",
                "ps",
                "su",
                "sudo",
                "kill",
                "logcat",
                "grep",
                "ls"
            };
            ApkAnalysis.LinuxCommandList = unwantedLinuxCmds.ToArray();
            //string ApkFolder = "/folder/with/apk/files";

            if (args.Length > 0 && Directory.Exists(args[0]))
                ApkFolder = args[0];

            var searchFor = new[]
            {
                new Regex("\".+\"", RegexOptions.Compiled),
                new Regex("[0-9]{1,3}(\\.[0-9]{1,3}){3}", RegexOptions.Compiled),
                new Regex("https?:\\/\\/([\\da-z\\.-]+)\\.([a-z\\.]{2,6})([\\/\\w \\.-]*)*\\/?", RegexOptions.Compiled),
                new Regex("Ljava/security/SecureClassLoader", RegexOptions.Compiled),
                new Regex("AccountManager;->get", RegexOptions.Compiled),
                new Regex("Ljava/net/URLClassLoader", RegexOptions.Compiled),
                new Regex("Ljava/lang/Runtime;->exec", RegexOptions.Compiled)
            };

            PerformAnalysis(ApkFolder, searchFor);
            Console.ReadKey();
        }

        private static void PerformAnalysis(string apkFolder, Regex[] regexes)
        {
            var apks = Directory.EnumerateFiles(apkFolder, "*.apk").Where(x => x.Contains("Hotspot Shield Free") || x.Contains("Amaze") || x.Contains("Tunnel") || x.Contains("Ultrasurf"));
            int done = 0, total = apks.Count();
            var tot = 100.0 / total;
            var starttime = DateTime.UtcNow;

            Console.WriteLine($"0/{total} - 0%");
            foreach (var apk in apks)
                try
                {
                    ApkAnalysis.LoadApkBakSmali(apk, regexes).GenerateJson();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error loading APK: " + apk);
                }
                finally
                {
                    done++;
                    var timeUsed = DateTime.UtcNow.Subtract(starttime).TotalSeconds;
                    var tpa = timeUsed / done;
                    var tl = ((total - done) * tpa)/60;
                    Console.Clear();
                    Console.WriteLine($"{done}/{total} - {Math.Round(tot * done),1}%");
                    Console.WriteLine("Estimated time left: " + Math.Round(tl) + " minutes");
                }
            Console.Clear();
            Console.WriteLine("\nDone with operations");
            var elapsed = DateTime.UtcNow.Subtract(starttime);
            Console.WriteLine($"Elapsed: {elapsed.Minutes} minutes and {elapsed.Seconds} seconds");
        }
    }
}