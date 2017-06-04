package ru.techmas.androidtemplate.interfaces.utils_view;

import ru.techmas.androidtemplate.interfaces.views.BaseView;

/**
 * Date: 04.06.2017
 * Time: 12:02
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
public interface NetworkView extends BaseView {
    void showProgress(boolean show);
    void showData(boolean show);
    void showError(boolean show, String text);
}
