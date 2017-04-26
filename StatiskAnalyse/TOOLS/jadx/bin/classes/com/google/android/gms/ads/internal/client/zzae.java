package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzae implements Creator<SearchAdRequestParcel> {
    static void zza(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, searchAdRequestParcel.versionCode);
        zzb.zzc(parcel, 2, searchAdRequestParcel.zztP);
        zzb.zzc(parcel, 3, searchAdRequestParcel.backgroundColor);
        zzb.zzc(parcel, 4, searchAdRequestParcel.zztQ);
        zzb.zzc(parcel, 5, searchAdRequestParcel.zztR);
        zzb.zzc(parcel, 6, searchAdRequestParcel.zztS);
        zzb.zzc(parcel, 7, searchAdRequestParcel.zztT);
        zzb.zzc(parcel, 8, searchAdRequestParcel.zztU);
        zzb.zzc(parcel, 9, searchAdRequestParcel.zztV);
        zzb.zza(parcel, 10, searchAdRequestParcel.zztW, false);
        zzb.zzc(parcel, 11, searchAdRequestParcel.zztX);
        zzb.zza(parcel, 12, searchAdRequestParcel.zztY, false);
        zzb.zzc(parcel, 13, searchAdRequestParcel.zztZ);
        zzb.zzc(parcel, 14, searchAdRequestParcel.zzua);
        zzb.zza(parcel, 15, searchAdRequestParcel.zzub, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzd(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzn(x0);
    }

    public SearchAdRequestParcel zzd(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 4:
                    i4 = zza.zzg(parcel, zzao);
                    break;
                case 5:
                    i5 = zza.zzg(parcel, zzao);
                    break;
                case 6:
                    i6 = zza.zzg(parcel, zzao);
                    break;
                case 7:
                    i7 = zza.zzg(parcel, zzao);
                    break;
                case 8:
                    i8 = zza.zzg(parcel, zzao);
                    break;
                case 9:
                    i9 = zza.zzg(parcel, zzao);
                    break;
                case 10:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 11:
                    i10 = zza.zzg(parcel, zzao);
                    break;
                case 12:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 13:
                    i11 = zza.zzg(parcel, zzao);
                    break;
                case 14:
                    i12 = zza.zzg(parcel, zzao);
                    break;
                case 15:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }

    public SearchAdRequestParcel[] zzn(int i) {
        return new SearchAdRequestParcel[i];
    }
}
