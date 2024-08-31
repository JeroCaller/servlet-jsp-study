package com.cola.db.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BasicDql {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new org.h2.Driver());
			
			String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
			String userName = "sa";
			String password = "";
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
			
			String sql = "select * from site_user";
			state = conn.prepareStatement(sql);
			
			rs = state.executeQuery();
			
			System.out.println("=== site_user table ===");
			while(rs.next()) {
				System.out.printf("%d \t %s \t %s \t %s \t ", 
						rs.getInt("unique_id"),
						rs.getString("user_name"),
						rs.getString("password"),
						rs.getString("role")
				);
				System.out.println(rs.getDate("sign_date"));
			}
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
			
			try {
				rs.close();
			} catch (SQLException | NullPointerException e) {
				e.printStackTrace();
			} 
		}
		
	}

}
