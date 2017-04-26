package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.Poi;
import com.baidu.location.b.m;
import com.baidu.mapapi.map.WeightedLatLng;
import com.baidu.mobstat.Config;
import com.tencent.stat.DeviceInfo;
import gov.nist.core.Separators;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

final class a implements com.baidu.location.b.b {
    private final d b;
    private int c;
    private double d;
    private double e;
    private Long f;
    private final b g = new b(this, this, true);
    private final b h = new b(this, this, false);
    private final SQLiteDatabase i;
    private final SQLiteDatabase j;
    private StringBuffer k = null;
    private StringBuffer l = null;
    private HashSet m = new HashSet();
    private ConcurrentHashMap n = new ConcurrentHashMap();
    private ConcurrentHashMap o = new ConcurrentHashMap();
    private StringBuffer p = new StringBuffer();
    private boolean q = false;

    private class a extends Thread {
        private String a;
        final /* synthetic */ a b;
        private Long c;
        private BDLocation d;
        private BDLocation e;
        private BDLocation f;
        private String g;
        private LinkedHashMap h;

        private a(a aVar, String str, Long l, BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str2, LinkedHashMap linkedHashMap) {
            this.b = aVar;
            this.a = str;
            this.c = l;
            this.d = bDLocation;
            this.e = bDLocation2;
            this.f = bDLocation3;
            this.g = str2;
            this.h = linkedHashMap;
        }

        public void run() {
            this.b.a(this.a, this.c, this.d);
            this.b.k = null;
            this.b.l = null;
            this.b.a(this.h);
            this.b.a(this.f, this.d, this.e, this.a, this.c);
            if (this.g != null) {
                this.b.b.j().a(this.g);
            }
            this.h = null;
            this.a = null;
            this.g = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
        }
    }

    private final class b extends m {
        final /* synthetic */ a b;
        private String c;
        private final String d;
        private String e;
        private a f;
        private boolean g = false;
        private int h = 0;
        private long i = -1;
        private long j = -1;
        private long k = -1;
        private long l = -1;

        b(a aVar, a aVar2, boolean z) {
            this.b = aVar;
            this.f = aVar2;
            if (z) {
                this.d = "load";
            } else {
                this.d = AlixDefine.actionUpdate;
            }
            this.c7 = new ArrayList();
            this.c = d.ak;
        }

        private void a(String str, String str2, String str3) {
            this.e = str3;
            this.c = String.format("http://%s/%s", new Object[]{str, str2});
            ao();
        }

        private void b() {
            this.h++;
            this.i = System.currentTimeMillis();
        }

        private boolean c() {
            if (this.h < 2) {
                return true;
            }
            if (this.i + 43200000 >= System.currentTimeMillis()) {
                return false;
            }
            this.h = 0;
            this.i = -1;
            return true;
        }

        private void d() {
            this.e = null;
            if (!i()) {
                this.e = f();
            } else if (this.j == -1 || this.j + 86400000 <= System.currentTimeMillis()) {
                this.e = e();
            }
            if (this.e == null && (this.k == -1 || this.k + 86400000 <= System.currentTimeMillis())) {
                if (this.b.b.l().a()) {
                    this.e = g();
                } else {
                    this.e = h();
                }
            }
            if (this.e != null) {
                ao();
            }
        }

        private String e() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                jSONObject.put("type", "0");
                jSONObject.put("cuid", com.baidu.location.b.c.N().bm);
                jSONObject.put(DeviceInfo.TAG_VERSION, "1");
                jSONObject.put("prod", com.baidu.location.b.c.bj + Separators.COLON + com.baidu.location.b.c.bn);
            } catch (Exception e) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.G(jSONObject.toString()) : null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String f() {
            /*
            r11 = this;
            r4 = 0;
            r1 = 0;
            r6 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0175, all -> 0x015a }
            r6.<init>();	 Catch:{ Exception -> 0x0175, all -> 0x015a }
            r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0175, all -> 0x015a }
            r0.<init>();	 Catch:{ Exception -> 0x0175, all -> 0x015a }
            r2 = r11.b;	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r2 = r2.j;	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r3 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r5 = 3;
            r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r7 = 0;
            r8 = "CL";
            r5[r7] = r8;	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r7 = 1;
            r8 = 5;
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r5[r7] = r8;	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r7 = 2;
            r8 = 50;
            r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r5[r7] = r8;	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r3 = java.lang.String.format(r3, r5);	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            r5 = 0;
            r2 = r2.rawQuery(r3, r5);	 Catch:{ Exception -> 0x017b, all -> 0x015a }
            if (r2 == 0) goto L_0x0186;
        L_0x0038:
            r3 = r2.moveToFirst();	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            if (r3 == 0) goto L_0x0186;
        L_0x003e:
            r3 = r2.getCount();	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r5 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r5.<init>();	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
        L_0x0047:
            r7 = r2.isAfterLast();	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            if (r7 != 0) goto L_0x00a8;
        L_0x004d:
            r7 = 1;
            r7 = r2.getString(r7);	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r5.put(r7);	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r2.moveToNext();	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            goto L_0x0047;
        L_0x0059:
            r3 = move-exception;
            r3 = r1;
        L_0x005b:
            if (r3 == 0) goto L_0x0060;
        L_0x005d:
            r3.close();	 Catch:{ Exception -> 0x0169 }
        L_0x0060:
            if (r2 == 0) goto L_0x0183;
        L_0x0062:
            r2.close();	 Catch:{ Exception -> 0x0156 }
            r2 = r0;
        L_0x0066:
            if (r2 == 0) goto L_0x0180;
        L_0x0068:
            r0 = "model";
            r0 = r2.has(r0);
            if (r0 != 0) goto L_0x0180;
        L_0x0070:
            r4 = r11.l;
            r6 = -1;
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r0 == 0) goto L_0x0086;
        L_0x0078:
            r4 = r11.l;
            r6 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
            r4 = r4 + r6;
            r6 = java.lang.System.currentTimeMillis();
            r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
            if (r0 >= 0) goto L_0x0180;
        L_0x0086:
            r0 = r2.toString();
            r1 = com.baidu.location.Jni.G(r0);
            r4 = java.lang.System.currentTimeMillis();
            r11.l = r4;
            r0 = r1;
        L_0x0095:
            if (r2 == 0) goto L_0x00a7;
        L_0x0097:
            r1 = "model";
            r1 = r2.has(r1);
            if (r1 == 0) goto L_0x00a7;
        L_0x009f:
            r0 = r2.toString();
            r0 = com.baidu.location.Jni.G(r0);
        L_0x00a7:
            return r0;
        L_0x00a8:
            r7 = "cell";
            r6.put(r7, r5);	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r5 = r3;
        L_0x00ae:
            r3 = r11.b;	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r3 = r3.j;	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r7 = "SELECT * FROM %s WHERE frequency>%d ORDER BY frequency DESC LIMIT %d;";
            r8 = 3;
            r8 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r9 = 0;
            r10 = "AP";
            r8[r9] = r10;	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r9 = 1;
            r10 = 5;
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r9 = 2;
            r10 = 50;
            r10 = java.lang.Integer.valueOf(r10);	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r8[r9] = r10;	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r7 = java.lang.String.format(r7, r8);	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            r8 = 0;
            r3 = r3.rawQuery(r7, r8);	 Catch:{ Exception -> 0x0059, all -> 0x0170 }
            if (r3 == 0) goto L_0x0103;
        L_0x00da:
            r7 = r3.moveToFirst();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            if (r7 == 0) goto L_0x0103;
        L_0x00e0:
            r4 = r3.getCount();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r7 = new org.json.JSONArray;	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r7.<init>();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
        L_0x00e9:
            r8 = r3.isAfterLast();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            if (r8 != 0) goto L_0x00fe;
        L_0x00ef:
            r8 = 1;
            r8 = r3.getString(r8);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r7.put(r8);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r3.moveToNext();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            goto L_0x00e9;
        L_0x00fb:
            r4 = move-exception;
            goto L_0x005b;
        L_0x00fe:
            r8 = "ap";
            r6.put(r8, r7);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
        L_0x0103:
            r7 = "type";
            r8 = "1";
            r0.put(r7, r8);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r7 = "cuid";
            r8 = com.baidu.location.b.c.N();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r8 = r8.bm;	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r0.put(r7, r8);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r7 = "ver";
            r8 = "1";
            r0.put(r7, r8);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r7 = "prod";
            r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r8.<init>();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r9 = com.baidu.location.b.c.bj;	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r9 = ":";
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r9 = com.baidu.location.b.c.bn;	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r8 = r8.append(r9);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r8 = r8.toString();	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            r0.put(r7, r8);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
            if (r5 != 0) goto L_0x0140;
        L_0x013e:
            if (r4 == 0) goto L_0x0145;
        L_0x0140:
            r4 = "model";
            r0.put(r4, r6);	 Catch:{ Exception -> 0x00fb, all -> 0x0172 }
        L_0x0145:
            if (r3 == 0) goto L_0x014a;
        L_0x0147:
            r3.close();	 Catch:{ Exception -> 0x0167 }
        L_0x014a:
            if (r2 == 0) goto L_0x0183;
        L_0x014c:
            r2.close();	 Catch:{ Exception -> 0x0152 }
            r2 = r0;
            goto L_0x0066;
        L_0x0152:
            r2 = move-exception;
            r2 = r0;
            goto L_0x0066;
        L_0x0156:
            r2 = move-exception;
            r2 = r0;
            goto L_0x0066;
        L_0x015a:
            r0 = move-exception;
            r2 = r1;
        L_0x015c:
            if (r1 == 0) goto L_0x0161;
        L_0x015e:
            r1.close();	 Catch:{ Exception -> 0x016c }
        L_0x0161:
            if (r2 == 0) goto L_0x0166;
        L_0x0163:
            r2.close();	 Catch:{ Exception -> 0x016e }
        L_0x0166:
            throw r0;
        L_0x0167:
            r3 = move-exception;
            goto L_0x014a;
        L_0x0169:
            r3 = move-exception;
            goto L_0x0060;
        L_0x016c:
            r1 = move-exception;
            goto L_0x0161;
        L_0x016e:
            r1 = move-exception;
            goto L_0x0166;
        L_0x0170:
            r0 = move-exception;
            goto L_0x015c;
        L_0x0172:
            r0 = move-exception;
            r1 = r3;
            goto L_0x015c;
        L_0x0175:
            r0 = move-exception;
            r0 = r1;
            r2 = r1;
            r3 = r1;
            goto L_0x005b;
        L_0x017b:
            r2 = move-exception;
            r2 = r1;
            r3 = r1;
            goto L_0x005b;
        L_0x0180:
            r0 = r1;
            goto L_0x0095;
        L_0x0183:
            r2 = r0;
            goto L_0x0066;
        L_0x0186:
            r5 = r4;
            goto L_0x00ae;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.b.f():java.lang.String");
        }

        private String g() {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("type", "2");
                    jSONObject.put(DeviceInfo.TAG_VERSION, "1");
                    jSONObject.put("cuid", com.baidu.location.b.c.N().bm);
                    jSONObject.put("prod", com.baidu.location.b.c.bj + Separators.COLON + com.baidu.location.b.c.bn);
                    this.k = System.currentTimeMillis();
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.G(jSONObject.toString()) : null;
        }

        private String h() {
            JSONObject jSONObject;
            try {
                JSONObject b = this.b.b.l().b();
                if (b != null) {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "3");
                        jSONObject.put(DeviceInfo.TAG_VERSION, "1");
                        jSONObject.put("cuid", com.baidu.location.b.c.N().bm);
                        jSONObject.put("prod", com.baidu.location.b.c.bj + Separators.COLON + com.baidu.location.b.c.bn);
                        jSONObject.put("rgc", b);
                        this.k = System.currentTimeMillis();
                    } catch (Exception e) {
                    }
                } else {
                    jSONObject = null;
                }
            } catch (Exception e2) {
                jSONObject = null;
            }
            return jSONObject != null ? Jni.G(jSONObject.toString()) : null;
        }

        private boolean i() {
            Throwable th;
            Cursor cursor = null;
            boolean z = true;
            Cursor rawQuery;
            try {
                rawQuery = this.b.i.rawQuery("SELECT COUNT(*) FROM AP;", null);
                try {
                    cursor = this.b.i.rawQuery("SELECT COUNT(*) FROM CL", null);
                    if (!(rawQuery == null || !rawQuery.moveToFirst() || cursor == null || !cursor.moveToFirst() || (rawQuery.getInt(0) == 0 && cursor.getInt(0) == 0))) {
                        z = false;
                    }
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e2) {
                        }
                    }
                } catch (Exception e3) {
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e5) {
                        }
                    }
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Exception e7) {
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                rawQuery = cursor;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                return z;
            } catch (Throwable th3) {
                th = th3;
                rawQuery = cursor;
                if (rawQuery != null) {
                    rawQuery.close();
                }
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            return z;
        }

        void a() {
            if (c() && !this.g) {
                this.b.h.d();
            }
        }

        public void au() {
            this.g = true;
            this.c5 = this.c;
            this.c7.clear();
            this.c7.add(new BasicNameValuePair("qt", this.d));
            this.c7.add(new BasicNameValuePair("req", this.e));
        }

        public void int(boolean z) {
            if (!z || this.c6 == null) {
                this.g = false;
                b();
                return;
            }
            new e(this).start();
        }
    }

    private static final class c {
        double a;
        double b;
        double c;

        private c(double d, double d2, double d3) {
            this.a = d;
            this.b = d2;
            this.c = d3;
        }
    }

    a(d dVar) {
        File file;
        SQLiteDatabase openOrCreateDatabase;
        SQLiteDatabase sQLiteDatabase = null;
        this.b = dVar;
        try {
            file = new File(this.b.d(), "ofl_location.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
        } catch (Exception e) {
            openOrCreateDatabase = null;
        }
        this.i = openOrCreateDatabase;
        if (this.i != null) {
            try {
                this.i.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
                this.i.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY,x DOUBLE,y DOUBLE,r INTEGER,cl DOUBLE,timestamp INTEGER, frequency INTEGER DEFAULT 0);");
            } catch (Exception e2) {
            }
        }
        try {
            file = new File(this.b.d(), "ofl_statistics.db");
            if (!file.exists()) {
                file.createNewFile();
            }
            sQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(file, null);
        } catch (Exception e3) {
        }
        this.j = sQLiteDatabase;
        if (this.j != null) {
            try {
                this.j.execSQL("CREATE TABLE IF NOT EXISTS AP (id LONG PRIMARY KEY, originid VARCHAR(15), frequency INTEGER DEFAULT 0);");
                this.j.execSQL("CREATE TABLE IF NOT EXISTS CL (id LONG PRIMARY KEY, originid VARCHAR(40), frequency INTEGER DEFAULT 0);");
            } catch (Exception e4) {
            }
        }
    }

    private double a(double d, double d2, double d3, double d4) {
        double d5 = d4 - d2;
        double d6 = d3 - d;
        double toRadians = Math.toRadians(d);
        Math.toRadians(d2);
        double toRadians2 = Math.toRadians(d3);
        Math.toRadians(d4);
        d5 = Math.toRadians(d5);
        d6 = Math.toRadians(d6);
        d5 = (Math.sin(d5 / 2.0d) * ((Math.cos(toRadians) * Math.cos(toRadians2)) * Math.sin(d5 / 2.0d))) + (Math.sin(d6 / 2.0d) * Math.sin(d6 / 2.0d));
        return (Math.atan2(Math.sqrt(d5), Math.sqrt(WeightedLatLng.DEFAULT_INTENSITY - d5)) * 2.0d) * 6378137.0d;
    }

    private int a(ArrayList arrayList, double d) {
        if (arrayList.size() == 0) {
            return 0;
        }
        int i = 0;
        while (true) {
            int i2;
            int i3;
            if (arrayList.size() >= 3) {
                double d2 = 0.0d;
                double d3 = 0.0d;
                for (i2 = 0; i2 < arrayList.size(); i2++) {
                    d2 += ((c) arrayList.get(i2)).a;
                    d3 += ((c) arrayList.get(i2)).b;
                }
                d2 /= (double) arrayList.size();
                d3 /= (double) arrayList.size();
                int i4 = 0;
                int i5 = -1;
                double d4 = -1.0d;
                while (i4 < arrayList.size()) {
                    double a = a(d3, d2, ((c) arrayList.get(i4)).b, ((c) arrayList.get(i4)).a);
                    if (a > d4) {
                        i2 = i4;
                    } else {
                        i2 = i5;
                        a = d4;
                    }
                    i4++;
                    i5 = i2;
                    d4 = a;
                }
                if (d4 > d && i5 >= 0 && i5 < arrayList.size()) {
                    i++;
                    arrayList.remove(i5);
                    i2 = 1;
                    i3 = i;
                    if (i2 == 1) {
                        return i3;
                    }
                    i = i3;
                }
            }
            i2 = 0;
            i3 = i;
            if (i2 == 1) {
                return i3;
            }
            i = i3;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.location.BDLocation a(java.lang.Long r20) {
        /*
        r19 = this;
        r2 = 0;
        r0 = r19;
        r0.q = r2;
        r8 = 0;
        r6 = 0;
        r4 = 0;
        r3 = 0;
        r0 = r19;
        r2 = r0.f;
        if (r2 == 0) goto L_0x0046;
    L_0x0011:
        r0 = r19;
        r2 = r0.f;
        r0 = r20;
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x0046;
    L_0x001d:
        r3 = 1;
        r0 = r19;
        r6 = r0.d;
        r0 = r19;
        r4 = r0.e;
        r0 = r19;
        r8 = r0.c;
    L_0x002a:
        if (r3 == 0) goto L_0x010d;
    L_0x002c:
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        r3 = (float) r8;
        r2.setRadius(r3);
        r2.setLatitude(r4);
        r2.setLongitude(r6);
        r3 = "cl";
        r2.setNetworkLocationType(r3);
        r3 = 66;
        r2.setLocType(r3);
    L_0x0045:
        return r2;
    L_0x0046:
        r2 = 0;
        r9 = java.util.Locale.US;
        r10 = "SELECT * FROM CL WHERE id = %d AND timestamp + %d > %d;";
        r11 = 3;
        r11 = new java.lang.Object[r11];
        r12 = 0;
        r11[r12] = r20;
        r12 = 1;
        r13 = 15552000; // 0xed4e00 float:2.1792994E-38 double:7.683709E-317;
        r13 = java.lang.Integer.valueOf(r13);
        r11[r12] = r13;
        r12 = 2;
        r14 = java.lang.System.currentTimeMillis();
        r16 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r14 = r14 / r16;
        r13 = java.lang.Long.valueOf(r14);
        r11[r12] = r13;
        r9 = java.lang.String.format(r9, r10, r11);
        r0 = r19;
        r10 = r0.i;	 Catch:{ Exception -> 0x00f6, all -> 0x0101 }
        r11 = 0;
        r2 = r10.rawQuery(r9, r11);	 Catch:{ Exception -> 0x00f6, all -> 0x0101 }
        if (r2 == 0) goto L_0x00e5;
    L_0x0079:
        r9 = r2.moveToFirst();	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        if (r9 == 0) goto L_0x00e5;
    L_0x007f:
        r9 = "cl";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r10 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r12 = 0;
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r9 <= 0) goto L_0x00e5;
    L_0x008f:
        r3 = 1;
        r9 = "x";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r6 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r9 = "y";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r4 = r2.getDouble(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r9 = "r";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r8 = r2.getInt(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r9 = "timestamp";
        r9 = r2.getColumnIndex(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r9 = r2.getInt(r9);	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r10 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r9 = r9 + r10;
        r10 = (long) r9;	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r12 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r14 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r12 = r12 / r14;
        r9 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r9 >= 0) goto L_0x00cd;
    L_0x00c8:
        r9 = 1;
        r0 = r19;
        r0.q = r9;	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
    L_0x00cd:
        r9 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        if (r8 >= r9) goto L_0x00ef;
    L_0x00d1:
        r8 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
    L_0x00d3:
        r0 = r19;
        r0.d = r6;	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r0 = r19;
        r0.e = r4;	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r0 = r19;
        r0.c = r8;	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
        r0 = r20;
        r1 = r19;
        r1.f = r0;	 Catch:{ Exception -> 0x00f6, all -> 0x0112 }
    L_0x00e5:
        if (r2 == 0) goto L_0x002a;
    L_0x00e7:
        r2.close();	 Catch:{ Exception -> 0x00ec }
        goto L_0x002a;
    L_0x00ec:
        r2 = move-exception;
        goto L_0x002a;
    L_0x00ef:
        r9 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        if (r9 >= r8) goto L_0x00d3;
    L_0x00f3:
        r8 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        goto L_0x00d3;
    L_0x00f6:
        r9 = move-exception;
        if (r2 == 0) goto L_0x002a;
    L_0x00f9:
        r2.close();	 Catch:{ Exception -> 0x00fe }
        goto L_0x002a;
    L_0x00fe:
        r2 = move-exception;
        goto L_0x002a;
    L_0x0101:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
    L_0x0107:
        if (r3 == 0) goto L_0x010c;
    L_0x0109:
        r3.close();	 Catch:{ Exception -> 0x0110 }
    L_0x010c:
        throw r2;
    L_0x010d:
        r2 = 0;
        goto L_0x0045;
    L_0x0110:
        r3 = move-exception;
        goto L_0x010c;
    L_0x0112:
        r3 = move-exception;
        r18 = r3;
        r3 = r2;
        r2 = r18;
        goto L_0x0107;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a(java.lang.Long):com.baidu.location.BDLocation");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.baidu.location.BDLocation a(java.util.LinkedHashMap r34, com.baidu.location.BDLocation r35, int r36) {
        /*
        r33 = this;
        r0 = r33;
        r2 = r0.p;
        r3 = 0;
        r2.setLength(r3);
        r6 = 0;
        r4 = 0;
        r2 = 0;
        if (r35 == 0) goto L_0x0382;
    L_0x000f:
        r2 = 1;
        r4 = r35.getLatitude();
        r6 = r35.getLongitude();
        r21 = r2;
    L_0x001a:
        r28 = 0;
        r26 = 0;
        r24 = 0;
        r23 = 0;
        r10 = new java.lang.StringBuffer;
        r10.<init>();
        r3 = 1;
        r2 = r34.entrySet();
        r11 = r2.iterator();
        r2 = 0;
        r8 = r2;
        r9 = r3;
    L_0x0033:
        r2 = r34.size();
        r3 = 30;
        r2 = java.lang.Math.min(r2, r3);
        if (r8 >= r2) goto L_0x0088;
    L_0x003f:
        r2 = r11.next();
        r2 = (java.util.Map.Entry) r2;
        r3 = r2.getKey();
        r3 = (java.lang.String) r3;
        r2 = r2.getValue();
        r2 = (java.lang.Integer) r2;
        r12 = r2.intValue();
        if (r12 >= 0) goto L_0x0060;
    L_0x0057:
        r2 = r2.intValue();
        r2 = -r2;
        r2 = java.lang.Integer.valueOf(r2);
    L_0x0060:
        r12 = com.baidu.location.Jni.I(r3);
        if (r12 != 0) goto L_0x006c;
    L_0x0066:
        r3 = r9;
    L_0x0067:
        r2 = r8 + 1;
        r8 = r2;
        r9 = r3;
        goto L_0x0033;
    L_0x006c:
        r0 = r33;
        r13 = r0.o;
        r13.put(r12, r3);
        if (r9 == 0) goto L_0x0082;
    L_0x0075:
        r9 = 0;
    L_0x0076:
        r0 = r33;
        r3 = r0.n;
        r3.put(r12, r2);
        r10.append(r12);
        r3 = r9;
        goto L_0x0067;
    L_0x0082:
        r3 = 44;
        r10.append(r3);
        goto L_0x0076;
    L_0x0088:
        r2 = java.util.Locale.US;
        r3 = "SELECT * FROM AP WHERE id IN (%s) AND timestamp+%d>%d;";
        r8 = 3;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r8[r9] = r10;
        r9 = 1;
        r10 = 7776000; // 0x76a700 float:1.0896497E-38 double:3.8418545E-317;
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 2;
        r10 = java.lang.System.currentTimeMillis();
        r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r10 = r10 / r12;
        r10 = java.lang.Long.valueOf(r10);
        r8[r9] = r10;
        r3 = java.lang.String.format(r2, r3, r8);
        r2 = 0;
        r0 = r33;
        r8 = r0.i;	 Catch:{ Exception -> 0x034b, all -> 0x0345 }
        r9 = 0;
        r22 = r8.rawQuery(r3, r9);	 Catch:{ Exception -> 0x034b, all -> 0x0345 }
        if (r22 == 0) goto L_0x0379;
    L_0x00ba:
        r2 = r22.moveToFirst();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        if (r2 == 0) goto L_0x0379;
    L_0x00c0:
        r29 = new java.util.ArrayList;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r29.<init>();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
    L_0x00c5:
        r2 = r22.isAfterLast();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        if (r2 != 0) goto L_0x022e;
    L_0x00cb:
        r2 = 0;
        r0 = r22;
        r2 = r0.getLong(r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r2 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = 1;
        r0 = r22;
        r10 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = 2;
        r0 = r22;
        r8 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = 3;
        r0 = r22;
        r12 = r0.getInt(r3);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = 4;
        r0 = r22;
        r14 = r0.getDouble(r3);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = 5;
        r0 = r22;
        r3 = r0.getInt(r3);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r0 = r33;
        r13 = r0.m;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r13.add(r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r13 = 604800; // 0x93a80 float:8.47505E-40 double:2.98811E-318;
        r3 = r3 + r13;
        r0 = (long) r3;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r16 = r0;
        r18 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r30 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r18 = r18 / r30;
        r3 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1));
        if (r3 >= 0) goto L_0x0160;
    L_0x0113:
        r0 = r33;
        r3 = r0.p;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = r3.length();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        if (r3 <= 0) goto L_0x0126;
    L_0x011d:
        r0 = r33;
        r3 = r0.p;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r13 = ",";
        r3.append(r13);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
    L_0x0126:
        r0 = r33;
        r3 = r0.p;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r13 = java.util.Locale.US;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r16 = "(%d,\"%s\",%d)";
        r17 = 3;
        r0 = r17;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r17 = r0;
        r18 = 0;
        r17[r18] = r2;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r18 = 1;
        r0 = r33;
        r0 = r0.o;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r19 = r0;
        r0 = r19;
        r19 = r0.get(r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r17[r18] = r19;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r18 = 2;
        r19 = 100000; // 0x186a0 float:1.4013E-40 double:4.94066E-319;
        r19 = java.lang.Integer.valueOf(r19);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r17[r18] = r19;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r0 = r16;
        r1 = r17;
        r13 = java.lang.String.format(r13, r0, r1);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3.append(r13);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
    L_0x0160:
        r16 = 0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 > 0) goto L_0x0197;
    L_0x0166:
        r22.moveToNext();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        goto L_0x00c5;
    L_0x016b:
        r2 = move-exception;
        r2 = r22;
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
    L_0x0176:
        if (r2 == 0) goto L_0x017b;
    L_0x0178:
        r2.close();	 Catch:{ Exception -> 0x033f }
    L_0x017b:
        if (r3 == 0) goto L_0x033c;
    L_0x017d:
        r2 = new com.baidu.location.BDLocation;
        r2.<init>();
        r3 = (float) r4;
        r2.setRadius(r3);
        r2.setLatitude(r12);
        r2.setLongitude(r10);
        r3 = "wf";
        r2.setNetworkLocationType(r3);
        r3 = 66;
        r2.setLocType(r3);
    L_0x0196:
        return r2;
    L_0x0197:
        r14 = 0;
        r3 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x01a9;
    L_0x019d:
        r14 = 0;
        r3 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1));
        if (r3 <= 0) goto L_0x01a9;
    L_0x01a3:
        if (r12 <= 0) goto L_0x01a9;
    L_0x01a5:
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r12 < r3) goto L_0x01b5;
    L_0x01a9:
        r22.moveToNext();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        goto L_0x00c5;
    L_0x01ae:
        r2 = move-exception;
    L_0x01af:
        if (r22 == 0) goto L_0x01b4;
    L_0x01b1:
        r22.close();	 Catch:{ Exception -> 0x0342 }
    L_0x01b4:
        throw r2;
    L_0x01b5:
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x01ce;
    L_0x01ba:
        r3 = r33;
        r14 = r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r16 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 <= 0) goto L_0x01ce;
    L_0x01c9:
        r22.moveToNext();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        goto L_0x00c5;
    L_0x01ce:
        r0 = r33;
        r3 = r0.n;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r2 = r3.get(r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r2 = (java.lang.Integer) r2;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r2 = r2.intValue();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = 30;
        r2 = java.lang.Math.max(r3, r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r3 = 100;
        r2 = java.lang.Math.min(r3, r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = 70;
        if (r2 <= r3) goto L_0x0225;
    L_0x01ee:
        r2 = r2 + -70;
        r2 = (double) r2;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r16 = 4629137466983448576; // 0x403e000000000000 float:0.0 double:30.0;
        r2 = r2 / r16;
        r2 = r2 + r14;
    L_0x01f6:
        r14 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r12 = (double) r12;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r12 = java.lang.Math.max(r14, r12);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r14 = 4603579539098121011; // 0x3fe3333333333333 float:4.172325E-8 double:0.6;
        r12 = java.lang.Math.pow(r12, r14);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r14 = -4634023872579145564; // 0xbfb0a3d70a3d70a4 float:9.121204E-33 double:-0.065;
        r12 = r12 * r14;
        r2 = r2 * r12;
        r18 = java.lang.Math.exp(r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r13 = new com.baidu.location.c.a$c;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r20 = 0;
        r14 = r10;
        r16 = r8;
        r13.<init>(r14, r16, r18);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r0 = r29;
        r0.add(r13);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r22.moveToNext();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        goto L_0x00c5;
    L_0x0225:
        r2 = r2 + -70;
        r2 = (double) r2;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r16 = 4632233691727265792; // 0x4049000000000000 float:0.0 double:50.0;
        r2 = r2 / r16;
        r2 = r2 + r14;
        goto L_0x01f6;
    L_0x022e:
        r2 = 4652007308841189376; // 0x408f400000000000 float:0.0 double:1000.0;
        r0 = r33;
        r1 = r29;
        r0.a(r1, r2);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r10 = 0;
        r12 = 0;
        r8 = 0;
        r2 = 0;
        r16 = r2;
    L_0x0243:
        r2 = r29.size();	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r0 = r16;
        if (r0 >= r2) goto L_0x027e;
    L_0x024b:
        r0 = r29;
        r1 = r16;
        r2 = r0.get(r1);	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r2 = (com.baidu.location.c.a.c) r2;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r14 = r2.c;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r18 = 0;
        r3 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1));
        if (r3 > 0) goto L_0x0266;
    L_0x025d:
        r2 = r8;
        r8 = r12;
    L_0x025f:
        r12 = r16 + 1;
        r16 = r12;
        r12 = r8;
        r8 = r2;
        goto L_0x0243;
    L_0x0266:
        r14 = r2.a;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r0 = r2.c;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r18 = r0;
        r14 = r14 * r18;
        r14 = r14 + r10;
        r10 = r2.b;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r0 = r2.c;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r18 = r0;
        r10 = r10 * r18;
        r10 = r10 + r12;
        r2 = r2.c;	 Catch:{ Exception -> 0x016b, all -> 0x01ae }
        r2 = r2 + r8;
        r8 = r10;
        r10 = r14;
        goto L_0x025f;
    L_0x027e:
        r2 = 0;
        r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x036f;
    L_0x0284:
        r2 = 0;
        r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x036f;
    L_0x028a:
        r2 = 0;
        r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        if (r2 <= 0) goto L_0x036f;
    L_0x0290:
        r10 = r10 / r8;
        r12 = r12 / r8;
        r3 = 1;
        r8 = 0;
        r2 = 0;
        r32 = r2;
        r2 = r8;
        r8 = r32;
    L_0x029a:
        r9 = r29.size();	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        if (r8 >= r9) goto L_0x02c7;
    L_0x02a0:
        r0 = (double) r2;	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r18 = r0;
        r0 = r29;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r2 = (com.baidu.location.c.a.c) r2;	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r14 = r2.a;	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r0 = r29;
        r2 = r0.get(r8);	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r2 = (com.baidu.location.c.a.c) r2;	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r0 = r2.b;	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r16 = r0;
        r9 = r33;
        r14 = r9.a(r10, r12, r14, r16);	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r14 = r14 + r18;
        r9 = (float) r14;	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r2 = r8 + 1;
        r8 = r2;
        r2 = r9;
        goto L_0x029a;
    L_0x02c7:
        r8 = r29.size();	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r8 = (float) r8;	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r2 = r2 / r8;
        r28 = java.lang.Math.round(r2);	 Catch:{ Exception -> 0x0356, all -> 0x01ae }
        r2 = 30;
        r0 = r28;
        if (r0 >= r2) goto L_0x032f;
    L_0x02d7:
        r28 = 30;
        r2 = r3;
        r8 = r12;
        r12 = r28;
    L_0x02dd:
        if (r21 != 0) goto L_0x02e7;
    L_0x02df:
        r3 = r29.size();	 Catch:{ Exception -> 0x035d, all -> 0x01ae }
        r13 = 1;
        if (r3 > r13) goto L_0x02e7;
    L_0x02e6:
        r2 = 0;
    L_0x02e7:
        r3 = r29.size();	 Catch:{ Exception -> 0x035d, all -> 0x01ae }
        r0 = r36;
        if (r3 >= r0) goto L_0x030a;
    L_0x02ef:
        r14 = 4607182418800017408; // 0x3ff0000000000000 float:0.0 double:1.0;
        r3 = r29.size();	 Catch:{ Exception -> 0x035d, all -> 0x01ae }
        r0 = (double) r3;	 Catch:{ Exception -> 0x035d, all -> 0x01ae }
        r16 = r0;
        r14 = r14 * r16;
        r3 = r34.size();	 Catch:{ Exception -> 0x035d, all -> 0x01ae }
        r0 = (double) r3;	 Catch:{ Exception -> 0x035d, all -> 0x01ae }
        r16 = r0;
        r14 = r14 / r16;
        r16 = 4602678819172646912; // 0x3fe0000000000000 float:0.0 double:0.5;
        r3 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1));
        if (r3 >= 0) goto L_0x030a;
    L_0x0309:
        r2 = 0;
    L_0x030a:
        r3 = 1;
        r0 = r21;
        if (r0 != r3) goto L_0x0365;
    L_0x030f:
        r3 = 1;
        if (r2 != r3) goto L_0x0365;
    L_0x0312:
        r3 = r33;
        r4 = r3.a(r4, r6, r8, r10);	 Catch:{ Exception -> 0x035d, all -> 0x01ae }
        r6 = 4666723172467343360; // 0x40c3880000000000 float:0.0 double:10000.0;
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0365;
    L_0x0321:
        r2 = 0;
        r3 = r2;
        r4 = r12;
        r12 = r8;
    L_0x0325:
        if (r22 == 0) goto L_0x017b;
    L_0x0327:
        r22.close();	 Catch:{ Exception -> 0x032c }
        goto L_0x017b;
    L_0x032c:
        r2 = move-exception;
        goto L_0x017b;
    L_0x032f:
        r2 = 100;
        r0 = r28;
        if (r2 >= r0) goto L_0x0369;
    L_0x0335:
        r28 = 100;
        r2 = r3;
        r8 = r12;
        r12 = r28;
        goto L_0x02dd;
    L_0x033c:
        r2 = 0;
        goto L_0x0196;
    L_0x033f:
        r2 = move-exception;
        goto L_0x017b;
    L_0x0342:
        r3 = move-exception;
        goto L_0x01b4;
    L_0x0345:
        r3 = move-exception;
        r22 = r2;
        r2 = r3;
        goto L_0x01af;
    L_0x034b:
        r3 = move-exception;
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
        goto L_0x0176;
    L_0x0356:
        r2 = move-exception;
        r2 = r22;
        r4 = r28;
        goto L_0x0176;
    L_0x035d:
        r3 = move-exception;
        r3 = r2;
        r4 = r12;
        r12 = r8;
        r2 = r22;
        goto L_0x0176;
    L_0x0365:
        r3 = r2;
        r4 = r12;
        r12 = r8;
        goto L_0x0325;
    L_0x0369:
        r2 = r3;
        r8 = r12;
        r12 = r28;
        goto L_0x02dd;
    L_0x036f:
        r2 = r23;
        r8 = r24;
        r10 = r26;
        r12 = r28;
        goto L_0x02dd;
    L_0x0379:
        r3 = r23;
        r12 = r24;
        r10 = r26;
        r4 = r28;
        goto L_0x0325;
    L_0x0382:
        r21 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.c.a.a(java.util.LinkedHashMap, com.baidu.location.BDLocation, int):com.baidu.location.BDLocation");
    }

    private void a(BDLocation bDLocation, BDLocation bDLocation2, BDLocation bDLocation3, String str, Long l) {
        if (bDLocation != null && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
            String format;
            String format2;
            if (bDLocation2 != null && bDLocation.getNetworkLocationType().equals(Config.CELL_LOCATION) && a(bDLocation2.getLatitude(), bDLocation2.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 300.0d) {
                format = String.format(Locale.US, "UPDATE CL SET cl = 0 WHERE id = %d;", new Object[]{l});
                format2 = String.format(Locale.US, "INSERT OR REPLACE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)});
                try {
                    this.i.execSQL(format);
                    this.j.execSQL(format2);
                } catch (Exception e) {
                }
            }
            if (bDLocation3 != null && bDLocation.getNetworkLocationType().equals("wf") && a(bDLocation3.getLatitude(), bDLocation3.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude()) > 100.0d) {
                format = String.format("UPDATE AP SET cl = 0 WHERE id In (%s);", new Object[]{this.k.toString()});
                format2 = String.format("INSERT OR REPLACE INTO AP VALUES %s;", new Object[]{this.l.toString()});
                try {
                    this.i.execSQL(format);
                    this.j.execSQL(format2);
                } catch (Exception e2) {
                }
            }
        }
    }

    private void a(String str, Long l, BDLocation bDLocation) {
        if (str != null) {
            if (bDLocation != null) {
                try {
                    this.i.execSQL(String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l}));
                } catch (Exception e) {
                }
            } else {
                String format = String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",0);", new Object[]{l, str});
                String format2 = String.format(Locale.US, "UPDATE CL SET frequency=frequency+1 WHERE id = %d;", new Object[]{l});
                try {
                    this.j.execSQL(format);
                    this.j.execSQL(format2);
                } catch (Exception e2) {
                }
            }
            if (this.q) {
                try {
                    this.j.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO CL VALUES (%d,\"%s\",%d);", new Object[]{l, str, Integer.valueOf(100000)}));
                } catch (Exception e3) {
                }
            }
        }
    }

    private void a(String str, String str2, String str3) {
        this.g.a(str, str2, str3);
    }

    private void a(LinkedHashMap linkedHashMap) {
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            String str;
            this.k = new StringBuffer();
            this.l = new StringBuffer();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            int i = 1;
            int i2 = 1;
            for (Long l : this.n.keySet()) {
                try {
                    int i3;
                    int i4;
                    if (this.m.contains(l)) {
                        if (i2 != 0) {
                            i2 = 0;
                        } else {
                            this.k.append(',');
                            this.l.append(',');
                        }
                        this.k.append(l);
                        this.l.append('(').append(l).append(',').append('\"').append((String) this.o.get(l)).append('\"').append(',').append(100000).append(')');
                        i3 = i;
                        i4 = i2;
                    } else {
                        str = (String) this.o.get(l);
                        if (i != 0) {
                            i = 0;
                        } else {
                            stringBuffer.append(',');
                            stringBuffer2.append(',');
                        }
                        stringBuffer.append(l);
                        stringBuffer2.append('(').append(l).append(',').append('\"').append(str).append('\"').append(",0)");
                        i3 = i;
                        i4 = i2;
                    }
                    i = i3;
                    i2 = i4;
                } catch (Exception e) {
                    i = i;
                    i2 = i2;
                }
            }
            try {
                this.i.execSQL(String.format(Locale.US, "UPDATE AP SET frequency=frequency+1 WHERE id IN(%s)", new Object[]{this.k.toString()}));
            } catch (Exception e2) {
            }
            if (this.p.length() > 0) {
                if (stringBuffer2.length() > 0) {
                    stringBuffer2.append(",");
                }
                stringBuffer2.append(this.p);
            }
            String format = String.format("INSERT OR IGNORE INTO AP VALUES %s;", new Object[]{stringBuffer2.toString()});
            str = String.format("UPDATE AP SET frequency=frequency+1 WHERE id in (%s);", new Object[]{stringBuffer.toString()});
            try {
                if (stringBuffer2.length() > 0) {
                    this.j.execSQL(format);
                }
                if (stringBuffer.length() > 0) {
                    this.j.execSQL(str);
                }
            } catch (Exception e3) {
            }
        }
    }

    private void a(String[] strArr) {
        this.b.new().a(strArr);
    }

    Cursor a(a aVar) {
        BDLocation bDLocation;
        BDLocation bDLocation2 = new BDLocation();
        bDLocation2.setLocType(67);
        int i = 0;
        if (aVar.c) {
            double[] dArr;
            List list;
            String str = aVar.b;
            LinkedHashMap linkedHashMap = aVar.i;
            int i2 = aVar.f;
            BDLocation bDLocation3 = aVar.g;
            BDLocation bDLocation4 = null;
            Long valueOf = Long.valueOf(Long.MIN_VALUE);
            if (!(str == null || this.i == null)) {
                valueOf = Jni.I(str);
                if (valueOf != null) {
                    bDLocation4 = a(valueOf);
                }
            }
            BDLocation bDLocation5 = null;
            if (!(linkedHashMap == null || linkedHashMap.size() <= 0 || this.i == null)) {
                this.n.clear();
                this.m.clear();
                this.o.clear();
                bDLocation5 = a(linkedHashMap, bDLocation4, i2);
            }
            Double d = null;
            Double d2 = null;
            Double d3 = null;
            Double d4 = null;
            if (bDLocation4 != null) {
                d = Double.valueOf(bDLocation4.getLongitude());
                d2 = Double.valueOf(bDLocation4.getLatitude());
                dArr = Jni.if(bDLocation4.getLongitude(), bDLocation4.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation4.setCoorType("gcj");
                bDLocation4.setLatitude(dArr[1]);
                bDLocation4.setLongitude(dArr[0]);
                bDLocation4.setNetworkLocationType(Config.CELL_LOCATION);
            }
            if (bDLocation5 != null) {
                d3 = Double.valueOf(bDLocation5.getLongitude());
                d4 = Double.valueOf(bDLocation5.getLatitude());
                dArr = Jni.if(bDLocation5.getLongitude(), bDLocation5.getLatitude(), BDLocation.BDLOCATION_BD09LL_TO_GCJ02);
                bDLocation5.setCoorType("gcj");
                bDLocation5.setLatitude(dArr[1]);
                bDLocation5.setLongitude(dArr[0]);
                bDLocation5.setNetworkLocationType("wf");
            }
            if (bDLocation4 != null && bDLocation5 == null) {
                i = 1;
            } else if (bDLocation4 == null && bDLocation5 != null) {
                i = 2;
            } else if (!(bDLocation4 == null || bDLocation5 == null)) {
                i = 4;
            }
            Object obj = aVar.f > 0 ? 1 : null;
            Object obj2 = (linkedHashMap == null || linkedHashMap.size() <= 0) ? 1 : null;
            if (obj != null) {
                if (bDLocation5 != null) {
                    d2 = d3;
                    bDLocation = bDLocation5;
                } else {
                    if (!(obj2 == null || bDLocation4 == null)) {
                        d4 = d2;
                        bDLocation = bDLocation4;
                        d2 = d;
                    }
                    d4 = null;
                    d2 = null;
                    bDLocation = bDLocation2;
                }
            } else if (bDLocation5 != null) {
                d2 = d3;
                bDLocation = bDLocation5;
            } else {
                if (bDLocation4 != null) {
                    d4 = d2;
                    bDLocation = bDLocation4;
                    d2 = d;
                }
                d4 = null;
                d2 = null;
                bDLocation = bDLocation2;
            }
            if (aVar.e && this.b.new().l() && d4 != null && d2 != null) {
                bDLocation.setAddr(this.b.l().a(d2.doubleValue(), d4.doubleValue()));
            }
            if (obj != null && aVar.e && bDLocation.getAddrStr() == null) {
                d4 = null;
                d2 = null;
                i = 0;
                bDLocation = bDLocation2;
            }
            if ((!aVar.d && !aVar.h) || d4 == null || d2 == null) {
                list = null;
            } else {
                List b = this.b.l().b(d2.doubleValue(), d4.doubleValue());
                if (aVar.d) {
                    bDLocation.setPoiList(b);
                }
                list = b;
            }
            if (obj == null || !aVar.d || (list != null && list.size() > 0)) {
                i2 = i;
            } else {
                i2 = 0;
                bDLocation = bDLocation2;
            }
            String str2 = null;
            if (aVar.h && list != null && list.size() > 0) {
                str2 = String.format(Locale.CHINA, "在%s附近", new Object[]{((Poi) list.get(0)).getName()});
                bDLocation.setLocationDescribe(str2);
            }
            if (obj != null && aVar.h && r4 == null) {
                i2 = 0;
                bDLocation = bDLocation2;
            }
            StringBuffer stringBuffer = new StringBuffer();
            String str3 = null;
            if (aVar.a != null) {
                stringBuffer.append(aVar.a);
                stringBuffer.append(h.a(bDLocation5, bDLocation4, aVar));
                stringBuffer.append(h.a(bDLocation, i2));
                str3 = stringBuffer.toString();
            }
            new c(this, str, valueOf, bDLocation4, bDLocation5, bDLocation3, str3, linkedHashMap).start();
        } else {
            bDLocation = bDLocation2;
        }
        return h.a(bDLocation);
    }

    SQLiteDatabase a() {
        return this.j;
    }

    void b() {
        this.h.a();
    }
}
