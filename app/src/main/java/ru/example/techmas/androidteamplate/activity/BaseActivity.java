package ru.example.techmas.androidteamplate.activity;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import ru.example.techmas.androidteamplate.App;
import ru.example.techmas.androidteamplate.api.RestApi;
import ru.example.techmas.androidteamplate.utils.PreferenceHelper;


import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseActivity extends MvpAppCompatActivity {

    //@formatter:off
    @Inject protected RestApi restApi;
    @Inject protected PreferenceHelper preferenceHelper;
    //@formatter:on
    protected String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDagger();
        setupTag();
    }

    private void setupTag() {
        TAG = this.getClass().getSimpleName();
    }

    private void injectDagger() {
        ((App) getApplication()).getAppComponent().inject(this);
    }

    protected void startBus(){
        EventBus.getDefault().register(this);
    }

    protected void stopBus(){
        EventBus.getDefault().unregister(this);
    }

    protected void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
