<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="cpro.alternant.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CAMPUS-ALTERNANT SIMPLON IDF</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/app.css">
</head>
<body>

<h1>Welcome to CAMPUS ALTERNANT SIMPLON IDF</h1>

<nav>

<ul>

<li><a>Formulaire</a></li>
<li><a href=http://localhost:8080/Alternant/Controller">Accueil</a></li>

</ul>

</nav>

<form action="Controller" method="post">

<label for="nom">Nom :</label>
<input type="text" name="nom" id="nom">

<br>

<label for="prenom">Prenom :</label>
<input type="text" name="prenom" id="prenom">


<br>

<label for="naissance">Naissance :</label>
<input type="datetime" name="naissance" id="naissance">



<br>

<label for="entreprise">Entreprise :</label>
<input type="text" name="entreprise" id="entreprise">



<br>

<label for="img">Image :</label>
<input type="file" name="img" id="img">
<br>
<button>Valide</button>

</form>


<%
   List<Alternant> list = (ArrayList)request.getAttribute("alternant");

     for(Alternant a : list)
     {	 
    	 out.print(a.getImg()+"<br><br>");
    	 %>
    	
     <img src= <%="image/" + a.getImg()%>>
     <% 
     }
%>

</body>
</html>