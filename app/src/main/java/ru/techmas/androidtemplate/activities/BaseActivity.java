package ru.techmas.androidtemplate.activities;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;

import ru.techmas.androidtemplate.R;
import ru.techmas.androidtemplate.utils.KeyboardHelper;
import ru.techmas.androidtemplate.utils.Navigator;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class BaseActivity extends MvpAppCompatActivity {

    protected final String TAG = getClass().getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    protected final void hideKeyboard() {
        KeyboardHelper.hide(this);
    }

    @SuppressWarnings("unchecked")
    protected final <T extends View> T bindView(@IdRes int id) {
        return (T) findViewById(id);
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

    public void startActivity(Class<? extends BaseActivity> activityClass) {
        Navigator.startActivity(this, activityClass);
    }

    public void startActivityForResult(Class<? extends BaseActivity> activityClass, int requestCode) {
        Navigator.startActivityForResult(this, activityClass, requestCode);
    }


    @Override
    public final void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation);
    }

}
