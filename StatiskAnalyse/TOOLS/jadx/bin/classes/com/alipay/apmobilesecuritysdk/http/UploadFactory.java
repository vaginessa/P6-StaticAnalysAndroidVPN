package com.alipay.apmobilesecuritysdk.http;

public final class UploadFactory {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Mode.values().length];

        static {
            try {
                a[Mode.RPC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Mode.RPC_WALLET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public enum Mode {
        RPC,
        RPC_WALLET
    }

    public static com.alipay.apmobilesecuritysdk.http.a a(android.content.Context r3, com.alipay.apmobilesecuritysdk.http.UploadFactory.Mode r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107807 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.http.UploadFactory.a(android.content.Context, com.alipay.apmobilesecuritysdk.http.UploadFactory$Mode):com.alipay.apmobilesecuritysdk.http.a");
    }
}
