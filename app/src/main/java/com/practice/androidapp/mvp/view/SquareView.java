package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;

public interface SquareView extends BaseView {
    /**
     * 用来显示章节列表
     * @param data  章节列表的数据
     */
    void showSquareList(PageBean<Chapter> data);
}
