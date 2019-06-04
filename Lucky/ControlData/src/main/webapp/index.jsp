<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<p>Le password doit contenir obligatoirement le caractère
		spécial @</p>
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