package com.future.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.future.widgets.library.PopupListMenu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @butterknife.Bind(R.id.title)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butterknife.ButterKnife.bind(this);


    }

    public void tesPopupMenu(View view) {
        PopupListMenu popupList = new PopupListMenu();
        List<String> list = new ArrayList<>();
        list.add("全选");
        list.add("复制");
        list.add("更多");
        popupList.init(this, view, list, new PopupListMenu.OnPopupListClickListener() {
            @Override
            public void onPopupListClick(View contextView, int contextPosition, int position) {

            }
        });
    }
}
