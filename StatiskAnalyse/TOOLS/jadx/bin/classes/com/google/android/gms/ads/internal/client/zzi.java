package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Creator<AdSizeParcel> {
    static void zza(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, adSizeParcel.versionCode);
        zzb.zza(parcel, 2, adSizeParcel.zzte, false);
        zzb.zzc(parcel, 3, adSizeParcel.height);
        zzb.zzc(parcel, 4, adSizeParcel.heightPixels);
        zzb.zza(parcel, 5, adSizeParcel.zztf);
        zzb.zzc(parcel, 6, adSizeParcel.width);
        zzb.zzc(parcel, 7, adSizeParcel.widthPixels);
        zzb.zza(parcel, 8, adSizeParcel.zztg, i, false);
        zzb.zza(parcel, 9, adSizeParcel.zzth);
        zzb.zza(parcel, 10, adSizeParcel.zzti);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzc(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzl(x0);
    }

    public AdSizeParcel zzc(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int zzap = zza.zzap(parcel);
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        boolean z3 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i5 = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    i4 = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 5:
                    z3 = zza.zzc(parcel, zzao);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) zza.zzb(parcel, zzao, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new AdSizeParcel(i5, str, i4, i3, z3, i2, i, adSizeParcelArr, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AdSizeParcel[] zzl(int i) {
        return new AdSizeParcel[i];
    }
}
