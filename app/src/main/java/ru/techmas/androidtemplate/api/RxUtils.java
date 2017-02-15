package ru.techmas.androidtemplate.api;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alex Bykov on 15.02.2017.
 * You can contact me at: me@alexbykov.ru.
 */

public class RxUtils {



    public static <T> Observable.Transformer<T, T> applySchedulers() {
        return observable ->
                observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
    }
}
