package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 2:55 PM
 */
public class PaymentMethodsResponse implements Serializable {
    @SerializedName("ArabicDescription")
    @Expose
    private String arabicDescription;

    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;

    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("Code")
    @Expose
    private String code;

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
