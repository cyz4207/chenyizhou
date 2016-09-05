package com.pubaoyu.base;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/8/30 0030.
 */
public class DownImage extends AsyncTask<String,Float,Bitmap> {
    private ImageView imageView;
    String url;

    public DownImage(ImageView imageView,String url) {
        this.imageView = imageView;
        this.url=url;
    }


    @Override
    protected void onPostExecute(Bitmap o) {
        imageView.setImageBitmap(o);
    }

    @Override
    protected Bitmap doInBackground(String... bitmaps) {


        Bitmap bitmap = null;
        try {
            //加载一个网络图片
            InputStream is = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
