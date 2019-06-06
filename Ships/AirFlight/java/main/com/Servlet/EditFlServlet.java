package com.Servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.FlightDao;

/**
 * Servlet implementation class EditFlServlet
 */
public class EditFlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    FlightDao flDao = new FlightDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditFlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("FlightServlet").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post...editPerson");
		String id_edit		 = request.getParameter("id_edit");
		int id_edit_int		 = Integer.parseInt(id_edit);
		String depart  	 	 = request.getParameter("depart");
		String arrive   	 = request.getParameter("arrive");
		String plane    	 = request.getParameter("plane");
		int planeInt		 = Integer.parseInt(plane);
		String pilot 	 	 = request.getParameter("pilot");
		int pilotInt		 = Integer.parseInt(pilot);
		String flNo   	     = request.getParameter("flightNo");
		
			
		
		
		System.out.println(id_edit_int);
			//Editing person details in the database -
		try {
			flDao.update(id_edit_int, depart, arrive, planeInt, pilotInt, flNo);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
