package com.baidu.location.e;

import android.os.Handler;
import android.os.Message;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.d;
import com.baidu.location.b.f;
import com.baidu.location.b.g;
import com.baidu.location.b.j;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import com.baidu.location.b.o;
import com.baidu.location.h.c;
import com.baidu.location.h.h;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public abstract class b implements f {
    public static String fM = null;
    private boolean fL = false;
    private boolean fN = true;
    final Handler fO = new b(this);
    public h fP = null;
    public com.baidu.location.h.f fQ = null;

    class a extends m {
        String b;
        String c;
        final /* synthetic */ b d;

        public a(b bVar) {
            this.d = bVar;
            this.b = null;
            this.c = null;
            this.c7 = new ArrayList();
        }

        public void a(String str) {
            this.c = str;
            ao();
        }

        public void au() {
            this.c5 = k.Z();
            String S = d.U().S();
            if (c8 == g.for || c8 == g.o) {
                this.c5 = "http://" + S + "/sdk.php";
            }
            if (S != null) {
                o.aY().aV().else("&host=" + S);
            }
            S = Jni.K(this.c);
            this.c = null;
            if (this.b == null) {
                this.b = o.cn();
            }
            this.c7.add(new BasicNameValuePair("bloc", S));
            if (this.b != null) {
                this.c7.add(new BasicNameValuePair("up", this.b));
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[]{j.a(com.baidu.location.f.getServiceContext()), j.if(com.baidu.location.f.getServiceContext())}));
            if (stringBuffer.length() > 0) {
                this.c7.add(new BasicNameValuePair("ext", Jni.H(stringBuffer.toString())));
            }
            this.c7.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())})));
        }

        public void int(boolean z) {
            Message obtainMessage;
            if (this.d.fP == null || this.d.fP.dv() != 0) {
                if (!z || this.c6 == null) {
                    obtainMessage = this.d.fO.obtainMessage(63);
                    obtainMessage.obj = "HttpStatus error";
                    obtainMessage.sendToTarget();
                } else {
                    try {
                        BDLocation bDLocation;
                        String entityUtils = EntityUtils.toString(this.c6, "utf-8");
                        b.fM = entityUtils;
                        try {
                            bDLocation = new BDLocation(entityUtils);
                            bDLocation.setOperators(c.a().cS());
                            if (l.cg().cd()) {
                                bDLocation.setDirection(l.cg().ci());
                            }
                        } catch (Exception e) {
                            bDLocation = new BDLocation();
                            bDLocation.setLocType(0);
                        }
                        this.b = null;
                        if (bDLocation.getLocType() == 0 && bDLocation.getLatitude() == Double.MIN_VALUE && bDLocation.getLongitude() == Double.MIN_VALUE) {
                            obtainMessage = this.d.fO.obtainMessage(63);
                            obtainMessage.obj = "HttpStatus error";
                            obtainMessage.sendToTarget();
                        } else {
                            Message obtainMessage2 = this.d.fO.obtainMessage(21);
                            obtainMessage2.obj = bDLocation;
                            obtainMessage2.sendToTarget();
                        }
                    } catch (Exception e2) {
                        obtainMessage = this.d.fO.obtainMessage(63);
                        obtainMessage.obj = "HttpStatus error";
                        obtainMessage.sendToTarget();
                    }
                }
                if (this.c7 != null) {
                    this.c7.clear();
                }
            }
        }
    }

    public class b extends Handler {
        final /* synthetic */ b a;

        public b(b bVar) {
            this.a = bVar;
        }

        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                switch (message.what) {
                    case 21:
                        this.a.if(message);
                        return;
                    case 62:
                    case 63:
                        this.a.a6();
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public abstract void a6();

    public abstract void if(Message message);

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String k(java.lang.String r10) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 1;
        r7 = 0;
        r0 = r9.fP;
        if (r0 == 0) goto L_0x000f;
    L_0x0007:
        r0 = r9.fP;
        r0 = r0.dw();
        if (r0 != 0) goto L_0x0019;
    L_0x000f:
        r0 = com.baidu.location.h.c.a();
        r0 = r0.cO();
        r9.fP = r0;
    L_0x0019:
        r0 = r9.fQ;
        if (r0 == 0) goto L_0x0025;
    L_0x001d:
        r0 = r9.fQ;
        r0 = r0.ds();
        if (r0 != 0) goto L_0x002f;
    L_0x0025:
        r0 = com.baidu.location.h.l.a();
        r0 = r0.de();
        r9.fQ = r0;
    L_0x002f:
        r0 = com.baidu.location.h.d.a();
        r0 = r0.cJ();
        if (r0 == 0) goto L_0x0111;
    L_0x0039:
        r0 = com.baidu.location.h.d.a();
        r0 = r0.cD();
    L_0x0041:
        r2 = r9.fP;
        if (r2 == 0) goto L_0x004d;
    L_0x0045:
        r2 = r9.fP;
        r2 = r2.dx();
        if (r2 == 0) goto L_0x005c;
    L_0x004d:
        r2 = r9.fQ;
        if (r2 == 0) goto L_0x0059;
    L_0x0051:
        r2 = r9.fQ;
        r2 = r2.dn();
        if (r2 != 0) goto L_0x005c;
    L_0x0059:
        if (r0 != 0) goto L_0x005c;
    L_0x005b:
        return r1;
    L_0x005c:
        r1 = com.baidu.location.e.c.br();
        r2 = r1.bu();
        r1 = com.baidu.location.h.l.a();
        r1 = r1.db();
        if (r1 == 0) goto L_0x00d9;
    L_0x006e:
        r1 = "&cn=32";
    L_0x0070:
        r3 = r9.fN;
        if (r3 == 0) goto L_0x00f3;
    L_0x0074:
        r9.fN = r7;
        r3 = com.baidu.location.b.o.aY();
        r3 = r3.aV();
        r3.for(r8);
        r3 = com.baidu.location.h.l.a();
        r3 = r3.c7();
        r4 = android.text.TextUtils.isEmpty(r3);
        if (r4 != 0) goto L_0x00a6;
    L_0x008f:
        r4 = ":";
        r5 = "";
        r3 = r3.replace(r4, r5);
        r4 = java.util.Locale.CHINA;
        r5 = "%s&mac=%s";
        r6 = 2;
        r6 = new java.lang.Object[r6];
        r6[r7] = r1;
        r6[r8] = r3;
        r1 = java.lang.String.format(r4, r5, r6);
    L_0x00a6:
        r3 = android.os.Build.VERSION.SDK_INT;
        r4 = 17;
        if (r3 <= r4) goto L_0x00ac;
    L_0x00ac:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r1 = r3.append(r1);
        r1 = r1.append(r2);
        r1 = r1.toString();
        if (r10 == 0) goto L_0x00d0;
    L_0x00bf:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2 = r2.append(r10);
        r1 = r2.append(r1);
        r1 = r1.toString();
    L_0x00d0:
        r2 = r9.fP;
        r3 = r9.fQ;
        r1 = com.baidu.location.b.k.if(r2, r3, r0, r1, r7);
        goto L_0x005b;
    L_0x00d9:
        r1 = java.util.Locale.CHINA;
        r3 = "&cn=%d";
        r4 = new java.lang.Object[r8];
        r5 = com.baidu.location.h.c.a();
        r5 = r5.cR();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r7] = r5;
        r1 = java.lang.String.format(r1, r3, r4);
        goto L_0x0070;
    L_0x00f3:
        r3 = r9.fL;
        if (r3 != 0) goto L_0x00ac;
    L_0x00f7:
        r3 = com.baidu.location.e.o.ck();
        if (r3 == 0) goto L_0x010e;
    L_0x00fd:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r1 = r4.append(r1);
        r1 = r1.append(r3);
        r1 = r1.toString();
    L_0x010e:
        r9.fL = r8;
        goto L_0x00ac;
    L_0x0111:
        r0 = r1;
        goto L_0x0041;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.e.b.k(java.lang.String):java.lang.String");
    }
}
