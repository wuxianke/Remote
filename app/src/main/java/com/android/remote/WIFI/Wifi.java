package com.android.remote.WIFI;

import android.app.Fragment;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.android.remote.BlueTooth.BlueTooth;
import com.android.remote.DropEditText.DropEditText;
import com.android.remote.DropEditText.WrapListView;
import com.android.remote.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxianke on 2018/3/27.
 * @author wuxianke
 */

public class Wifi extends Fragment {

    private Context mcontext;
    private NameAdapter nameAdapter;
    private String wifiName;
    private WifiManager wifiManager;
    private WrapListView mPopView;
    private BlueTooth blueTooth;
    ArrayList<ScanResult>list;
    List<String>wifiNames;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wifi, null);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        DropEditText drop1 = getView().findViewById(R.id.drop_edit);
        DropEditText drop2 = getView().findViewById(R.id.drop_edit2);
        final EditText password =getView().findViewById(R.id.password);
        final CheckBox checkBox1=getView().findViewById(R.id.checkBox1);

        mcontext = getActivity();
        wifiManager = (WifiManager) mcontext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo info = wifiManager.getConnectionInfo();
        wifiManager.startScan();
        list = (ArrayList<ScanResult>) wifiManager.getScanResults();
        wifiNames = new ArrayList<>();
        if(list == null){
            blueTooth.showDialog();
        }else {
            for(int i=0; i<list.size(); i++){
                wifiName = list.get(i).SSID;
                String name = wifiName;
                wifiNames.add(name);
            }
            drop1.setAdapter(new NameAdapter(mcontext,wifiNames));
        }

        drop2.setAdapter(new WayAdapter());


        //密码显示隐藏
        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //如果选中，显示密码
                    password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

    }


}
