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
                "SSL_2_0", "SSL_3_0", "TLS_1_0", "TLS_1_1", "TLS_1_2", "getRuntime()", "getRuntime", "exec" + '\u0001' };

            var apks = Directory.EnumerateFiles("C:\\Users\\Malte\\Desktop\\flervpnapps");
            int done = 0, total = apks.Count();
            var tot = 100.0 / total;
            var anas = new List<ApkAnalysis>();
                Parallel.ForEach(apks, new ParallelOptions {MaxDegreeOfParallelism = 3}, apk =>
            {
                try
                {
                    var a = ApkAnalysis.LoadApkEnjarify(apk, searchFor);
                    anas.Add(a);
                    a.GenerateReport();
                }
                catch (Exception exception)
                {
                    Console.WriteLine("ERROR LOADING " + apk);
                }
                finally
                {
                    done++;
                    Console.Clear();
                    Console.WriteLine($"{done}/{total} - {Math.Round(tot * done), 1}%");

                }
            });
            var list = new List<Tuple<string, int>>();
            foreach (var permission in ApkAnalysis.Permissions)
            {
                var c = anas.Count(a => a.PermissionsUsed.Contains(permission));
                if (c != 0)
                list.Add(new Tuple<string, int>(permission, c));
            }
            list = list.OrderByDescending(x => x.Item2).ToList();
            foreach (var l in list)
            {
                Console.WriteLine($"{l.Item1}: {l.Item2}/{total} - {Math.Round(tot * l.Item2),1}%");
            }
            Console.WriteLine("\nDone with operations");
            Console.ReadKey();
        }

    }
}
