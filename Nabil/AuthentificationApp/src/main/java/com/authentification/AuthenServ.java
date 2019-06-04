package com.authentification;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AuthentServlet
 */
public class AuthenServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/Authentification.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginEntered = (String) request.getParameter("identifiant");

		String passwordEntered = (String) request.getParameter("motdepasse");
		

		if (loginEntered=="") {
			String Erreur = "Veuillez remplir le formulaire";

			request.setAttribute("Error", Erreur);
			this.getServletContext().getRequestDispatcher("/Authentification.jsp").forward(request, response);

		}
		else {
		
		request.setAttribute("login", loginEntered);
		request.setAttribute("password", passwordEntered);
		getServletContext().getRequestDispatcher("/bienvenue.jsp").forward(request, response);

		doGet(request, response);
		}
	}

}



