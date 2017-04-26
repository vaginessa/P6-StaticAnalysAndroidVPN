package com.baidu.location.g;

import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.Address.Builder;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.b.l;
import com.baidu.location.b.m;
import com.baidu.location.b.o;
import com.baidu.location.e.c;
import com.baidu.location.h.h;
import com.baidu.platform.comapi.location.CoordinateType;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.util.EntityUtils;

public class b implements f {
    private static SimpleDateFormat ji = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    long je = 0;
    h jf = null;
    private l jg = new l();
    com.baidu.location.h.f jh = null;
    boolean jj = false;
    a jk = null;

    class a extends m {
        final /* synthetic */ b b;

        public a(b bVar) {
            this.b = bVar;
        }

        void a(String str) {
            this.da = str;
            av();
        }

        public void au() {
        }

        public void int(boolean z) {
            this.b.jg.for(SystemClock.uptimeMillis());
            if (!z || this.c6 == null) {
                BDLocation bDLocation = new BDLocation();
                bDLocation.setLocType(63);
                c.br().try(bDLocation);
                return;
            }
            try {
                String entityUtils = EntityUtils.toString(this.c6, "utf-8");
                this.b.jk = new a(entityUtils);
                if (this.b.jj && this.b.jk.b()) {
                    bDLocation = new BDLocation();
                    bDLocation.setLongitude(this.b.jk.d());
                    bDLocation.setLatitude(this.b.jk.c());
                    bDLocation.setRadius(this.b.jk.e());
                    bDLocation.setLocType(BDLocation.TypeNetWorkLocation);
                    bDLocation.setLocationWhere(0);
                    bDLocation.setCoorType(CoordinateType.WGS84);
                    bDLocation.setNetworkLocationType("sky");
                    String str = this.b.jk.c;
                    String str2 = this.b.jk.e;
                    String str3 = this.b.jk.b;
                    String str4 = this.b.jk.f;
                    String str5 = this.b.jk.g;
                    Address build = new Builder().country(str).province(str2).city(str3).district(str4).street(str5).streetNumber(this.b.jk.h).build();
                    bDLocation.setTime(b.ji.format(new Date()));
                    bDLocation.setOperators(com.baidu.location.h.c.a().cS());
                    if (com.baidu.location.e.l.cg().cd()) {
                        bDLocation.setDirection(com.baidu.location.e.l.cg().ci());
                    }
                    if (k.cf.equals("all")) {
                        bDLocation.setAddr(build);
                    }
                    if (this.b.jk.a()) {
                        double[] dArr = Jni.if(this.b.jk.d(), this.b.jk.c(), "gps2gcj");
                        bDLocation.setCoorType(CoordinateType.GCJ02);
                        bDLocation.setLongitude(dArr[0]);
                        bDLocation.setLatitude(dArr[1]);
                    }
                    Message obtainMessage = com.baidu.location.e.m.bb().fO.obtainMessage(21);
                    obtainMessage.obj = bDLocation;
                    obtainMessage.sendToTarget();
                    this.b.jg.int(SystemClock.uptimeMillis());
                    this.b.jg.char(l.c0);
                    if (this.b.jf != null) {
                        this.b.jg.else(this.b.jf.dz());
                    }
                    o.aY().if(this.b.jg);
                } else if (this.b.jj && !this.b.jk.b()) {
                    bDLocation = new BDLocation();
                    bDLocation.setLocType(BDLocation.TypeServerError);
                    c.br().try(bDLocation);
                    this.b.jg.int(SystemClock.uptimeMillis());
                    this.b.jg.char(l.cX);
                    if (this.b.jf != null) {
                        this.b.jg.else(this.b.jf.dz());
                    }
                    o.aY().if(this.b.jg);
                }
            } catch (Exception e) {
            }
        }
    }

    public b(h hVar, com.baidu.location.h.f fVar, boolean z) {
        this.jf = hVar;
        this.jh = fVar;
        this.jj = z;
        this.jg.aj();
        long uptimeMillis = SystemClock.uptimeMillis();
        this.jg.do(uptimeMillis);
        this.jg.if(uptimeMillis);
    }

    public void cB() {
        String str = null;
        StringBuffer stringBuffer = new StringBuffer(1024);
        String i = (this.jh == null || this.jh.dn() <= 1) ? null : this.jh.i(15);
        if (this.jf != null && this.jf.du()) {
            str = this.jf.dy();
        }
        if (i != null || str != null) {
            stringBuffer.append("<LocationRQ xmlns=\"http://skyhookwireless.com/wps/2005\"\nversion=\"2.21\"\nstreet-address-lookup=\"full\">\n<authentication version=\"2.2\">\n<key key=\"" + Jni.dI() + "\"\n" + "username=\"BAIDULOC\"/></authentication>\n");
            if (i != null) {
                stringBuffer.append(i);
            }
            if (str != null) {
                stringBuffer.append(str);
            }
            stringBuffer.append("</LocationRQ>");
            new a(this).a(stringBuffer.toString());
            this.je = System.currentTimeMillis();
        }
    }
}
