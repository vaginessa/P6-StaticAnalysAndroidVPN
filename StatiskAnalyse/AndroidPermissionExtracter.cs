using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;

namespace StatiskAnalyse
{
    class AndroidPermissionExtracter
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