package com.practice.androidapp.mvp.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.practice.androidapp.R;
import com.practice.androidapp.beans.OfficialRecord;

public class OfficialRecordAdapter extends BaseQuickAdapter<OfficialRecord, BaseViewHolder> {
    public OfficialRecordAdapter() {
        super(R.layout.item_official_record);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder holder, OfficialRecord officialRecord) {
        holder.setText(R.id.tv_title,officialRecord.getTitle());

    }
}
