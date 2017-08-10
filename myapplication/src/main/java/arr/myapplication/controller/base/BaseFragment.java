package arr.myapplication.controller.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import arr.myapplication.R;

/**
 * Created by 1 on 2017/8/10.
 */

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);

        initView();
        initData();
        initLinstener();
        return textView;
    }
    public abstract void initView();
    public abstract void initData();
    public abstract int layoutId();
    public abstract void initLinstener();
}
