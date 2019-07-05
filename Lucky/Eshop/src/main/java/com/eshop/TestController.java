package com.eshop;

import java.util.*;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestController
 */
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Product> productList = new ArrayList<Product>();


	/**
	 * Default constructor. 
	 */
	public TestController() {
		// TODO Auto-generated constructor stub

	}




	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub

		DaoClass d = new DaoClass();


		try {
			productList = d.getAllProducts();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}





	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setAttribute("produit", productList);
		
		String q = request.getQueryString();
		
				
			String 	test = request.getParameter("products");
		
	         request.setAttribute("test", q);

		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		/*
		 * Bout de cote pour send une data image a la base de donnée
		 * 
		 *  String x = request.getParameter("img");

		  DaoClass s = new DaoClass(); 

		  s.saveInBDD("test", "img.src", 12000, x);*/


	}

}