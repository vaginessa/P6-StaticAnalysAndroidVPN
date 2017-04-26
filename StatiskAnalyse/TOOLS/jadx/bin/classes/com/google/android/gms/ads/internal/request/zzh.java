package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzh implements Creator<AdResponseParcel> {
    static void zza(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int zzaq = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, adResponseParcel.versionCode);
        zzb.zza(parcel, 2, adResponseParcel.zzBF, false);
        zzb.zza(parcel, 3, adResponseParcel.body, false);
        zzb.zzb(parcel, 4, adResponseParcel.zzyY, false);
        zzb.zzc(parcel, 5, adResponseParcel.errorCode);
        zzb.zzb(parcel, 6, adResponseParcel.zzyZ, false);
        zzb.zza(parcel, 7, adResponseParcel.zzEJ);
        zzb.zza(parcel, 8, adResponseParcel.zzEK);
        zzb.zza(parcel, 9, adResponseParcel.zzEL);
        zzb.zzb(parcel, 10, adResponseParcel.zzEM, false);
        zzb.zza(parcel, 11, adResponseParcel.zzzc);
        zzb.zzc(parcel, 12, adResponseParcel.orientation);
        zzb.zza(parcel, 13, adResponseParcel.zzEN, false);
        zzb.zza(parcel, 14, adResponseParcel.zzEO);
        zzb.zza(parcel, 15, adResponseParcel.zzEP, false);
        zzb.zza(parcel, 19, adResponseParcel.zzER, false);
        zzb.zza(parcel, 18, adResponseParcel.zzEQ);
        zzb.zza(parcel, 21, adResponseParcel.zzES, false);
        zzb.zza(parcel, 23, adResponseParcel.zzth);
        zzb.zza(parcel, 22, adResponseParcel.zzET);
        zzb.zza(parcel, 25, adResponseParcel.zzEU);
        zzb.zza(parcel, 24, adResponseParcel.zzEv);
        zzb.zzc(parcel, 27, adResponseParcel.zzEW);
        zzb.zza(parcel, 26, adResponseParcel.zzEV);
        zzb.zza(parcel, 29, adResponseParcel.zzEY, false);
        zzb.zza(parcel, 28, adResponseParcel.zzEX, i, false);
        zzb.zza(parcel, 31, adResponseParcel.zzti);
        zzb.zza(parcel, 30, adResponseParcel.zzEZ, false);
        zzb.zzI(parcel, zzaq);
    }

    public /* synthetic */ Object createFromParcel(Parcel x0) {
        return zzj(x0);
    }

    public /* synthetic */ Object[] newArray(int x0) {
        return zzE(x0);
    }

    public AdResponseParcel[] zzE(int i) {
        return new AdResponseParcel[i];
    }

    public AdResponseParcel zzj(Parcel parcel) {
        int zzap = zza.zzap(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        int i2 = 0;
        List list2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        List list3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        int i4 = 0;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        while (parcel.dataPosition() < zzap) {
            int zzao = zza.zzao(parcel);
            switch (zza.zzbM(zzao)) {
                case 1:
                    i = zza.zzg(parcel, zzao);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzao);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzao);
                    break;
                case 4:
                    list = zza.zzD(parcel, zzao);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzao);
                    break;
                case 6:
                    list2 = zza.zzD(parcel, zzao);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzao);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzao);
                    break;
                case 9:
                    j2 = zza.zzi(parcel, zzao);
                    break;
                case 10:
                    list3 = zza.zzD(parcel, zzao);
                    break;
                case 11:
                    j3 = zza.zzi(parcel, zzao);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzao);
                    break;
                case 13:
                    str3 = zza.zzp(parcel, zzao);
                    break;
                case 14:
                    j4 = zza.zzi(parcel, zzao);
                    break;
                case 15:
                    str4 = zza.zzp(parcel, zzao);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzao);
                    break;
                case 19:
                    str5 = zza.zzp(parcel, zzao);
                    break;
                case 21:
                    str6 = zza.zzp(parcel, zzao);
                    break;
                case 22:
                    z3 = zza.zzc(parcel, zzao);
                    break;
                case 23:
                    z4 = zza.zzc(parcel, zzao);
                    break;
                case 24:
                    z5 = zza.zzc(parcel, zzao);
                    break;
                case 25:
                    z6 = zza.zzc(parcel, zzao);
                    break;
                case 26:
                    z7 = zza.zzc(parcel, zzao);
                    break;
                case 27:
                    i4 = zza.zzg(parcel, zzao);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) zza.zza(parcel, zzao, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    str7 = zza.zzp(parcel, zzao);
                    break;
                case 30:
                    str8 = zza.zzp(parcel, zzao);
                    break;
                case 31:
                    z8 = zza.zzc(parcel, zzao);
                    break;
                default:
                    zza.zzb(parcel, zzao);
                    break;
            }
        }
        if (parcel.dataPosition() == zzap) {
            return new AdResponseParcel(i, str, str2, list, i2, list2, j, z, j2, list3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, i4, largeParcelTeleporter, str7, str8, z8);
        }
        throw new zza.zza("Overread allowed size end=" + zzap, parcel);
    }
}
