<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue</title>
</head>
<body>

<%

	String loginEntered = (String) request.getAttribute("login");

	String passwordEntered = (String) request.getAttribute("password");

%>

    <h1> BienVenue <%= request.getAttribute("login") %></h1>

 
<hr />
</body>
</html>