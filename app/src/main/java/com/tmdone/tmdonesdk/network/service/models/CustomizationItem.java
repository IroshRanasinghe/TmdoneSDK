package com.tmdone.tmdonesdk.network.service.models;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.content.Context;
import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:19 PM
 */
public class CustomizationItem implements Serializable {
    private static final String TAG = "CustomizationItem";
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ItemName")
    @Expose
    private String ItemName;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;

    @SerializedName("ItemNameArabic")
    @Expose
    private String ItemNameArabic;

    @SerializedName("Price")
    @Expose
    private double price;
    @SerializedName("Quantity")
    @Expose
    private Integer quantity;
    @SerializedName("ItemTotal")
    @Expose
    private double itemTotal;
    //    PreferenceManager preferenceManager;
    Context context;

    public CustomizationItem(String name, double price, Integer quantity, double itemTotal) {
        this.ItemName = name;
        this.price = price;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }

    public CustomizationItem(String name, String ItemNameArabic, double price, Integer quantity, double itemTotal) {
        this.ItemName = name;
        this.ItemNameArabic = ItemNameArabic;
        this.price = price;
        this.quantity = quantity;
        this.itemTotal = itemTotal;
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            Log.e(TAG, "ARABIC NAME: " + arabicName);
            return arabicName;
        } else {
            Log.e(TAG, "ENGLISH NAME: " + name);
            return name;
        }
    }

    public String getEnglishName() {
        return name;
    }

    public String getEnglishItemName() {
        return ItemName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemName() {
        if (ItemNameArabic != null) {
            if (CONST_IS_USER_LANGUAGE_AR)
                return ItemNameArabic;
            else
                return ItemName;
        } else {
            return ItemName;
        }


    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getItemNameArabic() {
        return ItemNameArabic;
    }

    public void setItemNameArabic(String itemNameArabic) {
        ItemNameArabic = itemNameArabic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
