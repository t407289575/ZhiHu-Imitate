package com.example.administrator.zhihu_imitate.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.zhihu_imitate.R;
import com.example.administrator.zhihu_imitate.model.DrawerListItemModel;

import java.util.List;

/**
 * Created by Administrator on 2015/9/15.
 */
public class DrawerListAdapter extends BaseAdapter {

    private Context mContext;
    private List<DrawerListItemModel> mItemModelList;
    public DrawerListAdapter() {
    }

    public DrawerListAdapter(Context context,List<DrawerListItemModel> itemModelListe){
        this.mContext = context;
        this.mItemModelList = itemModelListe;
    }

    @Override
    public int getCount() {
        return mItemModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return mItemModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder ;
        if (convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.drawerlistitem,null);
            holder = new ViewHolder();
            holder.imageIcon = (ImageView) convertView.findViewById(R.id.item_icon);
            holder.textTitle = (TextView) convertView.findViewById(R.id.item_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageIcon.setImageResource(mItemModelList.get(position).getIconId());
        holder.textTitle.setText(mItemModelList.get(position).getTitle());

        return convertView;
    }

    private class ViewHolder{
        private ImageView imageIcon;
        private TextView textTitle;
    }
}
