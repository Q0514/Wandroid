package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.net.Callback;

import io.reactivex.rxjava3.core.Observable;

public class ChapterListModel extends BaseModel {
    public void getChapterList(int pageNumber, int id, Callback<PageBean<Chapter>> listCallback) {
        Observable<BaseBean<PageBean<Chapter>>> observable = api().getChapterService().getHomeList(pageNumber, String.valueOf(id));
        getRequest(observable, listCallback);
    }
}
