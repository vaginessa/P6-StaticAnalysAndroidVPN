package com.baidu.location.e;

import android.os.Bundle;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.d;
import com.baidu.location.b.f;
import com.baidu.location.b.g;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import com.baidu.location.c.d.b;
import com.baidu.location.h.c;
import com.baidu.location.h.h;
import com.baidu.location.h.l;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

class w implements f {
    private static w b;
    private com.baidu.location.h.f c = null;
    private h d = null;
    private long e = 0;
    private final long f = 1000;
    private String g = null;

    class a extends m {
        final /* synthetic */ w b;
        private String c;

        a(w wVar) {
            this.b = wVar;
            this.c = null;
            this.c7 = new ArrayList();
        }

        public void a(String str) {
            this.c = str;
            ao();
        }

        public void au() {
            this.dg = 1;
            this.c5 = k.Z();
            String S = d.U().S();
            if (c8 == g.for || c8 == g.o) {
                this.c5 = "http://" + S + "/sdk.php";
            }
            S = Jni.H(this.c);
            this.c = null;
            this.c7.add(new BasicNameValuePair("bloc", S));
        }

        public void int(boolean z) {
            if (!z || this.c6 == null) {
                boolean z2 = k.bX;
                k.bX = true;
                if (com.baidu.location.c.d.try().long() && com.baidu.location.c.d.try().e()) {
                    BDLocation bDLocation = com.baidu.location.c.d.try().if(c.a().cO(), l.a().c8(), null, com.baidu.location.c.d.c.IS_NOT_MIX_MODE, b.NEED_TO_LOG);
                    if (bDLocation == null || bDLocation.getLocType() == 67) {
                        this.b.a(null);
                    } else {
                        this.b.a(bDLocation.getLocationDescribe());
                    }
                } else {
                    this.b.a(null);
                }
                if (!z2) {
                    k.bX = false;
                }
            } else {
                try {
                    this.b.a(new BDLocation(EntityUtils.toString(this.c6, "utf-8")).getLocationDescribe());
                } catch (Exception e) {
                    this.b.a(null);
                }
            }
            if (this.c7 != null) {
                this.c7.clear();
            }
        }
    }

    private w() {
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (b == null) {
                b = new w();
            }
            wVar = b;
        }
        return wVar;
    }

    private void a(String str) {
        this.g = str;
        Bundle bundle = new Bundle();
        if (str == null || str.equals("")) {
            bundle.putByteArray("locationtag", null);
        } else {
            bundle.putByteArray("locationtag", str.getBytes());
        }
        c.br().if(bundle, 601);
    }

    private boolean a(com.baidu.location.h.f fVar) {
        com.baidu.location.h.f de = l.a().de();
        return fVar == de ? false : de == null || fVar == null || !fVar.try(de);
    }

    private boolean a(h hVar) {
        h cO = c.a().cO();
        return cO == hVar ? false : cO == null || hVar == null || !hVar.case(cO);
    }

    public void b() {
        if (System.currentTimeMillis() - this.e >= 1000 || this.g == null) {
            this.e = System.currentTimeMillis();
            boolean a = a(this.c);
            boolean a2 = a(this.d);
            if (a || a2 || this.g == null) {
                this.d = c.a().cO();
                this.c = l.a().de();
                StringBuffer stringBuffer = new StringBuffer(1024);
                if (this.d != null && this.d.du()) {
                    stringBuffer.append(this.d.dz());
                }
                if (this.c != null && this.c.dn() > 1) {
                    stringBuffer.append(this.c.e(15));
                }
                String cI = com.baidu.location.h.d.a().cI();
                if (cI != null) {
                    stringBuffer.append(cI);
                }
                stringBuffer.append("&sema=aptag");
                stringBuffer.append(com.baidu.location.b.c.N().do(false));
                stringBuffer.append(c.br().bu());
                new a(this).a(stringBuffer.toString());
                return;
            }
            a(this.g);
            return;
        }
        a(this.g);
    }
}
