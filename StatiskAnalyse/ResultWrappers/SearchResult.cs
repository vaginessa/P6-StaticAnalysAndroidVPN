using System;
using System.Collections.Generic;

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

        
    }

}