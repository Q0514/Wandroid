package com.practice.androidapp;

import android.app.Application;

import com.practice.androidapp.net.RetrofitManager;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitManager.getInstance().init();
    }
}
