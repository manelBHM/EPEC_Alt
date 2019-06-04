<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/errorOne.css">
	<!-- Font Awesome Icons -->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
</head>
<body>

<div class="content-errorPseudo">
<p>
	le <span>pseudonyme</span> n'as pas été saisi correctement<br>
	veuillez saisi un pseudo <i class="fas fa-exclamation-circle"></i>
	</p>
</div>

	 <form action="AuthentificationServlet" method="post">


		<div>

			<label for="pseudo">Pseudonyme :</label> <input type="text" name="pseudo"
				id="pseudo">
		</div>


		<div>
			<label for="password">Password:</label> <input type="password"
				name="password" id="password">
		</div>

		<div>
			<button class="btn btn-outline-primary btn-lg" id="myBtn">Submit</button>

		</div>



</body>
</html>