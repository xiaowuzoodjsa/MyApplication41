package arr.myapplication.contorller;

import android.widget.Button;

import arr.myapplication.R;
import arr.myapplication.contorller.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private Button btu_add;
    private Button btu_delete;
    private Button btu_chaxun;
    private Button btu_update;

    @Override
    protected void initView() {
        btu_add = (Button) findViewById(R.id.btu_add);
        btu_delete = (Button) findViewById(R.id.btu_delete);
        btu_chaxun = (Button) findViewById(R.id.btu_chaxun);
        btu_update = (Button) findViewById(R.id.btu_update);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int initById() {
        return R.layout.activity_main;
    }

    @Override
    protected void linstener() {

    }
}
