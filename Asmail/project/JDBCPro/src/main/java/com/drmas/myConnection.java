package com.drmas;
import java.sql.*;

public class myConnection extends contextSql {
	
	public static Connection getMyConn() throws SQLException {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/JDBCPro";
			con = DriverManager.getConnection(url, "root", "");
			System.out.println("Connected Sucessfully :)");
		} catch (ClassNotFoundException e) {
			System.out.print(e.getCause());
			e.printStackTrace();
		}
		
		
		return con;
	}
	
	public static void main(String[] args) throws SQLException {
		getMyConn();
	}

}
