package com.baidu.location.h;

import android.net.wifi.ScanResult;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.baidu.location.b.k;
import gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class f implements com.baidu.location.b.f {
    private static final long kj = 10;
    private long kk = 0;
    private boolean kl = false;
    public List km = null;
    private long kn = 0;
    private boolean ko;

    public f(f fVar) {
        if (fVar != null) {
            this.km = fVar.km;
            this.kk = fVar.kk;
            this.kn = fVar.kn;
            this.kl = fVar.kl;
        }
    }

    public f(List list, long j) {
        this.kk = j;
        this.km = list;
        this.kn = System.currentTimeMillis();
        di();
    }

    private void di() {
        if (dn() >= 1) {
            Object obj = 1;
            for (int size = this.km.size() - 1; size >= 1 && r2 != null; size--) {
                int i = 0;
                obj = null;
                while (i < size) {
                    Object obj2;
                    if (((ScanResult) this.km.get(i)).level < ((ScanResult) this.km.get(i + 1)).level) {
                        ScanResult scanResult = (ScanResult) this.km.get(i + 1);
                        this.km.set(i + 1, this.km.get(i));
                        this.km.set(i, scanResult);
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

    public static String if(int i, List list) {
        if (list.size() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = list.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        int i3 = 1;
        while (i2 < i) {
            if (((ScanResult) list.get(i2)).level == 0) {
                size = i3;
            } else {
                if (i3 != 0) {
                    i3 = 0;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) list.get(i2)).BSSID.replace(Separators.COLON, ""));
                size = ((ScanResult) list.get(i2)).level;
                if (size < 0) {
                    size = -size;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                size = i3;
            }
            i2++;
            i3 = size;
        }
        return i3 == 0 ? stringBuffer.toString() : null;
    }

    public String d(int i) {
        if (dn() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = this.km.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        int i3 = 1;
        while (i2 < i) {
            if (((ScanResult) this.km.get(i2)).level == 0) {
                size = i3;
            } else {
                if (i3 != 0) {
                    i3 = 0;
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) this.km.get(i2)).BSSID.replace(Separators.COLON, ""));
                size = ((ScanResult) this.km.get(i2)).level;
                if (size < 0) {
                    size = -size;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                size = i3;
            }
            i2++;
            i3 = size;
        }
        return i3 == 0 ? stringBuffer.toString() : null;
    }

    public int dh() {
        for (int i = 0; i < dn(); i++) {
            int i2 = -((ScanResult) this.km.get(i)).level;
            if (i2 > 0) {
                return i2;
            }
        }
        return 0;
    }

    public boolean dj() {
        return this.kl;
    }

    public String dk() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("wifi=");
        if (this.km == null) {
            return stringBuilder.toString();
        }
        for (int i = 0; i < this.km.size(); i++) {
            int i2 = ((ScanResult) this.km.get(i)).level;
            stringBuilder.append(((ScanResult) this.km.get(i)).BSSID.replace(Separators.COLON, ""));
            stringBuilder.append(String.format(Locale.CHINA, ",%d;", new Object[]{Integer.valueOf(i2)}));
        }
        return stringBuilder.toString();
    }

    public boolean dl() {
        return System.currentTimeMillis() - this.kk < 3000;
    }

    public String dm() {
        try {
            return e(15);
        } catch (Exception e) {
            return null;
        }
    }

    public int dn() {
        return this.km == null ? 0 : this.km.size();
    }

    public String do(int i, boolean z) {
        int i2;
        int i3;
        if (dn() < 1) {
            return null;
        }
        int size;
        Object obj;
        int i4 = 0;
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer(512);
        List<Long> arrayList = new ArrayList();
        String c9 = l.a().c9();
        Object obj2 = null;
        if (VERSION.SDK_INT >= 17) {
            long elapsedRealtimeNanos;
            try {
                elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
            } catch (Error e) {
                elapsedRealtimeNanos = 0;
            }
            if (elapsedRealtimeNanos > 0) {
                obj2 = 1;
            }
        }
        if (obj2 == null || obj2 == null || z) {
            i2 = 0;
            i3 = 0;
            size = this.km.size();
            obj = 1;
        } else {
            i2 = 0;
            i3 = 0;
            size = this.km.size();
            obj = 1;
        }
        if (size <= i) {
            i = size;
        }
        int i5 = 0;
        while (i5 < i) {
            int i6;
            int i7;
            if (((ScanResult) this.km.get(i5)).level == 0) {
                obj2 = obj;
                i6 = i2;
                i7 = i3;
                i3 = i4;
                i4 = i7;
            } else {
                if (obj != null) {
                    obj = null;
                    stringBuffer.append("&wf=");
                } else {
                    stringBuffer.append("|");
                }
                String replace = ((ScanResult) this.km.get(i5)).BSSID.replace(Separators.COLON, "");
                stringBuffer.append(replace);
                size = ((ScanResult) this.km.get(i5)).level;
                if (size < 0) {
                    size = -size;
                }
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(size)}));
                i2++;
                if (c9 != null && c9.equals(replace)) {
                    this.ko = l.a().D(((ScanResult) this.km.get(i5)).capabilities);
                    l.a().dc();
                    i3 = i2;
                }
                if (i4 == 0) {
                    try {
                        if (random.nextInt(10) == 2 && ((ScanResult) this.km.get(i5)).SSID != null && ((ScanResult) this.km.get(i5)).SSID.length() < 30) {
                            stringBuffer.append(((ScanResult) this.km.get(i5)).SSID);
                            size = 1;
                        }
                        size = i4;
                    } catch (Exception e2) {
                        obj2 = obj;
                        i6 = i2;
                        i7 = i3;
                        i3 = i4;
                        i4 = i7;
                    }
                } else {
                    if (i4 == 1) {
                        if (random.nextInt(20) == 1 && ((ScanResult) this.km.get(i5)).SSID != null && ((ScanResult) this.km.get(i5)).SSID.length() < 30) {
                            stringBuffer.append(((ScanResult) this.km.get(i5)).SSID);
                            size = 2;
                        }
                    }
                    size = i4;
                }
                i4 = i3;
                i3 = size;
                obj2 = obj;
                i6 = i2;
            }
            i5++;
            i2 = i6;
            obj = obj2;
            i7 = i4;
            i4 = i3;
            i3 = i7;
        }
        if (obj != null) {
            return null;
        }
        stringBuffer.append("&wf_n=" + i3);
        if (0 > kj && arrayList.size() > 0) {
            StringBuffer stringBuffer2 = new StringBuffer(128);
            stringBuffer2.append("&wf_ut=");
            Long l = (Long) arrayList.get(0);
            obj = 1;
            for (Long l2 : arrayList) {
                Object obj3;
                if (obj != null) {
                    stringBuffer2.append(l2.longValue());
                    obj3 = null;
                } else {
                    long longValue = l2.longValue() - l.longValue();
                    if (longValue != 0) {
                        stringBuffer2.append("" + longValue);
                    }
                    obj3 = obj;
                }
                stringBuffer2.append("|");
                obj = obj3;
            }
            stringBuffer.append(stringBuffer2.toString());
        }
        stringBuffer.append("&wf_st=");
        stringBuffer.append(this.kk);
        stringBuffer.append("&wf_et=");
        stringBuffer.append(this.kn);
        stringBuffer.append("&wf_vt=");
        stringBuffer.append(e.j7);
        if (i3 > 0) {
            this.kl = true;
            stringBuffer.append("&wf_en=");
            stringBuffer.append(this.ko ? 1 : 0);
        }
        return stringBuffer.toString();
    }

    public boolean dp() {
        return System.currentTimeMillis() - this.kn < e.kc;
    }

    public String dq() {
        StringBuffer stringBuffer = new StringBuffer(512);
        stringBuffer.append("wifi info:");
        if (dn() < 1) {
            return stringBuffer.toString();
        }
        int size = this.km.size();
        if (size > 10) {
            size = 10;
        }
        int i = 0;
        int i2 = 1;
        while (i < size) {
            int i3;
            if (((ScanResult) this.km.get(i)).level == 0) {
                i3 = i2;
            } else if (i2 != 0) {
                stringBuffer.append("wifi=");
                stringBuffer.append(((ScanResult) this.km.get(i)).BSSID.replace(Separators.COLON, ""));
                i3 = ((ScanResult) this.km.get(i)).level;
                stringBuffer.append(String.format(Locale.CHINA, ";%d;", new Object[]{Integer.valueOf(i3)}));
                i3 = 0;
            } else {
                stringBuffer.append(Separators.SEMICOLON);
                stringBuffer.append(((ScanResult) this.km.get(i)).BSSID.replace(Separators.COLON, ""));
                i3 = ((ScanResult) this.km.get(i)).level;
                stringBuffer.append(String.format(Locale.CHINA, ",%d;", new Object[]{Integer.valueOf(i3)}));
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return stringBuffer.toString();
    }

    public String dr() {
        try {
            return do(k.cD, true);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean ds() {
        return System.currentTimeMillis() - this.kn < 3000;
    }

    public String e(int i) {
        return do(i, false);
    }

    public String h(int i) {
        StringBuffer stringBuffer = new StringBuffer(512);
        if (dn() < 1) {
            return stringBuffer.toString();
        }
        int size = this.km.size();
        if (size <= i) {
            i = size;
        }
        int i2 = 0;
        int i3 = 1;
        while (i2 < i) {
            if (((ScanResult) this.km.get(i2)).level == 0) {
                size = i3;
            } else if (i3 != 0) {
                stringBuffer.append(((ScanResult) this.km.get(i2)).BSSID.replace(Separators.COLON, ""));
                size = -((ScanResult) this.km.get(i2)).level;
                stringBuffer.append(String.format(Locale.CHINA, ";%d|", new Object[]{Integer.valueOf(size)}));
                size = 0;
            } else {
                stringBuffer.append(((ScanResult) this.km.get(i2)).BSSID.replace(Separators.COLON, ""));
                size = -((ScanResult) this.km.get(i2)).level;
                stringBuffer.append(String.format(Locale.CHINA, ";%d|", new Object[]{Integer.valueOf(size)}));
                size = i3;
            }
            i2++;
            i3 = size;
        }
        return stringBuffer.toString();
    }

    public String i(int i) {
        int i2 = 0;
        try {
            if (dn() < 1) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer(512);
            int size = this.km.size();
            if (size <= i) {
                i = size;
            }
            while (i2 < i) {
                if (((ScanResult) this.km.get(i2)).level != 0) {
                    stringBuffer.append(String.format(Locale.CHINA, "<access-point>\n<mac>%s</mac>\n<signal-strength>%d</signal-strength>\n</access-point>\n", new Object[]{((ScanResult) this.km.get(i2)).BSSID.replace(Separators.COLON, ""), Integer.valueOf(((ScanResult) this.km.get(i2)).level)}));
                }
                i2++;
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean int(f fVar) {
        if (this.km == null || fVar == null || fVar.km == null) {
            return false;
        }
        int size = this.km.size() < fVar.km.size() ? this.km.size() : fVar.km.size();
        for (int i = 0; i < size; i++) {
            String str = ((ScanResult) this.km.get(i)).BSSID;
            int i2 = ((ScanResult) this.km.get(i)).level;
            String str2 = ((ScanResult) fVar.km.get(i)).BSSID;
            int i3 = ((ScanResult) fVar.km.get(i)).level;
            if (!str.equals(str2) || i2 != i3) {
                return false;
            }
        }
        return true;
    }

    public String j(int i) {
        if (i == 0 || dn() < 1) {
            return null;
        }
        int i2;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.km.size() > k.cD) {
            i2 = k.cD;
        }
        i2 = 0;
        int i3 = 1;
        for (int i4 = 0; i4 < k.cD; i4++) {
            if ((i3 & i) != 0) {
                if (i2 == 0) {
                    stringBuffer.append("&ssid=");
                } else {
                    stringBuffer.append("|");
                }
                stringBuffer.append(((ScanResult) this.km.get(i4)).BSSID.replace(Separators.COLON, ""));
                stringBuffer.append(Separators.SEMICOLON);
                stringBuffer.append(((ScanResult) this.km.get(i4)).SSID);
                i2++;
            }
            i3 <<= 1;
        }
        return stringBuffer.toString();
    }

    public boolean new(f fVar) {
        if (this.km == null || fVar == null || fVar.km == null) {
            return false;
        }
        int size = this.km.size() < fVar.km.size() ? this.km.size() : fVar.km.size();
        for (int i = 0; i < size; i++) {
            if (!((ScanResult) this.km.get(i)).BSSID.equals(((ScanResult) fVar.km.get(i)).BSSID)) {
                return false;
            }
        }
        return true;
    }

    public boolean try(f fVar) {
        return e.if(fVar, this, k.bF);
    }
}
