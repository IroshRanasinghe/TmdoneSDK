package com.tmdone.tmdonesdk.app.ui.store;

import static com.tmdone.tmdonesdk.app.utility.DoubleUtility.formateDouble;
import static com.tmdone.tmdonesdk.app.utility.DoubleUtility.getFormattedAsCurrency;
import static com.tmdone.tmdonesdk.app.utility.DoubleUtility.getFormattedAsTwoDecimalsWithoutLocale;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_IS_PICKUP_ORDER;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_IS_STORE_FAVOURITE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_LATITUDE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_LONGITUDE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_SELECTED_STORE;
import static com.tmdone.tmdonesdk.core.Constants.BUNDLE_STORE_LIST_CURRENT_POSITION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.tmdone.tmdonesdk.R;
import com.tmdone.tmdonesdk.app.uimodels.Cuisine;
import com.tmdone.tmdonesdk.app.uimodels.FoodItem;
import com.tmdone.tmdonesdk.app.uimodels.Menu;
import com.tmdone.tmdonesdk.app.uimodels.MenuCategory;
import com.tmdone.tmdonesdk.app.uimodels.SingleRestaurantItem;
import com.tmdone.tmdonesdk.app.uimodels.SingleRestaurantItemContent;
import com.tmdone.tmdonesdk.app.uimodels.SingleRestaurantItemHeader;
import com.tmdone.tmdonesdk.app.uimodels.Store;
import com.tmdone.tmdonesdk.app.uimodels.StoreDetails;
import com.tmdone.tmdonesdk.app.utility.CommonHelpers;
import com.tmdone.tmdonesdk.app.utility.ExtenstionMethods;
import com.tmdone.tmdonesdk.databinding.ActivityIndividualStoreBinding;
import com.tmdone.tmdonesdk.network.service.models.IndividualProduct;
import com.tmdone.tmdonesdk.network.state_model.StateData;
import com.tmdone.tmdonesdk.network.viewmodel.StoreViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IndividualStoreActivity extends AppCompatActivity {

    private ActivityIndividualStoreBinding mBinding;
    StoreViewModel mRestaurantViewModel;
    private Menu menu;
    private List<SingleRestaurantItemHeader> mSingleItemHeaders;
    private ArrayList<SingleRestaurantItem> mRestaurantSingleItems, mAllItems;
    private ArrayList<String> mMenuList;
    private boolean isDataAvailable = false;
    private Store mStore;
    private IndividualRestaurantAdapter mIndividualRestaurantAdapter;
    private boolean mIsPickupOrder;

    private double mLatitude, mLongitude;
    private int mCurrentAdapterPosition;
    private boolean isFavorite;
    private boolean isUserScrolling = false;

    private boolean mIsIndividualProductDialogShowing = false;
    private StoreDetails mStoreDetails;
    private boolean mHasUserChangeOrderTypeChanged = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readArguments();
        bindUI();
        setupTabView();
        setupSwipeRefresh();
        setupViewModel();
        setupObservers();
        setupRecyclerviewScrolling();
        makeLoadMenuRequest();
        makeLoadStoreInfoRequest();
        setStoreInfo();
        attachListener();
    }

    private void attachListener() {
        mBinding.imageBack.setOnClickListener(v -> {
            finish();
        });

        mBinding.imageShare.setOnClickListener(v -> {

        });


        mBinding.imageBackInCollapse.setOnClickListener(v -> {

            finish();
        });


    }

    private void bindUI() {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_individual_store);
        mBinding.setLifecycleOwner(this);
        executeDataBindingOnUi();
        setupSwipeRefresh();
        mBinding.tabMenu.setTabMode(TabLayout.MODE_SCROLLABLE);
        mMenuList = new ArrayList<>();
        mSingleItemHeaders = new ArrayList<>();
    }

    private void readArguments() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mStore = (Store) extras.get(BUNDLE_SELECTED_STORE);
        }


        if (getIntent().hasExtra(BUNDLE_STORE_LIST_CURRENT_POSITION)) {
            mCurrentAdapterPosition = getIntent().getExtras().getInt(BUNDLE_STORE_LIST_CURRENT_POSITION);
        }

        if (getIntent().hasExtra(BUNDLE_IS_STORE_FAVOURITE)) {
            isFavorite = getIntent().getExtras().getBoolean(BUNDLE_IS_STORE_FAVOURITE);
        }

        if (getIntent().hasExtra(BUNDLE_LATITUDE)) {
            mLatitude = getIntent().getExtras().getDouble(BUNDLE_LATITUDE);
        }
        if (getIntent().hasExtra(BUNDLE_LONGITUDE)) {
            mLongitude = getIntent().getExtras().getDouble(BUNDLE_LONGITUDE);
        }

//        if (getIntent().hasExtra(BUNDLE_TARGET_AUDIENCE_OFFER_DISPLAY_TIME)) {
//            mOfferDisplayTime = getIntent().getExtras().getInt(BUNDLE_TARGET_AUDIENCE_OFFER_DISPLAY_TIME);
//        }
    }
    private void executeDataBindingOnUi() {
        mBinding.setRestaurant(mStore);
        mBinding.executePendingBindings();
    }

    private void setupRecyclerviewScrolling() {
        mBinding.recyclerFood.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy != 0) {

                    if (mRestaurantSingleItems.size() == 0) {
                        return;
                    }

                    isUserScrolling = true;
                    int position = ((LinearLayoutManager) mBinding.recyclerFood.getLayoutManager()).findFirstVisibleItemPosition();
                    String name = mIndividualRestaurantAdapter.getCurrentName(recyclerView, position);

                    if (isUserScrolling) {
                        if (name != null && !name.equalsIgnoreCase("")) {
                            if (mMenuList.contains(name)) {
                                int tabName = mMenuList.indexOf(name);
                                TabLayout.Tab tab = mBinding.tabMenu.getTabAt(tabName);
                                if (tab != null) {
                                    tab.select();
                                }
                            }
                        }
                    }
                    isUserScrolling = false;
                }

            }
        });

    }

    private void setupTabView() {
        mBinding.tabMenu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (isDataAvailable) {
                    int position = tab.getPosition();

                    String singleItemHeader = mSingleItemHeaders.get(position).getHeader();
                    if (!isUserScrolling) {
                        int headerPosition = mIndividualRestaurantAdapter.getTargetPosition(mBinding.recyclerFood, singleItemHeader);
                        ((LinearLayoutManager) mBinding.recyclerFood.getLayoutManager()).scrollToPositionWithOffset(headerPosition, 0);
                    }
                    isUserScrolling = false;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    private void setupViewModel() {
        mRestaurantViewModel = new ViewModelProvider(this).get(StoreViewModel.class);
    }

    private void setupObservers(){
        mRestaurantViewModel.menuLiveDataResponse.observe(this, this::observeGetMenuRequest);
        mRestaurantViewModel.storeDetailsStateLiveDataResponse.observe(this, this::observeStoreInfoRequest);
        mRestaurantViewModel.individualProductStateLiveData.observe(this, this::observeIndividualProductDetailRequest);
    }

    private void observeGetMenuRequest(StateData<Menu> menuStateData) {
        switch (menuStateData.getStatus()) {
            case LOADING: {
                setLoadings(true);
                break;
            }

            case SUCCESS: {
                setLoadings(false);
                if (menuStateData.getData() != null) {
                    menu = menuStateData.getData();
                    populateMenuRecyclerView(menu);

                }
                break;
            }

            case ERROR: {
                break;
            }
        }
    }

    private void setLoadings(boolean isLoading) {
        if (isLoading) {
            mBinding.menuShimmerLayout.startShimmer();
            mBinding.menuShimmerLayout.setVisibility(View.VISIBLE);

            mBinding.clSearch.setVisibility(View.GONE);
            mBinding.recyclerFood.setVisibility(View.GONE);

            mBinding.productShimmerLayout.startShimmer();
            mBinding.productShimmerLayout.setVisibility(View.VISIBLE);

        } else {
            mBinding.menuShimmerLayout.stopShimmer();
            mBinding.menuShimmerLayout.setVisibility(View.GONE);

            mBinding.clSearch.setVisibility(View.VISIBLE);
            mBinding.recyclerFood.setVisibility(View.VISIBLE);

            mBinding.productShimmerLayout.stopShimmer();
            mBinding.productShimmerLayout.setVisibility(View.GONE);

        }
    }

    private void observeIndividualProductDetailRequest(StateData<IndividualProduct> individualProductStateData) {
        switch (individualProductStateData.getStatus()) {
            case LOADING: {

                break;
            }

            case SUCCESS: {
                if (individualProductStateData.getData() != null) {


                }

                break;
            }

            case ERROR: {

                break;
            }
        }
    }

    private void observeStoreInfoRequest(StateData<StoreDetails> storeDetailsStateData) {
        switch (storeDetailsStateData.getStatus()) {
            case LOADING: {
                break;
            }

            case SUCCESS: {
                if (storeDetailsStateData.getData() != null) {
                    mStoreDetails = storeDetailsStateData.getData();
                    mStore = mapStoreDetailsToStoreObject(mStoreDetails, mStore.getSectorCode());
                    if (mHasUserChangeOrderTypeChanged) {
                        setStoreInfo();
                        executeDataBindingOnUi();
                    }
                    mHasUserChangeOrderTypeChanged = false;
                    storeStatusVisible(mStoreDetails);
                    attachStoreDetailsToStoreObject();
                }

                break;
            }

        }

    }

    private void attachStoreDetailsToStoreObject() {
        mStore.setAllowPromoCode(mStoreDetails.isAllowPromoCode());
    }

    private void storeStatusVisible(StoreDetails storeDetails) {
        if (storeDetails.getOnline()) {
            if (storeDetails.getBusy()) {
                if (mBinding.constraintStoresStatus.getVisibility() == View.GONE) {
                    mBinding.constraintStoresStatus.setVisibility(View.VISIBLE);
                }
                mBinding.textStoreStatus.setText(getString(R.string.msg_restaurant_is_busy_now));
            } else if (storeDetails.getSchedule()) {
                if (mBinding.constraintStoresStatus.getVisibility() == View.GONE) {
                    mBinding.constraintStoresStatus.setVisibility(View.VISIBLE);
                }
                mBinding.textStoreStatus.setText(getString(R.string.msg_order_schedule) + " " + formateDouble(storeDetails.getMinScheduleTime()) + " " + getString(R.string.hours));
            } else {
                mBinding.constraintStoresStatus.setVisibility(View.GONE);
            }
        } else {
            if (mBinding.constraintStoresStatus.getVisibility() == View.GONE) {
                mBinding.constraintStoresStatus.setVisibility(View.VISIBLE);
            }
            if (mIsPickupOrder)
                mBinding.textStoreStatus.setText(getString(R.string.msg_restaurant_is_closed_now_pickup));
            else
                mBinding.textStoreStatus.setText(getString(R.string.msg_restaurant_is_closed_now));
        }
    }

    private void setStoreInfo() {
        if (mStore != null) {
            attachCoverImage(mStore);
            attachCuisineOrDescription(mStore);
            attachRatingToText(mStore);
            attachToFavouriteIconToImage(mStore);
            setSpannableText(mStore);

            attachPreparationTimeToText(mStore);
            attachDistanceToText(mStore);
            attachDeliveryTimeToText(mStore);
            attachDeliveryFeeToText(mStore);
            attachMinOrderToText(mStore);
            attachStoreTypeOnUi(mStore);

        }
    }
    private void attachStoreTypeOnUi(Store mStore) {
        if (mStore.getMarketPlace()) {
            mBinding.imageMarketPlaceIndicator.setVisibility(View.VISIBLE);
            mBinding.imageTmDoneDeliveryIndicator.setVisibility(View.GONE);
        } else {
            mBinding.imageMarketPlaceIndicator.setVisibility(View.GONE);
            mBinding.imageTmDoneDeliveryIndicator.setVisibility(View.VISIBLE);
        }
    }
    private void attachMinOrderToText(Store storeInfo) {
        mBinding.textMinOrder.setText(getFormattedAsCurrency(storeInfo.getMarketPlaceMinOrderValue(), false));
    }
    private void attachDeliveryFeeToText(Store store) {
        if (store.getDeliveryFee() > 0) {
            mBinding.textDeliveryFee.setText(getFormattedAsCurrency(store.getDeliveryFee(), true));
        } else {
            mBinding.textDeliveryFee.setText(getString(R.string.label_free));
        }
    }
    private void attachDeliveryTimeToText(Store store) {
        String deliveryTime = store.getStoreDeliveryTime();
        if (ExtenstionMethods.isNotEmptyString(deliveryTime)) {
            mBinding.textDeliveryTime.setText(deliveryTime + " " + getString(R.string.label_mins));
        } else {
            mBinding.textDeliveryTime.setText(getString(R.string.label_not_available));
        }
    }
    private void attachPreparationTimeToText(Store store) {
        String preparationTime = store.getPreparationTime();
        if (ExtenstionMethods.isNotEmptyString(preparationTime)) {
            mBinding.textPreparationTime.setText(preparationTime + " " + getString(R.string.label_mins));
        } else {
            mBinding.textPreparationTime.setText(getString(R.string.label_not_available));
        }
    }

    private void attachDistanceToText(Store store) {
        mBinding.textDistance.setText(getFormattedAsTwoDecimalsWithoutLocale(store.getDistance()) + " " + getString(R.string.label_distance_km));
    }
    private void setSpannableText(Store storeInfo) {
        SpannableString content;
        if (ExtenstionMethods.isNotEmptyString(storeInfo.getRating() + " (" + storeInfo.getRatedCount() + ")")) {
            content = new SpannableString(storeInfo.getRating() + " (" + storeInfo.getRatedCount() + ")");
        } else {
            content = new SpannableString("0");
        }
//        [TAND-1918] [FR] Hide the Rating list view - Commented by Iroshana 23/03/01
//        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        mBinding.textRating.setText(content);
    }

    private void attachCoverImage(Store storeInfo) {
        Glide.with(this)
                .load(storeInfo.getCoverUrl())
                .placeholder(R.drawable.placeholder_store_cover)
                .override(400, 300).into(mBinding.imageCover);
    }
    private void attachCuisineOrDescription(Store storeInfo) {

        if (storeInfo.getCuisines() != null) {
            if (mBinding.textCuisine.getVisibility() == View.GONE) {
                mBinding.textCuisine.setVisibility(View.VISIBLE);
                mBinding.textCuisine.setText(getCuisine(storeInfo.getCuisines()));
            }
        } else {
            mBinding.textCuisine.setVisibility(View.GONE);
        }
    }
    private String getCuisine(List<String> cuisinesList) {
        String cuisines = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; cuisinesList.size() > i; i++) {
            if (i == 0) {
                stringBuilder.append(cuisinesList.get(i));
            } else {
                stringBuilder.append(", " + cuisinesList.get(i));
            }
        }
        cuisines = stringBuilder.toString();
        if (cuisines != null) {
            return cuisines;
        }
        return "";
    }

    private void attachRatingToText(Store storeInfo) {
        if (storeInfo.getRating() != null) {
            mBinding.textRating.setText(storeInfo.getRating() + " (" + storeInfo.getRatedCount() + ")");
        } else {
            mBinding.textRating.setText(getString(R.string.label_not_available));
        }
    }

    private void attachToFavouriteIconToImage(Store storeInfo) {
        if (storeInfo.getFavourite()) {
            mBinding.imageFavourite.setImageDrawable(getResources().getDrawable(R.drawable.ic_individual_favourite_bg_white));
        } else {
            mBinding.imageFavourite.setImageDrawable(getResources().getDrawable(R.drawable.ic_individual_favourite_outline_border_white));
        }
    }

    private void populateMenuRecyclerView(Menu menu) {
        if (menu.getMenuCategories() != null) {
            if (menu.getMenuCategories().isEmpty()) {
                if (mBinding.clSearch.getVisibility() == View.VISIBLE) {
                    mBinding.clSearch.setVisibility(View.GONE);
                }
                isShowMenuProductListingEmptyPlaceHolder(true);
            } else {
                isShowMenuProductListingEmptyPlaceHolder(false);
                if (mBinding.clSearch.getVisibility() == View.GONE) {
                    mBinding.clSearch.setVisibility(View.VISIBLE);
                }
                prepareRecyclerList(menu);
                setupRecyclerView();
                setTabLayoutIndex();
            }
        } else {
            if (mBinding.clSearch.getVisibility() == View.VISIBLE) {
                mBinding.clSearch.setVisibility(View.GONE);
            }
            isShowMenuProductListingEmptyPlaceHolder(true);
        }
    }

    private void isShowMenuProductListingEmptyPlaceHolder(boolean isShowEmptyPlaceHolder) {
        if (isShowEmptyPlaceHolder) {
            mBinding.linearLayoutEmptyView.setVisibility(View.VISIBLE);
            mBinding.recyclerFood.setVisibility(View.GONE);
        } else {
            mBinding.recyclerFood.setVisibility(View.VISIBLE);
            mBinding.linearLayoutEmptyView.setVisibility(View.GONE);
        }
    }

    private void prepareRecyclerList(Menu menu) {
        mRestaurantSingleItems = new ArrayList<>();
        mAllItems = new ArrayList<>();
        mBinding.tabMenu.removeAllTabs();

        ArrayList<String> headerList = new ArrayList<>();
        if (menu == null || menu.getItems() == null || menu.getMenuCategories() == null) {
            return;
        }
        for (MenuCategory menuCategory : menu.getMenuCategories()) {
            ArrayList<SingleRestaurantItemContent> menuProductsUnderThisMenuCategory = new ArrayList<>();
            for (FoodItem foodItem : menu.getItems()) {
                if (foodItem.getMenuCategories() != null) {
                    for (MenuCategory foodItemMenuCategory : foodItem.getMenuCategories()) {
                        if (foodItemMenuCategory.getCode().equals(menuCategory.getCode())) {
                            if (!headerList.contains(menuCategory.getName())) {
                                headerList.add(menuCategory.getName());
                                mMenuList.add(menuCategory.getName());
                                mRestaurantSingleItems.add(new SingleRestaurantItemHeader(menuCategory.getName()));
                                mSingleItemHeaders.add(new SingleRestaurantItemHeader(menuCategory.getName()));
                                mBinding.tabMenu.addTab(mBinding.tabMenu.newTab().setText(menuCategory.getName()));
                            }
                            SingleRestaurantItemContent item = new SingleRestaurantItemContent();
                            item.setHeaderName(menuCategory.getName());
                            item.setName(foodItem.getName());
                            item.setImage(foodItem.getImageUrl());
                            item.setRating(foodItem.getRating());
                            item.setDescription(foodItem.getDescription());
                            item.setId(foodItem.getId());
                            item.setInStock(foodItem.getInStock());
                            item.setFeatured(foodItem.getFeatured());
                            item.setItemIndex(foodItemMenuCategory.getIndex());

                            item.setPrice(foodItem.getPrice());
                            menuProductsUnderThisMenuCategory.add(item);
                        }
                    }

                }
            }
            Collections.sort(menuProductsUnderThisMenuCategory, new Comparator<SingleRestaurantItemContent>() {
                @Override
                public int compare(SingleRestaurantItemContent itemLeft, SingleRestaurantItemContent itemRight) {
                    return Integer.compare(itemLeft.getItemIndex(), itemRight.getItemIndex());
                }
            });
            mRestaurantSingleItems.addAll(menuProductsUnderThisMenuCategory);
            mAllItems.addAll(menuProductsUnderThisMenuCategory);
        }


        isDataAvailable = true;
    }

    private void setupRecyclerView() {
        mIndividualRestaurantAdapter = new IndividualRestaurantAdapter(mStore, this, getSupportFragmentManager());
        mIndividualRestaurantAdapter.setUpSingleRestaurantItemList(mRestaurantSingleItems);
        mIndividualRestaurantAdapter.setOnRestaurantItemSelectionListener(singleRestaurantItemContent -> {
            if (!mIsIndividualProductDialogShowing) {
                mIsIndividualProductDialogShowing = true;
                loadIndividualProductDetails(singleRestaurantItemContent.getId());
            }

        });
        mBinding.recyclerFood.setLayoutManager(new LinearLayoutManager(this));
        mBinding.recyclerFood.setAdapter(mIndividualRestaurantAdapter);
    }

    private void loadIndividualProductDetails(String productId) {
        mRestaurantViewModel.getFoodItem(mStore.getId(), productId, false);
    }

    private void setTabLayoutIndex() {
        TabLayout.Tab tab = mBinding.tabMenu.getTabAt(0);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                tab.select();
            }
        }, 500);
    }

    private void makeLoadMenuRequest() {
        mRestaurantViewModel.getMenu(mStore.getId());
    }

    private void onScreenRefresh() {
        mBinding.swipeRefreshFoodList.setRefreshing(false);
        if (mIndividualRestaurantAdapter != null) {
            mIndividualRestaurantAdapter.clear();
        }
        makeLoadMenuRequest();
    }

    private void setupSwipeRefresh() {
        mBinding.swipeRefreshFoodList.setOnRefreshListener(this::onScreenRefresh);
        mBinding.swipeRefreshFoodList.setColorSchemeResources(
                R.color.colorMinsk,
                R.color.colorGigas,
                R.color.colorSilverChalice,
                R.color.colorWhite);
        mBinding.swipeRefreshFoodList.setRefreshing(false);
    }

    private void makeLoadStoreInfoRequest() {
        mRestaurantViewModel.getStoreInfo(mStore.getId(), mLatitude, mLongitude, false);
    }

    public  Store mapStoreDetailsToStoreObject(StoreDetails storeDetails, String mSectorCode) {
        Store store = new Store();
        List<String> cuisineList = new ArrayList<>();

        for (Cuisine cuisine : storeDetails.getCuisineList()) {
            cuisineList.add(cuisine.getName());
        }
        store.setId(storeDetails.getId());
        store.setCoverUrl(storeDetails.getCoverUrl());
        store.setLogoUrl(storeDetails.getLogoUrl());
        store.setSectorCode(mSectorCode);
        store.setSectorName(storeDetails.getSectorName());
        store.setMinOrderValue(storeDetails.getMinOrderValue());
        store.setMarketPlace(storeDetails.isMarketPlace());
        store.setName(storeDetails.getName());
        store.setSectorLayoutType(storeDetails.getSectorLayoutType());
        store.setArabicName(storeDetails.getArabicName());
        store.setDeliveryTime(storeDetails.getMaxDeliveryTime());
        store.setDeliveryFee(storeDetails.getDeliveryFee());
        store.setAveragePrepTime(storeDetails.getAveragePrepTime());
        store.setMarketPlaceMinOrderValue(storeDetails.getMarketPlaceMinOrderValue());
        store.setRating(storeDetails.getRating());
        store.setIsTmDonePlusStore(storeDetails.isPlusStore());
        store.setRatedCount(storeDetails.getRatedCount());
        store.setCuisines(cuisineList);
        store.setFavourite(storeDetails.isFavourite());
        store.setAllowPromoCode(storeDetails.isAllowPromoCode());
        store.setAllowRating(storeDetails.isAllowRating());
        store.setDisableCredit(storeDetails.isDisableCredit());
        store.setAllowTracking(storeDetails.isAllowTracking());
        store.setOrderType(storeDetails.getOrderType());
        store.setDistance(storeDetails.getDistance());
        store.setOrderType(storeDetails.getOrderType());
        store.setDistance(storeDetails.getDistance());
        store.setStoreLayout(storeDetails.getStoreLayout());
        store.setTargetedOfferCount(storeDetails.getTargetedOfferCount());
        store.setTargetedOfferApplied(storeDetails.getTargetedOfferCount() > 0);

        return store;
    }
}