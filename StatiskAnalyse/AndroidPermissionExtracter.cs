using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text.RegularExpressions;

namespace StatiskAnalyse
{
    internal class AndroidPermissionExtracter
    {
        private static readonly Regex PermRegex = new Regex("android.permission.([A-Z_]+)", RegexOptions.Compiled);
        public static List<string> ExtractPermissions(string manifestPath)
        {
            var cmd = $"dump xmltree \"{manifestPath}\" AndroidManifest.xml";
            var pstart = new ProcessStartInfo(ApkAnalysis.AaptPah)
            {
                Arguments = cmd,
                CreateNoWindow = true,
                UseShellExecute = false,
                RedirectStandardOutput = true
            };
            var list = new List<string>();
            var p = Process.Start(pstart);
            while (!p.StandardOutput.EndOfStream)
            {
                var s = p.StandardOutput.ReadLine();
                var m = PermRegex.Match(s);
                if (m.Success)
                    list.Add(m.Groups[1].Value);
            }
            p.WaitForExit();
            
            list = list.Distinct().ToList();
            return list;
        }
    }
}