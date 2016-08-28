package com.future.myproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;

import com.future.myproject.utils.Log;


/**
 * Created by CL on 2016/8/27.
 */
public class BaseActivity extends AppCompatActivity {

    private static final String TAG = "BaseActivity";

    private SparseArray<View> mViews = new SparseArray<>();
    public void registerReceiver(){}
    public void unRegisterReceiver(){}

    public <T extends View> T bindView(int resId){
        T v = (T) mViews.get(resId);
        if (v == null) {
            v = (T) findViewById(resId);
            if (v != null) {
                mViews.put(resId, v);
            } else {
                throw new NullPointerException("found View failed, the view id is:" + resId);
            }
        }
        return v;
    }

    private Toast mToast;
    public void showToast(int resId) {
        if (mToast!=null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showToast(CharSequence msg) {
        if (mToast != null) {
            mToast.cancel();
        }
        mToast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        mToast.show();
    }

    public void showLoadingDialog(String msg) {
        DialogFragment df = new AppCompatDialogFragment();

    }

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
