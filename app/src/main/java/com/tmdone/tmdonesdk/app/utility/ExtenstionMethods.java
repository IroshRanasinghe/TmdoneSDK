package com.tmdone.tmdonesdk.app.utility;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 12:39 PM
 */
public class ExtenstionMethods {
    public static boolean isNotEmptyString(String value) {
        return value != null && !value.equalsIgnoreCase("");
    }

}
