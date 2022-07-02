package com.practice.androidapp.net.apis;




import com.practice.androidapp.base.BaseBean;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {

    // 修饰符 + 返回值 + 方法名();

    public int aaaa(String a );

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @FormUrlEncoded
    @POST("user/login")
    Observable<BaseBean<Object>> login(@Field("username") String username,
                                       @Field("password") String password);


    @FormUrlEncoded
    @POST("user/register")
    Observable<BaseBean<Object>> register(@Field("username") String username,
                                          @Field("password") String password,
                                          @Field("repassword")String rePassword);

}
