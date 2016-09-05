package com.pubaoyu.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BasePagerAdapter extends PagerAdapter {

    protected Context context;
    private ArrayList<View> viewList = new ArrayList<View>();
    private ArrayList<String> tabtitleList = new ArrayList<String>();

    public BasePagerAdapter(Context context) {

        this.context = context;
    }
    public ArrayList<View> getViewList() {

        return viewList;
    }
    public void addViewToAdapter(View view) {

        viewList.add(view);
    }
    public void addTabToAdapter(String title) {

        tabtitleList.add(title);
    }


    @Override
    public CharSequence getPageTitle(int position) {

        return tabtitleList.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object
            object) {
        View view = viewList.get(position);
        container.removeView(view);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = viewList.get(position);
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}
