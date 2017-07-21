package com.softard.wow.meterialdesign.internet;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wow on 17-7-21.
 */

public class HttpUtils {
    public static OkHttpClient client = new OkHttpClient();

    public static String get(String url) {
        client.newBuilder().connectTimeout(10000, TimeUnit.MILLISECONDS);
        Request request = new Request.Builder().url(url).build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }
}
