package com.baidu.location.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Handler;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.c.d;

public class i implements f {
    private static i hv = null;
    private boolean hA = false;
    private boolean hB = false;
    private a hC = null;
    private boolean hw = false;
    private boolean hx = true;
    final Handler hy = new Handler();
    private boolean hz = false;

    private class a extends BroadcastReceiver {
        final /* synthetic */ i a;

        private a(i iVar) {
            this.a = iVar;
        }

        public void onReceive(Context context, Intent intent) {
            if (context != null && this.a.hy != null) {
                this.a.b1();
            }
        }
    }

    private class b implements com.baidu.location.b.b, Runnable {
        final /* synthetic */ i b;

        private b(i iVar) {
            this.b = iVar;
        }

        public void run() {
            if (this.b.hx) {
                if (this.b.hA && e.bx().bv() && d.try().long()) {
                    new v(this).start();
                }
                if (this.b.hA && e.bx().bv()) {
                    o.aY().aW();
                }
                if (this.b.hA && this.b.hx) {
                    this.b.hy.postDelayed(this, (long) k.cy);
                    this.b.hB = true;
                    return;
                }
                this.b.hB = false;
            }
        }
    }

    private i() {
    }

    private void b1() {
        State state;
        State state2 = State.UNKNOWN;
        try {
            state = ((ConnectivityManager) com.baidu.location.f.getServiceContext().getSystemService("connectivity")).getNetworkInfo(1).getState();
        } catch (Exception e) {
            state = state2;
        }
        if (State.CONNECTED != state) {
            this.hA = false;
        } else if (!this.hA) {
            this.hA = true;
            this.hy.postDelayed(new b(), (long) k.cy);
            this.hB = true;
        }
    }

    public static i bY() {
        if (hv == null) {
            hv = new i();
        }
        return hv;
    }

    public synchronized void b0() {
        if (this.hw) {
            try {
                com.baidu.location.f.getServiceContext().unregisterReceiver(this.hC);
            } catch (Exception e) {
            }
            this.hx = false;
            this.hw = false;
            this.hC = null;
        }
    }

    public void bV() {
        this.hx = false;
    }

    public void bW() {
        if (this.hw) {
            this.hx = true;
            if (!this.hB && this.hx) {
                this.hy.postDelayed(new b(), (long) k.cy);
                this.hB = true;
            }
        }
    }

    public synchronized void bX() {
        if (com.baidu.location.f.isServing) {
            if (!this.hw) {
                try {
                    this.hC = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    com.baidu.location.f.getServiceContext().registerReceiver(this.hC, intentFilter);
                    this.hz = true;
                    b1();
                } catch (Exception e) {
                }
                this.hx = true;
                this.hw = true;
            }
        }
    }

    public void bZ() {
        if (this.hC == null) {
            this.hC = new a();
        }
        try {
            if (!this.hz) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                com.baidu.location.f.getServiceContext().registerReceiver(this.hC, intentFilter);
                b1();
                this.hz = true;
            }
        } catch (Exception e) {
        }
    }
}
