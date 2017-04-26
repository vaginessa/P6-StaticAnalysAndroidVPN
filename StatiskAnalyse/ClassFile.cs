using System.IO;

namespace StatiskAnalyse
{
    public class ClassFile
    {
        public string Name { get; private set; }
        public string FilePath { get; set; }
        public string[] Source { get; private set; }

        public static ClassFile FromPath(string path)
        {
            return new ClassFile
            {
                Name = Path.GetFileNameWithoutExtension(path),
                FilePath = path,
                Source = File.ReadAllLines(path)
            };
        }
        public override string ToString()
        {
            return Name;
        }
    }
}