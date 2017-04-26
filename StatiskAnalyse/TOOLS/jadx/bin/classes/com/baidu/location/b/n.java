package com.baidu.location.b;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class n {
    static n if;
    int a = 20;
    int do = 0;
    int for = 3164;
    int int = 60;
    int new = 40;
    String try = "firll.dat";

    private long a(int i) {
        RandomAccessFile randomAccessFile;
        Throwable th;
        String ai = k.ai();
        if (ai == null) {
            return -1;
        }
        String str = ai + File.separator + this.try;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                randomAccessFile.seek((long) i);
                int readInt = randomAccessFile.readInt();
                long readLong = randomAccessFile.readLong();
                if (readInt == randomAccessFile.readInt()) {
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e) {
                        }
                    }
                    return readLong;
                } else if (randomAccessFile == null) {
                    return -1;
                } else {
                    try {
                        randomAccessFile.close();
                        return -1;
                    } catch (IOException e2) {
                        return -1;
                    }
                }
            } catch (Exception e3) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    return -1;
                }
                try {
                    randomAccessFile2.close();
                    return -1;
                } catch (IOException e4) {
                    return -1;
                }
            } catch (Throwable th2) {
                th = th2;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            if (randomAccessFile2 != null) {
                return -1;
            }
            randomAccessFile2.close();
            return -1;
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private void a(int i, long j) {
        String ai = k.ai();
        if (ai != null) {
            try {
                RandomAccessFile randomAccessFile = new RandomAccessFile(ai + File.separator + this.try, "rw");
                randomAccessFile.seek((long) i);
                randomAccessFile.writeInt(this.for);
                randomAccessFile.writeLong(j);
                randomAccessFile.writeInt(this.for);
                randomAccessFile.close();
            } catch (Exception e) {
            }
        }
    }

    public static n if() {
        if (if == null) {
            if = new n();
        }
        return if;
    }

    public long a() {
        return a(this.a);
    }

    public void a(long j) {
        a(this.int, j);
    }

    public long do() {
        return a(this.do);
    }

    public void do(long j) {
        a(this.a, j);
    }

    public long for() {
        return a(this.int);
    }

    public void for(long j) {
        a(this.do, j);
    }

    public void if(long j) {
        a(this.new, j);
    }

    public long int() {
        return a(this.new);
    }
}
