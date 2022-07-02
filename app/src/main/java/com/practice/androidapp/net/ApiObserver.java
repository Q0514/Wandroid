package com.practice.androidapp.net;

import com.practice.androidapp.base.BaseBean;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class ApiObserver<T> implements Observer<BaseBean<T>> {
    private Callback<T> callback;

    public ApiObserver(Callback<T> callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }


    public void onNext(@NonNull BaseBean<T> t) {
        if (t.getErrorCode() == 0) {
            callback.onSuccess(t.getData());
        } else {
            callback.onError(new Exception(t.getErrorMsg()));
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {

        callback.onError(e);
    }

    @Override
    public void onComplete() {

    }

}
