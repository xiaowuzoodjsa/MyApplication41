package arr.myapplication.model;

import arr.myapplication.model.entity.Bean;

/**
 * Created by 1 on 2017/8/10.
 */

public interface OkHttpInfa {
   void onSuccess(Bean bean);
    void onError(String string);
}
