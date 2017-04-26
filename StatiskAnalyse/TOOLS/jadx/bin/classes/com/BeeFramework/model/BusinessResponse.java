package com.BeeFramework.model;

import com.external.androidquery.callback.AjaxStatus;
import org.json.JSONException;
import org.json.JSONObject;

public interface BusinessResponse {
    void OnMessageResponse(String str, JSONObject jSONObject, AjaxStatus ajaxStatus) throws JSONException;
}
