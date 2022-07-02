package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.BannerBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.mvp.model.HomeModel;
import com.practice.androidapp.mvp.view.HomeView;
import com.practice.androidapp.net.Callback;

import java.util.List;

public class HomePresenter extends BasePresenter<HomeView, HomeModel> {
    public HomePresenter(HomeModel model) {
        super(model);
    }

    public void getHomeList(int pageNumber) {
        getModel().getHomeList(pageNumber, new Callback<PageBean<Chapter>>() {

            @Override
            public void onSuccess(PageBean<Chapter> data) {
                getView().showHomeList(data);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    public void getBannerList() {
        getModel().getBannerList(new Callback<List<BannerBean>>() {
            @Override
            public void onSuccess(List<BannerBean> data) {
                getView().showBannerList(data);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
