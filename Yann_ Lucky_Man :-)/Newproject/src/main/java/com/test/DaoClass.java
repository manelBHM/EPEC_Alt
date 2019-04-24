package com.test;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoClass {


	public List getAllProducts() throws SQLException, ClassNotFoundException
	{
		List<Product> productsLists = new ArrayList<Product>();



		String url = "jdbc:mysql://localhost:3306/Magasin", user="lucky", password="";



		Class.forName("com.mysql.jdbc.Driver");



		Connection connect = DriverManager.getConnection(url, user, password);



		Statement st =  connect.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM produit");
		while(rs.next()){


			Product p = new Product(rs.getString("name"), rs.getString("description"), rs.getString("image"), rs.getInt("price"));

			productsLists.add(p);

		}
		connect.close();

		return productsLists;	
	}




	public List getImg() throws SQLException, ClassNotFoundException
	{
		List<String> imgSrc = new ArrayList<String>();



		String url = "jdbc:mysql://localhost:3306/Magasin", user="lucky", password="";



		Class.forName("com.mysql.jdbc.Driver");



		Connection connect = DriverManager.getConnection(url, user, password);



		Statement st =  connect.createStatement();

		ResultSet rs = st.executeQuery("SELECT image FROM produit");
		while(rs.next()) {

			imgSrc.add(rs.getString("image"));


		}
		connect.close();

		return imgSrc;	
	}



}

