package com.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Produits;

public class DAO {
	static String url = "jdbc:mysql://localhost:3306/pharmacie";
	static String login = "root";
	static String pwd = "Nab141282";
	static Connection cn = null;
	static Statement st = null;
	ArrayList<Produits> listeSQL = new ArrayList<Produits>();

	

	public ArrayList<Produits> getProduit() {

		try {
			
			listeSQL.removeAll(listeSQL);

			// Step 1 : Drvier loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step2 : getting connexion
			cn = DriverManager.getConnection(url, login, pwd);
			// Step 3 : Statement creation
			st = cn.createStatement();
			String sql = "SELECT * FROM medicament;";
			// Step 4 : request execution
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

				String libelle = rs.getString("name");
				int Prix = rs.getInt("price");
				int Qts = rs.getInt("QTS");
				Produits medic = new Produits(libelle, Prix, Qts);				
				listeSQL.add(medic);
			   
			    

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listeSQL;

	}
	
	
}
