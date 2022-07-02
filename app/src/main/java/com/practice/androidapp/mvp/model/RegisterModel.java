package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.net.Callback;

import io.reactivex.rxjava3.core.Observable;

public class RegisterModel extends BaseModel {

    public void register(String username, String password, String rePassword, Callback<Object> callback) {
        Observable<BaseBean<Object>> observable = api().getUserService().register(username, password, rePassword);
        getRequest(observable, callback);
    }
}