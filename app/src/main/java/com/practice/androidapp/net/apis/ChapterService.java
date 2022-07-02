package com.practice.androidapp.net.apis;


import com.practice.androidapp.base.BaseBean;
import com.practice.androidapp.base.PageBean;
import com.practice.androidapp.beans.BannerBean;
import com.practice.androidapp.beans.Chapter;
import com.practice.androidapp.beans.Navigation;
import com.practice.androidapp.beans.OfficialAccount;
import com.practice.androidapp.beans.OfficialRecord;
import com.practice.androidapp.beans.Project;
import com.practice.androidapp.beans.System;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChapterService {
///article/list/0/json?cid=60
    @GET("/article/list/{pageNumber}/json")
    Observable<BaseBean<PageBean<Chapter>>> getHomeList(@Path("pageNumber") int pageNumber,@Query("cid")String cid);

    @GET("/banner/json")
    Observable<BaseBean<List<BannerBean>>> getBannerList();


    @GET("/user_article/list/{pageNumber}/json")
    Observable<BaseBean<PageBean<Chapter>>> getSquareList(@Path("pageNumber") int pageNumber);

    @GET("/wxarticle/list/{id}/{pageNumber}/json")
    Observable<BaseBean<PageBean<OfficialRecord>>> getOfficialRecordList(@Path("id") int id, @Path("pageNumber") int pageNumber);


    @GET("/wxarticle/chapters/json")
    Observable<BaseBean<List<OfficialAccount>>> getOfficialAccountList();



    @GET("/tree/json")
    Observable<BaseBean<List<System>>> getSystemList();

    @GET("/navi/json")
    Observable<BaseBean<List<Navigation>>>getNavigationList();

    @GET("/project/list/{pageNumber}/json")
    Observable<BaseBean<PageBean<Chapter>>> getProjectChapterList(@Path("pageNumber")int pageNumber, @Query("cid") int id);
    @GET("/project/tree/json")
    Observable<BaseBean<List<Project>>> getProjectList();


}
