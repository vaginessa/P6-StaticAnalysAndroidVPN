package com.baidu.location.b;

import android.util.Log;
import internal.org.apache.http.entity.mime.MIME;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

class q extends Thread {
    final /* synthetic */ m a;

    q(m mVar) {
        this.a = mVar;
    }

    public void run() {
        int i;
        HttpEntity httpEntity;
        boolean z;
        HttpPost httpPost;
        Object obj;
        Object obj2;
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
            try {
                httpPost = new HttpPost(this.a.c5);
                try {
                    httpEntity = new UrlEncodedFormEntity(this.a.c7, "utf-8");
                    httpPost.setHeader(MIME.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=utf-8");
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
                } catch (Error e2) {
                    httpPost.abort();
                    Log.d(g.m, "NetworkCommunicationException!");
                    i--;
                    obj = httpPost;
                }
            } catch (Exception e3) {
                obj2 = httpEntity;
                httpPost.abort();
                Log.d(g.m, "NetworkCommunicationException!");
                i--;
                obj = httpPost;
            } catch (Error e4) {
                obj2 = httpEntity;
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
        this.a.c9 = false;
    }
}
