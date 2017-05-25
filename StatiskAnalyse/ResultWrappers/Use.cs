using Newtonsoft.Json;
using System;
using System.Collections.Generic;
namespace StatiskAnalyse
{
    public class Use : FileResultWrapper
    {
        public Use(ClassFile cf, int line, int col, string ll)
        {
            FoundIn = cf;
            Line = line;
            Index = col;
            SampleLine = ll.Trim('"');
            File = cf.FilePath;
        }

        [JsonIgnore]
        public ClassFile FoundIn { get; }

        public string SampleLine { get; set; }

        public override string ToString()
        {
            return SampleLine;
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