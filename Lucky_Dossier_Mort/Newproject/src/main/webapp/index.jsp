<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	
	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/app.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


</head>
<body>




	<main class="container">

	<h1>Hello world</h1>

	<section>

		<article>

<form action="TestController">



</form>




			<%
			List<Product> prod = (ArrayList) request.getAttribute("produit");
			

			for (Product p : prod) { out.println(p.getImg());%>

			<div class="card" style="width: 15rem;">
			
			
				<img src=<%="images/"+p.getImg()%> class="card-img-top" alt="...">
				
				<div class="card-body">

					<h5 class="card-title">
						<%=p.getName()%></h5>
					<br>

					<p class="card-text"><%=p.getDescription()%>.
					</p>
					<br>
					
						<p class="card-text"><%=p.getPrice()%> €
					</p>
					<br>

					<button type="button" class="btn btn-success">Ajouter au
						panier</button>

				</div>
			</div>
			<br>

			<%
				}
			%>

		</article>


	</section>

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