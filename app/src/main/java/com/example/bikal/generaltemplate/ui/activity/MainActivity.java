package com.example.bikal.generaltemplate.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bikal.generaltemplate.R;
import com.example.bikal.generaltemplate.mvp.view.MainView;
import com.example.bikal.generaltemplate.mvp.presenter.MainPresenter;


import com.arellomobile.mvp.presenter.InjectPresenter;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView {

    private static final int LAYOUT = R.layout.activity_main;

    //@formatter:off
    @InjectPresenter MainPresenter mainPresenter;
    @BindView(R.id.tvHello) TextView tvHello;
    //@formatter:on


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
    }





    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}
