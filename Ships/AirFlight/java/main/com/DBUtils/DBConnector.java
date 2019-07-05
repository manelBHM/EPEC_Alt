package com.DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String PATH 					= "jdbc:mysql://localhost:3306/airlineDB"; 	
	private static String USER						= "root";
	private static String PASS						= "pass";  
	private static Connection connection	= null;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(PATH, USER, PASS);
				System.out.println("Db connected succesfully...");
			}catch(SQLException e) {
				e.printStackTrace();
			} 
		}
			return connection;
		
	}
	
}
