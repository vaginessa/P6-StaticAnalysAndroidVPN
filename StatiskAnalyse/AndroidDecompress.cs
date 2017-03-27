using System;
using System.Text;

namespace StatiskAnalyse
{
    public static class AndroidDecompress
    {
        public const int EndDocTag = 0x00100101;
        public const int StartTag = 0x00100102;
        public const int EndTag = 0x00100103;

        public static string DecompressXml(byte[] xml)
        {
            var sbres = new StringBuilder();
            int numbStrings = Lew(xml, 4 * 4);
            int sitOff = 0x24;  // Offset of start of StringIndexTable
            int stOff = sitOff + numbStrings * 4; 
            int xmlTagOff = Lew(xml, 3 * 4);  // Start from the offset in the 3rd word.
            // Scan forward until we find the bytes: 0x02011000(x00100102 in normal int)
            for (int ii = xmlTagOff; ii < xml.Length - 4; ii += 4)
            {
                if (Lew(xml, ii) == StartTag)
                {
                    xmlTagOff = ii; break;
                }
            } // end of hack, scanning for start of first start tag
            
            int off = xmlTagOff;
            int indent = 0;
            int startTagLineNo = -2;
            while (off < xml.Length)
            {
                int tag0 = Lew(xml, off);
                //int tag1 = LEW(xml, off+1*4);
                int lineNo = Lew(xml, off + 2 * 4);
                //int tag3 = LEW(xml, off+3*4);
                int nameNsSi = Lew(xml, off + 4 * 4);
                int nameSi = Lew(xml, off + 5 * 4);

                if (tag0 == StartTag)
                { // XML START TAG
                    int tag6 = Lew(xml, off + 6 * 4);  // Expected to be 14001400
                    int numbAttrs = Lew(xml, off + 7 * 4);  // Number of Attributes to follow
                    //int tag8 = LEW(xml, off+8*4);  // Expected to be 00000000
                    off += 9 * 4;  // Skip over 6+3 words of startTag data
                    string name = CompXmlString(xml, sitOff, stOff, nameSi);
                    //tr.addSelect(name, null);
                    startTagLineNo = lineNo;

                    // Look for the Attributes

                    string sb = "";
                    for (int ii = 0; ii < numbAttrs; ii++)
                    {
                        int attrNameNsSi = Lew(xml, off);  // AttrName Namespace Str Ind, or FFFFFFFF
                        int attrNameSi = Lew(xml, off + 1 * 4);  // AttrName String Index
                        int attrValueSi = Lew(xml, off + 2 * 4); // AttrValue Str Ind, or FFFFFFFF
                        int attrFlags = Lew(xml, off + 3 * 4);
                        int attrResId = Lew(xml, off + 4 * 4);  // AttrValue ResourceId or dup AttrValue StrInd
                        off += 5 * 4;  // Skip over the 5 words of an attribute

                        string attrName = CompXmlString(xml, sitOff, stOff, attrNameSi);
                        string attrValue = attrValueSi != -1
                            ? CompXmlString(xml, sitOff, stOff, attrValueSi)
                            : /*"resourceID 0x" + */attrResId.ToString();
                        sb += " " + attrName + "=\"" + attrValue + "\"";
                        //tr.add(attrName, attrValue);
                    }
                    sbres.Append("<" + name + sb + ">");
                    indent++;

                }
                else if (tag0 == EndTag)
                { // XML END TAG
                    indent--;
                    off += 6 * 4;  // Skip over 6 words of endTag data
                    string name = CompXmlString(xml, sitOff, stOff, nameSi);
                    sbres.Append("</" + name + ">  \r\n");
                    //tr.parent();  // Step back up the NobTree

                }
                else if (tag0 == EndDocTag)
                {  // END OF XML DOC TAG
                    break;

                }
                else
                {
                    sbres.AppendLine("  Unrecognized tag code '" + tag0.ToString("X")
                        + "' at offset " + off);
                    break;
                }
            } 


            return sbres.ToString();
        }
        
        private static string CompXmlString(byte[] xml, int sitOff, int stOff, int strInd)
        {
            if (strInd < 0) return null;
            int strOff = stOff + Lew(xml, sitOff + strInd * 4);
            return CompXmlStringAt(xml, strOff);
        }

        private static string CompXmlStringAt(byte[] arr, int strOff)
        {
            int strLen = arr[strOff + 1] << 8 & 0xff00 | arr[strOff] & 0xff;
            byte[] chars = new byte[strLen];
            for (int ii = 0; ii < strLen; ii++)
            {
                chars[ii] = arr[strOff + 2 + ii * 2];
            }
            return Encoding.UTF8.GetString(chars);
        }

        public static int Lew(byte[] arr, int off)
        {
            return (int)(arr[off + 3] << 24 & 0xff000000 | arr[off + 2] << 16 & 0xff0000 | arr[off + 1] << 8 & 0xff00 | arr[off] & 0xFF);
        } 

    }
}