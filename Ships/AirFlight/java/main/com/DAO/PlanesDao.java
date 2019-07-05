package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtils.DBConnector;
import com.Entity.Planes;

public class PlanesDao {
	private String CREATE		= "INSTER INTO planes (name, model) VALUES (?, ?)";
	private String GET_ALL		= "SELECT * FROM planes";
	private String GET_BY_NAME	= "SELECT * FROM planes WHERE name = ?";
	private String UPDATE		= "UPADATE planes SET name = ?, model = ? WHERE id = ?";
	private String DELETE		= "DELETE FROM planes WHERE id = ?";
	Connection connection		= DBConnector.getConnection();
	
	//creating planes - 
	public void creatPlane(String name, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE);
		ps.setString(1, name);
		ps.setString(2, model);
		ps.executeUpdate();
		System.out.println("Plane created.");
	}
	//get allPlanes - 
	public List<Planes> getAll(int id, String name, String model) throws SQLException {
		List<Planes>planesList = new ArrayList<Planes>();
		PreparedStatement ps = connection.prepareStatement(GET_ALL);
		ResultSet 		  rs = ps.executeQuery();
		planesList.clear();
		while(rs.next()) {
			planesList.add(buildPlane(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return planesList;
	}
	//get by name - 
	public Planes getByName(String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BY_NAME);
		ps.setString(1, name);
		ResultSet		  rs = ps.executeQuery();
		rs.next();
		return buildPlane(rs.getInt(1), rs.getString(2), rs.getString(3));	
	}
	//update - 
	public void updatePlane(int id, String name, String model) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, name);
		ps.setString(2, model);
		ps.setInt(3, id);
		ps.executeUpdate();
		System.out.println("Update successful");
	}
	//delete -
	public void deletePlane(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	//build plane - 
	public Planes buildPlane(int id, String name, String model) {
		return new Planes (id, name, model);
	}
	

}
