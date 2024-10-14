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

public class ProductDAO {
	private Connection connection = null;
	private PreparedStatement statement = null;
	private ResultSet resultSet = null;
	
	private Context context = null;
	private DataSource dataSource = null;
	
	public ProductDAO() {
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mvc");
		} catch (NamingException e) {
			System.out.println("=== DB 연동 과정에서 예외 발생 ===");
			e.printStackTrace();
		}
	}
	
	private String selectedCategory = null;
	
	public void setSelectedCategory(String category) {
		this.selectedCategory = category;
	}
	
	/**
	 * 특정 카테고리의 물품 데이터들을 반환. 
	 * setSelectedCategory() 메서드를 통해 먼저 조회하고자 하는 카테고리를 정해야 함.
	 * @return
	 */
	public List<ProductDTO> getAllproducts() {
		if (this.selectedCategory == null) return null;
		
		String sql = "SELECT name, price, category FROM products WHERE category=?";
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, this.selectedCategory);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				ProductDTO oneItem = new ProductDTO();
				
				oneItem.setName(resultSet.getString("name"));
				oneItem.setPrice(resultSet.getInt("price"));
				oneItem.setCategory(resultSet.getString("category"));
				
				products.add(oneItem);
			}
			
		} catch (SQLException e) {
			JDBCTool.handleException("getAllproducts", e);
		} finally {
			JDBCTool.freeConnection(connection, statement, resultSet);
		}
		
		return products;
	}
}
