package ru.techmas.androidtemplate.di.modules;

import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.utils.presenter.TokenHelper;

/**
 * Date: 04.06.2017
 * Time: 10:46
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */

@Module
public class RestModule {

    private TokenHelper tokenHelper;
    private RestApi restApi;

    public RestModule(App app) {
        tokenHelper = new TokenHelper(PreferenceManager.getDefaultSharedPreferences(app));
        restApi = new RestApi(tokenHelper);
    }


    @Singleton
    @Provides
    RestApi provideRestApi() {
        return restApi;
    }

    @Singleton
    @Provides
    TokenHelper provideTokenHelper() {
        return tokenHelper;
    }
}

