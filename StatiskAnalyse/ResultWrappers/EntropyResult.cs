namespace StatiskAnalyse
{
    class EntropyResult : FileResultWrapper
    {
        public EntropyResult(string word, double entropy, string file, int line, int index)
        {
            Word = word;
            Entropy = entropy;
            File = file;
            Line = line;
            Index = index;
        }

        public string Word { get; set; }
        public double Entropy { get; set; }
    }
}