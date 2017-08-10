package arr.myapplication.model.impl;

import android.os.Handler;

import com.google.gson.Gson;

import java.io.IOException;

import arr.myapplication.model.LogiIn;
import arr.myapplication.model.LoginManger;
import arr.myapplication.model.entity.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 1 on 2017/8/9.
 */

public class OkHttpUtils implements LoginManger{
    private static OkHttpUtils utils;
    private final OkHttpClient client;
    private final Handler handler;
    private String string;

    public static OkHttpUtils getInstance(){
        if (utils==null){
            synchronized (OkHttpUtils.class){
                utils=new OkHttpUtils();
            }
        }
        return utils;
    }

    private  OkHttpUtils() {
        client = new OkHttpClient();
        handler = new Handler();
    }

    @Override
    public void getNet(String url, final LogiIn logiIn) {
        Request request=new Request.Builder().url(url).build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                logiIn.onError(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Gson gson=new Gson();
                        Bean bean = gson.fromJson(string, Bean.class);
                        logiIn.onSuccess(bean);
                    }
                });

            }
        });
    }
}
