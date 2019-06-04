package org.openup.pilotes.avions.vols.dao.dae.dae;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openup.pilotes.avions.vols.Vols;

public class Dae {

	static String DBDRIVER = "com.mysql.jdbc.Driver";
	static String DBPATH = "jdbc:mysql://localhost:3306/aeroport";
	static String DBUSER = "root";
	static String DBPASSWORD = "simplonco";
	
	static ArrayList<Vols> listeV = new ArrayList<Vols>();
	
	public ArrayList<Vols> getAll() throws ClassNotFoundException, SQLException{
		listeV.removeAll(listeV);
		 
		 Class.forName(DBDRIVER);
			Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM vols ");
			
			
			while(rs.next()) {
				String id = rs.getString("id");
				int avion = rs.getInt("avion");
				int pilote = rs.getInt("pilote");
			    String siteArrivee = rs.getString("siteArrivee");
			    String siteDepart = rs.getString("siteDepart");
			    String heureArrivee = rs.getString("heureArrivee");
			    String heureDepart = rs.getString("heureDepart");
				
				Vols newVole = new Vols(id,avion,pilote,siteArrivee,siteDepart,heureArrivee,heureDepart);
				listeV.add(newVole);
			}
			connection.close();
		return listeV;
	}
	
	public void insert(String id, int avion,int pilote,String siteArrivee, String siteDepart,String heureArrivee, String heureDepart) throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
		Statement statement = connection.createStatement();
		
		statement.executeUpdate("insert into vols(id,avion,pilote,siteArrivee,siteDepart,heureArrivee,heureDepart) value ('"+id+"',"+avion+","+pilote+",'"+siteArrivee+"','"+siteDepart+"','"+heureArrivee+"','"+heureDepart+"');");
		connection.close();
	}
	
	public void delete(int id) throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
		Statement statement = connection.createStatement();
	
		 statement.executeUpdate("DELETE FROM vols WHERE id="+id+";");
		connection.close();
}
}
