package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp.zza;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcw;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzmi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzgr
public class zzi extends zza {
    private final Context mContext;
    private final zzo zzoT;
    private final zzcw zzoU;
    private final zzcx zzoV;
    private final zzmi<String, zzcz> zzoW;
    private final zzmi<String, zzcy> zzoX;
    private final NativeAdOptionsParcel zzoY;
    private final List<String> zzoZ;
    private final zzem zzox;
    private final String zzpa;
    private final VersionInfoParcel zzpb;
    private WeakReference<zzn> zzpc;
    private Object zzpd = new Object();

    zzi(Context context, String str, zzem com_google_android_gms_internal_zzem, VersionInfoParcel versionInfoParcel, zzo com_google_android_gms_ads_internal_client_zzo, zzcw com_google_android_gms_internal_zzcw, zzcx com_google_android_gms_internal_zzcx, zzmi<String, zzcz> com_google_android_gms_internal_zzmi_java_lang_String__com_google_android_gms_internal_zzcz, zzmi<String, zzcy> com_google_android_gms_internal_zzmi_java_lang_String__com_google_android_gms_internal_zzcy, NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.mContext = context;
        this.zzpa = str;
        this.zzox = com_google_android_gms_internal_zzem;
        this.zzpb = versionInfoParcel;
        this.zzoT = com_google_android_gms_ads_internal_client_zzo;
        this.zzoV = com_google_android_gms_internal_zzcx;
        this.zzoU = com_google_android_gms_internal_zzcw;
        this.zzoW = com_google_android_gms_internal_zzmi_java_lang_String__com_google_android_gms_internal_zzcz;
        this.zzoX = com_google_android_gms_internal_zzmi_java_lang_String__com_google_android_gms_internal_zzcy;
        this.zzoY = nativeAdOptionsParcel;
        this.zzoZ = zzbi();
    }

    private List<String> zzbi() {
        List<String> arrayList = new ArrayList();
        if (this.zzoV != null) {
            arrayList.add("1");
        }
        if (this.zzoU != null) {
            arrayList.add("2");
        }
        if (this.zzoW.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMediationAdapterClassName() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.zzpd;
        monitor-enter(r2);
        r0 = r3.zzpc;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.zzpc;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.zzn) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.getMediationAdapterClassName();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzi.getMediationAdapterClassName():java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLoading() {
        /*
        r3 = this;
        r1 = 0;
        r2 = r3.zzpd;
        monitor-enter(r2);
        r0 = r3.zzpc;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x001a;
    L_0x0008:
        r0 = r3.zzpc;	 Catch:{ all -> 0x001d }
        r0 = r0.get();	 Catch:{ all -> 0x001d }
        r0 = (com.google.android.gms.ads.internal.zzn) r0;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0018;
    L_0x0012:
        r0 = r0.isLoading();	 Catch:{ all -> 0x001d }
    L_0x0016:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
    L_0x0017:
        return r0;
    L_0x0018:
        r0 = r1;
        goto L_0x0016;
    L_0x001a:
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        r0 = r1;
        goto L_0x0017;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzi.isLoading():boolean");
    }

    protected void runOnUiThread(Runnable runnable) {
        zzid.zzIE.post(runnable);
    }

    protected zzn zzbj() {
        return new zzn(this.mContext, AdSizeParcel.zzs(this.mContext), this.zzpa, this.zzox, this.zzpb);
    }

    public void zzf(final AdRequestParcel adRequestParcel) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ zzi zzpf;

            public void run() {
                synchronized (this.zzpf.zzpd) {
                    zzn zzbj = this.zzpf.zzbj();
                    this.zzpf.zzpc = new WeakReference(zzbj);
                    zzbj.zzb(this.zzpf.zzoU);
                    zzbj.zzb(this.zzpf.zzoV);
                    zzbj.zza(this.zzpf.zzoW);
                    zzbj.zza(this.zzpf.zzoT);
                    zzbj.zzb(this.zzpf.zzoX);
                    zzbj.zza(this.zzpf.zzbi());
                    zzbj.zzb(this.zzpf.zzoY);
                    zzbj.zzb(adRequestParcel);
                }
            }
        });
    }
}
