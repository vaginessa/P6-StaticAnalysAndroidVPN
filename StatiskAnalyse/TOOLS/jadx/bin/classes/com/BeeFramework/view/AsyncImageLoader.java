package com.BeeFramework.view;

import android.graphics.Bitmap;
import android.os.Handler;
import java.lang.ref.SoftReference;
import java.util.HashMap;

public class AsyncImageLoader {
    private HashMap<String, SoftReference<Bitmap>> imageCache;

    class AnonymousClass1 extends Handler {
        final /* synthetic */ AsyncImageLoader this$0;
        final /* synthetic */ ImageCallback val$imageCallback;
        final /* synthetic */ String val$imageUrl;

        AnonymousClass1(com.BeeFramework.view.AsyncImageLoader r1, com.BeeFramework.view.AsyncImageLoader.ImageCallback r2, java.lang.String r3) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108223 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.1.<init>(com.BeeFramework.view.AsyncImageLoader, com.BeeFramework.view.AsyncImageLoader$ImageCallback, java.lang.String):void");
        }

        public void handleMessage(android.os.Message r4) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108222 length=8972300
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
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.1.handleMessage(android.os.Message):void");
        }
    }

    class AnonymousClass2 extends Thread {
        final /* synthetic */ AsyncImageLoader this$0;
        final /* synthetic */ String val$fileName;
        final /* synthetic */ Handler val$handler;
        final /* synthetic */ String val$imageUrl;
        final /* synthetic */ String val$localPath;

        AnonymousClass2(com.BeeFramework.view.AsyncImageLoader r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, android.os.Handler r5) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108221 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.2.<init>(com.BeeFramework.view.AsyncImageLoader, java.lang.String, java.lang.String, java.lang.String, android.os.Handler):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108220 length=8972300
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
            r6 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.2.run():void");
        }
    }

    public interface ImageCallback {
        void imageLoaded(Bitmap bitmap, String str);
    }

    public AsyncImageLoader() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108219 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.<init>():void");
    }

    static /* synthetic */ java.util.HashMap access$000(com.BeeFramework.view.AsyncImageLoader r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108218 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.access$000(com.BeeFramework.view.AsyncImageLoader):java.util.HashMap");
    }

    public static java.lang.String saveUrlAsFile(java.lang.String r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.AsyncImageLoader.saveUrlAsFile(java.lang.String, java.lang.String):java.lang.String
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.saveUrlAsFile(java.lang.String, java.lang.String):java.lang.String");
    }

    public android.graphics.Bitmap loadDrawable(java.lang.String r10, java.lang.String r11, com.BeeFramework.view.AsyncImageLoader.ImageCallback r12) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108216 length=8972300
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
        r9 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.loadDrawable(java.lang.String, java.lang.String, com.BeeFramework.view.AsyncImageLoader$ImageCallback):android.graphics.Bitmap");
    }

    public android.graphics.Bitmap loadImageFromUrl(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.AsyncImageLoader.loadImageFromUrl(java.lang.String):android.graphics.Bitmap
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.loadImageFromUrl(java.lang.String):android.graphics.Bitmap");
    }

    public android.graphics.Bitmap loadImageFromUrl2(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.AsyncImageLoader.loadImageFromUrl2(java.lang.String):android.graphics.Bitmap
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.AsyncImageLoader.loadImageFromUrl2(java.lang.String):android.graphics.Bitmap");
    }

    public void loadImageFromSDCard(String url) {
    }
}
