using System.Collections.Generic;
using System.IO;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StatiskAnalyse
{
    public class ClassFileDirectory
    {
        public string Name { get; private set; }
        public string DirPath { get; set; }
        public List<ClassFileDirectory> Directories { get; } = new List<ClassFileDirectory>();
        public List<ClassFile> Files { get; } = new List<ClassFile>();

        public static ClassFileDirectory LoadFromDirectory(string rootDir, string ext)
        {
            var retVal = new ClassFileDirectory
            {
                Name = new DirectoryInfo(rootDir).Name,
                DirPath = rootDir
            };
            var dirs = Directory.EnumerateDirectories(rootDir);
            foreach (var d in dirs)
                retVal.Directories.Add(LoadFromDirectory(d, ext));
            var files = Directory.EnumerateFiles(rootDir, "*." + ext);
            foreach (var f in files)
                retVal.Files.Add(ClassFile.FromPath(f));


            return retVal;
        }

        public List<SearchResult> FindUses(params string[] patterns)
        {
            var l = new object();
            var retVal = new List<SearchResult>();
            Parallel.ForEach(patterns, pattern =>
            {
                var e = new SearchResult
                {
                    Pattern = pattern
                };
                e.Uses.AddRange(FindUsesInDir(this, pattern));
                lock (l)
                {
                    retVal.Add(e);
                }
            });
            return retVal;
        }

        public List<SearchResult> FindUses(params Regex[] patterns)
        {
            var l = new object();
            var retVal = new List<SearchResult>();
            Parallel.ForEach(patterns, pattern =>
            {
                var e = new SearchResult
                {
                    Pattern = pattern.ToString()
                };
                e.Uses.AddRange(FindUsesInDir(this, pattern));
                lock (l)
                {
                    retVal.Add(e);
                }
            });
            return retVal;
        }

        private static IEnumerable<SearchResult.Use> FindUsesInDir(ClassFileDirectory dir, string pattern)
        {
            var retVal = new List<SearchResult.Use>();
            foreach (var classFileDirectory in dir.Directories)
                retVal.AddRange(FindUsesInDir(classFileDirectory, pattern));
            foreach (var classFile in dir.Files)
                retVal.AddRange(FindOccurencesInString(classFile, pattern));
            return retVal;
        }

        private static IEnumerable<SearchResult.Use> FindOccurencesInString(ClassFile cf, string searchFor)
        {
            for (var li = 0; li < cf.Source.Length; li++)
            {
                var l = cf.Source[li];
                var i = l.IndexOf(searchFor);
                while (i != -1)
                {
                    yield return new SearchResult.Use(cf, li + 1, i + 1, l);
                    i = l.IndexOf(searchFor, i);
                }
            }
        }


        private static IEnumerable<SearchResult.Use> FindUsesInDir(ClassFileDirectory dir, Regex pattern)
        {
            var retVal = new List<SearchResult.Use>();
            foreach (var classFileDirectory in dir.Directories)
                retVal.AddRange(FindUsesInDir(classFileDirectory, pattern));
            foreach (var classFile in dir.Files)
                retVal.AddRange(FindOccurencesInString(classFile, pattern));
            return retVal;
        }

        private static IEnumerable<SearchResult.Use> FindOccurencesInString(ClassFile cf, Regex searchFor)
        {
            for (var i = 0; i < cf.Source.Length; i++)
            {
                var l = cf.Source[i];
                var m = searchFor.Matches(l);
                if (m.Count == 0) continue;
                foreach (Match match in m)
                    yield return new SearchResult.Use(cf, i + 1, match.Index + 1, match.Value);
            }
        }


        public override string ToString()
        {
            return Name;
        }
    }
}