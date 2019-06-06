package com.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Model.Personne;

public class DAO {
	static String url = "jdbc:mysql://localhost:3306/Personnes";
	static String login = "root";
	static String pwd = "Nab141282";
	static Connection cn = null;
	static Statement st = null;
	ArrayList<Personne> listeSQL = new ArrayList<Personne>();
	
	
	public ArrayList<Personne> getPersonne() {

		try {
			
			listeSQL.removeAll(listeSQL);

			// Step 1 : Drvier loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step2 : getting connexion
			cn = DriverManager.getConnection(url, login, pwd);
			// Step 3 : Statement creation
			st = cn.createStatement();
			String sql = "SELECT * FROM Personne;";
			// Step 4 : request execution
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				
				int id = rs.getInt("Id");
				int version = rs.getInt("version");
				String Nom = rs.getString("nom");
				String Prenom = rs.getString("prenom");
				Date date = rs.getDate("date_naissance");
				boolean marie = rs.getBoolean("Marie");
				int nbr = rs.getInt("nbr_enf");
				
				
				Personne per = new Personne(id, version, Nom, Prenom, date, marie, nbr);				
				listeSQL.add(per);
			   
			   
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listeSQL;

	}
	

}
