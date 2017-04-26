package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzav;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class AdvertisingIdClient {
    private static boolean zzoh = false;
    private final Context mContext;
    com.google.android.gms.common.zza zzob;
    zzav zzoc;
    boolean zzod;
    Object zzoe;
    zza zzof;
    final long zzog;

    public static final class Info {
        private final String zzom;
        private final boolean zzon;

        public Info(String advertisingId, boolean limitAdTrackingEnabled) {
            this.zzom = advertisingId;
            this.zzon = limitAdTrackingEnabled;
        }

        public String getId() {
            return this.zzom;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzon;
        }

        public String toString() {
            return "{" + this.zzom + "}" + this.zzon;
        }
    }

    static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzoi;
        private long zzoj;
        CountDownLatch zzok = new CountDownLatch(1);
        boolean zzol = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzoi = new WeakReference(advertisingIdClient);
            this.zzoj = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = (AdvertisingIdClient) this.zzoi.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzol = true;
            }
        }

        public void cancel() {
            this.zzok.countDown();
        }

        public void run() {
            try {
                if (!this.zzok.await(this.zzoj, TimeUnit.MILLISECONDS)) {
                    disconnect();
                }
            } catch (InterruptedException e) {
                disconnect();
            }
        }

        public boolean zzaK() {
            return this.zzol;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000);
    }

    public AdvertisingIdClient(Context context, long timeoutInMillis) {
        this.zzoe = new Object();
        zzx.zzw(context);
        this.mContext = context;
        this.zzod = false;
        this.zzog = timeoutInMillis;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1);
        try {
            advertisingIdClient.zzb(false);
            Info info = advertisingIdClient.getInfo();
            return info;
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean shouldSkipGmsCoreVersionCheck) {
        zzoh = shouldSkipGmsCoreVersionCheck;
    }

    static zzav zza(Context context, com.google.android.gms.common.zza com_google_android_gms_common_zza) throws IOException {
        try {
            return com.google.android.gms.internal.zzav.zza.zzb(com_google_android_gms_common_zza.zzno());
        } catch (InterruptedException e) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            IOException iOException = new IOException(th);
        }
    }

    private void zzaJ() {
        synchronized (this.zzoe) {
            if (this.zzof != null) {
                this.zzof.cancel();
                try {
                    this.zzof.join();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzog > 0) {
                this.zzof = new zza(this, this.zzog);
            }
        }
    }

    static com.google.android.gms.common.zza zzo(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE, 0);
            if (zzoh) {
                Log.d(AdRequest.LOGTAG, "Skipping gmscore version check");
                switch (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context)) {
                    case 0:
                    case 2:
                        break;
                    default:
                        throw new IOException("Google Play services not available");
                }
            }
            try {
                GooglePlayServicesUtil.zzaa(context);
            } catch (Throwable e) {
                throw new IOException(e);
            }
            ServiceConnection com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (zzb.zzqh().zza(context, intent, com_google_android_gms_common_zza, 1)) {
                    return com_google_android_gms_common_zza;
                }
                throw new IOException("Connection failure");
            } catch (Throwable e2) {
                IOException iOException = new IOException(e2);
            }
        } catch (NameNotFoundException e3) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finish() {
        /*
        r3 = this;
        r0 = "Calling this from your main thread can lead to deadlock";
        com.google.android.gms.common.internal.zzx.zzcj(r0);
        monitor-enter(r3);
        r0 = r3.mContext;	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x000e;
    L_0x000a:
        r0 = r3.zzob;	 Catch:{ all -> 0x002a }
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
    L_0x000f:
        return;
    L_0x0010:
        r0 = r3.zzod;	 Catch:{ IllegalArgumentException -> 0x002d }
        if (r0 == 0) goto L_0x001f;
    L_0x0014:
        r0 = com.google.android.gms.common.stats.zzb.zzqh();	 Catch:{ IllegalArgumentException -> 0x002d }
        r1 = r3.mContext;	 Catch:{ IllegalArgumentException -> 0x002d }
        r2 = r3.zzob;	 Catch:{ IllegalArgumentException -> 0x002d }
        r0.zza(r1, r2);	 Catch:{ IllegalArgumentException -> 0x002d }
    L_0x001f:
        r0 = 0;
        r3.zzod = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzoc = r0;	 Catch:{ all -> 0x002a }
        r0 = 0;
        r3.zzob = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        goto L_0x000f;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        r0 = move-exception;
        r1 = "AdvertisingIdClient";
        r2 = "AdvertisingIdClient unbindService failed.";
        android.util.Log.i(r1, r2, r0);	 Catch:{ all -> 0x002a }
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.identifier.AdvertisingIdClient.finish():void");
    }

    public Info getInfo() throws IOException {
        Info info;
        zzx.zzcj("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzod) {
                synchronized (this.zzoe) {
                    if (this.zzof == null || !this.zzof.zzaK()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zzb(false);
                    if (!this.zzod) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Throwable e) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e);
                    throw new IOException("Remote exception");
                } catch (Throwable e2) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e2);
                }
            }
            zzx.zzw(this.zzob);
            zzx.zzw(this.zzoc);
            info = new Info(this.zzoc.getId(), this.zzoc.zzc(true));
        }
        zzaJ();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzb(true);
    }

    protected void zzb(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzx.zzcj("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzod) {
                finish();
            }
            this.zzob = zzo(this.mContext);
            this.zzoc = zza(this.mContext, this.zzob);
            this.zzod = true;
            if (z) {
                zzaJ();
            }
        }
    }
}
