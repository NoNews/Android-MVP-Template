package ru.techmas.androidtemplate.interfaces.views;

import ru.techmas.androidtemplate.interfaces.utils_view.NavigatorView;

public interface SplashView extends BaseView, NavigatorView {
    void showErrorConnection(boolean show);
}
