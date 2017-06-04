package ru.techmas.androidtemplate.di.components;

import javax.inject.Singleton;

import dagger.Component;
import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.activities.BaseActivity;
import ru.techmas.androidtemplate.di.modules.ViewModule;
import ru.techmas.androidtemplate.fragments.BaseFragment;

/**
 * Date: 04.06.2017
 * Time: 10:30
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */


@Singleton
@Component(modules = {ViewModule.class})
public interface ViewComponent {
    void inject(App app);
    void inject(BaseFragment baseFragment);
    void inject(BaseActivity baseActivity);
}
