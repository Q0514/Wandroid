package com.practice.androidapp.base;

public interface IPresenter<V extends BaseView> {
    void attachView(V view);
}
