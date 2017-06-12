package ru.techmas.androidtemplate.presenters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import ru.techmas.androidtemplate.activities.MainActivity;
import ru.techmas.androidtemplate.api.RestApi;
import ru.techmas.androidtemplate.interfaces.views.SplashView;
import ru.techmas.androidtemplate.interfaces.views.SplashView$$State;
import ru.techmas.androidtemplate.utils.presenter.TokenHelper;

import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Date: 04.06.2017
 * Time: 15:00
 * Project: Android Template
 *
 * @author Alex Bykov
 *         You can contact me at me@alexbykov.ru
 */
@RunWith(RobolectricTestRunner.class)
public class SplashPresenterTest {
    @Mock
    SplashView splashView;
    @Mock
    SplashView$$State splashViewState;
    @Mock
    RestApi restApi;
    @Mock
    TokenHelper tokenHelper;

    private SplashPresenter splashPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        splashPresenter = new SplashPresenter(restApi, tokenHelper);
        splashPresenter.attachView(splashView);
        splashPresenter.setViewState(splashViewState);
    }

    @Test
    public void startNextTest() {
        when(tokenHelper.isFirstRun()).thenReturn(true);
        splashPresenter.startNext();
        verify(splashViewState).showErrorConnection(false);
        verify(splashViewState).startActivity(MainActivity.class);
        // TODO: 12.06.2017  
    }

}
