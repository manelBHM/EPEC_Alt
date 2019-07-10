<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Ajouter Produit</title>

<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<h1>
			Ajouter ADMIN
		</h1>
		<nav>
			<ul>
				<li><a href="AdminController?page=index">Home</a></li>
				<li><a href="AdminController?page=addProduct">Add Product</a></li>
				
			</ul>
		</nav>
	</header>
	
	<div class="signup-header">
	 	<h2>Add Product</h2>
	 </div>

	 <form method="post" action="AdminController">
	 
	 <input type="hidden" name="page" value="add_product">
     
	 	<div class="signup-group">
	 		<label>Nom Produit</label>
	 		<input type="text" name="name" placeholder="Nom Produit"  required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Prix</label>
	 		<input type="text" name="price" placeholder="Prix" required>
	 	</div>
	 	<div class="signup-group">
	 		<label>Categorie</label>
	 		<input type="text" name="category" placeholder="superhero / anime / artmartiaux" required>
	 	</div>
	 	
	 	<div class="signup-group">
	 		<label>Produit vedette</label>
	 		<input type="text" name="featured" placeholder="yes/no" required>
	 	</div>
	 	
	 	 	<div class="signup-group">
	 		 <label for="fileupload"> Selectionner une image</label>
	 		<input type="file" name="image" required><br>
	 		</div>
	 	<div class="signup-group">
			<input type="submit" value="Process">	 
		</div>
	 </form>
</body>
</html>