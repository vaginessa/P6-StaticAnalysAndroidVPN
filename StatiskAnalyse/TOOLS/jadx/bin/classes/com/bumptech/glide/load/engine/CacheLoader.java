package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.cache.DiskCache;

class CacheLoader {
    private static final String TAG = "CacheLoader";
    private final DiskCache diskCache;

    public CacheLoader(com.bumptech.glide.load.engine.cache.DiskCache r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104214 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.CacheLoader.<init>(com.bumptech.glide.load.engine.cache.DiskCache):void");
    }

    public <Z> com.bumptech.glide.load.engine.Resource<Z> load(com.bumptech.glide.load.Key r1, com.bumptech.glide.load.ResourceDecoder<java.io.File, Z> r2, int r3, int r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.engine.CacheLoader.load(com.bumptech.glide.load.Key, com.bumptech.glide.load.ResourceDecoder, int, int):com.bumptech.glide.load.engine.Resource<Z>
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.CacheLoader.load(com.bumptech.glide.load.Key, com.bumptech.glide.load.ResourceDecoder, int, int):com.bumptech.glide.load.engine.Resource<Z>");
    }
}
