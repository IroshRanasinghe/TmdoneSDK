package com.tmdone.tmdonesdk.network.service.models;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.content.Context;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:17 PM
 */
public class Customizations implements Serializable {
    @SerializedName("Amount")
    @Expose
    private final double amount;
    @SerializedName("Identifier")
    @Expose
    private String identifier;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;
    //    @SerializedName("Sequence")
//    @Expose
//    private Integer sequence;
    @SerializedName("IsRequired")
    @Expose
    private Boolean isRequired;
    @SerializedName("Type")
    @Expose
    private String type;
    @SerializedName("Range")
    @Expose
    private Range priceRangeResponse;
    @SerializedName("Items")
    @Expose
    private List<CustomizationItem> customizationItemList = null;
    @SerializedName("MenuItemId")
    @Expose
    private String menuItemId;

    public Customizations(double amount) {
        this.amount = amount;
    }

    public Customizations(String identifier, String name, double amount, List<CustomizationItem> customizationItemList) {
        this.name = name;
        this.identifier = identifier;
        this.amount = amount;
        this.customizationItemList = customizationItemList;

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName(Context context) {

        if (arabicName != null) {
            if (CONST_IS_USER_LANGUAGE_AR)
                return arabicName;
            else
                return name;
        } else {
            return name;
        }
    }

    public String getHeaderName() {

        if (arabicName != null) {
            if (CONST_IS_USER_LANGUAGE_AR)
                return arabicName;
            else
                return name;
        } else {
            return name;
        }
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            return arabicName;
        } else {
            return name;
        }
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

//    public Integer getSequence() {
//        return sequence;
//    }
//
//    public void setSequence(Integer sequence) {
//        this.sequence = sequence;
//    }

    public String getEnglishName() {
        return name;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean required) {
        isRequired = required;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Range getRange() {
        return priceRangeResponse;
    }

    public void setRange(Range priceRangeResponse) {
        this.priceRangeResponse = priceRangeResponse;
    }

    public List<CustomizationItem> getCustomizationItemList() {
        return customizationItemList;
    }

    public void setCustomizationItemList(List<CustomizationItem> customizationItemList) {
        this.customizationItemList = customizationItemList;
    }

    public String getMenuItemId() {
        return menuItemId;
    }

    public void setMenuItemId(String menuItemId) {
        this.menuItemId = menuItemId;
    }

    public double getAmount() {
        return amount;
    }
}
