package com.tmdone.tmdonesdk.network.service.apis;

import com.tmdone.tmdonesdk.network.service.models.CommonPaginater;
import com.tmdone.tmdonesdk.network.service.models.IndividualProduct;
import com.tmdone.tmdonesdk.network.service.models.MenuResponse;
import com.tmdone.tmdonesdk.network.service.models.StoreCriteria;
import com.tmdone.tmdonesdk.network.service.models.StoreDetailsResponse;
import com.tmdone.tmdonesdk.network.service.models.StoreResponse;

import java.util.Map;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @POST("api/stores/info")
    Single<StoreDetailsResponse> getStoreInfo(
            @HeaderMap Map<String, String> headers,
            @Query("storeId") String storeId,
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Query("isPickup") boolean isPickup
    );

    @POST("api/menutem/find")
    Single<MenuResponse> getMenu(
            @HeaderMap Map<String, String> headers, @Query("storeId") String storeId, @Query("isPickup") boolean isPickup);

    @POST("api/menutem/findOne")
    Single<IndividualProduct> getFoodProductDetails(
            @HeaderMap Map<String, String> headers,
            @Query("storeId") String id,
            @Query("menuItemId") String menuItemId,
            @Query("isPickup") boolean isPickup
    );
}
