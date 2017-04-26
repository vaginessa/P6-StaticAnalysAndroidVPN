package com.alipay.sdk.protocol;

public final class e {

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[f.values().length];

        static {
            try {
                a[f.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[f.NOT_POP_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[f.POP_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[f.TID_REFRESH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public e() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107424 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.protocol.e.<init>():void");
    }

    public static com.alipay.sdk.protocol.g a(com.alipay.sdk.protocol.c r6) throws com.alipay.sdk.exception.NetErrorException {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107423 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.protocol.e.a(com.alipay.sdk.protocol.c):com.alipay.sdk.protocol.g");
    }

    private static void b(com.alipay.sdk.protocol.c r1) throws com.alipay.sdk.exception.NetErrorException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.alipay.sdk.protocol.e.b(com.alipay.sdk.protocol.c):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.initTryCatches(MethodNode.java:305)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:105)
	... 5 more
*/
        /*
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.protocol.e.b(com.alipay.sdk.protocol.c):void");
    }
}
