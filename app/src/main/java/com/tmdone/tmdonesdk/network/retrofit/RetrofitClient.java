package com.tmdone.tmdonesdk.network.retrofit;


import android.util.Log;

import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:07 AM
 */
public class RetrofitClient {

    private static final int timeout = 20;
    private static Retrofit retrofitClient = null;

    public static Retrofit getClient(String baseUrl) {

        if (retrofitClient == null) {

            retrofitClient = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().serializeNulls().setLenient().create()))
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofitClient;
    }

}
