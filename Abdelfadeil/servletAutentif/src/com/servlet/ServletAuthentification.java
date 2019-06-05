package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletAuthentification
 */
//@WebServlet("/ServletAuthentification")
@WebServlet (name="ServletAuthentification", urlPatterns= {"/Authentifier"})
public class ServletAuthentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAuthentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("authentification.html").forward(request, response);
		
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		
		String username=request.getParameter("username");  
		String password=request.getParameter("password"); 
		

			
			if((username.equals("admin"))&&(password.equals("1234")))
			{
				request.getRequestDispatcher("/bienvenue.jsp").forward(request, response);				
			}else {
				request.getRequestDispatcher("/authentification.html").forward(request, response);
				
			
			}
		
	}

}
