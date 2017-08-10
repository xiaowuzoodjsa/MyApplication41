package arr.myapplication.model;

import arr.myapplication.model.entity.Bean;

/**
 * Created by 1 on 2017/8/9.
 */

public interface NetInfo {
    void onSuccess(Bean bean);
    void onError(String str);
}
