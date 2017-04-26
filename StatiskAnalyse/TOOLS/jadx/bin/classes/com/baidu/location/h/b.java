package com.baidu.location.h;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import gov.nist.core.Separators;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class b extends j implements f {
    private static Method j1 = null;
    private static b j2 = null;
    private static Method j3 = null;
    private static Method jN = null;
    private static Method jO = null;
    public static int jR = 0;
    public static int jT = 0;
    public static final long jV = 3000;
    private static Method jW = null;
    private static Class jX = null;
    public static final int jY = 3;
    private a j0 = null;
    private TelephonyManager jM = null;
    private h jP = null;
    private boolean jQ = false;
    private h jS = new h();
    private boolean jU = false;
    private List jZ = null;

    private class a extends PhoneStateListener {
        final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public void onCellLocationChanged(CellLocation cellLocation) {
            if (cellLocation != null) {
                try {
                    this.a.cV();
                } catch (Exception e) {
                }
            }
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (this.a.jS == null) {
                return;
            }
            if (this.a.jS.kv == 'g') {
                this.a.jS.ku = signalStrength.getGsmSignalStrength();
            } else if (this.a.jS.kv == 'c') {
                this.a.jS.ku = signalStrength.getCdmaDbm();
            }
        }
    }

    private b() {
    }

    private String byte(h hVar) {
        StringBuilder stringBuilder = new StringBuilder();
        if (Integer.valueOf(VERSION.SDK_INT).intValue() >= 17) {
            try {
                List<CellInfo> allCellInfo = this.jM.getAllCellInfo();
                if (allCellInfo != null && allCellInfo.size() > 0) {
                    stringBuilder.append("&nc=");
                    for (CellInfo cellInfo : allCellInfo) {
                        if (!cellInfo.isRegistered()) {
                            h hVar2 = if(cellInfo);
                            if (!(hVar2 == null || hVar2.kp == -1 || hVar2.kt == -1)) {
                                if (hVar.kp != hVar2.kp) {
                                    stringBuilder.append(hVar2.kp + "|" + hVar2.kt + "|" + hVar2.ku + Separators.SEMICOLON);
                                } else {
                                    stringBuilder.append("|" + hVar2.kt + "|" + hVar2.ku + Separators.SEMICOLON);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
            } catch (NoSuchMethodError e2) {
            }
        }
        return stringBuilder.toString();
    }

    private void cU() {
        String ah = k.ah();
        if (ah != null) {
            File file = new File(ah + File.separator + "lcvif.dat");
            if (file.exists()) {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    if (System.currentTimeMillis() - randomAccessFile.readLong() > 60000) {
                        randomAccessFile.close();
                        file.delete();
                        return;
                    }
                    randomAccessFile.readInt();
                    for (int i = 0; i < 3; i++) {
                        long readLong = randomAccessFile.readLong();
                        int readInt = randomAccessFile.readInt();
                        int readInt2 = randomAccessFile.readInt();
                        int readInt3 = randomAccessFile.readInt();
                        int readInt4 = randomAccessFile.readInt();
                        int readInt5 = randomAccessFile.readInt();
                        char c = '\u0000';
                        if (readInt5 == 1) {
                            c = 'g';
                        }
                        if (readInt5 == 2) {
                            c = 'c';
                        }
                        if (readLong != 0) {
                            h hVar = new h(readInt3, readInt4, readInt, readInt2, 0, c);
                            hVar.kr = readLong;
                            if (hVar.du()) {
                                this.jU = true;
                                this.jZ.add(hVar);
                            }
                        }
                    }
                    randomAccessFile.close();
                } catch (Exception e) {
                    file.delete();
                }
            }
        }
    }

    private void cV() {
        h cZ = cZ();
        if (cZ != null) {
            try(cZ);
        }
        if (cZ == null || !cZ.du()) {
            do(this.jM.getCellLocation());
        }
    }

    public static b cW() {
        if (j2 == null) {
            j2 = new b();
        }
        return j2;
    }

    private void cY() {
        int i = 0;
        if (this.jZ != null || this.jP != null) {
            if (this.jZ == null && this.jP != null) {
                this.jZ = new LinkedList();
                this.jZ.add(this.jP);
            }
            String ah = k.ah();
            if (ah != null) {
                File file = new File(ah + File.separator + "lcvif.dat");
                int size = this.jZ.size();
                try {
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(0);
                    randomAccessFile.writeLong(((h) this.jZ.get(size - 1)).kr);
                    randomAccessFile.writeInt(size);
                    for (int i2 = 0; i2 < 3 - size; i2++) {
                        randomAccessFile.writeLong(0);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(-1);
                        randomAccessFile.writeInt(2);
                    }
                    while (i < size) {
                        randomAccessFile.writeLong(((h) this.jZ.get(i)).kr);
                        randomAccessFile.writeInt(((h) this.jZ.get(i)).kw);
                        randomAccessFile.writeInt(((h) this.jZ.get(i)).kx);
                        randomAccessFile.writeInt(((h) this.jZ.get(i)).kp);
                        randomAccessFile.writeInt(((h) this.jZ.get(i)).kt);
                        if (((h) this.jZ.get(i)).kv == 'g') {
                            randomAccessFile.writeInt(1);
                        } else if (((h) this.jZ.get(i)).kv == 'c') {
                            randomAccessFile.writeInt(2);
                        } else {
                            randomAccessFile.writeInt(3);
                        }
                        i++;
                    }
                    randomAccessFile.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.location.h.h cZ() {
        /*
        r5 = this;
        r1 = 0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r0 = java.lang.Integer.valueOf(r0);
        r0 = r0.intValue();
        r2 = 17;
        if (r0 >= r2) goto L_0x0010;
    L_0x000f:
        return r1;
    L_0x0010:
        r0 = r5.jM;	 Catch:{ Exception -> 0x004f, NoSuchMethodError -> 0x004d }
        r0 = r0.getAllCellInfo();	 Catch:{ Exception -> 0x004f, NoSuchMethodError -> 0x004d }
        if (r0 == 0) goto L_0x000f;
    L_0x0018:
        r2 = r0.size();	 Catch:{ Exception -> 0x004f, NoSuchMethodError -> 0x004d }
        if (r2 <= 0) goto L_0x000f;
    L_0x001e:
        r3 = r0.iterator();	 Catch:{ Exception -> 0x004f, NoSuchMethodError -> 0x004d }
        r2 = r1;
    L_0x0023:
        r0 = r3.hasNext();	 Catch:{ Exception -> 0x0051, NoSuchMethodError -> 0x004d }
        if (r0 == 0) goto L_0x0054;
    L_0x0029:
        r0 = r3.next();	 Catch:{ Exception -> 0x0051, NoSuchMethodError -> 0x004d }
        r0 = (android.telephony.CellInfo) r0;	 Catch:{ Exception -> 0x0051, NoSuchMethodError -> 0x004d }
        r4 = r0.isRegistered();	 Catch:{ Exception -> 0x0051, NoSuchMethodError -> 0x004d }
        if (r4 == 0) goto L_0x0023;
    L_0x0035:
        r0 = r5.if(r0);	 Catch:{ Exception -> 0x0051, NoSuchMethodError -> 0x004d }
        if (r0 != 0) goto L_0x003d;
    L_0x003b:
        r2 = r0;
        goto L_0x0023;
    L_0x003d:
        r2 = r0.du();	 Catch:{ Exception -> 0x004a, NoSuchMethodError -> 0x004d }
        if (r2 != 0) goto L_0x0046;
    L_0x0043:
        r0 = r1;
    L_0x0044:
        r1 = r0;
        goto L_0x000f;
    L_0x0046:
        r0.dt();	 Catch:{ Exception -> 0x004a, NoSuchMethodError -> 0x004d }
        goto L_0x0044;
    L_0x004a:
        r1 = move-exception;
        r1 = r0;
        goto L_0x000f;
    L_0x004d:
        r0 = move-exception;
        goto L_0x000f;
    L_0x004f:
        r0 = move-exception;
        goto L_0x000f;
    L_0x0051:
        r0 = move-exception;
        r1 = r2;
        goto L_0x000f;
    L_0x0054:
        r1 = r2;
        goto L_0x000f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.h.b.cZ():com.baidu.location.h.h");
    }

    private h do(CellLocation cellLocation) {
        int i = 0;
        if (cellLocation == null || this.jM == null) {
            return null;
        }
        h hVar = new h();
        hVar.kr = System.currentTimeMillis();
        try {
            String networkOperator = this.jM.getNetworkOperator();
            if (networkOperator != null && networkOperator.length() > 0) {
                if (networkOperator.length() >= 3) {
                    int intValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (intValue < 0) {
                        intValue = this.jS.kw;
                    }
                    hVar.kw = intValue;
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
                    i = this.jS.kx;
                }
                hVar.kx = i;
            }
            jT = this.jM.getSimState();
        } catch (Exception e) {
            jR = 1;
        }
        if (cellLocation instanceof GsmCellLocation) {
            hVar.kp = ((GsmCellLocation) cellLocation).getLac();
            hVar.kt = ((GsmCellLocation) cellLocation).getCid();
            hVar.kv = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            hVar.kv = 'c';
            if (Integer.valueOf(VERSION.SDK_INT).intValue() < 5) {
                return hVar;
            }
            if (jX == null) {
                try {
                    jX = Class.forName("android.telephony.cdma.CdmaCellLocation");
                    j1 = jX.getMethod("getBaseStationId", new Class[0]);
                    jO = jX.getMethod("getNetworkId", new Class[0]);
                    jW = jX.getMethod("getSystemId", new Class[0]);
                    jN = jX.getMethod("getBaseStationLatitude", new Class[0]);
                    j3 = jX.getMethod("getBaseStationLongitude", new Class[0]);
                } catch (Exception e2) {
                    jX = null;
                    jR = 2;
                    return hVar;
                }
            }
            if (jX != null && jX.isInstance(cellLocation)) {
                try {
                    int intValue2 = ((Integer) jW.invoke(cellLocation, new Object[0])).intValue();
                    if (intValue2 < 0) {
                        intValue2 = this.jS.kx;
                    }
                    hVar.kx = intValue2;
                    hVar.kt = ((Integer) j1.invoke(cellLocation, new Object[0])).intValue();
                    hVar.kp = ((Integer) jO.invoke(cellLocation, new Object[0])).intValue();
                    Object invoke = jN.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        hVar.ky = ((Integer) invoke).intValue();
                    }
                    invoke = j3.invoke(cellLocation, new Object[0]);
                    if (((Integer) invoke).intValue() < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
                        hVar.ks = ((Integer) invoke).intValue();
                    }
                } catch (Exception e3) {
                    jR = 3;
                    return hVar;
                }
            }
        }
        try(hVar);
        return hVar;
    }

    private h if(CellInfo cellInfo) {
        int intValue = Integer.valueOf(VERSION.SDK_INT).intValue();
        if (intValue < 17) {
            return null;
        }
        h hVar = new h();
        Object obj = null;
        if (cellInfo instanceof CellInfoGsm) {
            CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
            hVar.kw = void(cellIdentity.getMcc());
            hVar.kx = void(cellIdentity.getMnc());
            hVar.kp = void(cellIdentity.getLac());
            hVar.kt = void(cellIdentity.getCid());
            hVar.kv = 'g';
            hVar.ku = ((CellInfoGsm) cellInfo).getCellSignalStrength().getAsuLevel();
            obj = 1;
        } else if (cellInfo instanceof CellInfoCdma) {
            CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
            hVar.ky = cellIdentity2.getLatitude();
            hVar.ks = cellIdentity2.getLongitude();
            hVar.kx = void(cellIdentity2.getSystemId());
            hVar.kp = void(cellIdentity2.getNetworkId());
            hVar.kt = void(cellIdentity2.getBasestationId());
            hVar.kv = 'c';
            hVar.ku = ((CellInfoCdma) cellInfo).getCellSignalStrength().getCdmaDbm();
            r2 = 1;
        } else if (cellInfo instanceof CellInfoLte) {
            CellIdentityLte cellIdentity3 = ((CellInfoLte) cellInfo).getCellIdentity();
            hVar.kw = void(cellIdentity3.getMcc());
            hVar.kx = void(cellIdentity3.getMnc());
            hVar.kp = void(cellIdentity3.getTac());
            hVar.kt = void(cellIdentity3.getCi());
            hVar.kv = 'g';
            hVar.ku = ((CellInfoLte) cellInfo).getCellSignalStrength().getAsuLevel();
            r2 = 1;
        }
        if (intValue >= 18 && r2 == null) {
            try {
                if (cellInfo instanceof CellInfoWcdma) {
                    CellIdentityWcdma cellIdentity4 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                    hVar.kw = void(cellIdentity4.getMcc());
                    hVar.kx = void(cellIdentity4.getMnc());
                    hVar.kp = void(cellIdentity4.getLac());
                    hVar.kt = void(cellIdentity4.getCid());
                    hVar.kv = 'g';
                    hVar.ku = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getAsuLevel();
                }
            } catch (Exception e) {
            }
        }
        try {
            hVar.kr = System.currentTimeMillis() - ((SystemClock.elapsedRealtimeNanos() - cellInfo.getTimeStamp()) / 1000000);
        } catch (Error e2) {
            hVar.kr = System.currentTimeMillis();
        }
        return hVar;
    }

    private void try(h hVar) {
        if (!hVar.du()) {
            return;
        }
        if (this.jS == null || !this.jS.case(hVar)) {
            this.jS = hVar;
            if (hVar.du()) {
                int size = this.jZ.size();
                h hVar2 = size == 0 ? null : (h) this.jZ.get(size - 1);
                if (hVar2 == null || hVar2.kt != this.jS.kt || hVar2.kp != this.jS.kp) {
                    this.jZ.add(this.jS);
                    if (this.jZ.size() > 3) {
                        this.jZ.remove(0);
                    }
                    cY();
                    this.jU = false;
                }
            } else if (this.jZ != null) {
                this.jZ.clear();
            }
        }
    }

    private int void(int i) {
        return i == ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED ? -1 : i;
    }

    public h cO() {
        if (!((this.jS != null && this.jS.dw() && this.jS.du()) || this.jM == null)) {
            try {
                cV();
            } catch (Exception e) {
            }
        }
        if (this.jS.dA()) {
            this.jP = null;
            this.jP = new h(this.jS.kp, this.jS.kt, this.jS.kw, this.jS.kx, this.jS.ku, this.jS.kv);
        }
        if (this.jS.dD() && this.jP != null && this.jS.kv == 'g') {
            this.jS.kx = this.jP.kx;
            this.jS.kw = this.jP.kw;
        }
        return this.jS;
    }

    public synchronized void cP() {
        if (!this.jQ) {
            if (com.baidu.location.f.isServing) {
                this.jM = (TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone");
                this.jZ = new LinkedList();
                this.j0 = new a(this);
                cU();
                if (!(this.jM == null || this.j0 == null)) {
                    try {
                        this.jM.listen(this.j0, 272);
                    } catch (Exception e) {
                    }
                    this.jQ = true;
                }
            }
        }
    }

    public String cQ() {
        return null;
    }

    public int cR() {
        int i = 0;
        if (this.jM != null) {
            try {
                i = this.jM.getNetworkType();
            } catch (Exception e) {
            }
        }
        return i;
    }

    public int cS() {
        String subscriberId;
        try {
            subscriberId = ((TelephonyManager) com.baidu.location.f.getServiceContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            subscriberId = null;
        }
        if (subscriberId != null) {
            if (subscriberId.startsWith("46000") || subscriberId.startsWith("46002") || subscriberId.startsWith("46007")) {
                return 1;
            }
            if (subscriberId.startsWith("46001")) {
                return 2;
            }
            if (subscriberId.startsWith("46003")) {
                return 3;
            }
        }
        return 0;
    }

    public synchronized void cT() {
        if (this.jQ) {
            if (!(this.j0 == null || this.jM == null)) {
                this.jM.listen(this.j0, 0);
            }
            this.j0 = null;
            this.jM = null;
            this.jZ.clear();
            this.jZ = null;
            cY();
            this.jQ = false;
        }
    }

    public boolean cX() {
        return this.jU;
    }

    public String int(h hVar) {
        String str = "";
        try {
            str = byte(hVar);
            if (str != null && !str.equals("") && !str.equals("&nc=")) {
                return str;
            }
            List<NeighboringCellInfo> neighboringCellInfo = this.jM.getNeighboringCellInfo();
            if (neighboringCellInfo != null && !neighboringCellInfo.isEmpty()) {
                String str2 = "&nc=";
                int i = 0;
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    int lac = neighboringCellInfo2.getLac();
                    str = (lac == -1 || neighboringCellInfo2.getCid() == -1) ? str2 : hVar.kp != lac ? str2 + lac + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + Separators.SEMICOLON : str2 + "|" + neighboringCellInfo2.getCid() + "|" + neighboringCellInfo2.getRssi() + Separators.SEMICOLON;
                    int i2 = i + 1;
                    if (i2 >= 8) {
                        break;
                    }
                    i = i2;
                    str2 = str;
                }
                str = str2;
            }
            return (str == null || !str.equals("&nc=")) ? str : null;
        } catch (Exception e) {
            e.printStackTrace();
            str = "";
        }
    }

    public String new(h hVar) {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&nw=");
        stringBuffer.append(hVar.kv);
        stringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[]{Integer.valueOf(hVar.kw), Integer.valueOf(hVar.kx), Integer.valueOf(hVar.kp), Integer.valueOf(hVar.kt), Integer.valueOf(hVar.ku)}));
        if (hVar.ky < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED && hVar.ks < ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) {
            stringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[]{Double.valueOf(((double) hVar.ks) / 14400.0d), Double.valueOf(((double) hVar.ky) / 14400.0d)}));
        }
        stringBuffer.append("&cl_t=");
        stringBuffer.append(hVar.kr);
        if (this.jZ != null && this.jZ.size() > 0) {
            int size = this.jZ.size();
            stringBuffer.append("&clt=");
            for (int i = 0; i < size; i++) {
                h hVar2 = (h) this.jZ.get(i);
                if (hVar2.kw != hVar.kw) {
                    stringBuffer.append(hVar2.kw);
                }
                stringBuffer.append("|");
                if (hVar2.kx != hVar.kx) {
                    stringBuffer.append(hVar2.kx);
                }
                stringBuffer.append("|");
                if (hVar2.kp != hVar.kp) {
                    stringBuffer.append(hVar2.kp);
                }
                stringBuffer.append("|");
                if (hVar2.kt != hVar.kt) {
                    stringBuffer.append(hVar2.kt);
                }
                stringBuffer.append("|");
                stringBuffer.append((System.currentTimeMillis() - hVar2.kr) / 1000);
                stringBuffer.append(Separators.SEMICOLON);
            }
        }
        if (jT > 100) {
            jT = 0;
        }
        stringBuffer.append("&cs=" + ((jR << 8) + jT));
        return stringBuffer.toString();
    }
}
