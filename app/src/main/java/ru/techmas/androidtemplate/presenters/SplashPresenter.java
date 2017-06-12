package ru.techmas.androidtemplate.presenters;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import ru.techmas.androidtemplate.activities.MainActivity;
import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.interfaces.views.SplashView;
import ru.techmas.androidtemplate.utils.presenter.TokenHelper;


@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    SplashPresenter(RestApi restApi, TokenHelper preferenceHelper) {
        this.restApi = restApi;
        this.tokenHelper = preferenceHelper;
        startNext();
    }


    public final void startNext() {
        getViewState().showErrorConnection(false);
        if (tokenHelper.isFirstRun()) {
            getViewState().startActivity(MainActivity.class);
        }
    }

}
