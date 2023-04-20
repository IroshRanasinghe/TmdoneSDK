package com.tmdone.tmdonesdk.app.utility;

import static com.tmdone.tmdonesdk.core.Constants.CONST_IS_USER_LANGUAGE_AR;

import java.util.Locale;

/**
 * @Author: Iroshana Ranasinghe
 * @Date: 19, April, 2023 4:40 PM
 */
public class DoubleUtility {
    public static String getFormattedAsTwoDecimalsWithoutLocale(Double value) {
        if (value == null) {
            return "";
        }
        return String.format(Locale.ENGLISH, "%.2f", value);
    }

    public static String getFormattedAsCurrency(Double value, boolean attacheOmr) {
        String mValue = String.format(Locale.ENGLISH, "%.3f", value);
        if (attacheOmr) {
            if (CONST_IS_USER_LANGUAGE_AR) {
                mValue = mValue + " ر.ع ";
            } else {
                mValue = mValue + " OMR";
            }
        }
        return mValue;
    }
}

