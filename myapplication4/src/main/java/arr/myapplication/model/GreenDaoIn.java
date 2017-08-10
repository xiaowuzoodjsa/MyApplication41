package arr.myapplication.model;

import java.util.List;

import arr.myapplication.model.entity.ShopBean;

/**
 * Created by 1 on 2017/8/10.
 */

public interface GreenDaoIn {
    void adds(ShopBean bean);
    void delete(int id);
    void update(int id,String name,String pwd);
    List<ShopBean> queryAll();
}
