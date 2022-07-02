package com.practice.androidapp;

import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.just.agentweb.AgentWeb;
import com.practice.androidapp.base.BaseActivity;
import com.practice.androidapp.databinding.ActivityWebBinding;

public class WebViewActivity extends BaseActivity<ActivityWebBinding> {

    AgentWeb agentWeb;
    @Override
    protected void init() {

        String title = getIntent().getStringExtra("title");
        String url = getIntent().getStringExtra("url");
        binding.toolbar.setNavigationOnClickListener(v -> onBackPressed());
        binding.toolbar.setTitle(title);
         agentWeb = AgentWeb.with(this)
                .setAgentWebParent(binding.fragmentContainer,
                        new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
                ).useDefaultIndicator()
                .createAgentWeb()
                .go(url);
    }

    @Override
    public void onBackPressed() {
        if(!agentWeb.back()) {
            super.onBackPressed();
        }
    }
}
