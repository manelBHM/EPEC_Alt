<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html>
<html>
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
        <header class="header">
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

	
<div class="bd-example">
  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
 
    <div class="carousel-inner">
      <div class="carousel-item active">
       <a href="Controller?page=superhero"><img src="https://cdn.wallpapersafari.com/20/9/RWNgX1.jpg"class="d-block w-100" alt="..."></a>
        <div class="carousel-caption d-none d-md-block">
          <h5>Super Hero</h5>
          <p>Achetez les derniers films de vos super héros préferé !</p>
        </div>
      </div>
      <div class="carousel-item">
        <a href="Controller?page=anime"><img src="https://images-eds-ssl.xboxlive.com/image?url=8Oaj9Ryq1G1_p3lLnXlsaZgGzAie6Mnu24_PawYuDYIoH77pJ.X5Z.MqQPibUVTcgaPE0QROsKtCEjE7t9tEsxEeCrSfhEAPNlK_nxBo1tcFX6OEADWMvXf7GU.XNMSVtcLPB._Mut56A5VqL.gN.1e53.r._5j31w8Ebtc3DClp0laSuB0dR3A9z2tcOuEObIhEcEL4DsT1lXMxko8yDmJelhPpn8fN0cxJmW0wJx8-&h=1080&w=1920&format=jpg" class="d-block w-100" alt="..."></a>
        <div class="carousel-caption d-none d-md-block">
          <h5>Animation</h5>
          <p>Achetez toutes les saisons de vos dessins animés préféré !</p>
        </div>
      </div>
      <div class="carousel-item">
       <a href="Controller?page=artmartiaux"> <img src="https://stmed.net/sites/default/files/bruce-lee-wallpapers-26502-9260838.jpg" class="d-block w-100" alt="..."></a>
        <div class="carousel-caption d-none d-md-block">
          <h5>Art Martiaux</h5>
          <p>Achetez tous les films d'art martiaux préféré !</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>


		
 					
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>