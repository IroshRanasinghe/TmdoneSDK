package com.tmdone.tmdonesdk.app.uimodels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:02 PM
 */
public class UserOffer  implements Parcelable{
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("DisplayTime")
    @Expose
    private int displayTime;
    @SerializedName("DisplayInterval")
    @Expose
    private int displayInterval;
    @SerializedName("RemainingSeconds")
    @Expose
    private double remainingSeconds;

    protected UserOffer(Parcel in) {
        id = in.readString();
        name = in.readString();
        description = in.readString();
        displayTime = in.readInt();
        displayInterval = in.readInt();
        remainingSeconds = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeInt(displayTime);
        dest.writeInt(displayInterval);
        dest.writeDouble(remainingSeconds);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<UserOffer> CREATOR = new Parcelable.Creator<UserOffer>() {
        @Override
        public UserOffer createFromParcel(Parcel in) {
            return new UserOffer(in);
        }

        @Override
        public UserOffer[] newArray(int size) {
            return new UserOffer[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDisplayTime() {
        return displayTime;
    }

    public void setDisplayTime(int displayTime) {
        this.displayTime = displayTime;
    }

    public int getDisplayInterval() {
        return displayInterval;
    }

    public void setDisplayInterval(int displayInterval) {
        this.displayInterval = displayInterval;
    }

    public double getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(double remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }
}
