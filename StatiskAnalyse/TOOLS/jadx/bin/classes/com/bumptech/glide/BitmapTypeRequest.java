package com.bumptech.glide;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class BitmapTypeRequest<ModelType> extends BitmapRequestBuilder<ModelType, Bitmap> {
    private final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    private final Glide glide;
    private final OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    BitmapTypeRequest(com.bumptech.glide.GenericRequestBuilder<ModelType, ?, ?, ?> r4, com.bumptech.glide.load.model.ModelLoader<ModelType, java.io.InputStream> r5, com.bumptech.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> r6, com.bumptech.glide.RequestManager.OptionsApplier r7) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104797 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.BitmapTypeRequest.<init>(com.bumptech.glide.GenericRequestBuilder, com.bumptech.glide.load.model.ModelLoader, com.bumptech.glide.load.model.ModelLoader, com.bumptech.glide.RequestManager$OptionsApplier):void");
    }

    private static <A, R> com.bumptech.glide.provider.FixedLoadProvider<A, com.bumptech.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap, R> buildProvider(com.bumptech.glide.Glide r4, com.bumptech.glide.load.model.ModelLoader<A, java.io.InputStream> r5, com.bumptech.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> r6, java.lang.Class<R> r7, com.bumptech.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, R> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104796 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.BitmapTypeRequest.buildProvider(com.bumptech.glide.Glide, com.bumptech.glide.load.model.ModelLoader, com.bumptech.glide.load.model.ModelLoader, java.lang.Class, com.bumptech.glide.load.resource.transcode.ResourceTranscoder):com.bumptech.glide.provider.FixedLoadProvider<A, com.bumptech.glide.load.model.ImageVideoWrapper, android.graphics.Bitmap, R>");
    }

    public com.bumptech.glide.BitmapRequestBuilder<ModelType, byte[]> toBytes() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104795 length=8972300
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
        r2 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.BitmapTypeRequest.toBytes():com.bumptech.glide.BitmapRequestBuilder<ModelType, byte[]>");
    }

    public com.bumptech.glide.BitmapRequestBuilder<ModelType, byte[]> toBytes(android.graphics.Bitmap.CompressFormat r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104794 length=8972300
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
        r2 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.BitmapTypeRequest.toBytes(android.graphics.Bitmap$CompressFormat, int):com.bumptech.glide.BitmapRequestBuilder<ModelType, byte[]>");
    }

    public <R> com.bumptech.glide.BitmapRequestBuilder<ModelType, R> transcode(com.bumptech.glide.load.resource.transcode.ResourceTranscoder<android.graphics.Bitmap, R> r6, java.lang.Class<R> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104793 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.BitmapTypeRequest.transcode(com.bumptech.glide.load.resource.transcode.ResourceTranscoder, java.lang.Class):com.bumptech.glide.BitmapRequestBuilder<ModelType, R>");
    }
}
