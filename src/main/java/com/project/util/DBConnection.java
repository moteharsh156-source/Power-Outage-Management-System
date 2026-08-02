package com.project.util;

<<<<<<< HEAD
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("db.properties");
            properties.load(file);

            url = properties.getProperty("db.url");
            username = properties.getProperty("db.username");
            password = properties.getProperty("db.password");
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection establishConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}
=======

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
>>>>>>> 43c1aa7ee7dd8569058a1d6094b798dade381eb9
