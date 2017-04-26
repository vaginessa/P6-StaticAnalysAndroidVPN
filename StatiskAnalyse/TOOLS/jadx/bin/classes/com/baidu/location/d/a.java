package com.baidu.location.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.BDNotifyListener;
import com.baidu.location.Jni;
import com.baidu.location.LocationClient;
import com.baidu.location.b.f;
import com.baidu.location.h.e;
import com.baidu.platform.comapi.location.CoordinateType;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import java.util.ArrayList;
import java.util.Iterator;

public class a implements f {
    public static final String fA = "android.com.baidu.location.TIMER.NOTIFY";
    private PendingIntent fB = null;
    private ArrayList fC = null;
    private BDLocation fD = null;
    private long fE = 0;
    private b fF = null;
    private float fG = Float.MAX_VALUE;
    private boolean fH = false;
    private long fI = 0;
    private boolean fJ = false;
    private LocationClient fK = null;
    private int fw = 0;
    private Context fx = null;
    private AlarmManager fy = null;
    private a fz = new a(this);

    public class a implements BDLocationListener {
        final /* synthetic */ a a;

        public a(a aVar) {
            this.a = aVar;
        }

        public void onReceiveLocation(BDLocation bDLocation) {
            if (this.a.fC != null && this.a.fC.size() > 0) {
                this.a.for(bDLocation);
            }
        }
    }

    public class b extends BroadcastReceiver {
        final /* synthetic */ a a;

        public b(a aVar) {
            this.a = aVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.a.fC != null && !this.a.fC.isEmpty()) {
                this.a.fK.requestNotifyLocation();
            }
        }
    }

    public a(Context context, LocationClient locationClient) {
        this.fx = context;
        this.fK = locationClient;
        this.fK.registerNotifyLocationListener(this.fz);
        this.fy = (AlarmManager) this.fx.getSystemService("alarm");
        this.fF = new b(this);
        this.fJ = false;
    }

    private void a3() {
        int i = StatusCodes.AUTH_DISABLED;
        if (a5()) {
            boolean z;
            int i2 = this.fG > 5000.0f ? 600000 : this.fG > 1000.0f ? 120000 : this.fG > 500.0f ? 60000 : StatusCodes.AUTH_DISABLED;
            if (this.fH) {
                this.fH = false;
            } else {
                i = i2;
            }
            if (this.fw != 0) {
                if (((long) i) > (this.fE + ((long) this.fw)) - System.currentTimeMillis()) {
                    z = false;
                    if (z) {
                        this.fw = i;
                        this.fE = System.currentTimeMillis();
                        new((long) this.fw);
                    }
                }
            }
            z = true;
            if (z) {
                this.fw = i;
                this.fE = System.currentTimeMillis();
                new((long) this.fw);
            }
        }
    }

    private boolean a5() {
        if (this.fC == null || this.fC.isEmpty()) {
            return false;
        }
        Iterator it = this.fC.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z = ((BDNotifyListener) it.next()).Notified < 3 ? true : z;
        }
        return z;
    }

    private void for(BDLocation bDLocation) {
        if (bDLocation.getLocType() != 61 && bDLocation.getLocType() != BDLocation.TypeNetWorkLocation && bDLocation.getLocType() != 65) {
            new(120000);
        } else if (System.currentTimeMillis() - this.fI >= e.kc && this.fC != null) {
            this.fD = bDLocation;
            this.fI = System.currentTimeMillis();
            float[] fArr = new float[1];
            Iterator it = this.fC.iterator();
            float f = Float.MAX_VALUE;
            while (it.hasNext()) {
                BDNotifyListener bDNotifyListener = (BDNotifyListener) it.next();
                Location.distanceBetween(bDLocation.getLatitude(), bDLocation.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - bDLocation.getRadius();
                if (radius > 0.0f) {
                    if (radius < f) {
                    }
                    radius = f;
                } else {
                    if (bDNotifyListener.Notified < 3) {
                        bDNotifyListener.Notified++;
                        bDNotifyListener.onNotify(bDLocation, fArr[0]);
                        if (bDNotifyListener.Notified < 3) {
                            this.fH = true;
                        }
                    }
                    radius = f;
                }
                f = radius;
            }
            if (f < this.fG) {
                this.fG = f;
            }
            this.fw = 0;
            a3();
        }
    }

    private void new(long j) {
        try {
            if (this.fB != null) {
                this.fy.cancel(this.fB);
            }
            this.fB = PendingIntent.getBroadcast(this.fx, 0, new Intent(fA), 134217728);
            if (this.fB != null) {
                this.fy.set(0, System.currentTimeMillis() + j, this.fB);
            }
        } catch (Exception e) {
        }
    }

    public void a4() {
        if (this.fB != null) {
            this.fy.cancel(this.fB);
        }
        this.fD = null;
        this.fI = 0;
        if (this.fJ) {
            this.fx.unregisterReceiver(this.fF);
        }
        this.fJ = false;
    }

    public int do(BDNotifyListener bDNotifyListener) {
        if (this.fC == null) {
            this.fC = new ArrayList();
        }
        this.fC.add(bDNotifyListener);
        bDNotifyListener.isAdded = true;
        bDNotifyListener.mNotifyCache = this;
        if (!this.fJ) {
            this.fx.registerReceiver(this.fF, new IntentFilter(fA));
            this.fJ = true;
        }
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals(CoordinateType.GCJ02)) {
                double[] dArr = Jni.if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
                bDNotifyListener.mLongitudeC = dArr[0];
                bDNotifyListener.mLatitudeC = dArr[1];
            }
            if (this.fD == null || System.currentTimeMillis() - this.fI > 30000) {
                this.fK.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.fD.getLatitude(), this.fD.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.fD.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.fG) {
                        this.fG = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.fD, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.fH = true;
                    }
                }
            }
            a3();
        }
        return 1;
    }

    public int for(BDNotifyListener bDNotifyListener) {
        if (this.fC == null) {
            return 0;
        }
        if (this.fC.contains(bDNotifyListener)) {
            this.fC.remove(bDNotifyListener);
        }
        if (this.fC.size() == 0 && this.fB != null) {
            this.fy.cancel(this.fB);
        }
        return 1;
    }

    public void if(BDNotifyListener bDNotifyListener) {
        if (bDNotifyListener.mCoorType != null) {
            if (!bDNotifyListener.mCoorType.equals(CoordinateType.GCJ02)) {
                double[] dArr = Jni.if(bDNotifyListener.mLongitude, bDNotifyListener.mLatitude, bDNotifyListener.mCoorType + "2gcj");
                bDNotifyListener.mLongitudeC = dArr[0];
                bDNotifyListener.mLatitudeC = dArr[1];
            }
            if (this.fD == null || System.currentTimeMillis() - this.fI > 300000) {
                this.fK.requestNotifyLocation();
            } else {
                float[] fArr = new float[1];
                Location.distanceBetween(this.fD.getLatitude(), this.fD.getLongitude(), bDNotifyListener.mLatitudeC, bDNotifyListener.mLongitudeC, fArr);
                float radius = (fArr[0] - bDNotifyListener.mRadius) - this.fD.getRadius();
                if (radius > 0.0f) {
                    if (radius < this.fG) {
                        this.fG = radius;
                    }
                } else if (bDNotifyListener.Notified < 3) {
                    bDNotifyListener.Notified++;
                    bDNotifyListener.onNotify(this.fD, fArr[0]);
                    if (bDNotifyListener.Notified < 3) {
                        this.fH = true;
                    }
                }
            }
            a3();
        }
    }
}
