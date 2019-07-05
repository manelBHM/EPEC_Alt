<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADMIN CONNECTION</title>

<link rel="stylesheet" type="text/css" href="style.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


</head>
<body>

<!-- <form method="post" action="AdminController"> -->

<!-- 	 <input type="hidden" name="page" value="admin-login-form"> -->

<%-- 	 	<font color="#F24638"><c:out value="${msg }"></c:out></font> --%>
	
<!-- Username : <input type ="text" name="username"> -->
<!-- Password : <input type= "password" name="password"> -->

<!-- <button> connection </button> -->

<!-- </form> -->

	 <form method="post" action = "AdminController" style="margin-top: 30px";>
	 
	 <input type="hidden" name="page" value="admin-login-form">
  <div class="form-group">
    <label for="exampleInputEmail1">Nom de compte admin</label>
    <input type="text" name="username"  class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Nom de compte admin" value="<c:out value="${username }"></c:out>">

  </div>
  <div class="form-group">
  
    <label for="exampleInputPassword1">Mot de passe</label>
    <input type="password" name="password"  class="form-control" id="exampleInputPassword1" placeholder="Mot de passe">
  </div>
  
  <button type="submit" name="login" class="btn btn-primary">Connexion</button>
</form>
</body>
</html>