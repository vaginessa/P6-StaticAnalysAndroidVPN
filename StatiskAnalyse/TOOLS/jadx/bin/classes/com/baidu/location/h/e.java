package com.baidu.location.h;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.baidu.location.b.f;
import com.baidu.location.e.m;
import com.baidu.location.e.o;
import com.baidu.mapapi.map.WeightedLatLng;
import gov.nist.core.Separators;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class e extends k implements f {
    public static final long j4 = 3000;
    public static final int j5 = 15;
    public static long j7 = 0;
    public static final long ka = 3000;
    public static final long kc = 5000;
    private static e ke = null;
    private boolean j6 = true;
    private f j8 = null;
    private Object j9 = null;
    private long kb = 0;
    private WifiManager kd = null;
    private Method kf = null;
    private boolean kg = false;
    private long kh = 0;
    private a ki = null;

    private class a extends BroadcastReceiver {
        final /* synthetic */ e a;

        private a(e eVar) {
            this.a = eVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                e.j7 = System.currentTimeMillis() / 1000;
                this.a.df();
                m.bb().ba();
                if (System.currentTimeMillis() - com.baidu.location.e.a.for() <= e.kc) {
                    o.do(com.baidu.location.e.a.a(), this.a.c8(), com.baidu.location.e.a.if(), com.baidu.location.e.a.do());
                }
            }
        }
    }

    private e() {
    }

    private void df() {
        if (this.kd != null) {
            try {
                f fVar = new f(this.kd.getScanResults(), this.kb);
                if (this.j8 == null || !fVar.new(this.j8)) {
                    this.j8 = fVar;
                }
            } catch (Exception e) {
            }
        }
    }

    public static e dg() {
        if (ke == null) {
            ke = new e();
        }
        return ke;
    }

    public static double if(f fVar, f fVar2) {
        if (fVar == null || fVar2 == null) {
            return 0.0d;
        }
        List list = fVar.km;
        List list2 = fVar2.km;
        if (list == list2) {
            return WeightedLatLng.DEFAULT_INTENSITY;
        }
        if (list == null || list2 == null) {
            return 0.0d;
        }
        int size = list.size();
        int size2 = list2.size();
        float f = (float) (size + size2);
        if (size == 0 && size2 == 0) {
            return WeightedLatLng.DEFAULT_INTENSITY;
        }
        if (size == 0 || size2 == 0) {
            return 0.0d;
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            String str = ((ScanResult) list.get(i)).BSSID;
            if (str == null) {
                i3 = i2;
            } else {
                for (int i4 = 0; i4 < size2; i4++) {
                    if (str.equals(((ScanResult) list2.get(i4)).BSSID)) {
                        i3 = i2 + 1;
                        break;
                    }
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return f <= 0.0f ? 0.0d : ((double) i2) / ((double) f);
    }

    public static boolean if(f fVar, f fVar2, float f) {
        if (fVar == null || fVar2 == null) {
            return false;
        }
        List list = fVar.km;
        List list2 = fVar2.km;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        float f2 = (float) (size + size2);
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            String str = ((ScanResult) list.get(i)).BSSID;
            if (str == null) {
                i3 = i2;
            } else {
                for (int i4 = 0; i4 < size2; i4++) {
                    if (str.equals(((ScanResult) list2.get(i4)).BSSID)) {
                        i3 = i2 + 1;
                        break;
                    }
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return ((float) (i2 * 2)) >= f2 * f;
    }

    public static boolean if(List list, List list2, float f) {
        if (list == null || list2 == null) {
            return false;
        }
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null) {
            return false;
        }
        int size = list.size();
        int size2 = list2.size();
        float f2 = (float) (size + size2);
        if (size == 0 && size2 == 0) {
            return true;
        }
        if (size == 0 || size2 == 0) {
            return false;
        }
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            String str = ((ScanResult) list.get(i)).BSSID;
            if (str == null) {
                i3 = i2;
            } else {
                for (int i4 = 0; i4 < size2; i4++) {
                    if (str.equals(((ScanResult) list2.get(i4)).BSSID)) {
                        i3 = i2 + 1;
                        break;
                    }
                }
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return ((float) (i2 * 2)) >= f2 * f;
    }

    public boolean D(String str) {
        return super.D(str);
    }

    public boolean c0() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.kh <= kc) {
            return false;
        }
        this.kh = currentTimeMillis;
        return c5();
    }

    public boolean c1() {
        return this.kd.isWifiEnabled() && 3 == this.kd.getWifiState();
    }

    public boolean c2() {
        boolean z = false;
        if (this.kd != null) {
            try {
                z = this.kd.isScanAlwaysAvailable();
            } catch (NoSuchMethodError e) {
            }
        }
        return z;
    }

    public void c3() {
        super.c3();
    }

    public f c4() {
        if (this.kd != null) {
            try {
                return new f(this.kd.getScanResults(), this.kb);
            } catch (Exception e) {
            }
        }
        return new f(null, 0);
    }

    public boolean c5() {
        return (this.kd != null && System.currentTimeMillis() - this.kb > 3000) ? da() : false;
    }

    public synchronized void c6() {
        if (!this.kg) {
            if (com.baidu.location.f.isServing) {
                this.kd = (WifiManager) com.baidu.location.f.getServiceContext().getSystemService("wifi");
                this.ki = new a();
                try {
                    com.baidu.location.f.getServiceContext().registerReceiver(this.ki, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                } catch (Exception e) {
                }
                this.kg = true;
                try {
                    Field declaredField = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
                    if (declaredField != null) {
                        declaredField.setAccessible(true);
                        this.j9 = declaredField.get(this.kd);
                        this.j9.getClass();
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    public String c7() {
        String str = null;
        try {
            WifiInfo connectionInfo = this.kd.getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        } catch (Exception e) {
        }
        return str;
    }

    public f c8() {
        return (this.j8 == null || !this.j8.ds()) ? c4() : this.j8;
    }

    public String c9() {
        if (this.kd == null) {
            return null;
        }
        WifiInfo connectionInfo = this.kd.getConnectionInfo();
        if (connectionInfo == null) {
            return null;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            if (bssid != null) {
                bssid = bssid.replace(Separators.COLON, "");
                if ("000000000000".equals(bssid) || "".equals(bssid)) {
                    return null;
                }
            }
            bssid = null;
            return bssid;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean da() {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Exception block dominator not found, method:com.baidu.location.h.e.da():boolean. bs: [B:12:0x0020, B:21:0x0050]
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:86)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r7 = this;
        r1 = 1;
        r0 = 0;
        r2 = r7.kd;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2 = r2.isWifiEnabled();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 != 0) goto L_0x0018;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x000a:
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r3 = 17;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 <= r3) goto L_0x003a;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x0010:
        r2 = r7.kd;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2 = r2.isScanAlwaysAvailable();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 == 0) goto L_0x003a;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x0018:
        r2 = r7.kf;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 == 0) goto L_0x0050;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x001c:
        r2 = r7.j9;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        if (r2 == 0) goto L_0x0050;
    L_0x0020:
        r2 = r7.kf;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r3 = r7.j9;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r4 = 1;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r5 = 0;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r6 = r7.j6;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r6 = java.lang.Boolean.valueOf(r6);	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r4[r5] = r6;	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
        r2.invoke(r3, r4);	 Catch:{ Exception -> 0x003b, NoSuchMethodError -> 0x0042 }
    L_0x0033:
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r7.kb = r2;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r0 = r1;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x003a:
        return r0;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
    L_0x003b:
        r2 = move-exception;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2 = r7.kd;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2.startScan();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        goto L_0x0033;
    L_0x0042:
        r0 = move-exception;
        r0 = r7.kd;
        r0.startScan();
        r2 = java.lang.System.currentTimeMillis();
        r7.kb = r2;
        r0 = r1;
        goto L_0x003a;
    L_0x0050:
        r2 = r7.kd;	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        r2.startScan();	 Catch:{ NoSuchMethodError -> 0x0042, Exception -> 0x0056 }
        goto L_0x0033;
    L_0x0056:
        r1 = move-exception;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.h.e.da():boolean");
    }

    public boolean db() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        } catch (Exception e) {
            return false;
        }
    }

    public int dc() {
        if (this.kd == null) {
            return -1;
        }
        WifiInfo connectionInfo = this.kd.getConnectionInfo();
        if (connectionInfo == null) {
            return -1;
        }
        try {
            String bssid = connectionInfo.getBSSID();
            int rssi = connectionInfo.getRssi();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (bssid != null) {
                bssid = bssid.replace(Separators.COLON, "");
                if ("000000000000".equals(bssid) || "".equals(bssid)) {
                    return -1;
                }
            }
            return rssi;
        } catch (Exception e) {
            return -1;
        }
    }

    public synchronized void dd() {
        if (this.kg) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.ki);
                j7 = 0;
            } catch (Exception e) {
            }
            this.ki = null;
            this.kd = null;
            this.kg = false;
        }
    }

    public f de() {
        return (this.j8 == null || !this.j8.dp()) ? c4() : this.j8;
    }

    public f do(List list) {
        return super.do(list);
    }
}
