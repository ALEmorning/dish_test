package com.example.test.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.test.R;

import java.util.List;

/*
主要用于设定listview的适配器
 */
public class collectAdapter extends BaseAdapter {
    Context mContext;
    List<item> mList;
    ViewHolder mViewHolder;

    public collectAdapter(Context mContext, List<item> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final item it = mList.get(i);
        if (view == null) {
            //用LayouInflater加载布局，传给布局对象view
            // 用view找到三个控件，存放在viewHolder中，再把viewHolder储存到View中
            // 完成了把控件展示在ListView的步骤
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_choose, viewGroup, false);

            mViewHolder = new ViewHolder();
            mViewHolder.checkBox = (CheckBox) view.findViewById(R.id.checkbox_1);
            mViewHolder.menu_name = (TextView) view.findViewById(R.id.t_menu_name);

            view.setTag(mViewHolder);
        } else {

            mViewHolder = (ViewHolder) view.getTag();
        }
        mViewHolder.checkBox.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        it.setIscheck(b);
                    }

                });
        mViewHolder.menu_name.setText(it.getMenu_name());

        mViewHolder.checkBox.setChecked(it.getIscheck());

        return view;
    }

    class ViewHolder {
        TextView menu_name;

        CheckBox checkBox;

    }
}



