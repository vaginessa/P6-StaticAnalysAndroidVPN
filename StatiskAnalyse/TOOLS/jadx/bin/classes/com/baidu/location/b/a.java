package com.baidu.location.b;

public class a {
    private String a;
    private String do;
    private boolean if;

    public a(String str, boolean z, String str2) {
        this.do = str;
        this.if = z;
        this.a = str2;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.if = z;
    }

    public boolean a() {
        return this.if;
    }

    public String do() {
        return this.do;
    }

    public String if() {
        return this.a;
    }

    public void if(String str) {
        this.do = str;
    }

    public String toString() {
        return "SDCardInfo [label=" + this.a + ", mountPoint=" + this.do + ", isRemoveable=" + this.if + "]";
    }
}
