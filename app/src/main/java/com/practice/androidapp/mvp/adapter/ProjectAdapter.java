package com.practice.androidapp.mvp.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.practice.androidapp.R;
import com.practice.androidapp.beans.Chapter;

public class ProjectAdapter extends BaseQuickAdapter<Chapter, BaseViewHolder> {
    public ProjectAdapter() {
     super(R.layout.item_project);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, Chapter chapter) {
        holder.setText(R.id.item_project_list_title_tv, chapter.getTitle());

    }
}
