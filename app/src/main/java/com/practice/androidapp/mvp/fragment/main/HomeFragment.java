package com.practice.androidapp.mvp.fragment.main;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.practice.androidapp.WebViewActivity;
import com.practice.androidapp.base.BaseMvpFragment;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.BannerBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.databinding.FragmentHomeBinding;
import com.practice.androidapp.mvp.adapter.BannerExampleAdapter;
import com.practice.androidapp.mvp.adapter.ChildNavigationAdapter;
import com.practice.androidapp.mvp.adapter.HomeAdapter;
import com.practice.androidapp.mvp.model.HomeModel;
import com.practice.androidapp.mvp.presenter.HomePresenter;
import com.practice.androidapp.mvp.view.HomeView;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnPageChangeListener;

import java.util.List;

public class HomeFragment extends BaseMvpFragment<FragmentHomeBinding, HomeView, HomePresenter> implements HomeView {
    private HomeAdapter adapter;
    private BannerExampleAdapter bannerExampleAdapter;
    private ChildNavigationAdapter childAdapter;
    @Override
    protected void init() {
        adapter = new HomeAdapter();
        bannerExampleAdapter = new BannerExampleAdapter();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            Chapter item = (Chapter) adapter.getItem(position);
            Intent intent = new Intent(getContext(), WebViewActivity.class);
            intent.putExtra("title",item.getTitle());
            intent.putExtra("url",item.getLink());
            startActivity(intent);

        });


        binding.banner.addBannerLifecycleObserver(this)//添加生命周期观察者
                .setAdapter(bannerExampleAdapter)
                .addOnPageChangeListener(new OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        String title = bannerExampleAdapter.getData(position).getTitle();
                        binding.tvTitle.setText(title);

                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                })
                .setIndicator(new CircleIndicator(requireContext()));

        presenter.getHomeList(0);

        presenter.getBannerList();

//        childAdapter.setTagClickListener((childPosition, item, parent) -> {
//            Intent intent = new Intent(getContext(), WebViewActivity.class);
//            intent.putExtra("title", item.getTitle());
//            intent.putExtra("url", item.getLink());
//            startActivity(intent);
//        });
//        childAdapter = new ChildNavigationAdapter();
////        binding.childRecyclerView.setAdapter(childAdapter);
////        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) binding.childRecyclerView.getLayoutManager();
//       adapter.setOnItemClickListener((adapter, view, position) -> {
//            linearLayoutManager.scrollToPosition(position);
//        });
    }
    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(new HomeModel());
    }

    @Override
    protected HomeView getV() {
        return this;
    }

    @Override
    public void showHomeList(PageBean<Chapter> data) {
        adapter.setList(data.getList());
    }

    @Override
    public void showBannerList(List<BannerBean> data) {
        bannerExampleAdapter.setDatas(data);
        binding.banner.start();
    }
}
