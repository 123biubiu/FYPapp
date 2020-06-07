package com.lucky.mplayer.utils;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lifei on 17/4/1.
 */

public class TimeUtils {
    private int allTime =30;
    private int time;

    private Timer timer;

    private TextView btnSure;
    private  NextListener mNextListener;

    public NextListener getmNextListener() {
        return mNextListener;
    }

    public void setmNextListener(NextListener mNextListener) {
        this.mNextListener = mNextListener;
    }

   public interface  NextListener{
         void next();
    }



    public TimeUtils(TextView btnSure) {
        super();
        this.btnSure = btnSure;

    }





    public void RunTimer(){
        if(timer!=null) {
            timer.cancel();
        }
        time = allTime;
        timer=new Timer();
        TimerTask task=new TimerTask() {

            @Override
            public void run(){
                time--;
                Message msg=handler.obtainMessage();
                msg.what=1;
                handler.sendMessage(msg);

            }
        };


        timer.schedule(task, 100, 1000);
    }


    private Handler handler =new Handler(){
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:

                    if(time>0){
//                        btnSure.setEnabled(false);
                        btnSure.setText("答题还剩"+time+"秒");
//                        btnSure.setTextSize(14);
                    }else{

                        timer.cancel();
                        btnSure.setText("进入下一题");
                        if(mNextListener!=null){
                            mNextListener.next();
                        }
//                        btnSure.setEnabled(true);
//                        btnSure.setTextSize(14);
                    }

                    break;


                default:
                    break;
            }

        };
    };



}