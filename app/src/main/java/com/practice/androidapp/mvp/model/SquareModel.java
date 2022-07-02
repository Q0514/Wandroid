package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.net.Callback;

import io.reactivex.rxjava3.core.Observable;

public class SquareModel extends BaseModel {
    public void getSquareList(int pageNumber, Callback<PageBean<Chapter>> callback) {
        Observable<BaseBean<PageBean<Chapter>>> observable = api().getChapterService().getSquareList(pageNumber);
        getRequest(observable,callback);
    }
}
