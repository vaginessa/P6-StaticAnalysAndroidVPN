package com.external.HorizontalVariableListView.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;

public abstract class HorizontalListView extends AdapterView<ListAdapter> {

    public interface OnItemDragListener {
        boolean onItemStartDrag(AdapterView<?> adapterView, View view, int i, long j);
    }

    public interface OnLayoutChangeListener {
        void onLayoutChange(boolean z, int i, int i2, int i3, int i4);
    }

    public interface OnScrollFinishedListener {
        void onScrollFinished(int i);
    }

    public HorizontalListView(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099184 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.external.HorizontalVariableListView.widget.HorizontalListView.<init>(android.content.Context):void");
    }

    public HorizontalListView(android.content.Context r1, android.util.AttributeSet r2) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099183 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.external.HorizontalVariableListView.widget.HorizontalListView.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public HorizontalListView(android.content.Context r1, android.util.AttributeSet r2, int r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67099182 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.external.HorizontalVariableListView.widget.HorizontalListView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public abstract int getScreenPositionForView(View view);
}
