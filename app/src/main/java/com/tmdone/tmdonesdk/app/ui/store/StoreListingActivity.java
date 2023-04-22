package com.tmdone.tmdonesdk.app.ui.store;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static com.tmdone.tmdonesdk.app.utility.PaginationListener.PAGE_START;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_IS_PICKUP_ORDER;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_IS_STORE_FAVOURITE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_LATITUDE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_LONGITUDE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_SELECTED_STORE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_STORE_LIST_CURRENT_POSITION;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.tmdone.tmdonesdk.R;
import com.tmdone.tmdonesdk.app.ui.store.StoreAdapter;
import com.tmdone.tmdonesdk.app.uimodels.Store;
import com.tmdone.tmdonesdk.app.utility.PaginationListener;
import com.tmdone.tmdonesdk.databinding.ActivityStoreListingBinding;
import com.tmdone.tmdonesdk.network.state_model.StateData;
import com.tmdone.tmdonesdk.network.viewmodel.StoreViewModel;

import java.util.ArrayList;
import java.util.List;

public class StoreListingActivity extends AppCompatActivity {

    private ActivityStoreListingBinding mBinding;
    StoreViewModel mRestaurantViewModel;
    private ArrayList<String> mSelectedCuisineCodeList;
    private ArrayList<String> mSelectedVendorTypesCodeList;
    private ArrayList<String> mSelectedAttributeCodeList;
    private String mChainId;

    private String mSelectedSortAttributeCode;
    private StoreAdapter mStoreAdapter;

    private List<Double> mNearByCode;

    ActivityResultLauncher<Intent> mIndividualStoreForForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    if (result.getData().hasExtra(BUNDLE_STORE_LIST_CURRENT_POSITION) && result.getData().hasExtra(BUNDLE_IS_STORE_FAVOURITE)) {
                        int mCurrentAdapterPosition = result.getData().getExtras().getInt(BUNDLE_STORE_LIST_CURRENT_POSITION);
                        if (mCurrentAdapterPosition > 0) {
                            boolean isFavorite = result.getData().getExtras().getBoolean(BUNDLE_IS_STORE_FAVOURITE);
                            mStoreAdapter.makeFavouriteBatch(mCurrentAdapterPosition, isFavorite);
                        }
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_store_listing);

        readArguments();
        setupRestaurantRecyclerView(false);
        setupViewModel();
        setupObservers();
        makeLoadStoreRequest();
    }

    private void readArguments() {
        mNearByCode = new ArrayList<>();
        mNearByCode.add(79.85656041651964);
        mNearByCode.add(6.910773629147182);

        mSelectedCuisineCodeList = new ArrayList<>();
        mSelectedVendorTypesCodeList = new ArrayList<>();
        mSelectedAttributeCodeList = new ArrayList<>();
    }

    private void setupViewModel() {
        mRestaurantViewModel = new ViewModelProvider(this).get(StoreViewModel.class);
    }

    private void setupRestaurantRecyclerView(boolean isPickup) {
        mStoreAdapter = new StoreAdapter(this, isPickup);
        LinearLayoutManager layoutManagerStore = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        mBinding.recyclerRestaurant.setLayoutManager(layoutManagerStore);
        mBinding.recyclerRestaurant.setHasFixedSize(true);
        mBinding.recyclerRestaurant.setAdapter(mStoreAdapter);
        attachPagination(layoutManagerStore);

        attachStoreAdapterListener();
    }

    private void setupSwipeRefresh() {
        mBinding.swipeRefreshLayout.setOnRefreshListener(this::onScreenRefresh);
        mBinding.swipeRefreshLayout.setColorSchemeResources(
                R.color.colorMinsk,
                R.color.colorGigas,
                R.color.colorSilverChalice,
                R.color.colorWhite);
        mBinding.swipeRefreshLayout.setRefreshing(false);
    }
    private void onScreenRefresh() {
        mBinding.swipeRefreshLayout.setRefreshing(false);
        mRestaurantViewModel.currentPage = PAGE_START;
        if (mStoreAdapter != null) {
            mStoreAdapter.clear();
        }

        makeLoadStoreRequest();
    }
    private void attachPagination(LinearLayoutManager linearLayoutManager) {
        mBinding.recyclerRestaurant.addOnScrollListener(new PaginationListener(linearLayoutManager) {
            @Override
            protected void loadMoreItems() {
                mRestaurantViewModel.currentPage++;
                makeLoadStoreRequest();
            }

            @Override
            public boolean isLastPage() {
                return mRestaurantViewModel.currentPage == mRestaurantViewModel.totalPage;
            }

            @Override
            public boolean isLoading() {
                return mRestaurantViewModel.isLoading;
            }
        });

    }

    private void attachStoreAdapterListener() {
        mStoreAdapter.setOnRestaurantClickListener((store, position) -> {
            navigateToDetailStoreView(position, store);
        });

    }

    private void navigateToDetailStoreView(int adapterPosition, Store store) {
        Intent intent =new Intent(StoreListingActivity.this,IndividualStoreActivity.class);
        intent.putExtra(BUNDLE_SELECTED_STORE, store);
        intent.putExtra(BUNDLE_STORE_LIST_CURRENT_POSITION, adapterPosition);
        intent.putExtra(BUNDLE_IS_STORE_FAVOURITE, store.getFavourite());
        intent.putExtra(BUNDLE_IS_PICKUP_ORDER, false);
        intent.putExtra(BUNDLE_LATITUDE, mNearByCode.get(1));
        intent.putExtra(BUNDLE_LONGITUDE, mNearByCode.get(0));
        mIndividualStoreForForResult.launch(intent);
    }

    private void makeLoadStoreRequest() {
        mRestaurantViewModel.getStoreList("FOOD",
                "",
                "",
                false,
                false,
                mSelectedCuisineCodeList,
                mSelectedVendorTypesCodeList,
                mSelectedAttributeCodeList,
                mNearByCode,
                mChainId,
                ""
        );
    }

    private void setupObservers() {
        mRestaurantViewModel.storeListLiveDataResponse.observe(this, this::observeGetStoresRequest);
    }

    private void observeGetStoresRequest(StateData<List<Store>> storeListStateData) {
        switch (storeListStateData.getStatus()) {
            case LOADING: {
                showLoadingAccordingly();
                break;
            }
            case SUCCESS: {
                mBinding.swipeRefreshLayout.setRefreshing(false);
                stopLoadingStores();
                if (storeListStateData.getData() != null) {
                    Log.e(TAG, "observeGetStoresRequest: " + new Gson().toJson(storeListStateData.getData()));
                    populateStoreRecycleView(storeListStateData.getData());
                }
                break;
            }

            case ERROR: {
//                dismissProgressDialog();
//                stopLoadingStores();
//                if (storeListStateData.getError() != null)
//                    showApiErrorDialog(storeListStateData.getError());
                break;
            }
        }
    }

    private void populateStoreRecycleView(List<Store> storeList) {
        if (!storeList.isEmpty()) {
            HideEmptyStoreRecycleViewPlaceHolder(true);
            mStoreAdapter.setData(storeList);
        } else {
            HideEmptyStoreRecycleViewPlaceHolder(false);
        }
    }


    private void showLoadingAccordingly() {
        if (mRestaurantViewModel.currentPage > 1) {
//            showProgressDialog();
        } else {
            HideEmptyStoreRecycleViewPlaceHolder(true);
            startShimmer();
        }
    }

    private void HideEmptyStoreRecycleViewPlaceHolder(boolean isHide) {
        if (isHide) {
            mBinding.constraintLayoutEmptyView.setVisibility(View.GONE);
        } else {
            mBinding.constraintLayoutEmptyView.setVisibility(View.VISIBLE);

        }
    }

    private void startShimmer() {
        mBinding.shimmerRestaurant.startShimmer();
        mBinding.shimmerRestaurant.setVisibility(View.VISIBLE);
    }
    private void stopLoadingStores() {
        stopRestaurantShimmerEffect();
        makeStoreRecycleViewVisible();
    }

    private void stopRestaurantShimmerEffect() {
        mBinding.shimmerRestaurant.stopShimmer();
        mBinding.shimmerRestaurant.setVisibility(View.GONE);
    }

    private void makeStoreRecycleViewVisible() {
        mBinding.recyclerRestaurant.setVisibility(View.VISIBLE);
    }

}