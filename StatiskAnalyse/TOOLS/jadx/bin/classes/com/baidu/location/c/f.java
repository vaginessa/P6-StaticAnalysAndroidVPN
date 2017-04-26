package com.baidu.location.c;

class f implements Runnable {
    final /* synthetic */ b a;

    f(b bVar) {
        this.a = bVar;
    }

    public void run() {
        if (com.baidu.location.f.isServing) {
            this.a.aZ();
        }
    }
}
