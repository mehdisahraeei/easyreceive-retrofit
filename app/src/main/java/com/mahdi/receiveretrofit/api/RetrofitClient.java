package com.mahdi.receiveretrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    private static Retrofit retrofit = null;
    private final static String url = "http://10.0.3.2/my/uploadimage/";


    private static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }


    public static Api getApiServices() {
        return getRetrofit().create(Api.class);
    }


}
