package com.easemob.cloud;

import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientManager {
    private static final int MAX_RETRIES_TIMES_ON_CONNECTION_REFUSED = 20;
    public static String Method_DELETE = "DELETE";
    public static String Method_GET = Constants.HTTP_GET;
    public static String Method_POST = Constants.HTTP_POST;
    public static String Method_PUT = "PUT";
    private static final String TAG = "HttpClientManager";
    private static volatile boolean isRetring = false;
    private static final int retriveInterval = 120000;
    private static volatile long retrivedTokenTime = 0;

    public HttpClientManager() {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100807 length=8972300
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
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.<init>():void");
    }

    static java.util.Map<java.lang.String, java.lang.String> addDomainToHeaders(java.util.Map<java.lang.String, java.lang.String> r3) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100806 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.addDomainToHeaders(java.util.Map):java.util.Map<java.lang.String, java.lang.String>");
    }

    static void checkAndProcessSSL(String str, DefaultHttpClient defaultHttpClient) throws NoSuchAlgorithmException, CertificateException, IOException, KeyStoreException, KeyManagementException, UnrecoverableKeyException {
    }

    public static org.apache.http.HttpResponse getHttpResponse(java.lang.String r1, java.util.Map<java.lang.String, java.lang.String> r2, java.lang.String r3, java.lang.String r4) throws java.security.KeyStoreException, java.security.KeyManagementException, java.security.UnrecoverableKeyException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100805 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.getHttpResponse(java.lang.String, java.util.Map, java.lang.String, java.lang.String):org.apache.http.HttpResponse");
    }

    static java.lang.String getNewHost(java.lang.String r4, com.easemob.chat.core.j.c r5) {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100804 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.getNewHost(java.lang.String, com.easemob.chat.core.j$c):java.lang.String");
    }

    public static org.apache.http.HttpResponse httpExecute(java.lang.String r5, java.util.Map<java.lang.String, java.lang.String> r6, java.lang.String r7, java.lang.String r8) throws org.apache.http.client.ClientProtocolException, java.io.IOException, java.security.KeyStoreException, java.security.KeyManagementException, java.security.UnrecoverableKeyException, java.security.NoSuchAlgorithmException, java.security.cert.CertificateException {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100803 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.httpExecute(java.lang.String, java.util.Map, java.lang.String, java.lang.String):org.apache.http.HttpResponse");
    }

    public static java.lang.String sendHttpRequest(java.lang.String r1, java.util.Map<java.lang.String, java.lang.String> r2, java.lang.String r3, java.lang.String r4) throws com.easemob.exceptions.EaseMobException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpClientManager.sendHttpRequest(java.lang.String, java.util.Map, java.lang.String, java.lang.String):java.lang.String
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.sendHttpRequest(java.lang.String, java.util.Map, java.lang.String, java.lang.String):java.lang.String");
    }

    private static java.lang.String sendHttpRequestWithCountDown(java.lang.String r1, java.util.Map<java.lang.String, java.lang.String> r2, java.lang.String r3, java.lang.String r4) throws com.easemob.exceptions.EaseMobException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpClientManager.sendHttpRequestWithCountDown(java.lang.String, java.util.Map, java.lang.String, java.lang.String):java.lang.String
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.sendHttpRequestWithCountDown(java.lang.String, java.util.Map, java.lang.String, java.lang.String):java.lang.String");
    }

    static android.util.Pair<java.lang.Integer, java.lang.String> sendHttpRequestWithRetryToken(java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7, java.lang.String r8, java.lang.String r9) throws com.easemob.exceptions.EaseMobException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.IllegalArgumentException: position=67100800 length=8972300
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
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.sendHttpRequestWithRetryToken(java.lang.String, java.util.Map, java.lang.String, java.lang.String):android.util.Pair<java.lang.Integer, java.lang.String>");
    }

    public static android.util.Pair<java.lang.Integer, java.lang.String> sendRequest(java.lang.String r1, java.util.Map<java.lang.String, java.lang.String> r2, java.lang.String r3, java.lang.String r4) throws java.io.IOException, com.easemob.exceptions.EaseMobException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpClientManager.sendRequest(java.lang.String, java.util.Map, java.lang.String, java.lang.String):android.util.Pair<java.lang.Integer, java.lang.String>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.sendRequest(java.lang.String, java.util.Map, java.lang.String, java.lang.String):android.util.Pair<java.lang.Integer, java.lang.String>");
    }

    private static org.apache.http.HttpResponse sendRequestWithCountDown(java.lang.String r1, java.util.Map<java.lang.String, java.lang.String> r2, java.lang.String r3, java.lang.String r4) throws com.easemob.exceptions.EaseMobException, java.io.IOException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpClientManager.sendRequestWithCountDown(java.lang.String, java.util.Map, java.lang.String, java.lang.String):org.apache.http.HttpResponse
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.sendRequestWithCountDown(java.lang.String, java.util.Map, java.lang.String, java.lang.String):org.apache.http.HttpResponse");
    }

    public static android.util.Pair<java.lang.Integer, java.lang.String> sendRequestWithToken(java.lang.String r1, java.util.Map<java.lang.String, java.lang.String> r2, java.lang.String r3, java.lang.String r4) throws com.easemob.exceptions.EaseMobException {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.easemob.cloud.HttpClientManager.sendRequestWithToken(java.lang.String, java.util.Map, java.lang.String, java.lang.String):android.util.Pair<java.lang.Integer, java.lang.String>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:116)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:249)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
Caused by: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.easemob.cloud.HttpClientManager.sendRequestWithToken(java.lang.String, java.util.Map, java.lang.String, java.lang.String):android.util.Pair<java.lang.Integer, java.lang.String>");
    }
}
