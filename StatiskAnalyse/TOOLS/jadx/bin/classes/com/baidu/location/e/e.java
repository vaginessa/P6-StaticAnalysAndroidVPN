package com.baidu.location.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.baidu.location.b.f;
import com.tencent.connect.common.Constants;

public class e implements f {
    private static e gq = null;
    private int gp = -1;
    private String gr = null;
    private a gs = null;
    private boolean gt = false;

    public class a extends BroadcastReceiver {
        final /* synthetic */ e a;

        public a(e eVar) {
            this.a = eVar;
        }

        public void onReceive(Context context, Intent intent) {
            try {
                if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                    this.a.gt = false;
                    int intExtra = intent.getIntExtra("status", 0);
                    int intExtra2 = intent.getIntExtra("plugged", 0);
                    int intExtra3 = intent.getIntExtra("level", -1);
                    int intExtra4 = intent.getIntExtra("scale", -1);
                    if (intExtra3 <= 0 || intExtra4 <= 0) {
                        this.a.gp = -1;
                    } else {
                        this.a.gp = (intExtra3 * 100) / intExtra4;
                    }
                    switch (intExtra) {
                        case 2:
                            this.a.gr = "4";
                            break;
                        case 3:
                        case 4:
                            this.a.gr = "3";
                            break;
                        default:
                            this.a.gr = null;
                            break;
                    }
                    switch (intExtra2) {
                        case 1:
                            this.a.gr = Constants.VIA_SHARE_TYPE_INFO;
                            this.a.gt = true;
                            return;
                        case 2:
                            this.a.gr = "5";
                            this.a.gt = true;
                            return;
                        default:
                            return;
                    }
                }
            } catch (Exception e) {
                this.a.gr = null;
            }
        }
    }

    private e() {
    }

    public static synchronized e bx() {
        e eVar;
        synchronized (e.class) {
            if (gq == null) {
                gq = new e();
            }
            eVar = gq;
        }
        return eVar;
    }

    public void bA() {
        if (this.gs != null) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.gs);
            } catch (Exception e) {
            }
        }
        this.gs = null;
    }

    public boolean bv() {
        return this.gt;
    }

    public String bw() {
        return this.gr;
    }

    public int by() {
        return this.gp;
    }

    public void bz() {
        this.gs = new a(this);
        com.baidu.location.f.getServiceContext().registerReceiver(this.gs, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
}
