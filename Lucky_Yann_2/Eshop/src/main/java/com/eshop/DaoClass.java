package com.eshop;


import java.util.*;
import java.sql.*;

public class DaoClass {

	
	public List getAllProducts() throws SQLException, ClassNotFoundException
	{
		List<Product> productsLists = new ArrayList<Product>();


		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/Magasin", user="lucky", password="";


		Connection connect = DriverManager.getConnection(url, user, password);



		Statement st =  connect.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM produit");
		
		while(rs.next()){

			if(rs.getString("image") != null)
			{
			Product p = new Product(rs.getString("name"), rs.getString("description"), rs.getString("image"), rs.getInt("price"), rs.getInt("quantite"));

			productsLists.add(p);
			}
			else {
				return null;
			}

		
		}
		connect.close();

		return productsLists;	
	}


}

