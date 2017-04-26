package com.baidu.location.e;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.b.k;
import com.baidu.location.b.m;
import com.baidu.location.b.n;
import com.baidu.location.f;
import com.baidu.location.h.l;
import com.baidu.mobstat.Config;
import gov.nist.core.Separators;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class d extends m {
    private static d ey = null;
    Handler eA;
    String eB;
    String eC;
    String eD;
    String eE;
    int ez;

    private d() {
        this.eE = null;
        this.eD = null;
        this.eC = null;
        this.eB = null;
        this.ez = 1;
        this.eA = null;
        this.eA = new Handler();
    }

    private boolean aL() {
        return (this.eC == null || new File(k.ai() + File.separator + this.eC).exists()) ? true : do("http://" + this.eE + Separators.SLASH + this.eC, this.eC);
    }

    private void aM() {
        if (this.eD != null) {
            File file = new File(k.ai() + File.separator + this.eD);
            if (!file.exists() && do("http://" + this.eE + Separators.SLASH + this.eD, this.eD)) {
                String str = k.if(file);
                if (this.eB != null && str != null && this.eB.equals(str)) {
                    File file2 = new File(k.ai() + File.separator + f.replaceFileName);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    try {
                        if(file, file2);
                    } catch (Exception e) {
                        file2.delete();
                    }
                }
            }
        }
    }

    private Handler aN() {
        return this.eA;
    }

    private void aO() {
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(e.int + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(e.int);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(200);
            randomAccessFile.writeBoolean(true);
            if (this.ez == 1) {
                randomAccessFile.writeBoolean(true);
            } else {
                randomAccessFile.writeBoolean(false);
            }
            if (this.eB != null) {
                byte[] bytes2 = this.eB.getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
            } else {
                randomAccessFile.writeInt(0);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private void aP() {
        if (this.eE != null && l.a().db()) {
            new r(this).start();
        }
    }

    public static d aR() {
        if (ey == null) {
            ey = new d();
        }
        return ey;
    }

    private static boolean do(String str, String str2) {
        File file = new File(k.ai() + File.separator + "tmp");
        if (file.exists()) {
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            httpURLConnection.disconnect();
            fileOutputStream.close();
            if (file.length() < 10240) {
                file.delete();
                return false;
            }
            file.renameTo(new File(k.ai() + File.separator + str2));
            return true;
        } catch (Exception e) {
            file.delete();
            return false;
        }
    }

    public static void if(File file, File file2) throws IOException {
        Throwable th;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream = null;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[Config.MAX_CACHE_JSON_CAPACIT_EXCEPTION];
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.flush();
                file.delete();
                if (bufferedInputStream2 != null) {
                    bufferedInputStream2.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    public void aQ() {
        if (System.currentTimeMillis() - n.if().do() > 86400000) {
            aN().postDelayed(new g(this), 10000);
            aN().postDelayed(new j(this), com.baidu.location.h.e.kc);
        }
    }

    public void au() {
        StringBuffer stringBuffer = new StringBuffer(128);
        stringBuffer.append("&sdk=");
        stringBuffer.append(com.baidu.location.b.f.bi);
        stringBuffer.append("&fw=");
        stringBuffer.append(f.getFrameVersion());
        stringBuffer.append("&suit=");
        stringBuffer.append(2);
        if (c.N().bm == null) {
            stringBuffer.append("&im=");
            stringBuffer.append(c.N().bo);
        } else {
            stringBuffer.append("&cu=");
            stringBuffer.append(c.N().bm);
        }
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&sv=");
        String str = VERSION.RELEASE;
        if (str != null && str.length() > 10) {
            str = str.substring(0, 10);
        }
        stringBuffer.append(str);
        stringBuffer.append("&pack=");
        stringBuffer.append(c.bn);
        this.c5 = k.ac() + "?&it=" + Jni.F(stringBuffer.toString());
    }

    public void int(boolean z) {
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
                if ("up".equals(jSONObject.getString("res"))) {
                    this.eE = jSONObject.getString("upath");
                    if (jSONObject.has("u1")) {
                        this.eD = jSONObject.getString("u1");
                    }
                    if (jSONObject.has("u2")) {
                        this.eC = jSONObject.getString("u2");
                    }
                    if (jSONObject.has("u1_md5")) {
                        this.eB = jSONObject.getString("u1_md5");
                    }
                    aN().post(new q(this));
                }
                if (jSONObject.has("ison")) {
                    this.ez = jSONObject.getInt("ison");
                }
                aO();
            } catch (Exception e) {
            }
        }
        n.if().for(System.currentTimeMillis());
    }
}
