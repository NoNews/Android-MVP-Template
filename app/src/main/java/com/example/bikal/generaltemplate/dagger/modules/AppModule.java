package com.example.bikal.generaltemplate.dagger.modules;

import com.example.bikal.generaltemplate.App;

import dagger.Module;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Module
public class AppModule {
    private App app;


    public AppModule(App app) {
        this.app = app;
    }

//
//    @Provides
//    @Singleton
//    public Context provideApplicationContext() {
//        return app;
//    }

}
