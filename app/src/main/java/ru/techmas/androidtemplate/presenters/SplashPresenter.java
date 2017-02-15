package ru.techmas.androidtemplate.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.interfaces.views.SplashView;
import ru.techmas.androidtemplate.utils.PreferenceHelper;

@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {


    @Inject
    public SplashPresenter(RestApi restApi, PreferenceHelper preferenceHelper) {
        this.restApi=restApi;
        this.preferenceHelper=preferenceHelper;
    }

    public void startActivityWithFragment() {

        if (preferenceHelper.isFirstRun()) {
            getViewState().showMainActivity();
        }
        //// TODO: Rest here
        ///TODO: Any logic here
    }
}
