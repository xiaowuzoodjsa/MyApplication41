package arr.myapplication.model;

import com.google.gson.Gson;

import java.io.IOException;

import arr.myapplication.App.App;
import arr.myapplication.model.entity.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 1 on 2017/8/10.
 */

public class OkHttpManger implements getUrl{
    private  static OkHttpManger okHttpManger;
    private OkHttpClient client;


    public static  OkHttpManger getInstance(){
        if (okHttpManger==null){
            synchronized (OkHttpManger.class){
                okHttpManger=new OkHttpManger();
            }
        }
        return okHttpManger;
    }

    private OkHttpManger() {

    }
    @Override
    public void get(String url, final OkHttpInfa okHttpInfa) {
        client = new OkHttpClient.Builder().build();
        Request request=new Request.Builder().url(url).build();
        Call call= client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                okHttpInfa.onError(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Gson gson = new Gson();
                        Bean bean = gson.fromJson(string, Bean.class);
                        okHttpInfa.onSuccess(bean);


                    }
                });
            }
        });
    }
}
