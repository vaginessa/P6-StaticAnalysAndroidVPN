package com.baidu.location.a;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.f;
import com.baidu.location.b.g;
import com.baidu.location.c.b;
import com.baidu.location.c.d;
import com.baidu.location.e.e;
import com.baidu.location.e.h;
import com.baidu.location.e.i;
import com.baidu.location.e.m;
import com.baidu.location.e.n;
import com.baidu.location.e.o;
import com.baidu.location.h.c;
import com.baidu.location.h.l;

public class a extends Service implements LLSInterface, f {
    static a l3 = null;
    private static long l7 = 0;
    private HandlerThread l2;
    private boolean l4 = false;
    Messenger l5 = null;
    private Looper l6;

    public class a extends Handler {
        final /* synthetic */ a a;

        public a(a aVar, Looper looper) {
            this.a = aVar;
            super(looper);
        }

        public void handleMessage(Message message) {
            if (com.baidu.location.f.isServing) {
                switch (message.what) {
                    case 11:
                        this.a.m(message);
                        break;
                    case 12:
                        this.a.l(message);
                        break;
                    case 15:
                        this.a.n(message);
                        break;
                    case 22:
                        m.bb().do(message);
                        break;
                    case 28:
                        m.bb().bd();
                        break;
                    case 41:
                        m.bb().ba();
                        break;
                    case g.B /*401*/:
                        try {
                            message.getData();
                            break;
                        } catch (Exception e) {
                            break;
                        }
                }
            }
            if (message.what == 1) {
                this.a.dR();
            }
            if (message.what == 0) {
                this.a.dS();
            }
            super.handleMessage(message);
        }
    }

    public static long dP() {
        return l7;
    }

    public static Handler dQ() {
        return l3;
    }

    private void dR() {
        c.a().cT();
        m.bb().bc();
        o.cj();
        com.baidu.location.e.c.br().bt();
        h.bK().bL();
        if (!this.l4) {
            Process.killProcess(Process.myPid());
        }
    }

    private void dS() {
        c.a().cP();
        l.a().c6();
        com.baidu.location.b.c.N();
        m.bb().bj();
        b.a0().a1();
        e.bx().bz();
    }

    private void l(Message message) {
        com.baidu.location.e.c.br().char(message);
    }

    private void m(Message message) {
        Log.d("baidu_location_service", "baidu location service register ...");
        com.baidu.location.e.c.br().long(message);
        d.try();
        com.baidu.location.e.f.bC().bF();
        com.baidu.location.e.d.aR().aQ();
    }

    private void n(Message message) {
        com.baidu.location.e.c.br().goto(message);
    }

    public double getVersion() {
        return 6.119999885559082d;
    }

    public IBinder onBind(Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            com.baidu.location.b.c.bl = extras.getString(AlixDefine.KEY);
            com.baidu.location.b.c.bk = extras.getString("sign");
            this.l4 = extras.getBoolean("kill_process");
        }
        return this.l5.getBinder();
    }

    public void onCreate(Context context) {
        l7 = System.currentTimeMillis();
        this.l2 = n.a();
        this.l6 = this.l2.getLooper();
        l3 = new a(this, this.l6);
        this.l5 = new Messenger(l3);
        l3.sendEmptyMessage(0);
        Log.d("baidu_location_service", "baidu location service start1 ..." + Process.myPid());
    }

    public void onDestroy() {
        l.a().dd();
        i.bY().b0();
        d.try().h();
        com.baidu.location.e.f.bC().bI();
        com.baidu.location.h.d.a().cG();
        e.bx().bA();
        l3.sendEmptyMessage(1);
        Log.d("baidu_location_service", "baidu location service stop ...");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 1;
    }

    public boolean onUnBind(Intent intent) {
        return false;
    }
}
