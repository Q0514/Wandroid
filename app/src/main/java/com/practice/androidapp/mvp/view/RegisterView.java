package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;

public interface RegisterView extends BaseView {
    void registerSuccess();

    void registerFail(String message);
}
