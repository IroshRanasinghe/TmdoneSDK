package com.tmdone.tmdonesdk.network.state_model;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import androidx.annotation.Nullable;

import com.tmdone.tmdonesdk.BuildConfig;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 10:51 AM
 */
public class ErrorModel {
    private int errorCode = -1;
    private String errorMessage;

    @Nullable
    private Object errorData;


    public ErrorModel(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        if (errorMessage.equals("")) {
            return showDefaultMessageAccordingToLocal();
        } else {
            if (errorMessage.contains(BuildConfig.API_URL) || errorMessage.contains("https://demopaygate.tmdone.com") || errorMessage.contains("https://demoanalytics.tmdone.com") || errorMessage.contains("The requested resource does not support http")) {
                return showDefaultMessageAccordingToLocal();
            } else {
                return errorMessage;
            }
        }
    }

    private String showDefaultMessageAccordingToLocal() {
        if (CONST_IS_USER_LANGUAGE_AR) {
            return "حدث خطأ ما! الرجاء المحاولة مرة أخرى.";
        } else {
            return "Oops, Something Went Wrong..Please Try Again!";
        }
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Nullable
    public Object getErrorData() {
        return errorData;
    }

    public void setErrorData(@Nullable Object errorData) {
        this.errorData = errorData;
    }
}
