package ru.techmas.androidteamplate.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.techmas.androidteamplate.interfaces.view.BaseFragmentView;

/**
 * Created by reg on 23.12.2016.
 */

@InjectViewState
public class BaseFragmentPresenter extends MvpPresenter<BaseFragmentView> {

    private boolean inProgress;

    public void doSomeThingWithProgress(boolean visible) {

        if (visible) {
            if (!inProgress){
                inProgress = true;
                getViewState().startProgress();
            }

        } else {
            if (inProgress) getViewState().stopProgress();
        }

    }
}
