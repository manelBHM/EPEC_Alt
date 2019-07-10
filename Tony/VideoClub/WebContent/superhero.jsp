<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<!DOCTYPE html>
<html style = "background: white">
<head>
<meta charset="UTF-8">
<title>VideoClub</title>
<link rel="stylesheet" type="text/css" href="style1.css">
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.4/css/bulma.min.css"> -->

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

	
	<div class="card-deck" style ="background: white;">
	
	<c:forEach items="${list }" var="product">
  
  <c:if test="${product.getCategory() == 'superhero' }">
  
  
  <div class="card" style="background: Silver; margin-left:50px; margin-top:40px">
    <img src="${product.getImage() }" style="width: 200px; height:300px;"class="card-img-top" alt="...">
    <div class="card-body">
   <h5 style="color:white"class="card-title"><c:out value="${product.getName() }"></c:out></h5>
    <p style="color:white"class="card-text"><c:out value="${ product.getPrice() }"></c:out>€</p>
    <a class="btn btn-primary" href="Controller?page=addtocart&action=superhero&id=<c:out value ="${product.getId() }"/>">Ajouter au panier</a>
<%--     <div class = "text-center"><a href="Controller?page=addtocart&action=index&id=<c:out value ="${product.getId() }"/>">Ajouter au panier</a></div> --%>
    
    </div>
  </div>
	</c:if>
  </c:forEach>
  
  </div>

		
		
	<footer>
		<div class="footer"> &copy; Tony Nabil 2019
	      <a href="Controller?page=index"> Video Club</a>
	    </div>
	</footer>

</body>
</html>


 						
 						
 						
	
