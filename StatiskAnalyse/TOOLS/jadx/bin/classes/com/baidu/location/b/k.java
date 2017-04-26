package com.baidu.location.b;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Environment;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.e.e;
import com.baidu.location.f;
import com.baidu.location.h.a;
import com.baidu.location.h.b;
import com.baidu.location.h.c;
import com.baidu.location.h.h;
import com.baidu.platform.comapi.location.CoordinateType;
import com.google.android.gms.search.SearchAuth.StatusCodes;
import com.tencent.open.yyb.TitleBar;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;

public class k implements f {
    public static int b0 = 0;
    public static int b1 = 0;
    public static byte[] b2 = null;
    public static int b3 = 3;
    public static double b4 = 0.0d;
    private static String b5 = "http://loc.map.baidu.com/tcu.php";
    private static String b6 = "http://loc.map.baidu.com/user_err.php";
    public static int b7 = 3;
    public static int b8 = 100;
    public static int b9 = 30;
    private static String bE = "http://loc.map.baidu.com/iofd.php";
    public static float bF = 0.5f;
    public static double bG = 0.0d;
    public static int bH = 20;
    public static int bI = 30000;
    public static int bJ = 7;
    public static boolean bK = true;
    public static float bL = 0.9f;
    public static int bM = 30000;
    private static String bN = "http://loc.map.baidu.com/sdk.php";
    public static int bO = 6;
    public static boolean bP = false;
    public static int bQ = 120;
    public static boolean bR = true;
    public static boolean bS = false;
    public static int bT = 1000;
    private static String bU = "http://loc.map.baidu.com/oqur.php";
    private static String bV = "http://loc.map.baidu.com/wloc";
    public static float bW = 2.2f;
    public static boolean bX = false;
    public static boolean bY = false;
    private static String bZ = "https://sapi.skyhookwireless.com/wps2/location";
    public static float cA = 3.8f;
    public static int cB = 20;
    public static int cC = 2;
    public static int cD = 16;
    public static double cE = 0.0d;
    public static int cF = 300;
    public static boolean cG = false;
    public static long cH = 15;
    public static int cI = 70;
    public static long cJ = 420000;
    public static int cK = 70;
    public static int cL = 0;
    public static boolean cM = false;
    public static String cN = CoordinateType.GCJ02;
    public static float cO = 50.0f;
    public static long cP = 300000;
    public static float cQ = 1.1f;
    public static float ca = 0.1f;
    public static float cb = 0.0f;
    public static int cc = 60;
    public static float cd = 6.0f;
    public static final boolean ce = true;
    public static String cf = "no";
    public static float cg = TitleBar.SHAREBTN_RIGHT_MARGIN;
    public static float ch = PhotoViewAttacher.DEFAULT_MAX_SCALE;
    public static boolean ci = false;
    public static boolean cj = false;
    public static float ck = 2.3f;
    public static boolean cl = true;
    public static boolean cm = false;
    public static float cn = TitleBar.SHAREBTN_RIGHT_MARGIN;
    public static int co = 0;
    public static double cp = 0.0d;
    public static int cq = 10;
    public static int cr = 1000;
    public static long cs = 900000;
    public static long ct = 0;
    public static long cu = 180000;
    public static String cv = "http://loc.map.baidu.com/sdk_ep.php";
    public static int cw = 420000;
    public static float cx = 200.0f;
    public static int cy = StatusCodes.AUTH_DISABLED;
    public static float cz = TitleBar.SHAREBTN_RIGHT_MARGIN;

    static String X() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(13);
        return String.format(Locale.CHINA, "%d_%d_%d_%d_%d_%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    public static String Y() {
        return bU;
    }

    public static String Z() {
        return bN;
    }

    public static String aa() {
        return bV;
    }

    public static String ab() {
        return bZ;
    }

    public static String ac() {
        return b5;
    }

    public static String ad() {
        Calendar instance = Calendar.getInstance();
        int i = instance.get(5);
        int i2 = instance.get(1);
        int i3 = instance.get(2) + 1;
        int i4 = instance.get(11);
        int i5 = instance.get(12);
        int i6 = instance.get(13);
        return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6)});
    }

    public static String ae() {
        return b6;
    }

    public static String af() {
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        try {
            String path = Environment.getExternalStorageDirectory().getPath();
            File file = new File(path + "/baidu/tempdata");
            if (file.exists()) {
                return path;
            }
            file.mkdirs();
            return path;
        } catch (Exception e) {
            return null;
        }
    }

    public static String ag() {
        return bE;
    }

    public static String ah() {
        String af = af();
        return af == null ? null : af + "/baidu/tempdata";
    }

    public static String ai() {
        try {
            File file = new File(f.getServiceContext().getFilesDir() + File.separator + "lldt");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath();
        } catch (Exception e) {
            return null;
        }
    }

    static float do(String str, String str2, String str3) {
        float f = Float.MIN_VALUE;
        if (!(str == null || str.equals(""))) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                indexOf += str2.length();
                int indexOf2 = str.indexOf(str3, indexOf);
                if (indexOf2 != -1) {
                    String substring = str.substring(indexOf, indexOf2);
                    if (!(substring == null || substring.equals(""))) {
                        try {
                            f = Float.parseFloat(substring);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return f;
    }

    public static boolean do(BDLocation bDLocation) {
        int locType = bDLocation.getLocType();
        return locType > 100 && locType < 200;
    }

    public static int for(String str, String str2, String str3) {
        int i = Integer.MIN_VALUE;
        if (!(str == null || str.equals(""))) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                indexOf += str2.length();
                int indexOf2 = str.indexOf(str3, indexOf);
                if (indexOf2 != -1) {
                    String substring = str.substring(indexOf, indexOf2);
                    if (!(substring == null || substring.equals(""))) {
                        try {
                            i = Integer.parseInt(substring);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return i;
    }

    public static boolean for(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo state : allNetworkInfo) {
            if (state.getState() == State.CONNECTED) {
                return true;
            }
        }
        return false;
    }

    public static String if(h hVar, com.baidu.location.h.f fVar, Location location, String str) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        if (hVar != null) {
            str2 = b.cW().new(hVar);
            if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        if (fVar != null) {
            try {
                str2 = fVar.e(5);
            } catch (Exception e) {
                str2 = null;
            }
            if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        if (location != null) {
            str2 = b1 != 0 ? a.else(location) : a.goto(location);
            if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        str2 = c.N().do(false);
        if (str2 != null) {
            stringBuffer.append(str2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        if (hVar != null) {
            str2 = c.a().int(hVar);
            if (str2 != null && str2.length() + stringBuffer.length() < 750) {
                stringBuffer.append(str2);
            }
        }
        return stringBuffer.toString();
    }

    public static String if(h hVar, com.baidu.location.h.f fVar, Location location, String str, int i) {
        String str2;
        StringBuffer stringBuffer = new StringBuffer(1024);
        if (hVar != null) {
            str2 = b.cW().new(hVar);
            if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        if (fVar != null) {
            str2 = i == 0 ? fVar.dr() : fVar.dm();
            if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        if (location != null) {
            str2 = (b1 == 0 || i == 0) ? a.goto(location) : a.else(location);
            if (str2 != null) {
                stringBuffer.append(str2);
            }
        }
        boolean z = false;
        if (i == 0) {
            z = true;
        }
        str2 = c.N().do(z);
        if (str2 != null) {
            stringBuffer.append(str2);
        }
        if (str != null) {
            stringBuffer.append(str);
        }
        Object bw = e.bx().bw();
        if (!TextUtils.isEmpty(bw)) {
            stringBuffer.append("&bc=").append(bw);
        }
        if (i == 0) {
            if (hVar != null) {
                str2 = c.a().int(hVar);
                if (str2 != null && str2.length() + stringBuffer.length() < 750) {
                    stringBuffer.append(str2);
                }
            }
            str2 = stringBuffer.toString();
            if (location != null || fVar == null) {
                b3 = 3;
            } else {
                try {
                    float speed = location.getSpeed();
                    int i2 = b1;
                    int dh = fVar.dh();
                    int dn = fVar.dn();
                    boolean dj = fVar.dj();
                    if (speed < cd && ((i2 == 1 || i2 == 0) && (dh < cc || dj))) {
                        b3 = 1;
                    } else if (speed >= cz || (!(i2 == 1 || i2 == 0 || i2 == 3) || (dh >= cK && dn <= bO))) {
                        b3 = 3;
                    } else {
                        b3 = 2;
                    }
                } catch (Exception e) {
                    b3 = 3;
                }
            }
            return str2;
        }
        if (hVar != null) {
            str2 = c.a().int(hVar);
            stringBuffer.append(str2);
        }
        str2 = stringBuffer.toString();
        if (location != null) {
        }
        b3 = 3;
        return str2;
    }

    public static String if(File file) {
        if (!file.isFile()) {
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int read = fileInputStream.read(bArr, 0, 1024);
                if (read != -1) {
                    instance.update(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return new BigInteger(1, instance.digest()).toString(16);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static String if(String str, String str2, String str3, double d) {
        if (str == null || str.equals("")) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        indexOf += str2.length();
        int indexOf2 = str.indexOf(str3, indexOf);
        if (indexOf2 == -1) {
            return null;
        }
        String substring = str.substring(0, indexOf);
        return substring + String.format(Locale.CHINA, "%.7f", new Object[]{Double.valueOf(d)}) + str.substring(indexOf2);
    }

    static double int(String str, String str2, String str3) {
        double d = Double.MIN_VALUE;
        if (!(str == null || str.equals(""))) {
            int indexOf = str.indexOf(str2);
            if (indexOf != -1) {
                indexOf += str2.length();
                int indexOf2 = str.indexOf(str3, indexOf);
                if (indexOf2 != -1) {
                    String substring = str.substring(indexOf, indexOf2);
                    if (!(substring == null || substring.equals(""))) {
                        try {
                            d = Double.parseDouble(substring);
                        } catch (NumberFormatException e) {
                        }
                    }
                }
            }
        }
        return d;
    }
}
