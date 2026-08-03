package com.project.util;

import java.io.InputStream;
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

            InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db.properties");
            properties.load(input);

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