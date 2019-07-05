package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtils.DBConnector;
import com.Entity.Pilots;

public class PilotDao {
	private String CREATE 		= "INSTER INTO pilots (firstName, lastName) VALUES (?, ?)";
	private String GET_ALL		= "SELECT * FROM pilots";
	private String GET_BY_FNAME = "SELECT * FROM pilots WHERE firstName = ?";
	private String UPDATE		= "UPDATE pilots SET firstName = ?, lastName = ? WHERE id = ?";
	private String DELETE		= "DELETE FROM pilots WHERE id = ?";
	Connection connection		= DBConnector.getConnection(); 
	
	//creating pilot - 
	public void createPilot(String firstName, String lastName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.executeUpdate();
		System.out.println("New pilot created");
	}
	//get all pilots - 
	public List<Pilots> getAll() throws SQLException{
		List<Pilots> pilotsList = new ArrayList<Pilots>();
		PreparedStatement ps	= connection.prepareStatement(GET_ALL);
		ResultSet 		  rs	= ps.executeQuery();
		pilotsList.clear();
		while(rs.next()) {
			pilotsList.add(buildPilot(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		return pilotsList;
	}
	//get by name - 
	public Pilots getByName(String firstName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BY_FNAME);
		ps.setString(1, firstName);
		ResultSet 		  rs = ps.executeQuery();
		rs.next();
		return buildPilot(rs.getInt(1), rs.getString(2), rs.getString(3));
	}
	//update - 
	public void updatePilot(int id, String firstName, String lastName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setInt(3, id);
		ps.executeUpdate();
		System.out.println("Update successful");
	}
	//delete - 
	public void deletePilot(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Selected pilot deleted.");
	} 
	//build pilot - 
	public Pilots buildPilot(int id, String firstName, String lastName) {
		return new Pilots(id, firstName, lastName);
	}
}
















