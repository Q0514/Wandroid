package com.practice.androidapp.mvp.log;

import android.text.TextUtils;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.practice.androidapp.R;
import com.practice.androidapp.base.BaseMvpActivity;
import com.practice.androidapp.databinding.ActivityRegisterBinding;
import com.practice.androidapp.mvp.presenter.RegisterPresenter;
import com.practice.androidapp.mvp.view.RegisterView;

public class RegisterActivity extends BaseMvpActivity<ActivityRegisterBinding, RegisterView, RegisterPresenter> implements RegisterView {
    @Override
    protected void init() {
        binding.btnLogin.setOnClickListener(v -> {
            String username = binding.etUsername.getText().toString().trim();
            String password =binding.etPassword.getText().toString().trim();
            String confirmPassword = binding.etConfirmPassword.getText().toString().trim();
            if (TextUtils.isEmpty(username)) {
                binding.etUsername.setError(getString(R.string.username_error_tip));
            } else if (TextUtils.isEmpty(password)) {
                binding.etPassword.setError(getString(R.string.password_error_tip));
            } else if (password.length() < 6 || password.length() > 20) {
                binding.etPassword.setError(getString(R.string.password_length_error_tip));
            } else if (TextUtils.isEmpty(confirmPassword)) {
                binding.etConfirmPassword.setError(getString(R.string.confirm_password_error_tip));
            } else if (!password.equals(confirmPassword)) {
                binding.etConfirmPassword.setError(getString(R.string.password_not_equals));
            }else {
                presenter.register(username,password,confirmPassword);
            }


        });
        binding.tvToLogin.setOnClickListener(view -> finish());
        binding.toolbar.setNavigationOnClickListener(view -> finish());

    }


    @Override
    protected RegisterPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected RegisterView getView() {
        return this;
    }

    @Override
    public void registerSuccess() {
        finish();

    }

    @Override
    public void registerFail(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
