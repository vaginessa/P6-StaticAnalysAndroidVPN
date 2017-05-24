namespace StatiskAnalyse
{
    class IpSearchResult : FileResultWrapper
    {
        public IpSearchResult(string ip, string country, string file, int line, int index)
        {
            Ip = ip;
            Country = country;
            File = file;
            Line = line;
            Index = index;
        }

        public string Ip { get; set; }
        public string Country { get; set; }
    }
}