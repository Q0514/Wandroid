package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.beans.Project;
import com.practice.androidapp.net.Callback;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class ProjectModel extends BaseModel {
    public void getProjectList(Callback<List<Project>> listCallback) {
        Observable<BaseBean<List<Project>>> observable = api().getChapterService().getProjectList();
        getRequest(observable, listCallback);
    }
}
