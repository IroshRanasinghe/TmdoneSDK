package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 2:56 PM
 */
public class LocationResponse implements Serializable {
    @SerializedName("LocationText")
    @Expose
    private String locationText;
    @SerializedName("Point")
    @Expose
    private List<Double> point = null;
    @SerializedName("Bearing")
    @Expose
    public int bearing;

    public String getLocationText() {
        return locationText;
    }

    public void setLocationText(String locationText) {
        this.locationText = locationText;
    }

    public List<Double> getPoint() {
        return point;
    }

    public void setPoint(List<Double> point) {
        this.point = point;
    }


    public LocationResponse() {
    }

    public LocationResponse(String locationText, List<Double> point) {
        this.locationText = locationText;
        this.point = point;
    }
}
