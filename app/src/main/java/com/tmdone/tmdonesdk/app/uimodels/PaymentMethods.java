package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 3:00 PM
 */
public class PaymentMethods implements Parcelable{
    @SerializedName("ArabicDescription")
    @Expose
    private String arabicDescription;

    @SerializedName("IsDeleted")
    @Expose
    private Boolean isDeleted;

    @SerializedName("Description")
    @Expose
    private String description;

    @SerializedName("IsActive")
    @Expose
    private Boolean isActive;

    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("Id")
    @Expose
    private String id;

    @SerializedName("Code")
    @Expose
    private String code;

    public static final Parcelable.Creator<PaymentMethods> CREATOR = new Parcelable.Creator<PaymentMethods>() {
        @Override
        public PaymentMethods createFromParcel(Parcel in) {
            return new PaymentMethods(in);
        }

        @Override
        public PaymentMethods[] newArray(int size) {
            return new PaymentMethods[size];
        }
    };

    protected PaymentMethods(Parcel in) {
        arabicDescription = in.readString();
        byte tmpIsDeleted = in.readByte();
        isDeleted = tmpIsDeleted == 0 ? null : tmpIsDeleted == 1;
        description = in.readString();
        byte tmpIsActive = in.readByte();
        isActive = tmpIsActive == 0 ? null : tmpIsActive == 1;
        imageUrl = in.readString();
        id = in.readString();
        code = in.readString();
    }

    public String getArabicDescription() {
        return arabicDescription;
    }

    public void setArabicDescription(String arabicDescription) {
        this.arabicDescription = arabicDescription;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getDescription() {
        if (CONST_IS_USER_LANGUAGE_AR)
            return arabicDescription;
        else
            return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(arabicDescription);
        dest.writeByte((byte) (isDeleted == null ? 0 : isDeleted ? 1 : 2));
        dest.writeString(description);
        dest.writeByte((byte) (isActive == null ? 0 : isActive ? 1 : 2));
        dest.writeString(imageUrl);
        dest.writeString(id);
        dest.writeString(code);
    }
}
