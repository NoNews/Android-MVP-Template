package ru.techmas.androidtemplate.activities;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import ru.techmas.androidtemplate.interfaces.utils_view.NetworkView;

/**
 * Date: 04.06.2017
 * Time: 12:17
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public abstract class BaseNetworkActivity extends BaseActivity implements NetworkView {


    private ViewGroup ltData;
    private ProgressBar progressBar;
    private Button btnRepeat;
    private ViewGroup ltError;
    private TextView tvError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showProgress(boolean show) {
        if (show) showView(progressBar);
        else hideView(progressBar);
    }

    @Override
    public void showData(boolean show) {
        if (show) showView(ltData);
        else hideView(ltData);
    }

    @Override
    public void showError(boolean show, String text) {
        if (show) {
            showView(ltError);
            tvError.setText(text);
        } else hideView(ltError);
    }
}
