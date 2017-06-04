package ru.techmas.androidtemplate.interfaces.views;

import ru.techmas.androidtemplate.interfaces.utils_view.NavigatorActivityView;

public interface SplashView extends BaseView, NavigatorActivityView {
    void showErrorConnection(boolean show);
}
