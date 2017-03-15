package ru.techmas.burgerking;



import android.app.Application;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import ru.techmas.burgerking.dagger.components.AppComponent;
import ru.techmas.burgerking.dagger.components.DaggerAppComponent;
import ru.techmas.burgerking.dagger.modules.AppModule;



/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        setupDagger2();
    }

    private void setupDagger2() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public static AppComponent getAppComponent(){
        return appComponent;
    }

}
