package arr.mymvc.model;

import android.content.Context;

import java.util.List;

import arr.mymvc.model.entity.Bean;
import arr.mymvc.model.entity.BeanDao;
import arr.mymvc.model.entity.DaoMaster;
import arr.mymvc.model.entity.DaoSession;

/**
 * Created by 1 on 2017/8/9.
 */

public class GreenUtils implements GreenDaoInfa {
    private static Context context;
    private static String names;
    private static BeanDao beanDao;
    private static GreenUtils greenUtils;


    public GreenUtils(Context context,String names) {
        this.context=context;
        this.names=names;

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context,names);

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getReadableDb());

        DaoSession daoSession = daoMaster.newSession();
        beanDao = daoSession.getBeanDao();
    }

    private static GreenUtils getIntance() {
        if (greenUtils==null){
            greenUtils=new GreenUtils(context,names);
        }
        return greenUtils;
    }


    @Override
    public void adds(Bean bean) {
        beanDao.insert(bean);
    }

    @Override
    public void deletes(long id) {
        Bean bean = beanDao.loadByRowId(id);
        beanDao.delete(bean);
    }

    @Override
    public void update(long id, String name, String pwd) {
        Bean bean = beanDao.loadByRowId(id);
        bean.setName(name);
        bean.setPwd(pwd);
    }

    @Override
    public List<Bean> queryAll() {
        List<Bean> list = beanDao.loadAll();
        return list;
    }
}
