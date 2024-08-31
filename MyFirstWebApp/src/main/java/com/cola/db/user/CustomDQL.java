package com.cola.db.user;

import java.util.ArrayList;
import java.util.List;

import com.cola.db.lib.DBDaoVo;
import com.cola.db.lib.DBVo;

public class CustomDQL {

	public static void main(String[] args) {
		// TODO 전체 레코드로부터 출력하고자 하는 데이터만 골라 출력할 수 있다.
		
		DBDaoVo daoVo = new DBDaoVo();
		
		List<DBVo> allRecords = daoVo.getAllRecords();
		
		System.out.println("site_user 테이블 내 전체 건수: " + allRecords.size());
		System.out.println(); // 개행.
		
		// role이 USER인 사람들의 데이터만 조회.
		List<DBVo> users = new ArrayList<DBVo>();
		for (DBVo vo : allRecords) {
			if (vo.getRole().equals("USER")) {
				users.add(vo);
			}
		}
		
		System.out.println("USER 권한을 가지는 사용자들의 수: " + users.size());
		System.out.println();
		
		System.out.println("=== 사용자 목록 ===");
		System.out.println("unique_id \t user_name \t sign_date");
		System.out.println("-------------------------------------------");
		users.forEach((vo) -> {
			System.out.println(
					vo.getUniqueId() + " \t\t " + 
					vo.getUserName() + " \t " + 
					vo.getSignDate()
			);
		});
		
	}

}
