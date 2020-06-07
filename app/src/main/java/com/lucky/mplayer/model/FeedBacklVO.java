package com.lucky.mplayer.model;

import cn.bmob.v3.BmobObject;

public class FeedBacklVO extends BmobObject {

	private String userTel;
	private String name;
	private String count;
	private String lastDate;

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getLastDate() {
		return lastDate;
	}

	public void setLastDate(String lastDate) {
		this.lastDate = lastDate;
	}
}
