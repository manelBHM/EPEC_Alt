package org.openup.pilotes.avions.vols.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.openup.pilotes.Pilotes;





public class DAO {
	
	static String DBDRIVER = "com.mysql.jdbc.Driver";
	static String DBPATH = "jdbc:mysql://localhost:3306/aeroport";
	static String DBUSER = "root";
	static String DBPASSWORD = "simplonco";

	static ArrayList<Pilotes> listeP = new ArrayList<Pilotes>();
	
	
	
	//this down for listeP
	
	public ArrayList<Pilotes> getAll() throws ClassNotFoundException, SQLException{
		 listeP.removeAll(listeP);
		 
		 Class.forName(DBDRIVER);
			Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM pilotes ");
			
			
			while(rs.next()) {
				int id=rs.getInt("id");
				String nom = rs.getString("nom");
				String sit = rs.getString("sit");
				
				Pilotes newPilotes = new Pilotes(id,nom,sit);
				listeP.add(newPilotes);
			}
			connection.close();
		return listeP;
	}
	
	public void insert(String nom, String sit) throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("insert into pilotes(nom,sit) value ('"+nom+"','"+sit+"');");
		connection.close();
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
		Statement statement = connection.createStatement();
	
		 statement.executeUpdate("DELETE FROM pilotes WHERE id="+id+";");
		connection.close();
}
	
	////////////////////
	
	
	
	
	
	

	
	
}
