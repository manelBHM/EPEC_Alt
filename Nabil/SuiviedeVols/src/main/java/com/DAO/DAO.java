package com.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Model.Avion;
import Model.Pilote;
import Model.Vol;
import org.springframework.stereotype.Repository;

@Repository
public class DAO {
	
	
	
	static String url = "jdbc:mysql://localhost:3306/SuivieDeVols";

	static String login = "root";
	static String pwd = "Nab141282";
	static Connection cn = null;
	static Statement st = null;
	ArrayList<Pilote> listeSQL = new ArrayList<Pilote>();
	ArrayList<Avion> listeSQL2 = new ArrayList<Avion>();
	ArrayList<Vol> listeSQL3 = new ArrayList<Vol>();

	
	public ArrayList<Pilote> getPilote() {

		try {
			
			listeSQL.removeAll(listeSQL);

			// Step 1 : Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step2 : getting connexion
			cn = DriverManager.getConnection(url, login, pwd);
			// Step 3 : Statement creation
			st = cn.createStatement();
			String sql = "SELECT * FROM Pilote";
			// Step 4 : request execution
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				
				int id = rs.getInt("ID");
				String nom = rs.getString("nom");
				String site = rs.getString("site");
											
				Pilote Pilote = new Pilote(id, nom, site);				
				listeSQL.add(Pilote);
			   
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listeSQL;

	}
	
	
	
	public ArrayList<Avion> getAvion() {

		try {
			
			listeSQL2.removeAll(listeSQL2);

			// Step 1 : Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step2 : getting connexion
			cn = DriverManager.getConnection(url, login, pwd);
			// Step 3 : Statement creation
			st = cn.createStatement();
			String sql = "SELECT * FROM Avion;";
			// Step 4 : request execution
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				
				int id = rs.getInt("ID");
				String constructeur = rs.getString("constructeur");
				String modele = rs.getString("modele");
				String capacite = rs.getString("capacite");
				String site = rs.getString("site");
				
				Avion Avion = new Avion(id, constructeur, modele, capacite, site);				
				listeSQL2.add(Avion);
			   
			   
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listeSQL2;

	}
	
	
	public ArrayList<Vol> getVol() {

		try {
			
			listeSQL3.removeAll(listeSQL3);

			// Step 1 : Driver loading
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Step2 : getting connexion
			cn = DriverManager.getConnection(url, login, pwd);
			// Step 3 : Statement creation
			st = cn.createStatement();
			String sql = "SELECT * FROM Vol;";
			// Step 4 : request execution
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				
				String id = rs.getString("ID");
				String avion = rs.getString("avion");
				String HA = rs.getString("heureArrivee");
				String HD = rs.getString("heureDepart");
				String pilote = rs.getString("pilote");
				String siteArrivee = rs.getString("siteArrivee");
				String siteDepart = rs.getString("siteDepart");

				Vol Vol = new Vol(id, avion, HA, HD, pilote, siteArrivee, siteDepart);				
				listeSQL3.add(Vol);
			   			   
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return listeSQL3;

	}



	public String findPiloteByNom(String name) {
		// TODO Auto-generated method stub
		return name;
	}
	
}
