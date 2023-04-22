package com.tmdone.tmdonesdk.app.uimodels;

import android.os.Parcel;
import android.os.Parcelable;

public class SingleRestaurantItemHeader extends SingleRestaurantItem implements Parcelable {

    public SingleRestaurantItemHeader() {
    }

    public SingleRestaurantItemHeader(String name) {
        this.name = name;
    }


    public static final Creator<SingleRestaurantItemHeader> CREATOR = new Creator<SingleRestaurantItemHeader>() {
        @Override
        public SingleRestaurantItemHeader createFromParcel(Parcel in) {
            return new SingleRestaurantItemHeader(in);
        }

        @Override
        public SingleRestaurantItemHeader[] newArray(int size) {
            return new SingleRestaurantItemHeader[size];
        }
    };

    protected SingleRestaurantItemHeader(Parcel in) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
