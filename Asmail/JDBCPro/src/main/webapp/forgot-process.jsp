<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCPro", "root", "");
	Statement st = con.createStatement();
	
	String email = request.getParameter("email");
	String strQuery = "SELECT password FROM users WHERE email='"+email+"'";
	
	ResultSet rs = st.executeQuery(strQuery);
	rs.next();
	
	String countRow = rs.getString(1);
	if(countRow.equals("1")){
		
	}
	
	
}catch(Exception e){
	out.println(e);
}

%>

</body>
</html>