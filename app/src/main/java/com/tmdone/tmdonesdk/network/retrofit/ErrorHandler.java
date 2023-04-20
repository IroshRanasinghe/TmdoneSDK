package com.tmdone.tmdonesdk.network.retrofit;



import android.content.Context;

import com.tmdone.tmdonesdk.R;
import com.tmdone.tmdonesdk.network.state_model.ErrorModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Objects;

import retrofit2.HttpException;

/**
 * @Author Shalitha Samarasignghe
 * @create 1/8/2021 4:04 PM
 */

public class ErrorHandler {

    private final Context mApplicationContext;

    public ErrorHandler(Context applicationContext) {
        mApplicationContext = applicationContext.getApplicationContext();
    }

    /**
     * if the API has used some other key to return the Error message , add it to here
     *
     * @return
     */
    public ErrorModel getError(Throwable error) {
        String errorMessage;
        errorMessage = mApplicationContext.getString(R.string.msg_something_went_wrong);


        ErrorModel errorModel = new ErrorModel(errorMessage);  // TODO can customize common error msg here
        try {
            if (error instanceof SocketTimeoutException) {
                error.printStackTrace();
            } else if (error instanceof UnknownHostException || error instanceof ConnectException) {
                errorMessage = mApplicationContext.getString(R.string.msg_network_not_available);
                errorModel.setErrorMessage(errorMessage);
                error.printStackTrace();
            } else if (error instanceof HttpException) {
                errorModel.setErrorCode(((HttpException) error).code());
                JSONObject errorObject = new JSONObject(new String(Objects.requireNonNull(Objects.requireNonNull(((HttpException) error).response()).errorBody()).bytes()));
                if (errorObject.has("error_description")) {
                    errorModel.setErrorMessage(errorObject.getString("error_description"));
                } else if (errorObject.has("error")) {
                    errorModel.setErrorMessage(errorObject.getString("error"));
                } else if (errorObject.has("ModelState")) {
                    JSONObject modelState = errorObject.getJSONObject("ModelState");
                    JSONArray jsonArray = modelState.getJSONArray("");
                    errorModel.setErrorMessage(jsonArray.getString(0));
                } else if (errorObject.has("Message")) {
                    errorModel.setErrorMessage(errorObject.getString("Message"));
                } else if (errorObject.has("error_message")) {
                    errorModel.setErrorMessage(errorObject.getString("error_message"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return errorModel;
    }
}
