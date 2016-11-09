package com.example.bikal.generaltemplate.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.bikal.generaltemplate.R;
import com.example.bikal.generaltemplate.mvp.view.MainView;
import com.example.bikal.generaltemplate.mvp.presenter.MainPresenter;


import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends BaseActivity implements MainView {

    public static final String TAG = "MainActivity";
    @InjectPresenter MainPresenter mMainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

}
