package ru.techmas.androidtemplate.presenters;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

import org.greenrobot.eventbus.EventBus;

import ru.techmas.androidtemplate.api.rest.RestApi;
import ru.techmas.androidtemplate.utils.PreferenceHelper;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


/**
 * Created by Alex Bykov on 15.02.2017.
 * You can contact me at: me@alexbykov.ru.
 */

public class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    protected RestApi restApi;
    protected PreferenceHelper preferenceHelper;
    //
    protected String TAG = getClass().getSimpleName();


    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    protected final void startBus() {
        if (!EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().register(this);
    }

    protected final void stopBus() {
        if (EventBus.getDefault().isRegistered(this))
            EventBus.getDefault().unregister(this);
    }

    protected final void unSubscribeOnDestroy(@NonNull Subscription subscription) {
        compositeSubscription.add(subscription);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeSubscription.clear();
    }
}
