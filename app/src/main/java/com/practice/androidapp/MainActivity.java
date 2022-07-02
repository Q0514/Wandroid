package com.practice.androidapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.fragment.app.Fragment;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.navigation.NavigationView;
import com.practice.androidapp.base.BaseActivity;
import com.practice.androidapp.databinding.ActivityMainBinding;
import com.practice.androidapp.databinding.HeaderViewBinding;
import com.practice.androidapp.mvp.fragment.main.HomeFragment;
import com.practice.androidapp.mvp.fragment.main.OfficialAccountFragment;
import com.practice.androidapp.mvp.fragment.main.ProjectFragment;
import com.practice.androidapp.mvp.fragment.main.SquareFragment;
import com.practice.androidapp.mvp.fragment.main.SystemFragment;
import com.practice.androidapp.mvp.log.LoginActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    private String[] title;

    private final int[] iconSelectId = {
            R.drawable.ic_tab_home_selected, R.drawable.ic_tab_square_selected,
            R.drawable.ic_tab_wechat_selected, R.drawable.ic_tab_system_selected, R.drawable.ic_tab_project_selected};

    private final int[] iconDeselectId = {
            R.drawable.ic_tab_home_unselect, R.drawable.ic_tab_square_unselect,
            R.drawable.ic_tab_wechat_unselect, R.drawable.ic_tab_system_unselect, R.drawable.ic_tab_project_unselect};

    @Override
    protected void init() {
        title = getResources().getStringArray(R.array.main_tab_titles);
        ArrayList<CustomTabEntity> tabData = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            int finalI = i;
            tabData.add(new CustomTabEntity() {
                @Override
                public String getTabTitle() {
                    return title[finalI];
                }

                @Override
                public int getTabSelectedIcon() {
                    return iconSelectId[finalI];
                }

                @Override
                public int getTabUnselectedIcon() {
                    return iconDeselectId[finalI];
                }
            });
        }
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new SquareFragment());
        fragments.add(new OfficialAccountFragment());
        fragments.add(new SystemFragment());
        fragments.add(new ProjectFragment());

        binding.tabLayout.setTabData(tabData, this, R.id.fl_content, fragments);

        binding.toolbar.setTitle(R.string.wan_android);
        setSupportActionBar(binding.toolbar);
        binding.tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (position == 0) {
                    binding.toolbar.setTitle(R.string.wan_android);
                } else {
                    binding.toolbar.setTitle(title[position]);
                }
            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, 0, 0);
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        //初始化菜单状态，设置这个属性后，toolbar会默认有一个点击动画效果
        View headerView = binding.navigationView.getHeaderView(0);
        HeaderViewBinding headerViewBinding = HeaderViewBinding.bind(headerView);
        headerViewBinding.ivAvatar.setImageResource(R.drawable.ic_avatar);
        headerViewBinding.tvLevel.setText(R.string.level);
        headerViewBinding.tvLogin.setText(R.string.to_login);
        headerViewBinding.tvRank.setText(R.string.rank);
        headerViewBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });


        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {


            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_score:
                        break;
                    case R.id.menu_favorite:
                        break;
                    case R.id.menu_share:
                        break;
                    case R.id.menu_todo:
                        break;
                    case R.id.menu_night:
                        break;
                    case R.id.menu_setting:
                }
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();

                if (item.getItemId() == R.id.menu_setting) {

                } else if (item.getItemId() == R.id.menu_favorite) {

                }

                return false;
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            Toast.makeText(this, "menu", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
