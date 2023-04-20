package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tmdone.tmdonesdk.R;
import com.tmdone.tmdonesdk.app.utility.ExtenstionMethods;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 12:32 PM
 */
public class Store implements Parcelable{
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;
    @SerializedName("IsFeatured")
    @Expose
    private boolean isFeatured;
    @SerializedName("IsOnline")
    @Expose
    private boolean isOnline;
    @SerializedName("CoverUrl")
    @Expose
    public String coverUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("Rating")
    @Expose
    private Double rating;
    @SerializedName("RatedCount")
    @Expose
    private Integer ratedCount;
    @SerializedName("AveragePrepTime")
    @Expose
    private Double averagePrepTime;
    @SerializedName("DeliveryTime")
    @Expose
    private Double deliveryTime;
    @SerializedName("Cuisines")
    @Expose
    private List<String> cuisines = null;
    @SerializedName("Attributes")
    @Expose
    private List<String> attributes = null;
    @SerializedName("DeliveryFee")
    @Expose
    private Double deliveryFee;
    @SerializedName("IsBusy")
    @Expose
    private boolean isBusy;
    @SerializedName("SectorCode")
    @Expose
    private String sectorCode;
    @SerializedName("Contact")
    @Expose
    private Object contact;
    @SerializedName("Distance")
    @Expose
    private Double distance;
    @SerializedName("MarketPlaceMinOrderValue")
    @Expose
    private Double marketPlaceMinOrderValue;
    @SerializedName("IsFavourite")
    @Expose
    private boolean isFavourite;
    @SerializedName("MarketPlaceZoneInfos")
    @Expose
    private List<Object> marketPlaceZoneInfoList = null;
    @SerializedName("OfferName")
    @Expose
    private String offerName;
    @SerializedName("OfferArabicName")
    @Expose
    private String offerArabicName;

    @SerializedName("IsMarketPlace")
    @Expose
    private boolean isMarketPlace;
    @SerializedName("IsStoreNew")
    @Expose
    private boolean isStoreNew;
    @SerializedName("MinOrderValue")
    @Expose
    private double minOrderValue;

    @SerializedName("IsPlusStore")
    @Expose
    private boolean mIsTmDonePlusStore;

    @SerializedName("SectorLayout")
    @Expose
    private String sectorLayoutType;
    @SerializedName("SectorName")
    @Expose
    private String sectorName;

    @SerializedName("IsAllowTracking")
    @Expose
    private boolean isAllowTracking;

    @SerializedName("IsAllowRating")
    @Expose
    private boolean isAllowRating;

    @SerializedName("IsAllowPromoCode")
    @Expose
    private boolean isAllowPromoCode;

    @SerializedName("IsAllowScheduleOrder")
    @Expose
    private boolean isAllowScheduleOrder;

    @SerializedName("IsDisableCredit")
    @Expose
    private boolean isDisableCredit;

    @SerializedName("OrderType")
    @Expose
    private String orderType;

    @SerializedName("IsTargetedOfferApplied")
    @Expose
    private boolean isTargetedOfferApplied;

    @SerializedName("TargetedOfferCount")
    @Expose
    private int targetedOfferCount;

    protected Store(Parcel in) {
        id = in.readString();
        name = in.readString();
        arabicName = in.readString();
        isFeatured = in.readByte() != 0;
        isOnline = in.readByte() != 0;
        coverUrl = in.readString();
        logoUrl = in.readString();
        if (in.readByte() == 0) {
            rating = null;
        } else {
            rating = in.readDouble();
        }
        if (in.readByte() == 0) {
            ratedCount = null;
        } else {
            ratedCount = in.readInt();
        }
        if (in.readByte() == 0) {
            averagePrepTime = null;
        } else {
            averagePrepTime = in.readDouble();
        }
        if (in.readByte() == 0) {
            deliveryTime = null;
        } else {
            deliveryTime = in.readDouble();
        }
        cuisines = in.createStringArrayList();
        attributes = in.createStringArrayList();
        if (in.readByte() == 0) {
            deliveryFee = null;
        } else {
            deliveryFee = in.readDouble();
        }
        isBusy = in.readByte() != 0;
        sectorCode = in.readString();
        if (in.readByte() == 0) {
            distance = null;
        } else {
            distance = in.readDouble();
        }
        if (in.readByte() == 0) {
            marketPlaceMinOrderValue = null;
        } else {
            marketPlaceMinOrderValue = in.readDouble();
        }
        isFavourite = in.readByte() != 0;
        offerName = in.readString();
        offerArabicName = in.readString();
        isMarketPlace = in.readByte() != 0;
        isStoreNew = in.readByte() != 0;
        minOrderValue = in.readDouble();
        mIsTmDonePlusStore = in.readByte() != 0;
        sectorLayoutType = in.readString();
        sectorName = in.readString();
        isAllowTracking = in.readByte() != 0;
        isAllowRating = in.readByte() != 0;
        isAllowPromoCode = in.readByte() != 0;
        isAllowScheduleOrder = in.readByte() != 0;
        isDisableCredit = in.readByte() != 0;
        orderType = in.readString();
        isTargetedOfferApplied = in.readByte() != 0;
        targetedOfferCount = in.readInt();
        storeLayout = in.readString();
    }

    public static final Parcelable.Creator<Store> CREATOR = new Parcelable.Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    public String getStoreLayout() {
        return storeLayout;
    }

    public void setStoreLayout(String storeLayout) {
        this.storeLayout = storeLayout;
    }

    @SerializedName("StoreLayout")
    @Expose
    private String storeLayout;

    public Store() {
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @BindingAdapter({"storeCover"})
    public static void loadStoreCover(ImageView imageView, String coverUrl) {
        Glide.with(imageView.getContext())
                .load(coverUrl)
                .placeholder(R.drawable.default_cover)
                .override(400, 300).into(imageView);
    }

    @BindingAdapter({"restaurantLogo"})
    public static void loadRestaurantLogo(CircleImageView imageView, String logoUrl) {
        Context context = imageView.getContext();
        Resources resources = context.getResources();
        Drawable defaultImage = ContextCompat.getDrawable(context, R.drawable.image_tmdone_logo_round);
        try {
            Glide.with(context)
                    .asBitmap()
                    .load(logoUrl)
                    .error(defaultImage)
                    .placeholder(defaultImage)
                    .into(new BitmapImageViewTarget(imageView) {
                        @Override
                        protected void setResource(Bitmap bitmap) {
                            if (!bitmap.isRecycled()) {
                                RoundedBitmapDrawable circularBitmapDrawable =
                                        RoundedBitmapDrawableFactory.create(resources, bitmap);
                                circularBitmapDrawable.setCircular(true);
                                imageView.setImageDrawable(circularBitmapDrawable);
                            } else {
                                // The bitmap is recycled, so we need to load it again before displaying it
                                loadRestaurantLogo(imageView, logoUrl);
                            }
                        }
                    });
        } catch (Exception e) {
            if (e.getMessage() != null && e.getMessage().contains("Canvas: trying to use a recycled bitmap")) {
                loadRestaurantLogo(imageView, logoUrl);
            } else {
                Log.e("StoreObject", "Error loading restaurant logo", e);
            }
        }
    }

    @BindingAdapter({"squareRestaurantLogo"})
    public static void LoadSquareRestaurantLogo(ImageView imageView, String logoUrl) {
        Glide.with(imageView.getContext())
                .load(logoUrl)
                .placeholder(R.drawable.ic_grocery_placeholder)
                .into(imageView);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            if (ExtenstionMethods.isNotEmptyString(arabicName))
                return arabicName;
            else
                return name;
        } else
            return name;
    }

    public String getStoreEnglishName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public boolean getOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public boolean getBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRatedCount() {
        return ratedCount;
    }

    public void setRatedCount(Integer ratedCount) {
        this.ratedCount = ratedCount;
    }

    public Double getAveragePrepTime() {
        return averagePrepTime;
    }

    public String getPreparationTime() {
        return Integer.toString(averagePrepTime.intValue());
    }

    public void setAveragePrepTime(Double averagePrepTime) {
        this.averagePrepTime = averagePrepTime;
    }

    public Double getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Double deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<String> attributes) {
        this.attributes = attributes;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public Object getContact() {
        return contact;
    }

    public void setContact(Object contact) {
        this.contact = contact;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getMarketPlaceMinOrderValue() {
        return marketPlaceMinOrderValue;
    }

    public void setMarketPlaceMinOrderValue(Double marketPlaceMinOrderValue) {
        this.marketPlaceMinOrderValue = marketPlaceMinOrderValue;
    }

    public boolean getMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public List<Object> getMarketPlaceZoneInfoList() {
        return marketPlaceZoneInfoList;
    }

    public void setMarketPlaceZoneInfoList(List<Object> marketPlaceZoneInfoList) {
        this.marketPlaceZoneInfoList = marketPlaceZoneInfoList;
    }

    public String getStoreDeliveryTime() {
        return Integer.toString(deliveryTime.intValue());
    }

    public String getOfferName() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            return offerArabicName;
        } else {
            return offerName;
        }
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getOfferArabicName() {
        return offerArabicName;
    }

    public void setOfferArabicName(String offerArabicName) {
        this.offerArabicName = offerArabicName;
    }

    public boolean getStoreNew() {
        return isStoreNew;
    }

    public void setStoreNew(boolean storeNew) {
        isStoreNew = storeNew;
    }

    public double getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(double minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public boolean isTmDonePlusStore() {
        return mIsTmDonePlusStore;
    }

    public void setIsTmDonePlusStore(boolean mIsTmDonePlusStore) {
        this.mIsTmDonePlusStore = mIsTmDonePlusStore;
    }

    public String getSectorLayoutType() {
        return sectorLayoutType;
    }

    public void setSectorLayoutType(String sectorLayoutType) {
        this.sectorLayoutType = sectorLayoutType;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public boolean isAllowTracking() {
        return isAllowTracking;
    }

    public void setAllowTracking(boolean allowTracking) {
        isAllowTracking = allowTracking;
    }

    public boolean isAllowRating() {
        return isAllowRating;
    }

    public void setAllowRating(boolean allowRating) {
        isAllowRating = allowRating;
    }

    public boolean isAllowPromoCode() {
        return isAllowPromoCode;
    }

    public void setAllowPromoCode(boolean allowPromoCode) {
        isAllowPromoCode = allowPromoCode;
    }

    public boolean isAllowScheduleOrder() {
        return isAllowScheduleOrder;
    }

    public void setAllowScheduleOrder(boolean allowScheduleOrder) {
        isAllowScheduleOrder = allowScheduleOrder;
    }

    public boolean isDisableCredit() {
        return isDisableCredit;
    }

    public void setDisableCredit(boolean disableCredit) {
        isDisableCredit = disableCredit;
    }

    public boolean isTargetedOfferApplied() {
        return isTargetedOfferApplied;
    }

    public void setTargetedOfferApplied(boolean targetedOfferApplied) {
        isTargetedOfferApplied = targetedOfferApplied;
    }

    public int getTargetedOfferCount() {
        return targetedOfferCount;
    }

    public void setTargetedOfferCount(int targetedOfferCount) {
        this.targetedOfferCount = targetedOfferCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(arabicName);
        parcel.writeByte((byte) (isFeatured ? 1 : 0));
        parcel.writeByte((byte) (isOnline ? 1 : 0));
        parcel.writeString(coverUrl);
        parcel.writeString(logoUrl);
        if (rating == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(rating);
        }
        if (ratedCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ratedCount);
        }
        if (averagePrepTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(averagePrepTime);
        }
        if (deliveryTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(deliveryTime);
        }
        parcel.writeStringList(cuisines);
        parcel.writeStringList(attributes);
        if (deliveryFee == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(deliveryFee);
        }
        parcel.writeByte((byte) (isBusy ? 1 : 0));
        parcel.writeString(sectorCode);
        if (distance == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(distance);
        }
        if (marketPlaceMinOrderValue == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(marketPlaceMinOrderValue);
        }
        parcel.writeByte((byte) (isFavourite ? 1 : 0));
        parcel.writeString(offerName);
        parcel.writeString(offerArabicName);
        parcel.writeByte((byte) (isMarketPlace ? 1 : 0));
        parcel.writeByte((byte) (isStoreNew ? 1 : 0));
        parcel.writeDouble(minOrderValue);
        parcel.writeByte((byte) (mIsTmDonePlusStore ? 1 : 0));
        parcel.writeString(sectorLayoutType);
        parcel.writeString(sectorName);
        parcel.writeByte((byte) (isAllowTracking ? 1 : 0));
        parcel.writeByte((byte) (isAllowRating ? 1 : 0));
        parcel.writeByte((byte) (isAllowPromoCode ? 1 : 0));
        parcel.writeByte((byte) (isAllowScheduleOrder ? 1 : 0));
        parcel.writeByte((byte) (isDisableCredit ? 1 : 0));
        parcel.writeString(orderType);
        parcel.writeByte((byte) (isTargetedOfferApplied ? 1 : 0));
        parcel.writeInt(targetedOfferCount);
        parcel.writeString(storeLayout);
    }
}
