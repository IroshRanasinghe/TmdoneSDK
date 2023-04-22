package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 2:56 PM
 */
public class OperationalDetailsItemResponse {
    @SerializedName("EndTime")
    @Expose
    private String endTime;

    @SerializedName("OperationalDayArabic")
    @Expose
    private String operationalDayArabic;

    @SerializedName("StartTime")
    @Expose
    private String startTime;

    @SerializedName("OperationalDay")
    @Expose
    private String operationalDay;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getOperationalDayArabic() {
        return operationalDayArabic;
    }

    public void setOperationalDayArabic(String operationalDayArabic) {
        this.operationalDayArabic = operationalDayArabic;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getOperationalDay() {
        return operationalDay;
    }

    public void setOperationalDay(String operationalDay) {
        this.operationalDay = operationalDay;
    }
}
