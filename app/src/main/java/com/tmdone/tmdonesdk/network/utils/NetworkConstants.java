package com.tmdone.tmdonesdk.network.utils;

import com.tmdone.tmdonesdk.BuildConfig;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:49 AM
 */
public class NetworkConstants {
    // Network Response codes
    public final static int RESPONSE_UNAUTHORIZED = 401;
    public final static int RESPONSE_BAD_REQUEST = 400;
    public final static int RESPONSE_NOT_FOUND = 404;
    public final static int RESPONSE_INTERNAL_SERVER_ERROR = 500;


    // API Header Keys
    public final static String HEADER_DEVICE_TYPE = "DeviceType";
    public final static String HEADER_APP_NAME = "AppName";
    public final static String HEADER_APP_VERSION = "AppVersion";
    public final static String HEADER_DEVICE_MANUFACTURER = "DeviceMake";
    public final static String HEADER_DEVICE_MODEL = "DeviceModel";
    public final static String HEADER_OS_VERSION = "DeviceOsVersion";
    public final static String HEADER_LANGUAGE = "lang";
    public final static String HEADER_BEARER_KEY = "Bearer ";
    public final static String HEADER_AUTHORIZATION = "Authorization";


    // API Header values
    public final static String HEADER_DEVICE_TYPE_VALUE = "ANDROID";
    public final static String HEADER_APP_NAME_VALUE = "TMDONE";
    public final static String HEADER_LANGUAGE_VALUE_EN = "en";
    public final static String HEADER_LANGUAGE_VALUE_AR = "ar";
}
