package com.alipay.tscenter.biz.rpc.vkeydfp.result;

import java.io.Serializable;

public class DeviceDataReportResult extends BaseResult implements Serializable {
    public String apdid;
    public String appListVer;
    public String bugTrackSwitch;
    public String currentTime;
    public String token;
    public String version;
    public String vkeySwitch;

    public DeviceDataReportResult() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67107250 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult.<init>():void");
    }
}
