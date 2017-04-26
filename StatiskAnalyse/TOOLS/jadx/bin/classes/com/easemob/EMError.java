package com.easemob;

public class EMError {
    public static final int ALREADY_LOGEDIN = -1024;
    public static final int CONNECTION_CLOSED = -1013;
    public static final int CONNECTION_CONFLICT = -1014;
    public static final int CONNECTION_INIT_FAILED = -1022;
    public static final int CONNECT_TIMER_OUT = -1004;
    public static final int DNS_ERROR = -1002;
    public static final int ENCRYPTION_ERROR = -1009;
    public static final int ERROR_EXCEPTION = -1;
    public static final int ERROR_FILE_NOT_FOUND = -3;
    public static final int ERROR_SEND = -2;
    public static final int ERROR_SOCKET_TIME_OUT = -1026;
    public static final int ERROR_UNBIND_DEVICETOKEN = -3000;
    public static final int FILE_NOT_FOUND = -1012;
    public static final int GENERAL_ERROR = -998;
    public static final int GROUP_ADD_MEMBERS_TOO_MUCH = -1019;
    public static final int GROUP_MEMBERS_FULL = -1018;
    public static final int GROUP_NOT_EXIST = -1017;
    public static final int GROUP_NOT_EXIST_LOCAL = -1016;
    public static final int GROUP_NO_PERMISSIONS = -1020;
    public static final int ILLEGAL_USER_NAME = -1025;
    public static final int INVALID_CERTIFICATE = -1008;
    public static final int INVALID_FILE = -1011;
    public static final int INVALID_KEYSTORE = -1006;
    public static final int INVALID_PASSWORD_USERNAME = -1005;
    public static final int IO_EXCEPTION = -1007;
    public static final int LOGOFFINPROGRESS_ERROR = -1010;
    public static final int MESSAGE_SEND_INVALID_CONTENT = -2001;
    public static final int MESSAGE_SEND_NOT_IN_THE_GROUP = -2000;
    public static final int MESSAGE_SEND_TRAFFIC_LIMIT = -2002;
    public static final int NONETWORK_ERROR = -1001;
    public static final int NO_ERROR = 0;
    public static final int UNABLE_CONNECT_TO_SERVER = -1003;
    public static final int UNAUTHORIZED = -1021;
    public static final int UNKNOWN_SERVER_ERROR = -1000;
    public static final int UNKNOW_ERROR = -999;
    public static final int USER_ALREADY_EXISTS = -1015;
    public static final int USER_REMOVED = -1023;

    public EMError() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67102946 length=8972300
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
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.EMError.<init>():void");
    }
}
