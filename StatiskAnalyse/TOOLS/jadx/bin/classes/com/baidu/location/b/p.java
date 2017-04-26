package com.baidu.location.b;

import android.util.Log;
import internal.org.apache.http.entity.mime.MIME;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

class p extends Thread {
    final /* synthetic */ m a;

    p(m mVar) {
        this.a = mVar;
    }

    public void run() {
        int i;
        boolean z;
        this.a.c5 = k.Z();
        this.a.au();
        int i2 = this.a.dg;
        this.a.am();
        if (m.c8 == g.byte) {
            i = i2;
            z = true;
        } else {
            i = i2;
            z = false;
        }
        while (i > 0) {
            try {
                Object httpGet = new HttpGet(this.a.c5);
                httpGet.setHeader(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
                httpGet.setHeader("Accept-Charset", "UTF-8;");
                HttpClient defaultHttpClient = new DefaultHttpClient();
                defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.Q));
                defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.Q));
                HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                if (z) {
                    defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(m.dd, m.df, "http"));
                }
                z = !z;
                HttpResponse execute = defaultHttpClient.execute(httpGet);
                if (execute.getStatusLine().getStatusCode() == 200) {
                    this.a.c6 = execute.getEntity();
                    this.a.int(true);
                    break;
                }
                httpGet.abort();
                i--;
            } catch (Exception e) {
                Log.d(g.m, "NetworkCommunicationException!");
            }
        }
        if (i <= 0) {
            m.de++;
            this.a.c6 = null;
            this.a.int(false);
        } else {
            m.de = 0;
        }
        this.a.c9 = false;
    }
}
