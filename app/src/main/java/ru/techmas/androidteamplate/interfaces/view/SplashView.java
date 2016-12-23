package ru.techmas.androidteamplate.interfaces.view;

import com.arellomobile.mvp.MvpView;

public interface SplashView extends MvpView {

    void showErrorConnection();
    void goneErrorConnection();

}
