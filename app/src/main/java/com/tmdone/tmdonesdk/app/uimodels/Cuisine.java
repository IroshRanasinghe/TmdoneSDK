package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:08 PM
 */
public class Cuisine implements Parcelable{
    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;

    public static final Parcelable.Creator<Cuisine> CREATOR = new Parcelable.Creator<Cuisine>() {
        @Override
        public Cuisine createFromParcel(Parcel in) {
            return new Cuisine(in);
        }

        @Override
        public Cuisine[] newArray(int size) {
            return new Cuisine[size];
        }
    };
    //
    private boolean isSelected;

    protected Cuisine(Parcel in) {
        id = in.readString();
        code = in.readString();
        name = in.readString();
        arabicName = in.readString();
        isSelected = in.readByte() != 0;
    }

    public Cuisine() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(code);
        dest.writeString(name);
        dest.writeString(arabicName);
        dest.writeByte((byte) (isSelected ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR)
            return arabicName;
        else
            return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
