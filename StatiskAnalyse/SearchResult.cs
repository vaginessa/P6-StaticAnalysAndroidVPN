using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace StatiskAnalyse
{
    public class SearchResult
    {
        public string Pattern { get; set; }
        public int UseCount => Uses.Count;
        public List<Use> Uses { get; } = new List<Use>();

        public override string ToString()
        {
            return $"{Pattern} : {Uses.Count} uses";
        }

        public class Use
        {
            public Use(ClassFile cf, int line, int col, string ll)
            {
                FoundIn = cf;
                Line = line;
                Index = col;
                SampleLine = ll.Trim('"');
            }

            [JsonIgnore]
            public ClassFile FoundIn { get; }

            public string File => FoundIn.FilePath;
            public int Index { get; }
            public int Line { get; set; }

            public string SampleLine { get; set; }

            public override string ToString()
            {
                return SampleLine;
            }
        }

        public class UseComparer : IEqualityComparer<Use>
        {
            public bool Equals(Use x, Use y)
            {
                return string.Equals(x.SampleLine, y.SampleLine, StringComparison.CurrentCultureIgnoreCase);
            }

            public int GetHashCode(Use obj)
            {
                return obj.SampleLine.ToLower().GetHashCode();
            }
        }
    }
}