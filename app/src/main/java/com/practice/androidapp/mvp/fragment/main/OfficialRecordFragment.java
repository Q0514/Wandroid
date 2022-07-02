package com.practice.androidapp.mvp.fragment.main;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.practice.androidapp.WebViewActivity;
import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.OfficialRecord;
import com.practice.androidapp.databinding.FragmentOfficialRecordBinding;
import com.practice.androidapp.mvp.adapter.OfficialRecordAdapter;
import com.practice.androidapp.mvp.model.OfficialRecordModel;
import com.practice.androidapp.mvp.presenter.OfficialRecordPresenter;
import com.practice.androidapp.mvp.view.OfficialRecordView;

public class OfficialRecordFragment extends BaseMvpFragment<FragmentOfficialRecordBinding, OfficialRecordView, OfficialRecordPresenter> implements OfficialRecordView {
    private OfficialRecordAdapter officialRecordAdapter;

    public static OfficialRecordFragment getInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        OfficialRecordFragment fragment = new OfficialRecordFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void init() {
        int id = getArguments().getInt("id");
        officialRecordAdapter = new OfficialRecordAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(officialRecordAdapter);
        presenter.getOfficialRecordList(id, 0);
        officialRecordAdapter.setOnItemClickListener((adapter, view, position) -> {
            OfficialRecord item = officialRecordAdapter.getItem(position);
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra("title",item.getTitle());
            intent.putExtra("url",item.getLink());
            startActivity(intent);

        });
    }

    @Override
    protected OfficialRecordPresenter getPresenter() {
        return new OfficialRecordPresenter(new OfficialRecordModel());
    }

    @Override
    protected OfficialRecordView getV() {
        return this;
    }

    @Override
    public void showOfficialRecordList(PageBean<OfficialRecord> data) {
        officialRecordAdapter.setList(data.getList());

    }
}
