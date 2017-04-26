package com.easemob.cloud;

import java.util.Map;
import java.util.Properties;

public abstract class CloudFileManager {
    protected static final String TAG = "CloudFileManager";
    public static CloudFileManager instance = null;
    protected Properties sessionContext;

    public CloudFileManager() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100860 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.CloudFileManager.<init>():void");
    }

    public abstract boolean authorization();

    public abstract void deleteFileInBackground(String str, String str2, String str3, CloudOperationCallback cloudOperationCallback);

    public abstract void downloadFile(String str, String str2, String str3, Map<String, String> map, CloudOperationCallback cloudOperationCallback);

    public java.lang.String getRemoteFileName(java.lang.String r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100859 length=8972300
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
        r5 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.CloudFileManager.getRemoteFileName(java.lang.String, java.lang.String):java.lang.String");
    }

    public abstract void uploadFileInBackground(String str, String str2, String str3, String str4, Map<String, String> map, CloudOperationCallback cloudOperationCallback);
}
