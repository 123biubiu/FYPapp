package com.lucky.mplayer.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.VideoView;

public class CustomVideoView extends VideoView {

	private int defaultWidth = 1920;
	private int defaultHeight = 1080;
	
	public CustomVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public CustomVideoView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CustomVideoView(Context context) {
		super(context);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width = getDefaultSize(defaultWidth, widthMeasureSpec);
		int height = getDefaultSize(defaultHeight, heightMeasureSpec);
//		Log.e("fangming", "width : " + width + " , height : " + height);
		setMeasuredDimension(width, height);
	}

	
}
