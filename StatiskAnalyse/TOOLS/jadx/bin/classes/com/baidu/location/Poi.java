package com.baidu.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Poi implements Parcelable {
    public static final Creator CREATOR = new c();
    private final double a;
    private final String do;
    private final String if;

    public Poi(String str, String str2, double d) {
        this.do = str;
        this.if = str2;
        this.a = d;
    }

    public int describeContents() {
        return 0;
    }

    public String getId() {
        return this.do;
    }

    public String getName() {
        return this.if;
    }

    public double getRank() {
        return this.a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.do);
        parcel.writeString(this.if);
        parcel.writeDouble(this.a);
    }
}
