package com.azapps.bloodbankipda3.helper.retrofitCalls;

import com.azapps.bloodbankipda3.data.SuccessfullyLoggedInDataHolder;
import com.azapps.bloodbankipda3.data.UserLoginDataBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DataApi {
    @POST("login")
    Call<SuccessfullyLoggedInDataHolder> getDataHolder(@Body UserLoginDataBody userLoginDataBody);

}
