package com.practice.androidapp.mvp.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.practice.androidapp.R;
import com.practice.androidapp.beans.System;

import java.util.List;

public class SystemAdapter extends BaseQuickAdapter<System, BaseViewHolder> {
    public SystemAdapter() {
        super(R.layout.item_system);

    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, System system) {
        holder.setText(R.id.tv_name, system.getName());
        StringBuilder sb = new StringBuilder();
        List<System.ChildrenDTO> children = (List<System.ChildrenDTO>) system.getChildren();
        if (children != null) {
            for (int i = 0; i < children.size(); i++) {
                System.ChildrenDTO item = children.get(i);
                sb.append(item.getName());
                if (i < children.size() - 1) {
                    sb.append("\t\t");
                }
            }
        }
        holder.setText(R.id.tv_children_names, sb.toString());
    }

}

