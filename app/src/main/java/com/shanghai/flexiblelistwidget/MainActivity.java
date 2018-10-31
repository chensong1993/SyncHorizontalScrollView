package com.shanghai.flexiblelistwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shanghai.flexiblelibrary.SyncHorizontalScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mLeftListView;
    RecyclerView mRightListView;
    //横竖联动头容器
    SyncHorizontalScrollView mTitleHorScv;
    //横竖联动内容容器
    SyncHorizontalScrollView mContentHorScv;
    TabAdapter mTabAdapter,mTabContentAdapter;
    List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        listData();
        initData();
    }

    private void listData() {
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
        list.add("0");
    }

    private void initData() {
        // 设置两个水平控件的联动
        mTitleHorScv.setScrollView(mContentHorScv);
        mContentHorScv.setScrollView(mTitleHorScv);
        mTabAdapter = new TabAdapter(this, list,0);
        mTabContentAdapter = new TabAdapter(this, list,1);
        mLeftListView.setAdapter(mTabAdapter);
        mRightListView.setAdapter(mTabContentAdapter);
        mLeftListView.setLayoutManager(new LinearLayoutManager(this));
        mRightListView.setLayoutManager(new LinearLayoutManager(this));
        mLeftListView.setNestedScrollingEnabled(false);
        mRightListView.setNestedScrollingEnabled(false);
    }

    private void initView() {
        list = new ArrayList();
        mLeftListView = findViewById(R.id.left_container_listview);
        mRightListView = findViewById(R.id.right_container_listview);
        mTitleHorScv = findViewById(R.id.title_horsv);
        mContentHorScv = findViewById(R.id.content_horsv);
    }

}
