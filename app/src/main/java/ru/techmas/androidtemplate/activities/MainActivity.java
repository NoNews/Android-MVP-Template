package ru.techmas.androidtemplate.activities;


import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.techmas.androidtemplate.R;
import ru.techmas.androidtemplate.interfaces.views.MainView;
import ru.techmas.androidtemplate.presenters.MainActivityPresenter;
import ru.techmas.androidtemplate.utils.Injector;

public class MainActivity extends BaseActivity implements MainView {

    private static final int LAYOUT = R.layout.activity_main;

    @InjectPresenter
    MainActivityPresenter mainPresenter;

    @ProvidePresenter
    MainActivityPresenter provideMainActivityPresenter() {
        return Injector.getPresenterComponent().getMainActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
    }

    @Override
    public void setupUI() {

    }

    @Override
    public void setupUX() {

    }

}
