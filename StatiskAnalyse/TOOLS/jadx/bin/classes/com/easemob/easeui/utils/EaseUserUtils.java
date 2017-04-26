package com.easemob.easeui.utils;

import com.easemob.easeui.controller.EaseUI;
import com.easemob.easeui.controller.EaseUI.EaseUserProfileProvider;

public class EaseUserUtils {
    static EaseUserProfileProvider userProvider = EaseUI.getInstance().getUserProfileProvider();

    public EaseUserUtils() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100275 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.utils.EaseUserUtils.<init>():void");
    }

    public static com.easemob.easeui.domain.EaseUser getUserInfo(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100274 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.utils.EaseUserUtils.getUserInfo(java.lang.String):com.easemob.easeui.domain.EaseUser");
    }

    public static void setUserAvatar(android.content.Context r1, java.lang.String r2, android.widget.ImageView r3) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.easeui.utils.EaseUserUtils.setUserAvatar(android.content.Context, java.lang.String, android.widget.ImageView):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.utils.EaseUserUtils.setUserAvatar(android.content.Context, java.lang.String, android.widget.ImageView):void");
    }

    public static void setUserNick(java.lang.String r2, android.widget.TextView r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100272 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.utils.EaseUserUtils.setUserNick(java.lang.String, android.widget.TextView):void");
    }
}
