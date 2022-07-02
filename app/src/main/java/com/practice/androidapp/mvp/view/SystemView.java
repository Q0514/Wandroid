package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.beans.System;

import java.util.List;

public interface SystemView extends BaseView {
    void showSystemList(List<System> data);
}
