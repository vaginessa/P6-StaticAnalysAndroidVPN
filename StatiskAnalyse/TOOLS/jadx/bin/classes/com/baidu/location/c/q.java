package com.baidu.location.c;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.m;
import com.google.android.gms.common.api.CommonStatusCodes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import org.apache.http.ParseException;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class q implements b {
    private static final String e = String.format(Locale.US, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", new Object[]{Integer.valueOf(CommonStatusCodes.AUTH_API_INVALID_CREDENTIALS)});
    private static final String f = String.format(Locale.US, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", new Object[]{Integer.valueOf(3)});
    private String b = null;
    private final SQLiteDatabase c;
    private final a d;

    private class a extends m {
        final /* synthetic */ q b;
        private int c;
        private long d;
        private String e;
        private boolean f;
        private boolean g;
        private q h;

        a(q qVar, q qVar2) {
            this.b = qVar;
            this.h = qVar2;
            this.e = null;
            this.f = false;
            this.g = false;
            this.c7 = new ArrayList();
            this.c = 0;
            this.d = -1;
        }

        private void a() {
            if (!this.f) {
                this.e = this.h.b();
                if (this.d != -1 && this.d + 86400000 <= System.currentTimeMillis()) {
                    this.c = 0;
                    this.d = -1;
                }
                if (this.e != null && this.c < 2) {
                    this.f = true;
                    ao();
                }
            }
        }

        public void au() {
            this.c7.clear();
            this.c7.add(new BasicNameValuePair("qt", "ofbh"));
            this.c7.add(new BasicNameValuePair("req", this.e));
            this.c5 = d.ak;
        }

        public void int(boolean z) {
            this.g = false;
            if (z && this.c6 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
                    if (jSONObject != null && jSONObject.has("error") && jSONObject.getInt("error") == BDLocation.TypeNetWorkLocation) {
                        this.g = true;
                    }
                } catch (ParseException e) {
                } catch (JSONException e2) {
                } catch (IOException e3) {
                }
            }
            this.f = false;
            if (!this.g) {
                this.c++;
                this.d = System.currentTimeMillis();
            }
            new r(this).start();
        }
    }

    q(SQLiteDatabase sQLiteDatabase) {
        this.c = sQLiteDatabase;
        this.d = new a(this, this);
        if (this.c != null && this.c.isOpen()) {
            this.c.execSQL("CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))");
        }
    }

    private void a(boolean z) {
        if (z && this.b != null) {
            String format = String.format("DELETE FROM LOG WHERE timestamp in (%s);", new Object[]{this.b});
            if (this.b.length() > 0) {
                try {
                    this.c.execSQL(format);
                } catch (Exception e) {
                }
            }
        }
        this.b = null;
    }

    private String b() {
        Cursor rawQuery;
        Throwable th;
        String str = null;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            rawQuery = this.c.rawQuery(f, null);
            if (rawQuery != null) {
                try {
                    if (rawQuery.getCount() > 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        rawQuery.moveToFirst();
                        while (!rawQuery.isAfterLast()) {
                            jSONArray.put(rawQuery.getString(1));
                            if (stringBuffer.length() != 0) {
                                stringBuffer.append(",");
                            }
                            stringBuffer.append(rawQuery.getLong(0));
                            rawQuery.moveToNext();
                        }
                        try {
                            jSONObject.put("ofloc", jSONArray);
                            str = jSONObject.toString();
                        } catch (JSONException e) {
                        }
                        this.b = stringBuffer.toString();
                    }
                } catch (Exception e2) {
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e3) {
                        }
                    }
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    if (rawQuery != null) {
                        try {
                            rawQuery.close();
                        } catch (Exception e4) {
                        }
                    }
                    throw th;
                }
            }
            if (rawQuery != null) {
                try {
                    rawQuery.close();
                } catch (Exception e5) {
                }
            }
        } catch (Exception e6) {
            Object obj = str;
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            rawQuery = str;
            th = th4;
            if (rawQuery != null) {
                rawQuery.close();
            }
            throw th;
        }
        return str;
    }

    void a() {
        this.d.a();
    }

    void a(String str) {
        String G = Jni.G(str);
        try {
            this.c.execSQL(String.format(Locale.US, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", new Object[]{Long.valueOf(System.currentTimeMillis()), G}));
            this.c.execSQL(e);
        } catch (Exception e) {
        }
    }
}
