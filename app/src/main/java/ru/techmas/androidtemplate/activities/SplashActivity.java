package ru.techmas.androidtemplate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
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
        return App.getAppComponent().getSplashPresenter();
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
        splashPresenter.startActivityWithFragment();
    }

    private void setupListeners() {
        btnRepeat.setOnClickListener(v -> onClickRepeatRequest());
    }


    public void onClickRepeatRequest() {
        progressBar.setVisibility(View.VISIBLE);
        splashPresenter.startActivityWithFragment();
    }

    @Override
    public void showErrorConnection() {
        progressBar.setVisibility(View.INVISIBLE);
        ltBackground.setVisibility(View.VISIBLE);
        tvSomethingWentWrong.startAnimation(AnimationUtils.loadAnimation(this, R.anim.error_translation));
    }

    @Override
    public void goneErrorConnection() {
        ltBackground.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMainActivity() {
        Intent intent = MainActivity.getIntent(this);
        startActivity(intent);
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
        finish();
    }

    private void bindViews() {
        ltBackground = bindView(R.id.ltBackground);
        btnRepeat = bindView(R.id.btnRepeat);
        tvSomethingWentWrong = bindView(R.id.tvSomethingWentWrong);
        progressBar = bindView(R.id.progressBar);
    }
}
