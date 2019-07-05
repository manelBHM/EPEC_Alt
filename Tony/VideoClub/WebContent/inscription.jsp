<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Page d'inscription</title>
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 

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
	 	<h2>Crée un compte chez VideoClub</h2>
	 </div>

	 
	 <form method="post" action="Controller">
	 
	 <input type="hidden" name="page" value="formulaire">
	 
	 
  <div class="form-row">
  
      <div class="form-group col-md-6">
      <label for="inputCity">Nom</label>
      <input name="name" type="text" class="form-control" id="inputCity" placeholder="Nom" value="<c:out value="${name }"></c:out>"required>
    </div>
  
  
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input name ="email"type="email" class="form-control" id="inputEmail4" placeholder="Email"value="<c:out value="${email }"></c:out>"required>
    </div>
    
    
    
    <div class="form-group col-md-6">
      <label for="inputPassword4">Nom de Compte</label>
      <input name="username" type="text" class="form-control" id="inputPassword4" placeholder="Nom de compte"value="<c:out value="${username }"></c:out>"required>
    </div>
  </div>


    <div class="form-group col-md-6">
      <label for="inputCity">Adresse</label>
      <input name="address" type="text" class="form-control" id="inputCity" placeholder="Adresse" value="<c:out value="${name }"></c:out>"required>
    </div>

  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">Mot de passe</label>
      <input name="password_1" type="text" class="form-control" placeholder="Mot de passe" id="inputCity">
    </div>
   
    <div class="form-group col-md-6">
      <label for="inputZip">verification mdp</label>
      <input name="password_2" type="text" class="form-control" placeholder="Verification du mot de passe"id="inputZip">
    </div>
  </div>

   
  <button name="register" type="submit" class="btn btn-primary">Crée le compte</button>
  
  <p>
	 		Déja un compte ? <a href="Controller?page=login" style="color:#F24638;">Connexion !</a>
	 	</p>
</form>


	 
	 
	 

	 					
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	 
</body>
</html>