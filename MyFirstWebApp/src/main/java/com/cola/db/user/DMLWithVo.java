package com.cola.db.user;

import com.cola.db.lib.DBDaoVo;
import com.cola.db.lib.DBVo;
import com.cola.db.lib.UserRole;

public class DMLWithVo {

	public static void main(String[] args) {
		DBDaoVo daoVo = new DBDaoVo();
		
		// 잘못 입력된 데이터 삭제
		daoVo.deleteOneRecord(3);
		
		System.out.println("기존 테이블 데이터");
		daoVo.printAllRecords();
		System.out.println();
		
		System.out.println("데이터 한 건 삽입 후\n");
		DBVo vo = new DBVo();
		vo.setUniqueId(3);
		vo.setUserName("javas456");
		vo.setPassword("javas2222");
		vo.setRole(UserRole.USER);
		daoVo.insertOneRecord(vo);
		daoVo.printAllRecords();
		System.out.println();
		
		System.out.println("데이터 한 건 수정 후\n");
		DBVo voUpdate = new DBVo();
		voUpdate.setUniqueId(3);
		voUpdate.setUserName("naithon789");
		voUpdate.setPassword("naithon3333");
		daoVo.updateOneRecord(voUpdate);
		daoVo.printAllRecords();
		
		daoVo.close();
	}

}
