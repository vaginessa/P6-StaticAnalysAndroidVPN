package com.baidu.location.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.baidu.location.f;
import com.baidu.location.f.a.a;
import com.tencent.connect.common.Constants;
import gov.nist.core.Separators;

public class c implements f {
    public static String bj = null;
    public static String bk = null;
    public static String bl = null;
    public static String bn = null;
    private static c bq = null;
    public String bm = null;
    public String bo = null;
    private boolean bp = false;

    private c() {
        if (f.getServiceContext() != null) {
            do(f.getServiceContext());
        }
    }

    public static c N() {
        if (bq == null) {
            bq = new c();
        }
        return bq;
    }

    public String K() {
        return bn != null ? L() + "|" + bn : L();
    }

    public String L() {
        return this.bm != null ? "v6.12|" + this.bm + "|" + Build.MODEL : "v6.12|" + this.bo + "|" + Build.MODEL;
    }

    public String M() {
        return "&sdk=6.12" + P();
    }

    public String O() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.bm == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.bo);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.bm);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&os=A");
        stringBuffer.append(VERSION.SDK);
        stringBuffer.append("&prod=");
        stringBuffer.append(bj + Separators.COLON + bn);
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        return stringBuffer.toString();
    }

    public String P() {
        StringBuffer stringBuffer = new StringBuffer(200);
        if (this.bm != null) {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.bm);
        } else {
            stringBuffer.append("&im=");
            stringBuffer.append(this.bo);
        }
        try {
            stringBuffer.append("&mb=");
            stringBuffer.append(Build.MODEL);
        } catch (Exception e) {
        }
        stringBuffer.append("&pack=");
        try {
            stringBuffer.append(bn);
        } catch (Exception e2) {
        }
        stringBuffer.append("&sdk=");
        stringBuffer.append(f.bi);
        return stringBuffer.toString();
    }

    public String do(boolean z) {
        return if(z, null);
    }

    public void do(Context context) {
        if (context != null && !this.bp) {
            try {
                this.bo = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e) {
                this.bo = "NULL";
            }
            try {
                this.bm = a.if(context);
            } catch (Exception e2) {
                this.bm = null;
            }
            try {
                bn = context.getPackageName();
            } catch (Exception e3) {
                bn = null;
            }
            this.bp = true;
        }
    }

    public String if(boolean z, String str) {
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&sdk=");
        stringBuffer.append(f.bi);
        if (z) {
            if (k.cf.equals("all")) {
                stringBuffer.append("&addr=all");
            }
            if (k.bX || k.ci || k.bS || k.bP) {
                stringBuffer.append("&sema=");
                if (k.bX) {
                    stringBuffer.append("aptag|");
                }
                if (k.bP) {
                    stringBuffer.append("aptagd|");
                }
                if (k.ci) {
                    stringBuffer.append("poiregion|");
                }
                if (k.bS) {
                    stringBuffer.append("regular");
                }
            }
        }
        if (z) {
            if (str == null) {
                stringBuffer.append("&coor=gcj02");
            } else {
                stringBuffer.append("&coor=");
                stringBuffer.append(str);
            }
        }
        if (this.bm == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(this.bo);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(this.bm);
        }
        stringBuffer.append("&fw=");
        stringBuffer.append(f.getFrameVersion());
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        stringBuffer.append("&os=A");
        stringBuffer.append(VERSION.SDK);
        if (z) {
            stringBuffer.append("&sv=");
            String str2 = VERSION.RELEASE;
            if (str2 != null && str2.length() > 6) {
                str2 = str2.substring(0, 6);
            }
            stringBuffer.append(str2);
        }
        return stringBuffer.toString();
    }

    public void if(String str, String str2) {
        bj = str;
        bn = str2;
    }
}
