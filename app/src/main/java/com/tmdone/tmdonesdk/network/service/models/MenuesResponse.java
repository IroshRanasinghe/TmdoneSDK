package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 22, April, 2023 1:01 PM
 */
public class MenuesResponse {
    @SerializedName("isActive")
    @Expose
    private Boolean isActive;
    @SerializedName("isDeleted")
    @Expose
    private Boolean isDeleted;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("storeInfo")
    @Expose
    private StoreInfoResponse storeInfoResponse;
    @SerializedName("operationalDetails")
    @Expose
    private List<OperationalDetailResponse> operationalDetails = null;
    @SerializedName("isDefault")
    @Expose
    private Boolean isDefault;
    @SerializedName("isCurrent")
    @Expose
    private Boolean isCurrent;
    @SerializedName("ArabicName")
    @Expose
    private String arabicName;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public StoreInfoResponse getStoreInfoResponse() {
        return storeInfoResponse;
    }

    public void setStoreInfoResponse(StoreInfoResponse storeInfoResponse) {
        this.storeInfoResponse = storeInfoResponse;
    }

    public List<OperationalDetailResponse> getOperationalDetails() {
        return operationalDetails;
    }

    public void setOperationalDetails(List<OperationalDetailResponse> operationalDetails) {
        this.operationalDetails = operationalDetails;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Boolean getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Boolean current) {
        isCurrent = current;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }
}
