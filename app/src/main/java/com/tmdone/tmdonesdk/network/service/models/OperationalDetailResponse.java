package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:01 PM
 */
public class OperationalDetailResponse {
    @SerializedName("operationalDay")
    @Expose
    private String operationalDay;
    @SerializedName("startTime")
    @Expose
    private String startTime;
    @SerializedName("endTime")
    @Expose
    private String endTime;
    @SerializedName("daysOfWeek")
    @Expose
    private List<String> daysOfWeek = null;

    public String getOperationalDay() {
        return operationalDay;
    }

    public void setOperationalDay(String operationalDay) {
        this.operationalDay = operationalDay;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<String> getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(List<String> daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }
}
