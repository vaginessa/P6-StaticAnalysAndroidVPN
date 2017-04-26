package com.easemob.media;

import android.content.Context;

public class AVNative {
    static final String TAG = AVNative.class.getSimpleName();

    static {
        System.loadLibrary("easemob_jni");
    }

    public AVNative() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099467 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.media.AVNative.<init>():void");
    }

    public int GetAudioInputLevel(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099466 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.media.AVNative.GetAudioInputLevel(java.lang.String):int");
    }

    public int GetAudioOutputLevel(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099465 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.media.AVNative.GetAudioOutputLevel(java.lang.String):int");
    }

    public native int nativeAVStartRecord(String str);

    public native String nativeAVStopRecord();

    public native int nativeGetLocalBitrate();

    public native int nativeGetRemoteBitrate();

    public native int nativeGetVideoFramerate();

    public native int nativeGetVideoHeight();

    public native int nativeGetVideoLostcnt();

    public native int nativeGetVideoTimedelay();

    public native int nativeGetVideoWidth();

    public native void nativeInit(EMVideoCallBridge eMVideoCallBridge);

    public native void nativePause();

    public native int nativeProcessPcm(byte[] bArr, int i, String str);

    public native int nativeProcessYUV(int i, int i2, byte[] bArr);

    public native void nativeQuit();

    public native void nativeResume();

    public native int nativeSetRenderFlag(boolean z);

    public native int nativeSetVideoEncodeFlag(boolean z);

    public native int nativeStartVideo(IGxStatusCallback iGxStatusCallback, int i, int i2, String str, String str2, int i3, String str3, String str4, int i4, int i5, int i6, boolean z, boolean z2);

    public native void nativeStopVideo();

    public native int nativeTakePicture(String str);

    native int nativeVoeClient_FullDuplexSpeech(String str);

    native int nativeVoeClient_GetAudioLevel(String str);

    native int nativeVoeClient_GetAudioOutputLevel(String str);

    public native int nativeVoeClient_GetLocalBitrate(String str);

    public native int nativeVoeClient_GetLostcnt(String str);

    public native int nativeVoeClient_GetRemoteBitrate(String str);

    public native int nativeVoeClient_GetTimeDelay(String str);

    native int nativeVoeClient_Register(IGxStatusCallback iGxStatusCallback, Context context, int i, String str, int i2, String str2, String str3, int i3, String str4, String str5, boolean z, int i4);

    native int nativeVoeClient_Release(String str);

    native int nativeVoeClient_StartRecodeMic(IGxStatusCallback iGxStatusCallback, Context context, String str, String str2);

    native int nativeVoeClient_Stop(String str);

    native int nativeVoeClient_StopRecodeMic(String str);

    public native void onNativeAccel(float f, float f2, float f3);

    public native void onNativeKeyDown(int i);

    public native void onNativeKeyUp(int i);

    public native void onNativeResize(int i, int i2, int i3);

    public native void onNativeTouch(int i, int i2, int i3, float f, float f2, float f3);

    public int register(com.easemob.media.IGxStatusCallback r15, android.content.Context r16, int r17, java.lang.String r18, int r19, java.lang.String r20, java.lang.String r21, int r22, java.lang.String r23, java.lang.String r24, boolean r25, int r26) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099464 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r14 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.media.AVNative.register(com.easemob.media.IGxStatusCallback, android.content.Context, int, java.lang.String, int, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, boolean, int):int");
    }

    public int setFullDuplexSpeech(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099463 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.media.AVNative.setFullDuplexSpeech(java.lang.String):int");
    }

    public int stop(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099462 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.media.AVNative.stop(java.lang.String):int");
    }

    public int unregister(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099461 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r3 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.media.AVNative.unregister(java.lang.String):int");
    }
}
