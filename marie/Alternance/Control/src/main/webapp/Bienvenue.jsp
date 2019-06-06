<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bienvenue</title>
</head>
<body>
<h1>Authentification - Client</h1>
<form action="Authentification" method="POST">
<table border="1" cellspacing="0" cellpadding="5">
<tr>
<td>Identifiant/Login : </td>
<td><input type="text" name="identifiant" id="identifiant"
value="" size="20" required/></td>
</tr>
<tr>
<td>Mot de passe : </td>
<td><input type="password" name="motdepasse" id="motdepasse"
value="" size="20" required/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit"
name="valider" id="valider" value="Valider"/></td>
</tr>
</table>
</form>
</body>
</html>