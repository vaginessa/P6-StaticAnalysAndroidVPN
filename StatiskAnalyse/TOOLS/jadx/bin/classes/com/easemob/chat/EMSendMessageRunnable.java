package com.easemob.chat;

import com.easemob.EMCallBack;
import com.easemob.analytics.EMTimeTag;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smackx.muc.MultiUserChat;

class EMSendMessageRunnable implements Runnable {
    private static /* synthetic */ int[] $SWITCH_TABLE$com$easemob$chat$EMMessage$Type = null;
    private static final String PERF = "perf";
    private static final String TAG = "sender";
    private static final int WAIT_SEND_TIME_OUT = 60;
    private static final int WAIT_TIME_OUT = 40;
    static Hashtable<String, Object> errorMsgWaitLocks = new Hashtable();
    private static long lastForceReconnectTime = 0;
    private static long lastSendMessageTime = -1;
    private static ConcurrentLinkedQueue<EMSendMessageRunnable> pendingMsgQueue = new ConcurrentLinkedQueue();
    static Hashtable<String, Object> sendLocks;
    static Hashtable<String, Object> sendMsgLocks;
    private static ExecutorService sendThreadPool = Executors.newFixedThreadPool(3);
    private static Object trafficLock = new Object();
    private EMCallBack callback;
    private Chat chat;
    private boolean connectedBeforeSend;
    private Object errorWaitLock;
    private String groupId;
    private EMMessage msg;
    private MultiUserChat muc;
    private Object mutex;
    private int numberOfRetried;
    private Object sendMutex;
    EMTimeTag timeTag;

    class AnonymousClass1 implements EMCloudOperationCallback {
        final /* synthetic */ EMSendMessageRunnable this$0;
        private final /* synthetic */ EMCallBack val$callback;
        private final /* synthetic */ long val$fileLength;
        private final /* synthetic */ File val$fileToSend;
        private final /* synthetic */ ImageMessageBody val$imgMsgBody;
        private final /* synthetic */ EMMessage val$msg;
        private final /* synthetic */ boolean val$needToDeleteFile;
        private final /* synthetic */ String val$remoteFilePath;
        private final /* synthetic */ long val$startTime;

        AnonymousClass1(com.easemob.chat.EMSendMessageRunnable r2, com.easemob.chat.EMMessage r3, long r4, long r6, com.easemob.EMCallBack r8, boolean r9, java.io.File r10, java.lang.String r11, com.easemob.chat.ImageMessageBody r12) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101639 length=8972300
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
            r1 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.1.<init>(com.easemob.chat.EMSendMessageRunnable, com.easemob.chat.EMMessage, long, long, com.easemob.EMCallBack, boolean, java.io.File, java.lang.String, com.easemob.chat.ImageMessageBody):void");
        }

        public void onError(java.lang.String r4) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101638 length=8972300
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
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.1.onError(java.lang.String):void");
        }

        public void onProgress(int r7) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101637 length=8972300
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
            r6 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.1.onProgress(int):void");
        }

        public void onSuccess(java.lang.String r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.1.onSuccess(java.lang.String):void
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.1.onSuccess(java.lang.String):void");
        }
    }

    class AnonymousClass2 implements EMCloudOperationCallback {
        final /* synthetic */ EMSendMessageRunnable this$0;
        private final /* synthetic */ EMCallBack val$callback;
        private final /* synthetic */ EMMessage val$msg;
        private final /* synthetic */ String val$remoteFilePath;
        private final /* synthetic */ String val$thumFilePath;
        private final /* synthetic */ VideoMessageBody val$videoMsgBody;

        AnonymousClass2(com.easemob.chat.EMSendMessageRunnable r1, java.lang.String r2, java.lang.String r3, com.easemob.chat.EMMessage r4, com.easemob.EMCallBack r5, com.easemob.chat.VideoMessageBody r6) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101635 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.2.<init>(com.easemob.chat.EMSendMessageRunnable, java.lang.String, java.lang.String, com.easemob.chat.EMMessage, com.easemob.EMCallBack, com.easemob.chat.VideoMessageBody):void");
        }

        public void onError(java.lang.String r4) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101634 length=8972300
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
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.2.onError(java.lang.String):void");
        }

        public void onProgress(int r3) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101633 length=8972300
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
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.2.onProgress(int):void");
        }

        public void onSuccess(java.lang.String r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.2.onSuccess(java.lang.String):void
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.2.onSuccess(java.lang.String):void");
        }
    }

    class AnonymousClass3 implements EMCloudOperationCallback {
        final /* synthetic */ EMSendMessageRunnable this$0;
        private final /* synthetic */ Object val$lock;
        private final /* synthetic */ Map val$maps;

        AnonymousClass3(com.easemob.chat.EMSendMessageRunnable r1, java.util.Map r2, java.lang.Object r3) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101631 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.3.<init>(com.easemob.chat.EMSendMessageRunnable, java.util.Map, java.lang.Object):void");
        }

        public void onError(java.lang.String r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.3.onError(java.lang.String):void
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.3.onError(java.lang.String):void");
        }

        public void onProgress(int i) {
        }

        public void onSuccess(java.lang.String r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.3.onSuccess(java.lang.String):void
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.3.onSuccess(java.lang.String):void");
        }
    }

    class AnonymousClass4 implements EMCloudOperationCallback {
        final /* synthetic */ EMSendMessageRunnable this$0;
        private final /* synthetic */ EMCallBack val$callback;
        private final /* synthetic */ long val$fileLength;
        private final /* synthetic */ FileMessageBody val$fileMsgBody;
        private final /* synthetic */ EMMessage val$msg;
        private final /* synthetic */ String val$remoteFilePath;
        private final /* synthetic */ long val$startTime;

        AnonymousClass4(com.easemob.chat.EMSendMessageRunnable r2, com.easemob.chat.EMMessage r3, long r4, long r6, com.easemob.EMCallBack r8, java.lang.String r9, com.easemob.chat.FileMessageBody r10) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101628 length=8972300
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
            r1 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.4.<init>(com.easemob.chat.EMSendMessageRunnable, com.easemob.chat.EMMessage, long, long, com.easemob.EMCallBack, java.lang.String, com.easemob.chat.FileMessageBody):void");
        }

        public void onError(java.lang.String r4) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101627 length=8972300
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
            r3 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.4.onError(java.lang.String):void");
        }

        public void onProgress(int r11) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101626 length=8972300
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
            r10 = this;
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.4.onProgress(int):void");
        }

        public void onSuccess(java.lang.String r1) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.4.onSuccess(java.lang.String):void
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.4.onSuccess(java.lang.String):void");
        }
    }

    static /* synthetic */ int[] $SWITCH_TABLE$com$easemob$chat$EMMessage$Type() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.$SWITCH_TABLE$com$easemob$chat$EMMessage$Type():int[]
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.$SWITCH_TABLE$com$easemob$chat$EMMessage$Type():int[]");
    }

    EMSendMessageRunnable(java.lang.String r2, com.easemob.chat.EMMessage r3, com.easemob.EMCallBack r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101623 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.<init>(java.lang.String, com.easemob.chat.EMMessage, com.easemob.EMCallBack):void");
    }

    public EMSendMessageRunnable(org.jivesoftware.smack.Chat r2, com.easemob.chat.EMMessage r3, com.easemob.EMCallBack r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101622 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.<init>(org.jivesoftware.smack.Chat, com.easemob.chat.EMMessage, com.easemob.EMCallBack):void");
    }

    public EMSendMessageRunnable(org.jivesoftware.smackx.muc.MultiUserChat r2, com.easemob.chat.EMMessage r3, com.easemob.EMCallBack r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101621 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.<init>(org.jivesoftware.smackx.muc.MultiUserChat, com.easemob.chat.EMMessage, com.easemob.EMCallBack):void");
    }

    static /* synthetic */ void access$1(com.easemob.chat.EMSendMessageRunnable r0, com.easemob.chat.EMMessage r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101620 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.access$1(com.easemob.chat.EMSendMessageRunnable, com.easemob.chat.EMMessage):void");
    }

    static /* synthetic */ java.util.Map access$2(com.easemob.chat.EMSendMessageRunnable r1, java.io.File r2, com.easemob.chat.EMMessage r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101619 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.access$2(com.easemob.chat.EMSendMessageRunnable, java.io.File, com.easemob.chat.EMMessage):java.util.Map");
    }

    static /* synthetic */ void access$3(com.easemob.chat.EMSendMessageRunnable r0, com.easemob.chat.EMMessage r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101618 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.access$3(com.easemob.chat.EMSendMessageRunnable, com.easemob.chat.EMMessage):void");
    }

    static void addErrorMsgWaitLock(java.lang.String r1, java.lang.Object r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101617 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.addErrorMsgWaitLock(java.lang.String, java.lang.Object):void");
    }

    static synchronized void addSendLock(java.lang.String r1, java.lang.Object r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.addSendLock(java.lang.String, java.lang.Object):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.addSendLock(java.lang.String, java.lang.Object):void");
    }

    private void checkConnection() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.checkConnection():void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.checkConnection():void");
    }

    static synchronized void flushPendingQueue() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.flushPendingQueue():void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.flushPendingQueue():void");
    }

    private java.lang.String getThumbnailImagePath(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101613 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.getThumbnailImagePath(java.lang.String):java.lang.String");
    }

    static boolean notifyErrorMsgWaitLock(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.notifyErrorMsgWaitLock(java.lang.String):boolean
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.notifyErrorMsgWaitLock(java.lang.String):boolean");
    }

    static synchronized void notifySendLock(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.notifySendLock(java.lang.String):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.notifySendLock(java.lang.String):void");
    }

    static synchronized void notifySendMsgLocks() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.notifySendMsgLocks():void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.notifySendMsgLocks():void");
    }

    public static void onConnected() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101609 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.onConnected():void");
    }

    static void onDestroy() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.onDestroy():void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.onDestroy():void");
    }

    static void onInit() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101607 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.onInit():void");
    }

    private void sendFileMessage(com.easemob.chat.EMMessage r14, com.easemob.EMCallBack r15) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101606 length=8972300
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
        r13 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.sendFileMessage(com.easemob.chat.EMMessage, com.easemob.EMCallBack):void");
    }

    private void sendImageMessage(com.easemob.chat.EMMessage r18, com.easemob.EMCallBack r19) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101605 length=8972300
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
        r17 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.sendImageMessage(com.easemob.chat.EMMessage, com.easemob.EMCallBack):void");
    }

    private void sendMessageXmpp(com.easemob.chat.EMMessage r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.sendMessageXmpp(com.easemob.chat.EMMessage):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.sendMessageXmpp(com.easemob.chat.EMMessage):void");
    }

    private void sendMesssageWithTrafficLimit(org.jivesoftware.smack.packet.Message r1, boolean r2) throws org.jivesoftware.smack.XMPPException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.sendMesssageWithTrafficLimit(org.jivesoftware.smack.packet.Message, boolean):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.sendMesssageWithTrafficLimit(org.jivesoftware.smack.packet.Message, boolean):void");
    }

    private void sendVideoMessage(com.easemob.chat.EMMessage r11, com.easemob.EMCallBack r12) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101602 length=8972300
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
        r10 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.sendVideoMessage(com.easemob.chat.EMMessage, com.easemob.EMCallBack):void");
    }

    private void updateMsgState(com.easemob.chat.EMMessage r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101601 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.updateMsgState(com.easemob.chat.EMMessage):void");
    }

    private java.util.Map<java.lang.String, java.lang.String> uploadEncryptedThumbnailImage(java.io.File r1, com.easemob.chat.EMMessage r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.uploadEncryptedThumbnailImage(java.io.File, com.easemob.chat.EMMessage):java.util.Map<java.lang.String, java.lang.String>
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.uploadEncryptedThumbnailImage(java.io.File, com.easemob.chat.EMMessage):java.util.Map<java.lang.String, java.lang.String>");
    }

    synchronized void addSendMsgLock(java.lang.String r1, java.lang.Object r2) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.addSendMsgLock(java.lang.String, java.lang.Object):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.addSendMsgLock(java.lang.String, java.lang.Object):void");
    }

    public void run() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.chat.EMSendMessageRunnable.run():void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.EMSendMessageRunnable.run():void");
    }
}
