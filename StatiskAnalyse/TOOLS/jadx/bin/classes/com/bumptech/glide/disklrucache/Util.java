package com.bumptech.glide.disklrucache;

import com.bumptech.glide.load.Key;
import com.external.stomp.Command;
import java.nio.charset.Charset;

final class Util {
    static final Charset US_ASCII = Charset.forName(Command.ENCODING);
    static final Charset UTF_8 = Charset.forName(Key.STRING_CHARSET_NAME);

    private Util() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104389 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.Util.<init>():void");
    }

    static void closeQuietly(java.io.Closeable r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.disklrucache.Util.closeQuietly(java.io.Closeable):void
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.Util.closeQuietly(java.io.Closeable):void");
    }

    static void deleteContents(java.io.File r8) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104387 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.Util.deleteContents(java.io.File):void");
    }

    static java.lang.String readFully(java.io.Reader r1) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.bumptech.glide.disklrucache.Util.readFully(java.io.Reader):java.lang.String
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.Util.readFully(java.io.Reader):java.lang.String");
    }
}
