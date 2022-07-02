package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.BannerBean;
import com.practice.androidapp.beans.Chapter;

import java.util.List;

public interface HomeView extends BaseView {
    void showHomeList(PageBean<Chapter> data);

    void showBannerList(List<BannerBean> data);

}
