package cpro.alternant;

import java.util.*;
import java.sql.*;


public class Dao {


	public List getAlternant() throws SQLException, ClassNotFoundException
	{
		List<Alternant> listAlternant = new ArrayList<Alternant>();


		Class.forName("com.mysql.jdbc.Driver");

		String url = "jdbc:mysql://localhost:3306/cpro", user="lucky", password="";


		Connection connect = DriverManager.getConnection(url, user, password);



		Statement st =  connect.createStatement();

		ResultSet rs = st.executeQuery("SELECT * FROM alternant");

		while(rs.next()){

			if(rs.getString("img") != null)
			{
				Alternant p = new Alternant(rs.getString("nom"), rs.getString("prenom"), rs.getString("naissance"), rs.getString("entreprise"), rs.getString("img"));

				listAlternant.add(p);
			}

			else 
			{
				return null;
			}


		}
		connect.close();

		return listAlternant;	
	}
	
	
	
	
	public void saveAlternant(String nom, String prenom, String naissance, String entreprise, String img)
	{
		String url = "jdbc:mysql://localhost:3306/cpro", user="lucky", password="";
	Connection cn = null;
	Statement st = null;
	
	try {
		// etape 1 chargement du DRIVER
		Class.forName("com.mysql.jdbc.Driver");
		
		// etape 2 recuperation de la connexion
		cn = DriverManager.getConnection(url, user, password);
		
		// etape 3 Creation d'un statement
		st = cn.createStatement();
		
		String sql = "INSERT INTO `alternant` (`nom`, `prenom`, `naissance`, `entreprise`, `img`) VALUES ('"+nom+"','"+prenom+"', '"+naissance+"', '"+entreprise+"', '"+img+"')";
		
		// etape 4 excution de la connexion
		st.executeUpdate(sql);
		
	}catch(SQLException e) {
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} finally {
			
		try {
			cn.close();
			st.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	}


}