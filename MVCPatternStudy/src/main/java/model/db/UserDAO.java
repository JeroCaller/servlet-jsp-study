package model.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	
	private Context context = null;
	private DataSource dataSource = null;
	
	public UserDAO() {
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (NamingException e) {
			System.out.println("=== DB 연동 과정에서 예외 발생 ===");
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 가입을 위해 유저 정보를 DB에 삽입.
	 * @param oneUser 회원 가입 시 입력받은 데이터들이 담긴 DTO 객체
	 */
	public boolean insertUser(UserDTO oneUser) {
		String sql = "INSERT INTO users (id, password) VALUES (?, ?)";
		
		int result = 0;
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			
			statement.setString(1, oneUser.getId());
			statement.setString(2, oneUser.getPassword());
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			JDBCTool.handleException("signUpUser", e);
		} finally {
			JDBCTool.freeConnection(connection, statement);
		}
		
		if (result > 0) return true;
		return false;
	}
	
	/**
	 * 모든 회원 정보 조회하여 반환.
	 * @return
	 */
	public List<UserDTO> getAllUsers() {
		String sql = "SELECT * FROM users";
		
		List<UserDTO> users = new ArrayList<UserDTO>();
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				UserDTO oneUser = new UserDTO();
				
				oneUser.setUser_no(resultSet.getInt("user_no"));
				oneUser.setId(resultSet.getString("id"));
				oneUser.setPassword(resultSet.getString("password"));
				
				users.add(oneUser);
			}
			
		} catch (SQLException e) {
			JDBCTool.handleException("signUpUser", e);
		} finally {
			JDBCTool.freeConnection(connection, statement, resultSet);
		}
		
		return users;
	}
	
}
