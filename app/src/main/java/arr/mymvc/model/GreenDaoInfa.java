package arr.mymvc.model;

import java.util.List;

import arr.mymvc.model.entity.Bean;

/**
 * Created by 1 on 2017/8/9.
 */

public interface GreenDaoInfa {
    void adds(Bean bean);
    void deletes(long id);
    void update(long id,String name,String pwd);
    List<Bean> queryAll();
}
