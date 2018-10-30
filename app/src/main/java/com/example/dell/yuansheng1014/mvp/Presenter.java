package com.example.dell.yuansheng1014.mvp;

import com.example.dell.yuansheng1014.bean.News;

import java.lang.ref.WeakReference;

public class Presenter implements Icontract.presenterimp<Icontract.iview>{
    private Icontract.iview iview;

    private WeakReference<Icontract.iview> iviewWeakReference;
    private Moudel moudel;
    private WeakReference<Icontract.moudelimp> moudelimpWeakReference;


    @Override
    public void attchview(Icontract.iview iview) {
        this.iview=iview;
        moudel = new Moudel();
        iviewWeakReference = new WeakReference<>(iview);
        moudelimpWeakReference = new WeakReference<Icontract.moudelimp>(moudel);
    }

    @Override
    public void datachview(Icontract.iview iview) {
        iviewWeakReference.clear();
        moudelimpWeakReference.clear();
    }

    @Override
    public void requestinfo() {
        moudel.requestdata(new Icontract.moudelimp.callisten() {
            @Override
            public void requestmsg(News news) {
                iview.data(news);
            }
        });
    }
}
