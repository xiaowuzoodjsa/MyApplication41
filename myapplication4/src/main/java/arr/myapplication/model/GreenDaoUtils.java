package arr.myapplication.model;

import android.content.Context;

import java.util.List;

import arr.myapplication.model.entity.DaoMaster;
import arr.myapplication.model.entity.DaoSession;
import arr.myapplication.model.entity.ShopBean;
import arr.myapplication.model.entity.ShopBeanDao;

/**
 * Created by 1 on 2017/8/10.
 */

public class GreenDaoUtils implements GreenDaoIn{
    private static GreenDaoUtils utils;
    private static Context context;
    private static String name;
    private final ShopBeanDao shopBeanDao;

    public static GreenDaoUtils getInstance(){
        if (utils==null){
            synchronized (GreenDaoUtils.class){
                utils=new GreenDaoUtils(context,name);
            }
        }
        return utils;
    }

    public  GreenDaoUtils(Context context,String name) {
        this.context=context;
        this.name=name;
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,name);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());
        DaoSession daoSession = daoMaster.newSession();
        shopBeanDao = daoSession.getShopBeanDao();

    }

    @Override
    public void adds(ShopBean bean) {
        shopBeanDao.insert(bean);
    }

    @Override
    public void delete(int id) {
        ShopBean shopBean = shopBeanDao.loadByRowId(id);
        shopBeanDao.delete(shopBean);
    }

    @Override
    public void update(int id, String name, String pwd) {
        ShopBean shopBean = shopBeanDao.loadByRowId(id);
        shopBean.setName(name);
        shopBean.setPwd(pwd);
    }

    @Override
    public List<ShopBean> queryAll() {
        List<ShopBean> shopBeen = shopBeanDao.loadAll();
        return shopBeen;
    }


}
