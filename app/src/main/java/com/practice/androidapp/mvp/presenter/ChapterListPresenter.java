package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.mvp.model.ChapterListModel;
import com.practice.androidapp.mvp.view.ChapterListView;
import com.practice.androidapp.net.Callback;

public class ChapterListPresenter extends BasePresenter<ChapterListView, ChapterListModel> {
    public ChapterListPresenter(ChapterListModel model) {
        super(model);
    }

    public void getChapterList(int pageNumber,int id) {
        getModel().getChapterList(0, id, new Callback<PageBean<Chapter>>() {
            @Override
            public void onSuccess(PageBean<Chapter> data) {
                getView().showList(data.getList());
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}