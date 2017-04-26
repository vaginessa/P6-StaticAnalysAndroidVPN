package com.google.android.gms.ads.internal;

import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbw;
import com.google.android.gms.internal.zzbx;
import com.google.android.gms.internal.zzcb;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzgg;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgz;
import com.google.android.gms.internal.zzhu;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzii;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;

@zzgr
public class zzp {
    private static zzp zzpN;
    private static final Object zzpy = new Object();
    private final zza zzpO = new zza();
    private final com.google.android.gms.ads.internal.overlay.zza zzpP = new com.google.android.gms.ads.internal.overlay.zza();
    private final zze zzpQ = new zze();
    private final zzgg zzpR = new zzgg();
    private final zzid zzpS = new zzid();
    private final zzjb zzpT = new zzjb();
    private final zzie zzpU = zzie.zzM(VERSION.SDK_INT);
    private final zzhu zzpV = new zzhu(this.zzpS);
    private final zzmn zzpW = new zzmp();
    private final zzcb zzpX = new zzcb();
    private final zzgz zzpY = new zzgz();
    private final zzbw zzpZ = new zzbw();
    private final zzbv zzqa = new zzbv();
    private final zzbx zzqb = new zzbx();
    private final zzi zzqc = new zzi();
    private final zzii zzqd = new zzii();
    private final zzej zzqe = new zzej();
    private final zzdu zzqf = new zzdu();

    static {
        zza(new zzp());
    }

    protected zzp() {
    }

    protected static void zza(zzp com_google_android_gms_ads_internal_zzp) {
        synchronized (zzpy) {
            zzpN = com_google_android_gms_ads_internal_zzp;
        }
    }

    public static zzcb zzbA() {
        return zzbq().zzpX;
    }

    public static zzgz zzbB() {
        return zzbq().zzpY;
    }

    public static zzbw zzbC() {
        return zzbq().zzpZ;
    }

    public static zzbv zzbD() {
        return zzbq().zzqa;
    }

    public static zzbx zzbE() {
        return zzbq().zzqb;
    }

    public static zzi zzbF() {
        return zzbq().zzqc;
    }

    public static zzii zzbG() {
        return zzbq().zzqd;
    }

    public static zzej zzbH() {
        return zzbq().zzqe;
    }

    public static zzdu zzbI() {
        return zzbq().zzqf;
    }

    private static zzp zzbq() {
        zzp com_google_android_gms_ads_internal_zzp;
        synchronized (zzpy) {
            com_google_android_gms_ads_internal_zzp = zzpN;
        }
        return com_google_android_gms_ads_internal_zzp;
    }

    public static zza zzbr() {
        return zzbq().zzpO;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zzbs() {
        return zzbq().zzpP;
    }

    public static zze zzbt() {
        return zzbq().zzpQ;
    }

    public static zzgg zzbu() {
        return zzbq().zzpR;
    }

    public static zzid zzbv() {
        return zzbq().zzpS;
    }

    public static zzjb zzbw() {
        return zzbq().zzpT;
    }

    public static zzie zzbx() {
        return zzbq().zzpU;
    }

    public static zzhu zzby() {
        return zzbq().zzpV;
    }

    public static zzmn zzbz() {
        return zzbq().zzpW;
    }
}
