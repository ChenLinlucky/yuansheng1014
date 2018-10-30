package com.example.dell.yuansheng1014;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dell.yuansheng1014.bean.News;
import com.example.dell.yuansheng1014.mvp.Icontract;
import com.example.dell.yuansheng1014.mvp.Presenter;

public class MainActivity extends AppCompatActivity implements Icontract.iview {

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new Presenter();
        presenter.attchview(this);
        presenter.requestinfo();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.datachview(this);
    }

    @Override
    public void data(News news) {
        Toast.makeText(this, "news:" + news, Toast.LENGTH_SHORT).show();
    }
}
