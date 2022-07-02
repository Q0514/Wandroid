package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.beans.Navigation;

import java.util.List;

public interface NavigationView extends BaseView {
    void showNavigationList(List<Navigation> data);
}
