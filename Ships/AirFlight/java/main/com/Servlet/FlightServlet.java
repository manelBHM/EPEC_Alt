package com.Servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.FlightDao;
import com.Entity.Flights;



/**
 * Servlet implementation class FlightServlet
 */
public class FlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FlightDao flightDao = new FlightDao();
	Flights f;
    List<Flights>flightsList = new ArrayList<Flights>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FlightServlet() {
        super();
    }
    
	@Override
	public void init() throws ServletException {
		try {
			flightsList  = flightDao.getAll();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gets into doGet ..1");
		String path = request.getServletPath();
		init();
		String urlString = request.getQueryString();
		List<Flights> flList = new ArrayList<Flights>();
		if(urlString != null) {
			String[] splitsAnd = urlString.split("&");
			Map<String, String> params = new HashMap<String, String>();
			params.clear();
			for(String element : splitsAnd) {
				String[] splitsEqual = element.split("=");
				if(splitsEqual.length == 2) {
					params.put(splitsEqual[0], splitsEqual[1]);
				}
				Map.Entry<String,String> entry = params.entrySet().iterator().next();
				
				String check = entry.getKey();
				switch(check) {
					case "fligthNo": 
						String flightNo = entry.getValue();
						try {
							Flights	f = flightDao.getByFlight(flightNo);
							flList.add(f);
							request.setAttribute("flList", flList);
							request.getRequestDispatcher("/filtered.jsp").forward(request, response);
						} catch (SQLException e) {
							e.printStackTrace();
						} break;
						
					case "depart":
						String depart = entry.getValue().toLowerCase();
						try {
							flList = flightDao.getByDepart(depart);
							request.setAttribute("flList", flList);
							request.getRequestDispatcher("/filtered.jsp").forward(request, response);
						} catch (SQLException e) {
							e.printStackTrace();
						} break;
						
					case "arrive":
						String arrive = entry.getValue().toLowerCase();
						try {
							flList = flightDao.getByArrival(arrive);
							request.setAttribute("flList", flList);
							System.out.println(flList.size());
							request.getRequestDispatcher("/filtered.jsp").forward(request, response);
						} catch (SQLException e) {
							e.printStackTrace();
						} break;
						
					case "pilotName":
						String pilotName = entry.getValue().toLowerCase();
						try {
							flList = flightDao.getByPilot(pilotName);
							request.setAttribute("flList", flList);
							request.getRequestDispatcher("/filtered.jsp").forward(request, response);
						} catch (SQLException e) {
							e.printStackTrace();
						} break;
					case "id_delete":
						String id_delete  = entry.getValue();
						int id_delete_int = Integer.parseInt(id_delete);
						try {
							flightDao.deleteFlight(id_delete_int);
							init();
							request.setAttribute("flightsList", flightsList);
							request.getRequestDispatcher("index.jsp").forward(request, response);
							
						} catch(SQLException e) {
							e.printStackTrace();
						} break;
					case "id_edit":
						String id_edit  = entry.getValue();
						request.setAttribute("id_Str", id_edit);	
						request.getRequestDispatcher("editFlights.jsp").forward(request, response);
						break;
				}
				flList.clear();
			}
		} else if(path.equals("/FlightServlet")) {
			
			System.out.println(path);
			request.setAttribute("flightsList", flightsList);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			System.out.println("else if");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post...");
		String id_edit  = request.getParameter("id_edit");
		String depart  	 = request.getParameter("depart");
		String arrive   	 = request.getParameter("arrive");
		String plane    	 = request.getParameter("plane");
		int planeNo		= Integer.parseInt(plane);
		String pilot 	 = request.getParameter("pilot");
		int pilotNo		= Integer.parseInt(pilot); 
		String flNo 		  	 = request.getParameter("flightNo");
			System.out.println(id_edit);
			if(id_edit == null) {
				try {
					flightDao.createFlight(depart, arrive, planeNo, pilotNo, flNo);
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			doGet(request, response);
		}

}
