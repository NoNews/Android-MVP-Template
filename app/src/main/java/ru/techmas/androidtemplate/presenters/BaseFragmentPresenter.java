package ru.techmas.androidtemplate.presenters;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import ru.techmas.androidtemplate.interfaces.views.BaseFragmentView;

/**
 * Created by reg on 23.12.2016.
 */

@InjectViewState
public class BaseFragmentPresenter extends BasePresenter<BaseFragmentView> {

    private boolean inProgress;

    @Deprecated
    public void doSomeThingWithProgress(boolean visible) {

        if (visible) {
            if (!inProgress) {
                inProgress = true;
                getViewState().startProgress();
            }

        } else {
            if (inProgress) getViewState().stopProgress();
        }

    }
}
