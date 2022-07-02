package com.practice.androidapp.mvp.view;

import com.practice.androidapp.base.BaseView;
import com.practice.androidapp.beans.OfficialAccount;

import java.util.List;

public interface OfficialAccountView extends BaseView {
    void showOfficialAccountList(List<OfficialAccount> data);
}
