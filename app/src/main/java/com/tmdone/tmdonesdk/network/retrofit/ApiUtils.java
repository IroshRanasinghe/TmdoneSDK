package com.tmdone.tmdonesdk.network.retrofit;

import com.tmdone.tmdonesdk.BuildConfig;
import com.tmdone.tmdonesdk.network.service.apis.StoreApi;

import retrofit2.Retrofit;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:26 AM
 */
public class ApiUtils {

    private static final String BASE_URL = BuildConfig.API_URL;

    public static StoreApi storeApi() {
        return RetrofitClient.getClient(BASE_URL).create(StoreApi.class);
    }
}
