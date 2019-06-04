package dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnector {
	//jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC

	private static String PATH = "jdbc:mysql://localhost:3306/id_pass_test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String USER = "root";
	private static String PASS = "pass";
	private static Connection connection = null;
	
	public static Connection getConncetion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		if(connection == null) {
			
			try {
				connection = DriverManager.getConnection(PATH, USER, PASS);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("Db connected...");
		}
		return connection;
	}
}
