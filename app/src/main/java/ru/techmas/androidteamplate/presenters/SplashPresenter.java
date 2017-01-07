package ru.techmas.androidteamplate.presenters;

import ru.techmas.androidteamplate.App;
import ru.techmas.androidteamplate.api.RestApi;
import ru.techmas.androidteamplate.interfaces.views.SplashView;
import ru.techmas.androidteamplate.utils.PreferenceHelper;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

@InjectViewState
public class SplashPresenter extends MvpPresenter<SplashView> {


    //@formatter:off
    @Inject RestApi restApi;
    @Inject PreferenceHelper preferenceHelper;
    //@formatter:on


    public SplashPresenter() {
        App.getAppComponent().inject(this);
    }

    public void startActivityWithFragment() {

        if (preferenceHelper.isFirstRun()){
            getViewState().showMainActivity();
        }
        //// TODO: Rest here
        ///TODO: Any logic here
    }
}
