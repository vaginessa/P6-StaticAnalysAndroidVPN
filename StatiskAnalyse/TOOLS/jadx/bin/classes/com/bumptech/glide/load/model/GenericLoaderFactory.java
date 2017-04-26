package com.bumptech.glide.load.model;

import android.content.Context;
import java.util.Map;

public class GenericLoaderFactory {
    private static final ModelLoader NULL_MODEL_LOADER = ;
    private final Map<Class, Map<Class, ModelLoader>> cachedModelLoaders;
    private final Context context;
    private final Map<Class, Map<Class, ModelLoaderFactory>> modelClassToResourceFactories;

    public GenericLoaderFactory(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103871 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.<init>(android.content.Context):void");
    }

    private <T, Y> void cacheModelLoader(java.lang.Class<T> r3, java.lang.Class<Y> r4, com.bumptech.glide.load.model.ModelLoader<T, Y> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103870 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.cacheModelLoader(java.lang.Class, java.lang.Class, com.bumptech.glide.load.model.ModelLoader):void");
    }

    private <T, Y> void cacheNullLoader(java.lang.Class<T> r2, java.lang.Class<Y> r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103869 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r1 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.cacheNullLoader(java.lang.Class, java.lang.Class):void");
    }

    private <T, Y> com.bumptech.glide.load.model.ModelLoader<T, Y> getCachedLoader(java.lang.Class<T> r4, java.lang.Class<Y> r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103868 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.getCachedLoader(java.lang.Class, java.lang.Class):com.bumptech.glide.load.model.ModelLoader<T, Y>");
    }

    private <T, Y> com.bumptech.glide.load.model.ModelLoaderFactory<T, Y> getFactory(java.lang.Class<T> r7, java.lang.Class<Y> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103867 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.getFactory(java.lang.Class, java.lang.Class):com.bumptech.glide.load.model.ModelLoaderFactory<T, Y>");
    }

    public synchronized <T, Y> com.bumptech.glide.load.model.ModelLoader<T, Y> buildModelLoader(java.lang.Class<T> r1, java.lang.Class<Y> r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.model.GenericLoaderFactory.buildModelLoader(java.lang.Class, java.lang.Class):com.bumptech.glide.load.model.ModelLoader<T, Y>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.initTryCatches(MethodNode.java:305)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:105)
	... 7 more
*/
        /*
        r0 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.buildModelLoader(java.lang.Class, java.lang.Class):com.bumptech.glide.load.model.ModelLoader<T, Y>");
    }

    @java.lang.Deprecated
    public synchronized <T, Y> com.bumptech.glide.load.model.ModelLoader<T, Y> buildModelLoader(java.lang.Class<T> r1, java.lang.Class<Y> r2, android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.model.GenericLoaderFactory.buildModelLoader(java.lang.Class, java.lang.Class, android.content.Context):com.bumptech.glide.load.model.ModelLoader<T, Y>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.initTryCatches(MethodNode.java:305)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:105)
	... 7 more
*/
        /*
        r0 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.buildModelLoader(java.lang.Class, java.lang.Class, android.content.Context):com.bumptech.glide.load.model.ModelLoader<T, Y>");
    }

    public synchronized <T, Y> com.bumptech.glide.load.model.ModelLoaderFactory<T, Y> register(java.lang.Class<T> r1, java.lang.Class<Y> r2, com.bumptech.glide.load.model.ModelLoaderFactory<T, Y> r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.model.GenericLoaderFactory.register(java.lang.Class, java.lang.Class, com.bumptech.glide.load.model.ModelLoaderFactory):com.bumptech.glide.load.model.ModelLoaderFactory<T, Y>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.initTryCatches(MethodNode.java:305)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:105)
	... 7 more
*/
        /*
        r0 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.register(java.lang.Class, java.lang.Class, com.bumptech.glide.load.model.ModelLoaderFactory):com.bumptech.glide.load.model.ModelLoaderFactory<T, Y>");
    }

    public synchronized <T, Y> com.bumptech.glide.load.model.ModelLoaderFactory<T, Y> unregister(java.lang.Class<T> r1, java.lang.Class<Y> r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.load.model.GenericLoaderFactory.unregister(java.lang.Class, java.lang.Class):com.bumptech.glide.load.model.ModelLoaderFactory<T, Y>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.initTryCatches(MethodNode.java:305)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:105)
	... 7 more
*/
        /*
        r0 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.GenericLoaderFactory.unregister(java.lang.Class, java.lang.Class):com.bumptech.glide.load.model.ModelLoaderFactory<T, Y>");
    }
}
