package com.lucky.mplayer.activity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lucky.mplayer.R;
import com.lucky.mplayer.model.User;
import com.lucky.mplayer.utils.ToastUtil;
import com.sjy.pickphotos.pickphotos.PhotoPicker;
import com.sjy.pickphotos.pickphotos.listeners.OnResultListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends BaseActivity {


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
    @BindView(R.id.radioButton1)
    RadioButton radioButton1;
    @BindView(R.id.radioButton2)
    RadioButton radioButton2;
    @BindView(R.id.radioButton3)
    RadioButton radioButton3;
    @BindView(R.id.radioGroup)
    RadioGroup radioGroup;
    @BindView(R.id.spinner)
    Spinner spinner;

    int type;
    @BindView(R.id.card)
    ImageView card;
    String fileurl;
    @BindView(R.id.shengao)
    EditText shengao;
    @BindView(R.id.tizhong)
    EditText tizhong;
    @BindView(R.id.xuexing)
    EditText xuexing;
    @BindView(R.id.tizhi)
    TextView tizhi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initView();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioButton1.getId() == radioGroup.getCheckedRadioButtonId()) {
                    type = 0;
                } else if (radioButton2.getId() == radioGroup.getCheckedRadioButtonId()) {
                    type = 1;
                } else {
                    type = 2;
                }
            }
        });
    }

    private void initView() {
        title.setText("registration");
        rightText.setVisibility(View.INVISIBLE);
        int a = 1;
    }


    private void userReg() {
        final String usertel = userTel.getText().toString();
        final String userNames = userName.getText().toString();
        final String userPasss = userPass.getText().toString();
        final String userPasss1 = userPass1.getText().toString();

        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);

        if (TextUtils.isEmpty(usertel)) {
            ToastUtil.showToast(this, "enter your id");
        } else if (TextUtils.isEmpty(usertel)) {
            ToastUtil.showToast(this, "enter your name");
        } else if (TextUtils.isEmpty(userPasss)) {
            ToastUtil.showToast(this, "enter your password");
        } else if (TextUtils.isEmpty(userPasss1)) {
            ToastUtil.showToast(this, "try again your password");
        }
//        else if (TextUtils.isEmpty(fileurl)) {
//            ToastUtil.showToast(this, "请上传头像");
//        }
        else if (!userPasss.equals(userPasss1)) {
            ToastUtil.showToast(this, "the passwords are not the same");
        } else {
            showLoading();
            BmobQuery<User> query = new BmobQuery<User>();
            query.addWhereEqualTo("userName", userNames);
            query.findObjects(new FindListener<User>() {

                @Override
                public void done(List<User> paramList, BmobException paramBmobException) {
                    if (paramList != null && paramList.size() > 0) {
                        hideLoading();
                        ToastUtil.showToast(RegisterActivity.this, "your id is exist, please enter it straightly");
                    } else {
                        User mUser = new User();
                        mUser.setUserName(userNames);
                        mUser.setUserTel(usertel);
                        mUser.setUserPass(userPasss1);
                        mUser.setUserType(String.valueOf(type));
//                        mUser.setOwner(spinner.getSelectedItem().toString());
                        mUser.save(new SaveListener<String>() {

                            @Override
                            public void done(String paramT, BmobException e) {
                                hideLoading();
                                if (e == null) {
                                    ToastUtil.showToast(RegisterActivity.this, "register success!");
                                    finish();
                                } else {
                                    ToastUtil.showToast(RegisterActivity.this, "register fail!");
                                }

                            }
                        });
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

    @OnClick(R.id.card)
    public void onViewClicked() {
        PhotoPicker.Album(RegisterActivity.this)
                .setMultiChooseSize(1)
                .setIsCompress(true)
                .setIsCrop(false)
                .setOnResultListener(new OnResultListener() {

                    @Override
                    public void onSucess(ArrayList<String> imagePathList) {
                        if (imagePathList != null && imagePathList.size() > 0) {

                                fileurl = imagePathList.get(0);
                                Glide.with(RegisterActivity.this)
                                        .load(fileurl).into(card);


                        }

                    }

                    @Override
                    public void onCancel() {

                    }
                })
                .start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data!=null){
            tizhi.setText(data.getStringExtra("data"));
        }
    }

    @OnClick(R.id.tizhi)
    public void onViewClicked1() {
//        Intent intent=new Intent(RegisterActivity.this,AttentionListActivity.class);
//        startActivityForResult(intent,100);
    }
}
