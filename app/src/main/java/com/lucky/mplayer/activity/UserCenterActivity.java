package com.lucky.mplayer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lucky.mplayer.MyApplication;
import com.lucky.mplayer.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserCenterActivity extends BaseActivity {

    @BindView(R.id.headimg)
    ImageView headimg;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.left_btn)
    ImageView leftBtn;
    @BindView(R.id.weibo_count)
    TextView weiboCount;
    @BindView(R.id.weibo_lyout)
    LinearLayout weiboLyout;
    @BindView(R.id.guanzhu_count)
    TextView guanzhuCount;
    @BindView(R.id.guanzhu_lyout)
    LinearLayout guanzhuLyout;
    @BindView(R.id.fensi_count)
    TextView fensiCount;
    @BindView(R.id.fensi_lyout)
    LinearLayout fensiLyout;
    @BindView(R.id.shoucang_count)
    TextView shoucangCount;
    @BindView(R.id.shoucang_lyout)
    LinearLayout shoucangLyout;
    @BindView(R.id.info_lyout)
    LinearLayout infoLyout;
    @BindView(R.id.voice_lyout)
    LinearLayout voiceLyout;
    @BindView(R.id.back_lyout)
    LinearLayout backLyout;
    @BindView(R.id.about_lyout)
    LinearLayout aboutLyout;
    @BindView(R.id.pas_lyout)
    LinearLayout pasLyout;
    @BindView(R.id.exit_lyout)
    LinearLayout exitLyout;
    @BindView(R.id.msg_lyout)
    LinearLayout msgLyout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_center);
        ButterKnife.bind(this);
        initData();
        int a = 1;
    }


    private void initData() {
//        if (!TextUtils.isEmpty(MyApplication.user.getUserCard())) {
//            Glide.with(UserCenterActivity.this)
//                    .load(MyApplication.user.getUserCard()).into(headimg);
//        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        userName.setText(MyApplication.user.getUserName());
    }

    @OnClick({R.id.headimg, R.id.left_btn, R.id.weibo_lyout, R.id.guanzhu_lyout, R.id.fensi_lyout, R.id.shoucang_lyout, R.id.info_lyout, R.id.back_lyout, R.id.about_lyout, R.id.pas_lyout, R.id.exit_lyout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.headimg:
                updateHead();
                break;
            case R.id.left_btn:
                finish();
                break;
            case R.id.weibo_lyout:
//                Intent intent10 = new Intent(UserCenterActivity.this, MyHelpListActivity.class);
//                intent10.putExtra("userTel", MyApplication.user.getUserTel());
//                startActivity(intent10);
                break;
            case R.id.guanzhu_lyout:
//                Intent intent11 = new Intent(UserCenterActivity.this, AttentionListActivity.class);
//                intent11.putExtra("userTel", MyApplication.user.getUserTel());
//                startActivity(intent11);
                break;
            case R.id.fensi_lyout:
//                Intent intent12 = new Intent(UserCenterActivity.this, MyAttentionListActivity.class);
//                intent12.putExtra("userTel", MyApplication.user.getUserTel());
//                startActivity(intent12);
            break;
            case R.id.shoucang_lyout:
//                Intent intent13 = new Intent(UserCenterActivity.this, ShouCangListActivity.class);
//                intent13.putExtra("userTel", MyApplication.user.getUserTel());
//                startActivity(intent13);
                break;
            case R.id.info_lyout:
                Intent intent5 = new Intent(UserCenterActivity.this, EditInfoActivity.class);
                startActivity(intent5);
                break;
            case R.id.back_lyout:
                Intent intent6 = new Intent(UserCenterActivity.this, FeedbackActivity.class);
                startActivity(intent6);
                break;
            case R.id.about_lyout:
                Intent intent7 = new Intent(UserCenterActivity.this, AboutActivity.class);
                startActivity(intent7);
                break;
            case R.id.pas_lyout:
                Intent intent8 = new Intent(UserCenterActivity.this, EditPasActivity.class);
                startActivity(intent8);
                break;
            case R.id.exit_lyout:
                hideLoading();
                MyApplication.user = null;
                Intent intent9 = new Intent(UserCenterActivity.this, LoginActivity.class);
                intent9.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent9.putExtra("flag", 1);
                startActivity(intent9);
                finish();
//                showLoading();
//                EMClient.getInstance().logout(true, new EMCallBack() {
//
//                    @Override
//                    public void onSuccess() {
//
//                    }
//
//                    @Override
//                    public void onProgress(int progress, String status) {
//
//                    }
//
//                    @Override
//                    public void onError(int code, String message) {
//                        hideLoading();
//                    }
//                });


                break;
        }
    }

    public void updateHead() {

//        PhotoPicker.Album(UserCenterActivity.this)
//                .setMultiChooseSize(1)
//                .setIsCompress(true)
//                .setIsCrop(false)
//                .setOnResultListener(new OnResultListener() {
//
//                    @Override
//                    public void onSucess(ArrayList<String> imagePathList) {
//                        if (imagePathList != null && imagePathList.size() > 0) {
//
//                            String fileurl = imagePathList.get(0);
//                            showLoading();
//                            final User mUser = MyApplication.user;
//                            mUser.setUserCard(fileurl);
//                            mUser.update(mUser.getObjectId(), new UpdateListener() {
//                                @Override
//                                public void done(BmobException e) {
//                                    hideLoading();
//                                    if (e == null) {
//                                        MyApplication.user = mUser;
//                                        Glide.with(UserCenterActivity.this)
//                                                .load(MyApplication.user.getUserCard()).into(headimg);
//                                        ToastUtil.showToast(UserCenterActivity.this, "上传成功");
//                                    } else {
//                                        ToastUtil.showToast(UserCenterActivity.this, "上传失败");
//                                    }
//                                }
//                            });
//
//
//                        }
//
//                    }
//
//                    @Override
//                    public void onCancel() {
//
//                    }
//                })
//                .start();
    }

    @OnClick(R.id.msg_lyout)
    public void onViewClicked() {
//        Intent intent13 = new Intent(UserCenterActivity.this, MsgListActivity.class);
//        intent13.putExtra("userTel", MyApplication.user.getUserTel());
//        startActivity(intent13);
    }
}
