package com.example.shopapp.utils;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String BASE_URL = "http://192.168.1.85/miniproject/";
    private static Retrofit instance = null;

    public static final synchronized Api getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance.create(Api.class);
    }

}
