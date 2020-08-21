package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iiht.evaluation.coronokit.model.ProductMaster;



public class ProductMasterDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public ProductMasterDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

	protected void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}

	protected void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	// add DAO methods as per requirements
	public List<ProductMaster> getProductRecords() throws ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM coronakitdb.products";
		this.connect();
		
		Statement stmt = this.jdbcConnection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		// map it to model
		List<ProductMaster> productMasterList = new ArrayList<ProductMaster>();
		while(rs.next()) {
			
			ProductMaster productMaster = new ProductMaster(rs.getInt("id"), rs.getString("name"), rs.getInt("cost"), rs.getString("description"));
			productMasterList.add(productMaster);		
		}
		
		rs.close();
		stmt.close();
		this.disconnect();
		
		return productMasterList;
	}
	public boolean addNewProduct(String name, String desc, String cost) throws ClassNotFoundException, SQLException {
		String sql = "insert into coronakitdb.products(name,description,cost) values(?,?,?)";
		this.connect();
		
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setString(2, desc);
		pstmt.setInt(3, Integer.parseInt(cost));
		
		boolean added = pstmt.executeUpdate() > 0;
		
		pstmt.close();
		this.disconnect();
		return added;
	}

	public boolean deleteProduct(String id) throws ClassNotFoundException, SQLException {
		
		String sql = "delete from coronakitdb.products where id=?";
		this.connect();
		
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		
		boolean deleted = pstmt.executeUpdate() > 0;
		
		pstmt.close();
		this.disconnect();
		return deleted;
	}
	
	public List<ProductMaster> viewEditProductRecords(String id) throws ClassNotFoundException, SQLException {
		String sql = "SELECT id, name, description, cost FROM coronakitdb.products where id = ?";
		this.connect();
		
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		
		ResultSet rs = pstmt.executeQuery();
		
		// map it to model
		List<ProductMaster> productMasterList = new ArrayList<ProductMaster>();
		while(rs.next()) {
			
			ProductMaster productMaster = new ProductMaster(rs.getInt("id"), rs.getString("name"), rs.getInt("cost"), rs.getString("description"));
			productMasterList.add(productMaster);		
		}
		
		rs.close();
		pstmt.close();
		this.disconnect();
		
		return productMasterList;
	}
	public boolean updateProduct(String name, String cost, String desc, int id) throws ClassNotFoundException, SQLException {
		String sql = "UPDATE coronakitdb.products SET name = ? ,cost = ?, description = ? where id = ?";
		this.connect();
		
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setString(1, name);
		pstmt.setInt(2, Integer.parseInt(cost));
		pstmt.setString(3, desc);
		pstmt.setInt(4, id);
		
		boolean updated = pstmt.executeUpdate() > 0;
		
		pstmt.close();
		this.disconnect();
		return updated;
	}
}