package ru.techmas.androidtemplate.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import ru.techmas.androidtemplate.R;
import ru.techmas.androidtemplate.activities.BaseActivity;
import ru.techmas.androidtemplate.fragments.BaseFragment;

/**
 * Date: 04.06.2017
 * Time: 10:00
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public class Navigator {


    private static final int FRAGMENT_TRANSITION = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
    public static boolean isFragmentAnimationDisabled = false;


    //@formatter:off
    private Navigator(){}
    //@formatter:on

    public static void startActivity(Activity applicationContext,
                                     Class<? extends BaseActivity> activityClass) {
        Intent intent = new Intent(applicationContext, activityClass);
        applicationContext.startActivity(intent);
        applicationContext.overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }


    public static void startActivityForResult(Activity activity,
                                              Class<? extends BaseActivity> activityClass,
                                              int requestCode) {
        Intent intent = new Intent(activity, activityClass);
        activity.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }


    public static void startFragment(@NonNull BaseFragment fragment,
                                     @NonNull FragmentManager fm,
                                     @IdRes int containerId) {
        fm.beginTransaction()
                .replace(containerId, fragment)
                .setTransition(FRAGMENT_TRANSITION)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }


    public static void startFragment(@NonNull BaseFragment fragment,
                                     @NonNull FragmentManager fm,
                                     @IdRes int containerId,
                                     boolean addToBackStack) {
        if (addToBackStack) startFragment(fragment, fm, containerId);
        else startFragmentWithoutBackStack(fragment, fm, containerId);
    }

    private static void startFragmentWithoutBackStack(@NonNull BaseFragment fragment,
                                                      @NonNull FragmentManager fm,
                                                      @IdRes int containerId) {
        fm.beginTransaction()
                .setTransition(FRAGMENT_TRANSITION)
                .replace(containerId, fragment)
                .commit();
    }

    public static void startFragment(@NonNull BaseFragment fragment,
                                     @NonNull FragmentManager fm,
                                     @IdRes int containerId,
                                     boolean addToBackStack,
                                     boolean clearBackStack,
                                     boolean activityIsFinishing) {

        if (clearBackStack && activityIsFinishing) clearBackStack(fm);
        if (addToBackStack) {
            startFragment(fragment, fm, containerId);
        } else startFragmentWithoutBackStack(fragment, fm, containerId);
    }

    private static void clearBackStack(FragmentManager fm) {
        isFragmentAnimationDisabled = true;
        fm.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        isFragmentAnimationDisabled = false;
    }

}
