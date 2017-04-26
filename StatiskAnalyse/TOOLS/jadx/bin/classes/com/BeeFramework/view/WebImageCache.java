package com.BeeFramework.view;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.Map;

public class WebImageCache {
    private static final String TAG = WebImageCache.class.getSimpleName();
    private static int mDefaultDiskCacheTimeoutInSeconds = 86400;
    private static boolean mIsDiskCachingEnabled = true;
    private static boolean mIsMemoryCachingEnabled = true;
    private Map<String, SoftReference<Bitmap>> mMemCache;

    public WebImageCache() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107935 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.<init>():void");
    }

    private java.lang.String hashURLString(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.WebImageCache.hashURLString(java.lang.String):java.lang.String
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.hashURLString(java.lang.String):java.lang.String");
    }

    public static void setDiskCachingDefaultCacheTimeout(int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107933 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.setDiskCachingDefaultCacheTimeout(int):void");
    }

    public static void setDiskCachingEnabled(boolean r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107932 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.setDiskCachingEnabled(boolean):void");
    }

    public static void setMemoryCachingEnabled(boolean r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107931 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.setMemoryCachingEnabled(boolean):void");
    }

    public void addBitmapToCache(android.content.Context r1, java.lang.String r2, android.graphics.Bitmap r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.WebImageCache.addBitmapToCache(android.content.Context, java.lang.String, android.graphics.Bitmap):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.addBitmapToCache(android.content.Context, java.lang.String, android.graphics.Bitmap):void");
    }

    public void addBitmapToMemCache(java.lang.String r1, android.graphics.Bitmap r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.WebImageCache.addBitmapToMemCache(java.lang.String, android.graphics.Bitmap):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.addBitmapToMemCache(java.lang.String, android.graphics.Bitmap):void");
    }

    public android.graphics.Bitmap getBitmapFromDiskCache(android.content.Context r1, java.lang.String r2, int r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.WebImageCache.getBitmapFromDiskCache(android.content.Context, java.lang.String, int):android.graphics.Bitmap
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.getBitmapFromDiskCache(android.content.Context, java.lang.String, int):android.graphics.Bitmap");
    }

    public android.graphics.Bitmap getBitmapFromMemCache(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.BeeFramework.view.WebImageCache.getBitmapFromMemCache(java.lang.String):android.graphics.Bitmap
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.view.WebImageCache.getBitmapFromMemCache(java.lang.String):android.graphics.Bitmap");
    }
}
