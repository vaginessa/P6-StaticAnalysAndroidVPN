package com.baidu.platform.comapi.map;

import android.graphics.Bitmap;
import android.view.MotionEvent;
import com.baidu.mapapi.model.inner.GeoPoint;
import javax.microedition.khronos.opengles.GL10;

public interface i {
    void a();

    void a(Bitmap bitmap);

    void a(MotionEvent motionEvent);

    void a(GeoPoint geoPoint);

    void a(B b);

    void a(String str);

    void a(GL10 gl10, B b);

    void b();

    void b(GeoPoint geoPoint);

    void b(B b);

    boolean b(String str);

    void c();

    void c(GeoPoint geoPoint);

    void c(B b);

    void d();

    void d(GeoPoint geoPoint);

    void e();

    void e(GeoPoint geoPoint);
}
