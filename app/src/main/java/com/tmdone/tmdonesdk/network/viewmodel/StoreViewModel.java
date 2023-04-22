package com.tmdone.tmdonesdk.network.viewmodel;

import static com.tmdone.tmdonesdk.app.utility.PaginationListener.PAGE_START;

import android.app.Application;



import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.google.gson.reflect.TypeToken;
import com.tmdone.tmdonesdk.app.uimodels.Menu;
import com.tmdone.tmdonesdk.app.uimodels.Store;
import com.tmdone.tmdonesdk.app.uimodels.StoreDetails;
import com.tmdone.tmdonesdk.app.utility.CommonHelpers;
import com.tmdone.tmdonesdk.network.repository.StoreRepository;
import com.tmdone.tmdonesdk.network.retrofit.ErrorHandler;
import com.tmdone.tmdonesdk.network.service.models.CommonPaginater;
import com.tmdone.tmdonesdk.network.service.models.IndividualProduct;
import com.tmdone.tmdonesdk.network.service.models.MenuResponse;
import com.tmdone.tmdonesdk.network.service.models.StoreCriteria;
import com.tmdone.tmdonesdk.network.service.models.StoreDetailsResponse;
import com.tmdone.tmdonesdk.network.service.models.StoreResponse;
import com.tmdone.tmdonesdk.network.state_model.StateLiveData;

import java.net.SocketTimeoutException;
import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 12:29 PM
 */
public class StoreViewModel extends AndroidViewModel {
    private  StoreRepository mStoreRepository;
    public StateLiveData<List<Store>> storeListLiveDataResponse;
    public StateLiveData<Menu> menuLiveDataResponse;
    public StateLiveData<StoreDetails> storeDetailsStateLiveDataResponse;
    public StateLiveData<IndividualProduct> individualProductStateLiveData;

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
        menuLiveDataResponse = new StateLiveData<>();
        storeDetailsStateLiveDataResponse = new StateLiveData<>();
        individualProductStateLiveData = new StateLiveData<>();
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

    public void getMenu(String storeId) {
        mStoreRepository.getMenu(storeId,false).retry((integer, throwable) -> {
            return throwable instanceof SocketTimeoutException;
        }).map(new Function<MenuResponse, Menu>() {
            @Override
            public Menu apply(MenuResponse menuResponse) throws Throwable {
                String menuItemJsonString = CommonHelpers.getGsonDecoderWithNanValueHandler().toJson(menuResponse);
                return CommonHelpers.getGsonDecoderWithNanValueHandler().fromJson(menuItemJsonString, new TypeToken<Menu>() {

                }.getType());
            }
        }).subscribe(new SingleObserver<Menu>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                menuLiveDataResponse.postLoading();
            }

            @Override
            public void onSuccess(@NonNull Menu menu) {
                menuLiveDataResponse.postSuccess(menu);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                menuLiveDataResponse.postError(mErrorHandler.getError(e));
            }
        });
    }

    public void getStoreInfo(@NonNull String storeId, @Nullable double latitude, @Nullable double longitude, boolean isPickUp) {
        mStoreRepository.getStoreInfo(storeId, latitude, longitude, isPickUp).retry((integer, throwable) -> {
            return throwable instanceof SocketTimeoutException;
        }).map(new Function<StoreDetailsResponse, StoreDetails>() {
            @Override
            public StoreDetails apply(StoreDetailsResponse storeDetailsResponse) throws Throwable {
                String storeDetailsJsonString = CommonHelpers.getGsonDecoderWithNanValueHandler().toJson(storeDetailsResponse);
                return CommonHelpers.getGsonDecoderWithNanValueHandler().fromJson(storeDetailsJsonString, new TypeToken<StoreDetails>() {

                }.getType());
            }
        }).subscribe(new SingleObserver<StoreDetails>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                storeDetailsStateLiveDataResponse.postLoading();
            }

            @Override
            public void onSuccess(@NonNull StoreDetails storeDetails) {
                storeDetailsStateLiveDataResponse.postSuccess(storeDetails);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                storeDetailsStateLiveDataResponse.postError(mErrorHandler.getError(e));
            }
        });
    }

    public void getFoodItem(String storeId, String productId, boolean isPickup) {
        mStoreRepository.getFoodProduct(storeId, productId, isPickup).retry((integer, throwable) -> {
            return throwable instanceof SocketTimeoutException;
        }).subscribe(new SingleObserver<IndividualProduct>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                individualProductStateLiveData.postLoading();
            }

            @Override
            public void onSuccess(@NonNull IndividualProduct individualProduct) {
                individualProductStateLiveData.postSuccess(individualProduct);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                individualProductStateLiveData.postError(mErrorHandler.getError(e));
            }
        });
    }
}
