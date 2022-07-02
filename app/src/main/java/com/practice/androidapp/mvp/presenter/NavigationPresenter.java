package com.practice.androidapp.mvp.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.beans.Navigation;
import com.practice.androidapp.mvp.model.NavigationModel;
import com.practice.androidapp.mvp.view.NavigationView;
import com.practice.androidapp.net.Callback;

import java.util.List;

public class NavigationPresenter extends BasePresenter<NavigationView, NavigationModel> {
    public NavigationPresenter(NavigationModel model) {
        super(model);
    }


    public void getNavigationList() {


        getModel().getNavigationList(new Callback<List<Navigation>>() {
            @Override
            public void onSuccess(List<Navigation> data) {
                Log.w("====","=====>>>"+new Gson().toJson(data));
                getView().showNavigationList(data);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}



