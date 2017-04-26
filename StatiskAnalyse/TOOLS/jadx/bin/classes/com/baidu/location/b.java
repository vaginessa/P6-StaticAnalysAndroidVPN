package com.baidu.location;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;

class b implements ServiceConnection {
    final /* synthetic */ LocationClient a;

    b(LocationClient locationClient) {
        this.a = locationClient;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.a.lC = new Messenger(iBinder);
        if (this.a.lC != null) {
            this.a.lK = true;
            Log.d("baidu_location_client", "baidu location connected ...");
            if (this.a.lV) {
                this.a.lg.obtainMessage(2).sendToTarget();
                return;
            }
            try {
                Message obtain = Message.obtain(null, 11);
                obtain.replyTo = this.a.lz;
                obtain.setData(this.a.dJ());
                this.a.lC.send(obtain);
                this.a.lK = true;
                if (this.a.lE != null) {
                    if (this.a.lH.booleanValue()) {
                        this.a.lg.obtainMessage(4).sendToTarget();
                    } else {
                        this.a.lg.obtainMessage(4).sendToTarget();
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.lC = null;
        this.a.lK = false;
    }
}
