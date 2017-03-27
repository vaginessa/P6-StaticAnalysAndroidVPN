using System;
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
            var useLibraries = new[] { "java/lang/Thread", "java/lang/reflect/Method", "java/lang/ClassLoader", "java/lang/Runtime;->exec", "https://", "SSLv2", "SSLv3", "Runtime.getRuntime()", ".exec(" };
           
            var apks = Directory.EnumerateFiles("C:\\Users\\Malte\\Desktop\\VPNAPKSTOTEST");
            foreach (var apk in apks)
            {
                try
                {
                    ApkAnalysis.LoadApkEnjarify(apk, useLibraries).GenerateReport();
                }
                catch (Exception exception)
                {
                    Console.WriteLine("ERROR LOADING " + apk); 
                }
            }
            Console.WriteLine("\nDone with operations");
            Console.ReadKey();
        }

    }
}
