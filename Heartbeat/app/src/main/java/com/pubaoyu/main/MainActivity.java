package com.pubaoyu.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button,button1;
    EditText editText1,editText2;
    //7.定义一个OkHttpClient
    final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button1= (Button) findViewById(R.id.button2);
        editText1= (EditText) findViewById(R.id.editText1);
        editText2= (EditText) findViewById(R.id.editText2);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
    }
    //4.实现代码操作
    @Override
    public void onClick(View view) {
        //5.
        switch (view.getId()) {
            case R.id.button:
                getRequest();
                break;
            case R.id.button2:
                postQin();
                break;
        }
    }

    /**
     * 6.get请求的方法
     */
    private void getRequest() {
        //在android中不能在ui中直接访问网络，所以我们需要自已定义线程的操作
        //6.1创建一个Request请求
        String url = "http://192.168.1.117:8080/HttpHou/OkHttpT";
        //创建request请求
        final Request request1 = new Request.Builder().get().tag(this).url(url).build();
        //创建一个线程
        new Thread(new Runnable() {
            ///重写run方法
            @Override
            public void run() {
                //定义一个响应
                Response response = null;
                //执行刚才我们创建的  OkHttpClient client = new OkHttpClient();
                try {
                    //得到我们的response对象
                    response = client.newCall(request1).execute();
                    //表示响应成功
                    if (response.isSuccessful()) {
                        //得到我们返回的数据
                        String str = response.body().string();
                        Log.v("执行成功", str);
                    } else {
                        Log.v("执行失败", response.code() + "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    public static final MediaType JOSN=MediaType.parse("application/json;charset=utf-8");
    public void postQin() {
        String name="adsafewfw";
        RequestBody body=RequestBody.create(JOSN,name);
        String url = "http://192.168.1.117:8080/HttpHou/Okaaa";
        final Request request=new Request.Builder().url(url).post(body).build();
        new Thread(new Runnable() {
            ///重写run方法
            @Override
            public void run() {
                //定义一个响应
                Response response = null;
                //执行刚才我们创建的  OkHttpClient client = new OkHttpClient();
                try {
                    //得到我们的response对象
                    response = client.newCall(request).execute();
                    //表示响应成功
                    if (response.isSuccessful()) {
                        //得到我们返回的数据
                        String str = response.body().string();
                        Log.v("执行成功", str);
                    } else {
                        Log.v("执行失败", response.code() + "");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
