package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import DataBase.DB;
import beans.Product;
import beans.User;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	ArrayList<Product> list = new ArrayList<>();
	static ArrayList<String> cartlist = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	HttpSession session;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String page = request.getParameter("page");
		if(page == null || page.equals("index")) {
			// appel de la DataBase TRY CATCH
			DB db = new DB();
			
			
			try {
				
				list = db.fetch();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			session = request.getSession();
			session.setAttribute("cartlist", cartlist);
			session.setAttribute("list", list);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		
		}
		
		else {	
			doPost(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String page = request.getParameter("page");
		
		if(page.equals("login")) {
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		if(page.equals("inscription")) {
		
			request.getRequestDispatcher("inscription.jsp").forward(request, response);
		
		}
		
		// incription part "formulaire"
		if(page.equals("formulaire")) {
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String address = request.getParameter("address");
			String password_1 = request.getParameter("password_1");
			String password_2 = request.getParameter("password_2");
			
			
			if (password_1.equals(password_2)){
				User user = new  User();
				user.setAddress(address);
				user.setEmail(email);
				user.setName(name);
				user.setUsername(username);
				user.setPassword(password_1);
				
				// appel de la DataBase TRY CATCH
				DB db = new DB();
				try {
					db.addUser(user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("username", username);
				request.setAttribute("msg", "Compte crée avec succés!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			
			}
			
			else {
				request.setAttribute("msg", "Les mots de passe ne sont pas identique");
				request.setAttribute("name", name);
				request.setAttribute("adress", address);
				request.setAttribute("email", email);
				request.setAttribute("username", username);
				request.getRequestDispatcher("inscription.jsp").forward(request, response);
				
			}
		}
		
	if(page.equals("login-form")) {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			DB db = new DB();
			User user = new User();
			boolean status = false;
			try {
				status = db.checkUser(username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status) {
				session = request.getSession();
				session.setAttribute("session", session);
				
				try {
					userList = db.fetchUser();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				session.setAttribute("address", user.fetchadd(userList,username));
				session.setAttribute("email", user.fetchemail(userList,username));
				session.setAttribute("name", user.fetchname(userList,username));
				session.setAttribute("username", username);
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else {
				request.setAttribute("msg", "Mauvais mot de passe");
				request.setAttribute("username", username);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			

			
		}
		// condition deconnexioon
		if(page.equals("logout")) {
			session = request.getSession();
			session.invalidate();;
			
			session = request.getSession();
			
			// supprimer la cart list a la deconnexion
			cartlist.clear();
			session.setAttribute("cartlist", cartlist);
			session.setAttribute("list", list);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		// afficher panier
		if(page.equals(("showcart"))) {
			
			request.getRequestDispatcher("Panier.jsp").forward(request, response);
	
		}
		// ajouter panier
		if(page.equals("addtocart")) {
			String id = request.getParameter("id");
			String action = request.getParameter("action");
			Product p = new Product();
			boolean check = p.check(cartlist,id);
			
			
			if(check)
				JOptionPane.showMessageDialog(null, "Produit déja dans le panier", "Info", JOptionPane.INFORMATION_MESSAGE);
			
			else {
			cartlist.add(id);
			JOptionPane.showMessageDialog(null, "Produit ajouter avec succes !", "Info", JOptionPane.INFORMATION_MESSAGE);
			
			}
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
		if(page.equals("success")) {
			
			request.getRequestDispatcher("success.jsp").forward(request, response);
			
		}
		if(page.equals("remove")) {
			String id = request.getParameter("id");
			Product p = new Product();
			cartlist = p.remove(cartlist,id);
			
			session = request.getSession();
			session.setAttribute("cartlist", cartlist);
			request.getRequestDispatcher("Panier.jsp").forward(request, response);
			
			
		}
		
		if(page.equals("artmartiaux") || page.equals("anime") || page.equals("superhero"))
//				|| page.equals("all-products"))
				
		{
			DB db = new DB();
			 try {
				list = db.fetch();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("list", list);
			
			if(page.equals("artmartiaux"))
				request.getRequestDispatcher("artmartiaux.jsp").forward(request, response);
			if(page.equals("anime"))
				request.getRequestDispatcher("anime.jsp").forward(request, response);
			if(page.equals("superhero"))
				request.getRequestDispatcher("superhero.jsp").forward(request, response);
//			if(page.equals("all-products"));
//			request.getRequestDispatcher("all-products.jsp").forward(request, response);

		}
		
		
//		doGet(request, response);
	}

}
