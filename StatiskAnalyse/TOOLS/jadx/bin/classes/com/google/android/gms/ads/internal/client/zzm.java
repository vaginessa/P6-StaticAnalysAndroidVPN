package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.client.zzv.zza;
import java.util.Random;

public class zzm extends zza {
    private Object zzpd = new Object();
    private final Random zzts = new Random();
    private long zztt;

    public zzm() {
        zzcL();
    }

    public long getValue() {
        return this.zztt;
    }

    public void zzcL() {
        synchronized (this.zzpd) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.zzts.nextInt()) + 2147483648L;
                if (j != this.zztt && j != 0) {
                    break;
                }
            }
            this.zztt = j;
        }
    }
}
