package arr.myapplication.contorller.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by 1 on 2017/8/10.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initById());
        initView();
        initData();

        linstener();
    }
    protected abstract void  initView();
    protected abstract void initData();
    protected abstract int initById();
    protected abstract void linstener();

}
