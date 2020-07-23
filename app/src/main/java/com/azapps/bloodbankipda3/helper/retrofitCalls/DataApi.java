package com.azapps.bloodbankipda3.helper.retrofitCalls;

import com.azapps.bloodbankipda3.data.RetrofitCallStatus;
import com.azapps.bloodbankipda3.data.SignUpUser;
import com.azapps.bloodbankipda3.data.UserLoginDataBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DataApi {
    @POST("login")
    Call<RetrofitCallStatus> getLoginDataResponse(@Body UserLoginDataBody userLoginDataBody);

    @POST("signup")
    Call<RetrofitCallStatus> getSignUpDataResponse(@Body SignUpUser signUpUser);

    @POST("profile")
    Call<RetrofitCallStatus> getUserProfileData(@Body String api_token);

}
