package arr.myapplication.app;

import android.app.Application;

import arr.myapplication.controller.base.BaseActivity;

/**
 * Created by 1 on 2017/8/10.
 */

public class App extends Application {
    public static BaseActivity baseActivity;
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
