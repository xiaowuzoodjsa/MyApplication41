package arr.myapplication.App;

import android.app.Application;

import arr.myapplication.contorller.base.BaseActivity;

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
