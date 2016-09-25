package com.future.myproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.future.widgets.library.PopupListMenu;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.title)
    TextView title;
    @Bind(R.id.child_1)
    Button child1;
    @Bind(R.id.child_2)
    Button child2;
    @Bind(R.id.parent)
    LinearLayout parent;
    private static final String TAG = "MainActivity";
    private PopupListMenu popupList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    public void tesPopupMenu(View view) {
        if (popupList == null) {
            List<String> list = new ArrayList<>();
            list.add("全选");
            list.add("复制");
            list.add("更多");
            popupList = new PopupListMenu(this,view,list);
            popupList.setOnPopupMenuListClickListener(new PopupListMenu.OnPopupMenuListClickListener() {

                @Override
                public void onPopupListClick(int menuPosition, String menuDes) {
                    Toast.makeText(MainActivity.this, menuPosition + "  " + menuDes, 0).show();
                }
            });
        }

        popupList.showPopupListWindow();
    }

    @OnClick({R.id.child_1, R.id.child_2, R.id.parent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.child_1:
                Log.i(TAG, "click child 1");
                break;
            case R.id.child_2:
                Log.i(TAG, "click child 2");
                break;
            case R.id.parent:
                Log.i(TAG, "click parent");
                break;
        }
    }
}
