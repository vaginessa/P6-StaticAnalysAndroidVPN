using System.Collections.Generic;

namespace StatiskAnalyse
{
    public class SearchResult
    {
        public string Pattern { get; set; }
        public List<Use> Uses { get; } = new List<Use>();

        public override string ToString()
        {
            return $"{Pattern} : {Uses.Count} uses";
        }

        public class Use
        {
            public ClassFile FoundIn { get; }
            public int Index { get; }
            public string Sample { get; }

            public Use(ClassFile cf, int index, string sample)
            {
                FoundIn = cf;
                Index = index;
                Sample = sample;
            }
        }
    }

}