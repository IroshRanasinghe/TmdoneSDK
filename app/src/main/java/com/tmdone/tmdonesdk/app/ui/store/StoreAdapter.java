package com.tmdone.tmdonesdk.app.ui.store;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.tmdone.tmdonesdk.R;
import com.tmdone.tmdonesdk.app.uimodels.Store;
import com.tmdone.tmdonesdk.app.utility.DoubleUtility;
import com.tmdone.tmdonesdk.app.utility.ExtenstionMethods;
import com.tmdone.tmdonesdk.core.Constants;
import com.tmdone.tmdonesdk.databinding.ItemStoreListingBinding;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 4:15 PM
 */
public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolderStore> {
    private static final String TAG = "RestaurantAdapter";
    private final List<Store> mObjectList;
    private OnStoreClickListener mOnStoreClickListener;
    private OnOfferStoryClickListener mOnOfferStoryClickListener;
    private final Activity activity;
    private final int STORES_NORMAL = 0;
    private final int STORES_SPECIAL = 1;
    private boolean mIsDetailView;
    private final boolean mIsPickupOrder;


    public StoreAdapter(Activity activity, boolean isPickupOrder) {
        mObjectList = new ArrayList<>();
        this.activity = activity;
        mIsPickupOrder = isPickupOrder;
    }

    public void setData(List<Store> objectList) {
        this.mObjectList.clear();
        this.mObjectList.addAll(objectList);
        notifyDataSetChanged();
    }

    public void addData(List<Store> objectList) {
        this.mObjectList.addAll(objectList);
        notifyDataSetChanged();
    }

    public void setIsDetailView(boolean isDetailView) {
        this.mIsDetailView = isDetailView;
        notifyDataSetChanged();
    }

    public void setOnRestaurantClickListener(OnStoreClickListener mOnStoreClickListener) {
        this.mOnStoreClickListener = mOnStoreClickListener;
    }

    public void setOnOfferStoryClickListener(OnOfferStoryClickListener mOnStatusClickListener) {
        this.mOnOfferStoryClickListener = mOnStatusClickListener;
    }

    public void setFavourite(boolean favourite, int position) {
        Store store = (Store) mObjectList.get(position);
        store.setFavourite(favourite);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderStore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        ItemStoreListingBinding binding = ItemStoreListingBinding.inflate(inflater, parent, false);
        return new ViewHolderStore(binding);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderStore holder, int position) {

        if (mObjectList.get(position) != null) {
            Store store = mObjectList.get(position);
            if (store != null) {
                holder.bind(store);
            }
        }
    }

    public void clear() {
        mObjectList.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mObjectList.size();
    }

    public void makeFavouriteBatch(int position, boolean isFavourite) {
        if (!mObjectList.isEmpty()) {
            if (mObjectList.get(position) != null) {
                Store store = (Store) mObjectList.get(position);
                store.setFavourite(isFavourite);
                notifyItemChanged(position);
            }
        }
    }

    public void makeAsFalseTargetedOfferApplied(int position) {
        if (!mObjectList.isEmpty()) {
            if (mObjectList.get(position) instanceof Store) {
                Store store = (Store) mObjectList.get(position);
                store.setTargetedOfferApplied(false);
                notifyItemChanged(position);
            }
        }
    }

    @Nullable
    public Store getRestaurant(int position) {
        if (mObjectList.get(position) instanceof Store) {
            return (Store) mObjectList.get(position);
        }
        return null;
    }

    public interface OnStoreClickListener {
        void onClick(Store store, int position);
    }

    public interface OnOfferStoryClickListener {
        void onStatusClick(Store store, int position);
    }


    public class ViewHolderStore extends RecyclerView.ViewHolder {
        private final ItemStoreListingBinding mBinding;

        public ViewHolderStore(@NonNull ItemStoreListingBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        public void bind(Store store) {
            mBinding.constraintLayout1.setBackgroundColor(Color.WHITE);
            mBinding.setRestaurant(store);
//            loadRestaurantLogo(store.getLogoUrl());
            switchViewChange(mIsDetailView);
            makeFavouriteBatchVisible(store);
            checkRestaurantStatus(store);
            attachCuisinesToText(store);
            checkPromotionStatus(store);
            attachStoreOfferText(store);
            attachNewBatch(store);
            attachRatingToText(store);
            attachMarketPlaceIcon(store);
            attachListener(store);
            attachStoreDeliveryRelatedInfo(store);
            mBinding.executePendingBindings();
        }

        private void loadRestaurantLogo(String logoUrl) {
            Resources resources = itemView.getContext().getResources();
            Drawable defaultImage = ContextCompat.getDrawable(itemView.getContext(), R.drawable.image_tmdone_logo_round);
            try {
                Glide.with(itemView.getContext())
                        .asBitmap()
                        .load(logoUrl)
                        .error(defaultImage)
                        .placeholder(defaultImage)
                        .into(new BitmapImageViewTarget(mBinding.imageRestaurantLogo) {
                            @Override
                            protected void setResource(Bitmap bitmap) {
                                if (bitmap != null) {
                                    if (!bitmap.isRecycled()) {
                                        RoundedBitmapDrawable circularBitmapDrawable =
                                                RoundedBitmapDrawableFactory.create(resources, bitmap);
                                        circularBitmapDrawable.setCircular(true);
                                        mBinding.imageRestaurantLogo.setImageDrawable(circularBitmapDrawable);
                                    } else {
                                        // The bitmap is recycled, so we need to load it again before displaying it
                                        loadRestaurantLogo(logoUrl);
                                    }
                                }else {
                                    loadRestaurantLogo(logoUrl);
                                }

                            }
                        });
            } catch (Exception e) {
                if (e.getMessage() != null && e.getMessage().contains("Canvas: trying to use a recycled bitmap")) {
                    loadRestaurantLogo(logoUrl);
                } else {
                    Log.e("StoreObject", "Error loading restaurant logo", e);
                }
            }
        }

        private void attachStoreDeliveryRelatedInfo(Store store) {
            StringBuilder deliverInfo = new StringBuilder();

            if (mIsPickupOrder) {
                String preparationTime = store.getPreparationTime();
                if (ExtenstionMethods.isNotEmptyString(preparationTime)) {
                    deliverInfo.append(preparationTime).append(" ").append(itemView.getContext().getString(R.string.label_mins));
                } else {
                    deliverInfo.append(itemView.getContext().getString(R.string.label_not_available));
                }
                deliverInfo.append(" ");
                deliverInfo.append("|");
                deliverInfo.append(" ");

                deliverInfo.append(itemView.getContext().getString(R.string.label_distance));
                deliverInfo.append(" ");
                deliverInfo.append(DoubleUtility.getFormattedAsTwoDecimalsWithoutLocale(store.getDistance()));
                deliverInfo.append(" ");
                deliverInfo.append(itemView.getContext().getString(R.string.label_distance_km));

            } else {
                String deliveryTime = store.getStoreDeliveryTime();
                if (ExtenstionMethods.isNotEmptyString(deliveryTime)) {
                    deliverInfo.append(deliveryTime).append(" ").append(itemView.getContext().getString(R.string.label_mins));
                } else {
                    deliverInfo.append(itemView.getContext().getString(R.string.label_not_available));
                }
                deliverInfo.append(" ");
                deliverInfo.append("|");
                deliverInfo.append(" ");

                deliverInfo.append(itemView.getContext().getString(R.string.delivery_fee));
                deliverInfo.append(":");
                deliverInfo.append(" ");
                if (store.getDeliveryFee() > 0) {
                    deliverInfo.append(DoubleUtility.getFormattedAsCurrency(store.getDeliveryFee(), true));
                } else {
                    deliverInfo.append(itemView.getContext().getString(R.string.label_free));
                }
            }

            mBinding.textDeliveryTime.setText(deliverInfo.toString());
        }


        private void attachListener(Store store) {
            mBinding.constraintLayout4.setOnClickListener(v -> mOnStoreClickListener.onClick(store, getAdapterPosition()));

//            if (store.isTargetedOfferApplied()) {
//                mBinding.relativeCircularImage.setOnClickListener(v -> {
//                    mOnOfferStoryClickListener.onStatusClick(store, getAdapterPosition());
//                });
//            }
        }


        private void checkRestaurantStatus(Store store) {
            if (store.getOnline()) {
                if (store.getBusy()) {
                    makeBackgroundOverlayVisible(itemView.getContext().getString(R.string.label_busy));
                } else {
                    makeBackgroundOverlayHide();
                }
            } else {
                makeBackgroundOverlayVisible(itemView.getContext().getString(R.string.label_closed));
            }
        }

        private void attachCuisinesToText(Store store) {
            String cuisine = "";

            List<String> cuisineList = store.getCuisines();
            StringBuilder stringBuilder = new StringBuilder();
            if (cuisineList.size() > 0) {
                for (int i = 0; i < cuisineList.size(); i++) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(cuisineList.get(i));
                }
                cuisine = stringBuilder.toString();


                if (!cuisine.isEmpty()) {
                    mBinding.textCuisine.setVisibility(View.VISIBLE);
                    mBinding.textCuisine.setText(cuisine);
                } else {
                    mBinding.textCuisine.setVisibility(View.GONE);
                }
            } else {
                mBinding.textCuisine.setVisibility(View.GONE);
            }
        }

        private void attachRatingToText(Store store) {
            if (store.getRating() != null) {
                mBinding.textRating.setText(store.getRating() + "");
            }
            if (store.getRatedCount() != null) {
                mBinding.textRatingCount.setVisibility(View.VISIBLE);
                mBinding.textRatingCount.setText("(" + store.getRatedCount() + ")");
            } else {
                mBinding.textRatingCount.setVisibility(View.GONE);
            }
        }


        private void checkPromotionStatus(Store store) {
            boolean isDiscount = false;
            boolean isPromo = false;
            if (store.getAttributes() != null) {
                for (String key : store.getAttributes()) {
                    if (key.equalsIgnoreCase(Constants.CONST_STORE_DISCOUNT)) {
                        isDiscount = true;
                        if (isPromo) {
                            break;
                        }
                    } else if (key.equalsIgnoreCase(Constants.CONST_STORE_PROMO)) {
                        isPromo = true;
                        if (isDiscount) {
                            break;
                        }
                    }
                }
            }

            if (isPromo) {
                if (mIsDetailView) {
                    mBinding.imageBatchDetailView.setVisibility(View.VISIBLE);
                    mBinding.imageBatch.setVisibility(View.GONE);
                    mBinding.imageBatchDetailView.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.promo_flag));
                } else {
                    mBinding.imageBatch.setVisibility(View.VISIBLE);
                    mBinding.imageBatchDetailView.setVisibility(View.GONE);
                    mBinding.imageBatch.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.promo_flag));
                }
            } else if (isDiscount) {
                if (mIsDetailView) {
                    mBinding.imageBatchDetailView.setVisibility(View.VISIBLE);
                    mBinding.imageBatch.setVisibility(View.GONE);
                    mBinding.imageBatchDetailView.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.discount_flag));
                } else {
                    mBinding.imageBatch.setVisibility(View.VISIBLE);
                    mBinding.imageBatchDetailView.setVisibility(View.GONE);
                    mBinding.imageBatch.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.discount_flag));
                }
//
            } else if (store.getFeatured()) {
                if (mIsDetailView) {
                    mBinding.imageBatchDetailView.setVisibility(View.VISIBLE);
                    mBinding.imageBatch.setVisibility(View.GONE);
                    mBinding.imageBatchDetailView.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.ic_featured_flag));
                } else {
                    mBinding.imageBatch.setVisibility(View.VISIBLE);
                    mBinding.imageBatchDetailView.setVisibility(View.GONE);
                    mBinding.imageBatch.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), R.drawable.ic_featured_flag));
                }
            } else {
                mBinding.imageBatch.setVisibility(View.GONE);
                mBinding.imageBatchDetailView.setVisibility(View.GONE);
            }

        }

        private void attachStoreOfferText(Store store) {
            if (store.getOfferName() != null) {
                if (mBinding.textOff.getVisibility() == View.GONE) {
                    mBinding.textOff.setVisibility(View.VISIBLE);
                }
                mBinding.textOff.setText(store.getOfferName());
            } else {
                mBinding.textOff.setVisibility(View.GONE);
            }
        }

        private void attachMarketPlaceIcon(Store store) {
            if (store.getMarketPlace()) {
                if (mIsPickupOrder) {
                    mBinding.imageMarketPlace.setImageDrawable(ResourcesCompat.getDrawable(itemView.getContext().getResources(), R.drawable.ic_pickup_order_color_yellow, itemView.getContext().getTheme()));
                } else
                    mBinding.imageMarketPlace.setImageDrawable(ResourcesCompat.getDrawable(itemView.getContext().getResources(), R.drawable.ic_market_place_car, itemView.getContext().getTheme()));
            } else {
                if (mIsPickupOrder) {
                    mBinding.imageMarketPlace.setImageDrawable(ResourcesCompat.getDrawable(itemView.getContext().getResources(), R.drawable.ic_pickup_order_color_yellow, itemView.getContext().getTheme()));
                } else {
                    mBinding.imageMarketPlace.setImageDrawable(ResourcesCompat.getDrawable(itemView.getContext().getResources(), R.drawable.ic_thunder_bg_orange, itemView.getContext().getTheme()));
                }
            }
            mBinding.imageMarketPlace.setVisibility(View.VISIBLE);
        }


        private void attachNewBatch(Store store) {
            if (store.getStoreNew()) {
                mBinding.constraintNewBatch.setVisibility(View.VISIBLE);
            } else {
                mBinding.constraintNewBatch.setVisibility(View.GONE);
            }
        }

        private void makeBackgroundOverlayVisible(String status) {
            mBinding.frameStatusContainer.setVisibility(View.VISIBLE);
            mBinding.textStatus.setText(status);
        }

        private void makeBackgroundOverlayHide() {
            mBinding.frameStatusContainer.setVisibility(View.GONE);
        }


        public void switchViewChange(boolean isDetailView) {
            if (isDetailView) {
                mBinding.imageCover.setVisibility(View.VISIBLE);
            } else {
                mBinding.imageCover.setVisibility(View.GONE);
            }
        }

        private void makeFavouriteBatchVisible(Store store) {
            if (store.getFavourite()) {
//                Log.e(TAG, "makeFavouriteBatchVisible: " + store.getFavourite());
                if (mBinding.imageFavourite.getVisibility() == View.GONE) {
                    mBinding.imageFavourite.setVisibility(View.VISIBLE);
                }
            } else {
//                Log.e(TAG, "makeFavouriteBatchVisible: " + store.getFavourite());
                mBinding.imageFavourite.setVisibility(View.GONE);
            }
        }

//        private void showCircularStatusView() {
//            mBinding.circularStatusView.setVisibility(View.VISIBLE);
//        }
//
//        private void hideCircularStatusView() {
//            mBinding.circularStatusView.setVisibility(View.GONE);
//        }

//        private void setupPortionCountOfCircularStatusCount(Store store) {
//            if (store.isTargetedOfferApplied()) {
//                if (store.getTargetedOfferCount() > 0) {
//                    showCircularStatusView();
//                    mBinding.circularStatusView.setPortionsCount(Math.max(store.getTargetedOfferCount(), CONST_MIN_PORTION_COUNT));
//                    mBinding.circularStatusView.setCustomPaint(UiUtility.tmdoneGradient(itemView.getContext(), 82, 82));
//                } else {
//                    hideCircularStatusView();
//                }
//            } else {
//                hideCircularStatusView();
//            }
//        }
    }
}
