package com.practice.androidapp.net;


public interface Callback<T> {
    void onSuccess(T data);

    void onError(Throwable throwable);
}
