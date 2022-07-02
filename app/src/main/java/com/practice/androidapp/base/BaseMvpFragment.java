package com.practice.androidapp.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

public abstract class BaseMvpFragment<B extends ViewBinding, V extends BaseView, P extends IPresenter<V>> extends BaseFragment<B> {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = getPresenter();

        presenter.attachView(getV());
    }

    protected abstract P getPresenter();

    protected abstract V getV();
}
