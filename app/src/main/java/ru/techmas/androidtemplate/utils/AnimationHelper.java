package ru.techmas.androidtemplate.utils;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import ru.techmas.androidtemplate.R;
import ru.techmas.androidtemplate.custom.elements.SimpleAnimationListener;


/**
 * Created by reg on 03.02.2017.
 */
public class AnimationHelper {

    private Context context;
    private TranslateAnimation moveUp;
    private AlphaAnimation fadeIn;
    private AlphaAnimation fadeOut;
    private Animation scaleIn;
    private Animation scaleOut;


    public AnimationHelper(Context context) {
        this.context = context;
    }


    public final void fadeIn(View view) {

        if (fadeIn == null) {
            fadeIn = new AlphaAnimation(0.1f, 1f);
            fadeIn.setDuration(1000);
            fadeIn.setInterpolator(new DecelerateInterpolator());
        }
        fadeIn.setAnimationListener(new SimpleAnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
            }
        });
        view.startAnimation(fadeIn);
    }

    public final void fadeOut(View view) {
        view.startAnimation(AnimationUtils.loadAnimation(context, R.anim.tabs_fade_out));
        if (fadeOut == null) {
            fadeOut = new AlphaAnimation(1f, 0f);
            fadeOut.setDuration(1000);
            fadeOut.setInterpolator(new AccelerateInterpolator());
        }
        fadeOut.setAnimationListener(new SimpleAnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                view.clearAnimation();
            }
        });
        view.startAnimation(fadeOut);
    }


    public final void scaleIn(View view) {
        if (scaleIn == null) {
            scaleIn = AnimationUtils.loadAnimation(context, R.anim.scale_in);
        }
        view.startAnimation(scaleIn);
    }


    public final void scaleOut(View view) {
        if (scaleOut == null) {
            scaleOut = AnimationUtils.loadAnimation(context, R.anim.scale_out);
        }
        view.startAnimation(scaleOut);
    }


    public void moveUp(View view) {
        if (moveUp == null) {
            moveUp = new TranslateAnimation(0, 0, 0, -35);
            moveUp.setDuration(400);
            moveUp.setInterpolator(new DecelerateInterpolator());
            moveUp.setFillAfter(true);
        }
        view.startAnimation(moveUp);
    }
}
