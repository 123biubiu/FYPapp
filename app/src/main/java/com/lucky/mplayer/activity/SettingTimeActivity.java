package com.lucky.mplayer.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.lucky.mplayer.MyApplication;
import com.lucky.mplayer.R;
import com.lucky.mplayer.model.User;
import com.lucky.mplayer.utils.ToastUtil;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
public class SettingTimeActivity extends BaseActivity {
    @BindView(R.id.setTimeComfirm_btn)
    TextView setTimeBtn;
    @BindView(R.id.title)
    TextView title;
//    @BindView(R.id.location_select_spinner)
//    Spinner current_location_spinner;
    @BindView(R.id.start_time_spinner)
    Spinner start_time_spinner;
    @BindView(R.id.end_time_spinner)
    Spinner end_time_spinner;
//    String selectedLocation;
    String selectedStartTime;
    String selectedEndTime;
    int it;
    int et;
    //单例化,不可用
//    private static SettingTimeActivity instance = new SettingTimeActivity();
//    private  SettingTimeActivity(){
//
//    }
//    public  static SettingTimeActivity getInstance(){
//        return instance;
//    }

//    String[] locations = {"select your current location","west_door","FB","CB","global center","Basement_Parking"};
//    String[] start_Time = {"when will you start using the lounge","8:00 am","9:00 am","10:00 am","11:00 am","12:00 am","1:00 pm","2:00 pm","3:00 pm","4:00 pm","5:00 pm","6:00 pm","7:00 pm","8:00 pm","9:00 pm","10:00 pm","11:00 pm"};
//    String[] end_Time = {"when will you leave the lounge","9:00 am","10:00 am","11:00 am","12:00 am","1:00 pm","2:00 pm","3:00 pm","4:00 pm","5:00 pm","6:00 pm","7:00 pm","8:00 pm","9:00 pm","10:00 pm","11:00 pm","12:00 pm"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_personalinformation_setting);
        ButterKnife.bind(this);
        title.setText("infor");
//        current_location_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    //取值
//                    selectedLocation = (String)current_location_spinner.getSelectedItem();
//                    //测试是否成功取值
////                Toast.makeText(SettingTimeActivity.this, selectedLocation,Toast.LENGTH_SHORT)
////                        .show();
//            }
//
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
        start_time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //取值
                selectedStartTime = (String)start_time_spinner.getSelectedItem();
                if(!selectedStartTime.equals("WHEN WILL YOU START USE THE LOUNGE")){
                    ArrayList<String>  stime = new ArrayList<String>(Arrays.asList(selectedStartTime.split(":")));
//                //测试是否成功取值
                    it = Integer.parseInt(stime.get(0));
//                    Toast.makeText(SettingTimeActivity.this, String.valueOf(it),Toast.LENGTH_SHORT)
//                            .show();
                }

            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        end_time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //取值
                selectedEndTime = (String)end_time_spinner.getSelectedItem();
                if(!selectedEndTime.equals("WHEN WILL YOU LEAVE THE LOUNGE")){
                    ArrayList<String>  etime = new ArrayList<String>(Arrays.asList(selectedEndTime.split(":")));
                     et = Integer.parseInt(etime.get(0));
//                    Toast.makeText(SettingTimeActivity.this, String.valueOf(et),Toast.LENGTH_SHORT)
//                            .show();
                }
                //测试是否成功取值
//                Toast.makeText(SettingTimeActivity.this, selectedEndTime,Toast.LENGTH_SHORT)
//                        .show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    @OnClick({R.id.left_btn, R.id.setTimeComfirm_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                break;
            //写在这里，记录目前所在地点，开启时间，结束时间
            //然后将这个数据传给下一个类
            case R.id.setTimeComfirm_btn:

                if( it < et) {
                    Intent intent = new Intent(SettingTimeActivity.this, SuperintendentMainActivity.class);
//                    intent.putExtra("location", selectedLocation);
                    intent.putExtra("start_time", it);

                    intent.putExtra("end_time", et);
                    startActivity(intent);
                    break;
                }
                else{
                    Toast.makeText(SettingTimeActivity.this, "invalid selection",Toast.LENGTH_SHORT)
                            .show();
                }
        }
    }


}
