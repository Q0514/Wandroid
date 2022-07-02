package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.OfficialRecord;
import com.practice.androidapp.net.Callback;

import io.reactivex.rxjava3.core.Observable;

public class OfficialRecordModel extends BaseModel {
    public void getOfficialRecordList(int id, int pageNumber, Callback<PageBean<OfficialRecord>> pageBeanCallback) {
        Observable<BaseBean<PageBean<OfficialRecord>>> observable = api().getChapterService().getOfficialRecordList(id, pageNumber);
        getRequest(observable, pageBeanCallback);
    }
}
