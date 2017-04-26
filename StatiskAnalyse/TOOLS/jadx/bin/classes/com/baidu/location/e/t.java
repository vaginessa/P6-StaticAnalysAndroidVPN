package com.baidu.location.e;

import android.os.Environment;
import java.io.File;

class t extends Thread {
    final /* synthetic */ h a;

    t(h hVar) {
        this.a = hVar;
    }

    public void run() {
        this.a.if(new File(Environment.getExternalStorageDirectory() + "/baidu/tempdata", "intime.dat"), "http://itsdata.map.baidu.com/long-conn-gps/sdk.php");
    }
}
