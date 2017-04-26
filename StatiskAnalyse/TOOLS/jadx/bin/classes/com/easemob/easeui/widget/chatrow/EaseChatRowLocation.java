package com.easemob.easeui.widget.chatrow;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.easemob.chat.EMMessage.Status;
import com.easemob.chat.LocationMessageBody;
import com.easemob.util.LatLng;

public class EaseChatRowLocation extends EaseChatRow {
    private LocationMessageBody locBody;
    private TextView locationView;

    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$easemob$chat$EMMessage$Status = new int[Status.values().length];

        static {
            try {
                $SwitchMap$com$easemob$chat$EMMessage$Status[Status.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$easemob$chat$EMMessage$Status[Status.SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$easemob$chat$EMMessage$Status[Status.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$easemob$chat$EMMessage$Status[Status.INPROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    protected class MapClickListener implements OnClickListener {
        String address;
        LatLng location;
        final /* synthetic */ EaseChatRowLocation this$0;

        public MapClickListener(com.easemob.easeui.widget.chatrow.EaseChatRowLocation r1, com.easemob.util.LatLng r2, java.lang.String r3) {
            /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100000 length=8972300
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
            throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.MapClickListener.<init>(com.easemob.easeui.widget.chatrow.EaseChatRowLocation, com.easemob.util.LatLng, java.lang.String):void");
        }

        public void onClick(View v) {
        }
    }

    public EaseChatRowLocation(android.content.Context r1, com.easemob.chat.EMMessage r2, int r3, android.widget.BaseAdapter r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099999 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.<init>(android.content.Context, com.easemob.chat.EMMessage, int, android.widget.BaseAdapter):void");
    }

    protected void onBubbleClick() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099998 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.onBubbleClick():void");
    }

    protected void onFindViewById() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099997 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.onFindViewById():void");
    }

    protected void onInflatView() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099996 length=8972300
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
        r3 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.onInflatView():void");
    }

    protected void onSetUpView() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.onSetUpView():void
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.onSetUpView():void");
    }

    protected void onUpdateView() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099994 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.easeui.widget.chatrow.EaseChatRowLocation.onUpdateView():void");
    }
}
