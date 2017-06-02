package ru.techmas.androidtemplate.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.techmas.androidtemplate.interfaces.views.MainView;

@InjectViewState
public class MainActivityPresenter extends BasePresenter<MainView> {


    @Inject
    MainActivityPresenter() {
    }

}
