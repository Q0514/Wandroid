package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.mvp.model.SystemModel;
import com.practice.androidapp.mvp.view.SystemView;
import com.practice.androidapp.net.Callback;
import com.practice.androidapp.beans.System;

import java.util.List;

public class SystemPresenter extends BasePresenter<SystemView, SystemModel> {
    public SystemPresenter(SystemModel model) {
        super(model);
    }

    public void getSystemList() {
        getModel().getSystemList(new Callback<List<System>>() {
            @Override
            public void onSuccess(List<System> data) {
                getView().showSystemList(data);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}