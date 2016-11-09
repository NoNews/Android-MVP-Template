package com.example.bikal.generaltemplate.ui.fragments;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.example.bikal.generaltemplate.App;
import com.example.bikal.generaltemplate.api.RestApi;
import com.example.bikal.generaltemplate.utils.PreferenceHelper;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseFragment extends MvpAppCompatFragment {

    protected   String TAG;

    //@formatter:off
    @Inject protected RestApi restApi;
    @Inject protected PreferenceHelper preferenceHelper;
    //@formatter:on

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDagger();
        setupTag();
    }


    private void setupTag() {
        TAG = this.getClass().getSimpleName();
    }

    private void injectDagger() {
        ((App) getActivity().getApplication()).getAppComponent().inject(this);
    }

    protected void startBus(){
        EventBus.getDefault().register(this);
    }

    protected void stopBus(){
        EventBus.getDefault().unregister(this);
    }
}