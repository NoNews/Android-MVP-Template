package ru.techmas.burgerking.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.techmas.burgerking.api.RestApi;
import ru.techmas.burgerking.interfaces.views.SplashView;
import ru.techmas.burgerking.utils.PreferenceHelper;

@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {


    @Inject
    SplashPresenter(RestApi restApi, PreferenceHelper preferenceHelper) {
        this.restApi = restApi;
        this.preferenceHelper = preferenceHelper;
    }

    public void startActivityWithFragment() {

        if (preferenceHelper.isFirstRun()) {
            getViewState().showMainActivity();
        }
        //// TODO: Rest here
        ///TODO: Any logic here
    }
}
