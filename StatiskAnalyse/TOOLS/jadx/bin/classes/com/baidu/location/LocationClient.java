package com.baidu.location;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.b.f;
import com.baidu.location.b.g;
import com.baidu.location.b.j;
import com.baidu.location.e.p;
import java.util.ArrayList;
import java.util.Iterator;
import net.java.sip.communicator.impl.protocol.jabber.extensions.jingle.CandidatePacketExtension;

public final class LocationClient implements f, com.baidu.location.e.p.a {
    private static final int lF = 5;
    private static final int lG = 12;
    private static final int lI = 6;
    private static final int lJ = 2;
    private static final int lQ = 11;
    private static final int lU = 4;
    private static final int lf = 10;
    private static final String lh = "baidu_location_Client";
    private static final int lk = 1;
    private static final int lo = 1000;
    private static final int lr = 3;
    private static final int ls = 8;
    private static final int lv = 9;
    private static final int lx = 7;
    private Context lA = null;
    private boolean lB = false;
    private Messenger lC = null;
    private long lD = 0;
    private LocationClientOption lE = new LocationClientOption();
    private Boolean lH = Boolean.valueOf(true);
    private boolean lK = false;
    private long lL = 0;
    private long lM = 0;
    private ServiceConnection lN = new b(this);
    private String lO;
    private BDLocation lP = null;
    private String lR = null;
    private boolean lS = false;
    private String lT = null;
    private boolean lV = true;
    private p lW = null;
    private ArrayList lX = null;
    private boolean le = false;
    private a lg = new a();
    private boolean li = false;
    private final Object lj = new Object();
    private b ll = null;
    private Boolean lm = Boolean.valueOf(false);
    private com.baidu.location.d.a ln = null;
    private Boolean lp = Boolean.valueOf(false);
    private boolean lq = false;
    private BDLocationListener lt = null;
    private boolean lu = false;
    private boolean lw = false;
    private boolean ly;
    private final Messenger lz = new Messenger(this.lg);

    private class a extends Handler {
        final /* synthetic */ LocationClient a;

        private a(LocationClient locationClient) {
            this.a = locationClient;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.dK();
                    return;
                case 2:
                    this.a.dL();
                    return;
                case 3:
                    this.a.e(message);
                    return;
                case 4:
                    this.a.dO();
                    return;
                case 5:
                    this.a.j(message);
                    return;
                case 6:
                    this.a.d(message);
                    return;
                case 7:
                    return;
                case 8:
                    this.a.k(message);
                    return;
                case 9:
                    this.a.void(message);
                    return;
                case 10:
                    this.a.i(message);
                    return;
                case 11:
                    this.a.dM();
                    return;
                case 12:
                    this.a.dN();
                    return;
                case 21:
                    Bundle data = message.getData();
                    data.setClassLoader(BDLocation.class.getClassLoader());
                    BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
                    if (this.a.li || !this.a.lB || bDLocation.getLocType() != 66) {
                        if (this.a.li || !this.a.lB) {
                            if (!this.a.li) {
                                this.a.li = true;
                            }
                            this.a.if(message, 21);
                            return;
                        }
                        this.a.li = true;
                        return;
                    }
                    return;
                case 26:
                    this.a.if(message, 26);
                    return;
                case 27:
                    this.a.h(message);
                    return;
                case 54:
                    if (this.a.lE.location_change_notify) {
                        this.a.le = true;
                        return;
                    }
                    return;
                case 55:
                    if (this.a.lE.location_change_notify) {
                        this.a.le = false;
                        return;
                    }
                    return;
                case g.I /*701*/:
                    this.a.byte((BDLocation) message.obj);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ LocationClient a;

        private b(LocationClient locationClient) {
            this.a = locationClient;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r6 = this;
            r0 = r6.a;
            r1 = r0.lj;
            monitor-enter(r1);
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r2 = 0;
            r0.lw = r2;	 Catch:{ all -> 0x0036 }
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.lC;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x001d;
        L_0x0015:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.lz;	 Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x001f;
        L_0x001d:
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        L_0x001e:
            return;
        L_0x001f:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.lX;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034;
        L_0x0027:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.lX;	 Catch:{ all -> 0x0036 }
            r0 = r0.size();	 Catch:{ all -> 0x0036 }
            r2 = 1;
            if (r0 >= r2) goto L_0x0039;
        L_0x0034:
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
        L_0x0036:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            throw r0;
        L_0x0039:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.lS;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x006f;
        L_0x0041:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.ll;	 Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x0055;
        L_0x0049:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r2 = new com.baidu.location.LocationClient$b;	 Catch:{ all -> 0x0036 }
            r3 = r6.a;	 Catch:{ all -> 0x0036 }
            r2.<init>(r3);	 Catch:{ all -> 0x0036 }
            r0.ll = r2;	 Catch:{ all -> 0x0036 }
        L_0x0055:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.lg;	 Catch:{ all -> 0x0036 }
            r2 = r6.a;	 Catch:{ all -> 0x0036 }
            r2 = r2.ll;	 Catch:{ all -> 0x0036 }
            r3 = r6.a;	 Catch:{ all -> 0x0036 }
            r3 = r3.lE;	 Catch:{ all -> 0x0036 }
            r3 = r3.scanSpan;	 Catch:{ all -> 0x0036 }
            r4 = (long) r3;	 Catch:{ all -> 0x0036 }
            r0.postDelayed(r2, r4);	 Catch:{ all -> 0x0036 }
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
        L_0x006f:
            r0 = r6.a;	 Catch:{ all -> 0x0036 }
            r0 = r0.lg;	 Catch:{ all -> 0x0036 }
            r2 = 4;
            r0 = r0.obtainMessage(r2);	 Catch:{ all -> 0x0036 }
            r0.sendToTarget();	 Catch:{ all -> 0x0036 }
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.b.run():void");
        }
    }

    public LocationClient(Context context) {
        this.lA = context;
        this.lE = new LocationClientOption();
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.lA = context;
        this.lE = locationClientOption;
        if (this.lW == null) {
            this.lW = new p(this.lA, this.lE, this);
            this.lW.ct();
        }
    }

    private void byte(BDLocation bDLocation) {
        if (!this.lV) {
            this.lP = bDLocation;
            if (!this.li && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                this.lB = true;
            }
            if (this.lX != null) {
                Iterator it = this.lX.iterator();
                while (it.hasNext()) {
                    ((BDLocationListener) it.next()).onReceiveLocation(bDLocation);
                }
            }
        }
    }

    private void d(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.lX != null && this.lX.contains(bDLocationListener)) {
                this.lX.remove(bDLocationListener);
            }
        }
    }

    private Bundle dJ() {
        if (this.lE == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.lT);
        bundle.putString("prodName", this.lE.prodName);
        bundle.putString("coorType", this.lE.coorType);
        bundle.putString("addrType", this.lE.addrType);
        bundle.putBoolean("openGPS", this.lE.openGps);
        bundle.putBoolean("location_change_notify", this.lE.location_change_notify);
        bundle.putInt("scanSpan", this.lE.scanSpan);
        bundle.putInt("timeOut", this.lE.timeOut);
        bundle.putInt(CandidatePacketExtension.PRIORITY_ATTR_NAME, this.lE.priority);
        bundle.putBoolean("map", this.lp.booleanValue());
        bundle.putBoolean("import", this.lm.booleanValue());
        bundle.putBoolean("needDirect", this.lE.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.lE.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.lE.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.lE.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.lE.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.lE.isNeedAltitude);
        return bundle;
    }

    private void dK() {
        if (!this.lK) {
            if (this.lH.booleanValue()) {
                if (this.lW == null) {
                    this.lW = new p(this.lA, this.lE, this);
                    this.lW.ct();
                }
                this.lW.cr();
                this.lH = Boolean.valueOf(false);
            }
            this.lT = this.lA.getPackageName();
            this.lR = this.lT + "_bdls_v2.9";
            Intent intent = new Intent(this.lA, f.class);
            try {
                intent.putExtra("debug_dev", this.ly);
            } catch (Exception e) {
            }
            if (this.lE == null) {
                this.lE = new LocationClientOption();
            }
            intent.putExtra("cache_exception", this.lE.isIgnoreCacheException);
            intent.putExtra("kill_process", this.lE.isIgnoreKillProcess);
            try {
                this.lA.bindService(intent, this.lN, 1);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.lK = false;
            }
        }
    }

    private void dL() {
        if (this.lK && this.lC != null) {
            Message obtain = Message.obtain(null, 12);
            obtain.replyTo = this.lz;
            try {
                this.lC.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.lA.unbindService(this.lN);
            } catch (Exception e2) {
            }
            synchronized (this.lj) {
                try {
                    if (this.lw) {
                        this.lg.removeCallbacks(this.ll);
                        this.lw = false;
                    }
                } catch (Exception e3) {
                }
            }
            if (this.ln != null) {
                this.ln.a4();
            }
            this.lC = null;
            this.lS = false;
            this.lq = false;
            this.lK = false;
            this.lB = false;
            this.li = false;
        }
    }

    private void dM() {
        if (this.lC != null) {
            Message obtain = Message.obtain(null, 22);
            try {
                obtain.replyTo = this.lz;
                this.lC.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void dN() {
        Message obtain = Message.obtain(null, 28);
        try {
            obtain.replyTo = this.lz;
            this.lC.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dO() {
        if (this.lC != null) {
            if ((System.currentTimeMillis() - this.lD > 3000 || !this.lE.location_change_notify || this.lS) && (!this.lq || System.currentTimeMillis() - this.lM > 20000 || this.lS)) {
                Message obtain = Message.obtain(null, 22);
                if (this.lS) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.lS);
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.lz;
                    this.lC.send(obtain);
                    this.lL = System.currentTimeMillis();
                    this.lu = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            synchronized (this.lj) {
                if (!(this.lE == null || this.lE.scanSpan < 1000 || this.lw)) {
                    if (this.ll == null) {
                        this.ll = new b();
                    }
                    this.lg.postDelayed(this.ll, (long) this.lE.scanSpan);
                    this.lw = true;
                }
            }
        }
    }

    private void e(Message message) {
        this.lS = false;
        if (message != null && message.obj != null) {
            LocationClientOption locationClientOption = (LocationClientOption) message.obj;
            if (!this.lE.equals(locationClientOption)) {
                if (this.lE.scanSpan != locationClientOption.scanSpan) {
                    try {
                        synchronized (this.lj) {
                            if (this.lw) {
                                this.lg.removeCallbacks(this.ll);
                                this.lw = false;
                            }
                            if (locationClientOption.scanSpan >= 1000 && !this.lw) {
                                if (this.ll == null) {
                                    this.ll = new b();
                                }
                                this.lg.postDelayed(this.ll, (long) locationClientOption.scanSpan);
                                this.lw = true;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                this.lE = new LocationClientOption(locationClientOption);
                if (this.lC != null) {
                    try {
                        Message obtain = Message.obtain(null, 15);
                        obtain.replyTo = this.lz;
                        obtain.setData(dJ());
                        this.lC.send(obtain);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] dArr = Jni.if(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(dArr[1]);
        bDLocation2.setLongitude(dArr[0]);
        return bDLocation2;
    }

    private void h(Message message) {
        Bundle data = message.getData();
        data.setClassLoader(BDLocation.class.getClassLoader());
        BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
        if (this.lt == null) {
            return;
        }
        if (this.lE == null || !this.lE.isDisableCache() || bDLocation.getLocType() != 65) {
            this.lt.onReceiveLocation(bDLocation);
        }
    }

    private void i(Message message) {
        if (message != null && message.obj != null) {
            BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
            if (this.ln != null) {
                this.ln.for(bDNotifyListener);
            }
        }
    }

    private void if(Message message, int i) {
        if (this.lK) {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            this.lP = (BDLocation) data.getParcelable("locStr");
            if (this.lP.getLocType() == 61) {
                this.lD = System.currentTimeMillis();
            }
            k(i);
        }
    }

    private void j(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.lX == null) {
                this.lX = new ArrayList();
            }
            if (!this.lX.contains(bDLocationListener)) {
                this.lX.add(bDLocationListener);
            }
        }
    }

    private void k(int i) {
        if (this.lP.getCoorType() == null) {
            this.lP.setCoorType(this.lE.coorType);
        }
        if (this.lu || ((this.lE.location_change_notify && this.lP.getLocType() == 61) || this.lP.getLocType() == 66 || this.lP.getLocType() == 67 || this.lq || this.lP.getLocType() == BDLocation.TypeNetWorkLocation)) {
            if (this.lX != null) {
                Iterator it = this.lX.iterator();
                while (it.hasNext()) {
                    ((BDLocationListener) it.next()).onReceiveLocation(this.lP);
                }
            }
            if (this.lP.getLocType() != 66 && this.lP.getLocType() != 67) {
                this.lu = false;
                this.lM = System.currentTimeMillis();
            }
        }
    }

    private void k(Message message) {
        if (message != null && message.obj != null) {
            this.lt = (BDLocationListener) message.obj;
        }
    }

    private void void(Message message) {
        if (message != null && message.obj != null) {
            BDNotifyListener bDNotifyListener = (BDNotifyListener) message.obj;
            if (this.ln == null) {
                this.ln = new com.baidu.location.d.a(this.lA, this);
            }
            this.ln.do(bDNotifyListener);
        }
    }

    public String getAccessKey() {
        try {
            this.lO = j.a(this.lA);
            if (TextUtils.isEmpty(this.lO)) {
                throw new IllegalStateException("please setting key from Manifest.xml");
            }
            return String.format("KEY=%s;SHA1=%s", new Object[]{this.lO, j.if(this.lA)});
        } catch (Exception e) {
            return null;
        }
    }

    public BDLocation getLastKnownLocation() {
        return this.lP;
    }

    public LocationClientOption getLocOption() {
        return this.lE;
    }

    public String getVersion() {
        return f.bg;
    }

    public boolean isStarted() {
        return this.lK;
    }

    public void onReceiveLocation(BDLocation bDLocation) {
        if ((!this.li || this.lB) && bDLocation != null) {
            Message obtainMessage = this.lg.obtainMessage(g.I);
            obtainMessage.obj = bDLocation;
            obtainMessage.sendToTarget();
        }
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.lg.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotify(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.lg.obtainMessage(9);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.lg.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void removeNotifyEvent(BDNotifyListener bDNotifyListener) {
        Message obtainMessage = this.lg.obtainMessage(10);
        obtainMessage.obj = bDNotifyListener;
        obtainMessage.sendToTarget();
    }

    public int requestLocation() {
        if (this.lC == null || this.lz == null) {
            return 1;
        }
        if (this.lX == null || this.lX.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.lL < 1000) {
            return 6;
        }
        Message obtainMessage = this.lg.obtainMessage(4);
        obtainMessage.arg1 = 0;
        obtainMessage.sendToTarget();
        return 0;
    }

    public void requestNotifyLocation() {
        this.lg.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.lC == null || this.lz == null) {
            return 1;
        }
        if (this.lX == null || this.lX.size() < 1) {
            return 2;
        }
        this.lg.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (this.lW == null) {
            this.lW = new p(this.lA, locationClientOption, this);
            this.lW.ct();
        }
        Message obtainMessage = this.lg.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public void start() {
        this.lV = false;
        this.lg.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        this.lV = true;
        this.lg.obtainMessage(2).sendToTarget();
        this.lW = null;
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        if (bDLocationListener == null) {
            throw new IllegalStateException("please set a non-null listener");
        }
        Message obtainMessage = this.lg.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.lC == null || this.lz == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain(null, 57);
            obtain.obj = location;
            this.lC.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
