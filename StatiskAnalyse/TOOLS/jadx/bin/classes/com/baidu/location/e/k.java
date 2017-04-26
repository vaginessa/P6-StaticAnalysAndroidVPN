package com.baidu.location.e;

import android.location.Location;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.b.e;
import com.baidu.location.b.f;
import com.baidu.mapapi.UIMsg.m_AppUI;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;

public class k implements f {
    private static final int h0 = 750;
    private static final int h1 = 1000;
    private static final int h3 = 100;
    private static int h5 = 0;
    private static k h6 = null;
    private static long h7 = 0;
    private static final int hJ = 12;
    private static StringBuffer hK = null;
    private static final int hL = 5;
    private static File hM = new File(e.int, hW);
    private static final int hN = 3600;
    private static int hO = 0;
    private static long hP = 0;
    private static long hQ = 0;
    private static boolean hR = true;
    private static final int hS = 1024;
    private static int hT = 0;
    private static double hU = 0.0d;
    private static double hV = 0.0d;
    private static String hW = "Temp_in.dat";
    private static int hX = 0;
    private static int hY = 0;
    private static final int hZ = 5;
    private String h2 = null;
    private boolean h4 = true;

    private k(String str) {
        if (str == null) {
            str = "";
        } else if (str.length() > 100) {
            str = str.substring(0, 100);
        }
        this.h2 = str;
    }

    private static boolean b4() {
        if (hM.exists()) {
            hM.delete();
        }
        if (!hM.getParentFile().exists()) {
            hM.getParentFile().mkdirs();
        }
        try {
            hM.createNewFile();
            RandomAccessFile randomAccessFile = new RandomAccessFile(hM, "rw");
            randomAccessFile.seek(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(0);
            randomAccessFile.writeInt(1);
            randomAccessFile.close();
            b6();
            return hM.exists();
        } catch (IOException e) {
            return false;
        }
    }

    private void b5() {
        if (hK != null && hK.length() >= 100) {
            u(hK.toString());
        }
        b6();
    }

    private static void b6() {
        hR = true;
        hK = null;
        hX = 0;
        h5 = 0;
        hQ = 0;
        hP = 0;
        h7 = 0;
        hU = 0.0d;
        hV = 0.0d;
        hO = 0;
        hT = 0;
        hY = 0;
    }

    private void b7() {
    }

    public static k b8() {
        if (h6 == null) {
            h6 = new k(c.N().K());
        }
        return h6;
    }

    public static String b9() {
        if (hM == null) {
            return null;
        }
        if (!hM.exists()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(hM, "rw");
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            if (!if(readInt, readInt2, readInt3)) {
                randomAccessFile.close();
                b4();
                return null;
            } else if (readInt2 == 0 || readInt2 == readInt3) {
                randomAccessFile.close();
                return null;
            } else {
                long j = 0 + ((long) (((readInt2 - 1) * 1024) + 12));
                randomAccessFile.seek(j);
                int readInt4 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt4];
                randomAccessFile.seek(j + 4);
                for (readInt3 = 0; readInt3 < readInt4; readInt3++) {
                    bArr[readInt3] = randomAccessFile.readByte();
                }
                String str = new String(bArr);
                readInt3 = readInt < com.baidu.location.b.k.cr ? readInt2 + 1 : readInt2 == com.baidu.location.b.k.cr ? 1 : readInt2 + 1;
                randomAccessFile.seek(4);
                randomAccessFile.writeInt(readInt3);
                randomAccessFile.close();
                return str;
            }
        } catch (IOException e) {
            return null;
        }
    }

    private boolean ca() {
        if (hM.exists()) {
            hM.delete();
        }
        b6();
        return !hM.exists();
    }

    private static boolean if(int i, int i2, int i3) {
        return (i < 0 || i > com.baidu.location.b.k.cr) ? false : (i2 < 0 || i2 > i + 1) ? false : i3 >= 1 && i3 <= i + 1 && i3 <= com.baidu.location.b.k.cr;
    }

    private boolean if(Location location, int i, int i2) {
        if (location == null || !com.baidu.location.b.k.bR || !this.h4 || !f.bC().gC) {
            return false;
        }
        if (com.baidu.location.b.k.cB < 5) {
            com.baidu.location.b.k.cB = 5;
        } else if (com.baidu.location.b.k.cB > 1000) {
            com.baidu.location.b.k.cB = 1000;
        }
        if (com.baidu.location.b.k.cF < 5) {
            com.baidu.location.b.k.cF = 5;
        } else if (com.baidu.location.b.k.cF > hN) {
            com.baidu.location.b.k.cF = hN;
        }
        double longitude = location.getLongitude();
        double latitude = location.getLatitude();
        long time = location.getTime() / 1000;
        if (hR) {
            hX = 1;
            hK = new StringBuffer("");
            hK.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", new Object[]{this.h2, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)}));
            h5 = hK.length();
            hQ = time;
            hU = longitude;
            hV = latitude;
            hP = (long) Math.floor((longitude * 100000.0d) + 0.5d);
            h7 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
            hR = false;
            return true;
        }
        float[] fArr = new float[1];
        Location.distanceBetween(latitude, longitude, hV, hU, fArr);
        long j = time - hQ;
        if (fArr[0] < ((float) com.baidu.location.b.k.cB) && j < ((long) com.baidu.location.b.k.cF)) {
            return false;
        }
        if (hK == null) {
            hX++;
            h5 = 0;
            hK = new StringBuffer("");
            hK.append(String.format(Locale.CHINA, "&nr=%s&traj=%d,%.5f,%.5f|", new Object[]{this.h2, Long.valueOf(time), Double.valueOf(longitude), Double.valueOf(latitude)}));
            h5 = hK.length();
            hQ = time;
            hU = longitude;
            hV = latitude;
            hP = (long) Math.floor((longitude * 100000.0d) + 0.5d);
            h7 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
        } else {
            hU = longitude;
            hV = latitude;
            long floor = (long) Math.floor((longitude * 100000.0d) + 0.5d);
            long floor2 = (long) Math.floor((latitude * 100000.0d) + 0.5d);
            hO = (int) (time - hQ);
            hT = (int) (floor - hP);
            hY = (int) (floor2 - h7);
            hK.append(String.format(Locale.CHINA, "%d,%d,%d|", new Object[]{Integer.valueOf(hO), Integer.valueOf(hT), Integer.valueOf(hY)}));
            h5 = hK.length();
            hQ = time;
            hP = floor;
            h7 = floor2;
        }
        if (h5 + 15 > h0) {
            u(hK.toString());
            hK = null;
        }
        if (hX >= com.baidu.location.b.k.cr) {
            this.h4 = false;
        }
        return true;
    }

    private String try(int i) {
        if (!hM.exists()) {
            return null;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(hM, "rw");
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            if (!if(readInt, randomAccessFile.readInt(), randomAccessFile.readInt())) {
                randomAccessFile.close();
                b4();
                return null;
            } else if (i == 0 || i == readInt + 1) {
                randomAccessFile.close();
                return null;
            } else {
                long j = (12 + 0) + ((long) ((i - 1) * 1024));
                randomAccessFile.seek(j);
                int readInt2 = randomAccessFile.readInt();
                byte[] bArr = new byte[readInt2];
                randomAccessFile.seek(j + 4);
                for (readInt = 0; readInt < readInt2; readInt++) {
                    bArr[readInt] = randomAccessFile.readByte();
                }
                randomAccessFile.close();
                return new String(bArr);
            }
        } catch (IOException e) {
            return null;
        }
    }

    private boolean u(String str) {
        if (str == null || !str.startsWith("&nr")) {
            return false;
        }
        if (!hM.exists() && !b4()) {
            return false;
        }
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(hM, "rw");
            randomAccessFile.seek(0);
            int readInt = randomAccessFile.readInt();
            int readInt2 = randomAccessFile.readInt();
            int readInt3 = randomAccessFile.readInt();
            if (if(readInt, readInt2, readInt3)) {
                if (com.baidu.location.b.k.bK) {
                    if (readInt == com.baidu.location.b.k.cr) {
                        if (str.equals(try(readInt3 == 1 ? com.baidu.location.b.k.cr : readInt3 - 1))) {
                            randomAccessFile.close();
                            return false;
                        }
                    } else if (readInt3 > 1 && str.equals(try(readInt3 - 1))) {
                        randomAccessFile.close();
                        return false;
                    }
                }
                randomAccessFile.seek(((long) (((readInt3 - 1) * 1024) + 12)) + 0);
                if (str.length() > h0) {
                    randomAccessFile.close();
                    return false;
                }
                String H = Jni.H(str);
                int length = H.length();
                if (length > m_AppUI.MSG_GET_GL_OK) {
                    randomAccessFile.close();
                    return false;
                }
                randomAccessFile.writeInt(length);
                randomAccessFile.writeBytes(H);
                if (readInt == 0) {
                    randomAccessFile.seek(0);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(1);
                    randomAccessFile.writeInt(2);
                } else if (readInt < com.baidu.location.b.k.cr - 1) {
                    randomAccessFile.seek(0);
                    randomAccessFile.writeInt(readInt + 1);
                    randomAccessFile.seek(8);
                    randomAccessFile.writeInt(readInt + 2);
                } else if (readInt == com.baidu.location.b.k.cr - 1) {
                    randomAccessFile.seek(0);
                    randomAccessFile.writeInt(com.baidu.location.b.k.cr);
                    if (readInt2 == 0 || readInt2 == 1) {
                        randomAccessFile.writeInt(2);
                    }
                    randomAccessFile.seek(8);
                    randomAccessFile.writeInt(1);
                } else if (readInt3 == readInt2) {
                    readInt = readInt3 == com.baidu.location.b.k.cr ? 1 : readInt3 + 1;
                    r2 = readInt == com.baidu.location.b.k.cr ? 1 : readInt + 1;
                    randomAccessFile.seek(4);
                    randomAccessFile.writeInt(r2);
                    randomAccessFile.writeInt(readInt);
                } else {
                    readInt = readInt3 == com.baidu.location.b.k.cr ? 1 : readInt3 + 1;
                    if (readInt == readInt2) {
                        r2 = readInt == com.baidu.location.b.k.cr ? 1 : readInt + 1;
                        randomAccessFile.seek(4);
                        randomAccessFile.writeInt(r2);
                    }
                    randomAccessFile.seek(8);
                    randomAccessFile.writeInt(readInt);
                }
                randomAccessFile.close();
                return true;
            }
            randomAccessFile.close();
            b4();
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    public void cb() {
        b5();
    }

    public boolean try(Location location) {
        return if(location, com.baidu.location.b.k.cB, com.baidu.location.b.k.cF);
    }
}
