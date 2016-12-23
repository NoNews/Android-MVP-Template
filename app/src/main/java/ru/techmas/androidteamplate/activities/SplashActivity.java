package ru.techmas.androidteamplate.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.techmas.androidteamplate.R;
import ru.techmas.androidteamplate.interfaces.view.SplashView;
import ru.techmas.androidteamplate.presenters.SplashPresenter;


public class SplashActivity extends BaseActivity implements SplashView {


    private static final int LAYOUT = R.layout.activity_splash;

    //@formatter:off
    @InjectPresenter SplashPresenter splashPresenter;
    @BindView(R.id.ltBackground) LinearLayout ltBackground;
    @BindView(R.id.btnRepeat) Button btnRepeat;
    @BindView(R.id.tvSomethingWentWrong) TextView tvSomethingWentWrong;
    @BindView(R.id.progressBar) ProgressBar progressBar;
    //@formatter:on


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
        splashPresenter.startActivityWithFragment();
    }


    @OnClick(R.id.btnRepeat)
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
    }
}
