package com.cola.db.user;

import com.cola.db.lib.DBDao;

public class DQLWithDao {

	public static void main(String[] args) {
		DBDao dao = new DBDao();
		
		dao.getAllRecords();
		dao.close();
	}

}
