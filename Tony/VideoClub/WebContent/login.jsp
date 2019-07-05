<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONNEXION</title>
<link rel="stylesheet" type="text/css" href="style.css">

<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>


	<c:set var="x" value="0"></c:set>
	<c:forEach items="${cartlist }" var="i">
		<c:set var="x" value="${x+1 }"></c:set>
	</c:forEach>


    <div class="block">
        <header class="header1" style="background: DarkSlateGray">
            <a href="Controller?page=index" class="header-logo">VideoClub</a>
           
           
            <nav class="header-menu">
                <a href="Controller?page=index">Accueil</a>
                <c:choose>
           	<c:when test="${session == null}">
						<a href="Controller?page=login">Connexion</a>
						<a href="Controller?page=inscription">Inscription</a>
					</c:when>
					<c:when test="${session != null}">
						<a href="Controller?page=logout" style="color: #F24638;">Deconnexion</a>
						<a href="#">Mon Compte(<c:out value="${username }"></c:out>)</a>
					</c:when>
                </c:choose>
                <a href="Controller?page=showcart">Panier(<c:out value="${x}"/>)</a>
            </nav>
        </header>
    </div>

	<div class="signup-header" style="background: DarkSlateGray">
	 	<h2>Connexion chez Video Club</h2>
	</div>
	 
	 <form method="post" action = "Controller" >
	 
	 <input type="hidden" name="page" value="login-form">
  <div class="form-group">
    <label for="exampleInputEmail1">Nom de compte</label>
    <input type="text" name="username"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nom de compte" value="<c:out value="${username }"></c:out>">

  </div>
  <div class="form-group">
  <font color="#F24638"><c:out value="${msg }"></c:out></font>
    <label for="exampleInputPassword1">Mot de passe</label>
    <input type="password" name="password"  class="form-control" id="exampleInputPassword1" placeholder="Mot de passe">
  </div>
  
  <button type="submit" name="login" class="btn btn-primary">Connexion</button>
</form>

	 
					
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>