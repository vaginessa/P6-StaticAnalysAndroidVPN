package com.baidu.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.baidu.location.Address.Builder;
import com.baidu.location.b.f;
import com.baidu.mobstat.Config;
import com.baidu.platform.comapi.location.CoordinateType;
import com.easemob.chat.MessageEncoder;
import com.easemob.easeui.EaseConstant;
import com.easemob.util.EMPrivateConstant.EMMultiUserConstant;
import com.external.imagezoom.ImageViewTouchBase;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class BDLocation implements Parcelable, f {
    public static final String BDLOCATION_BD09LL_TO_GCJ02 = "bd09ll2gcj";
    public static final String BDLOCATION_BD09_TO_GCJ02 = "bd092gcj";
    public static final String BDLOCATION_GCJ02_TO_BD09 = "bd09";
    public static final String BDLOCATION_GCJ02_TO_BD09LL = "bd09ll";
    public static final Creator CREATOR = new a();
    public static final int LOCATION_WHERE_IN_CN = 1;
    public static final int LOCATION_WHERE_OUT_CN = 0;
    public static final int LOCATION_WHERE_UNKNOW = 2;
    public static final int OPERATORS_TYPE_MOBILE = 1;
    public static final int OPERATORS_TYPE_TELECOMU = 3;
    public static final int OPERATORS_TYPE_UNICOM = 2;
    public static final int OPERATORS_TYPE_UNKONW = 0;
    public static final int TypeCacheLocation = 65;
    public static final int TypeCriteriaException = 62;
    public static final int TypeGpsLocation = 61;
    public static final int TypeNetWorkException = 63;
    public static final int TypeNetWorkLocation = 161;
    public static final int TypeNone = 0;
    public static final int TypeOffLineLocation = 66;
    public static final int TypeOffLineLocationFail = 67;
    public static final int TypeOffLineLocationNetworkFail = 68;
    public static final int TypeServerError = 167;
    private float k0;
    private String k1;
    private String k2;
    private int k3;
    private int kA;
    private double kB;
    private String kC;
    private boolean kD;
    private boolean kE;
    private boolean kF;
    private String kG;
    private String kH;
    private float kI;
    private String kJ;
    private double kK;
    private boolean kL;
    private Address kM;
    private boolean kN;
    private String kO;
    private String kP;
    private int kQ;
    private int kR;
    private float kS;
    private boolean kT;
    private List kU;
    private String kV;
    private int kW;
    private double kX;
    private String kY;
    private boolean kZ;
    private String kz;

    public BDLocation() {
        this.kW = 0;
        this.k1 = null;
        this.kB = Double.MIN_VALUE;
        this.kX = Double.MIN_VALUE;
        this.kD = false;
        this.kK = Double.MIN_VALUE;
        this.kE = false;
        this.k0 = 0.0f;
        this.kN = false;
        this.kS = 0.0f;
        this.kZ = false;
        this.kA = -1;
        this.kI = ImageViewTouchBase.ZOOM_INVALID;
        this.k2 = null;
        this.kT = false;
        this.kz = null;
        this.kG = null;
        this.kJ = null;
        this.kY = null;
        this.kL = false;
        this.kM = new Builder().build();
        this.kC = null;
        this.kO = null;
        this.kV = null;
        this.kF = false;
        this.kR = 0;
        this.kQ = 1;
        this.kP = null;
        this.kH = "";
        this.kU = null;
    }

    private BDLocation(Parcel parcel) {
        this.kW = 0;
        this.k1 = null;
        this.kB = Double.MIN_VALUE;
        this.kX = Double.MIN_VALUE;
        this.kD = false;
        this.kK = Double.MIN_VALUE;
        this.kE = false;
        this.k0 = 0.0f;
        this.kN = false;
        this.kS = 0.0f;
        this.kZ = false;
        this.kA = -1;
        this.kI = ImageViewTouchBase.ZOOM_INVALID;
        this.k2 = null;
        this.kT = false;
        this.kz = null;
        this.kG = null;
        this.kJ = null;
        this.kY = null;
        this.kL = false;
        this.kM = new Builder().build();
        this.kC = null;
        this.kO = null;
        this.kV = null;
        this.kF = false;
        this.kR = 0;
        this.kQ = 1;
        this.kP = null;
        this.kH = "";
        this.kU = null;
        this.kW = parcel.readInt();
        this.k1 = parcel.readString();
        this.kB = parcel.readDouble();
        this.kX = parcel.readDouble();
        this.kK = parcel.readDouble();
        this.k0 = parcel.readFloat();
        this.kS = parcel.readFloat();
        this.kA = parcel.readInt();
        this.kI = parcel.readFloat();
        this.kC = parcel.readString();
        this.kR = parcel.readInt();
        this.kO = parcel.readString();
        this.kV = parcel.readString();
        this.kP = parcel.readString();
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
        String readString6 = parcel.readString();
        parcel.readString();
        String readString7 = parcel.readString();
        this.kM = new Builder().country(readString7).countryCode(parcel.readString()).province(readString).city(readString2).cityCode(readString6).district(readString3).street(readString4).streetNumber(readString5).build();
        boolean[] zArr = new boolean[7];
        this.k3 = parcel.readInt();
        this.kH = parcel.readString();
        this.kG = parcel.readString();
        this.kJ = parcel.readString();
        this.kY = parcel.readString();
        this.kQ = parcel.readInt();
        try {
            parcel.readBooleanArray(zArr);
            this.kD = zArr[0];
            this.kE = zArr[1];
            this.kN = zArr[2];
            this.kZ = zArr[3];
            this.kT = zArr[4];
            this.kL = zArr[5];
            this.kF = zArr[6];
        } catch (Exception e) {
        }
        List arrayList = new ArrayList();
        parcel.readList(arrayList, Poi.class.getClassLoader());
        if (arrayList.size() == 0) {
            this.kU = null;
        } else {
            this.kU = arrayList;
        }
    }

    public BDLocation(BDLocation bDLocation) {
        this.kW = 0;
        this.k1 = null;
        this.kB = Double.MIN_VALUE;
        this.kX = Double.MIN_VALUE;
        this.kD = false;
        this.kK = Double.MIN_VALUE;
        this.kE = false;
        this.k0 = 0.0f;
        this.kN = false;
        this.kS = 0.0f;
        this.kZ = false;
        this.kA = -1;
        this.kI = ImageViewTouchBase.ZOOM_INVALID;
        this.k2 = null;
        this.kT = false;
        this.kz = null;
        this.kG = null;
        this.kJ = null;
        this.kY = null;
        this.kL = false;
        this.kM = new Builder().build();
        this.kC = null;
        this.kO = null;
        this.kV = null;
        this.kF = false;
        this.kR = 0;
        this.kQ = 1;
        this.kP = null;
        this.kH = "";
        this.kU = null;
        this.kW = bDLocation.kW;
        this.k1 = bDLocation.k1;
        this.kB = bDLocation.kB;
        this.kX = bDLocation.kX;
        this.kD = bDLocation.kD;
        this.kK = bDLocation.kK;
        this.kE = bDLocation.kE;
        this.k0 = bDLocation.k0;
        this.kN = bDLocation.kN;
        this.kS = bDLocation.kS;
        this.kZ = bDLocation.kZ;
        this.kA = bDLocation.kA;
        this.kI = bDLocation.kI;
        this.k2 = bDLocation.k2;
        this.kT = bDLocation.kT;
        this.kz = bDLocation.kz;
        this.kL = bDLocation.kL;
        this.kM = new Builder().country(bDLocation.kM.country).countryCode(bDLocation.kM.countryCode).province(bDLocation.kM.province).city(bDLocation.kM.city).cityCode(bDLocation.kM.cityCode).district(bDLocation.kM.district).street(bDLocation.kM.street).streetNumber(bDLocation.kM.streetNumber).build();
        this.kC = bDLocation.kC;
        this.kO = bDLocation.kO;
        this.kV = bDLocation.kV;
        this.kQ = bDLocation.kQ;
        this.kR = bDLocation.kR;
        this.kF = bDLocation.kF;
        this.kP = bDLocation.kP;
        this.k3 = bDLocation.k3;
        this.kH = bDLocation.kH;
        this.kG = bDLocation.kG;
        this.kJ = bDLocation.kJ;
        this.kY = bDLocation.kY;
        if (bDLocation.kU == null) {
            this.kU = null;
            return;
        }
        List arrayList = new ArrayList();
        for (int i = 0; i < bDLocation.kU.size(); i++) {
            Poi poi = (Poi) bDLocation.kU.get(i);
            arrayList.add(new Poi(poi.getId(), poi.getName(), poi.getRank()));
        }
        this.kU = arrayList;
    }

    public BDLocation(String str) {
        String str2 = null;
        this.kW = 0;
        this.k1 = null;
        this.kB = Double.MIN_VALUE;
        this.kX = Double.MIN_VALUE;
        this.kD = false;
        this.kK = Double.MIN_VALUE;
        this.kE = false;
        this.k0 = 0.0f;
        this.kN = false;
        this.kS = 0.0f;
        this.kZ = false;
        this.kA = -1;
        this.kI = ImageViewTouchBase.ZOOM_INVALID;
        this.k2 = null;
        this.kT = false;
        this.kz = null;
        this.kG = null;
        this.kJ = null;
        this.kY = null;
        this.kL = false;
        this.kM = new Builder().build();
        this.kC = null;
        this.kO = null;
        this.kV = null;
        this.kF = false;
        this.kR = 0;
        this.kQ = 1;
        this.kP = null;
        this.kH = "";
        this.kU = null;
        if (str != null && !str.equals("")) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject(com.easemob.chat.core.f.h);
                int parseInt = Integer.parseInt(jSONObject2.getString("error"));
                setLocType(parseInt);
                setTime(jSONObject2.getString("time"));
                JSONObject jSONObject3;
                if (parseInt == 61) {
                    jSONObject3 = jSONObject.getJSONObject("content");
                    jSONObject = jSONObject3.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject.getString(Config.EXCEPTION_TYPE)));
                    setLongitude(Double.parseDouble(jSONObject.getString(EMMultiUserConstant.MUC_ELEMENT_NAME)));
                    setRadius(Float.parseFloat(jSONObject3.getString(EaseConstant.EASEUI_IMAGEVIEW_RADIUS)));
                    setSpeed(Float.parseFloat(jSONObject3.getString("s")));
                    setDirection(Float.parseFloat(jSONObject3.getString("d")));
                    setSatelliteNumber(Integer.parseInt(jSONObject3.getString("n")));
                    if (jSONObject3.has("h")) {
                        try {
                            setAltitude(jSONObject3.getDouble("h"));
                        } catch (Exception e) {
                        }
                    }
                    try {
                        if (jSONObject3.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject3.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception e2) {
                    }
                    if (this.kQ == 0) {
                        setCoorType(CoordinateType.WGS84);
                    } else {
                        setCoorType(CoordinateType.GCJ02);
                    }
                } else if (parseInt == TypeNetWorkLocation) {
                    JSONObject jSONObject4 = jSONObject.getJSONObject("content");
                    jSONObject = jSONObject4.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject.getString(Config.EXCEPTION_TYPE)));
                    setLongitude(Double.parseDouble(jSONObject.getString(EMMultiUserConstant.MUC_ELEMENT_NAME)));
                    setRadius(Float.parseFloat(jSONObject4.getString(EaseConstant.EASEUI_IMAGEVIEW_RADIUS)));
                    if (jSONObject4.has("sema")) {
                        Object string;
                        jSONObject2 = jSONObject4.getJSONObject("sema");
                        if (jSONObject2.has("aptag")) {
                            string = jSONObject2.getString("aptag");
                            if (TextUtils.isEmpty(string)) {
                                this.kG = "";
                            } else {
                                this.kG = string;
                            }
                        }
                        if (jSONObject2.has("aptagd")) {
                            JSONArray jSONArray = jSONObject2.getJSONObject("aptagd").getJSONArray("pois");
                            List arrayList = new ArrayList();
                            for (int i = 0; i < jSONArray.length(); i++) {
                                JSONObject jSONObject5 = jSONArray.getJSONObject(i);
                                arrayList.add(new Poi(jSONObject5.getString("pid"), jSONObject5.getString("pname"), jSONObject5.getDouble(Config.PRINCIPAL_PART)));
                            }
                            this.kU = arrayList;
                        }
                        if (jSONObject2.has("poiregion")) {
                            string = jSONObject2.getString("poiregion");
                            if (!TextUtils.isEmpty(string)) {
                                this.kJ = string;
                            }
                        }
                        if (jSONObject2.has("regular")) {
                            string = jSONObject2.getString("regular");
                            if (!TextUtils.isEmpty(string)) {
                                this.kY = string;
                            }
                        }
                    }
                    if (jSONObject4.has(MessageEncoder.ATTR_ADDRESS)) {
                        String[] split = jSONObject4.getString(MessageEncoder.ATTR_ADDRESS).split(",");
                        int length = split.length;
                        String str3 = length > 0 ? split[0] : null;
                        String str4 = length > 1 ? split[1] : null;
                        String str5 = length > 2 ? split[2] : null;
                        String str6 = length > 3 ? split[3] : null;
                        String str7 = length > 4 ? split[4] : null;
                        String str8 = length > 5 ? split[5] : null;
                        String str9 = length > 6 ? split[6] : null;
                        if (length > 7) {
                            str2 = split[7];
                        }
                        this.kM = new Builder().country(str9).countryCode(str2).province(str3).city(str4).cityCode(str8).district(str5).street(str6).streetNumber(str7).build();
                        this.kT = true;
                    } else {
                        this.kT = false;
                        setAddrStr(null);
                    }
                    if (jSONObject4.has("floor")) {
                        this.kC = jSONObject4.getString("floor");
                        if (TextUtils.isEmpty(this.kC)) {
                            this.kC = null;
                        }
                    }
                    if (jSONObject4.has("loctp")) {
                        this.kP = jSONObject4.getString("loctp");
                        if (TextUtils.isEmpty(this.kP)) {
                            this.kP = null;
                        }
                    }
                    if (jSONObject4.has("bldgid")) {
                        this.kO = jSONObject4.getString("bldgid");
                        if (TextUtils.isEmpty(this.kO)) {
                            this.kO = null;
                        }
                    }
                    if (jSONObject4.has("bldg")) {
                        this.kV = jSONObject4.getString("bldg");
                        if (TextUtils.isEmpty(this.kV)) {
                            this.kV = null;
                        }
                    }
                    if (jSONObject4.has("ibav")) {
                        str2 = jSONObject4.getString("ibav");
                        if (TextUtils.isEmpty(str2)) {
                            this.kR = 0;
                        } else if (str2.equals("0")) {
                            this.kR = 0;
                        } else {
                            this.kR = Integer.valueOf(str2).intValue();
                        }
                    }
                    try {
                        if (jSONObject4.has("in_cn")) {
                            setLocationWhere(Integer.parseInt(jSONObject4.getString("in_cn")));
                        } else {
                            setLocationWhere(1);
                        }
                    } catch (Exception e3) {
                    }
                    if (this.kQ == 0) {
                        setCoorType(CoordinateType.WGS84);
                    } else {
                        setCoorType(CoordinateType.GCJ02);
                    }
                } else if (parseInt == 66 || parseInt == 68) {
                    jSONObject3 = jSONObject.getJSONObject("content");
                    jSONObject = jSONObject3.getJSONObject("point");
                    setLatitude(Double.parseDouble(jSONObject.getString(Config.EXCEPTION_TYPE)));
                    setLongitude(Double.parseDouble(jSONObject.getString(EMMultiUserConstant.MUC_ELEMENT_NAME)));
                    setRadius(Float.parseFloat(jSONObject3.getString(EaseConstant.EASEUI_IMAGEVIEW_RADIUS)));
                    if(Boolean.valueOf(Boolean.parseBoolean(jSONObject3.getString("isCellChanged"))));
                    setCoorType(CoordinateType.GCJ02);
                } else if (parseInt == TypeServerError) {
                    setLocationWhere(2);
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                this.kW = 0;
                this.kT = false;
            }
        }
    }

    private String dE() {
        return this.kJ;
    }

    private String dF() {
        return this.kH;
    }

    private String dG() {
        return this.kY;
    }

    private static String dH() {
        return Build.MODEL;
    }

    private void if(Boolean bool) {
        this.kL = bool.booleanValue();
    }

    public int describeContents() {
        return 0;
    }

    public String getAdUrl(String str) {
        String valueOf = String.valueOf(this.kB);
        String valueOf2 = String.valueOf(this.kX);
        String dF = dF();
        return "http://lba.baidu.com/" + "?a=" + Jni.E("ak=" + str + "&" + "lat=" + valueOf + "&" + "lng=" + valueOf2 + "&" + "cu=" + dF + "&" + "mb=" + dH());
    }

    public String getAddrStr() {
        return this.kM.address;
    }

    public Address getAddress() {
        return this.kM;
    }

    public double getAltitude() {
        return this.kK;
    }

    public String getBuildingID() {
        return this.kO;
    }

    public String getBuildingName() {
        return this.kV;
    }

    public String getCity() {
        return this.kM.city;
    }

    public String getCityCode() {
        return this.kM.cityCode;
    }

    public String getCoorType() {
        return this.k2;
    }

    public String getCountry() {
        return this.kM.country;
    }

    public String getCountryCode() {
        return this.kM.countryCode;
    }

    public float getDerect() {
        return this.kI;
    }

    public float getDirection() {
        return this.kI;
    }

    public String getDistrict() {
        return this.kM.district;
    }

    public String getFloor() {
        return this.kC;
    }

    public double getLatitude() {
        return this.kB;
    }

    public int getLocType() {
        return this.kW;
    }

    public String getLocationDescribe() {
        return this.kG;
    }

    public int getLocationWhere() {
        return this.kQ;
    }

    public double getLongitude() {
        return this.kX;
    }

    public String getNetworkLocationType() {
        return this.kP;
    }

    public int getOperators() {
        return this.k3;
    }

    public List getPoiList() {
        return this.kU;
    }

    public String getProvince() {
        return this.kM.province;
    }

    public float getRadius() {
        return this.kS;
    }

    public int getSatelliteNumber() {
        this.kZ = true;
        return this.kA;
    }

    public String getSemaAptag() {
        return this.kG;
    }

    public float getSpeed() {
        return this.k0;
    }

    public String getStreet() {
        return this.kM.street;
    }

    public String getStreetNumber() {
        return this.kM.streetNumber;
    }

    public String getTime() {
        return this.k1;
    }

    public boolean hasAddr() {
        return this.kT;
    }

    public boolean hasAltitude() {
        return this.kD;
    }

    public boolean hasRadius() {
        return this.kN;
    }

    public boolean hasSateNumber() {
        return this.kZ;
    }

    public boolean hasSpeed() {
        return this.kE;
    }

    public void internalSet(int i, String str) {
        if (str != null && i == 0) {
            this.kH = str;
        }
    }

    public boolean isCellChangeFlag() {
        return this.kL;
    }

    public boolean isIndoorLocMode() {
        return this.kF;
    }

    public int isParkAvailable() {
        return this.kR;
    }

    public void setAddr(Address address) {
        if (address != null) {
            this.kM = address;
            this.kT = true;
        }
    }

    public void setAddrStr(String str) {
        this.kz = str;
        if (str == null) {
            this.kT = false;
        } else {
            this.kT = true;
        }
    }

    public void setAltitude(double d) {
        this.kK = d;
        this.kD = true;
    }

    public void setBuildingID(String str) {
        this.kO = str;
    }

    public void setBuildingName(String str) {
        this.kV = str;
    }

    public void setCoorType(String str) {
        this.k2 = str;
    }

    public void setDirection(float f) {
        this.kI = f;
    }

    public void setFloor(String str) {
        this.kC = str;
    }

    public void setIndoorLocMode(boolean z) {
        this.kF = z;
    }

    public void setLatitude(double d) {
        this.kB = d;
    }

    public void setLocType(int i) {
        this.kW = i;
    }

    public void setLocationDescribe(String str) {
        this.kG = str;
    }

    public void setLocationWhere(int i) {
        this.kQ = i;
    }

    public void setLongitude(double d) {
        this.kX = d;
    }

    public void setNetworkLocationType(String str) {
        this.kP = str;
    }

    public void setOperators(int i) {
        this.k3 = i;
    }

    public void setParkAvailable(int i) {
        this.kR = i;
    }

    public void setPoiList(List list) {
        this.kU = list;
    }

    public void setRadius(float f) {
        this.kS = f;
        this.kN = true;
    }

    public void setSatelliteNumber(int i) {
        this.kA = i;
    }

    public void setSpeed(float f) {
        this.k0 = f;
        this.kE = true;
    }

    public void setTime(String str) {
        this.k1 = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.kW);
        parcel.writeString(this.k1);
        parcel.writeDouble(this.kB);
        parcel.writeDouble(this.kX);
        parcel.writeDouble(this.kK);
        parcel.writeFloat(this.k0);
        parcel.writeFloat(this.kS);
        parcel.writeInt(this.kA);
        parcel.writeFloat(this.kI);
        parcel.writeString(this.kC);
        parcel.writeInt(this.kR);
        parcel.writeString(this.kO);
        parcel.writeString(this.kV);
        parcel.writeString(this.kP);
        parcel.writeString(this.kM.province);
        parcel.writeString(this.kM.city);
        parcel.writeString(this.kM.district);
        parcel.writeString(this.kM.street);
        parcel.writeString(this.kM.streetNumber);
        parcel.writeString(this.kM.cityCode);
        parcel.writeString(this.kM.address);
        parcel.writeString(this.kM.country);
        parcel.writeString(this.kM.countryCode);
        parcel.writeInt(this.k3);
        parcel.writeString(this.kH);
        parcel.writeString(this.kG);
        parcel.writeString(this.kJ);
        parcel.writeString(this.kY);
        parcel.writeInt(this.kQ);
        parcel.writeBooleanArray(new boolean[]{this.kD, this.kE, this.kN, this.kZ, this.kT, this.kL, this.kF});
        parcel.writeList(this.kU);
    }
}
