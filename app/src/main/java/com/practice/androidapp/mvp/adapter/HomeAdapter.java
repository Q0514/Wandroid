package com.practice.androidapp.mvp.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.practice.androidapp.R;
import com.practice.androidapp.beans.Chapter;


public class HomeAdapter extends BaseQuickAdapter<Chapter, BaseViewHolder> {
    public HomeAdapter() {
        super(R.layout.item_home);

    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, Chapter home) {
        holder.setText(R.id.tv_title, home.getTitle());

    }
}