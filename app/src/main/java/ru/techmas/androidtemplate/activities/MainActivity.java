package ru.techmas.androidtemplate.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;



import butterknife.BindView;
import butterknife.ButterKnife;
import ru.techmas.androidtemplate.interfaces.views.MainView;
import ru.techmas.androidtemplate.presenters.MainPresenter;
import ru.techmas.androidtemplate.R;

public class MainActivity extends BaseActivity implements MainView {

    private static final int LAYOUT = R.layout.activity_main;

    //@formatter:off
    @InjectPresenter MainPresenter mainPresenter;
    @BindView(R.id.tvHello) TextView tvHello;
    //@formatter:on


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        ButterKnife.bind(this);
    }



    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }
}