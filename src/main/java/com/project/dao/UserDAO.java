package com.project.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;
import com.project.model.User;
import com.project.util.DBConnection;

//import jdk.javadoc.internal.doclets.toolkit.util.PreviewAPIListBuilder;

public class UserDAO {

	public boolean reqisterUser(User user) throws Exception {
		
		boolean status = false;
		
		Connection conn = DBConnection.establishConnection(); 
		
		String query = "Insert into users(full_name , email , password , phone , role) values (?,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, user.getFull_name());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getPhone());
		ps.setString(5, user.getRole());
		
		int row = ps.executeUpdate();
		
		if(row>0) {
			status = true;
		}
		ps.close();
		
		return status;
	}
	

	public User Login(String email , String password) throws Exception {
		
		boolean status = false;
	
		Connection conn = DBConnection.establishConnection();

		String query = "select * from users where email = ? and password = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, email);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		User us = null;
		
		if(rs.next()) {
			
			us = new User();
			
			us.setUser_id(rs.getInt("user_id"));
			us.setFull_name(rs.getString("full_name"));
			us.setEmail(rs.getString("email"));
			us.setPassword(rs.getString("password"));
			us.setPhone(rs.getString("phone"));
			us.setRole(rs.getString("role"));
			
			
		}
		rs.close();
		ps.close();
		
		return us;
		
	}
	
	public boolean isEmailExits(String email) throws Exception {
		
		Connection conn = DBConnection.establishConnection();
		
		String query = "select * from users where email = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);

		ps.setString(1, email);
		
		ResultSet rs = ps.executeQuery();
		
		return rs.next();
	
	}
	
	public boolean updateprofile(User us) throws Exception {
		
		Boolean status = false;
		
		Connection conn = DBConnection.establishConnection();
		
		String query = "update users set full_name = ? , email = ? , password = ? , phone = ? where user_id = ?";
		
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, us.getFull_name());
		ps.setString(2, us.getEmail());
		ps.setString(3, us.getPassword());
		ps.setString(4, us.getPhone());
		ps.setInt(5, us.getUser_id());
		
		int row = ps.executeUpdate();
		
		if(row > 0) {
			
			status = true;
		}
		
		ps.close();
		conn.close();
		return status;
		
		
		
		
	}
	

	
}


