package ru.techmas.androidtemplate.presenters;

import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.interfaces.views.SplashView;
import ru.techmas.androidtemplate.utils.PreferenceHelper;

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
