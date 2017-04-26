package com.google.android.gms.ads.internal.purchase;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<GInAppPurchaseManagerInfoParcel> {
    static void zza(GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, gInAppPurchaseManagerInfoParcel.versionCode);
        zzb.zza(parcel, 3, gInAppPurchaseManagerInfoParcel.zzfj(), false);
        zzb.zza(parcel, 4, gInAppPurchaseManagerInfoParcel.zzfk(), false);
        zzb.zza(parcel, 5, gInAppPurchaseManagerInfoParcel.zzfl(), false);
        zzb.zza(parcel, 6, gInAppPurchaseManagerInfoParcel.zzfi(), false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzh(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzx(x0);
    }

    public GInAppPurchaseManagerInfoParcel zzh(Parcel parcel) {
        IBinder iBinder = null;
        int zzap = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(zzao)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzao);
                    break;
                case 3:
                    iBinder4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzao);
                    break;
                case 4:
                    iBinder3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzao);
                    break;
                case 5:
                    iBinder2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzao);
                    break;
                case 6:
                    iBinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzao);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new GInAppPurchaseManagerInfoParcel(i, iBinder4, iBinder3, iBinder2, iBinder);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public GInAppPurchaseManagerInfoParcel[] zzx(int i) {
        return new GInAppPurchaseManagerInfoParcel[i];
    }
}
