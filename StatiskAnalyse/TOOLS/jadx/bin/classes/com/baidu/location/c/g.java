package com.baidu.location.c;

import java.util.List;
import java.util.concurrent.Callable;

class g implements Callable {
    final /* synthetic */ String a;
    final /* synthetic */ List b;
    final /* synthetic */ b c;

    g(b bVar, String str, List list) {
        this.c = bVar;
        this.a = str;
        this.b = list;
    }

    public String a() {
        this.c.do(this.a, this.b);
        return this.c.new(true);
    }

    public /* synthetic */ Object call() throws Exception {
        return a();
    }
}
