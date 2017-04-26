package com.baidu.location.b;

import android.util.Log;
import internal.org.apache.http.entity.mime.MIME;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

class t extends Thread {
    final /* synthetic */ m a;

    t(m mVar) {
        this.a = mVar;
    }

    public void run() {
        int i;
        HttpEntity httpEntity;
        boolean z;
        Object obj;
        this.a.c5 = k.Z();
        this.a.au();
        int i2 = this.a.dg;
        this.a.am();
        if (m.c8 == g.byte) {
            i = i2;
            httpEntity = null;
            z = true;
        } else {
            i = i2;
            httpEntity = null;
            z = false;
        }
        while (i > 0) {
            HttpPost httpPost;
            try {
                httpPost = new HttpPost(this.a.c5);
                try {
                    httpEntity = new ByteArrayEntity(this.a.db);
                    httpPost.setHeader(MIME.CONTENT_TYPE, "application/octet-stream");
                    httpPost.setHeader("Accept-Charset", "UTF-8;");
                    httpPost.setEntity(httpEntity);
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.Q));
                    defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.Q));
                    HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                    if (z) {
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(m.dd, m.df, "http"));
                    }
                    z = !z;
                    HttpResponse execute = defaultHttpClient.execute(httpPost);
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        this.a.c6 = execute.getEntity();
                        this.a.int(true);
                        break;
                    }
                    httpPost.abort();
                    i--;
                    obj = httpPost;
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                Object obj2 = httpEntity;
                httpPost.abort();
                Log.d(g.m, "NetworkCommunicationException!");
                i--;
                obj = httpPost;
            }
        }
        if (i <= 0) {
            m.de++;
            this.a.c6 = null;
            this.a.int(false);
        } else {
            m.de = 0;
        }
        this.a.db = null;
        this.a.c9 = false;
    }
}
