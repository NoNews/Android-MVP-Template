package ru.techmas.androidtemplate.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.interfaces.views.SplashView;
import ru.techmas.androidtemplate.utils.presenter.TokenHelper;

@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {


    @Inject
    SplashPresenter(RestApi restApi, TokenHelper preferenceHelper) {
        this.restApi=restApi;
        this.preferenceHelper=preferenceHelper;
    }

    public void startNext() {

        if (preferenceHelper.isFirstRun()) {
            getViewState().showMainActivity();
        }
        //// TODO: Rest here
        ///TODO: Any logic here
    }
}
