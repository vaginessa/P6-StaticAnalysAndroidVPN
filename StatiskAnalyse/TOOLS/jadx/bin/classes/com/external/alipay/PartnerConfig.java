package com.external.alipay;

import android.content.Context;

public class PartnerConfig {
    public String ALIPAY_CALLBACK;
    public String PARTNER;
    public String RSA_ALIPAY_PUBLIC;
    public String RSA_PRIVATE;
    public String SELLER;
    public Context mContext;

    public PartnerConfig(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67098860 length=8972300
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
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.external.alipay.PartnerConfig.<init>(android.content.Context):void");
    }
}
