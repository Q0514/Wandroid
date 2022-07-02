package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.mvp.model.SquareModel;
import com.practice.androidapp.mvp.view.SquareView;
import com.practice.androidapp.net.Callback;

public class SquarePresenter extends BasePresenter<SquareView, SquareModel> {
    public SquarePresenter(SquareModel model) {
        super(model);
    }
    public void getSquareList(int pageNumber){
        getModel().getSquareList(pageNumber, new Callback<PageBean<Chapter>>() {
            @Override
            public void onSuccess(PageBean<Chapter> data) {
                getView().showSquareList(data);

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
