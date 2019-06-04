<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/CSS/errorTwo.css">
	<!-- Font Awesome Icons -->

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
	integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
	crossorigin="anonymous">
</head>
<body>
<div>
	<p>
		le <span>password</span> ne contient pas de caractère spécial<br>
		veuillez saisir un <span>password</span>  avec au moins un caractère spécial
		 <i class="fas fa-exclamation-circle"></i>
	</p>
</div>



	<form action="AuthentificationServlet" method="post">


		<div>

			<label for="pseudo">Pseudo :</label> <input type="text" name="pseudo"
				id="pseudo">
		</div>


		<div>
			<label for="password">Mot de passe :</label> <input type="password"
				name="password" id="password">
		</div>

		<div>
			<button class="btn btn-outline-primary btn-lg" id="myBtn">Submit</button>

		</div>

	</form>

</body>
</html>