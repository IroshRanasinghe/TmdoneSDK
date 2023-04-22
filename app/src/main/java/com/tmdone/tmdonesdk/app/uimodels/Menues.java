package com.tmdone.tmdonesdk.app.uimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:07 PM
 */
public class Menues {
    @SerializedName("IsCurrent")
    @Expose
    private Boolean isCurrent;
    @SerializedName("IsDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;


    public Boolean getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Boolean current) {
        isCurrent = current;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
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

    public String getEnglishName() {
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
}
