package ru.techmas.burgerking.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.techmas.burgerking.App;
import ru.techmas.burgerking.activities.BaseActivity;
import ru.techmas.burgerking.dagger.modules.AppModule;
import ru.techmas.burgerking.fragments.BaseFragment;
import ru.techmas.burgerking.presenters.MainActivityPresenter;
import ru.techmas.burgerking.presenters.SplashPresenter;

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
