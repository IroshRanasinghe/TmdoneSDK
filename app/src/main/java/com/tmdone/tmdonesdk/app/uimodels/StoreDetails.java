package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tmdone.tmdonesdk.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:00 PM
 */
public class StoreDetails implements Parcelable {
    @SerializedName("IsMarketPlace")
    @Expose
    private boolean isMarketPlace;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("BranchName")
    @Expose
    private String branchName;

    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;

    @SerializedName("Rating")
    @Expose
    private double rating;

    @SerializedName("AreaId")
    @Expose
    private String areaId;

    @SerializedName("PaymentMethods")
    @Expose
    private List<PaymentMethods> paymentMethods;

    @SerializedName("Name")
    @Expose
    private String name;

    @SerializedName("IsOnline")
    @Expose
    private Boolean isOnline;

    @SerializedName("RatedCount")
    @Expose
    private Integer ratedCount;

    @SerializedName("SectorCode")
    @Expose
    private String sectorCode;

    @SerializedName("SectorId")
    @Expose
    private String sectorId;

    @SerializedName("ArabicDescription")
    @Expose
    private String arabicDescription;
    @SerializedName("MinScheduleTime")
    @Expose
    private Double minScheduleTime;

    @SerializedName("OperationalDetails")
    @Expose
    private List<OperationalDetailsItem> operationalDetailsItemList;

    @SerializedName("IsBusy")
    @Expose
    private Boolean isBusy;

    @SerializedName("ArabicName")
    @Expose
    private String arabicName;

    @SerializedName("Contact")
    @Expose
    private String contact;

    @SerializedName("IsSchedule")
    @Expose
    private Boolean isSchedule;

    @SerializedName("Area")
    @Expose
    private String area;

    @SerializedName("AveragePrepTime")
    @Expose
    private Double averagePrepTime;
    @SerializedName("MaxDeliveryTime")
    @Expose
    private Double maxDeliveryTime;

    @SerializedName("CoverUrl")
    @Expose
    private String coverUrl;

    @SerializedName("SectorName")
    @Expose
    private String sectorName;

    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("OrderType")
    @Expose
    private String orderType;

    @SerializedName("Distance")
    @Expose
    private Double distance;
    @SerializedName("MinOrderValue")
    @Expose
    private double minOrderValue;
    @SerializedName("Cuisines")
    @Expose
    private List<Cuisine> cuisineList = null;
    @SerializedName("IsFavourite")
    @Expose
    private boolean isFavourite;
    @SerializedName("DeliveryFee")
    @Expose
    private Double deliveryFee;
    @SerializedName("MarketPlaceMinOrderValue")
    @Expose
    private double marketPlaceMinOrderValue;
    @SerializedName("IsPlusStore")
    @Expose
    private boolean isPlusStore;

    @SerializedName("IsAllowScheduleOrder")
    @Expose
    private boolean isAllowScheduleOrder;

    @SerializedName("IsDisableCredit")
    @Expose
    private boolean isDisableCredit;

    @SerializedName("SectorLayout")
    @Expose
    private String sectorLayoutType;

    @SerializedName("IsAllowTracking")
    @Expose
    private boolean isAllowTracking;

    @SerializedName("IsAllowRating")
    @Expose
    private boolean isAllowRating;

    @SerializedName("IsAllowPromoCode")
    @Expose
    private boolean isAllowPromoCode;

    @SerializedName("Location")
    @Expose
    private Location location;
    @SerializedName("StoreLayout")
    @Expose
    private String storeLayout;

    @SerializedName("TargetedOfferCount")
    @Expose
    private int targetedOfferCount;

    @SerializedName("UserOffer")
    @Expose
    private UserOffer userOffer;

    protected StoreDetails(Parcel in) {
        isMarketPlace = in.readByte() != 0;
        description = in.readString();
        branchName = in.readString();
        logoUrl = in.readString();
        rating = in.readDouble();
        areaId = in.readString();
        paymentMethods = in.createTypedArrayList(PaymentMethods.CREATOR);
        name = in.readString();
        byte tmpIsOnline = in.readByte();
        isOnline = tmpIsOnline == 0 ? null : tmpIsOnline == 1;
        if (in.readByte() == 0) {
            ratedCount = null;
        } else {
            ratedCount = in.readInt();
        }
        sectorCode = in.readString();
        sectorId = in.readString();
        arabicDescription = in.readString();
        if (in.readByte() == 0) {
            minScheduleTime = null;
        } else {
            minScheduleTime = in.readDouble();
        }
        operationalDetailsItemList = in.createTypedArrayList(OperationalDetailsItem.CREATOR);
        byte tmpIsBusy = in.readByte();
        isBusy = tmpIsBusy == 0 ? null : tmpIsBusy == 1;
        arabicName = in.readString();
        contact = in.readString();
        byte tmpIsSchedule = in.readByte();
        isSchedule = tmpIsSchedule == 0 ? null : tmpIsSchedule == 1;
        area = in.readString();
        if (in.readByte() == 0) {
            averagePrepTime = null;
        } else {
            averagePrepTime = in.readDouble();
        }
        if (in.readByte() == 0) {
            maxDeliveryTime = null;
        } else {
            maxDeliveryTime = in.readDouble();
        }
        coverUrl = in.readString();
        sectorName = in.readString();
        id = in.readString();
        orderType = in.readString();
        if (in.readByte() == 0) {
            distance = null;
        } else {
            distance = in.readDouble();
        }
        minOrderValue = in.readDouble();
        cuisineList = in.createTypedArrayList(Cuisine.CREATOR);
        isFavourite = in.readByte() != 0;
        if (in.readByte() == 0) {
            deliveryFee = null;
        } else {
            deliveryFee = in.readDouble();
        }
        marketPlaceMinOrderValue = in.readDouble();
        isPlusStore = in.readByte() != 0;
        isAllowScheduleOrder = in.readByte() != 0;
        isDisableCredit = in.readByte() != 0;
        sectorLayoutType = in.readString();
        isAllowTracking = in.readByte() != 0;
        isAllowRating = in.readByte() != 0;
        isAllowPromoCode = in.readByte() != 0;
        location = in.readParcelable(Location.class.getClassLoader());
        storeLayout = in.readString();
        targetedOfferCount = in.readInt();
        userOffer = in.readParcelable(UserOffer.class.getClassLoader());
    }

    public static final Parcelable.Creator<StoreDetails> CREATOR = new Parcelable.Creator<StoreDetails>() {
        @Override
        public StoreDetails createFromParcel(Parcel in) {
            return new StoreDetails(in);
        }

        @Override
        public StoreDetails[] newArray(int size) {
            return new StoreDetails[size];
        }
    };

    @BindingAdapter({"storeInfoLogo"})
    public static void loadStoreInfoLogo(CircleImageView imageView, String logoUrl) {
        Glide.with(imageView.getContext())
                .asBitmap().centerCrop()
                .load(logoUrl)
                .error(R.drawable.image_tmdone_logo_round)
                .placeholder(R.drawable.image_tmdone_logo_round)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(imageView.getContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });

    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public boolean isMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public String getDescription() {
        if (CONST_IS_USER_LANGUAGE_AR)
            return arabicDescription;
        else
            return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinScheduleTime() {
        return minScheduleTime;
    }

    public void setMinScheduleTime(Double minScheduleTime) {
        this.minScheduleTime = minScheduleTime;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public List<PaymentMethods> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(List<PaymentMethods> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR)
            return arabicName;
        else
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Integer getRatedCount() {
        return ratedCount;
    }

    public void setRatedCount(Integer ratedCount) {
        this.ratedCount = ratedCount;
    }

    public String getSectorCode() {
        return sectorCode;
    }

    public void setSectorCode(String sectorCode) {
        this.sectorCode = sectorCode;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public Double getMaxDeliveryTime() {
        return maxDeliveryTime;
    }

    public void setMaxDeliveryTime(Double maxDeliveryTime) {
        this.maxDeliveryTime = maxDeliveryTime;
    }

    public List<OperationalDetailsItem> getOperationalDetailsItemList() {
        return operationalDetailsItemList;
    }

    public void setOperationalDetailsItemList(List<OperationalDetailsItem> operationalDetailsItemList) {
        this.operationalDetailsItemList = operationalDetailsItemList;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Boolean getSchedule() {
        return isSchedule;
    }

    public void setSchedule(Boolean schedule) {
        isSchedule = schedule;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Double getAveragePrepTime() {
        return averagePrepTime;
    }

    public void setAveragePrepTime(Double averagePrepTime) {
        this.averagePrepTime = averagePrepTime;
    }

    public Double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(Double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getMarketPlaceMinOrderValue() {
        return marketPlaceMinOrderValue;
    }

    public void setMarketPlaceMinOrderValue(double marketPlaceMinOrderValue) {
        this.marketPlaceMinOrderValue = marketPlaceMinOrderValue;
    }

    public List<Cuisine> getCuisineList() {
        return cuisineList;
    }

    public void setCuisineList(List<Cuisine> cuisineList) {
        this.cuisineList = cuisineList;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public double getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(double minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public boolean isPlusStore() {
        return isPlusStore;
    }

    public void setPlusStore(boolean plusStore) {
        isPlusStore = plusStore;
    }

    public String getSectorLayoutType() {
        return sectorLayoutType;
    }

    public void setSectorLayoutType(String sectorLayoutType) {
        this.sectorLayoutType = sectorLayoutType;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public int getTargetedOfferCount() {
        return targetedOfferCount;
    }

    public void setTargetedOfferCount(int targetedOfferCount) {
        this.targetedOfferCount = targetedOfferCount;
    }

    public String getStoreLayout() {
        return storeLayout;
    }

    public void setStoreLayout(String storeLayout) {
        this.storeLayout = storeLayout;
    }

    public UserOffer getUserOffer() {
        return userOffer;
    }

    public void setUserOffer(UserOffer userOffer) {
        this.userOffer = userOffer;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeByte((byte) (isMarketPlace ? 1 : 0));
        parcel.writeString(description);
        parcel.writeString(branchName);
        parcel.writeString(logoUrl);
        parcel.writeDouble(rating);
        parcel.writeString(areaId);
        parcel.writeTypedList(paymentMethods);
        parcel.writeString(name);
        parcel.writeByte((byte) (isOnline == null ? 0 : isOnline ? 1 : 2));
        if (ratedCount == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(ratedCount);
        }
        parcel.writeString(sectorCode);
        parcel.writeString(sectorId);
        parcel.writeString(arabicDescription);
        if (minScheduleTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(minScheduleTime);
        }
        parcel.writeTypedList(operationalDetailsItemList);
        parcel.writeByte((byte) (isBusy == null ? 0 : isBusy ? 1 : 2));
        parcel.writeString(arabicName);
        parcel.writeString(contact);
        parcel.writeByte((byte) (isSchedule == null ? 0 : isSchedule ? 1 : 2));
        parcel.writeString(area);
        if (averagePrepTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(averagePrepTime);
        }
        if (maxDeliveryTime == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(maxDeliveryTime);
        }
        parcel.writeString(coverUrl);
        parcel.writeString(sectorName);
        parcel.writeString(id);
        parcel.writeString(orderType);
        if (distance == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(distance);
        }
        parcel.writeDouble(minOrderValue);
        parcel.writeTypedList(cuisineList);
        parcel.writeByte((byte) (isFavourite ? 1 : 0));
        if (deliveryFee == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeDouble(deliveryFee);
        }
        parcel.writeDouble(marketPlaceMinOrderValue);
        parcel.writeByte((byte) (isPlusStore ? 1 : 0));
        parcel.writeByte((byte) (isAllowScheduleOrder ? 1 : 0));
        parcel.writeByte((byte) (isDisableCredit ? 1 : 0));
        parcel.writeString(sectorLayoutType);
        parcel.writeByte((byte) (isAllowTracking ? 1 : 0));
        parcel.writeByte((byte) (isAllowRating ? 1 : 0));
        parcel.writeByte((byte) (isAllowPromoCode ? 1 : 0));
        parcel.writeParcelable(location, i);
        parcel.writeString(storeLayout);
        parcel.writeInt(targetedOfferCount);
        parcel.writeParcelable(userOffer, i);
    }
}
