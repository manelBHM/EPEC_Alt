<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Produit</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>

		<header>
		<h1>
			Modifier produit
		</h1>
		<nav>
			<ul>
				<li><a href="AdminController?page=index">Home</a></li>
				<li><a href="AdminController?page=addProduct">Add Product</a></li>
				
			</ul>
		</nav>
	</header>
	
	<div class="signup-header">
	 	<h2>Edit Produit</h2>
	 </div>

	 <form method="post" action="AdminController">
	 
	 <input type="hidden" name="page" value="edit_product">
	 <input type="hidden" name="id" value="<c:out value="${p.getId() }"/>">
     
	 	<div class="signup-group">
	 		<label>Nom du produit</label>
	 		<input type="text" name="name" value="<c:out value="${p.getName() }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Prix</label>
	 		<input type="text" name="price" value="<c:out value="${p.getPrice() }"></c:out>" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Categorie</label>
	 		<input type="text" name="category" value="<c:out value="${p.getCategory() }"></c:out>" required>
	 	</div>
	 	
	 	<div class="signup-group">
	 		<label>Produit vedette </label>
	 		<input type="text" name="featured" value="<c:out value="${p.getFeatured() }"></c:out>" required>
	 	</div>
	 
	 	<div class="signup-group">
			<input type="submit" value="Process">	 
		</div>
	 </form>
</body>
</html>