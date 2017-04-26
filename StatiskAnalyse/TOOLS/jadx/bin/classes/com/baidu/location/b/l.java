package com.baidu.location.b;

import com.baidu.location.e.c;
import com.baidu.location.h.b;
import com.baidu.location.h.e;
import java.util.Locale;

public class l implements f {
    public static final String c0 = "skys";
    public static final String c2 = "ons";
    public static final String cV = "onf";
    public static final String cW = "off";
    public static final String cX = "skyf";
    public static final String cZ = "ofs";
    private String c1 = null;
    private long c3 = 0;
    private int c4 = 0;
    private long cR = 0;
    private String cS = null;
    private long cT = 0;
    private String cU = null;
    private long cY = 0;

    public void aj() {
        this.cT = 0;
        this.c3 = 0;
        this.cR = 0;
        this.cY = 0;
        this.c4 = 0;
        this.c1 = null;
        this.cU = null;
        this.cS = null;
    }

    public String ak() {
        StringBuffer stringBuffer = new StringBuffer();
        if (e.dg().db()) {
            this.c1 = "&cn=32";
        } else {
            this.c1 = String.format(Locale.CHINA, "&cn=%d", new Object[]{Integer.valueOf(b.cW().cR())});
        }
        stringBuffer.append(this.c1);
        stringBuffer.append(String.format(Locale.CHINA, "&fir=%d&tim=%d&dsc=%d&det=%d&ded=%d&typ=%s", new Object[]{Integer.valueOf(this.c4), Long.valueOf(this.cT), Long.valueOf(this.c3 - this.cT), Long.valueOf(this.cR - this.c3), Long.valueOf(this.cY - this.cR), this.cU}));
        if (this.cS != null) {
            stringBuffer.append(this.cS);
        }
        stringBuffer.append(c.N().do(false));
        stringBuffer.append(c.br().bu());
        return stringBuffer.toString();
    }

    public void char(String str) {
        this.cU = str;
    }

    public void do(long j) {
        this.cT = j;
    }

    public void else(String str) {
        if (this.cS == null) {
            this.cS = str;
            return;
        }
        this.cS = String.format("%s%s", new Object[]{this.cS, str});
    }

    public void for(long j) {
        this.cR = j;
    }

    public void for(boolean z) {
        if (z) {
            this.c4 = 1;
        } else {
            this.c4 = 0;
        }
    }

    public void if(long j) {
        this.c3 = j;
    }

    public void int(long j) {
        this.cY = j;
    }
}
