package com.tmdone.tmdonesdk.network.repository;

import com.tmdone.tmdonesdk.network.retrofit.ApiUtils;
import com.tmdone.tmdonesdk.network.retrofit.HeaderInterceptor;
import com.tmdone.tmdonesdk.network.service.apis.StoreApi;
import com.tmdone.tmdonesdk.network.service.models.CommonPaginater;
import com.tmdone.tmdonesdk.network.service.models.StoreCriteria;
import com.tmdone.tmdonesdk.network.service.models.StoreResponse;

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
}
