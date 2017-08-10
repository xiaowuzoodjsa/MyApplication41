package arr.myapplication.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import arr.myapplication.model.entity.Bean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 1 on 2017/8/9.
 */

public class OkHttpUtils implements OkHttpManger{
    private static OkHttpUtils utils;
    private final OkHttpClient client;

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
    }

    @Override
    public void get(String url, final NetInfo info) {
        Request request=new Request.Builder().url(url).build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                info.onError(e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson=new Gson();
                Bean bean = gson.fromJson(string, Bean.class);
                info.onSuccess(bean);
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> map, NetInfo info) {
    //  RequestBody requestBody=new FormBody.Builder().add();
     //  Request request=new Request.Builder().post(requestBody).url(url).build();
     //   Call call=client.newCall(request);
    }

}
