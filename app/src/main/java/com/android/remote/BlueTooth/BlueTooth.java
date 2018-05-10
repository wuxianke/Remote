package com.android.remote.BlueTooth;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.remote.MyApplication;
import com.android.remote.R;
import com.android.remote.WIFI.Wifi;


/**
 * Created by wuxianke on 2018/3/26.
 * @author wuxianke
 */

public class BlueTooth extends Fragment {


    private Button button;
    private int receive;
    private Context mContext;
    private BluetoothAdapter bluetoothAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 在这里初始化fragment的页面
        View view = inflater.inflate(R.layout.bluetooth, null);
        mContext = MyApplication.getInstance();
        button = view.findViewById(R.id.checkBtn);
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        //setListen();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!bluetoothAdapter.isEnabled())
                {
                    bluetoothAdapter.enable();//异步的，不会等待结果，直接返回。
                }else{
                    bluetoothAdapter.startDiscovery();
                }
            }
        });
        return view;

    }

    public void showDialog(){
        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("请确定手机已与设备配对")
                .setPositiveButton("确定", null)
                .show();
    }

    /*@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //注册蓝牙监听
        mContext = getActivity();
        mContext.registerReceiver(mReceiver, makeFilter());
    }

    public void changeFragment(){
        Wifi wf = new Wifi();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, wf);
        ft.commit();
    }

    public void setListen(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(receive){
                    case 1:
                        changeFragment();
                    case 0:
                        showDialog();
                }
            }
        });
    }


    public void showDialog(){
        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage("请确定手机已与设备配对")
                .setPositiveButton("确定", null)
                .show();
    }

    //注销蓝牙监听
    //mContext.unregisterReceiver(mReceiver);

    private IntentFilter makeFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED);
        return filter;
    }

     private BroadcastReceiver mReceiver =  new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case BluetoothAdapter.ACTION_STATE_CHANGED:
                    int blueState = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, 0);
                    switch (blueState) {
                        case BluetoothAdapter.STATE_TURNING_ON:
                            receive = 1;
                            break;
                        case BluetoothAdapter.STATE_ON:
                            receive = 1;
                            break;
                        case BluetoothAdapter.STATE_TURNING_OFF:
                            receive = 0;
                            break;
                        case BluetoothAdapter.STATE_OFF:
                            receive = 0;
                            break;
                    }
                    break;
            }
        }
    };*/



}
