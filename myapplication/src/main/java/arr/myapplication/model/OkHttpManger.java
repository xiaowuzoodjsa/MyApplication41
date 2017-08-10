package arr.myapplication.model;

import java.util.Map;

/**
 * Created by 1 on 2017/8/9.
 */

public interface OkHttpManger {
    void get(String url,NetInfo info);
    void post(String url, Map<String,String> map,NetInfo info);
}
