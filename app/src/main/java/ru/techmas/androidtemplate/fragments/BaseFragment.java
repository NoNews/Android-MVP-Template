package ru.techmas.androidtemplate.fragments;

import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.animation.Animation;

import com.arellomobile.mvp.MvpAppCompatFragment;

import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.BuildConfig;
import ru.techmas.androidtemplate.activities.BaseActivity;
import ru.techmas.androidtemplate.interfaces.utils_view.BaseSetup;
import ru.techmas.androidtemplate.interfaces.utils_view.NavigatorActivityView;
import ru.techmas.androidtemplate.utils.Injector;
import ru.techmas.androidtemplate.utils.KeyboardHelper;
import ru.techmas.androidtemplate.utils.Navigator;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public abstract class BaseFragment extends MvpAppCompatFragment implements NavigatorActivityView, BaseSetup {

    protected final String TAG = getClass().getSimpleName();
    protected View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injector.getViewComponent().inject(this);
    }

    protected final void hideKeyboard() {
        KeyboardHelper.hide(getActivity());
    }

    @Override
    public final void startActivity(Class<? extends BaseActivity> activityClass) {
        Navigator.startActivity(getActivity(), activityClass, false);
    }

    @Override
    public final void startActivityForResult(Class<? extends BaseActivity> activityClass, int requestCode) {
        Navigator.startActivityForResult(getActivity(), activityClass, requestCode);
    }

    protected final void hideView(@NonNull View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.GONE);
        }
    }

    protected final void showView(@NonNull View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (Navigator.isFragmentAnimationDisabled) {
            Animation a = new Animation() {
            };
            a.setDuration(0);
            return a;
        }
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @SuppressWarnings("unchecked")
    protected final <T extends View> T bindView(@IdRes int id) {
        return (T) rootView.findViewById(id);
    }


    @SuppressWarnings("unchecked")
    protected final int bindDimen(@DimenRes int id) {
        return (int) getResources().getDimension(id);
    }

    @SuppressWarnings("unchecked")
    protected final int bindColor(@ColorRes int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    @SuppressWarnings("unchecked")
    protected final String bindString(@StringRes int id) {
        return getString(id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (BuildConfig.DEBUG) {
            App.getRefWatcher(getActivity()).watch(this);
        }
    }
}
