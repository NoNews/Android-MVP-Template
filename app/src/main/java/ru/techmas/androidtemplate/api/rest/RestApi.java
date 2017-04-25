package ru.techmas.androidtemplate.api.rest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.Request;
import ru.techmas.androidtemplate.api.endpoints.User;
import ru.techmas.androidtemplate.Const;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.techmas.androidtemplate.utils.PreferenceHelper;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class RestApi {

    public final User user;
    private PreferenceHelper preferenceHelper;

    public RestApi(PreferenceHelper preferenceHelper) {
        this.preferenceHelper = preferenceHelper;

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        TokenAppendingHeaderInterceptor tokenInterceptor = new TokenAppendingHeaderInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(tokenInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.Url.API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        user = retrofit.create(User.class);
    }


    private class TokenAppendingHeaderInterceptor implements Interceptor {

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {

            final int NO_AUTHORIZED = 401;

            Request request = chain.request();
            String token = preferenceHelper.getToken();
            Request newRequest = request.newBuilder()
                    .addHeader(Const.Url.AUTHORIZATION, token)
                    .build();

            okhttp3.Response response = chain.proceed(newRequest);
            if (response.code() == NO_AUTHORIZED) {
                // TODO: 25.04.2017  reload Application, and clear token

            }
            return response;
        }
    }

}
