package com.lucky.mplayer.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.mplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
//readme class
public class AboutActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        title.setText("infor");
        rightText.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.left_btn)
    public void onViewClicked() {
        finish();
    }
}
