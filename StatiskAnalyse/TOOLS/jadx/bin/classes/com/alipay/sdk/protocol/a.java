package com.alipay.sdk.protocol;

import android.text.TextUtils;
import gov.nist.core.Separators;
import org.json.JSONObject;

public enum a {
    WapPay("js://wappay"),
    DownLoad("js://download"),
    Submit("submit"),
    Confirm("js://confirm"),
    Alert("js://alert"),
    Update("js://update"),
    Exit("js://exit");
    
    private String h;
    private String i;
    private String j;
    private JSONObject k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private String t;
    private JSONObject u;

    private a(String str) {
        this.h = str;
    }

    public static a[] a(b bVar) {
        if (bVar != null) {
            Object obj = bVar.a;
            String[] split = !TextUtils.isEmpty(obj) ? obj.split(Separators.SEMICOLON) : null;
            if (split == null) {
                return new a[]{Submit};
            }
            a[] aVarArr = new a[split.length];
            int length = split.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = split[i];
                a aVar = Submit;
                for (a aVar2 : values()) {
                    if (str.startsWith(aVar2.h)) {
                        break;
                    }
                }
                a aVar22 = aVar;
                aVar22.i = str;
                if (TextUtils.isEmpty(bVar.b)) {
                    bVar.b = com.alipay.sdk.cons.a.b;
                }
                aVar22.j = bVar.b;
                aVar22.k = bVar.a();
                aVar22.l = bVar.c;
                aVar22.m = bVar.d;
                aVar22.n = bVar.e;
                aVar22.o = bVar.f;
                aVar22.p = bVar.g;
                aVar22.q = bVar.h;
                aVar22.r = bVar.i;
                aVar22.s = bVar.j;
                aVar22.t = bVar.k;
                aVar22.u = bVar.l;
                aVarArr[i2] = aVar22;
                i++;
                i2++;
            }
            return aVarArr;
        }
        return new a[]{Submit};
    }

    private static String[] a(String str) {
        return !TextUtils.isEmpty(str) ? str.split(Separators.SEMICOLON) : null;
    }

    private JSONObject m() {
        return this.k;
    }

    public final JSONObject a() {
        return this.u;
    }

    public final String b() {
        return this.t;
    }

    public final String c() {
        return this.r;
    }

    public final String d() {
        return this.s;
    }

    public final String e() {
        return this.i;
    }

    public final String f() {
        return this.j;
    }

    public final String g() {
        return this.m;
    }

    public final String h() {
        return this.n;
    }

    public final boolean i() {
        return this.o;
    }

    public final boolean j() {
        return this.p;
    }

    public final boolean k() {
        return this.q;
    }

    public final String l() {
        return this.l;
    }
}
