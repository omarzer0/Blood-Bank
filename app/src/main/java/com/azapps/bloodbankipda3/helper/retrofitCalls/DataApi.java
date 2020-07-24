package com.azapps.bloodbankipda3.helper.retrofitCalls;

import com.azapps.bloodbankipda3.data.RetrofitArticleDataStatus;
import com.azapps.bloodbankipda3.data.RetrofitClientDataStatus;
import com.azapps.bloodbankipda3.data.SignUpUser;
import com.azapps.bloodbankipda3.data.UserLoginDataBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface DataApi {
    @POST("login")
    Call<RetrofitClientDataStatus> getLoginDataResponse(@Body UserLoginDataBody userLoginDataBody);

    @POST("signup")
    Call<RetrofitClientDataStatus> getSignUpDataResponse(@Body SignUpUser signUpUser);

    @POST("profile")
    Call<RetrofitClientDataStatus> getUserProfileData(@Query("api_token") String api_token);

    @GET("posts")
    Call<RetrofitArticleDataStatus> getUserArticleData(@Query("api_token") String api_token, @Query("page") int page);

}
