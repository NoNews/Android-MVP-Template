package com.example.bikal.generaltemplate.dagger.components;

import com.example.bikal.generaltemplate.App;
import com.example.bikal.generaltemplate.api.RestApi;
import com.example.bikal.generaltemplate.dagger.modules.AppModule;
import com.example.bikal.generaltemplate.ui.activity.BaseActivity;
import com.example.bikal.generaltemplate.ui.fragments.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */



@Singleton
@Component(modules = {AppModule.class})

public interface AppComponent {
    void inject(App app);
    void inject(BaseActivity baseActivity);
    void inject(BaseFragment baseFragment);
}
