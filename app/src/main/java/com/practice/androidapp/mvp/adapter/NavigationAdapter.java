package com.practice.androidapp.mvp.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.practice.androidapp.R;
import com.practice.androidapp.beans.Navigation;

import java.util.List;

public class NavigationAdapter extends BaseQuickAdapter<Navigation, BaseViewHolder> {


    private List<Navigation> list;

    public NavigationAdapter() {
        super(R.layout.item_navigation);


    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, Navigation navigation) {
        holder.setText(R.id.item_navigation_tv, navigation.getName());

    }

}
