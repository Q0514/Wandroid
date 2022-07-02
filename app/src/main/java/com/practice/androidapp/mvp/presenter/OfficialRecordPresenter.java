package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.OfficialRecord;
import com.practice.androidapp.mvp.model.OfficialRecordModel;
import com.practice.androidapp.mvp.view.OfficialRecordView;
import com.practice.androidapp.net.Callback;

public class OfficialRecordPresenter extends BasePresenter<OfficialRecordView, OfficialRecordModel> {
    public OfficialRecordPresenter(OfficialRecordModel model) {
        super(model);
    }

    public void getOfficialRecordList(int id, int pageNumber) {
        getModel().getOfficialRecordList(id, pageNumber, new Callback<PageBean<OfficialRecord>>() {
            @Override
            public void onSuccess(PageBean<OfficialRecord> data) {
                getView().showOfficialRecordList(data);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
