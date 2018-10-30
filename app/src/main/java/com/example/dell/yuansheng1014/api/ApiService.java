package com.example.dell.yuansheng1014.api;

import com.example.dell.yuansheng1014.bean.News;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("product/getCatagory")
    Observable<News> getjiudata();
}
