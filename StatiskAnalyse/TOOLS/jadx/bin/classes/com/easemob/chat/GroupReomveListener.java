package com.easemob.chat;

public abstract class GroupReomveListener implements GroupChangeListener {
    public GroupReomveListener() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67101419 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.chat.GroupReomveListener.<init>():void");
    }

    public void onApplicationAccept(String str, String str2, String str3) {
    }

    public void onApplicationDeclined(String str, String str2, String str3, String str4) {
    }

    public void onApplicationReceived(String str, String str2, String str3, String str4) {
    }

    public void onInvitationAccpted(String str, String str2, String str3) {
    }

    public void onInvitationDeclined(String str, String str2, String str3) {
    }

    public void onInvitationReceived(String str, String str2, String str3, String str4) {
    }
}
