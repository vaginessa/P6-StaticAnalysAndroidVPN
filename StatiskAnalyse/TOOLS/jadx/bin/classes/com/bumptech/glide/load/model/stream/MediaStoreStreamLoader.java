package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class MediaStoreStreamLoader implements ModelLoader<Uri, InputStream> {
    private final Context context;
    private final ModelLoader<Uri, InputStream> uriLoader;

    public MediaStoreStreamLoader(android.content.Context r1, com.bumptech.glide.load.model.ModelLoader<android.net.Uri, java.io.InputStream> r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103750 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.stream.MediaStoreStreamLoader.<init>(android.content.Context, com.bumptech.glide.load.model.ModelLoader):void");
    }

    public com.bumptech.glide.load.data.DataFetcher<java.io.InputStream> getResourceFetcher(android.net.Uri r7, int r8, int r9) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67103749 length=8972300
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
        r6 = this;
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.model.stream.MediaStoreStreamLoader.getResourceFetcher(android.net.Uri, int, int):com.bumptech.glide.load.data.DataFetcher<java.io.InputStream>");
    }
}
