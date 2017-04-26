package com.BeeFramework.fragment;

import android.app.Fragment;
import com.BeeFramework.model.BusinessResponse;
import com.external.androidquery.callback.AjaxStatus;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseFragment extends Fragment implements BusinessResponse {
    public BaseFragment() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67108587 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.BeeFramework.fragment.BaseFragment.<init>():void");
    }

    public void OnMessageResponse(String url, JSONObject jo, AjaxStatus status) throws JSONException {
    }
}
