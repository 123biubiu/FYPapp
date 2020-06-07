package com.lucky.mplayer;

import android.support.multidex.MultiDexApplication;

import com.baidu.mapapi.SDKInitializer;
import com.lucky.mplayer.model.User;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;

/**
 * Created by lipeng on 2018/3/10.
 */

public class MyApplication extends MultiDexApplication {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;
    public static User user;

    public static List<User> users = new ArrayList<>();
    @Override
    public void onCreate() {
        super.onCreate();
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        // 默认本地个性化地图初始化方法
        SDKInitializer.initialize(this);

        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
//        SDKInitializer.setCoordType(CoordType.BD09LL);
        Bmob.initialize(this, "b7fdebbe431f1c1f36851a33de7d61be");
    }


}

