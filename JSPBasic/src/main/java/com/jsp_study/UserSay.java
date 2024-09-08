package com.jsp_study;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserSay {
	private String userName = null;
	private String say = null;
	private String onlyOne = null;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getSay() {
		return say;
	}
	
	public void setSay(String say) {
		this.say = say;
	}
	
	public String getCurrentDateTime() {
		Calendar currentDateTime = Calendar.getInstance();
		SimpleDateFormat dFormat = new SimpleDateFormat("YYYY년 MM월 dd일 HH:mm:ss");
		return dFormat.format(currentDateTime.getTime());
	}
	
	/* 새로 추가한 코드 */
	public String getOnlyOne() {
		return onlyOne;
	}
	
	public void setOnlyOne(String say) {
		this.onlyOne = say;
	}
	
}
