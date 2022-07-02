package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.beans.Chapter;

import java.util.List;

public interface ChapterListView extends BaseView {
    void showList(List<Chapter> data);
}
