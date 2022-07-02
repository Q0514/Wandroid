package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.mvp.model.RegisterModel;
import com.practice.androidapp.mvp.view.RegisterView;
import com.practice.androidapp.net.Callback;

public class RegisterPresenter extends BasePresenter<RegisterView, RegisterModel> {
    public RegisterPresenter(RegisterModel model) {
        super(model);
    }

    public void register(String username, String password, String rePassword) {
        getModel().register(username, password, rePassword, new Callback<Object>() {
            @Override
            public void onSuccess(Object data) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}