package com.example.refrofitphotos.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repo {

    private static Repo sInstace;
    private FakeApi mFakeApi;

    public static Repo getInstance() {
        if (sInstace == null)
            sInstace = new Repo();

        return sInstace;
    }

    private Repo()  {
        mFakeApi = RetrofitInstance.getInstance().create(FakeApi.class);
    }


    public void getPhotos(final MyCallback<List<Photo>> callback) {
        Call<List<Photo>> call = mFakeApi.getPhotos();
        call.enqueue(new Callback<List<Photo>>() {
            @Override
            public void onFailure(Call<List<Photo>> call, Throwable t) {
                callback.onError("it is in onFailure: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                if (response.body() == null) {
                    callback.onError("null");
                } else {
                    callback.onSuccessful(response.body());
                }
            }
        });
    }
}
