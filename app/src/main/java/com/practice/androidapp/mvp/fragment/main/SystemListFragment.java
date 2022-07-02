package com.practice.androidapp.mvp.fragment.main;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.beans.System;
import com.practice.androidapp.databinding.FragmentSystemListBinding;
import com.practice.androidapp.mvp.activity.ChapterListActivity;
import com.practice.androidapp.mvp.adapter.SystemAdapter;
import com.practice.androidapp.mvp.model.SystemModel;
import com.practice.androidapp.mvp.presenter.SystemPresenter;
import com.practice.androidapp.mvp.view.SystemView;

import java.util.List;

public class SystemListFragment extends BaseMvpFragment<FragmentSystemListBinding, SystemView, SystemPresenter> implements SystemView {
   private SystemAdapter systemAdapter;
    @Override
    protected void init() {
        systemAdapter = new SystemAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(systemAdapter);
        presenter.getSystemList();
        systemAdapter.setOnItemClickListener((adapter, view, position) -> {
            System item = systemAdapter.getItem(position);
            Intent intent = new Intent(requireContext(), ChapterListActivity.class);
            intent.putExtra("system",item);
            startActivity(intent);

        });
    }

    @Override
    protected SystemPresenter getPresenter() {
        return new SystemPresenter(new SystemModel());
    }

    @Override
    protected SystemView getV() {
        return this;
    }

    @Override
    public void showSystemList(List<System> data) {
        Log.w("======>>>","=====>>>>"+data);
        systemAdapter.setList(data);
    }


}
