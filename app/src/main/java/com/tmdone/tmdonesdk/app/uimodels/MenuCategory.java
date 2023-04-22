package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:08 PM
 */
public class MenuCategory {
    @SerializedName("Id")
    @Expose
    private String Id;
    @SerializedName("Index")
    @Expose
    private int index;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR)
            return arabicName;
        else
            return name;
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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
