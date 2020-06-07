package com.lucky.mplayer.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.lucky.mplayer.R;
import com.lucky.mplayer.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserListAdapter extends BaseAdapter{


    private Context mContext;

    private LayoutInflater mInflater;

    private List<User> datas;

    public UserListAdapter(Context context, List<User> datas) {
        this.mContext = context;
        this.datas = datas;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas != null ? datas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder holder;
        View view = mInflater.from(mContext).inflate(R.layout.item_user, parent, false);
        holder = new MyViewHolder(view);
        ((MyViewHolder)holder).txt1.setText("username："+datas.get(position).getUserName());
        ((MyViewHolder)holder).txt2.setText("id："+datas.get(position).getUserTel());
        return view;
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt1)
        TextView txt1;
        @BindView(R.id.txt2)
        TextView txt2;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
