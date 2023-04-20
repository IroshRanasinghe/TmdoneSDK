package com.tmdone.tmdonesdk.network.viewmodel;

import static com.tmdone.tmdonesdk.app.utility.PaginationListener.PAGE_START;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.google.gson.reflect.TypeToken;
import com.tmdone.tmdonesdk.app.uimodels.Store;
import com.tmdone.tmdonesdk.app.utility.CommonHelpers;
import com.tmdone.tmdonesdk.network.repository.StoreRepository;
import com.tmdone.tmdonesdk.network.retrofit.ErrorHandler;
import com.tmdone.tmdonesdk.network.service.models.CommonPaginater;
import com.tmdone.tmdonesdk.network.service.models.StoreCriteria;
import com.tmdone.tmdonesdk.network.service.models.StoreResponse;
import com.tmdone.tmdonesdk.network.state_model.StateLiveData;

import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 12:29 PM
 */
public class StoreViewModel extends AndroidViewModel {
    private  StoreRepository mStoreRepository;
    public StateLiveData<List<Store>> storeListLiveDataResponse;

    private  ErrorHandler mErrorHandler;

    public boolean isLoading = false;
    public int currentPage = PAGE_START;
    public int totalPage = 0;
    public int totalItemCount = 0;
    int itemCount = 0;
    private final CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    public StoreViewModel(@NonNull Application application) {
        super(application);
        mStoreRepository = new StoreRepository();
        mErrorHandler = new ErrorHandler(application);
        initLiveData();
    }

    private void initLiveData() {
        storeListLiveDataResponse = new StateLiveData<>();
    }

    public void getStoreList(@NonNull String sectorCode,
                             String keyWord,
                             String brandCode,
                             boolean isFeatured,
                             boolean isPickup,
                             List<String> cuisines,
                             List<String> vendorTypes,
                             List<String> attributes,
                             @NonNull List<Double> nearByCords,
                             @Nullable String chainId,
                             String sortBy) {
        StoreCriteria storeCriteria = new StoreCriteria();

        storeCriteria.setSector(sectorCode);
        storeCriteria.setKeyword(keyWord);
        storeCriteria.setBrandCode(brandCode);
        storeCriteria.setFeatured(isFeatured);
        storeCriteria.setCuisines(cuisines);
        storeCriteria.setVendorTypes(vendorTypes);
        storeCriteria.setAttributes(attributes);
        storeCriteria.setPage(currentPage);
        storeCriteria.setChainId(chainId);
        storeCriteria.setNearByCords(nearByCords);
        storeCriteria.setSortBy(sortBy);
        storeCriteria.setSpecial(false);
        storeCriteria.setPickup(isPickup);

        Single<List<Store>> singleFetchStoreList = mStoreRepository.getStores(storeCriteria).retry((integer, throwable) -> {
            return throwable instanceof SocketTimeoutException;
        }).map(new Function<CommonPaginater<StoreResponse>, List<Store>>() {
            @Override
            public List<Store> apply(CommonPaginater<StoreResponse> commonPaginatedStoreListResponse) throws Throwable {
                extractPaginationData(commonPaginatedStoreListResponse);
                String storeListJsonString = CommonHelpers.getGsonDecoderWithNanValueHandler().toJson(commonPaginatedStoreListResponse.getItems());
                return CommonHelpers.getGsonDecoderWithNanValueHandler().fromJson(storeListJsonString, new TypeToken<List<Store>>() {
                }.getType());
            }
        });


        DisposableSingleObserver<List<Store>> disposableSingleObserverForFetchingStoreList = singleFetchStoreList.subscribeWith(new DisposableSingleObserver<List<Store>>() {
            @Override
            protected void onStart() {
                isLoading = true;
                storeListLiveDataResponse.postLoading();
                super.onStart();
            }

            @Override
            public void onSuccess(@NonNull List<Store> storeList) {
                isLoading = false;
                storeListLiveDataResponse.postSuccess(storeList);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                isLoading = false;
                storeListLiveDataResponse.postError(mErrorHandler.getError(e));
            }
        });
        mCompositeDisposable.add(disposableSingleObserverForFetchingStoreList);
    }

    private void extractPaginationData(CommonPaginater<StoreResponse> commonPaginate) {
        currentPage = commonPaginate.getPageNumber();
        totalPage = commonPaginate.getPageCount();
        totalItemCount = commonPaginate.getTotalItemCount();
    }

    public void clearDisposables() {
        mCompositeDisposable.clear();
    }
    @Override
    protected void onCleared() {
        clearDisposables();
        super.onCleared();
    }
}
