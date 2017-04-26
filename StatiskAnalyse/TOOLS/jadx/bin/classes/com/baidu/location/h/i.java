package com.baidu.location.h;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import com.baidu.location.f;

class i extends Handler {
    final /* synthetic */ a a;

    i(a aVar) {
        this.a = aVar;
    }

    public void handleMessage(Message message) {
        if (f.isServing) {
            switch (message.what) {
                case 1:
                    this.a.case((Location) message.obj);
                    return;
                case 2:
                    if (this.a.jx != null) {
                        this.a.jx.a((String) message.obj);
                        return;
                    }
                    return;
                case 3:
                    this.a.if("&og=1", (Location) message.obj);
                    return;
                case 4:
                    this.a.if("&og=2", (Location) message.obj);
                    return;
                default:
                    return;
            }
        }
    }
}
