package com.baidu.mobstat;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import java.util.List;

public enum ao {
    SERVICE(1),
    NO_SERVICE(2),
    ERISED(3);
    
    private int d;

    public abstract void a(Context context);

    private ao(int i) {
        this.d = i;
    }

    public String toString() {
        return String.valueOf(this.d);
    }

    public static ao a(int i) {
        for (ao aoVar : values()) {
            if (aoVar.d == i) {
                return aoVar;
            }
        }
        return NO_SERVICE;
    }

    public static boolean b(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List runningServices = activityManager.getRunningServices(ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                int i = 0;
                while (runningServices != null && i < runningServices.size()) {
                    if ("com.baidu.bottom.service.BottomService".equals(((RunningServiceInfo) runningServices.get(i)).service.getClassName())) {
                        return true;
                    }
                    i++;
                }
            } catch (Throwable e) {
                cr.a(e);
            }
        }
        return false;
    }
}
