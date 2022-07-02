package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.beans.Project;
import com.practice.androidapp.mvp.model.ProjectModel;
import com.practice.androidapp.mvp.view.ProjectView;
import com.practice.androidapp.net.Callback;

import java.util.List;

public class ProjectPresenter extends BasePresenter<ProjectView, ProjectModel> {
    public ProjectPresenter(ProjectModel model) {
        super(model);
    }

    public void getProjectList() {
        getModel().getProjectList(new Callback<List<Project>>() {

            @Override
            public void onSuccess(List<Project> data) {
                getView().showProjectList(data);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
