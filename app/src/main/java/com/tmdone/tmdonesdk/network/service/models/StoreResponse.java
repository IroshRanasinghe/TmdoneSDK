package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:45 AM
 */
public class StoreResponse {
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
    private Boolean isFeatured;
    @SerializedName("IsOnline")
    @Expose
    private Boolean isOnline;
    @SerializedName("IsBusy")
    @Expose
    private Boolean isBusy;
    @SerializedName("CoverUrl")
    @Expose
    private String coverUrl;
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
    @SerializedName("IsFavourite")
    @Expose
    private Boolean isFavourite;
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
    @SerializedName("MinOrderValue")
    @Expose
    private Double minOrderValue;
    @SerializedName("IsMarketPlace")
    @Expose
    private Boolean isMarketPlace;
    @SerializedName("MarketPlaceZoneInfos")
    @Expose
    private List<Object> marketPlaceZoneInfoList = null;
    @SerializedName("OfferName")
    @Expose
    private String offerName;
    @SerializedName("OfferArabicName")
    @Expose
    private String offerArabicName;
    @SerializedName("IsStoreNew")
    @Expose
    private Boolean isStoreNew;
    @SerializedName("SectorLayout")
    @Expose
    private String sectorLayoutType;
    @SerializedName("SectorName")
    @Expose
    private String sectorName;
    @SerializedName("OrderType")
    @Expose
    private String orderType;
    @SerializedName("StoreLayout")
    @Expose
    private String storeLayout;
    @SerializedName("IsTargetedOfferApplied")
    @Expose
    private Boolean isTargetedOfferApplied;
    @SerializedName("TargetedOfferCount")
    @Expose
    private Integer targetedOfferCount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
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

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public Boolean getOnline() {
        return isOnline;
    }

    public void setOnline(Boolean online) {
        isOnline = online;
    }

    public Boolean getBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
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

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
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

    public Boolean getMarketPlace() {
        return isMarketPlace;
    }

    public void setMarketPlace(Boolean marketPlace) {
        isMarketPlace = marketPlace;
    }

    public List<Object> getMarketPlaceZoneInfoList() {
        return marketPlaceZoneInfoList;
    }

    public void setMarketPlaceZoneInfoList(List<Object> marketPlaceZoneInfoList) {
        this.marketPlaceZoneInfoList = marketPlaceZoneInfoList;
    }

    public String getOfferName() {
        return offerName;
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

    public Boolean getStoreNew() {
        return isStoreNew;
    }

    public void setStoreNew(Boolean storeNew) {
        isStoreNew = storeNew;
    }

    public Double getMinOrderValue() {
        return minOrderValue;
    }

    public void setMinOrderValue(Double minOrderValue) {
        this.minOrderValue = minOrderValue;
    }

    public String getSectorLayoutType() {
        return sectorLayoutType;
    }


    public void setSectorLayoutType(String sectorLayoutType) {
        this.sectorLayoutType = sectorLayoutType;


    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;


    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getStoreLayout() {
        return storeLayout;
    }

    public void setStoreLayout(String storeLayout) {
        this.storeLayout = storeLayout;
    }

    public Boolean getTargetedOfferApplied() {
        return isTargetedOfferApplied;
    }

    public void setTargetedOfferApplied(Boolean targetedOfferApplied) {
        isTargetedOfferApplied = targetedOfferApplied;
    }

    public Integer getTargetedOfferCount() {
        return targetedOfferCount;
    }

    public void setTargetedOfferCount(Integer targetedOfferCount) {
        this.targetedOfferCount = targetedOfferCount;
    }
}
