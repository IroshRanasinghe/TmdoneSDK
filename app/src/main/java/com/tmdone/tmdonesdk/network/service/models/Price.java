package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:16 PM
 */
public class Price implements Serializable {
    @SerializedName("UnitPrice")
    @Expose
    private double unitPrice;
    @SerializedName("SalePrice")
    @Expose
    private double salePrice;
    @SerializedName("SaleStartDate")
    @Expose
    private Object saleStartDate;
    @SerializedName("SaleEndDate")
    @Expose
    private Object saleEndDate;
    @SerializedName("Price")
    @Expose
    private double price;
    @SerializedName("IsItemOnSale")
    @Expose
    private Boolean isItemOnSale;
    @SerializedName("DiscountPercentage")
    @Expose
    private double discountPercentage;

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public Object getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(Object saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public Object getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(Object saleEndDate) {
        this.saleEndDate = saleEndDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Boolean getItemOnSale() {
        return isItemOnSale;
    }

    public void setItemOnSale(Boolean itemOnSale) {
        isItemOnSale = itemOnSale;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
