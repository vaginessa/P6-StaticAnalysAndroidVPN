package com.baidu.platform.comjni.tools;

public class JNITools {
    public static native boolean CoordinateEncryptEx(float f, float f2, String str, Object obj);

    public static native void GetDistanceByMC(Object obj);

    public static native String GetToken();

    public static native boolean TransGeoStr2ComplexPt(Object obj);

    public static native boolean TransGeoStr2Pt(Object obj);

    public static native void TransNodeStr2Pt(Object obj);
}
