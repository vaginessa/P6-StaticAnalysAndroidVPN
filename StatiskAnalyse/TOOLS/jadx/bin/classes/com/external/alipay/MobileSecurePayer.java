package com.external.alipay;

import android.app.Activity;
import android.content.ServiceConnection;
import android.os.Handler;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;

public class MobileSecurePayer {
    static String TAG = "MobileSecurePayer";
    Integer lock;
    Activity mActivity;
    IAlixPay mAlixPay;
    private ServiceConnection mAlixPayConnection;
    private IRemoteServiceCallback mCallback;
    boolean mbPaying;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ MobileSecurePayer this$0;
        final /* synthetic */ Handler val$callback;
        final /* synthetic */ int val$myWhat;
        final /* synthetic */ String val$strOrderInfo;

        AnonymousClass2(com.external.alipay.MobileSecurePayer r1, java.lang.String r2, int r3, android.os.Handler r4) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67098874 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.external.alipay.MobileSecurePayer.2.<init>(com.external.alipay.MobileSecurePayer, java.lang.String, int, android.os.Handler):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.external.alipay.MobileSecurePayer.2.run():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.external.alipay.MobileSecurePayer.2.run():void");
        }
    }

    public MobileSecurePayer() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67098870 length=8972300
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
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.external.alipay.MobileSecurePayer.<init>():void");
    }

    static /* synthetic */ com.alipay.android.app.IRemoteServiceCallback access$000(com.external.alipay.MobileSecurePayer r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67098869 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.external.alipay.MobileSecurePayer.access$000(com.external.alipay.MobileSecurePayer):com.alipay.android.app.IRemoteServiceCallback");
    }

    static /* synthetic */ android.content.ServiceConnection access$100(com.external.alipay.MobileSecurePayer r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67098868 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.external.alipay.MobileSecurePayer.access$100(com.external.alipay.MobileSecurePayer):android.content.ServiceConnection");
    }

    public boolean pay(java.lang.String r5, android.os.Handler r6, int r7, android.app.Activity r8) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67098867 length=8972300
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
        r4 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.external.alipay.MobileSecurePayer.pay(java.lang.String, android.os.Handler, int, android.app.Activity):boolean");
    }
}
