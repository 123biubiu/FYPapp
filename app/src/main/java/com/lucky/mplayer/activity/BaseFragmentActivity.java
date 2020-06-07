package com.lucky.mplayer.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.android.tu.loadingdialog.LoadingDailog;


/**
 * Created by Administrator on 2018/3/25.
 */

public class BaseFragmentActivity extends FragmentActivity {
    LoadingDailog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoadingDailog.Builder loadBuilder=new LoadingDailog.Builder(this)
                .setMessage("uploading...")
                .setCancelable(true)
                .setCancelOutside(true);
        dialog=loadBuilder.create();
    }

    protected void showLoading(){
        dialog.show();
    }
    protected void hideLoading(){
        dialog.dismiss();
    }



}
