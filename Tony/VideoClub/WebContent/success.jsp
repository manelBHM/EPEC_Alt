<%@page import="beans.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JOptionPane"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style1.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> 

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
	
	
	<c:choose>
		<c:when test="${session == null}">
				<%
				JOptionPane.showMessageDialog(null, "Please Login first", "Info", JOptionPane.INFORMATION_MESSAGE);
				request.getRequestDispatcher("login.jsp").forward(request, response);
				%>
		</c:when>
		
		<c:when test="${x == 0}">
				
				<%
				JOptionPane.showMessageDialog(null, "Your shopping bag is empty", "Info", JOptionPane.INFORMATION_MESSAGE);
				request.getRequestDispatcher("cart.jsp").forward(request, response);
				%>
		</c:when>
		
		<c:when test="${session != null}">
				
				<div class="container" style="margin-top: 60px;margin-bottom: 60px;">
					<h4>Merci ! <font color="#6bb1f8"><c:out value="${name }"></c:out></font> Merci de votre commande chez video club elle sera envoyer à l'adresse suivante <font color="#6bb1f8"><c:out value="${address }"></c:out></font> dans 2-3 jours</h4>
					<h4>La confirmation de la commande sera envoyer sur votre mail  <font color="#6bb1f8"><c:out value="${email }"></c:out></font>.</h4>
					
					<br><br>
					<a href="Controller?page=index"><input type="button" value="Continue Shopping" class="btn btn-warning" style="width:100%;padding:8px;font-size:16px;"></a>
				</div>
			
		</c:when>
	
	</c:choose>
</body>
</html>