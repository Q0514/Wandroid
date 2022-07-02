package com.practice.androidapp.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseFragment<B extends ViewBinding> extends Fragment {

    protected B binding;


    @Nullable
    @Override
    public  View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return initBinding();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init();
    }

    private View initBinding() {
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            try {
                Class<B> clazz = (Class<B>) ((ParameterizedType) type).getActualTypeArguments()[0];
                Method method = clazz.getMethod("inflate", LayoutInflater.class);
                binding = (B) method.invoke(null, getLayoutInflater());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return binding.getRoot();
        }

        return null;
    }

    protected abstract void init();
}
