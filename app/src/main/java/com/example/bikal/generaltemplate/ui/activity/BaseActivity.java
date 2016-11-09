package com.example.bikal.generaltemplate.ui.activity;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseActivity extends MvpAppCompatActivity {


    protected   String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG=this.getClass().getSimpleName();
    }
}
