package com.design_pattern;

/**
 * DTO 예제 2.
 * setter 메서드가 없고, 대신 생성자를 통해 초기화를 하게 하면, 
 * 맨 처음 생성자를 통해 딱 한 번만 필드들을 초기화하면 그 이후 데이터 전송 중간에 
 * 값을 변경할 수 없게 만들 수 있다. 즉, 값의 불변성을 지킬 수 있어 변조를 방지할 수 있다. 
 */
public class DTO2 {
	private String userName = null;
	private String email = null;
	
	public DTO2(String userName, String email) {
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return this.userName + " : " + this.email;
	}
	
}
