package com.baidu.location.e;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.baidu.location.Address;
import com.baidu.location.BDLocation;
import com.baidu.location.b.f;
import com.baidu.location.b.k;
import com.baidu.location.b.o;
import com.baidu.location.c.d;
import com.baidu.location.h.c;
import com.baidu.location.h.e;
import com.baidu.location.h.h;
import com.baidu.location.h.l;
import com.baidu.mapapi.UIMsg.m_AppUI;
import com.baidu.mobstat.Config;
import com.tencent.open.yyb.TitleBar;
import gov.nist.core.Separators;
import java.util.List;

public class m extends b implements f {
    private static m fV = null;
    private h f0;
    private List f1;
    private long f2;
    private long f3;
    private h f4;
    private boolean f5;
    private double f6;
    private com.baidu.location.h.f f7;
    private boolean f8;
    private double f9;
    public final Handler fO;
    final int fR;
    public a fS;
    private volatile boolean fT;
    private boolean fU;
    private long fW;
    private boolean fX;
    private b fY;
    private String fZ;
    private long ga;
    private boolean gb;
    private boolean gc;
    private boolean gd;
    private Address ge;
    private BDLocation gf;
    private BDLocation gg;
    final int gh;
    private String gi;
    private com.baidu.location.h.f gj;

    private class a implements Runnable {
        final /* synthetic */ m a;

        private a(m mVar) {
            this.a = mVar;
        }

        public void run() {
            if (this.a.f8) {
                this.a.f8 = false;
                this.a.new(null);
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ m a;

        private b(m mVar) {
            this.a = mVar;
        }

        public void run() {
            if (this.a.f5) {
                this.a.f5 = false;
                if (!this.a.fX) {
                    this.a.bd();
                }
            }
        }
    }

    private m() {
        this.gh = m_AppUI.MSG_APP_DATA_OK;
        this.fR = 1000;
        this.gb = true;
        this.fS = null;
        this.gi = null;
        this.gf = null;
        this.gg = null;
        this.f7 = null;
        this.f4 = null;
        this.gj = null;
        this.f0 = null;
        this.gc = true;
        this.fT = false;
        this.f8 = false;
        this.f2 = 0;
        this.f3 = 0;
        this.ge = null;
        this.fZ = null;
        this.f1 = null;
        this.fU = false;
        this.ga = 0;
        this.fW = 0;
        this.fY = null;
        this.f5 = false;
        this.fX = false;
        this.gd = true;
        this.fO = new com.baidu.location.e.b.b(this);
        this.fS = new a(this);
    }

    private boolean a8() {
        return true;
    }

    private void a9() {
        this.fT = false;
        this.fX = false;
        this.gd = false;
        this.fU = false;
        bk();
    }

    public static m bb() {
        if (fV == null) {
            fV = new m();
        }
        return fV;
    }

    private boolean bi() {
        BDLocation bDLocation = null;
        double random = Math.random();
        long uptimeMillis = SystemClock.uptimeMillis();
        h cO = c.a().cO();
        com.baidu.location.h.f c8 = l.a().c8();
        boolean z = cO != null && cO.dA() && (c8 == null || c8.dn() == 0);
        if (d.try().long() && d.try().case() && (z || (0.0d < random && random < d.try().byte()))) {
            bDLocation = d.try().if(c.a().cO(), l.a().c8(), null, d.c.IS_MIX_MODE, com.baidu.location.c.d.b.NEED_TO_LOG);
        }
        if (bDLocation == null || bDLocation.getLocType() != 66 || !this.fT) {
            return false;
        }
        com.baidu.location.b.l lVar = new com.baidu.location.b.l();
        lVar.do(this.fW);
        lVar.if(uptimeMillis);
        lVar.for(uptimeMillis);
        lVar.int(SystemClock.uptimeMillis());
        lVar.char(com.baidu.location.b.l.cZ);
        if (this.f4 != null) {
            lVar.else(this.f4.dz());
            lVar.else("&offtag=1");
        }
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        bDLocation2.setLocType(BDLocation.TypeNetWorkLocation);
        if (!this.fT) {
            return false;
        }
        o.aY().if(lVar);
        this.fX = true;
        c.br().try(bDLocation2);
        this.gf = bDLocation2;
        return true;
    }

    private void bk() {
        if (this.gf != null) {
            o.co().cq();
        }
    }

    private void byte(Message message) {
        if (com.baidu.location.h.d.a().cJ()) {
            for(message);
        } else {
            int(message);
        }
    }

    private boolean do(com.baidu.location.h.f fVar) {
        this.fQ = l.a().de();
        return fVar == this.fQ ? false : this.fQ == null || fVar == null || !fVar.try(this.fQ);
    }

    private boolean do(h hVar) {
        this.fP = c.a().cO();
        return this.fP == hVar ? false : this.fP == null || hVar == null || !hVar.case(this.fP);
    }

    private void for(Message message) {
        BDLocation bDLocation = new BDLocation(com.baidu.location.h.d.a().cF());
        if (k.cf.equals("all") || k.bX || k.bP) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f9, this.f6, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] < 100.0f) {
                if (this.ge != null) {
                    bDLocation.setAddr(this.ge);
                }
                if (this.fZ != null) {
                    bDLocation.setLocationDescribe(this.fZ);
                }
                if (this.f1 != null) {
                    bDLocation.setPoiList(this.f1);
                }
            } else {
                this.fU = true;
                int(null);
            }
        }
        this.gf = bDLocation;
        this.gg = null;
        c.br().if(bDLocation, message);
    }

    private boolean if(com.baidu.location.h.f fVar) {
        return fVar == null ? false : this.gj == null || !e.if(fVar, this.gj, 0.1f);
    }

    private boolean if(h hVar) {
        return hVar == null ? false : this.f0 == null || !hVar.case(this.f0);
    }

    private void int(Message message) {
        if (this.gc) {
            this.fW = SystemClock.uptimeMillis();
            new(message);
        } else if (!this.fT) {
            this.fW = SystemClock.uptimeMillis();
            if (l.a().c5()) {
                this.f8 = true;
                this.fO.postDelayed(new a(), 2000);
                return;
            }
            new(message);
        }
    }

    private void new(Message message) {
        if (!this.fT) {
            if (System.currentTimeMillis() - this.f2 >= 1000 || this.gf == null) {
                if (this.fW > 0) {
                    o.aY().aV().do(this.fW);
                } else {
                    o.aY().aV().do(SystemClock.uptimeMillis());
                }
                this.fT = true;
                this.gb = do(this.f4);
                if (do(this.f7) || this.gb || this.gf == null || this.fU) {
                    String k = k(null);
                    if (k != null) {
                        if (this.gi != null) {
                            k = k + this.gi;
                            this.gi = null;
                        }
                        o.aY().aV().if(SystemClock.uptimeMillis());
                        this.fS.a(k);
                        this.f4 = this.fP;
                        this.f7 = this.fQ;
                        if (this.f4 == null || this.f4.dv() != 0) {
                            if (bi()) {
                                this.f4 = this.fP;
                                this.f7 = this.fQ;
                            }
                            if (d.try().i()) {
                                if (this.fY == null) {
                                    this.fY = new b();
                                }
                                this.fO.postDelayed(this.fY, d.try().if(c.a(c.a().cR())));
                                this.f5 = true;
                            }
                        } else {
                            new com.baidu.location.g.b(this.f4, this.f7, true).cB();
                            a9();
                        }
                        if (this.gc) {
                            this.gc = false;
                            if (l.a().db() && message != null && c.br().case(message) < 1000 && d.try().long()) {
                                new x(this).start();
                            }
                        }
                        this.f2 = System.currentTimeMillis();
                        return;
                    } else if (this.gf != null) {
                        c.br().try(this.gf);
                        a9();
                        return;
                    } else {
                        BDLocation bDLocation = new BDLocation();
                        bDLocation.setLocType(62);
                        c.br().try(bDLocation);
                        a9();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - this.ga > 60000) {
                            this.ga = currentTimeMillis;
                            o.aY().j("TypeCriteriaException");
                            return;
                        }
                        return;
                    }
                }
                if (this.gg != null && System.currentTimeMillis() - this.f3 > 30000) {
                    this.gf = this.gg;
                    this.gg = null;
                }
                if (l.cg().cd()) {
                    this.gf.setDirection(l.cg().ci());
                }
                c.br().try(this.gf);
                a9();
                return;
            }
            c.br().try(this.gf);
            a9();
        }
    }

    private void try(Message message) {
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            w.a().b();
        }
        switch (c.br().else(message)) {
            case 1:
                byte(message);
                return;
            case 2:
                int(message);
                return;
            case 3:
                if (com.baidu.location.h.d.a().cJ()) {
                    for(message);
                    return;
                }
                return;
            default:
                throw new IllegalArgumentException(String.format("this type %d is illegal", new Object[]{Integer.valueOf(c.br().else(message))}));
        }
    }

    public void a6() {
        boolean z;
        boolean z2 = true;
        if (this.fY == null || !this.f5) {
            z = false;
        } else {
            this.f5 = false;
            this.fO.removeCallbacks(this.fY);
            z = true;
        }
        if (com.baidu.location.h.d.a().cJ()) {
            BDLocation bDLocation = new BDLocation(com.baidu.location.h.d.a().cF());
            if (k.cf.equals("all") || k.bX || k.bP) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.f9, this.f6, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.ge != null) {
                        bDLocation.setAddr(this.ge);
                    }
                    if (this.fZ != null) {
                        bDLocation.setLocationDescribe(this.fZ);
                    }
                    if (this.f1 != null) {
                        bDLocation.setPoiList(this.f1);
                    }
                }
            }
            c.br().do(bDLocation, 21);
            a9();
        } else if (this.fX) {
            a9();
        } else {
            o.aY().aV().for(SystemClock.uptimeMillis());
            BDLocation bDLocation2;
            if (z) {
                if (d.try().long() && d.try().e()) {
                    bDLocation2 = d.try().if(c.a().cO(), l.a().c8(), null, d.c.IS_NOT_MIX_MODE, com.baidu.location.c.d.b.NEED_TO_LOG);
                    if (bDLocation2 != null && bDLocation2.getLocType() == 66) {
                        c.br().do(bDLocation2, 21);
                    }
                } else {
                    bDLocation2 = null;
                }
                if (bDLocation2 == null || bDLocation2.getLocType() == 67) {
                    if (this.gb || this.gf == null) {
                        bDLocation2 = com.baidu.location.c.b.a0().try(false);
                        c.br().do(bDLocation2, 21);
                        if (k.cf.equals("all") && bDLocation2.getAddrStr() == null) {
                            z2 = false;
                        }
                        if (k.bX && bDLocation2.getLocationDescribe() == null) {
                            z2 = false;
                        }
                        if (k.bP && bDLocation2.getPoiList() == null) {
                            z2 = false;
                        }
                        if (!z2) {
                            bDLocation2.setLocType(67);
                        }
                    } else {
                        c.br().do(this.gf, 21);
                    }
                }
                o.aY().aV().int(SystemClock.uptimeMillis());
                if (bDLocation2 == null || bDLocation2.getLocType() == 67) {
                    this.gf = null;
                    o.aY().aV().char(com.baidu.location.b.l.cW);
                    if (this.f4 != null) {
                        o.aY().aV().else(this.f4.dz());
                    }
                    o.aY().aX();
                } else {
                    this.gf = bDLocation2;
                    o.aY().aV().char(com.baidu.location.b.l.cZ);
                    if (this.f4 != null) {
                        o.aY().aV().else(this.f4.dz());
                    }
                    o.aY().aX();
                }
            } else {
                bDLocation2 = new BDLocation();
                bDLocation2.setLocType(63);
                this.gf = null;
                c.br().do(bDLocation2, 21);
            }
            this.gg = null;
            a9();
        }
    }

    public BDLocation a7() {
        return this.gf;
    }

    public void ba() {
        if (this.f8) {
            new(null);
            this.f8 = false;
        }
    }

    public void bc() {
        this.fT = false;
        this.f8 = false;
        this.fX = false;
        this.gd = true;
        bf();
    }

    public void bd() {
        BDLocation bDLocation;
        if (d.try().long() && d.try().goto()) {
            BDLocation bDLocation2 = d.try().if(c.a().cO(), l.a().c8(), null, d.c.IS_NOT_MIX_MODE, com.baidu.location.c.d.b.NEED_TO_LOG);
            bDLocation = (bDLocation2 == null || bDLocation2.getLocType() == 67) ? com.baidu.location.c.b.a0().try(false) : bDLocation2;
        } else {
            bDLocation = com.baidu.location.c.b.a0().try(false);
        }
        if (bDLocation != null && bDLocation.getLocType() == 66) {
            boolean z = true;
            if (k.cf.equals("all") && bDLocation.getAddrStr() == null) {
                z = false;
            }
            if (k.bX && bDLocation.getLocationDescribe() == null) {
                z = false;
            }
            if (k.bP && bDLocation.getPoiList() == null) {
                z = false;
            }
            if (z) {
                c.br().do(bDLocation, 21);
            }
        }
    }

    public String be() {
        return this.fZ;
    }

    public void bf() {
        this.gf = null;
    }

    public List bg() {
        return this.f1;
    }

    public boolean bh() {
        return this.gb;
    }

    public void bj() {
        this.gc = true;
        this.fT = false;
    }

    public void do(Message message) {
        try(message);
    }

    public void if(Message message) {
        if (this.fY != null && this.f5) {
            this.f5 = false;
            this.fO.removeCallbacks(this.fY);
        }
        BDLocation bDLocation = (BDLocation) message.obj;
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        if (bDLocation.hasAddr()) {
            this.ge = bDLocation.getAddress();
            this.f6 = bDLocation.getLongitude();
            this.f9 = bDLocation.getLatitude();
        }
        if (bDLocation.getLocationDescribe() != null) {
            this.fZ = bDLocation.getLocationDescribe();
            this.f6 = bDLocation.getLongitude();
            this.f9 = bDLocation.getLatitude();
        }
        if (bDLocation.getPoiList() != null) {
            this.f1 = bDLocation.getPoiList();
            this.f6 = bDLocation.getLongitude();
            this.f9 = bDLocation.getLatitude();
        }
        float[] fArr;
        if (com.baidu.location.h.d.a().cJ()) {
            bDLocation = new BDLocation(com.baidu.location.h.d.a().cF());
            if (k.cf.equals("all") || k.bX || k.bP) {
                fArr = new float[2];
                Location.distanceBetween(this.f9, this.f6, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
                if (fArr[0] < 100.0f) {
                    if (this.ge != null) {
                        bDLocation.setAddr(this.ge);
                    }
                    if (this.fZ != null) {
                        bDLocation.setLocationDescribe(this.fZ);
                    }
                    if (this.f1 != null) {
                        bDLocation.setPoiList(this.f1);
                    }
                }
            }
            c.br().do(bDLocation, 21);
            a9();
        } else if (bDLocation.getNetworkLocationType() != null && bDLocation.getNetworkLocationType().equals("sky")) {
            bDLocation.setNetworkLocationType("wf");
            c.br().do(bDLocation, 21);
            this.f3 = System.currentTimeMillis();
            this.gf = bDLocation;
        } else if (this.fX) {
            fArr = new float[2];
            if (this.gf != null) {
                Location.distanceBetween(this.gf.getLatitude(), this.gf.getLongitude(), bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            }
            if (fArr[0] > TitleBar.SHAREBTN_RIGHT_MARGIN) {
                this.gf = bDLocation;
                if (!this.gd) {
                    this.gd = false;
                    c.br().do(bDLocation, 21);
                }
            }
            a9();
        } else {
            boolean z;
            o.aY().aV().for(SystemClock.uptimeMillis());
            this.gg = null;
            if (!(this.f4 == null || this.f4.dv() == 0 || ((bDLocation.getLocationWhere() != 2 && bDLocation.getLocationWhere() != 0) || bDLocation.getLocType() != BDLocation.TypeServerError))) {
                new com.baidu.location.g.b(this.f4, this.f7, true).cB();
            }
            if (bDLocation.getLocType() == BDLocation.TypeNetWorkLocation && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && this.gf != null && this.gf.getLocType() == BDLocation.TypeNetWorkLocation && "wf".equals(this.gf.getNetworkLocationType()) && System.currentTimeMillis() - this.f3 < 30000) {
                z = true;
                this.gg = bDLocation;
            } else {
                z = false;
            }
            if (z) {
                c.br().do(this.gf, 21);
            } else {
                c.br().do(bDLocation, 21);
                this.f3 = System.currentTimeMillis();
                o.aY().aV().int(SystemClock.uptimeMillis());
                if (bDLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                    o.aY().aV().char(com.baidu.location.b.l.c2);
                    if (this.f4 != null) {
                        o.aY().aV().else(this.f4.dz());
                    }
                } else {
                    o.aY().aV().char(com.baidu.location.b.l.cV);
                    if (this.f4 != null) {
                        o.aY().aV().else(this.f4.dz());
                    }
                    o.aY().aX();
                }
            }
            if (!k.do(bDLocation)) {
                this.gf = null;
            } else if (!z) {
                this.gf = bDLocation;
            }
            int i = k.for(fM, "ssid\":\"", Separators.DOUBLE_QUOTE);
            if (i == Integer.MIN_VALUE || this.f7 == null) {
                this.gi = null;
            } else {
                this.gi = this.f7.j(i);
            }
            if (d.try().long() && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation && Config.CELL_LOCATION.equals(bDLocation.getNetworkLocationType()) && if(this.f4)) {
                d.try().if(this.f4, null, bDLocation2, d.c.IS_NOT_MIX_MODE, com.baidu.location.c.d.b.NO_NEED_TO_LOG);
                this.f0 = this.f4;
            }
            if (d.try().long() && bDLocation.getLocType() == BDLocation.TypeNetWorkLocation && "wf".equals(bDLocation.getNetworkLocationType())) {
                d.try().if(null, this.f7, bDLocation2, d.c.IS_NOT_MIX_MODE, com.baidu.location.c.d.b.NO_NEED_TO_LOG);
                this.gj = this.f7;
            }
            com.baidu.location.c.b.a0().if(fM, this.f4, this.f7, bDLocation2);
            if (l.a().db()) {
                d.try().k();
            }
            a9();
        }
    }

    public void int(BDLocation bDLocation) {
        bf();
        this.gf = bDLocation;
        this.gf.setIndoorLocMode(false);
    }

    public Address new(BDLocation bDLocation) {
        if (k.cf.equals("all") || k.bX || k.bP) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.f9, this.f6, bDLocation.getLatitude(), bDLocation.getLongitude(), fArr);
            if (fArr[0] >= 100.0f) {
                this.fZ = null;
                this.f1 = null;
                this.fU = true;
                int(null);
            } else if (this.ge != null) {
                return this.ge;
            }
        }
        return null;
    }
}
