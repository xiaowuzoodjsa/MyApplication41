package arr.myapplication.contorller;

import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import arr.myapplication.R;
import arr.myapplication.contorller.base.BaseActivity;
import arr.myapplication.model.GreenDaoUtils;
import arr.myapplication.model.entity.ShopBean;
import arr.myapplication.model.entity.ShopBeanDao;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button btu_add;
    private Button btu_delete;
    private Button btu_chaxun;
    private Button btu_update;
    private ShopBeanDao shopBeanDao;
    private GreenDaoUtils green;
    private List<ShopBean> list1;

    @Override
    protected void initView() {
        btu_add = (Button) findViewById(R.id.btu_add);
        btu_delete = (Button) findViewById(R.id.btu_delete);
        btu_chaxun = (Button) findViewById(R.id.btu_chaxun);
        btu_update = (Button) findViewById(R.id.btu_update);
    }

    @Override
    protected void initData() {
        green = new GreenDaoUtils(MainActivity.this,"dsad");
        list1 = new ArrayList<>();

    }

    @Override
    protected int initById() {
        return R.layout.activity_main;

    }

    @Override
    protected void linstener() {
        btu_add.setOnClickListener(this);
        btu_delete.setOnClickListener(this);
        btu_chaxun.setOnClickListener(this);
        btu_update.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btu_add:
                for (int i = 0; i <5 ; i++) {
                    green.adds(new ShopBean(null,"xiaowu"+i,"1230"+i));
                }

                break;
            case R.id.btu_chaxun:
                List<ShopBean> shopBeen = green.queryAll();
                for (int i = 0; i <shopBeen.size() ; i++) {
                    System.out.println(shopBeen.get(i).getId()+shopBeen.get(i).getName()+shopBeen.get(i).getPwd());
                }
                break;
            case R.id.btu_delete:
                green.delete(2);
                break;
            case R.id.btu_update:
                green.update(1,"小五","dsaghgd");
                break;
        }
    }
}
