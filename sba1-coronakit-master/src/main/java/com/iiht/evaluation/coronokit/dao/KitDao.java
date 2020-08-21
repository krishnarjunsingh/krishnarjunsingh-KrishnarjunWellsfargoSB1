package com.iiht.evaluation.coronokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;

import com.iiht.evaluation.coronokit.model.CoronaKit;
import com.iiht.evaluation.coronokit.model.KitDetail;
import com.iiht.evaluation.coronokit.model.ProductMaster;



public class KitDao {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;
	
	public KitDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
	// add DAO methods as per requirements
	public boolean addCart(String id, String id2) throws ClassNotFoundException, SQLException {
		String sql = "insert into coronakitdb.cart(coronaKitId, cartid) values(?,?)";
		
		this.connect();
		
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		pstmt.setInt(2, Integer.parseInt(id2));
		boolean added = pstmt.executeUpdate() > 0;
		pstmt.close();
		this.disconnect();
		
		return added;
	}
public boolean deleteCart() throws ClassNotFoundException, SQLException {
		
		String sql = "delete from coronakitdb.cart";
		this.connect();
		
		PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
		
		boolean deleted = pstmt.executeUpdate() > 0;
		
		pstmt.close();
		this.disconnect();
		return deleted;
	}

public List<KitDetail> getKitDetail() throws ClassNotFoundException, SQLException {
	String sql = "SELECT  * from products inner join cart on products.id = cart.coronaKitId";
	this.connect();
	
	Statement stmt = this.jdbcConnection.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	// map it to model
	List<KitDetail> kitDetailList = new ArrayList<KitDetail>();
	while(rs.next()) {
		
		KitDetail kitDetail = new KitDetail(rs.getInt("id"), rs.getInt("cost"));
		kitDetailList.add(kitDetail);		
	}
	
	rs.close();
	stmt.close();
	this.disconnect();
	
	return kitDetailList;
}
public List<KitDetail> getOrderSummary() throws ClassNotFoundException, SQLException {
	String sql = "SELECT  * from products inner join cart on products.id = cart.coronaKitId";
	this.connect();
	
	Statement stmt = this.jdbcConnection.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	// map it to model
	List<KitDetail> kitDetailList = new ArrayList<KitDetail>();
	while(rs.next()) {
		
		KitDetail kitDetail = new KitDetail(rs.getInt("id"), rs.getString("description"), rs.getString("name"), rs.getInt("cost"));
		kitDetailList.add(kitDetail);		
	}
	
	rs.close();
	stmt.close();
	this.disconnect();
	
	return kitDetailList;
}
public boolean addNewUser(String name, String email, String contact) throws ClassNotFoundException, SQLException {
	String sql = "insert into coronakitdb.customerdetail(name,email,contact,customerdetailcol) values(?,?,?,?)";
	this.connect();
	
	PreparedStatement pstmt = this.jdbcConnection.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setString(2, email);
	pstmt.setInt(3, Integer.parseInt(contact));
	pstmt.setString(4, email);
	
	boolean added = pstmt.executeUpdate() > 0;
	
	pstmt.close();
	this.disconnect();
	return added;
}

public List<KitDetail> getCustomerDetail() throws ClassNotFoundException, SQLException {
	String sql = "SELECT * FROM coronakitdb.customerdetail;";
	this.connect();
	
	Statement stmt = this.jdbcConnection.createStatement();
	ResultSet rs = stmt.executeQuery(sql);

	// map it to model
	List<KitDetail> kitDetailList = new ArrayList<KitDetail>();
	while(rs.next()) {
		
		KitDetail kitDetail = new KitDetail(rs.getString("name"), rs.getString("email"), rs.getInt("contact"), rs.getString("customerdetailcol"));
		kitDetailList.add(kitDetail);		
	}
	
	rs.close();
	stmt.close();
	this.disconnect();
	
	return kitDetailList;
}
}