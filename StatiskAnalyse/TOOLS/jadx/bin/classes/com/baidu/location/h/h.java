package com.baidu.location.h;

import com.baidu.location.b.f;
import com.baidu.location.b.g;
import java.util.Locale;

public class h implements f {
    public int kp;
    private boolean kq;
    public long kr;
    public int ks;
    public int kt;
    public int ku;
    public char kv;
    public int kw;
    public int kx;
    public int ky;

    public h() {
        this.kp = -1;
        this.kt = -1;
        this.kw = -1;
        this.kx = -1;
        this.ky = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.ks = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.kr = 0;
        this.ku = -1;
        this.kv = '\u0000';
        this.kq = false;
        this.kr = System.currentTimeMillis();
    }

    public h(int i, int i2, int i3, int i4, int i5, char c) {
        this.kp = -1;
        this.kt = -1;
        this.kw = -1;
        this.kx = -1;
        this.ky = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.ks = ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.kr = 0;
        this.ku = -1;
        this.kv = '\u0000';
        this.kq = false;
        this.kp = i;
        this.kt = i2;
        this.kw = i3;
        this.kx = i4;
        this.ku = i5;
        this.kv = c;
        this.kr = System.currentTimeMillis();
    }

    public h(h hVar) {
        this(hVar.kp, hVar.kt, hVar.kw, hVar.kx, hVar.ku, hVar.kv);
    }

    public boolean case(h hVar) {
        return this.kp == hVar.kp && this.kt == hVar.kt && this.kx == hVar.kx && this.kw == hVar.kw;
    }

    public boolean dA() {
        return this.kp > -1 && this.kt > -1 && this.kx > -1 && this.kw > -1;
    }

    public String dB() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(String.format(Locale.CHINA, "cell=%d|%d|%d|%d:%d", new Object[]{Integer.valueOf(this.kw), Integer.valueOf(this.kx), Integer.valueOf(this.kp), Integer.valueOf(this.kt), Integer.valueOf(this.ku)}));
        return stringBuffer.toString();
    }

    public String dC() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append(this.kt + 23);
        stringBuffer.append("H");
        stringBuffer.append(this.kp + 45);
        stringBuffer.append("K");
        stringBuffer.append(this.kx + 54);
        stringBuffer.append("Q");
        stringBuffer.append(this.kw + g.a);
        return stringBuffer.toString();
    }

    public boolean dD() {
        return this.kp > -1 && this.kt > -1 && this.kx == -1 && this.kw == -1;
    }

    public void dt() {
        this.kq = true;
    }

    public boolean du() {
        return this.kp > -1 && this.kt > 0;
    }

    public int dv() {
        return (this.kw <= 0 || !du()) ? 2 : (this.kw == 460 || this.kw == 454 || this.kw == 455 || this.kw == 466) ? 1 : 0;
    }

    public boolean dw() {
        return System.currentTimeMillis() - this.kr < 3000;
    }

    public boolean dx() {
        return this.kp == -1 && this.kt == -1 && this.kx == -1 && this.kw == -1;
    }

    public String dy() {
        if (!du()) {
            return null;
        }
        return String.format(Locale.CHINA, "<cell-tower>\n<mcc>%d</mcc><mnc>%d</mnc><lac>%d</lac><ci>%d</ci><rssi>%d</rssi></cell-tower>", new Object[]{Integer.valueOf(this.kw), Integer.valueOf(this.kx), Integer.valueOf(this.kp), Integer.valueOf(this.kt), Integer.valueOf(this.ku)});
    }

    public String dz() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(this.kv);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(this.kw), Integer.valueOf(this.kx), Integer.valueOf(this.kp), Integer.valueOf(this.kt), Integer.valueOf(this.ku)}));
        if (this.kq) {
            stringBuffer.append("&newcl=1");
        }
        return stringBuffer.toString();
    }
}
