using System;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace StatiskAnalyse
{
    class Program
    {
        static void Main(string[] args)
        {
            GoogleSearch.ApiKey = "AIzaSyDrqFQq2jnMtCtiNPiI5D6KDCWJT_Fyrt4";
            string ApkFolder = "/folder/with/apk/files";


            if (args.Length > 0 && Directory.Exists(args[0]))
                ApkFolder = args[0];

            var searchFor = new[] 
            {
                new Regex("\".*\"", RegexOptions.Compiled),
                new Regex("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}", RegexOptions.Compiled),
                new Regex("Ljava/security/SecureClassLoader", RegexOptions.Compiled),
                new Regex("Ljava/net/URLClassLoader", RegexOptions.Compiled),
                new Regex("Ljava/lang/Runtime;->exec", RegexOptions.Compiled)
            };

            PerformAnalysis(ApkFolder, searchFor);
            Console.ReadKey();
        }

        private static void PerformAnalysis(string apkFolder, Regex[] regexes)
        {
            var apks = Directory.EnumerateFiles(apkFolder, "*.apk");
            int done = 0, total = apks.Count();
            var tot = 100.0 / total;
            var starttime = DateTime.UtcNow;

            foreach (var apk in apks)
            {
                try
                {
                    ApkAnalysis.LoadApkBakSmali(apk, regexes).GenerateJson();
                }
                catch (Exception)
                {
                    Console.WriteLine("Error loading APK: " + apk);
                }
                finally
                {
                    done++;
                    var timeUsed = DateTime.UtcNow.Subtract(starttime).TotalMinutes;
                    var tpa = timeUsed / done;
                    var tl = (total - done) * tpa;
                    Console.Clear();
                    Console.WriteLine($"{done}/{total} - {Math.Round(tot * done),1}%");
                    Console.WriteLine("Estimated time left " + Math.Round(tl) + " minutes");
                }
            }
            Console.WriteLine("\nDone with operations");
        }

    }
}
