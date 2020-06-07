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
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lucky.mplayer.MyApplication;
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


public class LoginActivity extends BaseActivity {


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
    @BindView(R.id.register_btn)
    TextView registerBtn;
    @BindView(R.id.login_btn)
    TextView loginBtn;
    @BindView(R.id.reset_pass_btn)
    TextView resetPassBtn;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        flag = getIntent().getIntExtra("flag", 0);
        initView();
        takePhoto(LoginActivity.this, TAKE_PHOTO_REQUEST_CODE);
        int a = 1;
    }


    public void initView() {
        title.setText("login");
        rightText.setVisibility(View.INVISIBLE);
    }

    private static final int TAKE_PHOTO_REQUEST_CODE = 1;

    public static String takePhoto(Context context, int requestCode) {
        String filePath = "";
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.CAMERA},
                    TAKE_PHOTO_REQUEST_CODE);
        }
        return filePath;
    }


    public void login() {
        final String name = userName.getText().toString();
        final String pass = userPass.getText().toString();
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showToast(this, "enter your id");
        }
//        else if (name.length() != 11) {
//            ToastUtil.showToast(this, "账号位数不对");
//        }
        else if (TextUtils.isEmpty(pass)) {
            ToastUtil.showToast(this, "enter your password");
        } else {
            showLoading();
            BmobQuery<User> query = new BmobQuery<User>();
            query.addWhereEqualTo("userTel", name);
            query.addWhereEqualTo("userPass", pass);
            query.findObjects(new FindListener<User>() {

                @Override
                public void done(List<User> paramList, BmobException paramBmobException) {
                    hideLoading();
                    if (paramList != null && paramList.size() > 0) {
                        MyApplication.user = paramList.get(0);
                        hideLoading();
                        Intent intent = new Intent();
                        //jump to another activity
//                        intent.setClass(LoginActivity.this, SuperintendentMainActivity.class);
                        intent.setClass(LoginActivity.this, SettingTimeActivity.class);
                        startActivity(intent);
                        finish();
//                        showLoading();
//                        EMClient.getInstance().login(name, pass, new EMCallBack() {//回调
//                            @Override
//                            public void onSuccess() {
//
//                            }
//
//                            @Override
//                            public void onProgress(int progress, String status) {
//
//                            }
//
//                            @Override
//                            public void onError(int code, String message) {
//                                hideLoading();
//                                Intent intent = new Intent();
//                                intent.setClass(LoginActivity.this, MainActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        });

                    } else {
                        ToastUtil.showToast(LoginActivity.this, "invalid input");
                    }
                }
            });
        }
    }


    @OnClick({R.id.left_btn, R.id.register_btn, R.id.login_btn, R.id.reset_pass_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left_btn:
                break;
            case R.id.register_btn:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.login_btn:
                login();
                break;
            case R.id.reset_pass_btn:
                Intent intent1 = new Intent(LoginActivity.this, ResetPasswordActivity.class);
                startActivity(intent1);
                break;
        }
    }

    @OnClick(R.id.left_btn)
    public void onViewClicked() {
        finish();
    }
}
