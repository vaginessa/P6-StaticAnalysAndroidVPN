package com.easemob.util;

import android.support.v4.media.TransportMediator;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import com.BeeFramework.AppConst;
import com.baidu.location.b.g;
import com.baidu.mapapi.UIMsg.l_ErrorNo;
import java.text.Collator;
import java.util.Locale;
import org.bouncycastle.asn1.eac.EACTags;

public class HanziToPinyin {
    private static final Collator COLLATOR = Collator.getInstance(Locale.CHINA);
    private static final boolean DEBUG = false;
    private static final String FIRST_PINYIN_UNIHAN = "阿";
    private static final String LAST_PINYIN_UNIHAN = "鿿";
    public static final byte[][] PINYINS;
    private static final String TAG = "HanziToPinyin";
    public static final char[] UNIHANS = new char[]{'阿', '哎', '安', '肮', '凹', '八', '挀', '扳', '邦', '勹', '陂', '奔', '伻', '屄', '边', '灬', '憋', '汃', '冫', '癶', '峬', '嚓', '偲', '参', '仓', '撡', '冊', '嵾', '曽', '曾', '層', '叉', '芆', '辿', '伥', '抄', '车', '抻', '沈', '沉', '阷', '吃', '充', '抽', '出', '欻', '揣', '巛', '刅', '吹', '旾', '逴', '呲', '匆', '凑', '粗', '汆', '崔', '邨', '搓', '咑', '呆', '丹', '当', '刀', '嘚', '扥', '灯', '氐', '嗲', '甸', '刁', '爹', '丁', '丟', '东', '吺', '厾', '耑', '襨', '吨', '多', '妸', '诶', '奀', '鞥', '儿', '发', '帆', '匚', '飞', '分', '丰', '覅', '仏', '紑', '伕', '旮', '侅', '甘', '冈', '皋', '戈', '给', '根', '刯', '工', '勾', '估', '瓜', '乖', '关', '光', '归', '丨', '呙', '哈', '咍', '佄', '夯', '茠', '诃', '黒', '拫', '亨', '噷', '叿', '齁', '乯', '花', '怀', '犿', '巟', '灰', '昏', '吙', '丌', '加', '戋', '江', '艽', '阶', '巾', '坕', '冂', '丩', '凥', '姢', '噘', '军', '咔', '开', '刊', '忼', '尻', '匼', '肎', '劥', '空', '抠', '扝', '夸', '蒯', '宽', '匡', '亏', '坤', '扩', '垃', '来', '兰', '啷', '捞', '肋', '勒', '崚', '刕', '俩', '奁', '良', '撩', '列', '拎', '刢', '溜', '囖', '龙', '瞜', '噜', '娈', '畧', '抡', '罗', '呣', '妈', '埋', '嫚', '牤', '猫', '么', '呅', '门', '甿', '咪', '宀', '喵', '乜', '民', '名', '谬', '摸', '哞', '毪', '嗯', '拏', '腉', '囡', '囔', '孬', '疒', '娞', '恁', '能', '妮', '拈', '嬢', '鸟', '捏', '囜', '宁', '妞', '农', '羺', '奴', '奻', '疟', '黁', '郍', '喔', '讴', '妑', '拍', '眅', '乓', '抛', '呸', '喷', '匉', '丕', '囨', '剽', '氕', '姘', '乒', '钋', '剖', '仆', '七', '掐', '千', '呛', '悄', '癿', '亲', '狅', '芎', '丘', '区', '峑', '缺', '夋', '呥', '穣', '娆', '惹', '人', '扔', '日', '茸', '厹', '邚', '挼', '堧', '婑', '瞤', '捼', '仨', '毢', '三', '桒', '掻', '閪', '森', '僧', '杀', '筛', '山', '伤', '弰', '奢', '申', '莘', '敒', '升', '尸', '収', '书', '刷', '衰', '闩', '双', '谁', '吮', '说', '厶', '忪', '捜', '苏', '狻', '夊', '孙', '唆', '他', '囼', '坍', '汤', '夲', '忑', '熥', '剔', '天', '旫', '帖', '厅', '囲', '偷', '凸', '湍', '推', '吞', '乇', '穵', '歪', '弯', '尣', '危', '昷', '翁', '挝', '乌', '夕', '虲', '仚', '乡', '灱', '些', '心', '星', '凶', '休', '吁', '吅', '削', '坃', '丫', '恹', '央', '幺', '倻', '一', '囙', '应', '哟', '佣', '优', '扜', '囦', '曰', '晕', '筠', '筼', '帀', '災', '兂', '匨', '傮', '则', '贼', '怎', '増', '扎', '捚', '沾', '张', '长', '長', '佋', '蜇', '贞', '争', '之', '峙', '庢', '中', '州', '朱', '抓', '拽', '专', '妆', '隹', '宒', '卓', '乲', '宗', '邹', '租', '钻', '厜', '尊', '昨', '兙', '鿃', '鿄'};
    private static HanziToPinyin sInstance;
    private final boolean mHasChinaCollator;

    public static class Token {
        public static final int LATIN = 1;
        public static final int PINYIN = 2;
        public static final String SEPARATOR = " ";
        public static final int UNKNOWN = 3;
        public String source;
        public String target;
        public int type;

        public Token() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099309 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.Token.<init>():void");
        }

        public Token(int r1, java.lang.String r2, java.lang.String r3) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099308 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.Token.<init>(int, java.lang.String, java.lang.String):void");
        }
    }

    static {
        byte[][] bArr = new byte[424][];
        r1 = new byte[6];
        r1 = new byte[6];
        r1 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r1 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 66;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[8] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 66;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[12] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 66;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[14] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 66;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[15] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 66;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[18] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[24] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[28] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[29] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[30] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 73;
        bArr[32] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[33] = r2;
        r2 = new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[35] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 69;
        r2[3] = (byte) 78;
        bArr[37] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 69;
        r2[3] = (byte) 78;
        bArr[38] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 69;
        r2[3] = (byte) 78;
        bArr[39] = r2;
        r2 = new byte[]{(byte) 67, (byte) 72, (byte) 69, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[]{(byte) 67, (byte) 72, (byte) 79, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 79;
        r2[3] = (byte) 85;
        bArr[43] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 65;
        bArr[45] = r2;
        r2 = new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 73, r2};
        r2 = new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 78, r2};
        bArr[48] = new byte[]{(byte) 67, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71};
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 73;
        bArr[49] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 78;
        bArr[50] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 79;
        bArr[51] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[53] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 67;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[56] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 68;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[63] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 68;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[67] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 68;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[70] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 68;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[71] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 68;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[73] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 68;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[75] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r1 = new byte[6];
        r1[0] = (byte) 68;
        r1[1] = (byte) 85;
        r1[2] = (byte) 65;
        r1[3] = (byte) 78;
        bArr[78] = r1;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 70;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[89] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 70;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[92] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 70;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[93] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 71;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[100] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 71;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[105] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 71;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[106] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 71;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 73;
        bArr[110] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 71;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[111] = r2;
        r2 = new byte[]{(byte) 71, (byte) 85, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 72;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[119] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 72;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[EACTags.DYNAMIC_AUTHENTIFICATION_TEMPLATE] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 72;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[126] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 72;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 73;
        bArr[TransportMediator.KEYCODE_MEDIA_RECORD] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 72;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[131] = r2;
        r2 = new byte[]{(byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 74;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[138] = r2;
        r2 = new byte[]{(byte) 74, (byte) 73, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 74;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[AppConst.MAX_CONTENT_LEN] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 74;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[143] = r2;
        r2 = new byte[]{(byte) 74, (byte) 73, (byte) 79, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 74;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[147] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 75;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[153] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 75;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[157] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 75;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[158] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 75;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 73;
        bArr[162] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 75;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[163] = r2;
        r2 = new byte[]{(byte) 75, (byte) 85, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 76;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[171] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 76;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[175] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 76;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[178] = r2;
        r2 = new byte[]{(byte) 76, (byte) 73, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 76;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[180] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 76;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[183] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 76;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[186] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 76;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[189] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 77;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[197] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 77;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[g.void] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 77;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[g.c] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 77;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[g.aa] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 77;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[g.new] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 78;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[217] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 78;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[222] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 78;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[224] = r2;
        r2 = new byte[]{(byte) 78, (byte) 73, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 78;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[226] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 78;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[229] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 78;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[231] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 78;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[234] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 80;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[243] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 80;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[247] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 80;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[249] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 80;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[Callback.DEFAULT_SWIPE_ANIMATION_DURATION] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 80;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[253] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 81;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[259] = r2;
        r2 = new byte[]{(byte) 81, (byte) 73, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 81;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[261] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 81;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[264] = r2;
        r2 = new byte[]{(byte) 81, (byte) 73, (byte) 79, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 81;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[268] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 82;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[272] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 82;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[276] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 82;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[278] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 82;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[282] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[289] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[293] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 73;
        bArr[295] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[296] = r2;
        r2 = new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[298] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 69;
        r2[3] = (byte) 78;
        bArr[300] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 69;
        r2[3] = (byte) 78;
        bArr[g.e] = r2;
        r2 = new byte[]{(byte) 83, (byte) 72, (byte) 69, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 79;
        r2[3] = (byte) 85;
        bArr[305] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 65;
        bArr[307] = r2;
        r2 = new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 73, r2};
        r2 = new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 78, r2};
        bArr[310] = new byte[]{(byte) 83, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71};
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 73;
        bArr[311] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 78;
        bArr[312] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 79;
        bArr[313] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[315] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 83;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[318] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 84;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[325] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 84;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[328] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 84;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[330] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 84;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[331] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 84;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[333] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 84;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[334] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 84;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[337] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 87;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[344] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 87;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[347] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 88;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[352] = r2;
        r2 = new byte[]{(byte) 88, (byte) 73, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 88;
        r2[1] = (byte) 73;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[354] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 88;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[357] = r2;
        r2 = new byte[]{(byte) 88, (byte) 73, (byte) 79, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 88;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[361] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 89;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[366] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 89;
        r2[1] = (byte) 73;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[371] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 89;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[373] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 89;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[376] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 65;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[384] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 69;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[389] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 73;
        bArr[391] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[392] = r2;
        r2 = new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[]{(byte) 67, (byte) 72, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[]{(byte) 90, (byte) 72, (byte) 65, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 65;
        r2[3] = (byte) 79;
        bArr[396] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 69;
        r2[3] = (byte) 78;
        bArr[398] = r2;
        r2 = new byte[]{(byte) 90, (byte) 72, (byte) 69, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[]{(byte) 90, (byte) 72, (byte) 79, (byte) 78, (byte) 71, r2};
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 79;
        r2[3] = (byte) 85;
        bArr[l_ErrorNo.NETWORK_ERROR_404] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 65;
        bArr[406] = r2;
        r2 = new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 73, r2};
        r2 = new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 78, r2};
        bArr[409] = new byte[]{(byte) 90, (byte) 72, (byte) 85, (byte) 65, (byte) 78, (byte) 71};
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 73;
        bArr[410] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 78;
        bArr[411] = r2;
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 72;
        r2[2] = (byte) 85;
        r2[3] = (byte) 79;
        bArr[412] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 79;
        r2[2] = (byte) 78;
        r2[3] = (byte) 71;
        bArr[414] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 85;
        r2[2] = (byte) 65;
        r2[3] = (byte) 78;
        bArr[417] = r2;
        r2 = new byte[6];
        r2 = new byte[6];
        r2 = new byte[6];
        r2[0] = (byte) 90;
        r2[1] = (byte) 85;
        r2[2] = (byte) 79;
        bArr[420] = r2;
        bArr[421] = new byte[6];
        r2 = new byte[]{(byte) 83, (byte) 72, (byte) 65, (byte) 78, r2, new byte[6]};
        PINYINS = bArr;
    }

    protected HanziToPinyin(boolean r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099307 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.<init>(boolean):void");
    }

    private void addToken(java.lang.StringBuilder r3, java.util.ArrayList<com.easemob.util.HanziToPinyin.Token> r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099306 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.addToken(java.lang.StringBuilder, java.util.ArrayList, int):void");
    }

    private static boolean doSelfValidation() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099305 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.doSelfValidation():boolean");
    }

    public static com.easemob.util.HanziToPinyin getInstance() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.util.HanziToPinyin.getInstance():com.easemob.util.HanziToPinyin
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.getInstance():com.easemob.util.HanziToPinyin");
    }

    private com.easemob.util.HanziToPinyin.Token getToken(char r11) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099303 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.getToken(char):com.easemob.util.HanziToPinyin$Token");
    }

    public java.util.ArrayList<com.easemob.util.HanziToPinyin.Token> get(java.lang.String r11) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099302 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r10 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.util.HanziToPinyin.get(java.lang.String):java.util.ArrayList<com.easemob.util.HanziToPinyin$Token>");
    }
}
