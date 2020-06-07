package com.lucky.mplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.mplayer.MyApplication;
import com.lucky.mplayer.R;
import com.zyascend.MyAlarm.activity.MainAlarmActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends Activity {


    @BindView(R.id.left_btn)
    ImageView leftBtn;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.right_text)
    TextView rightText;
    @BindView(R.id.right1_text)
    TextView right1Text;
    @BindView(R.id.top_navigate)
    RelativeLayout topNavigate;
    @BindView(R.id.txt1)
    TextView txt1;
    @BindView(R.id.txt2)
    TextView txt2;
    @BindView(R.id.txt3)
    TextView txt3;
    @BindView(R.id.txt4)
    TextView txt4;
    @BindView(R.id.txt5)
    TextView txt5;
    @BindView(R.id.txt6)
    TextView txt6;
    @BindView(R.id.txtusername)
    TextView txtusername;
    @BindView(R.id.lyout1)
    LinearLayout lyout1;
    @BindView(R.id.lyout2)
    LinearLayout lyout2;
    @BindView(R.id.lyout3)
    LinearLayout lyout3;
    @BindView(R.id.txt)
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        txtusername.setText(MyApplication.user.getUserName());
        rightText.setText("");
        if("0".equals(MyApplication.user.getUserType())){
            lyout1.setVisibility(View.GONE);
        }else {
            lyout2.setVisibility(View.GONE);
            lyout3.setVisibility(View.GONE);
        }
        int a = 1;
    }


    public void initView() {
        title.setText(getResources().getString(R.string.app_name));
    }


    @OnClick({R.id.left_btn,R.id.txt1, R.id.txt2, R.id.txt3, R.id.txt4, R.id.txt5, R.id.txt6, R.id.right_text})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.txt1:
//                Intent intent4 = new Intent(MainActivity.this, HelpListManagerActivity.class);
//                startActivity(intent4);
                break;
            case R.id.txt2:
//                Intent intent = new Intent(MainActivity.this, HelpListActivity.class);
//                startActivity(intent);
                break;
            case R.id.txt3:
//                Intent intent1 = new Intent(MainActivity.this, AllHelpListManagerActivity.class);
//                startActivity(intent1);
                break;
            case R.id.txt4:
//                Intent intent5 = new Intent(MainActivity.this, MyHelpListManagerActivity.class);
//                startActivity(intent5);
                break;
            case R.id.txt5:
//                Intent intent2 = new Intent(MainActivity.this, HelpListActivity.class);
//                startActivity(intent2);
                break;
            case R.id.left_btn:
                Intent intent62 = new Intent(MainActivity.this, UserCenterActivity.class);
                startActivity(intent62);
                break;
        }
    }
}
