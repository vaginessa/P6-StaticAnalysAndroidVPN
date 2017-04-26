package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class BitmapPoolAdapter implements BitmapPool {
    public BitmapPoolAdapter() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67104088 length=8972300
	at com.android.dex.Dex.open(Dex.java:188)
	at jadx.core.dex.nodes.DexNode.openSection(DexNode.java:204)
	at jadx.core.dex.nodes.parser.DebugInfoParser.<init>(DebugInfoParser.java:51)
	at jadx.core.dex.visitors.DebugInfoVisitor.visit(DebugInfoVisitor.java:18)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = this;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter.<init>():void");
    }

    public int getMaxSize() {
        return 0;
    }

    public void setSizeMultiplier(float sizeMultiplier) {
    }

    public boolean put(Bitmap bitmap) {
        return false;
    }

    public Bitmap get(int width, int height, Config config) {
        return null;
    }

    public Bitmap getDirty(int width, int height, Config config) {
        return null;
    }

    public void clearMemory() {
    }

    public void trimMemory(int level) {
    }
}
