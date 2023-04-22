package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tmdone.tmdonesdk.network.service.models.PriceResponse;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:11 PM
 */
public class FoodItem {
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Menus")
    @Expose
    private List<Menues> menus = null;
    @SerializedName("MenuCategories")
    @Expose
    private List<MenuCategory> menuCategories = null;
    @SerializedName("Cuisines")
    @Expose
    private List<Cuisine> cuisines = null;
    @SerializedName("Attributes")
    @Expose
    private List<Attribute> attributes = null;
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

    public List<Menues> getMenus() {
        return menus;
    }

    public void setMenus(List<Menues> menus) {
        this.menus = menus;
    }

    public List<MenuCategory> getMenuCategories() {
        return menuCategories;
    }

    public void setMenuCategories(List<MenuCategory> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
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

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR)
            return arabicName;
        else
            return name;
    }

    public void setName(String name) {
        this.name = name;
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
