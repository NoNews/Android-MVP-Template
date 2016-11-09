package com.example.bikal.generaltemplate.ui.fragments;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatFragment;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseFragment extends MvpAppCompatFragment {

    protected   String TAG;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
    }
}
