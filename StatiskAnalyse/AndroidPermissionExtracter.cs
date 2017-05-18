using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Linq;
using System.Text.RegularExpressions;

namespace StatiskAnalyse
{
    internal class AndroidPermissionExtracter
    {
        private static readonly Regex PermRegex = new Regex("android.permission.([A-Z_]+)", RegexOptions.Compiled);

        public static List<string> ExtractPermissions(string apkPath, string outPath)
        {
            var cmd = $"dump xmltree \"{apkPath}\" AndroidManifest.xml";
            var pstart = new ProcessStartInfo(ApkAnalysis.AaptPah)
            {
                WorkingDirectory = outPath,
                Arguments = cmd,
                CreateNoWindow = true,
                UseShellExecute = false,
                RedirectStandardOutput = true
            };
            var p = Process.Start(pstart);
            var text = p.StandardOutput.ReadToEnd();
            var matches = PermRegex.Matches(text);
            var list = (from Match match in matches select match.Groups[1].Value).ToList();
            p.WaitForExit();
            File.WriteAllText(Path.Combine(outPath, "AndroidManifest.xml"), text);
            list = list.Distinct().ToList();
            return list;
        }
    }
}