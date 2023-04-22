package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:03 PM
 */
public class AttributeResponse {
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;
    @SerializedName("OrderType")
    @Expose
    private String orderType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
