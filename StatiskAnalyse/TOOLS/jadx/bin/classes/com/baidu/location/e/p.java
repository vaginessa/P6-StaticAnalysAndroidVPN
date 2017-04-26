package com.baidu.location.e;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.f;
import com.baidu.location.b.g;
import com.baidu.location.b.j;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import com.baidu.platform.comapi.location.CoordinateType;
import com.tencent.connect.common.Constants;
import gov.nist.core.Separators;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class p implements f {
    private static Class i1 = null;
    private static Method iS = null;
    private static Method iV = null;
    private static Method iZ = null;
    private LocationClientOption i0;
    private a iO;
    private String iP = null;
    private b iQ = new b();
    private Context iR = null;
    private String iT = null;
    private TelephonyManager iU = null;
    private c iW = null;
    private WifiManager iX = null;
    d iY = new d(this);

    public interface a {
        void onReceiveLocation(BDLocation bDLocation);
    }

    private class b {
        public int a;
        public int b;
        public int c;
        public int d;
        public char e;
        final /* synthetic */ p f;

        private b(p pVar) {
            this.f = pVar;
            this.a = -1;
            this.b = -1;
            this.c = -1;
            this.d = -1;
            this.e = '\u0000';
        }

        private boolean b() {
            return this.a > -1 && this.b > 0;
        }

        public String a() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append(this.b + 23);
            stringBuffer.append("H");
            stringBuffer.append(this.a + 45);
            stringBuffer.append("K");
            stringBuffer.append(this.d + 54);
            stringBuffer.append("Q");
            stringBuffer.append(this.c + g.a);
            return stringBuffer.toString();
        }

        public String toString() {
            if (!b()) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(128);
            stringBuffer.append("&nw=");
            stringBuffer.append(this.e);
            stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b)}));
            return stringBuffer.toString();
        }
    }

    protected class c {
        final /* synthetic */ p a;
        private long do = 0;
        public List if = null;

        public c(p pVar, List list) {
            this.a = pVar;
            this.if = list;
            this.do = System.currentTimeMillis();
            a();
        }

        private void a() {
            if (if() >= 1) {
                Object obj = 1;
                for (int size = this.if.size() - 1; size >= 1 && r2 != null; size--) {
                    int i = 0;
                    obj = null;
                    while (i < size) {
                        Object obj2;
                        if (((ScanResult) this.if.get(i)).level < ((ScanResult) this.if.get(i + 1)).level) {
                            ScanResult scanResult = (ScanResult) this.if.get(i + 1);
                            this.if.set(i + 1, this.if.get(i));
                            this.if.set(i, scanResult);
                            obj2 = 1;
                        } else {
                            obj2 = obj;
                        }
                        i++;
                        obj = obj2;
                    }
                }
            }
        }

        public String a(int i) {
            if (if() < 2) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.if.size();
            int i2 = 0;
            int i3 = 0;
            int i4 = 1;
            while (i2 < size) {
                int i5;
                if (((ScanResult) this.if.get(i2)).level == 0) {
                    i5 = i3;
                } else {
                    if (i4 != 0) {
                        stringBuffer.append("&wf=");
                        i4 = 0;
                    } else {
                        stringBuffer.append("|");
                    }
                    stringBuffer.append(((ScanResult) this.if.get(i2)).BSSID.replace(Separators.COLON, ""));
                    i5 = ((ScanResult) this.if.get(i2)).level;
                    if (i5 < 0) {
                        i5 = -i5;
                    }
                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(i5)}));
                    i5 = i3 + 1;
                    if (i5 > i) {
                        break;
                    }
                }
                i2++;
                i3 = i5;
            }
            return i4 != 0 ? null : stringBuffer.toString();
        }

        public int if() {
            return this.if == null ? 0 : this.if.size();
        }
    }

    class d extends m {
        String b;
        final /* synthetic */ p c;

        d(p pVar) {
            this.c = pVar;
            this.b = null;
            this.c7 = new ArrayList();
        }

        public void a(String str) {
            this.b = str;
            ao();
        }

        public void au() {
            this.c5 = k.Z();
            String H = Jni.H(this.b);
            this.b = null;
            this.c7.add(new BasicNameValuePair("bloc", H));
            StringBuffer stringBuffer = new StringBuffer(512);
            stringBuffer.append(String.format(Locale.CHINA, "&ki=%s&sn=%s", new Object[]{j.a(this.c.iR), j.if(this.c.iR)}));
            if (stringBuffer.length() > 0) {
                this.c7.add(new BasicNameValuePair("ext", Jni.H(stringBuffer.toString())));
            }
            this.c7.add(new BasicNameValuePair("trtm", String.format(Locale.CHINA, "%d", new Object[]{Long.valueOf(System.currentTimeMillis())})));
        }

        public void int(boolean z) {
            BDLocation bDLocation;
            if (z && this.c6 != null) {
                try {
                    try {
                        bDLocation = new BDLocation(EntityUtils.toString(this.c6, "utf-8"));
                    } catch (Exception e) {
                        bDLocation = new BDLocation();
                        bDLocation.setLocType(63);
                    }
                    if (bDLocation != null) {
                        if (bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                            bDLocation.setCoorType(this.c.i0.coorType);
                            this.c.iO.onReceiveLocation(bDLocation);
                        }
                    }
                } catch (Exception e2) {
                }
            }
            if (this.c7 != null) {
                this.c7.clear();
            }
        }
    }

    public p(Context context, LocationClientOption locationClientOption, a aVar) {
        String deviceId;
        String str;
        this.iR = context.getApplicationContext();
        this.i0 = locationClientOption;
        this.iO = aVar;
        String packageName = this.iR.getPackageName();
        try {
            this.iU = (TelephonyManager) this.iR.getSystemService("phone");
            deviceId = this.iU.getDeviceId();
        } catch (Exception e) {
            deviceId = null;
        }
        try {
            str = com.baidu.location.f.a.a.if(this.iR);
        } catch (Exception e2) {
            str = null;
        }
        if (str != null) {
            this.iP = "&prod=" + this.i0.prodName + Separators.COLON + packageName + "|&cu=" + str + "&coor=" + locationClientOption.getCoorType();
        } else {
            this.iP = "&prod=" + this.i0.prodName + Separators.COLON + packageName + "|&im=" + deviceId + "&coor=" + locationClientOption.getCoorType();
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("6.12");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        if (locationClientOption.getAddrType() != null) {
        }
        if (locationClientOption.getAddrType() != null && locationClientOption.getAddrType().equals("all")) {
            this.iP += "&addr=all";
        }
        if (locationClientOption.isNeedAptag || locationClientOption.isNeedAptagd) {
            this.iP += "&sema=";
            if (locationClientOption.isNeedAptag) {
                this.iP += "aptag|";
            }
            if (locationClientOption.isNeedAptagd) {
                this.iP += "aptagd|";
            }
        }
        stringBuffer.append("&first=1");
        stringBuffer.append(VERSION.SDK);
        this.iP += stringBuffer.toString();
        this.iX = (WifiManager) this.iR.getSystemService("wifi");
        Object cs = cs();
        if (!TextUtils.isEmpty(cs)) {
            cs = cs.replace(Separators.COLON, "");
        }
        if (!TextUtils.isEmpty(cs)) {
            this.iP += "&mac=" + cs;
        }
        ct();
    }

    private String case(int i) {
        String bVar;
        String a;
        if (i < 3) {
            i = 3;
        }
        try {
            if(this.iU.getCellLocation());
            bVar = this.iQ.toString();
        } catch (Exception e) {
            bVar = null;
        }
        try {
            this.iW = null;
            this.iW = new c(this, this.iX.getScanResults());
            a = this.iW.a(i);
        } catch (Exception e2) {
            a = null;
        }
        if (bVar == null && a == null) {
            this.iT = null;
            return null;
        }
        if (a != null) {
            bVar = bVar + a;
        }
        if (bVar == null) {
            return null;
        }
        this.iT = bVar + this.iP;
        return bVar + this.iP;
    }

    private void if(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation != null && this.iU != null) {
            b bVar = new b();
            String networkOperator = this.iU.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                try {
                    if (networkOperator.length() >= 3) {
                        int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                        if (intValue < 0) {
                            intValue = this.iQ.c;
                        }
                        bVar.c = intValue;
                    }
                    String substring = networkOperator.substring(3);
                    if (substring != null) {
                        char[] toCharArray = substring.toCharArray();
                        while (i < toCharArray.length && Character.isDigit(toCharArray[i])) {
                            i++;
                        }
                    }
                    i = Integer.valueOf(substring.substring(0, i)).intValue();
                    if (i < 0) {
                        i = this.iQ.d;
                    }
                    bVar.d = i;
                } catch (Exception e) {
                }
            }
            if (cellLocation instanceof GsmCellLocation) {
                bVar.a = ((GsmCellLocation) cellLocation).getLac();
                bVar.b = ((GsmCellLocation) cellLocation).getCid();
                bVar.e = 'g';
            } else if (cellLocation instanceof CdmaCellLocation) {
                bVar.e = 'c';
                if (i1 == null) {
                    try {
                        i1 = Class.forName("android.telephony.cdma.CdmaCellLocation");
                        iZ = i1.getMethod("getBaseStationId", new Class[0]);
                        iV = i1.getMethod("getNetworkId", new Class[0]);
                        iS = i1.getMethod("getSystemId", new Class[0]);
                    } catch (Exception e2) {
                        i1 = null;
                        return;
                    }
                }
                if (i1 != null && i1.isInstance(cellLocation)) {
                    try {
                        i = ((Integer) iS.invoke(cellLocation, new Object[0])).intValue();
                        if (i < 0) {
                            i = this.iQ.d;
                        }
                        bVar.d = i;
                        bVar.b = ((Integer) iZ.invoke(cellLocation, new Object[0])).intValue();
                        bVar.a = ((Integer) iV.invoke(cellLocation, new Object[0])).intValue();
                    } catch (Exception e3) {
                        return;
                    }
                }
            }
            if (bVar.b()) {
                this.iQ = bVar;
            }
        }
    }

    public String char(int i) {
        try {
            return case(i);
        } catch (Exception e) {
            return null;
        }
    }

    public void cr() {
        if (this.iT != null) {
            BDLocation bDLocation = null;
            if (!(this.i0.scanSpan < 1000 || this.i0.getAddrType().equals("all") || this.i0.isNeedAptag || this.i0.isNeedAptagd)) {
                bDLocation = com.baidu.location.c.b.a0().if(this.iQ.a(), this.iX.getScanResults(), false);
                if (!this.i0.coorType.equals(CoordinateType.GCJ02)) {
                    double longitude = bDLocation.getLongitude();
                    double latitude = bDLocation.getLatitude();
                    if (!(longitude == Double.MIN_VALUE || latitude == Double.MIN_VALUE)) {
                        double[] dArr = Jni.if(longitude, latitude, this.i0.coorType);
                        bDLocation.setLongitude(dArr[0]);
                        bDLocation.setLatitude(dArr[1]);
                        bDLocation.setCoorType(this.i0.coorType);
                    }
                }
                if (bDLocation.getLocType() == 66) {
                    this.iO.onReceiveLocation(bDLocation);
                }
            }
            if (bDLocation == null) {
                this.iY.a(this.iT);
            }
        }
    }

    public String cs() {
        String str = null;
        try {
            WifiInfo connectionInfo = this.iX.getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        } catch (Exception e) {
        }
        return str;
    }

    public String ct() {
        try {
            return case(15);
        } catch (Exception e) {
            return null;
        }
    }
}
