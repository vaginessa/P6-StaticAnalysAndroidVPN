package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzhu;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
public class zzi {
    public void zza(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.zza(intent, gInAppPurchaseManagerInfoParcel);
        zzp.zzbv().zzb(context, intent);
    }

    public String zzao(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("developerPayload");
            } catch (JSONException e) {
                zzb.zzaH("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public String zzap(String str) {
        String str2 = null;
        if (str != null) {
            try {
                str2 = new JSONObject(str).getString("purchaseToken");
            } catch (JSONException e) {
                zzb.zzaH("Fail to parse purchase data");
            }
        }
        return str2;
    }

    public int zzc(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            zzb.zzaH("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            zzb.zzaH("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public int zzd(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            zzb.zzaH("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            zzb.zzaH("Unexpected type for intent response code. " + obj.getClass().getName());
            return 5;
        }
    }

    public String zze(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_PURCHASE_DATA");
    }

    public String zzf(Intent intent) {
        return intent == null ? null : intent.getStringExtra("INAPP_DATA_SIGNATURE");
    }

    public void zzx(final Context context) {
        ServiceConnection anonymousClass1 = new ServiceConnection(this) {
            final /* synthetic */ zzi zzDa;

            public void onServiceConnected(ComponentName name, IBinder service) {
                boolean z = false;
                zzb com_google_android_gms_ads_internal_purchase_zzb = new zzb(context.getApplicationContext(), false);
                com_google_android_gms_ads_internal_purchase_zzb.zzN(service);
                int zza = com_google_android_gms_ads_internal_purchase_zzb.zza(3, context.getPackageName(), "inapp");
                zzhu zzby = zzp.zzby();
                if (zza == 0) {
                    z = true;
                }
                zzby.zzB(z);
                context.unbindService(this);
                com_google_android_gms_ads_internal_purchase_zzb.destroy();
            }

            public void onServiceDisconnected(ComponentName name) {
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage(GooglePlayServicesUtil.GOOGLE_PLAY_STORE_PACKAGE);
        context.bindService(intent, anonymousClass1, 1);
    }
}
