package com.digio.testdigio.api;

import com.digio.testdigio.model.ResponseBody;
import com.digio.testdigio.model.request.DocumentRequest;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers({"content-type: application/json"})
    @POST("/v2/client/document/uploadpdf")
    Observable<Response<ResponseBody>> uploadDocument(@Header("authorization") String authToken, @Body DocumentRequest requestBody);

}
