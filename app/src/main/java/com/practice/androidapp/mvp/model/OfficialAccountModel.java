package com.practice.androidapp.mvp.model;

import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.BaseModel;
import com.practice.androidapp.beans.OfficialAccount;
import com.practice.androidapp.net.Callback;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public class OfficialAccountModel extends BaseModel {
    public void getOfficialAccountList(Callback<List<OfficialAccount>> listCallback) {
        Observable<BaseBean<List<OfficialAccount>>> observable = api().getChapterService().getOfficialAccountList();
        getRequest(observable, listCallback);
    }
}
