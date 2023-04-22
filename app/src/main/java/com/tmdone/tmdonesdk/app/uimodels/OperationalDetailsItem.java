package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:01 PM
 */
public class OperationalDetailsItem implements Parcelable {
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

    public static final Parcelable.Creator<OperationalDetailsItem> CREATOR = new Parcelable.Creator<OperationalDetailsItem>() {
        @Override
        public OperationalDetailsItem createFromParcel(Parcel in) {
            return new OperationalDetailsItem(in);
        }

        @Override
        public OperationalDetailsItem[] newArray(int size) {
            return new OperationalDetailsItem[size];
        }
    };

    protected OperationalDetailsItem(Parcel in) {
        endTime = in.readString();
        operationalDayArabic = in.readString();
        startTime = in.readString();
        operationalDay = in.readString();
    }

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
        if (CONST_IS_USER_LANGUAGE_AR)
            return operationalDayArabic;
        else
            return operationalDay;
    }

    public String getAllOperationDetailInSingleString() {
        return getOperationalDay() + "  " + startTime + " - " + endTime;
    }
    public void setOperationalDay(String operationalDay) {
        this.operationalDay = operationalDay;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(endTime);
        dest.writeString(operationalDayArabic);
        dest.writeString(startTime);
        dest.writeString(operationalDay);
    }
}
