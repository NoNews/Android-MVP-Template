package ru.techmas.androidtemplate.api;

import ru.techmas.androidtemplate.api.endpoints.TestEndpoint;
import ru.techmas.androidtemplate.Const;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public class RestApi {

    public final TestEndpoint testEndpoint;

    public RestApi(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
//                .authenticator(authenticator)
                .build();


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Const.Url.API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        testEndpoint = retrofit.create(TestEndpoint.class);
    }
}
