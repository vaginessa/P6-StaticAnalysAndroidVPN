package com.easemob;

public interface EMCallBack {
    public static final int ERROR_EXCEPTION = -1;
    public static final int ERROR_EXCEPTION_CONNECT_TIMER_OUT = -1004;
    public static final int ERROR_EXCEPTION_DNS_ERROR = -1002;
    public static final int ERROR_EXCEPTION_ENCRYPTION_ERROR = -1009;
    public static final int ERROR_EXCEPTION_FILE_NOT_FOUND = -1012;
    public static final int ERROR_EXCEPTION_INVALID_CERTIFICATE = -1008;
    public static final int ERROR_EXCEPTION_INVALID_FILE = -1011;
    public static final int ERROR_EXCEPTION_INVALID_KEYSTORE = -1006;
    public static final int ERROR_EXCEPTION_INVALID_PASSWORD_USERNAME = -1005;
    public static final int ERROR_EXCEPTION_IO_EXCEPTION = -1007;
    public static final int ERROR_EXCEPTION_LOGOFFINPROGRESS_ERROR = -1010;
    public static final int ERROR_EXCEPTION_NONETWORK_ERROR = -1001;
    public static final int ERROR_EXCEPTION_NO_ERROR = 0;
    public static final int ERROR_EXCEPTION_UNABLE_CONNECT_TO_SERVER = -1003;
    public static final int ERROR_EXCEPTION_UNKNOWN_SERVER_ERROR = -1000;
    public static final int ERROR_FILE_NOT_FOUND = -3;
    public static final int ERROR_SEND = -2;
    public static final Object data = null;

    void onError(int i, String str);

    void onProgress(int i, String str);

    void onSuccess();
}
