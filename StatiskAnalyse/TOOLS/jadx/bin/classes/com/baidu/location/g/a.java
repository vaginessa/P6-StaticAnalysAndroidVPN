package com.baidu.location.g;

import android.util.Xml;
import com.baidu.location.b.f;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;

class a implements f {
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    private double i = Double.MIN_VALUE;
    private double j = Double.MIN_VALUE;
    private float k = 0.0f;
    private boolean l = false;
    private boolean m = true;

    public a(String str) {
        boolean z = false;
        XmlPullParser newPullParser = Xml.newPullParser();
        newPullParser.setInput(new StringReader(str));
        newPullParser.next();
        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
            switch (eventType) {
                case 2:
                    if (!z) {
                        if (!newPullParser.getName().equals("LocationRS")) {
                            break;
                        }
                        z = true;
                        break;
                    }
                    String name = newPullParser.getName();
                    if (name == null) {
                        continue;
                    } else if (name.equals("latitude")) {
                        try {
                            this.i = Double.valueOf(newPullParser.nextText()).doubleValue();
                            break;
                        } catch (Exception e) {
                            this.m = false;
                            break;
                        }
                    } else if (name.equals("longitude")) {
                        try {
                            this.j = Double.valueOf(newPullParser.nextText()).doubleValue();
                            break;
                        } catch (Exception e2) {
                            this.m = false;
                            break;
                        }
                    } else if (name.equals("hpe")) {
                        try {
                            this.k = Float.valueOf(newPullParser.nextText()).floatValue();
                            break;
                        } catch (Exception e3) {
                            this.m = false;
                            break;
                        }
                    } else if (name.equals("country")) {
                        try {
                            this.d = newPullParser.getAttributeValue(0);
                        } catch (Exception e4) {
                        }
                        try {
                            this.c = newPullParser.nextText();
                            break;
                        } catch (Exception e5) {
                            break;
                        }
                    } else if (name.equals("province")) {
                        try {
                            this.e = newPullParser.nextText();
                            break;
                        } catch (Exception e6) {
                            break;
                        }
                    } else if (name.equals("region")) {
                        try {
                            this.f = newPullParser.nextText();
                            break;
                        } catch (Exception e7) {
                            break;
                        }
                    } else if (name.equals("street-number")) {
                        try {
                            this.h = newPullParser.nextText();
                            break;
                        } catch (Exception e8) {
                            break;
                        }
                    } else if (name.equals("city")) {
                        try {
                            this.b = newPullParser.nextText();
                            break;
                        } catch (Exception e9) {
                            break;
                        }
                    } else if (name.equals("address-line")) {
                        try {
                            this.g = newPullParser.nextText();
                            break;
                        } catch (Exception e10) {
                            break;
                        }
                    } else {
                        try {
                            if (!name.equals("error")) {
                                break;
                            }
                            this.m = false;
                            break;
                        } catch (Exception e11) {
                            return;
                        }
                    }
                default:
                    break;
            }
        }
    }

    public boolean a() {
        return this.c.equals("China") || this.c.equals("Taiwan") || this.d.equals("HK");
    }

    public boolean b() {
        return this.m;
    }

    public double c() {
        return this.i;
    }

    public double d() {
        return this.j;
    }

    public float e() {
        return this.k;
    }
}
