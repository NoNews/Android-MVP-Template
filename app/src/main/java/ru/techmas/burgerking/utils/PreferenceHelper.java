package ru.techmas.burgerking.utils;

import android.content.SharedPreferences;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class PreferenceHelper {

    private static final String PREF_TOKEN_API = "tokenAPI";
    private SharedPreferences preferences;
    private String token;

    public PreferenceHelper(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    public String getToken() {
        if (token == null) token = preferences.getString(PREF_TOKEN_API, "");
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        preferences.edit().putString(PREF_TOKEN_API, token).apply();
    }

    public boolean isFirstRun() {
        return !preferences.contains(PREF_TOKEN_API);
    }

    public void exit() {
        preferences.edit().clear().apply();
    }

}

