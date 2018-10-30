package com.example.dell.yuansheng1014.mvp;

import com.example.dell.yuansheng1014.api.ApiService;
import com.example.dell.yuansheng1014.bean.News;
import com.example.dell.yuansheng1014.constant.Constant;
import com.example.dell.yuansheng1014.utils.HttpUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Moudel implements Icontract.moudelimp{


    @Override
    public void requestdata(final callisten callisten) {
        HttpUtils httpUtils = HttpUtils.getinstance();
        ApiService getmsgresponse = httpUtils.getmsgresponse(Constant.path);
        Observable<News> observable = getmsgresponse.getjiudata();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<News>() {
                    @Override
                    public void accept(News news) throws Exception {
                        callisten.requestmsg(news);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callisten.requestmsg(null);
                    }
                });
    }
}
