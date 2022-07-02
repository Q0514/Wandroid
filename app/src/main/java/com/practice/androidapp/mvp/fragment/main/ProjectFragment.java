package com.practice.androidapp.mvp.fragment.main;

import androidx.fragment.app.Fragment;

import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.beans.Project;
import com.practice.androidapp.databinding.FragmentProjectBinding;
import com.practice.androidapp.mvp.adapter.ViewPagerAdapter;
import com.practice.androidapp.mvp.model.ProjectModel;
import com.practice.androidapp.mvp.presenter.ProjectPresenter;
import com.practice.androidapp.mvp.view.ProjectView;

import java.util.ArrayList;
import java.util.List;

public class ProjectFragment extends BaseMvpFragment<FragmentProjectBinding, ProjectView, ProjectPresenter> implements ProjectView{
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void init() {


        presenter.getProjectList();
    }


    @Override
    protected ProjectPresenter getPresenter() {
        return new ProjectPresenter(new ProjectModel());
    }

    @Override
    protected ProjectView getV() {
        return this;
    }

    @Override
    public void showProjectList(List<Project> data) {
        ArrayList<Fragment> fragmentList = new ArrayList<>();
        //tabLayout上显示的标题
        String[] title = new String[data.size()];
        //根据后台返回的数据条数，循环创建对应数量的Fragment
        for (int i = 0; i < data.size(); i++) {
            //获取每个item，并赋值标题和初始化Fragment
            Project item = data.get(i);
            title[i] = item.getName();
            fragmentList.add(com.practice.androidapp.mvp.fragment.main.ProjectChapterFragment.getInstance(item.getId()));
        }
        binding.viewPager.setAdapter( new ViewPagerAdapter(getChildFragmentManager(),fragmentList,title));
        binding.tabLayout.setViewPager(binding.viewPager,title);

    }
}
