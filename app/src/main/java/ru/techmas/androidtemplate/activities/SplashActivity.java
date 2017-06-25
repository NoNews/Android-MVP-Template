package ru.techmas.androidtemplate.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import ru.techmas.androidtemplate.R;
import ru.techmas.androidtemplate.interfaces.views.SplashView;
import ru.techmas.androidtemplate.presenters.SplashPresenter;
import ru.techmas.androidtemplate.utils.Injector;


public class SplashActivity extends BaseActivity implements SplashView {


    private static final int LAYOUT = R.layout.activity_splash;


    @InjectPresenter
    SplashPresenter splashPresenter;

    @ProvidePresenter
    SplashPresenter provideSplashPresenter() {
        return Injector.getPresenterComponent().getSplashPresenter();
    }

    private LinearLayout ltBackground;
    private Button btnRepeat;
    private TextView tvSomethingWentWrong;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        setupUI();
        setupUX();
        getMvpDelegate().onAttach();
    }


    @Override
    public void setupUX() {
        btnRepeat.setOnClickListener(v -> splashPresenter.startNext());
    }


    @Override
    public final void showErrorConnection(boolean show) {
        if (show) {
            hideView(progressBar);
            showView(ltBackground);

            animationHelper.scaleIn(tvSomethingWentWrong);
        } else hideView(ltBackground);
    }


    @Override
    public void setupUI() {
        ltBackground = bindView(R.id.ltBackground);
        btnRepeat = bindView(R.id.btnRepeat);
        tvSomethingWentWrong = bindView(R.id.tvSomethingWentWrong);
        progressBar = bindView(R.id.progressBar);
    }

}
