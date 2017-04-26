package com.baidu.location.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.alipay.sdk.cons.b;
import com.baidu.location.f;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public abstract class m implements f {
    public static int c8 = g.w;
    private static String dd = "10.0.0.172";
    protected static int de = 0;
    private static int df = 80;
    public String c5 = null;
    public HttpEntity c6 = null;
    public List c7 = null;
    private boolean c9 = false;
    public String da = null;
    public byte[] db = null;
    public String dc = null;
    public int dg = 3;

    public static class a extends SSLSocketFactory {
        final SSLContext a = SSLContext.getInstance("TLS");

        public a(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
            super(keyStore);
            v vVar = new v(this);
            this.a.init(null, new TrustManager[]{vVar}, null);
        }

        public Socket createSocket() throws IOException {
            return this.a.getSocketFactory().createSocket();
        }

        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException, UnknownHostException {
            return this.a.getSocketFactory().createSocket(socket, str, i, z);
        }
    }

    private void am() {
        c8 = aq();
    }

    private int aq() {
        Context serviceContext = f.getServiceContext();
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) serviceContext.getSystemService("connectivity");
            if (connectivityManager == null) {
                return g.w;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return g.w;
            }
            if (activeNetworkInfo.getType() != 1) {
                return if(serviceContext, activeNetworkInfo);
            }
            String defaultHost = Proxy.getDefaultHost();
            return (defaultHost == null || defaultHost.length() <= 0) ? g.o : g.p;
        } catch (Exception e) {
            return g.w;
        }
    }

    private static int if(Context context, NetworkInfo networkInfo) {
        String toLowerCase;
        if (!(networkInfo == null || networkInfo.getExtraInfo() == null)) {
            toLowerCase = networkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase != null) {
                if (toLowerCase.startsWith("cmwap") || toLowerCase.startsWith("uniwap") || toLowerCase.startsWith("3gwap")) {
                    toLowerCase = Proxy.getDefaultHost();
                    if (toLowerCase == null || toLowerCase.equals("") || toLowerCase.equals("null")) {
                        toLowerCase = "10.0.0.172";
                    }
                    dd = toLowerCase;
                    return g.byte;
                } else if (toLowerCase.startsWith("ctwap")) {
                    toLowerCase = Proxy.getDefaultHost();
                    if (toLowerCase == null || toLowerCase.equals("") || toLowerCase.equals("null")) {
                        toLowerCase = "10.0.0.200";
                    }
                    dd = toLowerCase;
                    return g.byte;
                } else if (toLowerCase.startsWith("cmnet") || toLowerCase.startsWith("uninet") || toLowerCase.startsWith("ctnet") || toLowerCase.startsWith("3gnet")) {
                    return g.for;
                }
            }
        }
        toLowerCase = Proxy.getDefaultHost();
        if (toLowerCase != null && toLowerCase.length() > 0) {
            if ("10.0.0.172".equals(toLowerCase.trim())) {
                dd = "10.0.0.172";
                return g.byte;
            } else if ("10.0.0.200".equals(toLowerCase.trim())) {
                dd = "10.0.0.200";
                return g.byte;
            }
        }
        return g.for;
    }

    public static HttpClient if(HttpParams httpParams) {
        try {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load(null, null);
            SocketFactory aVar = new a(instance);
            aVar.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(httpParams, Key.STRING_CHARSET_NAME);
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme(b.a, aVar, 443));
            return new DefaultHttpClient(new ThreadSafeClientConnManager(httpParams, schemeRegistry), httpParams);
        } catch (Exception e) {
            return new DefaultHttpClient(httpParams);
        }
    }

    public static boolean int(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager.getActiveNetworkInfo() != null ? connectivityManager.getActiveNetworkInfo().isAvailable() : false;
        } catch (Exception e) {
            return false;
        }
    }

    public void an() {
        new t(this).start();
    }

    public void ao() {
        new r(this).start();
    }

    public void ap() {
        new q(this).start();
    }

    public void as() {
        new p(this).start();
    }

    public void at() {
        new s(this).start();
    }

    public abstract void au();

    public void av() {
        new u(this).start();
    }

    public abstract void int(boolean z);
}
