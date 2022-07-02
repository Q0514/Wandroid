package com.practice.androidapp.base;

import com.practice.androidapp.net.ApiObserver;
import com.practice.androidapp.net.Callback;
import com.practice.androidapp.net.RetrofitManager;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class BaseModel {

    protected RetrofitManager api() {
        return RetrofitManager.getInstance();
    }

    protected <T> void getRequest(Observable<BaseBean<T>> observable, Callback<T> callback) {
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ApiObserver<T>(callback));
    }
}
