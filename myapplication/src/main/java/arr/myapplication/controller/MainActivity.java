package arr.myapplication.controller;

import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.Map;

import arr.myapplication.R;
import arr.myapplication.controller.base.BaseActivity;
import arr.myapplication.model.NetInfo;
import arr.myapplication.model.OkHttpManger;
import arr.myapplication.model.OkHttpUtils;
import arr.myapplication.model.entity.Bean;

public class MainActivity extends BaseActivity implements OkHttpManger{

    private ListView listv;
    private RelativeLayout activity_main;

    @Override
    public void get(String url, NetInfo info) {
        OkHttpUtils.getInstance().get("", new NetInfo() {
            @Override
            public void onSuccess(Bean bean) {

            }

            @Override
            public void onError(String str) {

            }
        });
    }

    @Override
    public void post(String url, Map<String, String> map, NetInfo info) {

    }

    @Override
    public void initView() {
        listv = (ListView) findViewById(R.id.listv);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
    }

    @Override
    public void initData() {

    }

    @Override
    public int layoutId() {
        return R.id.activity_main;
    }

    @Override
    public void initLinstener() {

    }
}
