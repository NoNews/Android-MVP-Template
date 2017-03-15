package ru.techmas.burgerking.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.techmas.burgerking.interfaces.views.MainView;

@InjectViewState
public class MainActivityPresenter extends BasePresenter<MainView> {


    @Inject
    MainActivityPresenter() {

    }

}
