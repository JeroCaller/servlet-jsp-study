package com.cola.db.lib;

import java.sql.Date;

public class DBVo {
	private int uniqueId = 0;
	private String userName = null;
	private String password = null;
	private String role = null;
	private Date signDate = null;
	
	public int getUniqueId() {
		return uniqueId;
	}
	
	public void setUniqueId(int uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		switch (role) {
			case USER:
				this.role = "USER";
				break;
			case ADMIN:
				this.role = "ADMIN";
				break;
		}
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Date getSignDate() {
		return signDate;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}
	
}
