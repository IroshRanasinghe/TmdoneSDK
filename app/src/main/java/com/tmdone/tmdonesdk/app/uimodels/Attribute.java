package com.tmdone.tmdonesdk.app.uimodels;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tmdone.tmdonesdk.app.utility.ExtenstionMethods;

import coil.Coil;
import coil.ImageLoader;
import coil.request.ImageRequest;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:09 PM
 */
public class Attribute implements Parcelable{
    @SerializedName("ImageUrl")
    @Expose
    private String imageUrl;

    @SerializedName("Code")
    @Expose
    private String code;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;

    @SerializedName("OrderType")
    @Expose
    private String orderType;

    private boolean mIsSelected;


    public static final Parcelable.Creator<Attribute> CREATOR = new Parcelable.Creator<Attribute>() {
        @Override
        public Attribute createFromParcel(Parcel in) {
            return new Attribute(in);
        }

        @Override
        public Attribute[] newArray(int size) {
            return new Attribute[size];
        }
    };
    private boolean isChecked;

    protected Attribute(Parcel in) {
        imageUrl = in.readString();
        code = in.readString();
        name = in.readString();
        arabicName = in.readString();
        byte tmpIsChecked = in.readByte();
        isChecked = tmpIsChecked == 0 ? null : tmpIsChecked == 1;
        orderType = in.readString();
    }

    public Attribute() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            if (ExtenstionMethods.isNotEmptyString(arabicName))
                return arabicName;
            else
                return name;
        } else
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

    @BindingAdapter({"attributeImage"})
    public static void loadAttributeLogo(ImageView imageView, String logoUrl) {
        ImageLoader imageLoader = Coil.imageLoader(imageView.getContext());
        ImageRequest imageRequest = new ImageRequest.Builder(imageView.getContext())
                .data(logoUrl)
                .crossfade(true)
                .target(imageView)
                .build();
        imageLoader.enqueue(imageRequest);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeString(code);
        dest.writeString(name);
        dest.writeString(arabicName);
        dest.writeString(orderType);
        dest.writeByte((byte) (isChecked ? 1 : 2));
    }

    public boolean isIsSelected() {
        return mIsSelected;
    }

    public void setIsSelected(boolean mIsSelected) {
        this.mIsSelected = mIsSelected;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public boolean ismIsSelected() {
        return mIsSelected;
    }

    public void setmIsSelected(boolean mIsSelected) {
        this.mIsSelected = mIsSelected;
    }

    public boolean isChecked() {
        return isChecked;
    }
}
