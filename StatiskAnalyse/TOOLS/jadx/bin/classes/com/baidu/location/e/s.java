package com.baidu.location.e;

import android.location.Location;

class s implements Runnable {
    final /* synthetic */ Location a;
    final /* synthetic */ h b;

    s(h hVar, Location location) {
        this.b = hVar;
        this.a = location;
    }

    public void run() {
        this.b.do(this.a);
    }
}
