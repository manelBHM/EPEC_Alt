package org.openup.pilotes.avions.vols.dao.dae;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.openup.pilotes.avions.Avions;

public class Dao {

	static String DBDRIVER = "com.mysql.jdbc.Driver";
	static String DBPATH = "jdbc:mysql://localhost:3306/aeroport";
	static String DBUSER = "root";
	static String DBPASSWORD = "simplonco";
	
	static ArrayList<Avions> listeA = new ArrayList<Avions>();
	
	//this down for avions
	
		public ArrayList<Avions> getAll() throws ClassNotFoundException, SQLException{
			listeA.removeAll(listeA);
			 
			 Class.forName(DBDRIVER);
				Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM avions ");
				
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String constructeur = rs.getString("constructeur");
					String modele = rs.getString("modele");
					int capacite = rs.getInt("capacite");
					String sitee = rs.getString("sitee");
					
					Avions newAvions = new Avions(id,constructeur,modele,capacite,sitee);
					listeA.add(newAvions);
				}
				connection.close();
			return listeA;
		}
		
		public void insert(String constructeur, String modele,int capacite, String sitee ) throws ClassNotFoundException, SQLException {
			Class.forName(DBDRIVER);
			Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
			Statement statement = connection.createStatement();
			
			statement.executeUpdate("insert into pilotes(constructeur,modele,capacite,sitee) value ('"+constructeur+"','"+modele+"',"+capacite+",'"+sitee+"');");
			connection.close();
		}
		
		public void delete(int id) throws ClassNotFoundException, SQLException {
			Class.forName(DBDRIVER);
			Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
			Statement statement = connection.createStatement();
		
			 statement.executeUpdate("DELETE FROM avions WHERE id="+id+";");
			connection.close();
	}

}
