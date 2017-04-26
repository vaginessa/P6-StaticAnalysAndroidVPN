package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import java.util.LinkedList;

public class APSecuritySdk {
    private static APSecuritySdk a;
    private static Object b = new Object();
    private Context c;
    private String d;
    private boolean e;
    private boolean f;
    private Thread g;
    private LinkedList<RunningTask> h;

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    private class RunningTask {
        final /* synthetic */ APSecuritySdk a;
        private int b;
        private String c;
        private String d;
        private InitResultListener e;

        public RunningTask(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1, int r2, java.lang.String r3, java.lang.String r4, com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener r5) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107825 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.RunningTask.<init>(com.alipay.apmobilesecuritysdk.face.APSecuritySdk, int, java.lang.String, java.lang.String, com.alipay.apmobilesecuritysdk.face.APSecuritySdk$InitResultListener):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.RunningTask.run():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.initTryCatches(MethodNode.java:305)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:105)
	... 6 more
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.RunningTask.run():void");
        }
    }

    public class TokenResult {
        final /* synthetic */ APSecuritySdk a;
        public String apdid;
        public String apdidToken;
        public String umidToken;

        public TokenResult(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107823 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult.<init>(com.alipay.apmobilesecuritysdk.face.APSecuritySdk):void");
        }
    }

    private APSecuritySdk(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107822 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.<init>(android.content.Context):void");
    }

    static /* synthetic */ java.lang.String a(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r0, java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107821 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.a(com.alipay.apmobilesecuritysdk.face.APSecuritySdk, java.lang.String):java.lang.String");
    }

    static /* synthetic */ java.util.LinkedList a(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107820 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.a(com.alipay.apmobilesecuritysdk.face.APSecuritySdk):java.util.LinkedList");
    }

    static /* synthetic */ boolean a(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r0, boolean r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107819 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.a(com.alipay.apmobilesecuritysdk.face.APSecuritySdk, boolean):boolean");
    }

    static /* synthetic */ java.lang.Thread b(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107818 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.b(com.alipay.apmobilesecuritysdk.face.APSecuritySdk):java.lang.Thread");
    }

    static /* synthetic */ boolean b(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r0, boolean r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107817 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.b(com.alipay.apmobilesecuritysdk.face.APSecuritySdk, boolean):boolean");
    }

    static /* synthetic */ boolean c(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107816 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.c(com.alipay.apmobilesecuritysdk.face.APSecuritySdk):boolean");
    }

    static /* synthetic */ android.content.Context d(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107815 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.d(com.alipay.apmobilesecuritysdk.face.APSecuritySdk):android.content.Context");
    }

    static /* synthetic */ boolean e(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107814 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.e(com.alipay.apmobilesecuritysdk.face.APSecuritySdk):boolean");
    }

    static /* synthetic */ java.lang.String f(com.alipay.apmobilesecuritysdk.face.APSecuritySdk r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107813 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.f(com.alipay.apmobilesecuritysdk.face.APSecuritySdk):java.lang.String");
    }

    public static com.alipay.apmobilesecuritysdk.face.APSecuritySdk getInstance(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getInstance(android.content.Context):com.alipay.apmobilesecuritysdk.face.APSecuritySdk
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getInstance(android.content.Context):com.alipay.apmobilesecuritysdk.face.APSecuritySdk");
    }

    public com.alipay.apmobilesecuritysdk.face.APSecuritySdk.TokenResult getTokenResult() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getTokenResult():com.alipay.apmobilesecuritysdk.face.APSecuritySdk$TokenResult
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
        r0 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.getTokenResult():com.alipay.apmobilesecuritysdk.face.APSecuritySdk$TokenResult");
    }

    public synchronized void initToken(int r1, java.lang.String r2, java.lang.String r3, com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.initToken(int, java.lang.String, java.lang.String, com.alipay.apmobilesecuritysdk.face.APSecuritySdk$InitResultListener):void
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
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.initToken(int, java.lang.String, java.lang.String, com.alipay.apmobilesecuritysdk.face.APSecuritySdk$InitResultListener):void");
    }
}
