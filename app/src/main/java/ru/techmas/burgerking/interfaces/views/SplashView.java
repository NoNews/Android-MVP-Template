package ru.techmas.burgerking.interfaces.views;

import com.arellomobile.mvp.MvpView;

public interface SplashView extends MvpView {

    void showErrorConnection();
    void goneErrorConnection();

    void showMainActivity();

}
