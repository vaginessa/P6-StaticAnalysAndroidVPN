package com.baidu.location.b;

class r extends Thread {
    final /* synthetic */ m a;

    r(m mVar) {
        this.a = mVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r11 = this;
        r6 = 0;
        r3 = 1;
        r4 = 0;
        r0 = r11.a;
        r1 = com.baidu.location.b.k.Z();
        r0.c5 = r1;
        r0 = r11.a;
        r0.am();
        r0 = r11.a;
        r0.au();
        r0 = r11.a;
        r0 = r0.dg;
        r1 = com.baidu.location.b.m.c8;
        r2 = com.baidu.location.b.g.byte;
        if (r1 != r2) goto L_0x014b;
    L_0x001f:
        r5 = r0;
        r2 = r6;
        r0 = r3;
    L_0x0022:
        if (r5 <= 0) goto L_0x0117;
    L_0x0024:
        r1 = new org.apache.http.client.methods.HttpPost;	 Catch:{ Exception -> 0x0144, Error -> 0x0141 }
        r7 = r11.a;	 Catch:{ Exception -> 0x0144, Error -> 0x0141 }
        r7 = r7.c5;	 Catch:{ Exception -> 0x0144, Error -> 0x0141 }
        r1.<init>(r7);	 Catch:{ Exception -> 0x0144, Error -> 0x0141 }
        r2 = new org.apache.http.client.entity.UrlEncodedFormEntity;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r11.a;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r7.c7;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = "utf-8";
        r2.<init>(r7, r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = "Content-Type";
        r8 = "application/x-www-form-urlencoded; charset=utf-8";
        r1.setHeader(r7, r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = "Accept-Charset";
        r8 = "UTF-8;";
        r1.setHeader(r7, r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = "Host";
        r8 = "loc.map.baidu.com";
        r1.setHeader(r7, r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = "Accept-Encoding";
        r8 = "gzip";
        r1.addHeader(r7, r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r1.setEntity(r2);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r2 = new org.apache.http.impl.client.DefaultHttpClient;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r2.<init>();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r2.getParams();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = "http.connection.timeout";
        r9 = com.baidu.location.b.g.Q;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7.setParameter(r8, r9);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r2.getParams();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = "http.socket.timeout";
        r9 = com.baidu.location.b.g.Q;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r9 = java.lang.Integer.valueOf(r9);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7.setParameter(r8, r9);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r2.getParams();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = 0;
        org.apache.http.params.HttpProtocolParams.setUseExpectContinue(r7, r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r7 = new org.apache.http.HttpHost;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = com.baidu.location.b.m.dd;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r9 = com.baidu.location.b.m.df;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r10 = "http";
        r7.<init>(r8, r9, r10);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = r2.getParams();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r9 = "http.route.default-proxy";
        r8.setParameter(r9, r7);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
    L_0x009c:
        if (r0 != 0) goto L_0x00f6;
    L_0x009e:
        r0 = r3;
    L_0x009f:
        r2 = r2.execute(r1);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r2.getStatusLine();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r7.getStatusCode();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r7 != r8) goto L_0x012e;
    L_0x00af:
        r7 = r2.getEntity();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = r7.getContent();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = "Content-Encoding";
        r2 = r2.getFirstHeader(r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        if (r2 == 0) goto L_0x0149;
    L_0x00bf:
        r2 = r2.getValue();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = "gzip";
        r2 = r2.equalsIgnoreCase(r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        if (r2 == 0) goto L_0x0149;
    L_0x00cb:
        r2 = new java.util.zip.GZIPInputStream;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8 = new java.io.BufferedInputStream;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r8.<init>(r7);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r2.<init>(r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
    L_0x00d5:
        r7 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7.<init>();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
    L_0x00da:
        r8 = r2.read();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r9 = -1;
        if (r8 == r9) goto L_0x00f8;
    L_0x00e1:
        r7.write(r8);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        goto L_0x00da;
    L_0x00e5:
        r2 = move-exception;
    L_0x00e6:
        r1.abort();
        r2 = com.baidu.location.b.g.m;
        r7 = "NetworkCommunicationException!";
        android.util.Log.d(r2, r7);
    L_0x00f0:
        r2 = r5 + -1;
        r5 = r2;
        r2 = r1;
        goto L_0x0022;
    L_0x00f6:
        r0 = r4;
        goto L_0x009f;
    L_0x00f8:
        r8 = r7.toString();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        if (r2 == 0) goto L_0x0101;
    L_0x00fe:
        r2.close();	 Catch:{ Exception -> 0x0147, Error -> 0x0132 }
    L_0x0101:
        if (r7 == 0) goto L_0x0106;
    L_0x0103:
        r7.close();	 Catch:{ Exception -> 0x0147, Error -> 0x0132 }
    L_0x0106:
        r2 = r11.a;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = new org.apache.http.entity.StringEntity;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r9 = "UTF-8";
        r7.<init>(r8, r9);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r2.c6 = r7;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r2 = r11.a;	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        r7 = 1;
        r2.int(r7);	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
    L_0x0117:
        if (r5 > 0) goto L_0x013e;
    L_0x0119:
        r0 = com.baidu.location.b.m.de;
        r0 = r0 + 1;
        com.baidu.location.b.m.de = r0;
        r0 = r11.a;
        r0.c6 = r6;
        r0 = r11.a;
        r0.int(r4);
    L_0x0128:
        r0 = r11.a;
        r0.c9 = r4;
        return;
    L_0x012e:
        r1.abort();	 Catch:{ Exception -> 0x00e5, Error -> 0x0132 }
        goto L_0x00f0;
    L_0x0132:
        r2 = move-exception;
    L_0x0133:
        r1.abort();
        r2 = com.baidu.location.b.g.m;
        r7 = "NetworkCommunicationException!";
        android.util.Log.d(r2, r7);
        goto L_0x00f0;
    L_0x013e:
        com.baidu.location.b.m.de = r4;
        goto L_0x0128;
    L_0x0141:
        r1 = move-exception;
        r1 = r2;
        goto L_0x0133;
    L_0x0144:
        r1 = move-exception;
        r1 = r2;
        goto L_0x00e6;
    L_0x0147:
        r2 = move-exception;
        goto L_0x0106;
    L_0x0149:
        r2 = r7;
        goto L_0x00d5;
    L_0x014b:
        r5 = r0;
        r2 = r6;
        r0 = r4;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.b.r.run():void");
    }
}
