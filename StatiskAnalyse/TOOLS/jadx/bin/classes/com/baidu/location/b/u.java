package com.baidu.location.b;

import android.util.Log;
import com.bumptech.glide.load.Key;
import internal.org.apache.http.entity.mime.MIME;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

class u extends Thread {
    final /* synthetic */ m a;

    u(m mVar) {
        this.a = mVar;
    }

    public void run() {
        int i;
        HttpEntity httpEntity;
        boolean z;
        this.a.c5 = k.ab();
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
            Object obj;
            try {
                httpPost = new HttpPost(this.a.c5);
                try {
                    httpEntity = new StringEntity(this.a.da, Key.STRING_CHARSET_NAME);
                    httpPost.setHeader(MIME.CONTENT_TYPE, "text/xml");
                    httpPost.setEntity(httpEntity);
                    HttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, g.Q);
                    HttpConnectionParams.setSoTimeout(basicHttpParams, g.Q);
                    HttpClient httpClient = m.if(basicHttpParams);
                    HttpProtocolParams.setUseExpectContinue(httpClient.getParams(), false);
                    if (z) {
                        httpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(m.dd, m.df, "http"));
                    }
                    z = !z;
                    HttpResponse execute = httpClient.execute(httpPost);
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
        this.a.c9 = false;
    }
}
