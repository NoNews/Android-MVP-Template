package ru.techmas.androidtemplate.dagger.modules;

import android.content.Context;
import android.preference.PreferenceManager;

import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.utils.PreferenceHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Module
public class AppModule {
    private App app;
    private PreferenceHelper preferenceHelper;
    protected RestApi restApi;


    public AppModule(App app) {
        this.app = app;
        preferenceHelper=new PreferenceHelper(PreferenceManager.getDefaultSharedPreferences(app));
        restApi=new RestApi();
    }


    @Provides
    @Singleton
    public RestApi provideRestApi() {
        return restApi;
    }

    @Provides
    @Singleton
    public PreferenceHelper provideSharedPreference(){
        return preferenceHelper;
    }



    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }

}
