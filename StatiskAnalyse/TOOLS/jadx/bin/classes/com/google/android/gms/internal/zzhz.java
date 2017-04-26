package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zzgr
public abstract class zzhz implements zzgh<Future> {
    private volatile Thread zzIl;
    private boolean zzIm;
    private final Runnable zzx;

    public zzhz() {
        this.zzx = new Runnable(this) {
            final /* synthetic */ zzhz zzIn;

            {
                this.zzIn = r1;
            }

            public final void run() {
                this.zzIn.zzIl = Thread.currentThread();
                this.zzIn.zzbn();
            }
        };
        this.zzIm = false;
    }

    public zzhz(boolean z) {
        this.zzx = /* anonymous class already generated */;
        this.zzIm = z;
    }

    public final void cancel() {
        onStop();
        if (this.zzIl != null) {
            this.zzIl.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzbn();

    public /* synthetic */ Object zzfu() {
        return zzgz();
    }

    public final Future zzgz() {
        return this.zzIm ? zzic.zza(1, this.zzx) : zzic.zza(this.zzx);
    }
}
