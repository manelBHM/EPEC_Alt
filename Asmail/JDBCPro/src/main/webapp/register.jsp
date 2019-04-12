<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*, java.util.*"%>

<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
    <%
    
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCPro", "root", "");
    Statement st = con.createStatement();
    
    String firstname = request.getParameter("firstname");
    String lastname = request.getParameter("lastname");
    String email = request.getParameter("email");
    String userid = request.getParameter("userid");
    String password = request.getParameter("password");
    
    String chooseGenre = "";
    String genre[] = request.getParameterValues("genre");
    for(int i = 0; i< genre.length; i ++){
    	chooseGenre += genre[i]+" ";
    }
    
    String strQuery = "SELECT COUNT(*) FROM users where email='"+email+"'";
    ResultSet rs = st.executeQuery(strQuery);
    rs.next();
    
    String Countrow = rs.getString(1);

    if(Countrow.equals("0")){
        int num = st.executeUpdate("insert into users(firstname,lastname,email,userid,password, genre)values('"+firstname+"','"+lastname+"','"+email+"','"+userid+"','"+password+"', '"+chooseGenre+"')");  
    	 out.println(" Register Successfully");
     } else{
    	 out.println(" Register Error. Username Or Email already exists !");
     }


    try{
    	
    }catch(Exception e){
    	out.print(e.getMessage());
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>