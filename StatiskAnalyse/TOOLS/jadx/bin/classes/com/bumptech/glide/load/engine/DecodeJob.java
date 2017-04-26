package com.bumptech.glide.load.engine;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;

class DecodeJob<A, T, Z> {
    private static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    private static final String TAG = "DecodeJob";
    private final DiskCacheProvider diskCacheProvider;
    private final DiskCacheStrategy diskCacheStrategy;
    private final DataFetcher<A> fetcher;
    private final FileOpener fileOpener;
    private final int height;
    private volatile boolean isCancelled;
    private final DataLoadProvider<A, T> loadProvider;
    private final Priority priority;
    private final EngineKey resultKey;
    private final ResourceTranscoder<T, Z> transcoder;
    private final Transformation<T> transformation;
    private final int width;

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    static class FileOpener {
        FileOpener() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104212 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.FileOpener.<init>():void");
        }

        public java.io.OutputStream open(java.io.File r3) throws java.io.FileNotFoundException {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104211 length=8972300
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
            r2 = this;
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.FileOpener.open(java.io.File):java.io.OutputStream");
        }
    }

    class SourceWriter<DataType> implements Writer {
        private final DataType data;
        private final Encoder<DataType> encoder;
        final /* synthetic */ DecodeJob this$0;

        public SourceWriter(com.bumptech.glide.load.engine.DecodeJob r1, com.bumptech.glide.load.Encoder<DataType> r2, DataType r3) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104210 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.SourceWriter.<init>(com.bumptech.glide.load.engine.DecodeJob, com.bumptech.glide.load.Encoder, java.lang.Object):void");
        }

        public boolean write(java.io.File r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.engine.DecodeJob.SourceWriter.write(java.io.File):boolean
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
            r0 = 0;
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.SourceWriter.write(java.io.File):boolean");
        }
    }

    public DecodeJob(com.bumptech.glide.load.engine.EngineKey r13, int r14, int r15, com.bumptech.glide.load.data.DataFetcher<A> r16, com.bumptech.glide.provider.DataLoadProvider<A, T> r17, com.bumptech.glide.load.Transformation<T> r18, com.bumptech.glide.load.resource.transcode.ResourceTranscoder<T, Z> r19, com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider r20, com.bumptech.glide.load.engine.DiskCacheStrategy r21, com.bumptech.glide.Priority r22) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104208 length=8972300
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
        r12 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.<init>(com.bumptech.glide.load.engine.EngineKey, int, int, com.bumptech.glide.load.data.DataFetcher, com.bumptech.glide.provider.DataLoadProvider, com.bumptech.glide.load.Transformation, com.bumptech.glide.load.resource.transcode.ResourceTranscoder, com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider, com.bumptech.glide.load.engine.DiskCacheStrategy, com.bumptech.glide.Priority):void");
    }

    DecodeJob(com.bumptech.glide.load.engine.EngineKey r1, int r2, int r3, com.bumptech.glide.load.data.DataFetcher<A> r4, com.bumptech.glide.provider.DataLoadProvider<A, T> r5, com.bumptech.glide.load.Transformation<T> r6, com.bumptech.glide.load.resource.transcode.ResourceTranscoder<T, Z> r7, com.bumptech.glide.load.engine.DecodeJob.DiskCacheProvider r8, com.bumptech.glide.load.engine.DiskCacheStrategy r9, com.bumptech.glide.Priority r10, com.bumptech.glide.load.engine.DecodeJob.FileOpener r11) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104207 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.<init>(com.bumptech.glide.load.engine.EngineKey, int, int, com.bumptech.glide.load.data.DataFetcher, com.bumptech.glide.provider.DataLoadProvider, com.bumptech.glide.load.Transformation, com.bumptech.glide.load.resource.transcode.ResourceTranscoder, com.bumptech.glide.load.engine.DecodeJob$DiskCacheProvider, com.bumptech.glide.load.engine.DiskCacheStrategy, com.bumptech.glide.Priority, com.bumptech.glide.load.engine.DecodeJob$FileOpener):void");
    }

    static /* synthetic */ com.bumptech.glide.load.engine.DecodeJob.FileOpener access$000(com.bumptech.glide.load.engine.DecodeJob r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104206 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.access$000(com.bumptech.glide.load.engine.DecodeJob):com.bumptech.glide.load.engine.DecodeJob$FileOpener");
    }

    private com.bumptech.glide.load.engine.Resource<T> cacheAndDecodeSourceData(A r8) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104205 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.cacheAndDecodeSourceData(java.lang.Object):com.bumptech.glide.load.engine.Resource<T>");
    }

    private com.bumptech.glide.load.engine.Resource<T> decodeFromSourceData(A r7) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104204 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.decodeFromSourceData(java.lang.Object):com.bumptech.glide.load.engine.Resource<T>");
    }

    private com.bumptech.glide.load.engine.Resource<T> decodeSource() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.engine.DecodeJob.decodeSource():com.bumptech.glide.load.engine.Resource<T>
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.decodeSource():com.bumptech.glide.load.engine.Resource<T>");
    }

    private com.bumptech.glide.load.engine.Resource<T> loadFromCache(com.bumptech.glide.load.Key r1) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.engine.DecodeJob.loadFromCache(com.bumptech.glide.load.Key):com.bumptech.glide.load.engine.Resource<T>
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.loadFromCache(com.bumptech.glide.load.Key):com.bumptech.glide.load.engine.Resource<T>");
    }

    private void logWithTimeAndKey(java.lang.String r5, long r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104201 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.logWithTimeAndKey(java.lang.String, long):void");
    }

    private com.bumptech.glide.load.engine.Resource<Z> transcode(com.bumptech.glide.load.engine.Resource<T> r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104200 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.transcode(com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource<Z>");
    }

    private com.bumptech.glide.load.engine.Resource<T> transform(com.bumptech.glide.load.engine.Resource<T> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104199 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.transform(com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource<T>");
    }

    private com.bumptech.glide.load.engine.Resource<Z> transformEncodeAndTranscode(com.bumptech.glide.load.engine.Resource<T> r7) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104198 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.transformEncodeAndTranscode(com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource<Z>");
    }

    private void writeTransformedToCache(com.bumptech.glide.load.engine.Resource<T> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104197 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.writeTransformedToCache(com.bumptech.glide.load.engine.Resource):void");
    }

    public void cancel() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104196 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.cancel():void");
    }

    public com.bumptech.glide.load.engine.Resource<Z> decodeFromSource() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104195 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.decodeFromSource():com.bumptech.glide.load.engine.Resource<Z>");
    }

    public com.bumptech.glide.load.engine.Resource<Z> decodeResultFromCache() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104194 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.decodeResultFromCache():com.bumptech.glide.load.engine.Resource<Z>");
    }

    public com.bumptech.glide.load.engine.Resource<Z> decodeSourceFromCache() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104193 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.decodeSourceFromCache():com.bumptech.glide.load.engine.Resource<Z>");
    }
}
