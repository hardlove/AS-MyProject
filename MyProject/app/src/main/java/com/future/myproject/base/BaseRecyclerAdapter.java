package com.future.myproject.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenlu on 2016/7/7 0007.
 */
public abstract class  BaseRecyclerAdapter<T,VH extends RecyclerViewHolder> extends RecyclerView.Adapter<VH> {

    protected  List<T> mData;
    protected final Context mContext;
    protected LayoutInflater mInflater;
    protected OnItemClickListener mClickListener;
    private OnItemLongClickListener mLongClickListener;

    protected int firstVisibilityPosition;
    protected int lastVisibilityPosition;

    public OnItemLongClickListener getOnItemLongClickListener() {
        return mLongClickListener;
    }

    public int getFirstVisibilityPosition() {
        return firstVisibilityPosition;
    }

    public void setFirstVisibilityPosition(int firstVisibilityPosition) {
        this.firstVisibilityPosition = firstVisibilityPosition;
    }

    public int getLastVisibilityPosition() {
        return lastVisibilityPosition;
    }

    public void setLastVisibilityPosition(int lastVisibilityPosition) {
        this.lastVisibilityPosition = lastVisibilityPosition;
    }

    public BaseRecyclerAdapter(Context ctx, List<T> list) {
        mData = (list != null) ? list : new ArrayList<T>();
        mContext = ctx;
        mInflater = LayoutInflater.from(ctx);
    }

    public abstract VH onCreateItemViewHolder(Context mContext, View itemView, int viewType);


    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(getItemLayoutId(viewType), parent, false);
        final VH holder = onCreateItemViewHolder(mContext, itemView,viewType);
        if (mClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mClickListener.onItemClick(holder.itemView, holder.getLayoutPosition());
                }
            });
        }
        if (mLongClickListener != null) {
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mLongClickListener.onItemLongClick(holder.itemView, holder.getLayoutPosition());
                    return true;
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        bindData(holder, position, position < mData.size() ? mData.get(position) : null);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void add(int pos, T item) {
        mData.add(pos, item);
        notifyItemInserted(pos);
    }

    public void delete(int pos) {
        mData.remove(pos);
        notifyItemRemoved(pos);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mClickListener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        mLongClickListener = listener;
    }

    abstract public int getItemLayoutId(int viewType);

    abstract public void bindData(VH holder, int position, T itemData);

    public interface OnItemClickListener {
        public void onItemClick(View itemView, int pos);
    }

    public interface OnItemLongClickListener {
        public void onItemLongClick(View itemView, int pos);
    }
}
