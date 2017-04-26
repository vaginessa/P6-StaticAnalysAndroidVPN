package com.baidu.location.c;

import com.alipay.sdk.cons.c;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import gov.nist.core.Separators;
import java.util.Iterator;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

class e extends Thread {
    final /* synthetic */ b a;

    e(b bVar) {
        this.a = bVar;
    }

    public void run() {
        Exception e;
        JSONObject jSONObject;
        Iterator keys;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2;
        Object obj;
        Object obj2;
        Object obj3;
        int i;
        int i2;
        int i3;
        String str;
        String string;
        Double valueOf;
        Object obj4;
        int i4;
        int i5;
        int i6;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int i7;
        Exception exception;
        super.run();
        if (this.a.b.i == null || this.a.b.j == null || !this.a.b.i.isOpen() || !this.a.b.j.isOpen()) {
            this.a.g = false;
            return;
        }
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        StringBuffer stringBuffer3;
        int i8;
        JSONObject jSONObject4 = null;
        try {
            if (this.a.c6 != null) {
                jSONObject2 = new JSONObject(EntityUtils.toString(this.a.c6, "utf-8"));
                try {
                    jSONObject3 = jSONObject2.has("model") ? jSONObject2.getJSONObject("model") : null;
                    try {
                        if (jSONObject2.has("rgc")) {
                            jSONObject4 = jSONObject2.getJSONObject("rgc");
                        }
                    } catch (Exception e2) {
                        e = e2;
                        e.printStackTrace();
                        this.a.b.i.beginTransaction();
                        this.a.b.j.beginTransaction();
                        if (jSONObject4 != null) {
                            this.a.b.b.l().a(jSONObject4);
                        }
                        this.a.j = System.currentTimeMillis();
                        this.a.f.a(jSONObject2.getString("bdlist").split(Separators.SEMICOLON));
                        this.a.f.a(jSONObject2.getJSONObject("loadurl").getString(c.f), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                        jSONObject = jSONObject3.getJSONObject("cell");
                        keys = jSONObject.keys();
                        stringBuffer = new StringBuffer();
                        stringBuffer2 = new StringBuffer();
                        stringBuffer3 = new StringBuffer();
                        obj = 1;
                        obj2 = 1;
                        obj3 = 1;
                        i = 0;
                        i2 = 0;
                        i3 = 0;
                        while (keys.hasNext()) {
                            str = (String) keys.next();
                            string = jSONObject.getString(str);
                            valueOf = Double.valueOf(string.split(",")[3]);
                            if (obj2 == null) {
                                try {
                                    stringBuffer2.append(',');
                                } catch (Exception e3) {
                                    this.a.b();
                                    return;
                                } finally {
                                    if (this.a.b.i != null && this.a.b.i.isOpen()) {
                                        this.a.b.i.endTransaction();
                                    }
                                    if (this.a.b.j != null && this.a.b.j.isOpen()) {
                                        this.a.b.j.endTransaction();
                                    }
                                    this.a.c6 = null;
                                    this.a.g = false;
                                }
                            } else {
                                obj2 = null;
                            }
                            stringBuffer2.append(str);
                            i2++;
                            if (valueOf.doubleValue() <= 0.0d) {
                                if (obj == null) {
                                    stringBuffer.append(',');
                                } else {
                                    obj = null;
                                }
                                stringBuffer.append(str);
                                i8 = i + 1;
                                obj4 = obj;
                            } else {
                                if (obj3 == null) {
                                    stringBuffer3.append(',');
                                } else {
                                    obj3 = null;
                                }
                                stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                i3++;
                                i8 = i;
                                obj4 = obj;
                            }
                            if (i2 >= 100) {
                                this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                obj2 = 1;
                                stringBuffer2.setLength(0);
                                i2 -= 100;
                            }
                            if (i3 >= 100) {
                                this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                obj3 = 1;
                                stringBuffer3.setLength(0);
                                i3 -= 100;
                            }
                            if (i8 < 100) {
                                this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                                obj4 = 1;
                                stringBuffer.setLength(0);
                                i8 -= 100;
                            }
                            obj = obj4;
                            i = i8;
                        }
                        if (i2 > 0) {
                            this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        }
                        if (i3 > 0) {
                            this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        }
                        if (i > 0) {
                            this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        }
                        jSONObject = jSONObject3.getJSONObject("ap");
                        keys = jSONObject.keys();
                        i4 = 0;
                        i5 = 0;
                        i6 = 0;
                        obj5 = 1;
                        obj6 = 1;
                        obj4 = 1;
                        stringBuffer = new StringBuffer();
                        stringBuffer2 = new StringBuffer();
                        stringBuffer3 = new StringBuffer();
                        while (keys.hasNext()) {
                            str = (String) keys.next();
                            string = jSONObject.getString(str);
                            valueOf = Double.valueOf(string.split(",")[3]);
                            if (obj6 == null) {
                                stringBuffer2.append(',');
                            } else {
                                obj6 = null;
                            }
                            stringBuffer2.append(str);
                            i5++;
                            if (valueOf.doubleValue() <= 0.0d) {
                                if (obj5 == null) {
                                    stringBuffer.append(',');
                                } else {
                                    obj5 = null;
                                }
                                stringBuffer.append(str);
                                obj7 = obj4;
                                i = i6;
                                i6 = i4 + 1;
                                obj8 = obj7;
                            } else {
                                if (obj4 == null) {
                                    stringBuffer3.append(',');
                                } else {
                                    obj4 = null;
                                }
                                stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                                i8 = i6 + 1;
                                i6 = i4;
                                i7 = i8;
                                obj8 = obj4;
                                i = i7;
                            }
                            if (i5 >= 100) {
                                this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                                obj6 = 1;
                                stringBuffer2.setLength(0);
                                i5 -= 100;
                            }
                            if (i >= 100) {
                                this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                                obj8 = 1;
                                stringBuffer3.setLength(0);
                                i -= 100;
                            }
                            if (i6 <= 0) {
                                this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                            }
                            i4 = i6;
                            i6 = i;
                            obj4 = obj8;
                        }
                        if (i5 > 0) {
                            this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                        }
                        if (i6 > 0) {
                            this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                        }
                        if (i4 > 0) {
                            this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        }
                        this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                        this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                        this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
                        this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
                        this.a.b();
                        this.a.b.i.setTransactionSuccessful();
                        this.a.b.j.setTransactionSuccessful();
                        this.a.b.i.endTransaction();
                        this.a.b.j.endTransaction();
                        this.a.c6 = null;
                        this.a.g = false;
                    }
                } catch (Exception e4) {
                    exception = e4;
                    jSONObject3 = null;
                    e = exception;
                    e.printStackTrace();
                    this.a.b.i.beginTransaction();
                    this.a.b.j.beginTransaction();
                    if (jSONObject4 != null) {
                        this.a.b.b.l().a(jSONObject4);
                    }
                    this.a.j = System.currentTimeMillis();
                    this.a.f.a(jSONObject2.getString("bdlist").split(Separators.SEMICOLON));
                    this.a.f.a(jSONObject2.getJSONObject("loadurl").getString(c.f), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
                    jSONObject = jSONObject3.getJSONObject("cell");
                    keys = jSONObject.keys();
                    stringBuffer = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    stringBuffer3 = new StringBuffer();
                    obj = 1;
                    obj2 = 1;
                    obj3 = 1;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        string = jSONObject.getString(str);
                        valueOf = Double.valueOf(string.split(",")[3]);
                        if (obj2 == null) {
                            obj2 = null;
                        } else {
                            stringBuffer2.append(',');
                        }
                        stringBuffer2.append(str);
                        i2++;
                        if (valueOf.doubleValue() <= 0.0d) {
                            if (obj3 == null) {
                                obj3 = null;
                            } else {
                                stringBuffer3.append(',');
                            }
                            stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                            i3++;
                            i8 = i;
                            obj4 = obj;
                        } else {
                            if (obj == null) {
                                obj = null;
                            } else {
                                stringBuffer.append(',');
                            }
                            stringBuffer.append(str);
                            i8 = i + 1;
                            obj4 = obj;
                        }
                        if (i2 >= 100) {
                            this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            obj2 = 1;
                            stringBuffer2.setLength(0);
                            i2 -= 100;
                        }
                        if (i3 >= 100) {
                            this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            obj3 = 1;
                            stringBuffer3.setLength(0);
                            i3 -= 100;
                        }
                        if (i8 < 100) {
                            this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                            obj4 = 1;
                            stringBuffer.setLength(0);
                            i8 -= 100;
                        }
                        obj = obj4;
                        i = i8;
                    }
                    if (i2 > 0) {
                        this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    }
                    if (i3 > 0) {
                        this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    }
                    if (i > 0) {
                        this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    jSONObject = jSONObject3.getJSONObject("ap");
                    keys = jSONObject.keys();
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    obj5 = 1;
                    obj6 = 1;
                    obj4 = 1;
                    stringBuffer = new StringBuffer();
                    stringBuffer2 = new StringBuffer();
                    stringBuffer3 = new StringBuffer();
                    while (keys.hasNext()) {
                        str = (String) keys.next();
                        string = jSONObject.getString(str);
                        valueOf = Double.valueOf(string.split(",")[3]);
                        if (obj6 == null) {
                            obj6 = null;
                        } else {
                            stringBuffer2.append(',');
                        }
                        stringBuffer2.append(str);
                        i5++;
                        if (valueOf.doubleValue() <= 0.0d) {
                            if (obj4 == null) {
                                obj4 = null;
                            } else {
                                stringBuffer3.append(',');
                            }
                            stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                            i8 = i6 + 1;
                            i6 = i4;
                            i7 = i8;
                            obj8 = obj4;
                            i = i7;
                        } else {
                            if (obj5 == null) {
                                obj5 = null;
                            } else {
                                stringBuffer.append(',');
                            }
                            stringBuffer.append(str);
                            obj7 = obj4;
                            i = i6;
                            i6 = i4 + 1;
                            obj8 = obj7;
                        }
                        if (i5 >= 100) {
                            this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                            obj6 = 1;
                            stringBuffer2.setLength(0);
                            i5 -= 100;
                        }
                        if (i >= 100) {
                            this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                            obj8 = 1;
                            stringBuffer3.setLength(0);
                            i -= 100;
                        }
                        if (i6 <= 0) {
                            this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                        }
                        i4 = i6;
                        i6 = i;
                        obj4 = obj8;
                    }
                    if (i5 > 0) {
                        this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    }
                    if (i6 > 0) {
                        this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    }
                    if (i4 > 0) {
                        this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    }
                    this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
                    this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
                    this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
                    this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
                    this.a.b();
                    this.a.b.i.setTransactionSuccessful();
                    this.a.b.j.setTransactionSuccessful();
                    this.a.b.i.endTransaction();
                    this.a.b.j.endTransaction();
                    this.a.c6 = null;
                    this.a.g = false;
                }
            }
            jSONObject2 = null;
            jSONObject3 = null;
        } catch (Exception e5) {
            exception = e5;
            jSONObject2 = null;
            jSONObject3 = null;
            e = exception;
            e.printStackTrace();
            this.a.b.i.beginTransaction();
            this.a.b.j.beginTransaction();
            if (jSONObject4 != null) {
                this.a.b.b.l().a(jSONObject4);
            }
            this.a.j = System.currentTimeMillis();
            this.a.f.a(jSONObject2.getString("bdlist").split(Separators.SEMICOLON));
            this.a.f.a(jSONObject2.getJSONObject("loadurl").getString(c.f), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
            jSONObject = jSONObject3.getJSONObject("cell");
            keys = jSONObject.keys();
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            obj = 1;
            obj2 = 1;
            obj3 = 1;
            i = 0;
            i2 = 0;
            i3 = 0;
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj2 == null) {
                    stringBuffer2.append(',');
                } else {
                    obj2 = null;
                }
                stringBuffer2.append(str);
                i2++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj == null) {
                        stringBuffer.append(',');
                    } else {
                        obj = null;
                    }
                    stringBuffer.append(str);
                    i8 = i + 1;
                    obj4 = obj;
                } else {
                    if (obj3 == null) {
                        stringBuffer3.append(',');
                    } else {
                        obj3 = null;
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i3++;
                    i8 = i;
                    obj4 = obj;
                }
                if (i2 >= 100) {
                    this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj2 = 1;
                    stringBuffer2.setLength(0);
                    i2 -= 100;
                }
                if (i3 >= 100) {
                    this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj3 = 1;
                    stringBuffer3.setLength(0);
                    i3 -= 100;
                }
                if (i8 < 100) {
                    this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    obj4 = 1;
                    stringBuffer.setLength(0);
                    i8 -= 100;
                }
                obj = obj4;
                i = i8;
            }
            if (i2 > 0) {
                this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i3 > 0) {
                this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i > 0) {
                this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            jSONObject = jSONObject3.getJSONObject("ap");
            keys = jSONObject.keys();
            i4 = 0;
            i5 = 0;
            i6 = 0;
            obj5 = 1;
            obj6 = 1;
            obj4 = 1;
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj6 == null) {
                    stringBuffer2.append(',');
                } else {
                    obj6 = null;
                }
                stringBuffer2.append(str);
                i5++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj5 == null) {
                        stringBuffer.append(',');
                    } else {
                        obj5 = null;
                    }
                    stringBuffer.append(str);
                    obj7 = obj4;
                    i = i6;
                    i6 = i4 + 1;
                    obj8 = obj7;
                } else {
                    if (obj4 == null) {
                        stringBuffer3.append(',');
                    } else {
                        obj4 = null;
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i8 = i6 + 1;
                    i6 = i4;
                    i7 = i8;
                    obj8 = obj4;
                    i = i7;
                }
                if (i5 >= 100) {
                    this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj6 = 1;
                    stringBuffer2.setLength(0);
                    i5 -= 100;
                }
                if (i >= 100) {
                    this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj8 = 1;
                    stringBuffer3.setLength(0);
                    i -= 100;
                }
                if (i6 <= 0) {
                    this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                i4 = i6;
                i6 = i;
                obj4 = obj8;
            }
            if (i5 > 0) {
                this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i6 > 0) {
                this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i4 > 0) {
                this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
            this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
            this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
            this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
            this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
            this.a.b();
            this.a.b.i.setTransactionSuccessful();
            this.a.b.j.setTransactionSuccessful();
            this.a.b.i.endTransaction();
            this.a.b.j.endTransaction();
            this.a.c6 = null;
            this.a.g = false;
        }
        this.a.b.i.beginTransaction();
        this.a.b.j.beginTransaction();
        if (jSONObject4 != null) {
            this.a.b.b.l().a(jSONObject4);
        }
        if (jSONObject2 != null && jSONObject2.has("type") && jSONObject2.getString("type").equals("0")) {
            this.a.j = System.currentTimeMillis();
        }
        if (jSONObject2 != null && jSONObject2.has("bdlist")) {
            this.a.f.a(jSONObject2.getString("bdlist").split(Separators.SEMICOLON));
        }
        if (jSONObject2 != null && jSONObject2.has("loadurl")) {
            this.a.f.a(jSONObject2.getJSONObject("loadurl").getString(c.f), jSONObject2.getJSONObject("loadurl").getString("module"), jSONObject2.getJSONObject("loadurl").getString("req"));
        }
        if (jSONObject3 != null && jSONObject3.has("cell")) {
            jSONObject = jSONObject3.getJSONObject("cell");
            keys = jSONObject.keys();
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            obj = 1;
            obj2 = 1;
            obj3 = 1;
            i = 0;
            i2 = 0;
            i3 = 0;
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj2 == null) {
                    obj2 = null;
                } else {
                    stringBuffer2.append(',');
                }
                stringBuffer2.append(str);
                i2++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj3 == null) {
                        obj3 = null;
                    } else {
                        stringBuffer3.append(',');
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i3++;
                    i8 = i;
                    obj4 = obj;
                } else {
                    if (obj == null) {
                        obj = null;
                    } else {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(str);
                    i8 = i + 1;
                    obj4 = obj;
                }
                if (i2 >= 100) {
                    this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj2 = 1;
                    stringBuffer2.setLength(0);
                    i2 -= 100;
                }
                if (i3 >= 100) {
                    this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj3 = 1;
                    stringBuffer3.setLength(0);
                    i3 -= 100;
                }
                if (i8 < 100) {
                    this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                    obj4 = 1;
                    stringBuffer.setLength(0);
                    i8 -= 100;
                }
                obj = obj4;
                i = i8;
            }
            if (i2 > 0) {
                this.a.b.j.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i3 > 0) {
                this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i > 0) {
                this.a.b.i.execSQL(String.format("DELETE FROM CL WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
        }
        if (jSONObject3 != null && jSONObject3.has("ap")) {
            jSONObject = jSONObject3.getJSONObject("ap");
            keys = jSONObject.keys();
            i4 = 0;
            i5 = 0;
            i6 = 0;
            obj5 = 1;
            obj6 = 1;
            obj4 = 1;
            stringBuffer = new StringBuffer();
            stringBuffer2 = new StringBuffer();
            stringBuffer3 = new StringBuffer();
            while (keys.hasNext()) {
                str = (String) keys.next();
                string = jSONObject.getString(str);
                valueOf = Double.valueOf(string.split(",")[3]);
                if (obj6 == null) {
                    obj6 = null;
                } else {
                    stringBuffer2.append(',');
                }
                stringBuffer2.append(str);
                i5++;
                if (valueOf.doubleValue() <= 0.0d) {
                    if (obj4 == null) {
                        obj4 = null;
                    } else {
                        stringBuffer3.append(',');
                    }
                    stringBuffer3.append('(').append(str).append(',').append(string).append("," + (System.currentTimeMillis() / 1000)).append(')');
                    i8 = i6 + 1;
                    i6 = i4;
                    i7 = i8;
                    obj8 = obj4;
                    i = i7;
                } else {
                    if (obj5 == null) {
                        obj5 = null;
                    } else {
                        stringBuffer.append(',');
                    }
                    stringBuffer.append(str);
                    obj7 = obj4;
                    i = i6;
                    i6 = i4 + 1;
                    obj8 = obj7;
                }
                if (i5 >= 100) {
                    this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
                    obj6 = 1;
                    stringBuffer2.setLength(0);
                    i5 -= 100;
                }
                if (i >= 100) {
                    this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
                    obj8 = 1;
                    stringBuffer3.setLength(0);
                    i -= 100;
                }
                if (i6 <= 0) {
                    this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
                }
                i4 = i6;
                i6 = i;
                obj4 = obj8;
            }
            if (i5 > 0) {
                this.a.b.j.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer2.toString()}));
            }
            if (i6 > 0) {
                this.a.b.i.execSQL(String.format("INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;", new Object[]{stringBuffer3.toString()}));
            }
            if (i4 > 0) {
                this.a.b.i.execSQL(String.format("DELETE FROM AP WHERE id IN (%s);", new Object[]{stringBuffer.toString()}));
            }
        }
        this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(200000)}));
        this.a.b.i.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(200000)}));
        this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"AP", "AP", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
        this.a.b.j.execSQL(String.format("DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);", new Object[]{"CL", "CL", Integer.valueOf(StatusCodes.AUTH_DISABLED)}));
        if (!(jSONObject3 == null || jSONObject3.has("ap") || jSONObject3.has("cell"))) {
            this.a.b();
        }
        this.a.b.i.setTransactionSuccessful();
        this.a.b.j.setTransactionSuccessful();
        if (this.a.b.i != null && this.a.b.i.isOpen()) {
            this.a.b.i.endTransaction();
        }
        if (this.a.b.j != null && this.a.b.j.isOpen()) {
            this.a.b.j.endTransaction();
        }
        this.a.c6 = null;
        this.a.g = false;
    }
}
