package com.android.remote.WIFI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.remote.MyApplication;
import com.android.remote.R;

import java.util.List;

/**
 * Created by wuxianke on 2018/4/1.
 */

public class NameAdapter extends BaseAdapter {

    private List<String> nameList;
    private LayoutInflater mInflater;
    private Context context;
    private Wifi wifi;
    private MyApplication myApplication;

    public NameAdapter(Context context, List<String> list){
        nameList = list;
        mInflater = LayoutInflater.from(context);
    }



    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int position) {
        return nameList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){  //没有缓存的
            convertView = mInflater.inflate(R.layout.wifi_item,null);
        }
        TextView textView = new TextView(MyApplication.getInstance());
        textView.setText(nameList.get(position));
        return textView;

    }
}
