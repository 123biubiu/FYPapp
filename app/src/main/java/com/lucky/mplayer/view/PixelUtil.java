package com.lucky.mplayer.view;

import android.content.Context;

public class PixelUtil {

	private static Context mContext;
	
	public static void initContext(Context context){
		mContext = context;
	}
	
	public static int dp2px(float value){
		final float scale = mContext.getResources().getDisplayMetrics().densityDpi;
		return (int)(value * (scale/160) + 0.5f);
	}
	
	public static int dp2px(float value, Context context){
		final float scale = context.getResources().getDisplayMetrics().densityDpi;
		return (int)(value * (scale/160) + 0.5f);
	}
	
	public static int px2dp(float value){
		final float scale = mContext.getResources().getDisplayMetrics().densityDpi;
		return (int)((value * 160) /scale + 0.5f);
	}
	
	public static int px2dp(float value, Context context){
		final float scale = context.getResources().getDisplayMetrics().densityDpi;
		return (int)((value * 160) /scale + 0.5f);
	}
	
}
