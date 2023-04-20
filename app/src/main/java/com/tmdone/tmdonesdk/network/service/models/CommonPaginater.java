package com.tmdone.tmdonesdk.network.service.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:43 AM
 */
public class CommonPaginater<T> {
    @SerializedName("PageCount")
    private int pageCount;

    @SerializedName("PageSize")
    private int pageSize;

    @SerializedName("PageNumber")
    private int pageNumber;

    @SerializedName("TotalItemCount")
    private int totalItemCount;

    @SerializedName("Items")
    private List<T> items;

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
