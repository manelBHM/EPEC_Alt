<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.sql.*" %>
     
     <%
 	Class.forName("com.mysql.jdbc.Driver");
 	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCPro", "root", "");
 	Statement st = con.createStatement();
 	
 	String roll_no = request.getParameter("roll_no");
     %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Search Data</h1>
<table border="1">
<tr>
<td>ID:</td>
<td>Firstname</td>
<td>Lastname</td>
<td>Email</td>
<td>Username</td>
<td>Passord</td>
</tr>
<%
try{
	String sql = "SELECT * FROM users WHERE firstname='"+roll_no+"'";
	ResultSet rs = st.executeQuery(sql);
	while(rs.next()){ %>
	
	<tr>
	<td><%= rs.getString("id") %></td>
	<td><%= rs.getString("firstname") %></td>
	<td><%= rs.getString("lastname") %></td>
	<td><%= rs.getString("email") %></td>
	<td><%= rs.getString("userid") %></td>
	<td><%= rs.getString("password") %></td>
	
	</tr>
	
	<%
	
	}
	con.close();
}catch(Exception e){
	
}

%>


</table>
</body>
</html>