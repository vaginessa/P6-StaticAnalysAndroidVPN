package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzgt;
import com.google.android.gms.internal.zzhz;

@zzgr
public abstract class zzd extends zzhz implements com.google.android.gms.ads.internal.request.zzc.zza {
    private AdResponseParcel zzDf;
    private final com.google.android.gms.ads.internal.request.zzc.zza zzEi;
    private final Object zzpd = new Object();
    private final AdRequestInfoParcel zzzz;

    @zzgr
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
            super(adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
            this.mContext = context;
        }

        public void zzfH() {
        }

        public zzj zzfI() {
            return zzgt.zza(this.mContext, new zzbr((String) zzby.zzul.get()), zzgs.zzfQ());
        }
    }

    @zzgr
    public static class zzb extends zzd implements ConnectionCallbacks, OnConnectionFailedListener {
        private Context mContext;
        private final com.google.android.gms.ads.internal.request.zzc.zza zzEi;
        protected zze zzEj;
        private boolean zzEk;
        private final Object zzpd = new Object();
        private AdRequestInfoParcel zzzz;

        public zzb(Context context, AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
            Looper zzgM;
            super(adRequestInfoParcel, com_google_android_gms_ads_internal_request_zzc_zza);
            this.mContext = context;
            this.zzzz = adRequestInfoParcel;
            this.zzEi = com_google_android_gms_ads_internal_request_zzc_zza;
            if (((Boolean) zzby.zzuK.get()).booleanValue()) {
                this.zzEk = true;
                zzgM = zzp.zzbG().zzgM();
            } else {
                zzgM = context.getMainLooper();
            }
            this.zzEj = new zze(context, zzgM, this, this, adRequestInfoParcel.zzqj.zzJw);
            connect();
        }

        protected void connect() {
            this.zzEj.zzoZ();
        }

        public void onConnected(Bundle connectionHint) {
            zzgz();
        }

        public void onConnectionFailed(ConnectionResult result) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Cannot connect to remote service, fallback to local instance.");
            zzfJ().zzgz();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzp.zzbv().zzb(this.mContext, this.zzzz.zzqj.zzJu, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int cause) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaF("Disconnected from remote ad request service.");
        }

        public void zzfH() {
            synchronized (this.zzpd) {
                if (this.zzEj.isConnected() || this.zzEj.isConnecting()) {
                    this.zzEj.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzEk) {
                    zzp.zzbG().zzgN();
                    this.zzEk = false;
                }
            }
        }

        public zzj zzfI() {
            zzj zzfM;
            synchronized (this.zzpd) {
                try {
                    zzfM = this.zzEj.zzfM();
                } catch (IllegalStateException e) {
                    zzfM = null;
                    return zzfM;
                } catch (DeadObjectException e2) {
                    zzfM = null;
                    return zzfM;
                }
            }
            return zzfM;
        }

        zzhz zzfJ() {
            return new zza(this.mContext, this.zzzz, this.zzEi);
        }
    }

    public zzd(AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza com_google_android_gms_ads_internal_request_zzc_zza) {
        this.zzzz = adRequestInfoParcel;
        this.zzEi = com_google_android_gms_ads_internal_request_zzc_zza;
    }

    public final void onStop() {
        zzfH();
    }

    boolean zza(zzj com_google_android_gms_ads_internal_request_zzj, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            com_google_android_gms_ads_internal_request_zzj.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (Throwable e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service.", e);
            zzp.zzby().zzc(e, true);
        } catch (Throwable e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzp.zzby().zzc(e2, true);
        } catch (Throwable e22) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e22);
            zzp.zzby().zzc(e22, true);
        } catch (Throwable e222) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e222);
            zzp.zzby().zzc(e222, true);
        }
        this.zzEi.zzb(new AdResponseParcel(0));
        return false;
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzpd) {
            this.zzDf = adResponseParcel;
            this.zzpd.notify();
        }
    }

    public void zzbn() {
        try {
            zzj zzfI = zzfI();
            if (zzfI == null) {
                this.zzEi.zzb(new AdResponseParcel(0));
            } else if (zza(zzfI, this.zzzz)) {
                zzi(zzp.zzbz().elapsedRealtime());
            }
            zzfH();
        } catch (Throwable th) {
            zzfH();
        }
    }

    protected boolean zzf(long j) {
        long elapsedRealtime = 60000 - (zzp.zzbz().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpd.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public abstract void zzfH();

    public abstract zzj zzfI();

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void zzi(long r6) {
        /*
        r5 = this;
        r1 = r5.zzpd;
        monitor-enter(r1);
    L_0x0003:
        r0 = r5.zzDf;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0010;
    L_0x0007:
        r0 = r5.zzEi;	 Catch:{ all -> 0x0023 }
        r2 = r5.zzDf;	 Catch:{ all -> 0x0023 }
        r0.zzb(r2);	 Catch:{ all -> 0x0023 }
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r5.zzf(r6);	 Catch:{ all -> 0x0023 }
        if (r0 != 0) goto L_0x0003;
    L_0x0016:
        r0 = r5.zzDf;	 Catch:{ all -> 0x0023 }
        if (r0 == 0) goto L_0x0026;
    L_0x001a:
        r0 = r5.zzEi;	 Catch:{ all -> 0x0023 }
        r2 = r5.zzDf;	 Catch:{ all -> 0x0023 }
        r0.zzb(r2);	 Catch:{ all -> 0x0023 }
    L_0x0021:
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        goto L_0x000f;
    L_0x0023:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0023 }
        throw r0;
    L_0x0026:
        r0 = r5.zzEi;	 Catch:{ all -> 0x0023 }
        r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel;	 Catch:{ all -> 0x0023 }
        r3 = 0;
        r2.<init>(r3);	 Catch:{ all -> 0x0023 }
        r0.zzb(r2);	 Catch:{ all -> 0x0023 }
        goto L_0x0021;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzd.zzi(long):void");
    }
}
