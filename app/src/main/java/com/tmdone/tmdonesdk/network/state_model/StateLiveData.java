package com.tmdone.tmdonesdk.network.state_model;

import androidx.lifecycle.MutableLiveData;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:55 AM
 */
public class StateLiveData<T> extends MutableLiveData<StateData<T>> {
    /**
     * Use this to put the Data on a LOADING Status
     */
    public void postLoading() {
        postValue(new StateData<T>().loading());
    }

    /**
     * Use this to put the Data on a ERROR DataStatus
     *
     * @param errorModel the error to be handled
     */
    public void postError(ErrorModel errorModel) {
        postValue(new StateData<T>().error(errorModel));
    }

    /**
     * Use this to put the Data on a SUCCESS DataStatus
     *
     * @param data
     */
    public void postSuccess(T data) {
        postValue(new StateData<T>().success(data));
    }
}
