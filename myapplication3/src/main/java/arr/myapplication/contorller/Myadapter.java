package arr.myapplication.contorller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import arr.myapplication.R;
import arr.myapplication.model.entity.Bean;

/**
 * Created by 1 on 2017/8/10.
 */
public class Myadapter extends BaseAdapter{
    private MainActivity mainActivity;
    private List<Bean.DataBean> list;
    public Myadapter(MainActivity mainActivity, List<Bean.DataBean> list) {
        this.list=list;
        this.mainActivity=mainActivity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView=View.inflate(mainActivity, R.layout.item,null);
            viewHolder=new ViewHolder();
            viewHolder.text= (TextView) convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.text.setText(list.get(position).getGoods_name());
        return convertView;
    }
    class ViewHolder{
        TextView text;
    }
}
