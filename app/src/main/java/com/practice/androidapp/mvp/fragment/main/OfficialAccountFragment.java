package com.practice.androidapp.mvp.fragment.main;

import androidx.fragment.app.Fragment;

import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.beans.OfficialAccount;
import com.practice.androidapp.databinding.FragmentOfficialAccountBinding;
import com.practice.androidapp.mvp.adapter.ViewPagerAdapter;
import com.practice.androidapp.mvp.model.OfficialAccountModel;
import com.practice.androidapp.mvp.presenter.OfficialAccountPresenter;
import com.practice.androidapp.mvp.view.OfficialAccountView;

import java.util.ArrayList;
import java.util.List;

public class OfficialAccountFragment extends BaseMvpFragment<FragmentOfficialAccountBinding, OfficialAccountView, OfficialAccountPresenter> implements OfficialAccountView {
    @Override
    protected void init() {
        presenter.getOfficialAccountList();

    }

    @Override
    protected OfficialAccountPresenter getPresenter() {
        return new OfficialAccountPresenter(new OfficialAccountModel());
    }

    @Override
    protected OfficialAccountView getV() {
        return this;
    }

    @Override
    public void showOfficialAccountList(List<OfficialAccount> data) {
        /**
         * 显示公众号     tabLayout
         * @param data  后台返回的数据
         */
        //Fragment
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        //tabLayout上显示的标题
        String[] title = new String[data.size()];

        //根据后台返回的数据条数，循环创建对应数量的Fragment
        for (int i = 0; i < data.size(); i++) {
            //获取每个item，并赋值标题和初始化Fragment
            OfficialAccount item = data.get(i);
            title[i] = item.getName();
            fragmentList.add(OfficialRecordFragment.getInstance(item.getId()));
        }
//            binding.tabLayout.setViewPager(binding.viewPager, title,getActivity(),fragmentList);

        binding.viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), fragmentList, title));
        binding.tabLayout.setViewPager(binding.viewPager, title);


    }
}
