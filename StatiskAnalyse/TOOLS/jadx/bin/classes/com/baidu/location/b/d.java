package com.baidu.location.b;

import com.baidu.location.h.c;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import net.java.sip.communicator.impl.protocol.jabber.extensions.jingle.CandidatePacketExtension;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class d implements f {
    private static d bw = null;
    private String bA = "loc.map.baidu.com";
    private String br = null;
    private long bs = 0;
    private a bt = new a(this);
    private long bu = 0;
    private String bv = null;
    private int bx = 0;
    private long by = 0;
    private String bz = "dns.map.baidu.com";

    private class a extends m {
        final /* synthetic */ d b;
        private boolean c = false;

        public a(d dVar) {
            this.b = dVar;
        }

        void a() {
            if (!this.c) {
                this.c = true;
                as();
            }
        }

        public void au() {
            if (this.b.bz.equals("dns.map.baidu.com") || System.currentTimeMillis() - this.b.bs > 720000) {
                switch (c.a().cS()) {
                    case 1:
                        this.b.bz = "111.13.100.247";
                        break;
                    case 2:
                        this.b.bz = "111.206.37.190";
                        break;
                    case 3:
                        this.b.bz = "180.97.33.196";
                        break;
                    default:
                        this.b.bz = "dns.map.baidu.com";
                        break;
                }
            }
            this.c5 = "http://" + this.b.bz + ":80/remotedns?pid=lbs-geolocation";
        }

        void b() {
            if (System.currentTimeMillis() - this.b.by < 1200000) {
                this.b.Q();
                return;
            }
            String str;
            InetAddress byName;
            try {
                str = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke(null, new Object[]{"net.dns1"});
            } catch (Exception e) {
                str = null;
            }
            try {
                byName = InetAddress.getByName("loc.map.baidu.com");
            } catch (Exception e2) {
                byName = null;
            }
            if (byName != null && byName.getHostAddress() != null && str != null && !"".equals(str)) {
                this.b.bv = str;
                this.b.br = byName.getHostAddress();
                this.b.by = System.currentTimeMillis();
                this.b.Q();
            }
        }

        public void int(boolean z) {
            String str = null;
            if (z && this.c6 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(EntityUtils.toString(this.c6, "utf-8"));
                    if (jSONObject.getInt("errno") == 0 && jSONObject.has(AlixDefine.data)) {
                        JSONArray jSONArray = jSONObject.getJSONArray(AlixDefine.data);
                        JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                        JSONObject jSONObject3 = jSONArray.getJSONObject(1);
                        String string = jSONObject2.has("loc.map.baidu.com") ? jSONObject2.getJSONArray("loc.map.baidu.com").getJSONObject(0).getString(CandidatePacketExtension.IP_ATTR_NAME) : null;
                        if (jSONObject3.has("dns.map.baidu.com")) {
                            str = jSONObject3.getJSONArray("dns.map.baidu.com").getJSONObject(0).getString(CandidatePacketExtension.IP_ATTR_NAME);
                        }
                        if (!(string == null || str == null)) {
                            this.b.bz = str;
                            this.b.bA = string;
                        }
                        if (jSONObject.has("switch")) {
                            this.b.bx = jSONObject.getInt("switch");
                        }
                        this.b.bs = System.currentTimeMillis();
                        b();
                    }
                } catch (Exception e) {
                }
            }
            this.c = false;
        }
    }

    private d() {
        T();
    }

    private void Q() {
        try {
            RandomAccessFile randomAccessFile;
            File file = new File(e.int + "/grtcf.dat");
            if (!file.exists()) {
                File file2 = new File(e.int);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                if (file.createNewFile()) {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(2);
                    randomAccessFile.writeInt(0);
                    randomAccessFile.seek(8);
                    byte[] bytes = "1980_01_01:0".getBytes();
                    randomAccessFile.writeInt(bytes.length);
                    randomAccessFile.write(bytes);
                    randomAccessFile.seek(200);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.seek(800);
                    randomAccessFile.writeBoolean(false);
                    randomAccessFile.close();
                } else {
                    return;
                }
            }
            randomAccessFile = new RandomAccessFile(file, "rw");
            randomAccessFile.seek(800);
            String R = R();
            if (R != null) {
                randomAccessFile.writeBoolean(true);
                byte[] bytes2 = R.getBytes();
                randomAccessFile.writeInt(bytes2.length);
                randomAccessFile.write(bytes2);
            } else {
                randomAccessFile.writeBoolean(false);
            }
            randomAccessFile.close();
        } catch (Exception e) {
        }
    }

    private String R() {
        String str = null;
        try {
            JSONObject jSONObject = new JSONObject();
            if (this.bv != null) {
                jSONObject.put("dnsServer", this.bv);
            }
            if (this.br != null) {
                jSONObject.put("locServer", this.br);
            }
            if (this.bA != null) {
                jSONObject.put("address", this.bA);
            }
            if (this.bz != null) {
                jSONObject.put("dnsServerIp", this.bz);
            }
            jSONObject.put("DnsProxyTime", this.bs);
            jSONObject.put("DnsExtraTime", this.bu);
            jSONObject.put("DnsExtraUpdateTime", this.by);
            jSONObject.put("enable", this.bx);
            str = jSONObject.toString();
        } catch (Exception e) {
        }
        return str;
    }

    private void T() {
        try {
            File file = new File(e.int + "/grtcf.dat");
            if (file.exists()) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.seek(800);
                if (randomAccessFile.readBoolean()) {
                    int readInt = randomAccessFile.readInt();
                    byte[] bArr = new byte[readInt];
                    randomAccessFile.read(bArr, 0, readInt);
                    case(new String(bArr));
                }
                randomAccessFile.close();
            }
        } catch (Exception e) {
        }
    }

    public static d U() {
        if (bw == null) {
            bw = new d();
        }
        return bw;
    }

    private void case(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("dnsServer")) {
                this.bv = jSONObject.getString("dnsServer");
            }
            if (jSONObject.has("locServer")) {
                this.br = jSONObject.getString("locServer");
            }
            if (jSONObject.has("address")) {
                this.bA = jSONObject.getString("address");
            }
            if (jSONObject.has("locServer")) {
                this.bz = jSONObject.getString("dnsServerIp");
            }
            if (jSONObject.has("DnsProxyTime")) {
                this.bs = jSONObject.getLong("DnsProxyTime");
            }
            if (jSONObject.has("DnsExtraTime")) {
                this.bu = jSONObject.getLong("DnsExtraTime");
            }
            if (jSONObject.has("DnsExtraUpdateTime")) {
                this.by = jSONObject.getLong("DnsExtraUpdateTime");
            }
            if (jSONObject.has("enable")) {
                this.bx = jSONObject.getInt("enable");
            }
        } catch (Exception e) {
        }
    }

    public String S() {
        String str = "loc.map.baidu.com";
        if (this.bx == 1 && System.currentTimeMillis() - this.bs < 360000) {
            str = this.bA;
        }
        if (System.currentTimeMillis() - this.bs > 300000) {
            this.bt.a();
        }
        return str;
    }

    public String V() {
        if (System.currentTimeMillis() - this.bu <= 3600000 || System.currentTimeMillis() - this.by >= 43200000 || this.bv == null || this.br == null) {
            return null;
        }
        String str = "&dsvr=" + this.bv + "&lsvr=" + this.br;
        this.bu = System.currentTimeMillis();
        Q();
        return str;
    }
}
