package com.pubaoyu.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.pubaoyu.base.BasePagerAdapter;
import com.pubaoyu.base.DownImage;

public class HomePage extends AppCompatActivity {
    ImageView icons[] = new ImageView[3];
    ViewPager viewPager;
    BasePagerAdapter leadPagerAdapter;
    DownImage downImage;
    String url = "http://192.168.1.117:8080/HttpHou/images/naifen.jpg";
    String ur2 = "http://192.168.1.117:8080/HttpHou/images/tongxie.jpg";
    String ur3 = "http://192.168.1.117:8080/HttpHou/images/yunying.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__page);

      //  初始化引导页面小图标+skip (5  个小图标 + 1 个 个 skip  文字)
        initLeadIcon();
//  初始化引导页面 ViewPager  视图 (给 给 ViewPager  设置 Adapter)
        initViewPager();
//  初始化引导页面 ViewPager  内显示的视图数据 (向 向 ViewPager  的  Adapter 内添加视图( 图片))
        initPagerData();
    }

    private void initLeadIcon() {
        icons[0] = (ImageView) findViewById(R.id.icon1);
        icons[1] = (ImageView) findViewById(R.id.icon2);
        icons[2] = (ImageView) findViewById(R.id.icon3);
        icons[0].setImageResource(R.drawable.adware_style_selected);
    }

    private ViewPager.OnPageChangeListener pageChangeListener = new
            ViewPager.OnPageChangeListener() {
                @Override
                public void onPageSelected(int arg0) {
//  更新下标图标
                    for (int i = 0; i < icons.length; i++) {
                        icons[i].setImageResource(R.drawable.adware_style_default);
                    }
                    icons[arg0].setImageResource(R.drawable.adware_style_selected);
                }

                @Override
                public void onPageScrolled(int arg0, float arg1, int arg2) {
                }

                @Override
                public void onPageScrollStateChanged(int arg0) {
                }
            };

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        leadPagerAdapter = new BasePagerAdapter(this);
        viewPager.setAdapter(leadPagerAdapter);
        viewPager.setOnPageChangeListener(pageChangeListener);
    }

    private void initPagerData() {
        ImageView imageView = null;
        imageView = (ImageView)
                getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        downImage=new DownImage(imageView,url);
        downImage.execute();
        leadPagerAdapter.addViewToAdapter(imageView);

        imageView = (ImageView)
                getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        downImage=new DownImage(imageView,ur2);
        downImage.execute();
        leadPagerAdapter.addViewToAdapter(imageView);
        imageView = (ImageView)
                getLayoutInflater().inflate(R.layout.activity_lead_item, null);
        downImage=new DownImage(imageView,ur3);
        downImage.execute();
        leadPagerAdapter.addViewToAdapter(imageView);
        leadPagerAdapter.notifyDataSetChanged();
    }

}

