package com.lucky.mplayer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.mplayer.MyApplication;
import com.lucky.mplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInfoActivity extends AppCompatActivity {

    @BindView(R.id.left_btn)
    TextView leftBtn;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.right_text)
    TextView rightText;
    @BindView(R.id.right1_text)
    TextView right1Text;
    @BindView(R.id.top_navigate)
    RelativeLayout topNavigate;
    @BindView(R.id.info_lyout)
    LinearLayout infoLyout;
    @BindView(R.id.pas_lyout)
    LinearLayout pasLyout;
    @BindView(R.id.exit_lyout)
    LinearLayout exitLyout;
    @BindView(R.id.voice_lyout)
    LinearLayout voiceLyout;
    @BindView(R.id.back_lyout)
    LinearLayout backLyout;
    @BindView(R.id.about_lyout)
    LinearLayout aboutLyout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        title.setText("personal center");
        rightText.setVisibility(View.INVISIBLE);
        int a = 1;
    }

    @OnClick({R.id.left_btn, R.id.info_lyout, R.id.pas_lyout, R.id.exit_lyout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.info_lyout:
                Intent intent4 = new Intent(UserInfoActivity.this, EditInfoActivity.class);
                startActivity(intent4);
                break;
            case R.id.pas_lyout:
                Intent intent5 = new Intent(UserInfoActivity.this, EditPasActivity.class);
                startActivity(intent5);
                break;
            case R.id.exit_lyout:
                MyApplication.user = null;
                Intent intent6 = new Intent(UserInfoActivity.this, LoginActivity.class);
                intent6.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent6);
                finish();
                break;
        }
    }


}
