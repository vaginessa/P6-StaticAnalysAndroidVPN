package com.baidu.location.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.location.Location;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.b.f;
import com.baidu.location.b.m;
import com.baidu.location.h.e;
import com.baidu.mapapi.UIMsg.d_ResultType;
import com.tencent.connect.common.Constants;
import gov.nist.core.Separators;
import internal.org.apache.http.entity.mime.MIME;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements f {
    private static final String g1 = "1";
    private static final String g5 = "%d_%02d_%02d";
    private static final long gL = 86400000;
    private static final String gV = "utf-8";
    private static final int gX = 400;
    private static final String hg = "http://loc.map.baidu.com/cc.php";
    private static final String hh = "0";
    private static final int hq = 10000;
    private static h hr = null;
    public static String ht = "0";
    private long g0;
    private int g2;
    private int g3;
    private int g4;
    StringBuilder g6;
    private float g7;
    private double g8;
    Location g9;
    private Handler gJ;
    private int gK;
    private String gM;
    private double gN;
    private float gO;
    private int gP;
    private boolean gQ;
    private double gR;
    private int gS;
    private int gT;
    private boolean gU;
    private byte[] gW;
    private a gY;
    private int gZ;
    long ha;
    private int hb;
    private double hc;
    private List hd;
    long he;
    double hf;
    private boolean hi;
    private int hj;
    private int hk;
    private int hl;
    private long hm;
    double hn;
    int ho;
    private byte[] hp;
    Location hs;
    private int hu;

    class a extends m {
        String b;
        final /* synthetic */ h c;

        public a(h hVar) {
            this.c = hVar;
            this.b = null;
            this.c7 = new ArrayList();
        }

        public void a(String str) {
            this.b = str;
            ao();
        }

        public void au() {
            this.c5 = h.hg;
            String H = Jni.H(this.b);
            this.b = null;
            this.c7.add(new BasicNameValuePair("q", H));
        }

        public void int(boolean z) {
            if (z && this.c6 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.c6, h.gV));
                    jSONObject.put("prod", c.bn);
                    jSONObject.put("uptime", System.currentTimeMillis());
                    this.c.s(jSONObject.toString());
                } catch (Exception e) {
                }
            }
            if (this.c7 != null) {
                this.c7.clear();
            }
        }
    }

    private h() {
        this.gZ = 1;
        this.gR = 0.699999988079071d;
        this.gM = "3G|4G";
        this.g3 = 1;
        this.g4 = 307200;
        this.gK = 15;
        this.hl = 1;
        this.gN = 3.5d;
        this.g8 = 3.0d;
        this.hc = 0.5d;
        this.hu = 300;
        this.gP = 60;
        this.gT = 0;
        this.hk = 60;
        this.hb = 0;
        this.hm = 0;
        this.gY = null;
        this.gQ = false;
        this.gU = false;
        this.g2 = 0;
        this.g7 = 0.0f;
        this.gO = 0.0f;
        this.g0 = 0;
        this.gS = d_ResultType.SHORT_URL;
        this.he = 0;
        this.g9 = null;
        this.hs = null;
        this.g6 = null;
        this.ha = 0;
        this.gJ = null;
        this.hp = new byte[4];
        this.gW = null;
        this.hj = 0;
        this.hd = null;
        this.hi = false;
        this.ho = 0;
        this.hf = 116.22345545d;
        this.hn = 40.245667323d;
        this.gJ = new Handler();
    }

    public static h bK() {
        if (hr == null) {
            hr = new h();
        }
        return hr;
    }

    private void bN() {
        this.hd = null;
        this.ha = 0;
        this.hj = 0;
        this.g9 = null;
        this.hs = null;
        this.g7 = 0.0f;
        this.gO = 0.0f;
    }

    private void bO() {
    }

    private void bP() {
        int i = 0;
        this.hd.add(Byte.valueOf((byte) 0));
        this.hd.add(Byte.valueOf((byte) 0));
        if (ht.equals("0")) {
            this.hd.add(Byte.valueOf((byte) 110));
        } else {
            this.hd.add(Byte.valueOf((byte) 126));
        }
        this.hd.add(Byte.valueOf((byte) 0));
        this.hd.add(Byte.valueOf(this.hp[0]));
        this.hd.add(Byte.valueOf(this.hp[1]));
        this.hd.add(Byte.valueOf(this.hp[2]));
        this.hd.add(Byte.valueOf(this.hp[3]));
        int length = this.gW.length;
        this.hd.add(Byte.valueOf((byte) ((length + 1) & 255)));
        while (i < length) {
            this.hd.add(Byte.valueOf(this.gW[i]));
            i++;
        }
    }

    private void bQ() {
        String str = null;
        if (null == null) {
            str = f.bg;
        }
        String[] split = str.split("\\.");
        int length = split.length;
        this.hp[0] = (byte) 0;
        this.hp[1] = (byte) 0;
        this.hp[2] = (byte) 0;
        this.hp[3] = (byte) 0;
        if (length >= 4) {
            length = 4;
        }
        int i = 0;
        while (i < length) {
            try {
                this.hp[i] = (byte) (Integer.valueOf(split[i]).intValue() & 255);
                i++;
            } catch (Exception e) {
            }
        }
        this.gW = q(c.bn + Separators.COLON + c.N().bm);
    }

    private void bR() {
        if (!this.hi) {
            this.hi = true;
            r(c.bn);
            bU();
            bQ();
        }
    }

    private boolean bS() {
        if (this.gQ) {
            if (this.gU) {
                if (((double) this.g7) < this.hc) {
                    this.g2 += this.gK;
                    if (this.g2 <= this.hu || System.currentTimeMillis() - this.g0 > ((long) (this.gP * 1000))) {
                        return true;
                    }
                }
                this.g2 = 0;
                this.gU = false;
                return true;
            } else if (((double) this.g7) >= this.hc) {
                return true;
            } else {
                this.gU = true;
                this.g2 = 0;
                this.g2 += this.gK;
                return true;
            }
        } else if (((double) this.g7) >= this.gN || ((double) this.gO) >= this.g8) {
            this.gQ = true;
            return true;
        } else if (this.gT == 1 && System.currentTimeMillis() - this.g0 > ((long) (this.hk * 1000))) {
            return true;
        }
        return false;
    }

    private void bT() {
        if (this.ha != 0 && System.currentTimeMillis() - this.ha >= ((long) (this.gK * 1000))) {
            if (com.baidu.location.f.getServiceContext().getSharedPreferences("loc_navi_mode", 4).getBoolean("is_navi_on", false)) {
                bN();
            } else if (this.g3 == 1 && !bS()) {
                bN();
            } else if (!if(c.bn, com.baidu.location.f.getServiceContext())) {
                bN();
            } else if (this.hd != null) {
                int size = this.hd.size();
                this.hd.set(0, Byte.valueOf((byte) (size & 255)));
                this.hd.set(1, Byte.valueOf((byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & size) >> 8)));
                this.hd.set(3, Byte.valueOf((byte) (this.hj & 255)));
                byte[] bArr = new byte[size];
                for (int i = 0; i < size; i++) {
                    bArr[i] = ((Byte) this.hd.get(i)).byteValue();
                }
                if (Environment.getExternalStorageState().equals("mounted")) {
                    File file = new File(Environment.getExternalStorageDirectory(), "baidu/tempdata");
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    if (file.exists()) {
                        File file2 = new File(file, "intime.dat");
                        if (file2.exists()) {
                            file2.delete();
                        }
                        try {
                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                            bufferedOutputStream.write(bArr);
                            bufferedOutputStream.flush();
                            bufferedOutputStream.close();
                            new t(this).start();
                        } catch (Exception e) {
                        }
                    }
                }
                bN();
                this.g0 = System.currentTimeMillis();
            }
        }
    }

    private void bU() {
        if (System.currentTimeMillis() - this.hm > gL) {
            if (this.gY == null) {
                this.gY = new a(this);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(c.N().do(false));
            stringBuffer.append(c.br().bu());
            this.gY.a(stringBuffer.toString());
        }
        bO();
    }

    private void do(Location location) {
        new(location);
        bT();
    }

    private byte[] for(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((MotionEventCompat.ACTION_POINTER_INDEX_MASK & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((ViewCompat.MEASURED_STATE_MASK & i) >> 24)};
    }

    private String if(File file, String str) {
        String uuid = UUID.randomUUID().toString();
        String str2 = "--";
        String str3 = Separators.NEWLINE;
        String str4 = "multipart/form-data";
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setRequestMethod(Constants.HTTP_POST);
            httpURLConnection.setRequestProperty("Charset", gV);
            httpURLConnection.setRequestProperty("connection", "keep-alive");
            httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, str4 + ";boundary=" + uuid);
            if (file != null && file.exists()) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str2);
                stringBuffer.append(uuid);
                stringBuffer.append(str3);
                stringBuffer.append("Content-Disposition: form-data; name=\"location_dat\"; filename=\"" + file.getName() + Separators.DOUBLE_QUOTE + str3);
                stringBuffer.append("Content-Type: application/octet-stream; charset=utf-8" + str3);
                stringBuffer.append(str3);
                dataOutputStream.write(stringBuffer.toString().getBytes());
                InputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                dataOutputStream.write(str3.getBytes());
                dataOutputStream.write((str2 + uuid + str2 + str3).getBytes());
                dataOutputStream.flush();
                int responseCode = httpURLConnection.getResponseCode();
                outputStream.close();
                this.hb += gX;
                new(this.hb);
                if (responseCode == 200) {
                    return "1";
                }
            }
        } catch (MalformedURLException e) {
        } catch (IOException e2) {
        }
        return "0";
    }

    private void if(Location location) {
        Object obj = null;
        this.ha = System.currentTimeMillis();
        int((int) (this.ha / 1000));
        int((int) (location.getLongitude() * 1000000.0d));
        int((int) (location.getLatitude() * 1000000.0d));
        if (location.hasBearing()) {
            Object obj2 = null;
        } else {
            int i = 1;
        }
        if (!location.hasSpeed()) {
            int i2 = 1;
        }
        if (obj2 > null) {
            this.hd.add(Byte.valueOf((byte) 32));
        } else {
            this.hd.add(Byte.valueOf((byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & -33)));
        }
        if (obj > null) {
            this.hd.add(Byte.valueOf(Byte.MIN_VALUE));
        } else {
            this.hd.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & 127)));
        }
        this.g9 = location;
    }

    private boolean if(String str, Context context) {
        boolean z = false;
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    boolean z2;
                    if (runningAppProcessInfo.processName.equals(str)) {
                        int i = runningAppProcessInfo.importance;
                        if (i == 200 || i == 100) {
                            z2 = true;
                            z = z2;
                        }
                    }
                    z2 = z;
                    z = z2;
                }
            }
        } catch (Exception e) {
        }
        return z;
    }

    private void int(int i) {
        byte[] bArr = for(i);
        for (int i2 = 0; i2 < 4; i2++) {
            this.hd.add(Byte.valueOf(bArr[i2]));
        }
    }

    private void int(Location location) {
        int longitude = (int) ((location.getLongitude() - this.g9.getLongitude()) * 100000.0d);
        int latitude = (int) ((location.getLatitude() - this.g9.getLatitude()) * 100000.0d);
        if (location.hasBearing()) {
            Object obj = null;
        } else {
            int i = 1;
        }
        if (location.hasSpeed()) {
            Object obj2 = null;
        } else {
            int i2 = 1;
        }
        if (longitude > 0) {
            Object obj3 = null;
        } else {
            int i3 = 1;
        }
        int abs = Math.abs(longitude);
        if (latitude > 0) {
            Object obj4 = null;
        } else {
            int i4 = 1;
        }
        int abs2 = Math.abs(latitude);
        if (this.hj > 1) {
            this.hs = null;
            this.hs = this.g9;
        }
        this.g9 = location;
        if (this.g9 != null && this.hs != null && this.g9.getTime() > this.hs.getTime() && this.g9.getTime() - this.hs.getTime() < e.kc) {
            long time = this.g9.getTime() - this.hs.getTime();
            float[] fArr = new float[2];
            Location.distanceBetween(this.g9.getAltitude(), this.g9.getLongitude(), this.hs.getLatitude(), this.hs.getLongitude(), fArr);
            double speed = (double) ((PhotoViewAttacher.DEFAULT_MAX_SCALE * (fArr[0] - (this.hs.getSpeed() * ((float) time)))) / ((float) (time * time)));
            if (speed > ((double) this.gO)) {
                this.gO = (float) speed;
            }
        }
        this.hd.add(Byte.valueOf((byte) (abs & 255)));
        this.hd.add(Byte.valueOf((byte) (abs2 & 255)));
        byte b;
        if (obj > null) {
            b = (byte) 32;
            if (obj4 > null) {
                b = (byte) 96;
            }
            if (obj3 > null) {
                b = (byte) (b | -128);
            }
            this.hd.add(Byte.valueOf(b));
        } else {
            b = (byte) (((byte) (((int) (location.getBearing() / 15.0f)) & 255)) & 31);
            if (obj4 > null) {
                b = (byte) (b | 64);
            }
            if (obj3 > null) {
                b = (byte) (b | -128);
            }
            this.hd.add(Byte.valueOf(b));
        }
        if (obj2 > null) {
            this.hd.add(Byte.valueOf(Byte.MIN_VALUE));
            return;
        }
        this.hd.add(Byte.valueOf((byte) (((byte) (((int) ((((double) location.getSpeed()) * 3.6d) / 4.0d)) & 255)) & 127)));
    }

    private void new(int i) {
        if (i != 0) {
            try {
                RandomAccessFile randomAccessFile;
                File file = new File(com.baidu.location.b.e.int + "/grtcf.dat");
                if (!file.exists()) {
                    File file2 = new File(com.baidu.location.b.e.int);
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
                randomAccessFile.seek(8);
                byte[] bytes2 = (o(g5) + Separators.COLON + i).getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
    }

    private void new(Location location) {
        if (System.currentTimeMillis() - this.he >= ((long) this.gS) && location != null) {
            if (location != null && location.hasSpeed() && location.getSpeed() > this.g7) {
                this.g7 = location.getSpeed();
            }
            try {
                if (this.hd == null) {
                    this.hd = new ArrayList();
                    bP();
                    if(location);
                } else {
                    int(location);
                }
            } catch (Exception e) {
            }
            this.hj++;
        }
    }

    private String o(String str) {
        Calendar instance = Calendar.getInstance();
        return String.format(str, new Object[]{Integer.valueOf(instance.get(1)), Integer.valueOf(instance.get(2) + 1), Integer.valueOf(instance.get(5))});
    }

    private void p(String str) {
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("on")) {
                    this.gZ = jSONObject.getInt("on");
                }
                if (jSONObject.has("bash")) {
                    this.gR = jSONObject.getDouble("bash");
                }
                if (jSONObject.has("net")) {
                    this.gM = jSONObject.getString("net");
                }
                if (jSONObject.has("tcon")) {
                    this.g3 = jSONObject.getInt("tcon");
                }
                if (jSONObject.has("tcsh")) {
                    this.g4 = jSONObject.getInt("tcsh");
                }
                if (jSONObject.has("per")) {
                    this.gK = jSONObject.getInt("per");
                }
                if (jSONObject.has("chdron")) {
                    this.hl = jSONObject.getInt("chdron");
                }
                if (jSONObject.has("spsh")) {
                    this.gN = jSONObject.getDouble("spsh");
                }
                if (jSONObject.has("acsh")) {
                    this.g8 = jSONObject.getDouble("acsh");
                }
                if (jSONObject.has("stspsh")) {
                    this.hc = jSONObject.getDouble("stspsh");
                }
                if (jSONObject.has("drstsh")) {
                    this.hu = jSONObject.getInt("drstsh");
                }
                if (jSONObject.has("stper")) {
                    this.gP = jSONObject.getInt("stper");
                }
                if (jSONObject.has("nondron")) {
                    this.gT = jSONObject.getInt("nondron");
                }
                if (jSONObject.has("nondrper")) {
                    this.hk = jSONObject.getInt("nondrper");
                }
                if (jSONObject.has("uptime")) {
                    this.hm = jSONObject.getLong("uptime");
                }
                bO();
            } catch (JSONException e) {
            }
        }
    }

    private byte[] q(String str) {
        int i = 0;
        if (str == null) {
            return null;
        }
        byte[] bytes = str.getBytes();
        byte nextInt = (byte) new Random().nextInt(255);
        byte nextInt2 = (byte) new Random().nextInt(255);
        byte[] bArr = new byte[(bytes.length + 2)];
        int length = bytes.length;
        int i2 = 0;
        while (i < length) {
            int i3 = i2 + 1;
            bArr[i2] = (byte) (bytes[i] ^ nextInt);
            i++;
            i2 = i3;
        }
        i = i2 + 1;
        bArr[i2] = nextInt;
        i2 = i + 1;
        bArr[i] = nextInt2;
        return bArr;
    }

    private void r(String str) {
        int i = 1;
        try {
            File file = new File(com.baidu.location.b.e.int + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(2);
                int readInt = randomAccessFile.readInt();
                randomAccessFile.seek(8);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.read(bArr, 0, readInt2);
                String str2 = new String(bArr);
                if (str2.contains(o(g5)) && str2.contains(Separators.COLON)) {
                    try {
                        String[] split = str2.split(Separators.COLON);
                        if (split.length > 1) {
                            this.hb = Integer.valueOf(split[1]).intValue();
                        }
                    } catch (Exception e) {
                    }
                }
                while (i <= readInt) {
                    randomAccessFile.seek((long) (i * 2048));
                    readInt2 = randomAccessFile.readInt();
                    bArr = new byte[readInt2];
                    randomAccessFile.read(bArr, 0, readInt2);
                    str2 = new String(bArr);
                    if (str != null && str2.contains(str)) {
                        p(str2);
                        break;
                    }
                    i++;
                }
                randomAccessFile.close();
            }
        } catch (Exception e2) {
        }
    }

    private void s(String str) {
        try {
            File file = new File(com.baidu.location.b.e.int + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(com.baidu.location.b.e.int);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
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
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
            randomAccessFile2.seek(2);
            int readInt = randomAccessFile2.readInt();
            int i = 1;
            while (i <= readInt) {
                randomAccessFile2.seek((long) (i * 2048));
                int readInt2 = randomAccessFile2.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile2.read(bArr, 0, readInt2);
                if (new String(bArr).contains(c.bn)) {
                    break;
                }
                i++;
            }
            if (i >= readInt) {
                randomAccessFile2.seek(2);
                randomAccessFile2.writeInt(i);
            }
            randomAccessFile2.seek((long) (i * 2048));
            byte[] bytes2 = str.getBytes();
            randomAccessFile2.writeInt(bytes2.length);
            randomAccessFile2.write(bytes2);
            randomAccessFile2.close();
        } catch (Exception e) {
        }
    }

    public void bL() {
        if (this.hi) {
            this.hi = false;
            bN();
        }
    }

    public void bM() {
        this.gJ.postDelayed(new u(this), 2000);
    }

    public void for(Location location) {
        if (!this.hi) {
            bR();
        }
        if (this.gZ != 1 || ((double) e.bx().by()) >= this.gR * 100.0d || !this.gM.contains(com.baidu.location.h.c.a(com.baidu.location.h.c.a().cR()))) {
            return;
        }
        if (this.g3 != 1 || this.hb <= this.g4) {
            this.gJ.post(new s(this, location));
        }
    }
}
