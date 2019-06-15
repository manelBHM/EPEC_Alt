<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%

try{
String currentPassword = request.getParameter("current");
String newPassword = request.getParameter("new");
String conPassword = request.getParameter("confirm");


Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCPro", "root", "");

String password = "";
int id = 1;

Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM users WHERE password='"+currentPassword+"'");
while(rs.next()){
	id = rs.getInt(1);
	password = rs.getString("password");
}
System.out.println(id+ " " + password);
if(password.equals(currentPassword)){
	Statement st1 = con.createStatement();
	int i = st1.executeUpdate("UPDATE users SET password='"+newPassword+"' WHERE id='"+id+"'");
	out.println("Password changed successfully !");
	st1.close();
	con.close();
}else{
	out.println("Invalid Current Password");
}

}catch(Exception e){
	out.println(e);
}
%>