package com.practice.androidapp.mvp.log;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import androidx.fragment.app.Fragment;

import com.practice.androidapp.R;
import com.practice.androidapp.base.BaseActivity;
import com.practice.androidapp.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding> {
    @Override
    protected void init() {
        binding.tvToRegister.setOnClickListener(view -> startActivity(new Intent(this,RegisterActivity.class)));
        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.etUsername.getText().toString().trim();
            String password = binding.etPassword.getText().toString().trim();
            if (TextUtils.isEmpty(username)) {
                binding.etUsername.setError(getString(R.string.username_error_tip));
            } else if (TextUtils.isEmpty(password)) {
                binding.etPassword.setError(getString(R.string.password_error_tip));
            } else {

            }
        });
    }
}
