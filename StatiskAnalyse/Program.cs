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
            var anas = new List<ApkAnalysis>();
                Parallel.ForEach(apks, new ParallelOptions {MaxDegreeOfParallelism = 4}, apk =>
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
            });
            var tot = anas.Count;
            foreach (var permission in ApkAnalysis.Permissions)
            {
                var c = anas.Count(a => a.PermissionsUsed.Contains(permission));
                Console.WriteLine($"{permission}: {c}/{tot}  {tot/100*c}");
            }

            Console.WriteLine("\nDone with operations");
            Console.ReadKey();
        }

    }
}
