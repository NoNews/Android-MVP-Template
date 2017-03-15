package ru.techmas.burgerking.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.techmas.burgerking.App;
import ru.techmas.burgerking.R;
import ru.techmas.burgerking.interfaces.views.MainView;
import ru.techmas.burgerking.presenters.MainActivityPresenter;

public class MainActivity extends BaseActivity implements MainView {

    private static final int LAYOUT = R.layout.activity_main;

    @InjectPresenter
    MainActivityPresenter mainPresenter;

    @ProvidePresenter
    MainActivityPresenter provideMainActivityPresenter() {
        return App.getAppComponent().getMainActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

    }


    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}
