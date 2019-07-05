package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import beans.Product;
import beans.User;

public class DB {

	
	private String username = "root";
	private String password = "Packard77";
	private String dbName = "eshop";
	private String url = "jdbc:mysql://localhost:3306/" + dbName;
	private String driver = "com.mysql.jdbc.Driver";
	
	
	ArrayList<Product> list = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	
	private Connection con ;
	
	// methode pour ce connecter a la database
	private void dbConnect() {
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	// methode pour close la database
	private void dbClose() {
		
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addUser(User user) throws SQLException {
		// appel de la methode pour ce connecter a la database.
		dbConnect();
		
		// commande sql ajouter user dans la database
		String sql = "Insert into user(name,email,username,address,password) values(?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, user.getName());
		st.setString(2, user.getEmail());
		st.setString(3, user.getUsername());
		st.setString(4, user.getAddress());
		st.setString(5, user.getPassword());
		
		// pour executer la commande
		st.executeUpdate();
		// appel de la methode pour close la datebase.
		dbClose();
	}
	
	public boolean checkUser(String username, String password) throws SQLException {
		
		// ??????????????,
		dbConnect();
		int count = 0;
		String sql = "Select * from user where username = ? and password = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, username);
		st.setString(2, password);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			count = 1;
		}
		
		dbClose();
		if (count == 0)
			return false;
		
		return true;
	}
	
	
	// Liste pour les produits dans la database 
	public ArrayList<Product> fetch() throws SQLException {
		// Connection database
		dbConnect();
		
		// Commande sql select product
		
		String sql = "Select * from product";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		
		// boucle pour afficher toute les données de la db a la suite
		while (rs.next()) {
			
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String featured = rs.getString("featured");
			String price = rs.getString("price");
			String category = rs.getString("category");
			String image = rs.getString("image");
			
		
			Product p = new Product();
			
			p.setId(id);
			p.setFeatured(featured);
			p.setName(name);
			p.setPrice(price);
			p.setCategory(category);
			p.setImage(image);

			
			// ajoute des données dans une liste ArrayList produit declarer au debut de la classe.
			list.add(p);
			p=null;
		}
		dbClose();
		return list;
	}
		
	public void deleteProduct(String id) throws SQLException {
		
		// Connection database
		dbConnect();
		
		// Commande sql delete product with id
		String sql = "Delete from product where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		st.executeUpdate();
		dbClose();
	}
	
	// Methode pour chercher un produit
	
	public Product fetchProduct(String id) throws SQLException {
		
		// Connection database
		dbConnect();
		
		// Commande sql select product with id
		String sql = "select * from product where id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rst = pstmt.executeQuery();
		Product p = new Product();
		
		while(rst.next()) {
		
		p.setId(rst.getInt("id"));
		p.setName(rst.getString("name"));
		p.setPrice("price");
		p.setCategory("category");
		p.setFeatured("featured");
		p.setImage(rst.getString("image"));
		
		}
		
		dbClose();
		return p;
	}
	
	
	public void updateProduct(Product p) throws SQLException {
		dbConnect();
		String sql = "update product set name=?,price=?,category=?,featured=? where id=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, p.getName());
		st.setString(2, p.getPrice());
		st.setString(3, p.getCategory());
		st.setString(4, p.getFeatured());
		st.setInt(5, p.getId());
		st.executeUpdate();
		dbClose();
	}
	// Methode pour ajouter des produits
	
	public void addProduct(Product p) throws SQLException{
		
		
	// Connection database
		dbConnect();
	
	// Commande sql pour insert dans product
		String sql = "Insert into product(name,price,category,featured,image) values (?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, p.getName());
		st.setString(2, p.getPrice());
		st.setString(3, p.getCategory());
		st.setString(4, p.getFeatured());
		st.setString(5, p.getImage());
	// Execute
		st.executeUpdate();
		dbClose();
	}
	
	
	public ArrayList<User> fetchUser() throws SQLException {
		dbConnect();
		String sql = "Select * from user";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			String address = rs.getString("address");
			String user = rs.getString("username");
			String email = rs.getString("email");
			String name = rs.getString("name");
			int id = rs.getInt("id");
			String password = rs.getString("password");
			
			User u = new User();
			u.setAddress(address);
			u.setEmail(email);
			u.setId(id);
			u.setName(name);
			u.setUsername(user);
			u.setPassword(password);
			userList.add(u);
			u=null;
				
		}
		
		dbClose();
		return userList;
	}
}
