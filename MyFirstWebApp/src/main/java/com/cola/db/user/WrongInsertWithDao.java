package com.cola.db.user;

import com.cola.db.lib.DBDao;

public class WrongInsertWithDao {

	public static void main(String[] args) {
		DBDao dao = new DBDao();
		
		System.out.println("새 데이터 삽입 전");
		System.out.println();  // 개행
		dao.getAllRecords();
		
		System.out.println("새 데이터 삽입 후");
		System.out.println();
		
		// 사용자 이름과 권한명이 실수로 뒤바뀐채 삽입하려고 하고 있다. 그런데 에러 없이 수행되어버리고 만다...
		dao.insertOneRecord(3, "USER", "javas2222", " javas456");
		dao.getAllRecords();
		
		dao.close();
	}

}
