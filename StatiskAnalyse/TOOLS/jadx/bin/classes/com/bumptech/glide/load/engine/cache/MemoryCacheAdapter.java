package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;

public class MemoryCacheAdapter implements MemoryCache {
    private ResourceRemovedListener listener;

    public MemoryCacheAdapter() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103944 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.MemoryCacheAdapter.<init>():void");
    }

    public com.bumptech.glide.load.engine.Resource<?> put(com.bumptech.glide.load.Key r2, com.bumptech.glide.load.engine.Resource<?> r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103943 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.MemoryCacheAdapter.put(com.bumptech.glide.load.Key, com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource<?>");
    }

    public void setResourceRemovedListener(com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103942 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.cache.MemoryCacheAdapter.setResourceRemovedListener(com.bumptech.glide.load.engine.cache.MemoryCache$ResourceRemovedListener):void");
    }

    public int getCurrentSize() {
        return 0;
    }

    public int getMaxSize() {
        return 0;
    }

    public void setSizeMultiplier(float multiplier) {
    }

    public Resource<?> remove(Key key) {
        return null;
    }

    public void clearMemory() {
    }

    public void trimMemory(int level) {
    }
}
