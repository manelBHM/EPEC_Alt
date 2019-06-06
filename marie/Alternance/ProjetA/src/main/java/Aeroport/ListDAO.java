package Aeroport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ListDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
		String BDPATH = "jdbc:mysql://localhost:3306/Aéroports";
		String DBUSER = "root";
		String DBPASSWORD = "simplon";
		
		try {
       	
       	 Class.forName(DATABASE_DRIVER);
       	 
       	 
       	 Connection connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
       	 Statement statement = connection.createStatement();
       	 ResultSet rs = statement.executeQuery("SELECT * FROM Aéroports.vol");
       	 while (rs.next()) {
         System.out.println(" - " + rs.getString("id") + " " + rs.getString("pilote") + " " + rs.getString("avion") + " " + rs.getString("heureArrive") + " " + 
       	 rs.getString("heureDepart") + " " + rs.getString("siteArrive") + " " + rs.getString("siteDepart"));
         } connection.close();
		 } catch (Exception e) {e.printStackTrace();
	     }
	}
	
	

	public ArrayList<Vol> getAll() {
		ArrayList<Vol> listeP = new ArrayList<Vol>();
		String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
		String BDPATH = "jdbc:mysql://localhost:3306/Aéroports";
		String DBUSER = "root";
		String DBPASSWORD = "simplon";
		
		try {
       	
       	 Class.forName(DATABASE_DRIVER);
       	 
       	 
       	 Connection connection = DriverManager.getConnection(BDPATH, DBUSER, DBPASSWORD);
       	 Statement statement = connection.createStatement();
       	 ResultSet rs = statement.executeQuery("SELECT * FROM Aéroports.vol");
       	 while (rs.next()) {
       	 System.out.println(" - " + rs.getString("id") + " " + rs.getString("pilote") + " " + rs.getString("avion") + " " + rs.getString("heureArrive") + " " + 
       	 rs.getString("heureDepart") + " " + rs.getString("siteArrive") + " " + rs.getString("siteDepart"));
       	 
         Vol v = new Vol(0, 0, 0, rs.getString("pilote") + " " + rs.getString("avion") + " " + rs.getString("heureArrive") + " " + 
         rs.getString("heureDepart") + " " + rs.getString("siteArrive") + " " + rs.getString("siteDepart"), DBPASSWORD, DBPASSWORD, DBPASSWORD);
         listeP.add(v);
         } connection.close();
		 } catch (Exception e) {e.printStackTrace();
	     }
		return listeP;
	}
}
