package ru.techmas.androidtemplate.api.error;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Date: 04.06.2017
 * Time: 12:29
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */


// TODO: 04.06.2017 Refactor that
public class ApiError extends Throwable {
    public ApiError(ResponseBody responseBody) {
        super(getMessage(responseBody));
    }


    private static String getMessage(ResponseBody responseBody) {
        try {
            return new JSONObject(responseBody.string()).optString("message");
        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        return "Unknown exception";
    }
}
