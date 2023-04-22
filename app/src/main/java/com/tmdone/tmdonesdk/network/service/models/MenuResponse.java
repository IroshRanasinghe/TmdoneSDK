package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:00 PM
 */
public class MenuResponse {
    @SerializedName("Menus")
    @Expose
    private List<MenuesResponse> menus = null;
    @SerializedName("menuCategories")
    @Expose
    private List<MenuCategoryResponse> menuCategories = null;
    @SerializedName("Cuisines")
    @Expose
    private List<CuisineResponse> cuisines = null;
    @SerializedName("Attributes")
    @Expose
    private List<AttributeResponse> attributes = null;
    @SerializedName("Items")
    @Expose
    private List<FoodItemResponse> items = null;

    public List<MenuesResponse> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuesResponse> menus) {
        this.menus = menus;
    }

    public List<MenuCategoryResponse> getMenuCategories() {
        return menuCategories;
    }

    public void setMenuCategories(List<MenuCategoryResponse> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public List<CuisineResponse> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<CuisineResponse> cuisines) {
        this.cuisines = cuisines;
    }

    public List<AttributeResponse> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeResponse> attributes) {
        this.attributes = attributes;
    }

    public List<FoodItemResponse> getItems() {
        return items;
    }

    public void setItems(List<FoodItemResponse> items) {
        this.items = items;
    }
}
