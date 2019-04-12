<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.sql.*,java.util.*"%>
    <%@page import="com.drmas.myConnection" %>

<%
String userid = request.getParameter("userid");
//session.putValue("userid", userid);
String password = request.getParameter("password");


Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/JDBCPro", "root", "");

Statement st = con.createStatement();
ResultSet rs=st.executeQuery("select * from users where password='"+password+"'"); 
try{
	rs.next();
	if(rs.getString("password").equals(password) && rs.getString("userid").equals(userid)){
		out.println("Welcome : "+userid);
	}else{
		out.println("Cannot Login Password Or Username Invalid ! ");	
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
