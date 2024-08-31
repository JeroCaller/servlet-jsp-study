package com.cola.db.lib;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTool {
	private String jdbcUrl = "jdbc:h2:tcp://localhost/~/test";
	private String userName = "sa";
	private String password = "";
	private Driver driver = new org.h2.Driver();
	
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	public JDBCTool() {}
	public JDBCTool(String jdbcUrl, String userName, String password, Driver driver) {
		this.jdbcUrl = jdbcUrl;
		this.userName = userName;
		this.password = password;
		this.driver = driver;
	}
	
	public void handleSQLException(SQLException exp) {
		System.out.println("=== SQL 관련 예외 발생. 자세한 사항은 다음을 참조 ===");
		exp.printStackTrace();
	}
	
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			DriverManager.registerDriver(driver);
			
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch (SQLException e) {
			handleSQLException(e);
		}
		return conn;
	}
	
	/**
	 * AutoCloseable 인터페이스를 상속받는 객체들의 close() 메서드를 호춯한다.
	 * @param closes - Connection, ResultSet, PreparedStatement 객체
	 */
	public void close(AutoCloseable ...closes) {
		for (AutoCloseable autoc : closes) {
			if (autoc == null) {
				continue;
			}
			
			try {
				autoc.close();
			} catch (Exception e) {
				if (e instanceof SQLException) {
					handleSQLException((SQLException)e);
				} else {
					System.out.println("=== 예기치 못한 예외 발생 ===");
					e.printStackTrace();
				}
			}
		}
	}
	
}
