package com.tmdone.tmdonesdk.app.uimodels;

public class SingleRestaurantItem {
    String name;

    String headerName;
    private boolean isRequired;
    private Range range;
    private boolean mIsItemExpanded = true;
    private String mCustomizationIdentifier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }

    public String getHeader() {
        return name;
    }

    public void setHeader(String name) {
        this.name = name;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }

    public boolean ismIsItemExpanded() {
        return mIsItemExpanded;
    }

    public void setmIsItemExpanded(boolean mIsItemExpanded) {
        this.mIsItemExpanded = mIsItemExpanded;
    }

    public String getmCustomizationIdentifier() {
        return mCustomizationIdentifier;
    }

    public void setmCustomizationIdentifier(String mCustomizationIdentifier) {
        this.mCustomizationIdentifier = mCustomizationIdentifier;
    }
}
