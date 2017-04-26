package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.File;

public class ImageVideoGifDrawableLoadProvider implements DataLoadProvider<ImageVideoWrapper, GifBitmapWrapper> {
    private final ResourceDecoder<File, GifBitmapWrapper> cacheDecoder;
    private final ResourceEncoder<GifBitmapWrapper> encoder;
    private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> sourceDecoder;
    private final Encoder<ImageVideoWrapper> sourceEncoder;

    public ImageVideoGifDrawableLoadProvider(com.bumptech.glide.provider.DataLoadProvider<com.bumptech.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap> r5, com.bumptech.glide.provider.DataLoadProvider<java.io.InputStream, com.bumptech.glide.load.resource.gif.GifDrawable> r6, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r7) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103370 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider.<init>(com.bumptech.glide.provider.DataLoadProvider, com.bumptech.glide.provider.DataLoadProvider, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool):void");
    }

    public com.bumptech.glide.load.ResourceDecoder<java.io.File, com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper> getCacheDecoder() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103369 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider.getCacheDecoder():com.bumptech.glide.load.ResourceDecoder<java.io.File, com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper>");
    }

    public com.bumptech.glide.load.ResourceEncoder<com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper> getEncoder() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103368 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider.getEncoder():com.bumptech.glide.load.ResourceEncoder<com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper>");
    }

    public com.bumptech.glide.load.ResourceDecoder<com.bumptech.glide.load.model.ImageVideoWrapper, com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper> getSourceDecoder() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103367 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider.getSourceDecoder():com.bumptech.glide.load.ResourceDecoder<com.bumptech.glide.load.model.ImageVideoWrapper, com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper>");
    }

    public com.bumptech.glide.load.Encoder<com.bumptech.glide.load.model.ImageVideoWrapper> getSourceEncoder() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103366 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider.getSourceEncoder():com.bumptech.glide.load.Encoder<com.bumptech.glide.load.model.ImageVideoWrapper>");
    }
}
