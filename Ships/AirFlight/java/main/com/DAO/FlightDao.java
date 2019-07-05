package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DBUtils.DBConnector;
import com.Entity.Flights;

public class FlightDao {
	private final String CREATE  		= "INSERT INTO flights (depart, arrive, planes_id, pilots_id, flightNo) VALUES (?, ?, ?, ?, ?)";
	private final String GET_ALL 		= "SELECT flights.id, flightNo, depart, arrive, name, firstName, lastName FROM flights  INNER JOIN planes ON flights.planes_id = planes.id  INNER JOIN pilots ON flights.pilots_id = pilots.id";
	private final String GET_BY_FLY_NO  = "SELECT flights.id, flightNo, depart, arrive, name, firstName, lastName FROM flights INNER JOIN planes ON flights.planes_id = planes.id INNER JOIN pilots ON flights.pilots_id = pilots.id WHERE flightNo = ?";
	private final String GET_BY_DEPART  = "SELECT flights.id, flightNo, depart, arrive, name, firstName, lastName FROM flights INNER JOIN planes ON flights.planes_id = planes.id INNER JOIN pilots ON flights.pilots_id = pilots.id WHERE depart = ?";
	private final String GET_BY_ARRIVE  = "SELECT flights.id, flightNo, depart, arrive, name, firstName, lastName FROM flights INNER JOIN planes ON flights.planes_id = planes.id INNER JOIN pilots ON flights.pilots_id = pilots.id WHERE arrive = ?";
	private final String GET_BY_PILOT   = "SELECT flights.id, flightNo, depart, arrive, name, firstName, lastName FROM flights INNER JOIN planes ON flights.planes_id = planes.id INNER JOIN pilots ON flights.pilots_id = pilots.id WHERE firstName = ?";
	private final String UPDATE			= "UPDATE flights SET depart = ?, arrive = ?, planes_id = ?, pilots_id = ?, flightNo = ? WHERE flights.id = ?";
	private final String DELETE			= "DELETE FROM flights WHERE id = ?";
	Connection connection				= DBConnector.getConnection();
	
	//creating flights -
	public void createFlight(String depart, String arrive, int planes_id, int pilots_id, String flightNo) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE);
		ps.setString(1, depart);
		ps.setString(2, arrive);
		ps.setInt(3, planes_id);
		ps.setInt(4, pilots_id);
		ps.setString(5, flightNo);
		ps.executeUpdate();
		
		System.out.println("created");
	}
	//get all - 
	public List<Flights>getAll() throws SQLException{
		List<Flights> flightList = new ArrayList<Flights>();
		PreparedStatement ps 	= connection.prepareStatement(GET_ALL);
		ResultSet		  rs	= ps.executeQuery();
		flightList.clear();
		while(rs.next()) {
			flightList.add(flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return flightList;
	}
	
	//get by flight no - 
	public Flights getByFlight(String flightNo) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_BY_FLY_NO);
		ps.setString(1, flightNo);
		ResultSet 		  rs = ps.executeQuery();
		rs.next();
		return flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
	}
	//get by departure -
	public List<Flights> getByDepart(String depart) throws SQLException {
		List<Flights>flList = new ArrayList<Flights>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_DEPART);
		ps.setString(1, depart);
		ResultSet 		  rs = ps.executeQuery();
		while(rs.next()) {
			flList.add(flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return flList;
	}
	//get by arrival -
	public List<Flights> getByArrival(String arrive) throws SQLException {
		List<Flights>flList = new ArrayList<Flights>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_ARRIVE);
		ps.setString(1, arrive);
		ResultSet 		  rs = ps.executeQuery();
		while(rs.next()) {
			flList.add(flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return flList;
	}
		
	//get by pilotFname -
	public List<Flights> getByPilot(String pilot) throws SQLException {
		List<Flights>flList = new ArrayList<Flights>();
		PreparedStatement ps = connection.prepareStatement(GET_BY_PILOT);
		ps.setString(1, pilot);
		ResultSet 		  rs = ps.executeQuery();
		while(rs.next()) {
			flList.add(flight(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
		}
		return flList;
	}
		
	
	//update flight - 
	public void update(int id, String depart, String arrive, int plane, int pilot, String flightNo) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, depart);
		ps.setString(2, arrive);
		ps.setInt(3, plane);
		ps.setInt(4, pilot);
		ps.setString(5, flightNo);
		ps.setInt(6, id);
		ps.executeUpdate();
		System.out.println("Update successful");	
	}
	//delete flight - 
	public void deleteFlight(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Flight no : " + id + " has been deleted.");
	}
	public Flights flight(int id, String depart, String arrive, String plane, String pilotFname, String pilotLname, String flightNo) {
		return new Flights(id, depart, arrive, plane, pilotFname, pilotLname, flightNo);
	}
}
