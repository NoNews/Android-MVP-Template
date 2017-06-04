package ru.techmas.androidtemplate.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.R;
import ru.techmas.androidtemplate.interfaces.views.SplashView;
import ru.techmas.androidtemplate.presenters.SplashPresenter;


public class SplashActivity extends BaseActivity implements SplashView {


    private static final int LAYOUT = R.layout.activity_splash;


    @InjectPresenter
    SplashPresenter splashPresenter;

    @ProvidePresenter
    SplashPresenter provideSplashPresenter() {
        return App.getPresenterComponent().getSplashPresenter();
    }

    private LinearLayout ltBackground;
    private Button btnRepeat;
    private TextView tvSomethingWentWrong;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        bindViews();
        setupListeners();
        getMvpDelegate().onAttach();
    }

    private void setupListeners() {
        btnRepeat.setOnClickListener(v -> splashPresenter.startNext());
    }


    private void bindViews() {
        ltBackground = bindView(R.id.ltBackground);
        btnRepeat = bindView(R.id.btnRepeat);
        tvSomethingWentWrong = bindView(R.id.tvSomethingWentWrong);
        progressBar = bindView(R.id.progressBar);
    }

    @Override
    public final void showErrorConnection(boolean show) {
        if (show) {
            hideView(progressBar);
            showView(ltBackground);
            animationHelper.scaleIn(tvSomethingWentWrong);
        } else hideView(ltBackground);
    }
}
