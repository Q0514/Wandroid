package com.practice.androidapp.mvp.presenter;

import android.util.Log;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.mvp.model.ProjectChapterModel;
import com.practice.androidapp.mvp.view.ProjectChapterView;
import com.practice.androidapp.net.Callback;

public class ProjectChapterPresenter extends BasePresenter<ProjectChapterView, ProjectChapterModel> {
    public ProjectChapterPresenter(ProjectChapterModel model) {
        super(model);
    }
    public void getProjectChapterList(int id, int pageNumber) {
        getModel().getProjectChapterList(id,pageNumber, new Callback<PageBean<Chapter>>() {
            @Override
            public void onSuccess(PageBean<Chapter> data) {
                Log.w("====>>","=====>>>dataSize"+data.getList().size());

                getView().showProjectChapterList(data);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
