using System.Net;
using System.Text.RegularExpressions;

namespace StatiskAnalyse
{
    class GoogleSearch
    {
        private static readonly Regex ResCountRegex = new Regex("About ([0-9,]+) results", RegexOptions.Compiled);

        public GoogleSearch(string word)
        {
            Query = "http://www.google.dk/search?q=" + WebUtility.UrlEncode(word) + "&hl=en";
            using (var wc = new WebClient())
            {
                var html = wc.DownloadString(Query);
                var m = ResCountRegex.Match(html);
                if (m.Success)
                {
                    Results = long.Parse(m.Groups[1].Value.Replace(",", ""));
                }
            }
        }

        public long Results { get; set; }
        public string Query { get; set; }
    }
}