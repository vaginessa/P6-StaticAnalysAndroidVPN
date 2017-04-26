package com.baidu.location.e;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Message;
import android.os.Messenger;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.h.d;
import com.baidu.platform.comapi.location.CoordinateType;
import gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.java.sip.communicator.impl.protocol.jabber.extensions.jingle.CandidatePacketExtension;

public class c implements f {
    private static c gm = null;
    private boolean gk;
    private ArrayList gl;
    public boolean gn;
    private boolean go;

    private class a {
        public String a = null;
        public Messenger b = null;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;
        final /* synthetic */ c e;

        public a(c cVar, Message message) {
            boolean z = false;
            this.e = cVar;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.prodName = message.getData().getString("prodName");
            com.baidu.location.b.c.N().if(this.c.prodName, this.a);
            this.c.coorType = message.getData().getString("coorType");
            this.c.addrType = message.getData().getString("addrType");
            this.c.enableSimulateGps = message.getData().getBoolean("enableSimulateGps", false);
            boolean z2 = k.cj || this.c.enableSimulateGps;
            k.cj = z2;
            if (!k.cf.equals("all")) {
                k.cf = this.c.addrType;
            }
            this.c.openGps = message.getData().getBoolean("openGPS");
            this.c.scanSpan = message.getData().getInt("scanSpan");
            this.c.timeOut = message.getData().getInt("timeOut");
            this.c.priority = message.getData().getInt(CandidatePacketExtension.PRIORITY_ATTR_NAME);
            this.c.location_change_notify = message.getData().getBoolean("location_change_notify");
            this.c.mIsNeedDeviceDirect = message.getData().getBoolean("needDirect", false);
            this.c.isNeedAltitude = message.getData().getBoolean("isneedaltitude", false);
            z2 = k.bX || message.getData().getBoolean("isneedaptag", false);
            k.bX = z2;
            if (k.bP || message.getData().getBoolean("isneedaptagd", false)) {
                z = true;
            }
            k.bP = z;
            if (this.c.scanSpan >= 1000) {
                i.bY().bX();
            }
            if (this.c.mIsNeedDeviceDirect || this.c.isNeedAltitude) {
                l.cg().byte(this.c.mIsNeedDeviceDirect);
                l.cg().case(this.c.isNeedAltitude);
                l.cg().ce();
            }
        }

        private void a(int i) {
            Message obtain = Message.obtain(null, i);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        private void a(int i, Bundle bundle) {
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
                e.printStackTrace();
            }
        }

        private void a(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            Message obtain = Message.obtain(null, i);
            obtain.setData(bundle);
            try {
                if (this.b != null) {
                    this.b.send(obtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        public void a() {
            a(23);
        }

        public void a(BDLocation bDLocation) {
            a(bDLocation, 21);
        }

        public void a(BDLocation bDLocation, int i) {
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (l.cg().cc() && (bDLocation2.getLocType() == BDLocation.TypeNetWorkLocation || bDLocation2.getLocType() == 66)) {
                bDLocation2.setAltitude(l.cg().cf());
            }
            if (i == 21) {
                a(27, "locStr", bDLocation2);
            }
            if (!(this.c.coorType == null || this.c.coorType.equals(CoordinateType.GCJ02))) {
                double longitude = bDLocation2.getLongitude();
                double latitude = bDLocation2.getLatitude();
                if (!(longitude == Double.MIN_VALUE || latitude == Double.MIN_VALUE)) {
                    double[] dArr;
                    if ((bDLocation2.getCoorType() != null && bDLocation2.getCoorType().equals(CoordinateType.GCJ02)) || bDLocation2.getCoorType() == null) {
                        dArr = Jni.if(longitude, latitude, this.c.coorType);
                        bDLocation2.setLongitude(dArr[0]);
                        bDLocation2.setLatitude(dArr[1]);
                        bDLocation2.setCoorType(this.c.coorType);
                    } else if (!(bDLocation2.getCoorType() == null || !bDLocation2.getCoorType().equals(CoordinateType.WGS84) || this.c.coorType.equals("bd09ll"))) {
                        dArr = Jni.if(longitude, latitude, "wgs842mc");
                        bDLocation2.setLongitude(dArr[0]);
                        bDLocation2.setLatitude(dArr[1]);
                        bDLocation2.setCoorType("wgs84mc");
                    }
                }
            }
            a(i, "locStr", bDLocation2);
        }

        public void b() {
            a(111);
        }

        public void b(BDLocation bDLocation) {
            if (this.c.location_change_notify) {
                a(bDLocation);
            }
        }

        public void c() {
            if (!this.c.location_change_notify) {
                return;
            }
            if (k.cG) {
                a(54);
            } else {
                a(55);
            }
        }
    }

    private c() {
        this.gl = null;
        this.go = false;
        this.gk = false;
        this.gn = true;
        this.gl = new ArrayList();
    }

    private void bn() {
        bq();
        bs();
    }

    private void bq() {
        Iterator it = this.gl.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.c.openGps) {
                z2 = true;
            }
            z = aVar.c.location_change_notify ? true : z;
        }
        k.cm = z;
        if (this.go != z2) {
            this.go = z2;
            d.a().char(this.go);
        }
    }

    public static c br() {
        if (gm == null) {
            gm = new c();
        }
        return gm;
    }

    private a if(Messenger messenger) {
        if (this.gl == null) {
            return null;
        }
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.b.equals(messenger)) {
                return aVar;
            }
        }
        return null;
    }

    private void if(a aVar) {
        if (aVar != null) {
            if (if(aVar.b) != null) {
                aVar.a(14);
                return;
            }
            this.gl.add(aVar);
            aVar.a(13);
        }
    }

    public void bl() {
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b();
        }
    }

    public void bm() {
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a();
        }
    }

    public boolean bo() {
        return this.gn;
    }

    public boolean bp() {
        return this.go;
    }

    public void bs() {
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            ((a) it.next()).c();
        }
    }

    public void bt() {
        this.gl.clear();
        bn();
    }

    public String bu() {
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.gl.isEmpty()) {
            return "&prod=" + com.baidu.location.b.c.bj + Separators.COLON + com.baidu.location.b.c.bn;
        }
        a aVar = (a) this.gl.get(0);
        if (aVar.c.prodName != null) {
            stringBuffer.append(aVar.c.prodName);
        }
        if (aVar.a != null) {
            stringBuffer.append(Separators.COLON);
            stringBuffer.append(aVar.a);
            stringBuffer.append("|");
        }
        String stringBuffer2 = stringBuffer.toString();
        return (stringBuffer2 == null || stringBuffer2.equals("")) ? null : "&prod=" + stringBuffer2;
    }

    public int case(Message message) {
        if (message == null || message.replyTo == null) {
            return 1000;
        }
        a aVar = if(message.replyTo);
        return (aVar == null || aVar.c == null) ? 1000 : aVar.c.scanSpan;
    }

    public void char(Message message) {
        a aVar = if(message.replyTo);
        if (aVar != null) {
            this.gl.remove(aVar);
        }
        i.bY().b0();
        l.cg().ch();
        bn();
    }

    public void do(BDLocation bDLocation, int i) {
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            try {
                a aVar = (a) it.next();
                aVar.a(bDLocation, i);
                if (aVar.d > 4) {
                    it.remove();
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    public int else(Message message) {
        if (message == null || message.replyTo == null) {
            return 1;
        }
        a aVar = if(message.replyTo);
        return (aVar == null || aVar.c == null) ? 1 : aVar.c.priority;
    }

    public boolean goto(Message message) {
        boolean z = true;
        a aVar = if(message.replyTo);
        if (aVar == null) {
            return false;
        }
        int i = aVar.c.scanSpan;
        aVar.c.scanSpan = message.getData().getInt("scanSpan", aVar.c.scanSpan);
        if (aVar.c.scanSpan < 1000) {
            i.bY().bV();
            l.cg().ch();
            this.gn = false;
        } else {
            i.bY().bW();
            this.gn = true;
        }
        if (aVar.c.scanSpan <= 999 || i >= 1000) {
            z = false;
        } else if (aVar.c.mIsNeedDeviceDirect || aVar.c.isNeedAltitude) {
            l.cg().byte(aVar.c.mIsNeedDeviceDirect);
            l.cg().case(aVar.c.isNeedAltitude);
            l.cg().ce();
        }
        aVar.c.openGps = message.getData().getBoolean("openGPS", aVar.c.openGps);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption = aVar.c;
        if (string == null || string.equals("")) {
            string = aVar.c.coorType;
        }
        locationClientOption.coorType = string;
        string = message.getData().getString("addrType");
        locationClientOption = aVar.c;
        if (string == null || string.equals("")) {
            string = aVar.c.addrType;
        }
        locationClientOption.addrType = string;
        if (!k.cf.equals(aVar.c.addrType)) {
            m.bb().bf();
        }
        aVar.c.timeOut = message.getData().getInt("timeOut", aVar.c.timeOut);
        aVar.c.location_change_notify = message.getData().getBoolean("location_change_notify", aVar.c.location_change_notify);
        aVar.c.priority = message.getData().getInt(CandidatePacketExtension.PRIORITY_ATTR_NAME, aVar.c.priority);
        bn();
        return z;
    }

    public void if(Bundle bundle, int i) {
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            try {
                a aVar = (a) it.next();
                aVar.a(i, bundle);
                if (aVar.d > 4) {
                    it.remove();
                }
            } catch (Exception e) {
                return;
            }
        }
    }

    public void if(BDLocation bDLocation, Message message) {
        if (bDLocation != null && message != null) {
            a aVar = if(message.replyTo);
            if (aVar != null) {
                aVar.a(bDLocation);
                if (aVar.d > 4) {
                    this.gl.remove(aVar);
                }
            }
        }
    }

    public void l(String str) {
        BDLocation bDLocation = new BDLocation(str);
        Address address = m.bb().new(bDLocation);
        String be = m.bb().be();
        List bg = m.bb().bg();
        if (address != null) {
            bDLocation.setAddr(address);
        }
        if (be != null) {
            bDLocation.setLocationDescribe(be);
        }
        if (bg != null) {
            bDLocation.setPoiList(bg);
        }
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            ((a) it.next()).b(bDLocation);
        }
    }

    public void long(Message message) {
        if (message != null && message.replyTo != null) {
            if(new a(this, message));
            bn();
        }
    }

    public void try(BDLocation bDLocation) {
        Iterator it = this.gl.iterator();
        while (it.hasNext()) {
            try {
                a aVar = (a) it.next();
                aVar.a(bDLocation);
                if (aVar.d > 4) {
                    it.remove();
                }
            } catch (Exception e) {
                return;
            }
        }
    }
}
