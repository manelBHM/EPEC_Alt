<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue !!</title>
</head>
<body>


<% String u = (String)request.getAttribute("username");
	out.println("Bonjour ! " + u);

	%>
</body>
</html>