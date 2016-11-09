package com.example.bikal.generaltemplate;



import android.app.Application;

import com.example.bikal.generaltemplate.dagger.components.AppComponent;
import com.example.bikal.generaltemplate.dagger.components.DaggerAppComponent;
import com.example.bikal.generaltemplate.dagger.modules.AppModule;


/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class App extends Application {

    private AppComponent appComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger2();
    }

    private void setupDagger2() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

}
