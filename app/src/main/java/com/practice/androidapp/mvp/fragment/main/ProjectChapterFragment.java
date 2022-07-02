package com.practice.androidapp.mvp.fragment.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.practice.androidapp.WebViewActivity;
import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.databinding.FragmentProjectChapterBinding;
import com.practice.androidapp.mvp.adapter.ProjectAdapter;
import com.practice.androidapp.mvp.model.ProjectChapterModel;
import com.practice.androidapp.mvp.presenter.ProjectChapterPresenter;
import com.practice.androidapp.mvp.view.ProjectChapterView;

public class ProjectChapterFragment extends BaseMvpFragment<FragmentProjectChapterBinding, ProjectChapterView, ProjectChapterPresenter> implements ProjectChapterView {
    private ProjectAdapter projectAdapter;

    public static ProjectChapterFragment getInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        ProjectChapterFragment fragment = new ProjectChapterFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void init() {
        int id = getArguments().getInt("id");
        Log.w("====>>","=====>>>id:"+id);
        projectAdapter = new ProjectAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(projectAdapter);
        presenter.getProjectChapterList(id, 0);
        projectAdapter.setOnItemClickListener((adapter, view, position) -> {
            Chapter item = projectAdapter.getItem(position);
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra("title",item.getTitle());
            intent.putExtra("url",item.getLink());
            startActivity(intent);
        });
    }

    @Override
    protected ProjectChapterPresenter getPresenter() {
        return new ProjectChapterPresenter(new ProjectChapterModel());
    }

    @Override
    protected ProjectChapterView getV() {
        return this;
    }

    @Override
    public void showProjectChapterList(PageBean<Chapter> data) {
//        Log.w("====>>","=====>>>dataSize:"+data.getList().size());
        projectAdapter.setList(data.getList());
    }
}
