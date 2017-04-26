package com.baidu.mobstat;

import android.content.Context;

enum ar extends ao {
    ar(String str, int i, int i2) {
        super(str, i, i2);
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        l a = at.a(context);
        bd bdVar = new bd();
        bdVar.a = false;
        bdVar.b = "E";
        bdVar.c = false;
        a.a(applicationContext, bdVar.a());
    }
}
