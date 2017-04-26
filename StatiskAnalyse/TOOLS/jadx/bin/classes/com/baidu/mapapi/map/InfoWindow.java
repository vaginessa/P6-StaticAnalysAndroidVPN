package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.mapapi.model.LatLng;

public class InfoWindow {
    BitmapDescriptor a;
    View b;
    LatLng c;
    OnInfoWindowClickListener d;
    int e;

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick();
    }

    public InfoWindow(android.view.View r3, com.baidu.mapapi.model.LatLng r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67106755 length=8972300
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
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.InfoWindow.<init>(android.view.View, com.baidu.mapapi.model.LatLng, int):void");
    }

    public InfoWindow(com.baidu.mapapi.map.BitmapDescriptor r3, com.baidu.mapapi.model.LatLng r4, int r5, com.baidu.mapapi.map.InfoWindow.OnInfoWindowClickListener r6) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67106754 length=8972300
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
        r2 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mapapi.map.InfoWindow.<init>(com.baidu.mapapi.map.BitmapDescriptor, com.baidu.mapapi.model.LatLng, int, com.baidu.mapapi.map.InfoWindow$OnInfoWindowClickListener):void");
    }
}
