package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.beans.Navigation;
import com.practice.androidapp.net.Callback;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class NavigationModel extends BaseModel {
    public void getNavigationList(Callback<List<Navigation>> callback) {
        Observable<BaseBean<List<Navigation>>> observable = api().getChapterService().getNavigationList();
        getRequest(observable, callback);
    }

    public void getNavigationList() {

    }
}
