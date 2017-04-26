package com.baidu.location.b;

import android.util.Log;
import internal.org.apache.http.entity.mime.MIME;
import java.io.File;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpProtocolParams;

class s extends Thread {
    final /* synthetic */ m a;

    s(m mVar) {
        this.a = mVar;
    }

    public void run() {
        this.a.c5 = k.Z();
        this.a.au();
        int i = this.a.dg;
        this.a.am();
        int i2 = i;
        HttpEntity httpEntity = null;
        while (i2 > 0) {
            HttpPost httpPost;
            Object obj;
            try {
                httpPost = new HttpPost(this.a.c5);
                try {
                    httpEntity = new FileEntity(new File(this.a.dc), "binary/octet-stream");
                    httpPost.setHeader(MIME.CONTENT_TYPE, "application/octet-stream");
                    httpPost.setHeader("Accept-Charset", "UTF-8;");
                    httpPost.setEntity(httpEntity);
                    HttpClient defaultHttpClient = new DefaultHttpClient();
                    defaultHttpClient.getParams().setParameter("http.connection.timeout", Integer.valueOf(g.Q));
                    defaultHttpClient.getParams().setParameter("http.socket.timeout", Integer.valueOf(g.d));
                    HttpProtocolParams.setUseExpectContinue(defaultHttpClient.getParams(), false);
                    if ((m.c8 == g.byte || m.c8 == g.w) && (this.a.dg - i2) % 2 == 0) {
                        defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(m.dd, m.df, "http"));
                    }
                    HttpResponse execute = defaultHttpClient.execute(httpPost);
                    if (execute.getStatusLine().getStatusCode() == 200) {
                        this.a.c6 = execute.getEntity();
                        this.a.int(true);
                        break;
                    }
                    httpPost.abort();
                    i2--;
                    obj = httpPost;
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                Object obj2 = httpEntity;
                httpPost.abort();
                Log.d(g.m, "NetworkCommunicationException!");
                i2--;
                obj = httpPost;
            }
        }
        if (i2 <= 0) {
            m.de++;
            this.a.c6 = null;
            this.a.int(false);
        } else {
            m.de = 0;
        }
        this.a.c9 = false;
    }
}
