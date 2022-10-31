package com.example.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 万能适配器
 */
public class UniversalAdapter extends BaseAdapter {
    private Context context;
    private int layoutId;
    private List dataList;
    private InitViewCallBack initViewCallBack;

    public interface InitViewCallBack {
        void initView(int i, View view, Object object);

    }

    public void setInitViewCallBack(InitViewCallBack initViewCallBack) {
        this.initViewCallBack = initViewCallBack;
    }

    public UniversalAdapter(Context context, int layoutId, List dataList) {
        this.context = context;
        this.layoutId = layoutId;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(layoutId, null);
        Object  o =  dataList.get(i);
        if (initViewCallBack!=null){
            initViewCallBack.initView(i,view,o);
        }

        return view;
    }
}
