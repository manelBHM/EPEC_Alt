<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin INDEX</title>
<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
	
	<header>
	<h1> ADMIN</h1>
	
		<nav>
			<ul>
				<li><a href="AdminController?page=index">Accueil</a></li>
				<li><a href="AdminController?page=addProduct">Ajouter Produit</a></li>
				
			</ul>
		</nav>
	</header>
	
	 <sql:setDataSource 
	 user="root" password="Packard77" 
	 driver="com.mysql.jdbc.Driver" 
	 url="jdbc:mysql://localhost:3306/eshop"
	 var="ds"/>
	 
	  <sql:query  var="result" dataSource="${ds }">
 
		 select * from product
		 
	   </sql:query>
	
		<div class="container">
	<h2>Liste des Produits</h2>
		 <table>
			<tr>
			<th style="width:80px;">ID</th>
			<th style="width:100px;">Name</th>
			<th style="width:100px;">Prix</th>
			<th style="width:100px;">Categorie</th>
			
			<th>Option</th>
		</tr>
	</table>
		
		 <c:forEach items="${result.rows }" var="row">
		  <table style="table-layout: fixed;width: 100%;">
		  	
				<tr>
					<td style="width: 50px;"><c:out value="${row.id }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.name }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.price }"></c:out></td>
					<td style="width: 100px;"><c:out value="${row.category}"/></td>
					<td style="width: 100px;"><img src="${row.image}" height="100" width="70" ></td>
					
			
					
					<td style="width: 100px;">
					
					<a href="<%= request.getContextPath() %>/AdminController?page=edit&id=${row.id}" style="color: #6bb1f8;">edit</a> ||
					<a href="<%= request.getContextPath() %>/AdminController?page=delete&id=${row.id}" style="color:#6bb1f8;">delete</a>
					
					</td>
				</tr>
			</table>
		 </c:forEach>
		 </div>

</body>
</html>