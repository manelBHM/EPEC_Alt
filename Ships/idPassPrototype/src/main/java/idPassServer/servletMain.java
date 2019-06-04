package idPassServer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validation.Valider;

/**
 * Servlet implementation class servletMain
 */
public class servletMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public servletMain() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gets into doGet ..1");
		//String servletPath = request.getServletPath();
		//String urlString   = request.getQueryString(); 
		request.getRequestDispatcher("index.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("gets into doPost ..1");
		String userName = request.getParameter("user").toLowerCase();
		String passWord = request.getParameter("pass");
		if(Valider.checkUser(userName, passWord)) {
			System.out.println("Goes through...");
			request.setAttribute("userName", userName);
			request.getRequestDispatcher("loggedIn.jsp").forward(request, response);
		} else {
			System.out.println("user name or password incorrect!");
			request.getRequestDispatcher("opss.jsp").forward(request, response);
		}
		doGet(request, response);
	}

}
