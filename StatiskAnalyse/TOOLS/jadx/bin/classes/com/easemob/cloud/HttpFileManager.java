package com.easemob.cloud;

import android.content.Context;
import com.easemob.cloud.CustomMultiPartEntity.ProgressListener;
import java.util.Map;

public class HttpFileManager extends CloudFileManager {
    private static final long MAX_ALLOWED_FILE_SIZE = 10485760;
    private static final int max_retry_times_on_connection_refused = 20;
    private Context appContext;
    boolean tokenRetrieved;
    private long totalSize;

    class AnonymousClass1 implements ProgressListener {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ CloudOperationCallback b;

        AnonymousClass1(com.easemob.cloud.HttpFileManager r1, com.easemob.cloud.CloudOperationCallback r2) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100796 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.1.<init>(com.easemob.cloud.HttpFileManager, com.easemob.cloud.CloudOperationCallback):void");
        }

        public void transferred(long r6) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100795 length=8972300
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
            r5 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.1.transferred(long):void");
        }
    }

    class AnonymousClass2 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ String b;
        private final /* synthetic */ String c;
        private final /* synthetic */ String d;
        private final /* synthetic */ String e;
        private final /* synthetic */ Map f;
        private final /* synthetic */ CloudOperationCallback g;

        AnonymousClass2(com.easemob.cloud.HttpFileManager r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map r6, com.easemob.cloud.CloudOperationCallback r7) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100794 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.2.<init>(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100793 length=8972300
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
            r9 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.2.run():void");
        }
    }

    class AnonymousClass3 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ String b;
        private final /* synthetic */ String c;
        private final /* synthetic */ String d;
        private final /* synthetic */ String e;
        private final /* synthetic */ Map f;
        private final /* synthetic */ CloudOperationCallback g;
        private final /* synthetic */ int h;

        AnonymousClass3(com.easemob.cloud.HttpFileManager r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map r6, com.easemob.cloud.CloudOperationCallback r7, int r8) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100792 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.3.<init>(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100791 length=8972300
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
            r9 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.3.run():void");
        }
    }

    class AnonymousClass4 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ String b;
        private final /* synthetic */ String c;
        private final /* synthetic */ String d;
        private final /* synthetic */ String e;
        private final /* synthetic */ Map f;
        private final /* synthetic */ CloudOperationCallback g;

        AnonymousClass4(com.easemob.cloud.HttpFileManager r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map r6, com.easemob.cloud.CloudOperationCallback r7) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100790 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.4.<init>(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100789 length=8972300
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
            r9 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.4.run():void");
        }
    }

    class AnonymousClass5 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ String b;
        private final /* synthetic */ String c;
        private final /* synthetic */ String d;
        private final /* synthetic */ String e;
        private final /* synthetic */ Map f;
        private final /* synthetic */ CloudOperationCallback g;
        private final /* synthetic */ int h;

        AnonymousClass5(com.easemob.cloud.HttpFileManager r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map r6, com.easemob.cloud.CloudOperationCallback r7, int r8) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100788 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.5.<init>(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100787 length=8972300
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
            r9 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.5.run():void");
        }
    }

    class AnonymousClass6 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ String b;
        private final /* synthetic */ String c;
        private final /* synthetic */ String d;
        private final /* synthetic */ String e;
        private final /* synthetic */ Map f;
        private final /* synthetic */ CloudOperationCallback g;

        AnonymousClass6(com.easemob.cloud.HttpFileManager r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map r6, com.easemob.cloud.CloudOperationCallback r7) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100786 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.6.<init>(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.6.run():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.6.run():void");
        }
    }

    class AnonymousClass7 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ CloudOperationCallback b;
        private final /* synthetic */ Map c;
        private final /* synthetic */ String d;
        private final /* synthetic */ String e;

        AnonymousClass7(com.easemob.cloud.HttpFileManager r1, com.easemob.cloud.CloudOperationCallback r2, java.util.Map r3, java.lang.String r4, java.lang.String r5) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100784 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.7.<init>(com.easemob.cloud.HttpFileManager, com.easemob.cloud.CloudOperationCallback, java.util.Map, java.lang.String, java.lang.String):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100783 length=8972300
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
            r5 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.7.run():void");
        }
    }

    class AnonymousClass8 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ String b;
        private final /* synthetic */ String c;
        private final /* synthetic */ Map d;
        private final /* synthetic */ CloudOperationCallback e;
        private final /* synthetic */ int f;

        AnonymousClass8(com.easemob.cloud.HttpFileManager r1, java.lang.String r2, java.lang.String r3, java.util.Map r4, com.easemob.cloud.CloudOperationCallback r5, int r6) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100782 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.8.<init>(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.8.run():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.8.run():void");
        }
    }

    class AnonymousClass9 extends Thread {
        final /* synthetic */ HttpFileManager a;
        private final /* synthetic */ String b;
        private final /* synthetic */ String c;
        private final /* synthetic */ CloudOperationCallback d;

        AnonymousClass9(com.easemob.cloud.HttpFileManager r1, java.lang.String r2, java.lang.String r3, com.easemob.cloud.CloudOperationCallback r4) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100780 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.9.<init>(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, com.easemob.cloud.CloudOperationCallback):void");
        }

        public void run() {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.9.run():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
            /*
            r0 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.9.run():void");
        }
    }

    public HttpFileManager() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100778 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.<init>():void");
    }

    public HttpFileManager(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100777 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.<init>(android.content.Context):void");
    }

    public HttpFileManager(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100776 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.<init>(android.content.Context, java.lang.String):void");
    }

    static /* synthetic */ long access$0(com.easemob.cloud.HttpFileManager r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100775 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.access$0(com.easemob.cloud.HttpFileManager):long");
    }

    static /* synthetic */ void access$1(com.easemob.cloud.HttpFileManager r0, java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.util.Map r5, com.easemob.cloud.CloudOperationCallback r6, int r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100774 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.access$1(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int, boolean):void");
    }

    static /* synthetic */ void access$2(com.easemob.cloud.HttpFileManager r0, java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.util.Map r5, com.easemob.cloud.CloudOperationCallback r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100773 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.access$2(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
    }

    static /* synthetic */ void access$3(com.easemob.cloud.HttpFileManager r0, java.lang.String r1, java.lang.String r2, java.util.Map r3, com.easemob.cloud.CloudOperationCallback r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100772 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.access$3(com.easemob.cloud.HttpFileManager, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int):void");
    }

    private void downloadFileWithCountDown(java.lang.String r1, java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3, com.easemob.cloud.CloudOperationCallback r4, int r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.downloadFileWithCountDown(java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.downloadFileWithCountDown(java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int):void");
    }

    public static java.lang.String getMimeType(java.io.File r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100770 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.getMimeType(java.io.File):java.lang.String");
    }

    private long onDownloadCompleted(org.apache.http.HttpResponse r1, com.easemob.cloud.CloudOperationCallback r2, java.lang.String r3) throws java.io.IOException, java.lang.IllegalStateException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.onDownloadCompleted(org.apache.http.HttpResponse, com.easemob.cloud.CloudOperationCallback, java.lang.String):long
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.onDownloadCompleted(org.apache.http.HttpResponse, com.easemob.cloud.CloudOperationCallback, java.lang.String):long");
    }

    private void processHeaders(org.apache.http.client.methods.HttpGet r5, java.util.Map<java.lang.String, java.lang.String> r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100768 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.processHeaders(org.apache.http.client.methods.HttpGet, java.util.Map):void");
    }

    private java.lang.String processUrl(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100767 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.processUrl(java.lang.String):java.lang.String");
    }

    private void sendFiletoServerHttp(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.util.Map<java.lang.String, java.lang.String> r14, com.easemob.cloud.CloudOperationCallback r15) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100766 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.sendFiletoServerHttp(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
    }

    private void sendFiletoServerHttpWithCountDown(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, com.easemob.cloud.CloudOperationCallback r6, int r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.sendFiletoServerHttpWithCountDown(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int, boolean):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.sendFiletoServerHttpWithCountDown(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback, int, boolean):void");
    }

    public boolean authorization() {
        return true;
    }

    public void deleteFileInBackground(java.lang.String r2, java.lang.String r3, java.lang.String r4, com.easemob.cloud.CloudOperationCallback r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100764 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.deleteFileInBackground(java.lang.String, java.lang.String, java.lang.String, com.easemob.cloud.CloudOperationCallback):void");
    }

    public void downloadFile(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, com.easemob.cloud.CloudOperationCallback r7) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100763 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.downloadFile(java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
    }

    public void downloadFile(java.lang.String r1, java.lang.String r2, java.util.Map<java.lang.String, java.lang.String> r3, com.easemob.cloud.CloudOperationCallback r4) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.downloadFile(java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.downloadFile(java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
    }

    public void uploadFile(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, java.util.Map<java.lang.String, java.lang.String> r5, com.easemob.cloud.CloudOperationCallback r6) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpFileManager.uploadFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.uploadFile(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
    }

    public void uploadFileInBackground(java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.util.Map<java.lang.String, java.lang.String> r13, com.easemob.cloud.CloudOperationCallback r14) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100760 length=8972300
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
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpFileManager.uploadFileInBackground(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, com.easemob.cloud.CloudOperationCallback):void");
    }
}
