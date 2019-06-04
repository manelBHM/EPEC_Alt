

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import java.sql.*;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		String _username = request.getParameter("username");
		String _password = request.getParameter("password");
		
		try {
			
			if(_username != null) {
				
				Class.forName("com.mysql.jdbc.driver").newInstance();
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/authentification", "root", "vivania1985");
				
				String Query = "select * from auth where username=? and password=?";
				PreparedStatement psm = conn.prepareStatement(Query);
				psm.setString(1, _username);
				psm.setString(2, _password);
				ResultSet rs = psm.executeQuery();
				
				if(rs.next()) {
					  
					response.sendRedirect("menber.jsp");
					
				} else {
					
					response.sendRedirect("error.jsp");
				}
				
			}
			
		} catch(Exception ex) {
			System.out.println("Exception: " +ex.getMessage());
		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		
//		if(username.equals("java") && password.equals("1234")) {
//		  
//			response.sendRedirect("menber.jsp");
//			
//		} else {
//			
//			response.sendRedirect("error.jsp");
//		}
//		
		//doGet(request, response);
	}
}

