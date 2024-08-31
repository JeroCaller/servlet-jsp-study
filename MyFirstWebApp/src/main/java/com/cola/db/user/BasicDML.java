package com.cola.db.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BasicDML {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement state = null;
		
		try {
			DriverManager.registerDriver(new org.h2.Driver());
			
			String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
			String userName = "sa";
			String password = "";
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			
			String sql = "insert into site_user values(?, ?, ?, ?, ?)";
			state = conn.prepareStatement(sql);
			
			state.setInt(1, 1);
			state.setString(2, "kimquel123");
			state.setString(3, "kimquel1111");
			state.setString(4, "USER");
			
			java.util.Date today = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(today.getTime());
			state.setDate(5, sqlDate);
			
			int rowCount = state.executeUpdate();
			System.out.println(rowCount + "건 처리되었습니다.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
			
			try {
				state.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			}
		}
	}

}
