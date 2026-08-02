package com.project.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBConnection {

static String url , user , password ;
	
	public static Connection establishConnection() throws ClassNotFoundException, SQLException, IOException{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("config/db.properties");
		prop.load(fis);

		url = prop.getProperty("db.url");
		user = prop.getProperty("db.user");
		password = prop.getProperty("db.password");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn =  DriverManager.getConnection(url,user,password);

		
		return conn;
	}
}
