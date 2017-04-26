package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzg implements Creator<AdRequestParcel> {
    static void zza(AdRequestParcel adRequestParcel, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, adRequestParcel.versionCode);
        zzb.zza(parcel, 2, adRequestParcel.zzsB);
        zzb.zza(parcel, 3, adRequestParcel.extras, false);
        zzb.zzc(parcel, 4, adRequestParcel.zzsC);
        zzb.zzb(parcel, 5, adRequestParcel.zzsD, false);
        zzb.zza(parcel, 6, adRequestParcel.zzsE);
        zzb.zzc(parcel, 7, adRequestParcel.zzsF);
        zzb.zza(parcel, 8, adRequestParcel.zzsG);
        zzb.zza(parcel, 9, adRequestParcel.zzsH, false);
        zzb.zza(parcel, 10, adRequestParcel.zzsI, i, false);
        zzb.zza(parcel, 11, adRequestParcel.zzsJ, i, false);
        zzb.zza(parcel, 12, adRequestParcel.zzsK, false);
        zzb.zza(parcel, 13, adRequestParcel.zzsL, false);
        zzb.zza(parcel, 14, adRequestParcel.zzsM, false);
        zzb.zzb(parcel, 15, adRequestParcel.zzsN, false);
        zzb.zza(parcel, 17, adRequestParcel.zzsP, false);
        zzb.zza(parcel, 16, adRequestParcel.zzsO, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzb(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzk(x0);
    }

    public AdRequestParcel zzb(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        List list = null;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        String str = null;
        SearchAdRequestParcel searchAdRequestParcel = null;
        Location location = null;
        String str2 = null;
        Bundle bundle2 = null;
        Bundle bundle3 = null;
        List list2 = null;
        String str3 = null;
        String str4 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 3:
                    bundle = zza.zzr(parcel, zzao);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 5:
                    list = zza.zzD(parcel, zzao);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 7:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 9:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 10:
                    searchAdRequestParcel = (SearchAdRequestParcel) zza.zza(parcel, zzao, SearchAdRequestParcel.CREATOR);
                    break;
                case 11:
                    location = (Location) zza.zza(parcel, zzao, Location.CREATOR);
                    break;
                case 12:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 13:
                    bundle2 = zza.zzr(parcel, zzao);
                    break;
                case 14:
                    bundle3 = zza.zzr(parcel, zzao);
                    break;
                case 15:
                    list2 = zza.zzD(parcel, zzao);
                    break;
                case 16:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 17:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new AdRequestParcel(i, j, bundle, i2, list, z, i3, z2, str, searchAdRequestParcel, location, str2, bundle2, bundle3, list2, str3, str4);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public AdRequestParcel[] zzk(int i) {
        return new AdRequestParcel[i];
    }
}
