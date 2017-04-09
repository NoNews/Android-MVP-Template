package ru.techmas.androidtemplate.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.activities.BaseActivity;
import ru.techmas.androidtemplate.dagger.modules.AppModule;
import ru.techmas.androidtemplate.fragments.BaseFragment;
import ru.techmas.androidtemplate.presenters.MainActivityPresenter;
import ru.techmas.androidtemplate.presenters.SplashPresenter;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Singleton
@Component(modules = {AppModule.class})

public interface AppComponent {
    //@formatter:off
    void inject(App app);
    void inject(BaseActivity baseActivity);
    void inject(BaseFragment baseFragment);
    void inject(SplashPresenter splashPresenter);
    MainActivityPresenter getMainActivityPresenter();
    SplashPresenter getSplashPresenter();
}
