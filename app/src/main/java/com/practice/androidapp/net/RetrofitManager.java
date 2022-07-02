package com.practice.androidapp.net;




import com.practice.androidapp.net.apis.ChapterService;
import com.practice.androidapp.net.apis.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {


    private static RetrofitManager instance;

    private static Retrofit retrofit;


    private UserService userService;

    private ChapterService chapterService;



    public static RetrofitManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitManager.class) {
                if (instance == null) {
                    instance = new RetrofitManager();
                }
            }
        }

        return instance;
    }

    public void init() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wanandroid.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }


    public UserService getUserService() {
        if (userService == null) {
            userService = retrofit.create(UserService.class);
        }
        return userService;
    }
    public ChapterService getChapterService() {
        if (chapterService == null) {
            chapterService = retrofit.create(ChapterService.class);
        }
        return chapterService;
    }
}
