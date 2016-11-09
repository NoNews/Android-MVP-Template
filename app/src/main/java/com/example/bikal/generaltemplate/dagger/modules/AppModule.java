package com.example.bikal.generaltemplate.dagger.modules;

import android.content.Context;

import com.example.bikal.generaltemplate.App;
import com.example.bikal.generaltemplate.api.RestApi;

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
    protected RestApi restApi;


    public AppModule(App app) {
        this.app = app;
        restApi=new RestApi();
    }



    @Provides
    @Singleton
    public RestApi provideRestApi() {
        return restApi;
    }



    @Provides
    @Singleton
    public Context provideApplicationContext() {
        return app;
    }

}
