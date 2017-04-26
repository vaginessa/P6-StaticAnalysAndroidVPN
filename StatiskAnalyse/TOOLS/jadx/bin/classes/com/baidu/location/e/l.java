package com.baidu.location.e;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.b.f;

public class l implements SensorEventListener, f {
    private static l id;
    private SensorManager h8;
    private boolean h9 = false;
    private boolean ia;
    private float ib;
    private float[] ic;
    private double ie = Double.MIN_VALUE;
    private float[] ig;
    private boolean ih = false;

    public static l cg() {
        if (id == null) {
            id = new l();
        }
        return id;
    }

    public void byte(boolean z) {
        this.ia = z;
    }

    public void case(boolean z) {
        this.h9 = z;
    }

    public boolean cc() {
        return this.h9;
    }

    public boolean cd() {
        return this.ia;
    }

    public synchronized void ce() {
        if (!this.ih) {
            if (this.h8 == null) {
                this.h8 = (SensorManager) com.baidu.location.f.getServiceContext().getSystemService("sensor");
            }
            if (this.h8 != null) {
                Sensor defaultSensor = this.h8.getDefaultSensor(11);
                if (defaultSensor != null && this.ia) {
                    this.h8.registerListener(this, defaultSensor, 3);
                }
                defaultSensor = this.h8.getDefaultSensor(6);
                if (defaultSensor != null && this.h9) {
                    this.h8.registerListener(this, defaultSensor, 3);
                }
            }
            this.ih = true;
        }
    }

    public double cf() {
        return this.ie;
    }

    public synchronized void ch() {
        if (this.ih) {
            if (this.h8 != null) {
                this.h8.unregisterListener(this);
                this.h8 = null;
            }
            this.ih = false;
        }
    }

    public float ci() {
        return this.ib;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        switch (sensorEvent.sensor.getType()) {
            case 6:
                this.ic = (float[]) sensorEvent.values.clone();
                this.ie = (double) SensorManager.getAltitude(1013.25f, this.ic[0]);
                return;
            case 11:
                this.ig = (float[]) sensorEvent.values.clone();
                if (this.ig != null) {
                    float[] fArr = new float[9];
                    SensorManager.getRotationMatrixFromVector(fArr, this.ig);
                    float[] fArr2 = new float[3];
                    SensorManager.getOrientation(fArr, fArr2);
                    this.ib = (float) Math.toDegrees((double) fArr2[0]);
                    this.ib = (float) Math.floor(this.ib >= 0.0f ? (double) this.ib : (double) (this.ib + 360.0f));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
