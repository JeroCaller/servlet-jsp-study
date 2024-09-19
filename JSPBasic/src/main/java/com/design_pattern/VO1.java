package com.design_pattern;

import java.util.Objects;

public class VO1 {
	private String userName = null;
	
	public VO1(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return this.userName;
	}

	@Override
	/**
	 * java.util.Objects.hash() 메서드를 이용하면 굳이 해시 알고리즘을 고안, 구현하지 
	 * 않아도 클래스의 필드값만 전달하면 고유한 해시값을 반환하도록 할 수 있다. 
	 * 클래스 필드가 2개 이상인 경우 모든 필드들을 hash() 메서드의 인자로 넘길 수 있다. 
	 * 그러면 hash() 메서드 내부에서 주어진 필드값들을 토대로 고유한 해시값을 반환한다. 
	 */
	public int hashCode() {
		return Objects.hash(this.userName);
	}

	@Override
	/**
	 * 인자로 주어진 obj 객체가 이 객체(this)와 같은 경우 서로 같은 객체로 판별.
	 * 주어진 obj가 null이거나 애초에 VO1의 객체가 아닐 경우 서로 다른 객체로 판별. 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof VO1) || obj == null) return false;
		if (this == obj) return true;
		
		VO1 otherVo = (VO1)obj;
		return this.userName.equals(otherVo.getUserName());
	}
	
}
