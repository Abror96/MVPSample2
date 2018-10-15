package com.example.kringle.mvpsample2.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit ourInstance;
    private static final String BASE_URL = "https://api.myjson.com/";

    public static Retrofit getInstance() {
        if (ourInstance == null) {

            ourInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return ourInstance;

    }

}
