package com.RunApp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DAO.FlightDao;
import com.DBUtils.DBConnector;
import com.Entity.Flights;

public class RunApp {

	public static void main(String[] args) {
		Connection connection = DBConnector.getConnection();
		FlightDao flDao = new FlightDao();
		List<Flights> displayFlights = new ArrayList<Flights>(); 
				try {
					displayFlights = flDao.getByPilot("Jack");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
		for(Flights f: displayFlights) {
			System.out.println("Flight no is : " + f.getFlightNo());
		}
		
//		try {
//			
//			flDao.update(1, "London", "Japan", 1, 1, "XD108");
//			//System.out.println("id :" + f.getId() + " from : " + f.getDepart());
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
	}

}
