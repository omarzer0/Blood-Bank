package com.azapps.bloodbankipda3.helper.retrofitCalls;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.azapps.bloodbankipda3.helper.Constant.BASE_URL;

public class RetrofitClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}