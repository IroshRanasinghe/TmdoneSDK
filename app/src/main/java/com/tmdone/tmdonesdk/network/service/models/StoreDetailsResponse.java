package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 2:54 PM
 */
public class StoreDetailsResponse {
    @SerializedName("IsMarketPlace")
    @Expose
    private boolean isMarketPlace;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("BranchName")
    @Expose
    private String branchName;

    @SerializedName("MinScheduleTime")
    @Expose
    private Double minScheduleTime;

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
    private List<PaymentMethodsResponse> paymentMethodsResponses;

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

    @SerializedName("Cuisines")
    @Expose
    private List<CuisineResponse> cuisineResponseList = null;

    @SerializedName("ArabicDescription")
    @Expose
    private String arabicDescription;

    @SerializedName("MaxDeliveryTime")
    @Expose
    private Integer maxDeliveryTime;

    @SerializedName("OperationalDetails")
    @Expose
    private List<OperationalDetailsItemResponse> operationalDetailsItemResponseList;

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

    @SerializedName("DeliveryFee")
    @Expose
    private Double deliveryFee;

    @SerializedName("CoverUrl")
    @Expose
    private String coverUrl;

    @SerializedName("SectorName")
    @Expose
    private String sectorName;

    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("MarketPlaceMinOrderValue")
    @Expose
    private Double marketPlaceMinOrderValue;
    @SerializedName("MinOrderValue")
    @Expose
    private Double minOrderValue;

    @SerializedName("IsFavourite")
    @Expose
    private boolean isFavourite;

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
    public LocationResponse location;

    @SerializedName("OrderType")
    @Expose
    private String orderType;

    @SerializedName("Distance")
    @Expose
    private Double distance;

    @SerializedName("StoreLayout")
    @Expose
    private String storeLayout;

    @SerializedName("TargetedOfferCount")
    @Expose
    private Integer targetedOfferCount;

    @SerializedName("UserOffer")
    @Expose
    private UserOfferResponse userOfferResponse;

    public boolean isMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public String getDescription() {
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

    public List<PaymentMethodsResponse> getPaymentMethodsResponses() {
        return paymentMethodsResponses;
    }

    public void setPaymentMethodsResponses(List<PaymentMethodsResponse> paymentMethodsResponses) {
        this.paymentMethodsResponses = paymentMethodsResponses;
    }

    public String getName() {
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

    public Integer getMaxDeliveryTime() {
        return maxDeliveryTime;
    }

    public void setMaxDeliveryTime(Integer maxDeliveryTime) {
        this.maxDeliveryTime = maxDeliveryTime;
    }

    public List<OperationalDetailsItemResponse> getOperationalDetailsItemResponseList() {
        return operationalDetailsItemResponseList;
    }

    public void setOperationalDetailsItemResponseList(List<OperationalDetailsItemResponse> operationalDetailsItemResponseList) {
        this.operationalDetailsItemResponseList = operationalDetailsItemResponseList;
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

    public double getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(double deliveryFee) {
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

    public Double getMarketPlaceMinOrderValue() {
        return marketPlaceMinOrderValue;
    }

    public void setMarketPlaceMinOrderValue(Double marketPlaceMinOrderValue) {
        this.marketPlaceMinOrderValue = marketPlaceMinOrderValue;
    }

    public List<CuisineResponse> getCuisineResponseList() {
        return cuisineResponseList;
    }

    public void setCuisineResponseList(List<CuisineResponse> cuisineResponseList) {
        this.cuisineResponseList = cuisineResponseList;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public Double getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(Double minOrderValue) {
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

    public boolean isAllowPromoCode() {
        return isAllowPromoCode;
    }

    public void setAllowPromoCode(boolean allowPromoCode) {
        isAllowPromoCode = allowPromoCode;
    }

    public boolean isAllowRating() {
        return isAllowRating;
    }

    public void setAllowRating(boolean allowRating) {
        isAllowRating = allowRating;
    }

    public boolean isAllowTracking() {
        return isAllowTracking;
    }

    public void setAllowTracking(boolean allowTracking) {
        isAllowTracking = allowTracking;
    }


    public String getStoreLayout() {
        return storeLayout;
    }

    public void setStoreLayout(String storeLayout) {
        this.storeLayout = storeLayout;
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

    public Integer getTargetedOfferCount() {
        return targetedOfferCount;
    }

    public void setTargetedOfferCount(Integer targetedOfferCount) {
        this.targetedOfferCount = targetedOfferCount;
    }

    public UserOfferResponse getUserOfferResponse() {
        return userOfferResponse;
    }

    public void setUserOfferResponse(UserOfferResponse userOfferResponse) {
        this.userOfferResponse = userOfferResponse;
    }
}
