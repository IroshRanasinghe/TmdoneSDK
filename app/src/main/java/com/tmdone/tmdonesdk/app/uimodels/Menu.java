package com.tmdone.tmdonesdk.app.uimodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:07 PM
 */
public class Menu {
    @SerializedName("Menus")
    @Expose
    private List<Menues> menus;
    @SerializedName("menuCategories")
    @Expose
    private List<MenuCategory> menuCategories;
    @SerializedName("Cuisines")
    @Expose
    private List<Cuisine> cuisines;
    @SerializedName("Attributes")
    @Expose
    private List<Attribute> attributes;
    @SerializedName("Items")
    @Expose
    private List<FoodItem> items;

    public List<Menues> getMenus() {
        return menus;
    }

    public void setMenus(List<Menues> menus) {
        this.menus = menus;
    }

    public List<MenuCategory> getMenuCategories() {
        return menuCategories;
    }

    public void setMenuCategories(List<MenuCategory> menuCategories) {
        this.menuCategories = menuCategories;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<FoodItem> getItems() {
        return items;
    }

    public void setItems(List<FoodItem> items) {
        this.items = items;
    }
}
