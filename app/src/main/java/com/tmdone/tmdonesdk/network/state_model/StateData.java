package com.tmdone.tmdonesdk.network.state_model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:54 AM
 */
public class StateData<T> {

    @NonNull
    private DataStatus status;

    @Nullable
    private T data;

    @Nullable
    private ErrorModel error;

    public StateData() {
        this.status = DataStatus.CREATED;
        this.data = null;
        this.error = null;
    }

    public StateData<T> loading() {
        this.status = DataStatus.LOADING;
        this.data = null;
        this.error = null;
        return this;
    }

    public StateData<T> success(@NonNull T data) {
        this.status = DataStatus.SUCCESS;
        this.data = data;
        this.error = null;
        return this;
    }

    public StateData<T> error(@NonNull ErrorModel error) {
        this.status = DataStatus.ERROR;
        this.data = null;
        this.error = error;
        return this;
    }

    @NonNull
    public DataStatus getStatus() {
        return status;
    }

    @Nullable
    public T getData() {
        return data;
    }

    @Nullable
    public ErrorModel getError() {
        return error;
    }

    public enum DataStatus {
        CREATED,
        SUCCESS,
        ERROR,
        LOADING
    }
}
