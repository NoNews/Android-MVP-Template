package ru.techmas.androidteamplate.fragments;

import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import com.arellomobile.mvp.MvpAppCompatFragment;
import ru.techmas.androidteamplate.App;
import ru.techmas.androidteamplate.api.RestApi;
import ru.techmas.androidteamplate.utils.PreferenceHelper;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import static android.content.Context.INPUT_METHOD_SERVICE;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseFragment extends MvpAppCompatFragment {

    protected String TAG;

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

    protected void startBus() {
        EventBus.getDefault().register(this);
    }

    protected void stopBus() {
        EventBus.getDefault().unregister(this);
    }

    protected void hideKeyboard() {
        try {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
