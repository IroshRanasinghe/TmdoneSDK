package com.tmdone.tmdonesdk.app.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 12:49 PM
 */
public class CommonHelpers {

    public static Gson getGsonDecoderWithNanValueHandler() {
        return new GsonBuilder()
                .serializeSpecialFloatingPointValues()
                .setLenient()
                .setPrettyPrinting()
                .create();
    }
}
