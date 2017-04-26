package com.baidu.location.h;

public final class c {
    public static final int a = 11;
    public static final int b = 5;
    public static final int byte = 10;
    public static final String c = "3G";
    public static final int case = 0;
    public static final int char = 8;
    public static final int d = 9;
    public static final String do = "WIFI";
    public static final int e = 1;
    public static final int else = 7;
    public static final int f = 3;
    public static final int for = 12;
    public static final String g = "unknown";
    public static final int goto = 2;
    public static final String h = "2G";
    public static final String if = "4G";
    public static final int int = 4;
    public static final int long = 14;
    public static final int new = 6;
    public static final int try = 13;
    public static final int void = 15;

    public static j a() {
        return b.cW();
    }

    public static String a(int i) {
        if (l.a().db()) {
            return do;
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return h;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return c;
            case 13:
                return if;
            default:
                return "unknown";
        }
    }
}
