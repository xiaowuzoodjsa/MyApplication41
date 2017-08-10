package arr.myapplication.contorller.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import arr.myapplication.App.App;

/**
 * Created by 1 on 2017/8/10.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.baseActivity=this;
        setContentView(initId());
        initView();
        initLinsenter();
        initData();
    }
    protected abstract void initView();
    protected abstract void initData();
    protected abstract int initId();
    protected abstract void initLinsenter();
}
