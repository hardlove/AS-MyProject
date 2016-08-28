package com.future.myproject.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.globalroam.gruc.enterprise.utils.Log;
import com.globalroam.voip.api.MLoginApi;

/**
 * Created by chenlu on 2016/8/5 0005.
 */
public class ScreenActionReceiver extends BroadcastReceiver {
    private static final String TAG = "ScreenActionReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive");
        String action = intent.getAction();
        /**
         * screen on   screen off 静态注册无法监听到，，screen unlock 可以静态注册
         */
        if (Intent.ACTION_SCREEN_ON.equals(action)) {
            Log.d(TAG, "screen on");
        } else if (Intent.ACTION_SCREEN_OFF.equals(action)) {
            Log.d(TAG, "screen off");
        } else if (Intent.ACTION_USER_PRESENT.equals(action)) {
            Log.d(TAG, "screen unlock . islogin:"+MLoginApi.isLogin());
            MLoginApi.checkLoginStatus();


        }

    }
}
