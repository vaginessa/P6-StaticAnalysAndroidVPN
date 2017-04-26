package com.baidu.location.c;

import com.baidu.mobstat.Config;
import com.easemob.util.EMPrivateConstant.EMMultiUserConstant;
import gov.nist.core.Separators;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

enum o extends b {
    o(String str, int i, String str2, String str3, String str4, int i2, int i3) {
        super(str, i, str2, str3, str4, i2, i3);
    }

    List a(JSONObject jSONObject, String str, int i) {
        Iterator keys = jSONObject.keys();
        List arrayList = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        while (keys.hasNext()) {
            JSONArray jSONArray;
            JSONArray jSONArray2 = null;
            StringBuffer stringBuffer2 = new StringBuffer();
            String str2 = (String) keys.next();
            b.b(stringBuffer, str2, str, 0);
            try {
                jSONArray = jSONObject.getJSONArray(str2);
            } catch (JSONException e) {
                jSONArray = jSONArray2;
            }
            if (jSONArray != null) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    Object obj = null;
                    Object obj2 = null;
                    String str3 = null;
                    String str4 = null;
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        if (jSONObject2.has(Config.STAT_SDK_TYPE)) {
                            str3 = jSONObject2.getString(Config.STAT_SDK_TYPE);
                        }
                        if (jSONObject2.has("stn")) {
                            str4 = jSONObject2.getString("stn");
                        }
                        if (jSONObject2.has(EMMultiUserConstant.MUC_ELEMENT_NAME)) {
                            obj = Double.valueOf(jSONObject2.getDouble(EMMultiUserConstant.MUC_ELEMENT_NAME));
                        }
                        if (jSONObject2.has(Config.EXCEPTION_TYPE)) {
                            obj2 = Double.valueOf(jSONObject2.getDouble(Config.EXCEPTION_TYPE));
                        }
                        if (stringBuffer2.length() > 0) {
                            stringBuffer2.append(",");
                        }
                        stringBuffer2.append("(NULL,\"").append(str2).append("\",\"").append(str3).append("\",\"").append(str4).append("\",").append(obj).append(",").append(obj2).append(Separators.RPAREN);
                    } catch (JSONException e2) {
                    }
                    if (i2 % 50 == 49 && stringBuffer2.length() > 0) {
                        arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCSITE", stringBuffer2.toString()}));
                        stringBuffer2.setLength(0);
                    }
                }
                if (stringBuffer2.length() > 0) {
                    arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCSITE", stringBuffer2.toString()}));
                }
            }
        }
        if (stringBuffer.length() > 0) {
            arrayList.add(String.format(Locale.US, "INSERT OR REPLACE INTO %s VALUES %s", new Object[]{"RGCUPDATE", stringBuffer}));
        }
        arrayList.add(String.format(Locale.US, "DELETE FROM RGCSITE WHERE _id NOT IN (SELECT _id FROM RGCSITE LIMIT %d);", new Object[]{Integer.valueOf(i)}));
        return arrayList;
    }
}
