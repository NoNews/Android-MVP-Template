package ru.techmas.androidteamplate.dagger.components;

import ru.techmas.androidteamplate.App;
import ru.techmas.androidteamplate.dagger.modules.AppModule;
import ru.techmas.androidteamplate.activities.BaseActivity;
import ru.techmas.androidteamplate.fragments.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;
import ru.techmas.androidteamplate.presenters.SplashPresenter;

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
    void inject(SplashPresenter splashPresenter);
}
