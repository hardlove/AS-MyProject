package com.future.map.baidu.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.future.map.R;
import com.future.map.base.BaseActivity;

/**
 * Created by CL on 2016/8/27.
 */
public class BaiduMapActivity extends BaseActivity {

    private static final String TAG = "BaiduMapActivity";
    private TextView mBack;
    private TextView mSend;
    private TextView mTtitle;
    private FrameLayout mContainer;
    private FragmentTabHost mTabHost;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_layout);
        initView();

        mTabHost.setup(this, getSupportFragmentManager(), R.id.real_tab_content);
        Class<?> mFragment = PoiFragment.class;
        Bundle bundle = null;
        mTabHost.addTab(mTabHost.newTabSpec("全部").setIndicator("全部"), mFragment, bundle);
        mTabHost.addTab(mTabHost.newTabSpec("小区").setIndicator("小区"), mFragment, bundle);
        mTabHost.addTab(mTabHost.newTabSpec("办公楼").setIndicator("办公楼"), mFragment, bundle);
        mTabHost.addTab(mTabHost.newTabSpec("广场").setIndicator("广场"), mFragment, bundle);


    }

    private void initView() {
        mBack = (TextView) findViewById(R.id.left_back);
        mSend = (TextView) findViewById(R.id.title_right);
        mTtitle = (TextView) findViewById(R.id.title_center);
        mContainer = (FrameLayout) findViewById(R.id.map_container);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);

    }

}
