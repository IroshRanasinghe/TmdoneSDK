package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:18 PM
 */
public class Range implements Serializable {
    @SerializedName("Minimum")
    @Expose
    private Integer minimum;
    @SerializedName("Maximum")
    @Expose
    private Integer maximum;
    @SerializedName("MaxPerItem")
    @Expose
    private Integer maxPerItem;

    public Integer getMinimum() {
        return minimum;
    }

    public void setMinimum(Integer minimum) {
        this.minimum = minimum;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public Integer getMaxPerItem() {
        return maxPerItem;
    }
}
