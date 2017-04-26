package com.baidu.mapapi.map.offline;

import com.baidu.mapapi.model.LatLng;

public class MKOLUpdateElement {
    public static final int DOWNLOADING = 1;
    public static final int FINISHED = 4;
    public static final int SUSPENDED = 3;
    public static final int UNDEFINED = 0;
    public static final int WAITING = 2;
    public static final int eOLDSFormatError = 9;
    public static final int eOLDSIOError = 7;
    public static final int eOLDSInstalling = 10;
    public static final int eOLDSMd5Error = 5;
    public static final int eOLDSNetError = 6;
    public static final int eOLDSWifiError = 8;
    public int cityID;
    public String cityName;
    public LatLng geoPt;
    public int level;
    public int ratio;
    public int serversize;
    public int size;
    public int status;
    public boolean update;

    public MKOLUpdateElement() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67106280 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.offline.MKOLUpdateElement.<init>():void");
    }
}
