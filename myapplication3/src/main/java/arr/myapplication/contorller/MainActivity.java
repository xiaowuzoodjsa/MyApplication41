package arr.myapplication.contorller;

import android.widget.ListView;

import java.util.List;

import arr.myapplication.R;
import arr.myapplication.contorller.base.BaseActivity;
import arr.myapplication.model.OkHttpInfa;
import arr.myapplication.model.OkHttpManger;
import arr.myapplication.model.entity.Bean;

public class MainActivity extends BaseActivity {


    private ListView listv;
    String url="http://m.yunifang.com/yunifang/mobile/goods/getall?random=86588&encode=102e81c24a35dbdc9bb130c3c164434b&category_id=13";

    @Override
    protected void initView() {
        listv = (ListView) findViewById(R.id.listv);
    }

    @Override
    protected void initData() {

        OkHttpManger.getInstance().get(url, new OkHttpInfa() {
            @Override
            public void onSuccess(Bean bean) {
                List<Bean.DataBean> data = bean.getData();
                Myadapter adapter=new Myadapter(MainActivity.this,data);
                listv.setAdapter(adapter);
            }

            @Override
            public void onError(String string) {

            }
        });

    }

    @Override
    protected int initId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initLinsenter() {

    }
}
