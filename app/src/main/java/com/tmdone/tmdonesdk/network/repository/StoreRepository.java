package com.tmdone.tmdonesdk.network.repository;

import android.util.Log;

import com.tmdone.tmdonesdk.network.retrofit.ApiUtils;
import com.tmdone.tmdonesdk.network.retrofit.HeaderInterceptor;
import com.tmdone.tmdonesdk.network.service.apis.StoreApi;
import com.tmdone.tmdonesdk.network.service.models.CommonPaginater;
import com.tmdone.tmdonesdk.network.service.models.IndividualProduct;
import com.tmdone.tmdonesdk.network.service.models.MenuResponse;
import com.tmdone.tmdonesdk.network.service.models.StoreCriteria;
import com.tmdone.tmdonesdk.network.service.models.StoreDetailsResponse;
import com.tmdone.tmdonesdk.network.service.models.StoreResponse;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 12:02 PM
 */
public class StoreRepository {
    private final StoreApi mStoreApi;

    public StoreRepository() {
        mStoreApi = ApiUtils.storeApi();
    }

    public Single<CommonPaginater<StoreResponse>> getStores(StoreCriteria storeCriteria) {
        return mStoreApi.getStore(HeaderInterceptor.getHeaders(), storeCriteria);
    }

    public Single<MenuResponse> getMenu(String storeId, boolean isPickup) {
        return mStoreApi.getMenu(HeaderInterceptor.getHeaders(),storeId, isPickup);
    }

    public Single<StoreDetailsResponse> getStoreInfo(@NonNull String storeId, double latitude, double longitude, boolean isPickUp) {
        return mStoreApi.getStoreInfo(HeaderInterceptor.getHeaders(),storeId, latitude, longitude, isPickUp);
    }

    public Single<IndividualProduct> getFoodProduct(String storeId, String menuId, boolean isPickup) {
        return mStoreApi.getFoodProductDetails(HeaderInterceptor.getHeaders(),storeId, menuId, isPickup);
    }
}
