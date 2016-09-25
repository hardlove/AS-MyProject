package com.future.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;
import jp.wasabeef.glide.transformations.BlurTransformation;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.screen_bg)
    ImageView mScreenBg;
    @Bind(R.id.screen_bottom_bg)
    ImageView mScreenBottomBg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Glide.with(this).load(R.mipmap.screen_bg).centerCrop().bitmapTransform(new BlurTransformation(this, 128, 3)).into(mScreenBg);


        String url = "http://g.hiphotos.baidu.com/baike/c0%3Dbaike116%2C5%2C5%2C116%2C38/sign=73c143f9ae51f3ded7bfb136f5879b7a/6d81800a19d8bc3e5fe28df9838ba61ea8d3451f.jpg";
        Glide.with(this).load(url).centerCrop().bitmapTransform(new BlurTransformation(this, 10, 3)).into(mScreenBottomBg);

    }
}
