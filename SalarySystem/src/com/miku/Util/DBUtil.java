package com.miku.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBUtil {
	public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static String URL = "jdbc:mysql://localhost:3306/db_user?useUnicode=true&characterEncoding=utf-8&SSL=false&useSSL = false";
	public static String USERNAME = "root";
	public static String PASSWORD = "526500siji";
	
	private static Connection conn  = null;
	public DBUtil() throws ClassNotFoundException{
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  Connection getConnection() {
		return conn;
	}
	
	public static void close(Connection conn,PreparedStatement stmt,ResultSet results) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt!=null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(results!=null) {
			try {
				results.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
