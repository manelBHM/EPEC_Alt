package com.example.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.demo.Model.Person;

public class Dao {

	static String DBDRIVER = "com.mysql.jdbc.Driver";
	static String DBPATH = "jdbc:mysql://localhost:3306/person";
	static String DBUSER = "root";
	static String DBPASSWORD = "simplonco";
	static ArrayList<Person> liste = new ArrayList<Person>();

	public ArrayList<Person> getAll() throws ClassNotFoundException, SQLException {
		
		liste.removeAll(liste);

		Class.forName(DBDRIVER);
		Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
		
		Statement statement = connection.createStatement();
		
		ResultSet rs = statement.executeQuery("SELECT * FROM list");

		while (rs.next()) {

			String prenom = rs.getString("prenom");
			String nom = rs.getString("nom");
			int age = rs.getInt("age");
			int id = rs.getInt("id");
			Person newPersonne = new Person(id, nom, prenom, age);
			liste.add(newPersonne);
		}

		connection.close();
		return liste;

	}
	
	public void insert(String nom, String prenom, int age) throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
		Statement statement = connection.createStatement();
	
		 statement.executeUpdate("insert into list (nom,prenom,age) value ('"+nom+"','"+prenom+"',"+age+");");
		connection.close();
}
	public void delete(int id) throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		Connection connection = DriverManager.getConnection(DBPATH, DBUSER, DBPASSWORD);
		Statement statement = connection.createStatement();
	
		 statement.executeUpdate("DELETE FROM list WHERE id="+id+";");
		connection.close();
}

	
	
}
