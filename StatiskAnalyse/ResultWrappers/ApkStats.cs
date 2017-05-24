namespace StatiskAnalyse
{
    internal class ApkStats
    {
        public bool IsObfuscated { get; set; }
        public int TrackerCount { get; set; }
        public int HighEntropyWordCount { get; set; }
        public int LinuxCommandCount { get; set; }
        public object HardcodedIPs { get; internal set; }
    }
}