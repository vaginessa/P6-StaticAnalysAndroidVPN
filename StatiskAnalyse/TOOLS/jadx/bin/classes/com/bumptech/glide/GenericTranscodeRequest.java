package com.bumptech.glide;

import com.bumptech.glide.load.model.ModelLoader;

public class GenericTranscodeRequest<ModelType, DataType, ResourceType> extends GenericRequestBuilder<ModelType, DataType, ResourceType, ResourceType> implements DownloadOptions {
    private final Class<DataType> dataClass;
    private final ModelLoader<ModelType, DataType> modelLoader;
    private final OptionsApplier optionsApplier;
    private final Class<ResourceType> resourceClass;

    GenericTranscodeRequest(android.content.Context r10, com.bumptech.glide.Glide r11, java.lang.Class<ModelType> r12, com.bumptech.glide.load.model.ModelLoader<ModelType, DataType> r13, java.lang.Class<DataType> r14, java.lang.Class<ResourceType> r15, com.bumptech.glide.manager.RequestTracker r16, com.bumptech.glide.manager.Lifecycle r17, com.bumptech.glide.RequestManager.OptionsApplier r18) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104707 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericTranscodeRequest.<init>(android.content.Context, com.bumptech.glide.Glide, java.lang.Class, com.bumptech.glide.load.model.ModelLoader, java.lang.Class, java.lang.Class, com.bumptech.glide.manager.RequestTracker, com.bumptech.glide.manager.Lifecycle, com.bumptech.glide.RequestManager$OptionsApplier):void");
    }

    GenericTranscodeRequest(java.lang.Class<ResourceType> r3, com.bumptech.glide.GenericRequestBuilder<ModelType, ?, ?, ?> r4, com.bumptech.glide.load.model.ModelLoader<ModelType, DataType> r5, java.lang.Class<DataType> r6, java.lang.Class<ResourceType> r7, com.bumptech.glide.RequestManager.OptionsApplier r8) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104706 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericTranscodeRequest.<init>(java.lang.Class, com.bumptech.glide.GenericRequestBuilder, com.bumptech.glide.load.model.ModelLoader, java.lang.Class, java.lang.Class, com.bumptech.glide.RequestManager$OptionsApplier):void");
    }

    private static <A, T, Z, R> com.bumptech.glide.provider.LoadProvider<A, T, Z, R> build(com.bumptech.glide.Glide r2, com.bumptech.glide.load.model.ModelLoader<A, T> r3, java.lang.Class<T> r4, java.lang.Class<Z> r5, com.bumptech.glide.load.resource.transcode.ResourceTranscoder<Z, R> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104705 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericTranscodeRequest.build(com.bumptech.glide.Glide, com.bumptech.glide.load.model.ModelLoader, java.lang.Class, java.lang.Class, com.bumptech.glide.load.resource.transcode.ResourceTranscoder):com.bumptech.glide.provider.LoadProvider<A, T, Z, R>");
    }

    private com.bumptech.glide.GenericRequestBuilder<ModelType, DataType, java.io.File, java.io.File> getDownloadOnlyRequest() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104704 length=8972300
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
        r6 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericTranscodeRequest.getDownloadOnlyRequest():com.bumptech.glide.GenericRequestBuilder<ModelType, DataType, java.io.File, java.io.File>");
    }

    public com.bumptech.glide.request.FutureTarget<java.io.File> downloadOnly(int r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104703 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericTranscodeRequest.downloadOnly(int, int):com.bumptech.glide.request.FutureTarget<java.io.File>");
    }

    public <Y extends com.bumptech.glide.request.target.Target<java.io.File>> Y downloadOnly(Y r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104702 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericTranscodeRequest.downloadOnly(com.bumptech.glide.request.target.Target):Y");
    }

    public <TranscodeType> com.bumptech.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transcode(com.bumptech.glide.load.resource.transcode.ResourceTranscoder<ResourceType, TranscodeType> r6, java.lang.Class<TranscodeType> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104701 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericTranscodeRequest.transcode(com.bumptech.glide.load.resource.transcode.ResourceTranscoder, java.lang.Class):com.bumptech.glide.GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType>");
    }
}
