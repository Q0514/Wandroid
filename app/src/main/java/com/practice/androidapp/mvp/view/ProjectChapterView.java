package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;

public interface ProjectChapterView extends BaseView {
    void showProjectChapterList(PageBean<Chapter> data);
}
