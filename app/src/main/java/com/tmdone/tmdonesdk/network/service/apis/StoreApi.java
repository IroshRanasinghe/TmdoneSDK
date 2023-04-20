package com.tmdone.tmdonesdk.network.service.apis;

import com.tmdone.tmdonesdk.network.service.models.CommonPaginater;
import com.tmdone.tmdonesdk.network.service.models.StoreCriteria;
import com.tmdone.tmdonesdk.network.service.models.StoreResponse;

import java.util.Map;

import io.reactivex.rxjava3.core.Single;
import okhttp3.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:37 AM
 */
public interface StoreApi {
    @POST("api/stores/list")
    Single<CommonPaginater<StoreResponse>> getStore(
            @HeaderMap Map<String, String> headers,
            @Body StoreCriteria storeCriteria
    );
}
