package com.alipay.apmobilesecuritysdk.http;

import com.alipay.tscenter.biz.rpc.vkeydfp.request.DeviceDataReportRequest;
import com.alipay.tscenter.biz.rpc.vkeydfp.result.DeviceDataReportResult;

public interface a {
    DeviceDataReportResult a(DeviceDataReportRequest deviceDataReportRequest);

    boolean a(String str);
}
