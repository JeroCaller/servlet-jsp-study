package com.cola.db.user;

import com.cola.db.lib.DBDao;

public class InsertWithDao {

	public static void main(String[] args) {
		DBDao dao = new DBDao();
		
		System.out.println("새 데이터 삽입 전");
		System.out.println();  // 개행
		dao.getAllRecords();
		
		System.out.println("새 데이터 삽입 후");
		System.out.println();
		dao.insertOneRecord(3, "javas456", "javas2222", "USER");
		dao.getAllRecords();
		
		dao.close();
	}

}
