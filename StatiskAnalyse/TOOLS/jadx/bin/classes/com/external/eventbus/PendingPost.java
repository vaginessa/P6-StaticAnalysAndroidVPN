package com.external.eventbus;

import java.util.ArrayList;
import java.util.List;

final class PendingPost {
    private static final List<PendingPost> pendingPostPool = new ArrayList();
    Object event;
    PendingPost next;
    Subscription subscription;

    private PendingPost(java.lang.Object r1, com.external.eventbus.Subscription r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67098456 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.external.eventbus.PendingPost.<init>(java.lang.Object, com.external.eventbus.Subscription):void");
    }

    static com.external.eventbus.PendingPost obtainPendingPost(com.external.eventbus.Subscription r1, java.lang.Object r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.external.eventbus.PendingPost.obtainPendingPost(com.external.eventbus.Subscription, java.lang.Object):com.external.eventbus.PendingPost
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.external.eventbus.PendingPost.obtainPendingPost(com.external.eventbus.Subscription, java.lang.Object):com.external.eventbus.PendingPost");
    }

    static void releasePendingPost(com.external.eventbus.PendingPost r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.external.eventbus.PendingPost.releasePendingPost(com.external.eventbus.PendingPost):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.external.eventbus.PendingPost.releasePendingPost(com.external.eventbus.PendingPost):void");
    }
}
