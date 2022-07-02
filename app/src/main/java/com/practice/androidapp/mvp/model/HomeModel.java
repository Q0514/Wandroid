package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.BannerBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.net.Callback;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class HomeModel extends BaseModel {
    public void getHomeList(int pageNumber, Callback<PageBean<Chapter>> callback) {
        Observable<BaseBean<PageBean<Chapter>>> observable = api().getChapterService().getHomeList(pageNumber,null);
        getRequest(observable,callback);
    }

    public void getBannerList(Callback<List<BannerBean>> callback) {
        Observable<BaseBean<List<BannerBean>>> observable = api().getChapterService().getBannerList();
        getRequest(observable,callback);
    }
}
