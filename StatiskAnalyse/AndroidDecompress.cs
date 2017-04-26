using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text;

namespace StatiskAnalyse
{
    class AndroidXmlDecompress
    {
        public static List<string> ExtractPermissions(string manifestPath)
        {
            var cmd = $"dump permissions \"{manifestPath}\"";
            var pstart = new ProcessStartInfo(ApkAnalysis.AaptPah)
            {
                Arguments = cmd,
                CreateNoWindow = true,
                UseShellExecute = false,
                RedirectStandardOutput = true
            };
            var list = new List<string>();
            var p = Process.Start(pstart);
            bool titleGotten = false;
            while (!p.StandardOutput.EndOfStream)
            {
                //var s = p.StandardOutput.ReadLine();
                var s = p.StandardOutput.ReadLine().Replace("uses-permission: name=", "").Replace("permission: ", "").Trim('\'');
                if (titleGotten)
                    list.Add(s);
                else
                    titleGotten = true;
            }
            p.WaitForExit();
            list = list.Distinct().ToList();
            return list;
        }
    }
}