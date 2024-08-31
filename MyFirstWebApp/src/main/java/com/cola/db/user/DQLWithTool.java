package com.cola.db.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cola.db.lib.JDBCTool;

public class DQLWithTool {

	public static void main(String[] args) {
		JDBCTool jTool = new JDBCTool();
		Connection conn = null;
		PreparedStatement state = null;
		ResultSet rs = null;
		
		try {
			conn = jTool.getConnection();
			
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
			jTool.handleSQLException(e);
		} finally {
			jTool.close(conn, state, rs);
		}
		
	}

}
