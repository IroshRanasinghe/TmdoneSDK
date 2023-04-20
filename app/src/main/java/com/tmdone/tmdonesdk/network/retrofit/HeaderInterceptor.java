package com.tmdone.tmdonesdk.network.retrofit;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_APP_NAME;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_APP_NAME_VALUE;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_APP_VERSION;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_DEVICE_MANUFACTURER;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_DEVICE_MODEL;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_DEVICE_TYPE;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_DEVICE_TYPE_VALUE;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_LANGUAGE;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_LANGUAGE_VALUE_AR;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_LANGUAGE_VALUE_EN;
import static com.tmdone.tmdonesdk.network.utils.NetworkConstants.HEADER_OS_VERSION;

import android.os.Build;
import android.util.Log;

import com.google.gson.Gson;
import com.tmdone.tmdonesdk.BuildConfig;

import java.util.HashMap;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 11:07 AM
 */
public class HeaderInterceptor {

    private static HashMap<String, String> mHeaderMap;
    private static final String mDeviceManufacture = android.os.Build.MANUFACTURER;
    private static final String mDeviceModel = android.os.Build.MODEL;
    private static final String mDeviceOsVersion = Build.VERSION.RELEASE;

    public static HashMap<String, String> getHeaders() {
        if (mHeaderMap == null) {
            mHeaderMap = new HashMap<>();
            mHeaderMap.put(HEADER_DEVICE_TYPE, HEADER_DEVICE_TYPE_VALUE);
            mHeaderMap.put(HEADER_APP_NAME, HEADER_APP_NAME_VALUE);
            mHeaderMap.put(HEADER_APP_VERSION, "2.2.2");
            if (mDeviceManufacture != null)
                mHeaderMap.put(HEADER_DEVICE_MANUFACTURER, android.os.Build.MANUFACTURER);

            if (mDeviceModel != null)
                mHeaderMap.put(HEADER_DEVICE_MODEL, android.os.Build.MODEL);

            if (mDeviceOsVersion != null)
                mHeaderMap.put(HEADER_OS_VERSION, Build.VERSION.RELEASE);

        }
        if (CONST_IS_USER_LANGUAGE_AR) {
            mHeaderMap.put(HEADER_LANGUAGE, HEADER_LANGUAGE_VALUE_AR);
        } else {
            mHeaderMap.put(HEADER_LANGUAGE, HEADER_LANGUAGE_VALUE_EN);
        }

        Log.e(TAG, "TAXI HEADERS : " + new Gson().toJson(mHeaderMap));
        return mHeaderMap;
    }

}
