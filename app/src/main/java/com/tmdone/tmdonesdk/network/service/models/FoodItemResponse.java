package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:03 PM
 */
public class FoodItemResponse {
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Menus")
    @Expose
    private List<MenuesResponse> menus = null;
    @SerializedName("MenuCategories")
    @Expose
    private List<MenuCategoryResponse> menuCategories = null;
    @SerializedName("Cuisines")
    @Expose
    private List<CuisineResponse> cuisines = null;
    @SerializedName("Attributes")
    @Expose
    private List<AttributeResponse> attributes = null;
    @SerializedName("PrepTime")
    @Expose
    private Double prepTime;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("ArabicDescription")
    @Expose
    private String arabicDescription;
    @SerializedName("Sku")
    @Expose
    private String sku;
    @SerializedName("IsFeatured")
    @Expose
    private Boolean isFeatured;
    @SerializedName("Price")
    @Expose
    private PriceResponse price;
    @SerializedName("Rating")
    @Expose
    private double rating;
    @SerializedName("RatedCount")
    @Expose
    private Integer ratedCount;
    @SerializedName("IsInStock")
    @Expose
    private Boolean isInStock;
    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;
    @SerializedName("Status")
    @Expose
    private String status;

    @SerializedName("ArabicName")
    @Expose
    private String arabicName;

//    PreferenceManager preferenceManager;
//    Context context;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<MenuesResponse> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuesResponse> menus) {
        this.menus = menus;
    }

    public List<MenuCategoryResponse> getMenuCategories() {
        return menuCategories;
    }

    public void setMenuCategories(List<MenuCategoryResponse> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public List<CuisineResponse> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<CuisineResponse> cuisines) {
        this.cuisines = cuisines;
    }

    public List<AttributeResponse> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeResponse> attributes) {
        this.attributes = attributes;
    }

    public Double getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(Double prepTime) {
        this.prepTime = prepTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getName(Context context) {
//        if(context != this.context){
//            preferenceManager = null;
//        }
//
//        if(preferenceManager==null){
//            this.context = context;
//            preferenceManager = new PreferenceManager(context);
//        }
//
//        if(preferenceManager.getBoolean(Constants.PREF_IS_ARAB)){
//            if(ExtenstionMethods.isNotEmptyString(getArabicName()))
//                return getArabicName();
//            else
//                return name;
//        }
//
//        return name;
//    }

//    public String getDescription(Context context) {
//        if(context != this.context){
//            preferenceManager = null;
//        }
//
//        if(preferenceManager==null){
//            this.context = context;
//            preferenceManager = new PreferenceManager(context);
//        }
//        if(preferenceManager.getBoolean(Constants.PREF_IS_ARAB)){
//            if(ExtenstionMethods.isNotEmptyString(getArabicDescription()))
//                return getArabicDescription();
//            else
//                return description;
//        }
//
//        return description;
//    }\


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public String getEnglishName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
    }

    public PriceResponse getPrice() {
        return price;
    }

    public void setPrice(PriceResponse price) {
        this.price = price;
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

    public Boolean getInStock() {
        return isInStock;
    }

    public void setInStock(Boolean inStock) {
        isInStock = inStock;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }
}
