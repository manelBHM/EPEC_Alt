package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import DataBase.DB;
import beans.Product;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String page = request.getParameter("page");
		if (page == null) {
		request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			
		}else {
			doPost(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	
	{
		// TODO Auto-generated method stub

		// affichage de la page admin.
		String page = request.getParameter("page");
		if(page.equals("admin-login-form"))
		{
			
		
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if(username.equals("admin") && password.equals("1234")) {
//			response.sendRedirect("admin/index.jsp");
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
//			HttpSession session = request.getSession();
//			session.setAttribute("username", username);
//			session.setAttribute("password", password);
			
			}
			else {
				request.setAttribute("msg", "Mauvais mot de passe");
				request.setAttribute("username", username);
				request.getRequestDispatcher("admin/login.jsp").forward(request, response);
			}
			
		}
		
		// option delete
		
		if(page.equals("delete")) {
			String id = request.getParameter("id");
			DB db = new DB();
			try {
				db.deleteProduct(id);
			} catch(SQLException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Le Produit a été supprimer", "Info", JOptionPane.INFORMATION_MESSAGE);
		request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		
//		
		if(page.equals("index")) {
			
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		
		if(page.equals("addProduct")) {
//			response.sendRedirect("admin/addproduct.jsp");
			request.getRequestDispatcher("admin/addproduct.jsp").forward(request, response);
		}
		
		if(page.equals("edit")) {

			String id = request.getParameter("id");
			DB account = new DB();
			Product p = null;
			
			try {
				p = account.fetchProduct(id);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			request.setAttribute("p", p);
			request.getRequestDispatcher("admin/editProduct.jsp").forward(request, response);;
		}

		
		if(page.equals("edit_product")){
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String featured = request.getParameter("featured");
			Product p = new Product();
			p.setId(Integer.parseInt(id));
			p.setName(name);
			p.setPrice(price);
			p.setCategory(category);
			p.setFeatured(featured);
			
			DB account = new DB();
			try {
				account.updateProduct(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Le produit a été modifier avec succes !", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
		
		if(page.equals("add_product")){
			String name = request.getParameter("name");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			String featured = request.getParameter("featured");
			// test ajout d'image si bug c a cause de sa.
			String image = request.getParameter("image");
			Product p = new Product();
			p.setName(name);
			p.setPrice(price);
			p.setCategory(category);
			p.setFeatured(featured);
			p.setImage("image/"+image);

		
			DB account = new DB();
			try {
				account.addProduct(p);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Le produit a été ajouter avec succes !", "Info", JOptionPane.INFORMATION_MESSAGE);
			request.getRequestDispatcher("admin/index.jsp").forward(request, response);
		}
	}

}