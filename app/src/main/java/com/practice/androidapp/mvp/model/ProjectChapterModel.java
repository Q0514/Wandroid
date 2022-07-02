package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.net.Callback;

import io.reactivex.rxjava3.core.Observable;

public class ProjectChapterModel extends BaseModel {
    public void getProjectChapterList(int id, int pageNumber, Callback<PageBean<Chapter>> pageBeanCallback) {
        Observable<BaseBean<PageBean<Chapter>>> observable = api().getChapterService().getProjectChapterList(pageNumber,id);
        getRequest(observable,pageBeanCallback);
    }
}
