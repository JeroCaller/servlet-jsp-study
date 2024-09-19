package com.design_pattern;

/**
 * DTO의 값 불변성을 지키기 위해 생성자를 사용하면 
 * 초기화할 필드값이 많아질 때 서로 자료형이 겹치는 필드끼리 값을 뒤바꿔서 넣을 수 있다. 
 * 예를 들면 userName과 email 모두 String 자료형이라 DTO3(userName, email)이라고 해야 하는데 
 * DTO3(email, userName)이라고 해도 에러가 발생하지 않아 실수를 할 수 있다. 
 * 그래서 생성자 사용 대신 setter 메서드에서 값을 딱 한 번만 초기화하도록 고안해보았다. 
 * 이를 이용하면 값이 서로 뒤바뀐채 초기화되는 것을 방지함과 동시에 데이터의 불변성도 만족시킬 수 있을 것이다. 
 */
public class DTO3 {
	private String userName = null;
	private String email = null;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		if (this.userName != null) return;
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		if (this.email != null) return;
		this.email = email;
	}

	@Override
	public String toString() {
		return this.userName + " : " + this.email;
	}
	
}
