package com.example.dell.yuansheng1014.mvp;

import com.example.dell.yuansheng1014.bean.News;

public interface Icontract {
     interface iview{
        void data(News news);
    }
     interface presenterimp<iview>{
        void attchview(iview iview);
        void requestinfo(iview iview);
        void datachview();
    }
     interface moudelimp{
        interface callisten{
            void requestmsg(News news);
        }
        void requestdata(callisten callisten);
    }
}
