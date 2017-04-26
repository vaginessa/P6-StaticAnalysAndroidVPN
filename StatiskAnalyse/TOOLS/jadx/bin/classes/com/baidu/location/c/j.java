package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.c;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import com.baidu.location.h.e;
import com.tencent.stat.DeviceInfo;
import gov.nist.core.Separators;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

final class j implements b {
    private final d b;
    private final SQLiteDatabase c;
    private final a d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String[] j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private double o;
    private double p;
    private double q;
    private double r;
    private double s;
    private int t;
    private boolean u = true;
    private long v = 8000;
    private long w = e.kc;
    private long x = e.kc;
    private long y = e.kc;
    private long z = e.kc;

    private final class a extends m implements f {
        final /* synthetic */ j b;
        private int c;
        private long d;
        private long e;
        private boolean f;
        private final String g;

        private a(j jVar) {
            this.b = jVar;
            this.c = 0;
            this.f = false;
            this.d = -1;
            this.e = -1;
            this.c7 = new ArrayList();
            this.g = Jni.G(String.format(Locale.US, "&ver=%s&cuid=%s&prod=%s:%s&sdk=%.2f", new Object[]{"1", c.N().bm, c.bj, c.bn, Float.valueOf(f.bi)}));
        }

        private void a() {
            if (!this.f) {
                boolean z = false;
                try {
                    File file = new File(this.b.b.d(), "ofl.config");
                    if (this.e == -1 && file.exists()) {
                        JSONObject jSONObject;
                        Scanner scanner = new Scanner(file);
                        String next = scanner.next();
                        scanner.close();
                        JSONObject jSONObject2 = new JSONObject(next);
                        this.b.e = jSONObject2.getBoolean("ol");
                        this.b.f = jSONObject2.getBoolean("fl");
                        this.b.g = jSONObject2.getBoolean("on");
                        this.b.h = jSONObject2.getBoolean("wn");
                        this.b.i = jSONObject2.getBoolean("oc");
                        this.e = jSONObject2.getLong("t");
                        if (jSONObject2.has("cplist")) {
                            this.b.j = jSONObject2.getString("cplist").split(Separators.SEMICOLON);
                        }
                        if (jSONObject2.has("rgcgp")) {
                            this.b.l = jSONObject2.getInt("rgcgp");
                        }
                        if (jSONObject2.has("rgcon")) {
                            this.b.k = jSONObject2.getBoolean("rgcon");
                        }
                        if (jSONObject2.has("addrup")) {
                            this.b.n = jSONObject2.getInt("addrup");
                        }
                        if (jSONObject2.has("poiup")) {
                            this.b.m = jSONObject2.getInt("poiup");
                        }
                        if (jSONObject2.has("oflp")) {
                            jSONObject = jSONObject2.getJSONObject("oflp");
                            if (jSONObject.has("0")) {
                                this.b.o = jSONObject.getDouble("0");
                            }
                            if (jSONObject.has("1")) {
                                this.b.p = jSONObject.getDouble("1");
                            }
                            if (jSONObject.has("2")) {
                                this.b.q = jSONObject.getDouble("2");
                            }
                            if (jSONObject.has("3")) {
                                this.b.r = jSONObject.getDouble("3");
                            }
                            if (jSONObject.has("4")) {
                                this.b.s = jSONObject.getDouble("4");
                            }
                        }
                        if (jSONObject2.has("onlt")) {
                            jSONObject = jSONObject2.getJSONObject("onlt");
                            if (jSONObject.has("0")) {
                                this.b.z = jSONObject.getLong("0");
                            }
                            if (jSONObject.has("1")) {
                                this.b.y = jSONObject.getLong("1");
                            }
                            if (jSONObject.has("2")) {
                                this.b.v = jSONObject.getLong("2");
                            }
                            if (jSONObject.has("3")) {
                                this.b.w = jSONObject.getLong("3");
                            }
                            if (jSONObject.has("4")) {
                                this.b.x = jSONObject.getLong("4");
                            }
                        }
                        if (jSONObject2.has("minapn")) {
                            this.b.t = jSONObject2.getInt("minapn");
                        }
                    }
                    if (this.e == -1 && file.exists()) {
                    }
                    if (this.e != -1 && this.e + 86400000 <= System.currentTimeMillis()) {
                        z = true;
                    }
                } catch (Exception e) {
                }
                if ((this.e == -1 || r0) && b() && k.for(this.b.b.char())) {
                    this.f = true;
                    ao();
                }
            }
        }

        private boolean b() {
            boolean z = true;
            if (this.c >= 2) {
                if (this.d + 86400000 < System.currentTimeMillis()) {
                    this.c = 0;
                    this.d = -1;
                } else {
                    z = false;
                }
            }
            return !z ? z : z;
        }

        public void au() {
            this.c7.clear();
            this.c7.add(new BasicNameValuePair("qt", "conf"));
            this.c7.add(new BasicNameValuePair("req", this.g));
            this.c5 = d.ak;
        }

        public void int(boolean z) {
            if (!z || this.c6 == null) {
                this.c++;
                this.d = System.currentTimeMillis();
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
                    Object obj = "1";
                    long j = 0;
                    if (jSONObject.has("ofl")) {
                        j = jSONObject.getLong("ofl");
                    }
                    if (jSONObject.has(DeviceInfo.TAG_VERSION)) {
                        obj = jSONObject.getString(DeviceInfo.TAG_VERSION);
                    }
                    if ((j & 1) == 1) {
                        this.b.e = true;
                    }
                    if ((j & 2) == 2) {
                        this.b.f = true;
                    }
                    if ((j & 4) == 4) {
                        this.b.g = true;
                    }
                    if ((j & 8) == 8) {
                        this.b.h = true;
                    }
                    if ((16 & j) == 16) {
                        this.b.i = true;
                    }
                    if ((j & 32) == 32) {
                        this.b.k = true;
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (jSONObject.has("cplist")) {
                        this.b.j = jSONObject.getString("cplist").split(Separators.SEMICOLON);
                        jSONObject2.put("cplist", jSONObject.getString("cplist"));
                    }
                    if (jSONObject.has("bklist")) {
                        this.b.a(jSONObject.getString("bklist").split(Separators.SEMICOLON));
                    }
                    if (jSONObject.has("para")) {
                        JSONObject jSONObject3;
                        jSONObject = jSONObject.getJSONObject("para");
                        if (jSONObject.has("rgcgp")) {
                            this.b.l = jSONObject.getInt("rgcgp");
                        }
                        if (jSONObject.has("addrup")) {
                            this.b.n = jSONObject.getInt("addrup");
                        }
                        if (jSONObject.has("poiup")) {
                            this.b.m = jSONObject.getInt("poiup");
                        }
                        if (jSONObject.has("oflp")) {
                            jSONObject3 = jSONObject.getJSONObject("oflp");
                            if (jSONObject3.has("0")) {
                                this.b.o = jSONObject3.getDouble("0");
                            }
                            if (jSONObject3.has("1")) {
                                this.b.p = jSONObject3.getDouble("1");
                            }
                            if (jSONObject3.has("2")) {
                                this.b.q = jSONObject3.getDouble("2");
                            }
                            if (jSONObject3.has("3")) {
                                this.b.r = jSONObject3.getDouble("3");
                            }
                            if (jSONObject3.has("4")) {
                                this.b.s = jSONObject3.getDouble("4");
                            }
                        }
                        if (jSONObject.has("onlt")) {
                            jSONObject3 = jSONObject.getJSONObject("onlt");
                            if (jSONObject3.has("0")) {
                                this.b.z = jSONObject3.getLong("0");
                            }
                            if (jSONObject3.has("1")) {
                                this.b.y = jSONObject3.getLong("1");
                            }
                            if (jSONObject3.has("2")) {
                                this.b.v = jSONObject3.getLong("2");
                            }
                            if (jSONObject3.has("3")) {
                                this.b.w = jSONObject3.getLong("3");
                            }
                            if (jSONObject3.has("4")) {
                                this.b.x = jSONObject3.getLong("4");
                            }
                        }
                        if (jSONObject.has("minapn")) {
                            this.b.t = jSONObject.getInt("minapn");
                        }
                    }
                    jSONObject2.put("ol", this.b.e);
                    jSONObject2.put("fl", this.b.f);
                    jSONObject2.put("on", this.b.g);
                    jSONObject2.put("wn", this.b.h);
                    jSONObject2.put("oc", this.b.i);
                    this.e = System.currentTimeMillis();
                    jSONObject2.put("t", this.e);
                    jSONObject2.put(DeviceInfo.TAG_VERSION, obj);
                    jSONObject2.put("rgcon", this.b.k);
                    jSONObject2.put("rgcgp", this.b.l);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("0", this.b.o);
                    jSONObject4.put("1", this.b.p);
                    jSONObject4.put("2", this.b.q);
                    jSONObject4.put("3", this.b.r);
                    jSONObject4.put("4", this.b.s);
                    jSONObject2.put("oflp", jSONObject4);
                    jSONObject4 = new JSONObject();
                    jSONObject4.put("0", this.b.z);
                    jSONObject4.put("1", this.b.y);
                    jSONObject4.put("2", this.b.v);
                    jSONObject4.put("3", this.b.w);
                    jSONObject4.put("4", this.b.x);
                    jSONObject2.put("onlt", jSONObject4);
                    jSONObject2.put("addrup", this.b.n);
                    jSONObject2.put("poiup", this.b.m);
                    jSONObject2.put("minapn", this.b.t);
                    File file = new File(this.b.b.d(), "ofl.config");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fileWriter = new FileWriter(file);
                    fileWriter.write(jSONObject2.toString());
                    fileWriter.close();
                } catch (Exception e) {
                    this.c++;
                    this.d = System.currentTimeMillis();
                }
            }
            this.f = false;
        }
    }

    j(d dVar, SQLiteDatabase sQLiteDatabase) {
        this.b = dVar;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.k = false;
        this.l = 6;
        this.m = 30;
        this.n = 30;
        this.o = 0.0d;
        this.p = 0.0d;
        this.q = 0.0d;
        this.r = 0.0d;
        this.s = 0.0d;
        this.t = 8;
        this.j = new String[0];
        this.c = sQLiteDatabase;
        this.d = new a();
        if (this.c != null && this.c.isOpen()) {
            this.c.execSQL("CREATE TABLE IF NOT EXISTS BLACK (name VARCHAR(100) PRIMARY KEY);");
        }
        g();
    }

    int a() {
        return this.t;
    }

    long a(String str) {
        return str.equals(com.baidu.location.h.c.h) ? this.v : str.equals(com.baidu.location.h.c.c) ? this.w : str.equals(com.baidu.location.h.c.if) ? this.x : str.equals(com.baidu.location.h.c.do) ? this.y : str.equals("unknown") ? this.z : e.kc;
    }

    void a(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append("(\"");
            stringBuffer.append(strArr[i]);
            stringBuffer.append("\")");
        }
        if (this.c != null && this.c.isOpen() && stringBuffer.length() > 0) {
            try {
                this.c.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO BLACK VALUES %s;", new Object[]{stringBuffer.toString()}));
            } catch (Exception e) {
            }
        }
    }

    double b() {
        return this.o;
    }

    boolean b(String str) {
        Cursor cursor = null;
        boolean z = false;
        try {
            cursor = this.c.rawQuery(String.format(Locale.US, "SELECT * FROM BLACK WHERE NAME IN (\"%s\");", new Object[]{str}), null);
            if (cursor.getCount() > 0) {
                z = true;
            }
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e) {
                }
            }
        } catch (Exception e2) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e3) {
                }
            }
        } catch (Throwable th) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception e4) {
                }
            }
        }
        return z ? z : z;
    }

    double c() {
        return this.p;
    }

    double d() {
        return this.q;
    }

    double e() {
        return this.r;
    }

    double f() {
        return this.s;
    }

    void g() {
        this.d.a();
    }

    boolean h() {
        return this.e;
    }

    boolean i() {
        return this.g;
    }

    boolean j() {
        return this.h;
    }

    boolean k() {
        return this.f;
    }

    boolean l() {
        return this.k;
    }

    boolean m() {
        return this.u;
    }

    int n() {
        return this.l;
    }

    String[] o() {
        return this.j;
    }

    int p() {
        return this.n;
    }

    int q() {
        return this.m;
    }
}
