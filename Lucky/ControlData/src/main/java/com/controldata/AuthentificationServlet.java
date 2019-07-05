package com.controldata;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AuthentificationServlet
 */
public class AuthentificationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**download apache tomcat 7 for windows 64
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthentificationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.sendRedirect("authentification.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String tabPseudo [] = {"lucky", "stan"};
		String 	pseudo = request.getParameter("pseudo");

		String password = request.getParameter("password");

		request.setAttribute("pseudo", pseudo);

		if(!pseudo.isEmpty() && password.contains("@") || !pseudo.isEmpty() && password.contains("&") || !pseudo.isEmpty() && password.contains("%")|| !pseudo.isEmpty() && password.contains("^"))	
		{
			this.getServletContext().getRequestDispatcher("/authentification.jsp").forward(request, response);
		}
		else if(pseudo.isEmpty())
		{
			response.sendRedirect("pseudoIsEmpty.jsp");	
		}
		else if(!password.contains("@"))
		{
			response.sendRedirect("passwordFail.jsp");
		}
		else 
		{
			response.sendRedirect("/index.jsp");
		}

	}

}
