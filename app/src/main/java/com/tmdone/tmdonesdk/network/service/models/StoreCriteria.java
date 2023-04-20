package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:58 AM
 */
public class StoreCriteria {
    @SerializedName("Sector")
    @Expose
    private String sector;
    @SerializedName("Keyword")
    @Expose
    private String keyword;
    @SerializedName("BrandCode")
    @Expose
    private String brandCode;
    @SerializedName("IsFeatured")
    @Expose
    private Boolean isFeatured;
    @SerializedName("Cuisines")
    @Expose
    private List<String> cuisines = null;
    @SerializedName("Attributes")
    @Expose
    private List<String> attributes = null;
    @SerializedName("Page")
    @Expose
    private Integer page;
    @SerializedName("NearByCords")
    @Expose
    private List<Double> nearByCords = null;
    @SerializedName("SortBy")
    @Expose
    private String sortBy;

    @SerializedName("ChainId")
    @Expose
    private String chainId;
    @SerializedName("IsSpecial")
    @Expose
    private Boolean isSpecial;
    @SerializedName("VendorTypes")
    @Expose
    private List<String> vendorTypes;
    @SerializedName("IsPickup")
    @Expose
    private Boolean isPickup;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public Boolean getFeatured() {
        return isFeatured;
    }

    public void setFeatured(Boolean featured) {
        isFeatured = featured;
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<Double> getNearByCords() {
        return nearByCords;
    }

    public void setNearByCords(List<Double> nearByCords) {
        this.nearByCords = nearByCords;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Boolean getSpecial() {
        return isSpecial;
    }

    public void setSpecial(Boolean special) {
        isSpecial = special;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public List<String> getVendorTypes() {
        return vendorTypes;
    }

    public void setVendorTypes(List<String> vendorTypes) {
        this.vendorTypes = vendorTypes;
    }

    public Boolean getPickup() {
        return isPickup;
    }

    public void setPickup(Boolean pickup) {
        isPickup = pickup;
    }
}
