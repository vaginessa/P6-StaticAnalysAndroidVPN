package com.baidu.location.h;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.GpsStatus.NmeaListener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.e.h;
import com.baidu.location.e.o;
import com.external.imagezoom.ImageViewTouchBase;
import com.tencent.open.yyb.TitleBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;

public class a extends g implements f {
    private static int jH = 0;
    private static final int jv = 3000;
    private static String jy = null;
    private static a jz = null;
    private int jA;
    private final int jB = 1;
    private long jC = 0;
    private c jD = null;
    private Handler jE = null;
    private Context jF;
    private boolean jG = false;
    private b jI = null;
    private Location jJ;
    private final long jK = 1000;
    private LocationManager jL = null;
    private HashMap jl;
    private boolean jm = false;
    private final long jn = 9000;
    private final int jo = 2;
    private int jp;
    private long jq = 0;
    private String jr = null;
    private final int js = 4;
    private boolean jt = false;
    private final int ju = 3;
    private GpsStatus jw;
    private a jx = null;

    private class a implements Listener, NmeaListener {
        long a;
        final /* synthetic */ a b;
        private long c;
        private final int d;
        private boolean e;
        private List f;
        private String g;
        private String h;
        private String i;

        private a(a aVar) {
            this.b = aVar;
            this.a = 0;
            this.c = 0;
            this.d = 400;
            this.e = false;
            this.f = new ArrayList();
            this.g = null;
            this.h = null;
            this.i = null;
        }

        public void a(String str) {
            if (System.currentTimeMillis() - this.c > 400 && this.e && this.f.size() > 0) {
                try {
                    m mVar = new m(this.f, this.g, this.h, this.i);
                    if (mVar.a()) {
                        k.b1 = this.b.if(mVar, this.b.jp);
                        if (k.b1 > 0) {
                            a.jy = String.format(Locale.CHINA, "&nmea=%.1f|%.1f&g_tp=%d", new Object[]{Double.valueOf(mVar.c()), Double.valueOf(mVar.b()), Integer.valueOf(k.b1)});
                        }
                    } else {
                        k.b1 = 0;
                    }
                } catch (Exception e) {
                    k.b1 = 0;
                }
                this.f.clear();
                this.i = null;
                this.h = null;
                this.g = null;
                this.e = false;
            }
            if (str.startsWith("$GPGGA")) {
                this.e = true;
                this.g = str.trim();
            } else if (str.startsWith("$GPGSV")) {
                this.f.add(str.trim());
            } else if (str.startsWith("$GPGSA")) {
                this.i = str.trim();
            }
            this.c = System.currentTimeMillis();
        }

        public void onGpsStatusChanged(int i) {
            if (this.b.jL != null) {
                switch (i) {
                    case 2:
                        this.b.char(null);
                        this.b.else(false);
                        a.jH = 0;
                        return;
                    case 4:
                        if (this.b.jt) {
                            try {
                                if (this.b.jw == null) {
                                    this.b.jw = this.b.jL.getGpsStatus(null);
                                } else {
                                    this.b.jL.getGpsStatus(this.b.jw);
                                }
                                this.b.jA = 0;
                                this.b.jp = 0;
                                this.b.jl = new HashMap();
                                int i2 = 0;
                                for (GpsSatellite gpsSatellite : this.b.jw.getSatellites()) {
                                    if (gpsSatellite.usedInFix()) {
                                        i2++;
                                        if (gpsSatellite.getSnr() >= ((float) k.bH)) {
                                            this.b.jp = this.b.jp + 1;
                                        }
                                        this.b.if(gpsSatellite, this.b.jl);
                                    }
                                }
                                a.jH = i2;
                                return;
                            } catch (Exception e) {
                                return;
                            }
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public void onNmeaReceived(long j, String str) {
            if (!this.b.jt) {
                return;
            }
            if (!com.baidu.location.e.f.bC().gz) {
                k.b1 = 0;
            } else if (str != null && !str.equals("") && str.length() >= 9 && str.length() <= 150 && this.b.cJ()) {
                this.b.jE.sendMessage(this.b.jE.obtainMessage(2, str));
            }
        }
    }

    private class b implements LocationListener {
        final /* synthetic */ a a;

        private b(a aVar) {
            this.a = aVar;
        }

        public void onLocationChanged(Location location) {
            this.a.jC = System.currentTimeMillis();
            this.a.else(true);
            this.a.char(location);
            this.a.jm = false;
        }

        public void onProviderDisabled(String str) {
            this.a.char(null);
            this.a.else(false);
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            switch (i) {
                case 0:
                    this.a.char(null);
                    this.a.else(false);
                    return;
                case 1:
                    this.a.jq = System.currentTimeMillis();
                    this.a.jm = true;
                    this.a.else(false);
                    return;
                case 2:
                    this.a.jm = false;
                    return;
                default:
                    return;
            }
        }
    }

    private class c implements LocationListener {
        final /* synthetic */ a a;
        private long b;

        private c(a aVar) {
            this.a = aVar;
            this.b = 0;
        }

        public void onLocationChanged(Location location) {
            if (!this.a.jt && location != null && location.getProvider() == "gps" && System.currentTimeMillis() - this.b >= 10000 && o.if(location, false)) {
                this.b = System.currentTimeMillis();
                this.a.jE.sendMessage(this.a.jE.obtainMessage(4, location));
            }
        }

        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }
    }

    private a() {
    }

    public static a cN() {
        if (jz == null) {
            jz = new a();
        }
        return jz;
    }

    private void case(Location location) {
        if (location != null) {
            int i = jH;
            if (i == 0) {
                try {
                    i = location.getExtras().getInt("satellites");
                } catch (Exception e) {
                }
            }
            if (i != 0 || k.cj) {
                this.jJ = location;
                if (this.jJ == null) {
                    this.jr = null;
                } else {
                    this.jJ.setTime(System.currentTimeMillis());
                    float speed = (float) (((double) this.jJ.getSpeed()) * 3.6d);
                    if (!this.jJ.hasSpeed()) {
                        speed = ImageViewTouchBase.ZOOM_INVALID;
                    }
                    i = jH;
                    if (i == 0) {
                        try {
                            i = this.jJ.getExtras().getInt("satellites");
                        } catch (Exception e2) {
                        }
                    }
                    this.jr = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", new Object[]{Double.valueOf(this.jJ.getLongitude()), Double.valueOf(this.jJ.getLatitude()), Float.valueOf(speed), Float.valueOf(this.jJ.getBearing()), Integer.valueOf(i), Long.valueOf(r2)});
                    if(this.jJ.getLongitude(), this.jJ.getLatitude(), speed);
                }
                try {
                    com.baidu.location.e.k.b8().try(this.jJ);
                } catch (Exception e3) {
                }
                if (this.jJ != null) {
                    h.bK().for(this.jJ);
                }
                if (cJ() && this.jJ != null) {
                    com.baidu.location.e.c.br().l(cF());
                    if (jH > 2 && o.if(this.jJ, true)) {
                        boolean c0 = e.dg().c0();
                        com.baidu.location.e.a.a(new h(b.cW().cO()));
                        com.baidu.location.e.a.a(System.currentTimeMillis());
                        com.baidu.location.e.a.a(new Location(this.jJ));
                        com.baidu.location.e.a.a(com.baidu.location.e.c.br().bu());
                        if (!c0) {
                            o.do(com.baidu.location.e.a.a(), null, com.baidu.location.e.a.if(), com.baidu.location.e.c.br().bu());
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.jJ = null;
    }

    private void char(Location location) {
        this.jE.sendMessage(this.jE.obtainMessage(1, location));
    }

    public static String else(Location location) {
        String str = long(location);
        return str != null ? str + jy : str;
    }

    private void else(boolean z) {
        this.jG = z;
        if (!z || !cJ()) {
        }
    }

    public static String goto(Location location) {
        String str = long(location);
        return str != null ? str + "&g_tp=0" : str;
    }

    private int if(m mVar, int i) {
        if (jH >= k.cq) {
            return 1;
        }
        if (jH <= k.b7) {
            return 4;
        }
        double c = mVar.c();
        if (c <= ((double) k.cQ)) {
            return 1;
        }
        if (c >= ((double) k.bW)) {
            return 4;
        }
        c = mVar.b();
        return c > ((double) k.ck) ? c >= ((double) k.cA) ? 4 : i < k.bJ ? i <= k.cC ? 4 : this.jl != null ? if(this.jl) : 3 : 1 : 1;
    }

    private int if(HashMap hashMap) {
        if (this.jA > 4) {
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            int i = 0;
            for (Entry value : hashMap.entrySet()) {
                int i2;
                List list = (List) value.getValue();
                if (list != null) {
                    Object obj = if(list);
                    if (obj != null) {
                        arrayList.add(obj);
                        i2 = i + 1;
                        arrayList2.add(Integer.valueOf(i));
                        i = i2;
                    }
                }
                i2 = i;
                i = i2;
            }
            if (!arrayList.isEmpty()) {
                double[] dArr;
                double[] dArr2 = new double[2];
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    dArr = (double[]) arrayList.get(i3);
                    i = ((Integer) arrayList2.get(i3)).intValue();
                    dArr[0] = dArr[0] * ((double) i);
                    dArr[1] = dArr[1] * ((double) i);
                    dArr2[0] = dArr2[0] + dArr[0];
                    dArr2[1] = dArr[1] + dArr2[1];
                }
                dArr2[0] = dArr2[0] / ((double) size);
                dArr2[1] = dArr2[1] / ((double) size);
                dArr = new(dArr2[0], dArr2[1]);
                if (dArr[0] <= ((double) k.cI)) {
                    return 1;
                }
                if (dArr[0] >= ((double) k.bQ)) {
                    return 4;
                }
            }
        }
        return 3;
    }

    private String if(GpsSatellite gpsSatellite, HashMap hashMap) {
        int floor = (int) Math.floor((double) (gpsSatellite.getAzimuth() / 6.0f));
        float elevation = gpsSatellite.getElevation();
        int floor2 = (int) Math.floor(((double) elevation) / 1.5d);
        float snr = gpsSatellite.getSnr();
        int round = Math.round(snr / 5.0f);
        int prn = gpsSatellite.getPrn();
        int i = prn >= 65 ? prn - 32 : prn;
        if (snr >= TitleBar.SHAREBTN_RIGHT_MARGIN && elevation >= PhotoViewAttacher.DEFAULT_MIN_SCALE) {
            List list = (List) hashMap.get(Integer.valueOf(round));
            if (list == null) {
                list = new ArrayList();
            }
            list.add(gpsSatellite);
            hashMap.put(Integer.valueOf(round), list);
            this.jA++;
        }
        if (floor >= 64) {
            if (floor2 < 64) {
                if (i >= 65) {
                }
            }
            return null;
        }
        if (floor2 < 64) {
            if (i >= 65) {
            }
        }
        return null;
        if (i >= 65) {
        }
        return null;
    }

    private void if(double d, double d2, float f) {
        int i = 0;
        if (com.baidu.location.e.f.bC().gv) {
            if (d >= 73.146973d && d <= 135.252686d && d2 <= 54.258807d && d2 >= 14.604847d && f <= 18.0f) {
                int i2 = (int) ((d - k.bG) * 1000.0d);
                int i3 = (int) ((k.b4 - d2) * 1000.0d);
                if (i2 <= 0 || i2 >= 50 || i3 <= 0 || i3 >= 50) {
                    String str = String.format(Locale.CHINA, "&ll=%.5f|%.5f", new Object[]{Double.valueOf(d), Double.valueOf(d2)}) + "&im=" + com.baidu.location.b.c.N().L();
                    k.cp = d;
                    k.cE = d2;
                    com.baidu.location.e.f.bC().m(str);
                } else {
                    i2 += i3 * 50;
                    i3 = i2 >> 2;
                    i2 &= 3;
                    if (k.cM) {
                        i = (k.b2[i3] >> (i2 * 2)) & 3;
                    }
                }
            }
            if (k.co != i) {
                k.co = i;
            }
        }
    }

    private void if(String str, Location location) {
        if (location != null) {
            String str2 = str + com.baidu.location.e.c.br().bu();
            boolean c0 = e.dg().c0();
            com.baidu.location.e.a.a(new h(b.cW().cO()));
            com.baidu.location.e.a.a(System.currentTimeMillis());
            com.baidu.location.e.a.a(new Location(location));
            com.baidu.location.e.a.a(str2);
            if (!c0) {
                o.do(com.baidu.location.e.a.a(), null, com.baidu.location.e.a.if(), str2);
            }
        }
    }

    public static boolean if(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z && ((k.co == 3 || !com.baidu.location.b.h.W().for(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float distanceTo = location2.distanceTo(location);
        return speed > k.cg ? distanceTo > k.cx : speed > k.ch ? distanceTo > k.cO : distanceTo > 5.0f;
    }

    private double[] if(List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        double[] dArr = new double[2];
        for (GpsSatellite gpsSatellite : list) {
            if (gpsSatellite != null) {
                double[] dArr2 = int((double) (90.0f - gpsSatellite.getElevation()), (double) gpsSatellite.getAzimuth());
                dArr[0] = dArr[0] + dArr2[0];
                dArr[1] = dArr[1] + dArr2[1];
            }
        }
        int size = list.size();
        dArr[0] = dArr[0] / ((double) size);
        dArr[1] = dArr[1] / ((double) size);
        return dArr;
    }

    private double[] int(double d, double d2) {
        return new double[]{Math.sin(Math.toRadians(d2)) * d, Math.cos(Math.toRadians(d2)) * d};
    }

    public static String long(Location location) {
        float f = ImageViewTouchBase.ZOOM_INVALID;
        if (location == null) {
            return null;
        }
        float speed = (float) (((double) location.getSpeed()) * 3.6d);
        if (!location.hasSpeed()) {
            speed = ImageViewTouchBase.ZOOM_INVALID;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : ImageViewTouchBase.ZOOM_INVALID);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        if (location.hasBearing()) {
            f = location.getBearing();
        }
        return String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d", new Object[]{Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(f), Integer.valueOf(accuracy), Integer.valueOf(jH), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000)});
    }

    private double[] new(double d, double d2) {
        double d3 = 0.0d;
        if (d2 != 0.0d) {
            d3 = Math.toDegrees(Math.atan(d / d2));
        } else if (d > 0.0d) {
            d3 = 90.0d;
        } else if (d < 0.0d) {
            d3 = 270.0d;
        }
        return new double[]{Math.sqrt((d * d) + (d2 * d2)), d3};
    }

    public synchronized void cC() {
        if (com.baidu.location.f.isServing) {
            this.jF = com.baidu.location.f.getServiceContext();
            try {
                this.jL = (LocationManager) this.jF.getSystemService("location");
                this.jx = new a();
                this.jL.addGpsStatusListener(this.jx);
                this.jD = new c();
                this.jL.requestLocationUpdates("passive", 9000, 0.0f, this.jD);
            } catch (Exception e) {
            }
            this.jE = new i(this);
        }
    }

    public Location cD() {
        return this.jJ;
    }

    public boolean cE() {
        return (this.jJ == null || this.jJ.getLatitude() == 0.0d || this.jJ.getLongitude() == 0.0d) ? false : true;
    }

    public String cF() {
        if (this.jJ == null) {
            return null;
        }
        double[] dArr;
        int i;
        String str = "{\"result\":{\"time\":\"" + k.ad() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":" + "\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\"," + "\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.jJ.hasAccuracy() ? this.jJ.getAccuracy() : TitleBar.SHAREBTN_RIGHT_MARGIN);
        float speed = (float) (((double) this.jJ.getSpeed()) * 3.6d);
        if (!this.jJ.hasSpeed()) {
            speed = ImageViewTouchBase.ZOOM_INVALID;
        }
        double[] dArr2 = new double[2];
        if (com.baidu.location.b.h.W().for(this.jJ.getLongitude(), this.jJ.getLatitude())) {
            dArr2 = Jni.if(this.jJ.getLongitude(), this.jJ.getLatitude(), "gps2gcj");
            if (dArr2[0] > 0.0d || dArr2[1] > 0.0d) {
                dArr = dArr2;
                i = 1;
            } else {
                dArr2[0] = this.jJ.getLongitude();
                dArr2[1] = this.jJ.getLatitude();
                dArr = dArr2;
                i = 1;
            }
        } else {
            dArr2[0] = this.jJ.getLongitude();
            dArr2[1] = this.jJ.getLatitude();
            dArr = dArr2;
            i = 0;
        }
        String format = String.format(Locale.CHINA, str, new Object[]{Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Integer.valueOf(accuracy), Float.valueOf(this.jJ.getBearing()), Float.valueOf(speed), Integer.valueOf(jH)});
        if (i == 0) {
            format = format + ",\"in_cn\":\"0\"";
        }
        if (!this.jJ.hasAltitude()) {
            return format + "}}";
        }
        return format + String.format(Locale.CHINA, ",\"h\":%.2f}}", new Object[]{Double.valueOf(this.jJ.getAltitude())});
    }

    public synchronized void cG() {
        cK();
        if (this.jL != null) {
            try {
                if (this.jx != null) {
                    this.jL.removeGpsStatusListener(this.jx);
                }
                this.jL.removeUpdates(this.jD);
            } catch (Exception e) {
            }
            this.jx = null;
            this.jL = null;
        }
    }

    public void cH() {
        cC();
        if (!this.jt) {
            try {
                this.jI = new b();
                this.jL.requestLocationUpdates("gps", 1000, 0.0f, this.jI);
                this.jL.addNmeaListener(this.jx);
                this.jt = true;
            } catch (Exception e) {
            }
        }
    }

    public String cI() {
        return (!cJ() || this.jJ == null) ? null : long(this.jJ);
    }

    public boolean cJ() {
        if (!cE() || System.currentTimeMillis() - this.jC > 10000) {
            return false;
        }
        return (!this.jm || System.currentTimeMillis() - this.jq >= 3000) ? this.jG : true;
    }

    public void cK() {
        if (this.jt) {
            if (this.jL != null) {
                try {
                    if (this.jI != null) {
                        this.jL.removeUpdates(this.jI);
                    }
                    if (this.jx != null) {
                        this.jL.removeNmeaListener(this.jx);
                    }
                } catch (Exception e) {
                }
            }
            k.b1 = 0;
            k.co = 0;
            this.jI = null;
            this.jt = false;
            else(false);
        }
    }

    public String cL() {
        return this.jr;
    }

    public boolean cM() {
        return this.jt;
    }

    public void char(boolean z) {
        if (z) {
            cH();
        } else {
            cK();
        }
    }
}
