package com.pubaoyu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.pubaoyu.user.UserNa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/30.
 */
public class HomeAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    List<UserNa> list=new ArrayList<UserNa>();
    public HomeAdapter(){

    }
    public HomeAdapter(Context context){
        this.context=context;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public UserNa getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public List<UserNa> getUser(){
        return list;
    }
    //  添加数据到当前适配器集合
    public void addDataToAdapter(UserNa e) {
        if (e != null) {
            list.add(e);
        }
    }
    //  添加数据到当前适配器集合
    public void addDataToAdapter(List<UserNa> e) {
        if (e != null) {
            list.addAll(e);
        }
    }

    public void clearAdapter() {
        list.clear();
    }
    //  删除当前适配器集合内数据
    public void removeDataFromAdapter(UserNa e) {
        list.remove(e);
    }

    //  删除当前适配器集合内数据
    public void removeDataFromAdapter(int index) {
        list.remove(index);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
