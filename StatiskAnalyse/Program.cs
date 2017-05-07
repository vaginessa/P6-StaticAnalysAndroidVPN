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
            var searchFor = new[] 
            {
                new Tuple<Regex, Action<IEnumerable<SearchResult>>>(new Regex("\".*\"", RegexOptions.Compiled), null),
                new Tuple<Regex, Action<IEnumerable<SearchResult>>>(new Regex("[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}.[0-9]{1,3}", RegexOptions.Compiled),
                    results =>
                    {
                        
                    }),
                new Tuple<Regex, Action<IEnumerable<SearchResult>>>(new Regex("Ljava/security/SecureClassLoader", RegexOptions.Compiled), null), 
                new Tuple<Regex, Action<IEnumerable<SearchResult>>>(new Regex("Ljava/net/URLClassLoader", RegexOptions.Compiled), null), 
                new Tuple<Regex, Action<IEnumerable<SearchResult>>>(new Regex("Ljava/lang/Runtime;->exec", RegexOptions.Compiled), null), 

            };



            var potDangJavaClasses = new[] { "Ljava/security/SecureClassLoader", "Ljava/net/URLClassLoader", "Ljava/lang/Runtime;->exec" };

            searchFor = searchFor.Concat(potDangJavaClasses.Select(t => new Regex(t, RegexOptions.Compiled))).ToArray();

            var apks = Directory.EnumerateFiles("C:\\Users\\Malte\\Desktop\\flervpnapps", "*.apk")/*.Where(x => x.Contains("Avast"))*/;
            int done = 0, total = apks.Count();
            var tot = 100.0 / total;
            var starttime = DateTime.UtcNow;

            foreach (var apk in apks)
            {
                try
                {
                    ApkAnalysis.LoadApkBakSmali(apk, searchFor).GenerateJson(potDangJavaClasses);
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
