package com.easemob.easeui.widget.chatrow;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.easemob.chat.EMMessage;
import com.easemob.chat.EMMessage.ChatType;
import com.easemob.chat.VoiceMessageBody;

public class EaseChatRowVoicePlayClickListener implements OnClickListener {
    private static final String TAG = "VoicePlayClickListener";
    public static EaseChatRowVoicePlayClickListener currentPlayListener = null;
    public static boolean isPlaying = false;
    public static String playMsgId;
    Activity activity;
    private BaseAdapter adapter;
    private ChatType chatType;
    ImageView iv_read_status;
    MediaPlayer mediaPlayer;
    EMMessage message;
    private AnimationDrawable voiceAnimation;
    VoiceMessageBody voiceBody;
    ImageView voiceIconView;

    public EaseChatRowVoicePlayClickListener(com.easemob.chat.EMMessage r2, android.widget.ImageView r3, android.widget.ImageView r4, android.widget.BaseAdapter r5, android.app.Activity r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099968 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener.<init>(com.easemob.chat.EMMessage, android.widget.ImageView, android.widget.ImageView, android.widget.BaseAdapter, android.app.Activity):void");
    }

    static /* synthetic */ android.widget.BaseAdapter access$000(com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099967 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener.access$000(com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener):android.widget.BaseAdapter");
    }

    private void showAnimation() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099966 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener.showAnimation():void");
    }

    public void onClick(android.view.View r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099965 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener.onClick(android.view.View):void");
    }

    public void playVoice(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener.playVoice(java.lang.String):void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener.playVoice(java.lang.String):void");
    }

    public void stopPlayVoice() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099963 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowVoicePlayClickListener.stopPlayVoice():void");
    }
}
