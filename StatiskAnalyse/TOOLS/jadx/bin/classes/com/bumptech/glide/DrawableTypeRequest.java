package com.bumptech.glide;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class DrawableTypeRequest<ModelType> extends DrawableRequestBuilder<ModelType> implements DownloadOptions {
    private final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    private final OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    DrawableTypeRequest(java.lang.Class<ModelType> r8, com.bumptech.glide.load.model.ModelLoader<ModelType, java.io.InputStream> r9, com.bumptech.glide.load.model.ModelLoader<ModelType, android.os.ParcelFileDescriptor> r10, android.content.Context r11, com.bumptech.glide.Glide r12, com.bumptech.glide.manager.RequestTracker r13, com.bumptech.glide.manager.Lifecycle r14, com.bumptech.glide.RequestManager.OptionsApplier r15) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104716 length=8972300
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
        r7 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.DrawableTypeRequest.<init>(java.lang.Class, com.bumptech.glide.load.model.ModelLoader, com.bumptech.glide.load.model.ModelLoader, android.content.Context, com.bumptech.glide.Glide, com.bumptech.glide.manager.RequestTracker, com.bumptech.glide.manager.Lifecycle, com.bumptech.glide.RequestManager$OptionsApplier):void");
    }

    private static <A, Z, R> com.bumptech.glide.provider.FixedLoadProvider<A, com.bumptech.glide.load.model.ImageVideoWrapper, Z, R> buildProvider(com.bumptech.glide.Glide r3, com.bumptech.glide.load.model.ModelLoader<A, java.io.InputStream> r4, com.bumptech.glide.load.model.ModelLoader<A, android.os.ParcelFileDescriptor> r5, java.lang.Class<Z> r6, java.lang.Class<R> r7, com.bumptech.glide.load.resource.transcode.ResourceTranscoder<Z, R> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104715 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.DrawableTypeRequest.buildProvider(com.bumptech.glide.Glide, com.bumptech.glide.load.model.ModelLoader, com.bumptech.glide.load.model.ModelLoader, java.lang.Class, java.lang.Class, com.bumptech.glide.load.resource.transcode.ResourceTranscoder):com.bumptech.glide.provider.FixedLoadProvider<A, com.bumptech.glide.load.model.ImageVideoWrapper, Z, R>");
    }

    private com.bumptech.glide.GenericTranscodeRequest<ModelType, java.io.InputStream, java.io.File> getDownloadOnlyRequest() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104714 length=8972300
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
        r8 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.DrawableTypeRequest.getDownloadOnlyRequest():com.bumptech.glide.GenericTranscodeRequest<ModelType, java.io.InputStream, java.io.File>");
    }

    public com.bumptech.glide.BitmapTypeRequest<ModelType> asBitmap() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104713 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.DrawableTypeRequest.asBitmap():com.bumptech.glide.BitmapTypeRequest<ModelType>");
    }

    public com.bumptech.glide.GifTypeRequest<ModelType> asGif() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104712 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.DrawableTypeRequest.asGif():com.bumptech.glide.GifTypeRequest<ModelType>");
    }

    public com.bumptech.glide.request.FutureTarget<java.io.File> downloadOnly(int r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104711 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.DrawableTypeRequest.downloadOnly(int, int):com.bumptech.glide.request.FutureTarget<java.io.File>");
    }

    public <Y extends com.bumptech.glide.request.target.Target<java.io.File>> Y downloadOnly(Y r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104710 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.DrawableTypeRequest.downloadOnly(com.bumptech.glide.request.target.Target):Y");
    }
}
