package cpro.alternant;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Alternant> listAlternant = new ArrayList<Alternant>();

	/**
	 * Default constructor. 
	 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}



	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		Dao d = new Dao();

		try {
			listAlternant = d.getAlternant();
			
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
		//	response.getWriter().append("Served at: ").append(request.getContextPath());


		request.setAttribute("alternant", listAlternant);


		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Dao save = new Dao();

		String n = request.getParameter("nom");
		String p = request.getParameter("prenom");
		String b = request.getParameter("naissance");
		String e = request.getParameter("entreprise");
		String i = request.getParameter("img");
		
		save.saveAlternant(n, p, b, e, i);
		
	}

}