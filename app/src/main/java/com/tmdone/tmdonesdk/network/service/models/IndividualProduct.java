package com.tmdone.tmdonesdk.network.service.models;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:16 PM
 */
public class IndividualProduct implements Serializable {
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("StoreId")
    @Expose
    private String storeId;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Rating")
    @Expose
    private double rating;
    @SerializedName("RatedCount")
    @Expose
    private Integer ratedCount;
    @SerializedName("Price")
    @Expose
    private Price price;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("ArabicDescription")
    @Expose
    private String arabicDescription;
    @SerializedName("Customizations")
    @Expose
    private List<Customizations> customizationsList;
    @SerializedName("onesPerUnit")
    @Expose
    private double onesPerUnit;
    @SerializedName("unit")
    @Expose
    private String unit;
    @SerializedName("CurrentStock")
    @Expose
    private int currentStock;
    @SerializedName("IsFavorite")
    @Expose
    private boolean isFavourite;
    @SerializedName("OfferName")
    @Expose
    private String offerName;
    @SerializedName("OfferArabicName")
    @Expose
    private String offerArabicName;
    @SerializedName("IsNew")
    @Expose
    private boolean isNew;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getEnglishName() {
        return name;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Integer getRatedCount() {
        return ratedCount;
    }

    public void setRatedCount(Integer ratedCount) {
        this.ratedCount = ratedCount;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            if (arabicDescription != null) {
                return arabicDescription;
            } else {
                return description;
            }
        } else {
            return description;
        }
    }

    public String getOfferName() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            if (offerArabicName != null) {
                return offerArabicName;
            } else {
                return offerName;
            }
        } else {
            return offerName;
        }
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public List<Customizations> getCustomizationsList() {
        return customizationsList;
    }

    public void setCustomizationsList(List<Customizations> customizationsList) {
        this.customizationsList = customizationsList;
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            if (arabicName != null) {
                return arabicName;
            } else {
                return name;
            }
        } else {
            return name;
        }
    }

    public String getProductEnglishName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public double getOnesPerUnit() {
        return onesPerUnit;
    }

    public void setOnesPerUnit(double onesPerUnit) {
        this.onesPerUnit = onesPerUnit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(int currentStock) {
        this.currentStock = currentStock;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public String isOfferName() {
        return offerName;
    }

    public String isOfferArabicName() {
        return offerArabicName;
    }

    public void setOfferArabicName(String offerArabicName) {
        this.offerArabicName = offerArabicName;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }
}
