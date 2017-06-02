package ru.techmas.androidtemplate.dagger.modules;

import android.content.Context;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.utils.AnimationHelper;
import ru.techmas.androidtemplate.utils.PreferenceHelper;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */


@Module
public class AppModule {
    private App app;
    private PreferenceHelper preferenceHelper;
    private RestApi restApi;
    private AnimationHelper animationHelper;


    public AppModule(App app) {
        this.app = app;
        preferenceHelper = new PreferenceHelper(PreferenceManager.getDefaultSharedPreferences(app));
        restApi = new RestApi(preferenceHelper);
        animationHelper = new AnimationHelper(app);
    }


    @Provides
    @Singleton
    AnimationHelper provideAnimationHelper() {
        return animationHelper;
    }

    @Provides
    @Singleton
    RestApi provideRestApi() {
        return restApi;
    }

    @Provides
    @Singleton
    PreferenceHelper provideSharedPreference() {
        return preferenceHelper;
    }


    @Provides
    @Singleton
    Context provideApplicationContext() {
        return app;
    }

}
