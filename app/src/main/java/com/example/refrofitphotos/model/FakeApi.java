package com.example.refrofitphotos.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakeApi {

    @GET("photos")
    Call<List<Photo>> getPhotos();
}
