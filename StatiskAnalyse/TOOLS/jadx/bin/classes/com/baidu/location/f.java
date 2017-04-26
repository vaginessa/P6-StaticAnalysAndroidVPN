package com.baidu.location;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.location.a.a;
import com.baidu.location.b.e;
import com.baidu.location.b.k;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.RandomAccessFile;

public class f extends Service implements com.baidu.location.b.f {
    public static boolean isServing = false;
    private static final String lZ = "app.jar";
    public static Context mC = null;
    public static String replaceFileName = "repll.jar";
    LLSInterface l0 = null;
    LLSInterface l1 = null;
    LLSInterface lY = null;

    private boolean do(File file) {
        boolean z = false;
        try {
            File file2 = new File(e.int + "/grtcf.dat");
            if (file2.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                randomAccessFile.seek(200);
                if (randomAccessFile.readBoolean() && randomAccessFile.readBoolean()) {
                    int readInt = randomAccessFile.readInt();
                    if (readInt != 0) {
                        byte[] bArr = new byte[readInt];
                        randomAccessFile.read(bArr, 0, readInt);
                        String str = new String(bArr);
                        String str2 = k.if(file);
                        if (!(str == null || str2 == null || !str2.equals(str))) {
                            z = true;
                        }
                    }
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
        return z;
    }

    public static float getFrameVersion() {
        return com.baidu.location.b.f.bi;
    }

    public static String getJarFileName() {
        return lZ;
    }

    public static Context getServiceContext() {
        return mC;
    }

    public IBinder onBind(Intent intent) {
        return this.l1.onBind(intent);
    }

    public void onCreate() {
        mC = getApplicationContext();
        System.currentTimeMillis();
        this.l0 = new a();
        try {
            File file = new File(k.ai() + File.separator + replaceFileName);
            File file2 = new File(k.ai() + File.separator + lZ);
            if (file.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                file.renameTo(file2);
            }
            if (file2.exists()) {
                this.lY = (LLSInterface) new DexClassLoader(k.ai() + File.separator + lZ, k.ai(), null, getClassLoader()).loadClass("com.baidu.serverLoc.LocationService").newInstance();
            }
        } catch (Exception e) {
            this.lY = null;
        }
        if (this.lY == null || this.lY.getVersion() < this.l0.getVersion() || !do(new File(k.ai() + File.separator + lZ))) {
            this.l1 = this.l0;
            this.lY = null;
        } else {
            this.l1 = this.lY;
            this.l0 = null;
        }
        isServing = true;
        this.l1.onCreate(this);
    }

    public void onDestroy() {
        isServing = false;
        this.l1.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return this.l1.onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return this.l1.onUnBind(intent);
    }
}
