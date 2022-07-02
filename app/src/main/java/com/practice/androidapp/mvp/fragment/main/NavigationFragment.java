package com.practice.androidapp.mvp.fragment.main;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.practice.androidapp.WebViewActivity;
import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.beans.Navigation;
import com.practice.androidapp.databinding.FragmentNavigationBinding;
import com.practice.androidapp.mvp.adapter.ChildNavigationAdapter;
import com.practice.androidapp.mvp.adapter.NavigationAdapter;
import com.practice.androidapp.mvp.model.NavigationModel;
import com.practice.androidapp.mvp.presenter.NavigationPresenter;
import com.practice.androidapp.mvp.view.NavigationView;

import java.util.List;

public class NavigationFragment extends BaseMvpFragment<FragmentNavigationBinding,NavigationView, NavigationPresenter> implements NavigationView {
    private NavigationAdapter navigationAdapter;
    private ChildNavigationAdapter childAdapter;

    @Override
    protected void init() {
        navigationAdapter = new NavigationAdapter();
        binding.parentRecyclerView.setAdapter(navigationAdapter);
        childAdapter = new ChildNavigationAdapter();

        //添加网页
        childAdapter.setTagClickListener((childPosition, item, parent) -> {
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra("title",item.getTitle());
            intent.putExtra("url",item.getLink());
            startActivity(intent);
        });

        binding.childRecyclerView.setAdapter(childAdapter);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) binding.childRecyclerView.getLayoutManager();
        navigationAdapter.setOnItemClickListener((adapter, view, position) -> {
            linearLayoutManager.scrollToPosition(position);
        });
//
      presenter.getNavigationList();
    }


    @Override
    protected NavigationPresenter getPresenter() {
        return new NavigationPresenter(new NavigationModel());
    }

    @Override
    protected NavigationView getV() {
        return this;
    }


    @Override
    public void showNavigationList(List<Navigation> data) {
        navigationAdapter.setList(data);
        childAdapter.setList(data);
    }
}
