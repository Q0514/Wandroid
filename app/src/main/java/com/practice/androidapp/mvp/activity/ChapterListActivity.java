package com.practice.androidapp.mvp.activity;

import androidx.fragment.app.Fragment;

import com.practice.androidapp.base.BaseActivity;
import com.practice.androidapp.beans.System;
import com.practice.androidapp.databinding.ActivityChapterListBinding;
import com.practice.androidapp.mvp.adapter.ViewPagerAdapter;
import com.practice.androidapp.mvp.fragment.ChapterListFragment;

import java.util.ArrayList;
import java.util.List;

public class ChapterListActivity extends BaseActivity<ActivityChapterListBinding> {
    @Override
    protected void init() {
        System system = getIntent().getParcelableExtra("system");
        binding.toolbar.setTitle(system.getName());
        binding.toolbar.setNavigationOnClickListener(v -> finish());

        List<System.ChildrenDTO> children = (List<System.ChildrenDTO>) system.getChildren();
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        //tabLayout上显示的标题
        String[] title = new String[children.size()];

        //根据后台返回的数据条数，循环创建对应数量的Fragment
        for (int i = 0; i < children.size(); i++) {
            //获取每个item，并赋值标题和初始化Fragment
            System.ChildrenDTO childrenDTO = children.get(i);
            title[i] = childrenDTO.getName();
            fragmentList.add(ChapterListFragment.getInstance(childrenDTO.getId()));
        }

        binding.viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), fragmentList, title));
        binding.tabLayout.setViewPager(binding.viewPager, title);

    }
}
