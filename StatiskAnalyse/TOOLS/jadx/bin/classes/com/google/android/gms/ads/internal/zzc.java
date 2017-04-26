package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzcj;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzfi;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhs;
import com.google.android.gms.internal.zzhs.zza;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziz;

@zzgr
public abstract class zzc extends zzb implements zzg, zzfi {
    public zzc(Context context, AdSizeParcel adSizeParcel, String str, zzem com_google_android_gms_internal_zzem, VersionInfoParcel versionInfoParcel, zzd com_google_android_gms_ads_internal_zzd) {
        super(context, adSizeParcel, str, com_google_android_gms_internal_zzem, versionInfoParcel, com_google_android_gms_ads_internal_zzd);
    }

    public void recordClick() {
        onAdClicked();
    }

    public void recordImpression() {
        zza(this.zzot.zzqo, false);
    }

    protected zziz zza(zza com_google_android_gms_internal_zzhs_zza, zze com_google_android_gms_ads_internal_zze) {
        zziz com_google_android_gms_internal_zziz;
        View nextView = this.zzot.zzqk.getNextView();
        zziz com_google_android_gms_internal_zziz2;
        if (nextView instanceof zziz) {
            zzb.zzaF("Reusing webview...");
            com_google_android_gms_internal_zziz2 = (zziz) nextView;
            com_google_android_gms_internal_zziz2.zza(this.zzot.context, this.zzot.zzqn, this.zzoo);
            com_google_android_gms_internal_zziz = com_google_android_gms_internal_zziz2;
        } else {
            if (nextView != null) {
                this.zzot.zzqk.removeView(nextView);
            }
            com_google_android_gms_internal_zziz2 = zzp.zzbw().zza(this.zzot.context, this.zzot.zzqn, false, false, this.zzot.zzqi, this.zzot.zzqj, this.zzoo, this.zzow);
            if (this.zzot.zzqn.zztg == null) {
                zzb(com_google_android_gms_internal_zziz2.getView());
            }
            com_google_android_gms_internal_zziz = com_google_android_gms_internal_zziz2;
        }
        com_google_android_gms_internal_zziz.zzhe().zzb(this, this, this, this, false, this, null, com_google_android_gms_ads_internal_zze, this);
        com_google_android_gms_internal_zziz.zzaJ(com_google_android_gms_internal_zzhs_zza.zzHC.zzEC);
        return com_google_android_gms_internal_zziz;
    }

    public void zza(int i, int i2, int i3, int i4) {
        zzaS();
    }

    public void zza(zzck com_google_android_gms_internal_zzck) {
        zzx.zzci("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzot.zzqC = com_google_android_gms_internal_zzck;
    }

    protected void zza(final zza com_google_android_gms_internal_zzhs_zza, final zzcg com_google_android_gms_internal_zzcg) {
        if (com_google_android_gms_internal_zzhs_zza.errorCode != -2) {
            zzid.zzIE.post(new Runnable(this) {
                final /* synthetic */ zzc zzoC;

                public void run() {
                    this.zzoC.zzb(new zzhs(com_google_android_gms_internal_zzhs_zza, null, null, null, null, null, null));
                }
            });
            return;
        }
        if (com_google_android_gms_internal_zzhs_zza.zzqn != null) {
            this.zzot.zzqn = com_google_android_gms_internal_zzhs_zza.zzqn;
        }
        if (com_google_android_gms_internal_zzhs_zza.zzHD.zzEK) {
            this.zzot.zzqH = 0;
            this.zzot.zzqm = zzp.zzbu().zza(this.zzot.context, this, com_google_android_gms_internal_zzhs_zza, this.zzot.zzqi, null, this.zzox, this, com_google_android_gms_internal_zzcg);
            return;
        }
        zzid.zzIE.post(new Runnable(this) {
            final /* synthetic */ zzc zzoC;

            public void run() {
                if (com_google_android_gms_internal_zzhs_zza.zzHD.zzET && this.zzoC.zzot.zzqC != null) {
                    String str = null;
                    if (com_google_android_gms_internal_zzhs_zza.zzHD.zzBF != null) {
                        str = zzp.zzbv().zzaz(com_google_android_gms_internal_zzhs_zza.zzHD.zzBF);
                    }
                    zzcj com_google_android_gms_internal_zzch = new zzch(this.zzoC, str, com_google_android_gms_internal_zzhs_zza.zzHD.body);
                    this.zzoC.zzot.zzqH = 1;
                    try {
                        this.zzoC.zzot.zzqC.zza(com_google_android_gms_internal_zzch);
                        return;
                    } catch (Throwable e) {
                        zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", e);
                    }
                }
                final zze com_google_android_gms_ads_internal_zze = new zze();
                zziz zza = this.zzoC.zza(com_google_android_gms_internal_zzhs_zza, com_google_android_gms_ads_internal_zze);
                com_google_android_gms_ads_internal_zze.zza(new zze.zzb(com_google_android_gms_internal_zzhs_zza, zza));
                zza.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ AnonymousClass2 zzoF;

                    public boolean onTouch(View v, MotionEvent event) {
                        com_google_android_gms_ads_internal_zze.recordClick();
                        return false;
                    }
                });
                zza.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass2 zzoF;

                    public void onClick(View v) {
                        com_google_android_gms_ads_internal_zze.recordClick();
                    }
                });
                this.zzoC.zzot.zzqH = 0;
                this.zzoC.zzot.zzqm = zzp.zzbu().zza(this.zzoC.zzot.context, this.zzoC, com_google_android_gms_internal_zzhs_zza, this.zzoC.zzot.zzqi, zza, this.zzoC.zzox, this.zzoC, com_google_android_gms_internal_zzcg);
            }
        });
    }

    protected boolean zza(zzhs com_google_android_gms_internal_zzhs, zzhs com_google_android_gms_internal_zzhs2) {
        if (this.zzot.zzbN() && this.zzot.zzqk != null) {
            this.zzot.zzqk.zzbT().zzaC(com_google_android_gms_internal_zzhs2.zzEP);
        }
        return super.zza(com_google_android_gms_internal_zzhs, com_google_android_gms_internal_zzhs2);
    }

    public void zzbc() {
        zzaQ();
    }

    public void zzc(View view) {
        this.zzot.zzqG = view;
        zzb(new zzhs(this.zzot.zzqp, null, null, null, null, null, null));
    }
}
