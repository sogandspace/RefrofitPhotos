package com.example.refrofitphotos.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitInstance {

    private static Retrofit sInstance;
    private static String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static Retrofit getInstance() {
        if (sInstance == null) {
            sInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sInstance;
    }
}
