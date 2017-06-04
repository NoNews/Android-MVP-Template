package ru.techmas.androidtemplate.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.di.modules.RestModule;
import ru.techmas.androidtemplate.di.modules.UtilsModule;
import ru.techmas.androidtemplate.presenters.MainActivityPresenter;
import ru.techmas.androidtemplate.presenters.SplashPresenter;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Singleton
@Component(modules = {RestModule.class, UtilsModule.class})

public interface PresenterComponent {
    //@formatter:off
    void inject(App app);
    MainActivityPresenter getMainActivityPresenter();
    SplashPresenter getSplashPresenter();
}
