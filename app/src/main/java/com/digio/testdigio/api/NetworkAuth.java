package com.digio.testdigio.api;

import android.util.Base64;

import com.digio.testdigio.util.AppConstants;

import java.io.UnsupportedEncodingException;

public class NetworkAuth {
    public static String getAuthToken() {
        byte[] data = new byte[0];
        try {
            data = (AppConstants.API_USER_NAME + ":" + AppConstants.API_PASSWORD).getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "Basic " + Base64.encodeToString(data, Base64.NO_WRAP);
    }
}
