package com.example.bikal.generaltemplate.ui.activity;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.example.bikal.generaltemplate.App;
import com.example.bikal.generaltemplate.api.RestApi;
import com.example.bikal.generaltemplate.utils.EventMessage;


import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseActivity extends MvpAppCompatActivity {

    //@formatter:off
    @Inject protected RestApi restApi;
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
}
