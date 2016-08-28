package com.future.map.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.future.map.baidu.utils.Log;

/**
 * Created by CL on 2016/8/27.
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";
    public void registerReceiver(){}
    public void unRegisterReceiver(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG,"onCreate~~");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"onStart~~");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG,"onRestart~~");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume~~");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause~~");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"onStop~~");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"onDestroy~~");
        super.onDestroy();
    }
}
