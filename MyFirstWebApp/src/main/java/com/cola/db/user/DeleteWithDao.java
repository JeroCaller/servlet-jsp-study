package com.cola.db.user;

import com.cola.db.lib.DBDao;

public class DeleteWithDao {

	public static void main(String[] args) {
		DBDao dao = new DBDao();
		
		System.out.println("삭제 전\n");
		dao.getAllRecords();
		System.out.println();
		
		System.out.println("삭제 후\n");
		dao.deleteOneRecord(3);
		dao.getAllRecords();
		
		dao.close();
	}

}
