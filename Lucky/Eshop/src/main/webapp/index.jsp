<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.eshop.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lucky Online EShop Store</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">


<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/app.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	
	
	<!-- Fontawesome Cdn -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">



<!-- Google Font Cdn -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
 



</head>
<body>



	<header>


		<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo01"
				aria-controls="navbarTogglerDemo01" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo01">

				<ul class="navbar-nav mr-auto mt-2 mt-lg-0">

					<li class="nav-item active"><a class="nav-link"
						href="http://localhost:8080/Eshop/TestController"><i class="fas fa-home"></i></a>
					</li>


				</ul>


				<div>
					<a class="nav-link mr-sm-2" href="#"><i class="fas fa-shopping-cart"></i></a>
				</div>
			</div>
		</nav>




		<!-- CARROUSEL CARROUSEL CARROUSEL -->

		<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/samsung.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/samsung.jpg" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="images/samsung.jpg" class="d-block w-100" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>

	</header>



	<main class="container">


	<h1>Welcome to my Eshop Store</h1>

	<section class="row">
	
	<form action="#" method="get" class="row">

		<%
			List<Product> prod = (ArrayList) request.getAttribute("produit");

			for (Product p : prod) {
		%>


		<div class="card-deck">



			<div class="card"  id="card_content">

				<img src=<%="images/" + p.getImg()%> class="card-img-top img-fluid" id="images" alt=<%=p.getName()%>>



				<div class="card-body">

					<h5 class="card-title">
						<%=p.getName()%></h5>


					<p class="card-text"><%=p.getDescription()%>.
					</p>


					<p
					
				
					 class="card-text"><%=p.getPrice()%>
						€
					</p>

	            <div class="card-footer qte col" <%if(p.getQuantite()<5){%>style="color: red"<%}%>>
	           
						<%=p.getQuantite()%>
						- En stock
						
					</div>


					<button class="btn btn-outline-success" id="btn" name="products" value=<%=p.getName()+"&prix="+p.getPrice()%>>Ajouter au panier</button>

				</div>
			</div>

		</div>
	

		<%
			}
		%>
		</form>
	</section>
	
	
	<%
	
	String t = (String)request.getAttribute("test");
	out.println(t);
	%>
	</main>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>