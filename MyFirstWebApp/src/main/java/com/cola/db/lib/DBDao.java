package com.cola.db.lib;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBDao {
	private Connection conn = null;
	private PreparedStatement state = null;
	private ResultSet rs = null;
	private JDBCTool jtool = new JDBCTool();
	
	private final String ALL_DQL = "select * from site_user";
	private final String INSERT_SQL = "insert into site_user values(?, ?, ?, ?, ?)";
	private final String UPDATE_SQL = "update site_user set user_name = ?, password = ? where unique_id = ?";
	private final String DELETE_SQL = "delete site_user where unique_id = ?";
	
	public DBDao() {
		conn = jtool.getConnection();
	}
	
	public void getAllRecords() {
		try {
			state = conn.prepareStatement(ALL_DQL);
			rs = state.executeQuery();
			
			System.out.println("=== site_user table ===");
			System.out.println("unique_id \t user_name \t password \t role \t sign_date");
			System.out.println("-------------------------------------------------------------------");
			while(rs.next()) {
				System.out.printf("%d \t\t %s \t %s \t %s \t ", 
						rs.getInt("unique_id"),
						rs.getString("user_name"),
						rs.getString("password"),
						rs.getString("role")
				);
				System.out.println(rs.getDate("sign_date"));
			}
		} catch (SQLException e) {
			jtool.handleSQLException(e);
		}
	}
	
	public void insertOneRecord(int uniqueId, String userName, String password, String role) {
		try {
			state = conn.prepareStatement(INSERT_SQL);
			
			state.setInt(1, uniqueId);
			state.setString(2, userName);
			state.setString(3, password);
			state.setString(4, role);
			
			// 회원 가입 날짜는 이 코드를 실행하는 현재 날짜로 함.
			java.util.Date today = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(today.getTime());
			state.setDate(5, sqlDate);
			
			int rowCount = state.executeUpdate();
			System.out.println(rowCount + "건 처리되었습니다.");
			
		} catch (SQLException e) {
			jtool.handleSQLException(e);
		}
	}
	
	/**
	 * 한 건의 유저 이름 및 패스워드만 다른 값으로 수정한다. 
	 * @param uniqueId - 수정할 대상 데이터의 unique_id를 지정.
	 * @param userName
	 * @param password
	 */
	public void updateOneRecord(int uniqueId, String userName, String password) {
		try {
			state = conn.prepareStatement(UPDATE_SQL);
			
			state.setInt(3, uniqueId);
			state.setString(1, userName);
			state.setString(2, password);
			
			int rowCount = state.executeUpdate();
			System.out.println(rowCount + "건 처리되었습니다.");
			
		} catch (SQLException e) {
			jtool.handleSQLException(e);
		}
	}
	
	/**
	 * 특정 unique_id를 가지는 데이터 한 건을 삭제한다. 
	 * @param uniqueId
	 */
	public void deleteOneRecord(int uniqueId) {
		try {
			state = conn.prepareStatement(DELETE_SQL);
			
			state.setInt(1, uniqueId);
			
			int rowCount = state.executeUpdate();
			System.out.println(rowCount + "건 처리되었습니다.");
			
		} catch (SQLException e) {
			jtool.handleSQLException(e);
		}
	}
	
	public void close() {
		jtool.close(conn, state, rs);
	}
	
}
