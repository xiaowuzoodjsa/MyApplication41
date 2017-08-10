package arr.myapplication.controller.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import arr.myapplication.app.App;

/**
 * Created by 1 on 2017/8/9.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        App.baseActivity=this;
        initView();
        initData();
        initLinstener();
    }



    public abstract void initView();
    public abstract void initData();
    public abstract int layoutId();
    public abstract void initLinstener();
}
