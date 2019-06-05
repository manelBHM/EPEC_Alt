package validation;
import dbUtils.*;
import java.sql.*;

public class Valider {

	public static boolean checkUser(String user, String pass) {
		boolean ok = false;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		try {
			PreparedStatement ps = dbConnector.getConncetion().prepareStatement("SELECT * FROM idPass WHERE userName = ? AND passWord = ?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			ok = rs.next();
			System.out.println("valider works");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return ok;
	}
	
	public static void register(String user, String pass) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
		}
		try {
			PreparedStatement ps = dbConnector.getConncetion().prepareStatement("INSERT INTO idPass (userName, passWord) VALUES (?, ?)");
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
