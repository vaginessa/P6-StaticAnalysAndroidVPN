package com.baidu.location.b;

import com.baidu.location.Jni;
import com.baidu.location.e.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class o implements f {
    private static o e0 = null;
    private static final int e2 = 128;
    private static String e3 = "LogSDK";
    private static int e4 = 1024;
    private static final int e5 = 32;
    private static int e8 = 5;
    private static final int e9 = 1040;
    private static final String eZ = (e.int + "/llg.dat");
    private static final String fb = (e.int + "/ller.dat");
    private static final int fc = 1000;
    public static final String fd = (e.int + "/llin.dat");
    private l e1 = null;
    private long e6 = 0;
    private SimpleDateFormat e7 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private a fa = null;

    private class a extends m {
        final /* synthetic */ o b;
        private String c;
        private boolean d;

        a(o oVar) {
            this.b = oVar;
            this.c = null;
            this.d = false;
            this.c7 = new ArrayList();
        }

        public void a(String str) {
            this.c = str;
            if (this.c != null) {
                ao();
                this.d = true;
            }
        }

        public boolean a() {
            return this.d;
        }

        public void au() {
            this.c7.clear();
            this.c7.add(new BasicNameValuePair("qt", "stat"));
            this.c7.add(new BasicNameValuePair("req", this.c));
            this.c5 = "http://loc.map.baidu.com/statloc";
        }

        public void int(boolean z) {
            this.d = false;
            if (!z || this.c6 == null) {
                this.b.e6 = System.currentTimeMillis();
                return;
            }
            try {
                EntityUtils.toString(this.c6, "utf-8");
            } catch (Exception e) {
            }
        }
    }

    private o() {
        if (this.e1 == null) {
            this.e1 = new l();
        }
    }

    public static o aY() {
        if (e0 == null) {
            synchronized (o.class) {
                if (e0 == null) {
                    e0 = new o();
                }
            }
        }
        return e0;
    }

    public static synchronized void for(String str, String str2) {
        synchronized (o.class) {
            File file = new File(str);
            if (!file.exists()) {
                i(str);
            }
            try {
                int i;
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(4);
                int readInt = randomAccessFile.readInt();
                int readInt2 = randomAccessFile.readInt();
                int readInt3 = randomAccessFile.readInt();
                int readInt4 = randomAccessFile.readInt();
                int readInt5 = randomAccessFile.readInt();
                if (readInt3 < readInt) {
                    randomAccessFile.seek((long) ((readInt2 * readInt3) + 128));
                    byte[] bytes = (str2 + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes, 0, bytes.length);
                    i = readInt3 + 1;
                } else {
                    randomAccessFile.seek((long) ((readInt4 * readInt2) + 128));
                    byte[] bytes2 = (str2 + '\u0000').getBytes();
                    randomAccessFile.writeInt(bytes2.length);
                    randomAccessFile.write(bytes2, 0, bytes2.length);
                    readInt4++;
                    if (readInt4 > readInt3) {
                        readInt4 = 0;
                        i = readInt3;
                    } else {
                        i = readInt3;
                    }
                }
                randomAccessFile.seek(12);
                randomAccessFile.writeInt(i);
                randomAccessFile.writeInt(readInt4);
                randomAccessFile.writeInt(readInt5);
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
    }

    private static void i(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                File file2 = new File(e.int);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (!file.createNewFile()) {
                    file = null;
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(0);
                randomAccessFile.writeInt(32);
                randomAccessFile.writeInt(1000);
                randomAccessFile.writeInt(e9);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.writeInt(0);
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public static boolean if(String str, List list) {
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(8);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            byte[] bArr = new byte[e4];
            int i = readInt2;
            readInt2 = e8 + 1;
            boolean z = false;
            while (readInt2 > 0 && i > 0) {
                if (i < readInt3) {
                    readInt3 = 0;
                }
                try {
                    randomAccessFile.seek((long) (((i - 1) * readInt) + 128));
                    int readInt4 = randomAccessFile.readInt();
                    if (readInt4 > 0 && readInt4 < readInt) {
                        randomAccessFile.read(bArr, 0, readInt4);
                        if (bArr[readInt4 - 1] == (byte) 0) {
                            list.add(0, new String(bArr, 0, readInt4 - 1));
                            z = true;
                        }
                    }
                    readInt2--;
                    i--;
                } catch (Exception e) {
                    return z;
                }
            }
            randomAccessFile.seek(12);
            randomAccessFile.writeInt(i);
            randomAccessFile.writeInt(readInt3);
            randomAccessFile.close();
            return z;
        } catch (Exception e2) {
            return false;
        }
    }

    public l aV() {
        return this.e1;
    }

    public void aW() {
        if (this.fa == null) {
            this.fa = new a(this);
        }
        if (System.currentTimeMillis() - this.e6 >= 3600000 && !this.fa.a()) {
            try {
                Object obj;
                Object obj2;
                List arrayList = new ArrayList();
                if(fb, arrayList);
                if (arrayList.size() > 0) {
                    obj = null;
                    obj2 = 1;
                } else {
                    if(eZ, arrayList);
                    if (arrayList.size() == 0) {
                        if(fd, arrayList);
                        int i = 1;
                        obj2 = null;
                    } else {
                        obj = null;
                        obj2 = null;
                    }
                }
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                if (arrayList.size() > 0) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        jSONArray.put((String) arrayList.get(i2));
                    }
                    if (obj2 != null) {
                        jSONObject.put("locpt", jSONArray);
                    } else if (obj != null) {
                        jSONObject.put("locup", jSONArray);
                    } else {
                        jSONObject.put("loctc", jSONArray);
                    }
                    this.fa.a(jSONObject.toString());
                }
            } catch (Exception e) {
            }
        }
    }

    public void aX() {
        if (this.e1 != null) {
            for(eZ, Jni.H(this.e1.ak()));
            this.e1.aj();
        }
    }

    public void if(l lVar) {
        if (lVar != null) {
            for(eZ, Jni.H(lVar.ak()));
        }
    }

    public void j(String str) {
        if (str != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                String format = this.e7.format(new Date());
                stringBuffer.append("&time=");
                stringBuffer.append(format);
                stringBuffer.append("&err=");
                stringBuffer.append(str);
                stringBuffer.append(c.N().do(false));
                stringBuffer.append(c.br().bu());
                for(fb, Jni.H(stringBuffer.toString()));
            } catch (Exception e) {
            }
        }
    }
}
