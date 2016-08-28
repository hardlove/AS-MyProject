package com.future.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.future.map.baidu.ui.BaiduMapActivity;

public class MainActivity extends AppCompatActivity {

    @butterknife.Bind(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);

        Intent i = new Intent(this, BaiduMapActivity.class);
        startActivity(i);
    }
}
