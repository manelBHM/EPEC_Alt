

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Authentification
 */
public class Authentification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Authentification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Bienvenue.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String loginEntered = (String) request.getParameter("identifiant");
		
		String passwordEntered = (String) request.getParameter("motdepasse");
		
		
		System.out.println(loginEntered);
		if ( loginEntered != null && passwordEntered != null) {
			request.setAttribute("user", loginEntered);
			System.out.println("good");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		//request.setAttribute("erreur", "Vous devez remplir les deux champs.");
		
		/*getServletContext().getRequestDispatcher("/Bienvenue.jsp").forward(request, response);*/
		
		}

		else {
		
		request.setAttribute("identifiant", loginEntered);
		
		request.setAttribute("motdepasse", passwordEntered);
		
		getServletContext().getRequestDispatcher("/Bienvenue.jsp").forward(request, response);
		
		}
		
	}

}
