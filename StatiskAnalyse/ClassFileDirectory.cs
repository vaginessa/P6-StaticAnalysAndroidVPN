using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
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
            {
                retVal.Directories.Add(LoadFromDirectory(d, ext));
            }
            var files = Directory.EnumerateFiles(rootDir, "*." + ext);
            foreach (var f in files)
            {
                retVal.Files.Add(ClassFile.FromPath(f));
            }


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

        public List<Tuple<string, bool>> FindPermissions(string apkpath)
        {
            return null;
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
            var i = 0;
            var l = cf.Source.Length;
            var sl = searchFor.Length;
            while ((i = cf.Source.IndexOf(searchFor, i)) != -1)
            {
                var ls = cf.Source.LastIndexOf("\n", i) + 1;
                var le = cf.Source.IndexOf("\n", ls) - 1;
                if (le < 0)
                    le = l;

                var sam = cf.Source.Substring(ls, le - ls).TrimStart();
                yield return new SearchResult.Use(cf, i, sam);
                i += sl;
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
            var matches = searchFor.Matches(cf.Source);
            return (from Match match in matches select new SearchResult.Use(cf, match.Index, match.Value)).ToList();
        }


        public override string ToString()
        {
            return Name;
        }

        public object FindUses(string[] androidPermissions, bool pattern)
        {
            throw new NotImplementedException();
        }
    }
}