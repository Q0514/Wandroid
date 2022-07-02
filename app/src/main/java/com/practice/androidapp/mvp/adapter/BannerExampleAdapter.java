package com.practice.androidapp.mvp.adapter;

import com.bumptech.glide.Glide;
import com.practice.androidapp.beans.BannerBean;
import com.youth.banner.adapter.BannerImageAdapter;
import com.youth.banner.holder.BannerImageHolder;

import java.util.ArrayList;

public class BannerExampleAdapter extends BannerImageAdapter<BannerBean> {
    public BannerExampleAdapter() {
        super(new ArrayList<>());
    }

    @Override
    public void onBindView(BannerImageHolder holder, BannerBean data, int position, int size) {
        Glide.with(holder.itemView.getContext())
                .load(data.getImagePath())
                .into(holder.imageView);
    }
}
