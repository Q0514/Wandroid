package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.OfficialRecord;

public interface OfficialRecordView extends BaseView {
    void showOfficialRecordList(PageBean<OfficialRecord> data);
}
