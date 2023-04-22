package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 12:14 PM
 */
public class PriceResponse {
    @SerializedName("UnitPrice")
    @Expose
    private double unitPrice;
    @SerializedName("SalePrice")
    @Expose
    private double salePrice;
    @SerializedName("SaleStartDate")
    @Expose
    private String saleStartDate;
    @SerializedName("SaleEndDate")
    @Expose
    private String saleEndDate;
    @SerializedName("Price")
    @Expose
    private double price;
    @SerializedName("IsItemOnSale")
    @Expose
    private Boolean isItemOnSale;
    @SerializedName("DiscountPercentage")
    @Expose
    private double discountPercentage;
    @SerializedName("IsVatExempted")
    @Expose
    private Boolean isVatExempted;
    @SerializedName("Vat")
    @Expose
    private double vat;


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

    public String getSaleStartDate() {
        return saleStartDate;
    }

    public void setSaleStartDate(String saleStartDate) {
        this.saleStartDate = saleStartDate;
    }

    public String getSaleEndDate() {
        return saleEndDate;
    }

    public void setSaleEndDate(String saleEndDate) {
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

    public void setItemOnSale(boolean itemOnSale) {
        isItemOnSale = itemOnSale;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setItemOnSale(Boolean itemOnSale) {
        isItemOnSale = itemOnSale;
    }

    public Boolean getVatExempted() {
        return isVatExempted;
    }

    public void setVatExempted(Boolean vatExempted) {
        isVatExempted = vatExempted;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }
}
