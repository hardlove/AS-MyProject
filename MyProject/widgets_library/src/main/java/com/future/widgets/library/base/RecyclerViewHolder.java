package com.future.widgets.library.base;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mViews;//集合类，layout里包含的View,以view的id作为key，value是view对象
    private Context mContext;//上下文对象

    public RecyclerViewHolder(Context ctx, View itemView) {
        super(itemView);
        mContext = ctx;
        mViews = new SparseArray<View>();
    }

    private <T extends View> T findViewById(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getView(int viewId) {
        return findViewById(viewId);
    }

    public TextView getTextView(int viewId) {
        return (TextView) getView(viewId);
    }

    public Button getButton(int viewId) {
        return (Button) getView(viewId);
    }

    public ImageView getImageView(int viewId) {
        return (ImageView) getView(viewId);
    }

    public CheckBox getCheckBox(int viesId) {
        return (CheckBox) getView(viesId);
    }
    public ProgressBar getProgressBar(int viesId) {
        return (ProgressBar) getView(viesId);
    }

    public ImageButton getImageButton(int viewId) {
        return (ImageButton) getView(viewId);
    }

    public EditText getEditText(int viewId) {
        return (EditText) getView(viewId);
    }




    /**
     * 设置网络圆形图片
     */
    public RecyclerViewHolder setCircleImageFromNet(int viewId, String path, int id) {
        ImageView iv = findViewById(viewId);
        return this;
    }

    /**
     * 设置一个网络圆角图
     */
    public RecyclerViewHolder setRoundCornerImgFromNet(int viewId, String path, int radius) {
        ImageView iv = findViewById(viewId);
        return this;
    }

    /**
     * 展示正常网络图片
     */
    public RecyclerViewHolder setNormalImgPath(int viewId, String path) {
        ImageView iv = findViewById(viewId);
        return this;
    }

    public RecyclerViewHolder setNormalImgPath(int viewId, String path, int defaultResId) {
        ImageView iv = findViewById(viewId);
        return this;
    }

    /**
     * 展示资源圆角图片
     */
    public RecyclerViewHolder setResRoundConerImg(int viewId, int resourceId, int radius) {
        ImageView iv = findViewById(viewId);
        return this;
    }



    public RecyclerViewHolder setTextView(int viewId, CharSequence content) {
        TextView tv = findViewById(viewId);
        tv.setText(content);
        return this;
    }

    public RecyclerViewHolder setTextView(int viewId, int resid) {
        TextView tv = findViewById(viewId);
        tv.setText(resid);
        return this;
    }


    public RecyclerViewHolder setItemOnClickListener(int viewId, View.OnClickListener listener) {
        View view = findViewById(viewId);
        view.setOnClickListener(listener);
        return this;
    }
}
