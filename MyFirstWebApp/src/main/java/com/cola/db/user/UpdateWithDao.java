package com.cola.db.user;

import com.cola.db.lib.DBDao;

public class UpdateWithDao {

	public static void main(String[] args) {
		DBDao dao = new DBDao();
		
		System.out.println("수정 전");
		System.out.println(); // 개행
		dao.getAllRecords();
		System.out.println();
		
		dao.updateOneRecord(3, "naithon789", "naithon1111");
		System.out.println("수정 후");
		System.out.println();
		dao.getAllRecords();
		System.out.println();
		
		dao.close();
	}

}
