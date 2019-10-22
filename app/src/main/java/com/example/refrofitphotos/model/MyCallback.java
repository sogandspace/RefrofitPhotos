package com.example.refrofitphotos.model;

public interface MyCallback<T> {
    void onSuccessful(T data);

    void onError(String message);
}
