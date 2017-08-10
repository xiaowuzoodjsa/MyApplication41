package arr.mymvc.contorller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import arr.mymvc.R;
import arr.mymvc.contorller.base.BaseActivity;
import arr.mymvc.model.GreenUtils;
import arr.mymvc.model.entity.Bean;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button button;
    private Button button2;
    private Button button3;
    private Button button4;
    private RelativeLayout activity_main;
    private GreenUtils greenUtils;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greenUtils = new GreenUtils(MainActivity.this, "nn");
        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        activity_main = (RelativeLayout) findViewById(R.id.activity_main);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                for (int i = 0; i < 5; i++) {
                    Bean bean = new Bean(null, "xiaowu" + i, "xiao" + i);
                    greenUtils.adds(bean);
                }
                break;
            case R.id.button2:
                greenUtils.deletes(2);
                break;
            case R.id.button3:
                greenUtils.update(1, "yangyang", "xiaowu");
                break;
            case R.id.button4:
                List<Bean> list = greenUtils.queryAll();
                for (int i = 0; i < list.size(); i++) {
                    Bean bean = list.get(i);
                    System.out.println(bean.getId()+bean.getName()+bean.getPwd());
                }
                break;
        }
    }
}
