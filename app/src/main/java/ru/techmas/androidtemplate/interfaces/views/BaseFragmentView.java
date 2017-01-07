package ru.techmas.androidtemplate.interfaces.views;

import com.arellomobile.mvp.MvpView;



/**
 * Created by reg on 23.12.2016.
 */

public interface BaseFragmentView extends MvpView, OnProgressBar {

    void startProgress();
    void stopProgress();
}
