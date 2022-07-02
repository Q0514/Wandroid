package com.practice.androidapp.mvp.fragment.main;

import androidx.fragment.app.Fragment;

import com.practice.androidapp.base.BaseFragment;
import com.practice.androidapp.databinding.FragmentSystemBinding;
import com.practice.androidapp.mvp.adapter.ViewPagerAdapter;

import java.util.ArrayList;

public class SystemFragment extends BaseFragment<FragmentSystemBinding> {
    @Override
    protected void init() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new SystemListFragment());
        fragments.add(new NavigationFragment());

        String[] titles = {"体系", "导航"};
        binding.viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), fragments, titles));
        binding.tabLayout.setViewPager(binding.viewPager, titles);
    }
}
