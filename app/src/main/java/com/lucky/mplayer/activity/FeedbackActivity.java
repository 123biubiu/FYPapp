package com.lucky.mplayer.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.mplayer.R;
import com.lucky.mplayer.model.FeedBacklVO;
import com.lucky.mplayer.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class FeedbackActivity extends BaseActivity {

    @BindView(R.id.edt)
    EditText edt;
    @BindView(R.id.login_btn)
    TextView loginBtn;
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
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        rightText.setVisibility(View.INVISIBLE);
        title.setText("feedback");
    }

    @OnClick(R.id.login_btn)
    public void onViewClicked() {
        showLoading();
        FeedBacklVO mUser = new FeedBacklVO();
        mUser.setName(edt.getText().toString());
        mUser.save(new SaveListener<String>() {

            @Override
            public void done(String paramT, BmobException e) {
                hideLoading();
                edt.setText("");
                ToastUtil.showToast(FeedbackActivity.this, "send feedback success!");
            }
        });


    }

    @OnClick(R.id.left_btn)
    public void onViewClicked1() {
        finish();
    }

}
