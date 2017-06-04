package ru.techmas.androidtemplate.api.endpoints;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import ru.techmas.androidtemplate.api.ApiResponse;

/**
 * Created by Alex Bykov on 09.11.2016.
 * You can contact me at: me@alexbykov.ru.
 */

public interface User {


    //    // TODO: 09.11.2016 init here!
    @GET("album/list")
    Observable<Response<ApiResponse<String>>> getTest();
}
