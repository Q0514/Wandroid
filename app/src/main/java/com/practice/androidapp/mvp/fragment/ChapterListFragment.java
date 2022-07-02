package com.practice.androidapp.mvp.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.practice.androidapp.WebViewActivity;
import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.databinding.FragmentChapterListBinding;
import com.practice.androidapp.mvp.adapter.SquareAdapter;
import com.practice.androidapp.mvp.model.ChapterListModel;
import com.practice.androidapp.mvp.presenter.ChapterListPresenter;
import com.practice.androidapp.mvp.view.ChapterListView;

import java.util.List;

public class ChapterListFragment extends BaseMvpFragment<FragmentChapterListBinding, ChapterListView, ChapterListPresenter> implements ChapterListView {

    private SquareAdapter squareAdapter;

    public static ChapterListFragment getInstance(int id) {
        Bundle bundle = new Bundle();
        bundle.putInt("id", id);
        ChapterListFragment fragment = new ChapterListFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    protected void init() {
        int id = getArguments().getInt("id");
        presenter.getChapterList(0,id);

        squareAdapter = new SquareAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(squareAdapter);

        squareAdapter.setOnItemClickListener((adapter, view, position) -> {
            Chapter item = squareAdapter.getItem(position);
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra("title",item.getTitle());
            intent.putExtra("url",item.getLink());
            startActivity(intent);
        });
    }

    @Override
    protected ChapterListPresenter getPresenter() {
        return new ChapterListPresenter(new ChapterListModel());
    }

    @Override
    protected ChapterListView getV() {
        return this;
    }

    @Override
    public void showList(List<Chapter> data) {
        squareAdapter.setList(data);
    }
}
