package ru.techmas.androidtemplate.fragments;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatFragment;

import ru.techmas.androidtemplate.App;
import ru.techmas.androidtemplate.activities.BaseActivity;
import ru.techmas.androidtemplate.utils.KeyboardHelper;
import ru.techmas.androidtemplate.utils.Navigator;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseFragment extends MvpAppCompatFragment {

    protected final String TAG = getClass().getSimpleName();
    protected View rootView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getViewComponent().inject(this);
    }


    protected void hideKeyboard() {
        KeyboardHelper.hide(getActivity());
    }


    public void startActivity(Class<? extends BaseActivity> activityClass) {
        Navigator.startActivity(getActivity(), activityClass);
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


    @SuppressWarnings("unchecked")
    protected final <T extends View> T bindView(@IdRes int id) {
        return (T) rootView.findViewById(id);
    }


}
