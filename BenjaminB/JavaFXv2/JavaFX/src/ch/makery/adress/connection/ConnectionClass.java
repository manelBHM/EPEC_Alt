package ch.makery.adress.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	Connection connection;
	public Connection getConnection() {
		String dbname="fxdb";
		String name="root";
		String password="789147";
		String url;
		try {
			Class.forName("com.mysql.jdbc.driver");
			try {
				connection = DriverManager.getConnection( url="jdbc:mysql://localhost3306/"+dbname,name,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
		
	}
	
}
