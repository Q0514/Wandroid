package com.practice.androidapp.mvp.fragment.main;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.practice.androidapp.WebViewActivity;
import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.databinding.FragmentSquareBinding;
import com.practice.androidapp.mvp.adapter.SquareAdapter;
import com.practice.androidapp.mvp.model.SquareModel;
import com.practice.androidapp.mvp.presenter.SquarePresenter;
import com.practice.androidapp.mvp.view.SquareView;

public class SquareFragment extends BaseMvpFragment<FragmentSquareBinding, SquareView, SquarePresenter>implements SquareView {
private SquareAdapter squareAdapter;
    @Override
    protected void init() {
        squareAdapter = new SquareAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(squareAdapter);
        presenter.getSquareList(1);
        squareAdapter.setOnItemClickListener((adapter, view, position) -> {
            Chapter item = squareAdapter.getItem(position);
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra("title",item.getTitle());
            intent.putExtra("url",item.getLink());
            startActivity(intent);
        });
    }

    @Override
    protected SquarePresenter getPresenter() {
        return new SquarePresenter(new SquareModel());
    }

    @Override
    protected SquareView getV() {
        return this;
    }

    @Override
    public void showSquareList(PageBean<Chapter> data) {
        squareAdapter.setList(data.getList());
    }
}
