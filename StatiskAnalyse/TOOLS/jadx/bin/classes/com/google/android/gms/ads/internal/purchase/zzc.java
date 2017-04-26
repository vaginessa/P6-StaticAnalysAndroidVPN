package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzfw;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhz;
import com.google.android.gms.internal.zzid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zzgr
public class zzc extends zzhz implements ServiceConnection {
    private Context mContext;
    private boolean zzCB;
    private zzfw zzCC;
    private zzb zzCD;
    private zzh zzCE;
    private List<zzf> zzCF;
    private zzk zzCG;
    private final Object zzpd;

    public zzc(Context context, zzfw com_google_android_gms_internal_zzfw, zzk com_google_android_gms_ads_internal_purchase_zzk) {
        this(context, com_google_android_gms_internal_zzfw, com_google_android_gms_ads_internal_purchase_zzk, new zzb(context), zzh.zzw(context.getApplicationContext()));
    }

    zzc(Context context, zzfw com_google_android_gms_internal_zzfw, zzk com_google_android_gms_ads_internal_purchase_zzk, zzb com_google_android_gms_ads_internal_purchase_zzb, zzh com_google_android_gms_ads_internal_purchase_zzh) {
        this.zzpd = new Object();
        this.zzCB = false;
        this.zzCF = null;
        this.mContext = context;
        this.zzCC = com_google_android_gms_internal_zzfw;
        this.zzCG = com_google_android_gms_ads_internal_purchase_zzk;
        this.zzCD = com_google_android_gms_ads_internal_purchase_zzb;
        this.zzCE = com_google_android_gms_ads_internal_purchase_zzh;
        this.zzCF = this.zzCE.zzg(10);
    }

    private void zze(long j) {
        do {
            if (!zzf(j)) {
                zzb.v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzCB);
    }

    private boolean zzf(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpd.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzb.zzaH("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName name, IBinder service) {
        synchronized (this.zzpd) {
            this.zzCD.zzN(service);
            zzfm();
            this.zzCB = true;
            this.zzpd.notify();
        }
    }

    public void onServiceDisconnected(ComponentName name) {
        zzb.zzaG("In-app billing service disconnected.");
        this.zzCD.destroy();
    }

    public void onStop() {
        synchronized (this.zzpd) {
            com.google.android.gms.common.stats.zzb.zzqh().zza(this.mContext, this);
            this.zzCD.destroy();
        }
    }

    protected void zza(final zzf com_google_android_gms_ads_internal_purchase_zzf, String str, String str2) {
        final Intent intent = new Intent();
        zzp.zzbF();
        intent.putExtra("RESPONSE_CODE", 0);
        zzp.zzbF();
        intent.putExtra("INAPP_PURCHASE_DATA", str);
        zzp.zzbF();
        intent.putExtra("INAPP_DATA_SIGNATURE", str2);
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzc zzCI;

            public void run() {
                try {
                    if (this.zzCI.zzCG.zza(com_google_android_gms_ads_internal_purchase_zzf.zzCR, -1, intent)) {
                        this.zzCI.zzCC.zza(new zzg(this.zzCI.mContext, com_google_android_gms_ads_internal_purchase_zzf.zzCS, true, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    } else {
                        this.zzCI.zzCC.zza(new zzg(this.zzCI.mContext, com_google_android_gms_ads_internal_purchase_zzf.zzCS, false, -1, intent, com_google_android_gms_ads_internal_purchase_zzf));
                    }
                } catch (RemoteException e) {
                    zzb.zzaH("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    public void zzbn() {
        synchronized (this.zzpd) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
            com.google.android.gms.common.stats.zzb.zzqh().zza(this.mContext, intent, (ServiceConnection) this, 1);
            zze(SystemClock.elapsedRealtime());
            com.google.android.gms.common.stats.zzb.zzqh().zza(this.mContext, this);
            this.zzCD.destroy();
        }
    }

    protected void zzfm() {
        if (!this.zzCF.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzf com_google_android_gms_ads_internal_purchase_zzf : this.zzCF) {
                hashMap.put(com_google_android_gms_ads_internal_purchase_zzf.zzCS, com_google_android_gms_ads_internal_purchase_zzf);
            }
            String str = null;
            while (true) {
                Bundle zzj = this.zzCD.zzj(this.mContext.getPackageName(), str);
                if (zzj == null || zzp.zzbF().zzc(zzj) != 0) {
                    break;
                }
                ArrayList stringArrayList = zzj.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList stringArrayList2 = zzj.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList stringArrayList3 = zzj.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String string = zzj.getString("INAPP_CONTINUATION_TOKEN");
                for (int i = 0; i < stringArrayList.size(); i++) {
                    if (hashMap.containsKey(stringArrayList.get(i))) {
                        str = (String) stringArrayList.get(i);
                        String str2 = (String) stringArrayList2.get(i);
                        String str3 = (String) stringArrayList3.get(i);
                        zzf com_google_android_gms_ads_internal_purchase_zzf2 = (zzf) hashMap.get(str);
                        if (com_google_android_gms_ads_internal_purchase_zzf2.zzCR.equals(zzp.zzbF().zzao(str2))) {
                            zza(com_google_android_gms_ads_internal_purchase_zzf2, str2, str3);
                            hashMap.remove(str);
                        }
                    }
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str4 : hashMap.keySet()) {
                this.zzCE.zza((zzf) hashMap.get(str4));
            }
        }
    }
}
