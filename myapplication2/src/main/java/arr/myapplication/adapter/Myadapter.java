package arr.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import arr.myapplication.R;
import arr.myapplication.contorller.MainActivity;
import arr.myapplication.model.entity.Bean;

/**
 * Created by 1 on 2017/8/9.
 */
public class Myadapter extends BaseAdapter{
    private MainActivity mainActivity;
    private List<Bean.DataBean.GoodsBriefBean> activityInfoList;
    public Myadapter(MainActivity mainActivity, List<Bean.DataBean.GoodsBriefBean> activityInfoList) {
        this.mainActivity=mainActivity;
        this.activityInfoList=activityInfoList;
    }

    @Override
    public int getCount() {
        return activityInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return activityInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=View.inflate(mainActivity, R.layout.item,null);
            viewHolder=new ViewHolder();
            viewHolder.image= (TextView) convertView.findViewById(R.id.imagev);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.image.setText(activityInfoList.get(position).getGoods_name());
        return convertView;
    }
    class ViewHolder{
        TextView image;
    }
}
