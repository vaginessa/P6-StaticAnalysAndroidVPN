package com.google.android.gms.ads.internal;

import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import java.lang.ref.WeakReference;

@zzgr
public class zzo {
    private final zza zzpG;
    private AdRequestParcel zzpH;
    private boolean zzpI;
    private boolean zzpJ;
    private long zzpK;
    private final Runnable zzx;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long timeFromNowInMillis) {
            return this.mHandler.postDelayed(runnable, timeFromNowInMillis);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzo(zza com_google_android_gms_ads_internal_zza) {
        this(com_google_android_gms_ads_internal_zza, new zza(zzid.zzIE));
    }

    zzo(zza com_google_android_gms_ads_internal_zza, zza com_google_android_gms_ads_internal_zzo_zza) {
        this.zzpI = false;
        this.zzpJ = false;
        this.zzpK = 0;
        this.zzpG = com_google_android_gms_ads_internal_zzo_zza;
        final WeakReference weakReference = new WeakReference(com_google_android_gms_ads_internal_zza);
        this.zzx = new Runnable(this) {
            final /* synthetic */ zzo zzpM;

            public void run() {
                this.zzpM.zzpI = false;
                zza com_google_android_gms_ads_internal_zza = (zza) weakReference.get();
                if (com_google_android_gms_ads_internal_zza != null) {
                    com_google_android_gms_ads_internal_zza.zzd(this.zzpM.zzpH);
                }
            }
        };
    }

    public void cancel() {
        this.zzpI = false;
        this.zzpG.removeCallbacks(this.zzx);
    }

    public void pause() {
        this.zzpJ = true;
        if (this.zzpI) {
            this.zzpG.removeCallbacks(this.zzx);
        }
    }

    public void resume() {
        this.zzpJ = false;
        if (this.zzpI) {
            this.zzpI = false;
            zza(this.zzpH, this.zzpK);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        if (this.zzpI) {
            zzb.zzaH("An ad refresh is already scheduled.");
            return;
        }
        this.zzpH = adRequestParcel;
        this.zzpI = true;
        this.zzpK = j;
        if (!this.zzpJ) {
            zzb.zzaG("Scheduling ad refresh " + j + " milliseconds from now.");
            this.zzpG.postDelayed(this.zzx, j);
        }
    }

    public boolean zzbp() {
        return this.zzpI;
    }

    public void zzg(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000);
    }
}
