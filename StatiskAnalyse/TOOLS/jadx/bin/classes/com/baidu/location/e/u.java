package com.baidu.location.e;

import android.location.Location;
import com.tencent.open.yyb.TitleBar;

class u implements Runnable {
    final /* synthetic */ h a;

    u(h hVar) {
        this.a = hVar;
    }

    public void run() {
        Location location = new Location("GPS");
        h hVar = this.a;
        hVar.hf -= 1.123456789E-4d;
        hVar = this.a;
        hVar.hn -= 1.02340567E-5d;
        location.setTime(System.currentTimeMillis());
        location.setLongitude(this.a.hf);
        location.setLatitude(this.a.hn);
        location.setSpeed(TitleBar.BACKBTN_LEFT_MARGIN);
        location.setBearing(35.0f);
        hVar = this.a;
        hVar.ho++;
        this.a.for(location);
        if (this.a.ho < 20) {
            this.a.gJ.postDelayed(this, 1000);
        }
    }
}
