using System.Net;
using System.Text.RegularExpressions;

namespace StatiskAnalyse
{
    class GoogleSearch
    {
        public static string ApiKey { get; set; }
        public static string SearchEngineId { get; set; } = "017576662512468239146";

        private static readonly Regex ResCountRegex = new Regex("\"totalResults\": \"([0-9]+)\"", RegexOptions.Compiled);

        public GoogleSearch(string word)
        {
            Query = $"https://www.googleapis.com/customsearch/v1?key={ApiKey}&cx={SearchEngineId}:omuauf_lfve&q={WebUtility.UrlEncode(word)}";
            SearchParam = word;
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

        public string SearchParam { get; set; }
        public long Results { get; set; }
        public string Query { get; set; }
    }
}