package com.baidu.location.f.a;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import gov.nist.core.Separators;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.UUID;

public final class b {
    private static final boolean a = false;
    private static final String do = "DeviceId";
    private static final String for = "30212102dicudiab";
    private static final String if = "baidu/.cuid";
    private static final String int = "com.baidu.deviceid";

    static final class a {
        public final String a;
        public final boolean b;

        private a(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        static a a(Context context) {
            boolean z;
            boolean z2 = true;
            String str = "";
            try {
                str = System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(str)) {
                    str = a(context, "");
                }
                System.putString(context.getContentResolver(), "bd_setting_i", str);
                z = false;
            } catch (Exception e) {
                Log.d(b.do, "Settings.System.getString or putString failed");
                if (TextUtils.isEmpty(str)) {
                    str = a(context, "");
                    z = true;
                } else {
                    z = true;
                }
            }
            if (z) {
                z2 = false;
            }
            return new a(str, z2);
        }

        private static String a(Context context, String str) {
            CharSequence deviceId;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                    return TextUtils.isEmpty(deviceId) ? str : deviceId;
                }
            } catch (Throwable e) {
                Log.e(b.do, "Read IMEI failed", e);
            }
            deviceId = null;
            if (TextUtils.isEmpty(deviceId)) {
            }
        }
    }

    private b() {
    }

    public static String a(Context context) {
        a(context, "android.permission.WRITE_SETTINGS");
        a(context, "android.permission.READ_PHONE_STATE");
        a(context, "android.permission.WRITE_EXTERNAL_STORAGE");
        a a = a.a(context);
        String str = a.a;
        boolean z = !a.b;
        String str2 = if(context);
        String str3 = "";
        if (z) {
            return c.a(("com.baidu" + str2).getBytes(), true);
        }
        String str4 = null;
        Object string = System.getString(context.getContentResolver(), int);
        if (TextUtils.isEmpty(string)) {
            str4 = c.a(("com.baidu" + str + str2).getBytes(), true);
            string = System.getString(context.getContentResolver(), str4);
            if (!TextUtils.isEmpty(string)) {
                System.putString(context.getContentResolver(), int, string);
                a(str, (String) string);
            }
        }
        if (TextUtils.isEmpty(string)) {
            string = a(str);
            if (!TextUtils.isEmpty(string)) {
                System.putString(context.getContentResolver(), str4, string);
                System.putString(context.getContentResolver(), int, string);
            }
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        str3 = c.a((str + str2 + UUID.randomUUID().toString()).getBytes(), true);
        System.putString(context.getContentResolver(), str4, str3);
        System.putString(context.getContentResolver(), int, str3);
        a(str, str3);
        return str3;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = "";
        try {
            Reader fileReader = new FileReader(new File(Environment.getExternalStorageDirectory(), if));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
                stringBuilder.append(Separators.NEWLINE);
            }
            bufferedReader.close();
            fileReader.close();
            String[] split = new String(com.baidu.location.f.b.a.a(for, for, com.baidu.location.f.b.b.a(stringBuilder.toString().getBytes()))).split(Separators.EQUALS);
            return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : str2;
        } catch (FileNotFoundException e) {
            return str2;
        } catch (IOException e2) {
            return str2;
        } catch (Exception e3) {
            return str2;
        }
    }

    private static void a(Context context, String str) {
        if ((context.checkCallingOrSelfPermission(str) == 0 ? 1 : null) == null) {
            try {
                throw new SecurityException("Permission Denial: requires permission " + str);
            } catch (Exception e) {
            }
        }
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(Separators.EQUALS);
            stringBuilder.append(str2);
            File file = new File(Environment.getExternalStorageDirectory(), if);
            try {
                new File(file.getParent()).mkdirs();
                FileWriter fileWriter = new FileWriter(file, false);
                fileWriter.write(com.baidu.location.f.b.b.a(com.baidu.location.f.b.a.if(for, for, stringBuilder.toString().getBytes()), "utf-8"));
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
            } catch (Exception e2) {
            }
        }
    }

    public static String do(Context context) {
        return a.a(context).a;
    }

    public static String if(Context context) {
        String str = "";
        Object string = Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }
}
