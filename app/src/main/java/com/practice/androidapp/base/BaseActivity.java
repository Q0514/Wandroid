package com.practice.androidapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<B extends ViewBinding> extends AppCompatActivity {

    protected B binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBinding();
        init();
    }

    private void initBinding() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            try {
                Class<B> clazz = (Class<B>) ((ParameterizedType) type).getActualTypeArguments()[0];
                Method method = clazz.getMethod("inflate", LayoutInflater.class);
                binding = (B) method.invoke(null, getLayoutInflater());
            } catch (Exception e) {
                e.printStackTrace();
            }

            setContentView(binding.getRoot());
        }
    }


    protected abstract void init();

}

