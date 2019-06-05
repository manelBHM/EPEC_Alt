<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Font Awesome Icons -->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">

<style>
p{
border-left: 10px inset darkblue;
	background: darkgreen;
	color: whitesmoke;
	padding: 10px;
	margin-bottom: 50px;
	width: 30%;
	text-align: center;
	font-weight: bold;
}

div {
	margin: 0 auto;
	width: 50%
}

</style>
</head>


<body>

<div>
<p>Authentification Done <i class="fas fa-check"></i></p>
</div>

<% 
String pseudo = (String)request.getAttribute("pseudo");
out.println("Bienvenue " + pseudo + ", Controle Réussi :-) ");
%>

</body>
</html>