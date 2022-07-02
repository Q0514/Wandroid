package com.practice.androidapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;


public abstract class BaseMvpActivity<B extends ViewBinding, V extends BaseView, P extends IPresenter<V>> extends BaseActivity<B> {
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = getPresenter();

        presenter.attachView(getView());

        super.onCreate(savedInstanceState);

    }


    protected abstract P getPresenter();

    protected abstract V getView();
}
