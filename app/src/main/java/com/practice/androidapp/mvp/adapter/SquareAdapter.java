package com.practice.androidapp.mvp.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.practice.androidapp.R;
import com.practice.androidapp.beans.Chapter;

public class SquareAdapter extends BaseQuickAdapter<Chapter, BaseViewHolder> {

    public SquareAdapter() {
        super(R.layout.item_square);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, Chapter square) {
        holder.setText(R.id.tv_title,square.getTitle());


    }
}
