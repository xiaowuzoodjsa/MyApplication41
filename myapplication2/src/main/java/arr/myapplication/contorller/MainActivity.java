package arr.myapplication.contorller;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.List;

import arr.myapplication.R;
import arr.myapplication.adapter.Myadapter;
import arr.myapplication.contorller.base.BaseActivity;
import arr.myapplication.model.LogiIn;
import arr.myapplication.model.entity.Bean;
import arr.myapplication.model.impl.OkHttpUtils;

public class MainActivity extends BaseActivity {

    private ListView listv;
    private RelativeLayout activity_main;
    String url="http://m.yunifang.com/yunifang/mobile/category/list?random=96333&encode=bf3386e14fe5bb0bcef234baebca2414";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        OkHttpUtils.getInstance().getNet(url, new LogiIn() {
            @Override
            public void onSuccess(Bean bean) {
                List<Bean.DataBean.GoodsBriefBean> goodsBrief = bean.getData().getGoodsBrief();
                Myadapter adapter=new Myadapter(MainActivity.this,goodsBrief);
                listv.setAdapter(adapter);
            }

            @Override
            public void onError(String string) {
                System.out.println(string);
            }
        });

    }

    private void initView() {
        listv = (ListView) findViewById(R.id.listv);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);
    }
}
