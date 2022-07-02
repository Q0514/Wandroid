package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.net.Callback;
import com.practice.androidapp.beans.System;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class SystemModel extends BaseModel {
    public void getSystemList(Callback<List<System>> listCallback) {
        Observable<BaseBean<List<System>>> systemList = api().getChapterService().getSystemList();
        getRequest(systemList,listCallback);
    }
}
