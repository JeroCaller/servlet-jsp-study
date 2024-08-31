package com.cola.db.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cola.db.lib.JDBCTool;

public class DMLWithTool {

	public static void main(String[] args) {
		JDBCTool jTool = new JDBCTool();
		Connection conn = null;
		PreparedStatement state = null;
		
		try {
			conn = jTool.getConnection();
			
			String sql = "insert into site_user values(?, ?, ?, ?, ?)";
			state = conn.prepareStatement(sql);
			
			state.setInt(1, 2);
			state.setString(2, "jeongdb123");
			state.setString(3, "jeongdb1111");
			state.setString(4, "ADMIN");
			
			java.util.Date today = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(today.getTime());
			state.setDate(5, sqlDate);
			
			int rowCount = state.executeUpdate();
			System.out.println(rowCount + "건 처리되었습니다.");
		} catch (SQLException e) {
			jTool.handleSQLException(e);
		} finally {
			jTool.close(conn, state);
		}
	}

}
