package com.lucky.mplayer.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.mplayer.R;
import com.lucky.mplayer.model.User;
import com.lucky.mplayer.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.UpdateListener;


public class ResetPasswordActivity extends BaseActivity {


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
    @BindView(R.id.user_oldpass)
    EditText userOldpass;
    @BindView(R.id.user_newpass)
    EditText userNewpass;
    @BindView(R.id.user_newpass2)
    EditText userNewpass2;
    @BindView(R.id.confirm_btn)
    TextView confirmBtn;
    private String userNameStr;
    private String oldPassStr;
    private String newPass1Str;
    private String newPass2Str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetpassword);
        ButterKnife.bind(this);
        initView();
        int a = 1;
    }

    private void initView() {
        title.setText("edit your password");
        rightText.setVisibility(View.INVISIBLE);
    }


    private void resetPassword() {
        userNameStr = userName.getText().toString().trim();
        oldPassStr = userOldpass.getText().toString().trim();
        newPass1Str = userNewpass.getText().toString().trim();
        newPass2Str = userNewpass2.getText().toString().trim();
        if (TextUtils.isEmpty(userNameStr)) {
            ToastUtil.showToast(this, "enter your name");
        } else if (TextUtils.isEmpty(oldPassStr)) {
            ToastUtil.showToast(this, "enter the previous password");
        } else if (TextUtils.isEmpty(newPass1Str)) {
            ToastUtil.showToast(this, "null input is not allowed ");
        } else if (TextUtils.isEmpty(newPass2Str)) {
            ToastUtil.showToast(this, "null input is not allowed");
        } else {
            if (newPass1Str.equals(newPass2Str)) {
//                List<User> users = mUserDao.queryBuilder()
//                        .where(UserDao.Properties.UserTel.eq(userNameStr))
//                        .where(UserDao.Properties.Commentary.eq(oldPassStr))
//                        .list();
//                if (users != null && users.size() > 0) {
//                   User user=users.get(0);
//                    user.setUserPass(newPass1Str);
//                    mUserDao.update(user);
//                    ToastUtil.showToast(this, "成功");
//                    finish();
//
//                } else {
//                    ToastUtil.showToast(this, "用户名或密保问题答案错误");
//                }
//
                showLoading();
                BmobQuery<User> query = new BmobQuery<User>();
                query.addWhereEqualTo("userTel", userNameStr);
                query.addWhereEqualTo("userPass", oldPassStr);
                query.findObjects(new FindListener<User>() {

                    @Override
                    public void done(List<User> paramList, BmobException paramBmobException) {
                        hideLoading();
                        if (paramList != null && paramList.size() > 0) {

                            User u = paramList.get(0);
                            u.setUserPass(newPass1Str);
                            u.update(u.getObjectId(), new UpdateListener() {

                                @Override
                                public void done(BmobException e) {
                                    if (e == null) {
                                        ToastUtil.showToast(ResetPasswordActivity.this, "edit valid!");
                                        finish();
                                    } else {
                                        ToastUtil.showToast(ResetPasswordActivity.this, "edit invalid!");
                                    }
                                }

                            });

                        } else {
                            ToastUtil.showToast(ResetPasswordActivity.this, "invalid input");
                        }
                    }
                });
            } else {
                ToastUtil.showToast(this, "the passwords are not the same, try again");
            }

        }
    }

    @OnClick({R.id.left_btn, R.id.confirm_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                finish();
                break;
            case R.id.confirm_btn:
                resetPassword();
                break;
        }
    }
}
