<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
<p><%
            String login = (String) request.getAttribute("loginEntered");
            String password = (String) request.getAttribute("passwordEntered");
      %><p>
</body>
</html>