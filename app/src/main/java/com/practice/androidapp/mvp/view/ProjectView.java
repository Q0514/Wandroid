package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.beans.Project;

import java.util.List;

public interface ProjectView extends BaseView {
    void showProjectList(List<Project> data);
}
