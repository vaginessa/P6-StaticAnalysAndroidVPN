package com.baidu.platform.comjni.map.favorite;

import android.os.Bundle;

public class JNIFavorite {
    public JNIFavorite() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104987 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.platform.comjni.map.favorite.JNIFavorite.<init>():void");
    }

    public native boolean Add(long j, String str, String str2);

    public native boolean Clear(long j);

    public native long Create();

    public native int GetAll(long j, Bundle bundle);

    public native String GetValue(long j, String str);

    public native boolean IsExist(long j, String str);

    public native boolean Load(long j, String str, String str2, String str3, int i, int i2, int i3);

    public native int Release(long j);

    public native boolean Remove(long j, String str);

    public native boolean SaveCache(long j);

    public native boolean SetType(long j, int i);

    public native boolean Update(long j, String str, String str2);
}
