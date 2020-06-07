package com.lucky.mplayer.activity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.mplayer.MyApplication;
import com.lucky.mplayer.R;
import com.lucky.mplayer.model.User;
import com.lucky.mplayer.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class EditPasActivity extends BaseActivity {


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
    @BindView(R.id.user_name)
    EditText userName;
    @BindView(R.id.user_pass)
    EditText userPass;
    @BindView(R.id.user_pass1)
    EditText userPass1;
    @BindView(R.id.user_nl)
    EditText userNl;
    @BindView(R.id.user_xb)
    EditText userXb;
    @BindView(R.id.user_je)
    EditText userJe;
    @BindView(R.id.user_tel)
    EditText userTel;
    @BindView(R.id.register_btn)
    TextView registerBtn;
    @BindView(R.id.user_old_pass)
    EditText userOldPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_pas);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initData() {
        userTel.setText(MyApplication.user.getUserTel());
        userTel.setEnabled(false);
        userName.setText(MyApplication.user.getUserName());
    }

    private void initView() {
        title.setText("change your password");
        rightText.setVisibility(View.INVISIBLE);
    }

//registration system about change password
    private void userReg() {
        final String usertel = userTel.getText().toString();
        final String userNames = userName.getText().toString();
        final String userOldPasss1 = userOldPass.getText().toString();
        final String userPasss = userPass.getText().toString();
        final String userPasss1 = userPass1.getText().toString();
        if (TextUtils.isEmpty(userOldPasss1)) {
            ToastUtil.showToast(this, "enter original password");
        } else if (!userOldPasss1.equals(MyApplication.user.getUserPass())) {
            ToastUtil.showToast(this, "enter invalid");
        } else if (TextUtils.isEmpty(userPasss)) {
            ToastUtil.showToast(this, "enter your password");
        } else if (TextUtils.isEmpty(userPasss1)) {
            ToastUtil.showToast(this, "try again");
        } else if (!userPasss.equals(userPasss1)) {
            ToastUtil.showToast(this, "the passwords are not the same");
        } else {
            showLoading();
            final User mUser = MyApplication.user;
            mUser.setUserName(userNames);
            mUser.setUserTel(usertel);
            mUser.setUserPass(userPasss1);
            mUser.update(mUser.getObjectId(), new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    hideLoading();
                    if (e == null) {
                        MyApplication.user = mUser;
                        ToastUtil.showToast(EditPasActivity.this, "update success!");
                        finish();
                    } else {
                        ToastUtil.showToast(EditPasActivity.this, "update fail!");
                    }
                }
            });

        }
    }

    @OnClick({R.id.left_btn, R.id.register_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.register_btn:
                userReg();
                break;
        }
    }
}
