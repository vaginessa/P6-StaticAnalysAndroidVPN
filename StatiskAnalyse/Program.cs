using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StatiskAnalyse
{
    class Program
    {
        static void Main(string[] args)
        {
            var searchFor = new[] { "java/lang/Thread", "java/lang/reflect/Method", "java/lang/ClassLoader", "java/lang/Runtime", "https://",
                "SSL_2_0", "SSL_3_0", "TLS_1_0", "TLS_1_1", "TLS_1_2", "exec"};


            var apks = Directory.EnumerateFiles("C:\\Users\\Malte\\Desktop\\flervpnapps", "*.apk");
            int done = 0, total = apks.Count();
            var tot = 100.0 / total;
            var starttime = DateTime.UtcNow;

            foreach (var apk in apks)
            {
                try
                {
                    ApkAnalysis.LoadApkBakSmali(apk, searchFor).GenerateJson();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("ERROR LOADING " + apk);
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
            Console.ReadKey();
        }

    }
}
