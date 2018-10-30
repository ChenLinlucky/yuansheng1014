package com.example.dell.yuansheng1014.utils;

import android.util.Log;

import com.example.dell.yuansheng1014.api.ApiService;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtils {
    private static HttpUtils httpUtils;
    private OkHttpClient okHttpClient;

    private HttpUtils() {
      okHttpClient=   new OkHttpClient.Builder().addInterceptor(new longinterceptor())
                .build();
    }

    //拦截器
    class longinterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();//创建请求
            String method = request.method();//请求方法和地址
            HttpUrl url = request.url();
            Log.d("longinterceptor", method + "==" + url);
            //重新接收
            Response proceed = chain.proceed(request);
            return proceed;
        }
    }
    //单例
    public static HttpUtils getinstance() {
        if (httpUtils == null) {
            //同步锁
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }


    public ApiService getmsgresponse(String base){
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(base)// 根地址
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加RXjava对Retrofit的支持
                .addConverterFactory(GsonConverterFactory.create())//添加对gson的解析
                .build();
        //接收
        ApiService service = retrofit.create(ApiService.class);
        return service;
    }

}
