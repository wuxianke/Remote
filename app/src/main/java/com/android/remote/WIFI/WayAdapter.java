package com.android.remote.WIFI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.remote.MyApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxianke on 2018/4/1.
 */

public class WayAdapter extends BaseAdapter {

    private LayoutInflater inflater;


    private List<String> wayList = new ArrayList<String>(){
        {
            add("wpa_aes/wpa_tkip");
            add("wpa2_aes/wpa2_tkip");
            add("wpa/wpa2_aes");
        }
    };



    @Override
    public int getCount() {
        return wayList.size();
    }

    @Override
    public Object getItem(int position) {
        return wayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv = new TextView(MyApplication.getInstance());
        tv.setText(wayList.get(position));
        return tv;
    }
}
