package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

static String url , user , password ;
	
	public static Connection establishConnection() throws ClassNotFoundException, SQLException{
		
		url = "jdbc:mysql://localhost:3306/blood_donor";
		user = "root";
		password = "Harsh@156";
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =  DriverManager.getConnection(url,user,password);

		
		return conn;
	}
}
