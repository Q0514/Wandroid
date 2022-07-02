package com.practice.androidapp.mvp.presenter;

import com.practice.androidapp.base.BasePresenter;
import com.practice.androidapp.beans.OfficialAccount;
import com.practice.androidapp.mvp.model.OfficialAccountModel;
import com.practice.androidapp.mvp.view.OfficialAccountView;
import com.practice.androidapp.net.Callback;

import java.util.List;

public class OfficialAccountPresenter extends BasePresenter<OfficialAccountView, OfficialAccountModel> {
    public OfficialAccountPresenter(OfficialAccountModel model) {
        super(model);
    }
    public void getOfficialAccountList() {
        getModel().getOfficialAccountList(new Callback<List<OfficialAccount>>() {

            @Override
            public void onSuccess(List<OfficialAccount> data) {
                getView().showOfficialAccountList(data);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }
}
