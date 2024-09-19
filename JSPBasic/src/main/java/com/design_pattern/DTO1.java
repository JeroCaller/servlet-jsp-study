package com.design_pattern;

/**
 * DTO 예제 1.
 * 각 필드마다 getter, setter 메서드를 정의할 수 있다. 
 * setter 메서드가 존재할 경우, 그 필드는 가변성을 띈다. 즉, 
 * 중간에 값이 바뀔 수 있다. 
 */
public class DTO1 {
	private String username = null;
	private String email = null;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
