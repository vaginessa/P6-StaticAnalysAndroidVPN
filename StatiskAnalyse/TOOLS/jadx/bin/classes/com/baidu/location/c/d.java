package com.baidu.location.c;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.baidu.location.BDLocation;
import com.baidu.location.b.o;
import com.baidu.location.f;
import com.baidu.location.h.h;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class d implements com.baidu.location.b.b {
    static final String ab = ae;
    private static final String ad = "http://180.149.144.31:8091/offline_loc";
    private static final String ae = "com.baidu.lbs.offlinelocationprovider";
    private static final String ag = "ofld";
    public static final String ai = "1";
    static final String ak = am;
    private static final String am = "http://loc.map.baidu.com/offline_loc";
    private static Context an = null;
    public static final String ao = "oflv2";
    public static final String ap = "oflv1";
    private static d aq = null;
    private static final String ar = "content://%s/";
    private static final String as = "com.baidu.lbs.offlinelocationprovider.debug";
    private static final int at = 2000;
    private final j ac;
    private final File af;
    private final k ah;
    private final q aj;
    private final a al;

    private enum a {
        NETWORK_UNKNOWN,
        NETWORK_WIFI,
        NETWORK_2G,
        NETWORK_3G,
        NETWORK_4G
    }

    public enum b {
        NEED_TO_LOG,
        NO_NEED_TO_LOG
    }

    public enum c {
        IS_MIX_MODE,
        IS_NOT_MIX_MODE
    }

    private d() {
        File file;
        try {
            file = new File(an.getFilesDir(), ag);
            try {
                if (!file.exists()) {
                    file.mkdir();
                }
            } catch (Exception e) {
            }
        } catch (Exception e2) {
            file = null;
        }
        this.af = file;
        this.al = new a(this);
        this.aj = new q(this.al.a());
        this.ac = new j(this, this.al.a());
        this.ah = new k(this, this.al.a(), this.ac.n());
    }

    private BDLocation do(String[] strArr) {
        BDLocation bDLocation = new BDLocation();
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        bDLocation = (FutureTask) newSingleThreadExecutor.submit(new i(this, strArr));
        try {
            bDLocation = (BDLocation) bDLocation.get(2000, TimeUnit.MILLISECONDS);
            return bDLocation;
        } catch (InterruptedException e) {
            bDLocation.cancel(true);
            return null;
        } catch (ExecutionException e2) {
            bDLocation.cancel(true);
            return null;
        } catch (TimeoutException e3) {
            o.aY().j("offlineLocation Timeout Exception!");
            bDLocation.cancel(true);
            return null;
        } finally {
            newSingleThreadExecutor.shutdown();
        }
    }

    public static void if(Context context) {
        if (an == null) {
            an = context;
            com.baidu.location.b.c.N().do(an);
        }
    }

    private static final Uri int(String str) {
        return Uri.parse(String.format(ar, new Object[]{str}));
    }

    private void int() {
        this.ac.g();
    }

    public static d try() {
        if (aq == null) {
            synchronized (d.class) {
                if (aq == null) {
                    if (an == null) {
                        if(f.getServiceContext());
                    }
                    aq = new d();
                }
            }
        }
        aq.int();
        return aq;
    }

    private boolean void() {
        ProviderInfo providerInfo;
        String packageName = an.getPackageName();
        ProviderInfo resolveContentProvider = an.getPackageManager().resolveContentProvider(ab, 0);
        if (resolveContentProvider == null) {
            String[] o = this.ac.o();
            providerInfo = resolveContentProvider;
            for (String resolveContentProvider2 : o) {
                providerInfo = an.getPackageManager().resolveContentProvider(resolveContentProvider2, 0);
                if (providerInfo != null) {
                    break;
                }
            }
        } else {
            providerInfo = resolveContentProvider;
        }
        return providerInfo == null ? true : packageName.equals(providerInfo.packageName);
    }

    public double byte() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) an.getSystemService("connectivity")).getActiveNetworkInfo();
        a aVar = a.NETWORK_UNKNOWN;
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                aVar = a.NETWORK_WIFI;
            }
            if (activeNetworkInfo.getType() == 0) {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11) {
                    aVar = a.NETWORK_2G;
                } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || subtype == 15) {
                    aVar = a.NETWORK_3G;
                } else if (subtype == 13) {
                    aVar = a.NETWORK_4G;
                }
            }
        }
        return aVar == a.NETWORK_UNKNOWN ? this.ac.b() : aVar == a.NETWORK_WIFI ? this.ac.c() : aVar == a.NETWORK_2G ? this.ac.d() : aVar == a.NETWORK_3G ? this.ac.e() : aVar == a.NETWORK_4G ? this.ac.f() : 0.0d;
    }

    public boolean case() {
        return this.ac.j();
    }

    public Context char() {
        return an;
    }

    File d() {
        return this.af;
    }

    public boolean do(String str) {
        return this.ac.b(str);
    }

    public boolean e() {
        return this.ac.i();
    }

    public Cursor for(String[] strArr) {
        return this.al.a(new a(strArr));
    }

    public boolean goto() {
        return this.ac.k();
    }

    public void h() {
    }

    public boolean i() {
        return this.ac.m();
    }

    public long if(String str) {
        return this.ac.a(str);
    }

    public BDLocation if(h hVar, com.baidu.location.h.f fVar, BDLocation bDLocation, c cVar, b bVar) {
        int a;
        String str;
        if (cVar == c.IS_MIX_MODE) {
            a = this.ac.a();
            str = com.baidu.location.b.c.N().O() + "&mixMode=1";
        } else {
            str = com.baidu.location.b.c.N().O();
            a = 0;
        }
        String[] a2 = h.a(hVar, fVar, bDLocation, str, (bVar == b.NEED_TO_LOG ? Boolean.valueOf(true) : Boolean.valueOf(false)).booleanValue(), a);
        BDLocation bDLocation2 = null;
        if (a2.length > 0) {
            bDLocation2 = do(a2);
            if (bDLocation2 == null || bDLocation2.getLocType() != 67) {
                return bDLocation2;
            }
        }
        return bDLocation2;
    }

    q j() {
        return this.aj;
    }

    public void k() {
        this.aj.a();
    }

    k l() {
        return this.ah;
    }

    public boolean long() {
        return this.ac.h();
    }

    public boolean m() {
        return this.ac.l();
    }

    public void n() {
        if (void()) {
            this.al.b();
        }
    }

    j new() {
        return this.ac;
    }
}
