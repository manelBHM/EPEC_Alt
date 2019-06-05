<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> <title>Authentification</title>
</head>
<body>
<h1>Authentification - Client</h1>
<form action="AuthenServ" method="POST">

<%  
	 String Myerror = (String) request.getAttribute("Error");
%>

 <h1><%= Myerror %></h1>
<table border="1" cellspacing="0" cellpadding="5">
<tr>
<td>Identifiant/Login : </td>
<td><input type="text" name="identifiant" id="identifiant"
value="" size="20"/></td>
</tr>
<tr>
<td>Mot de passe : </td>
<td><input type="text" name="motdepasse" id="motdepasse"
value="" size="20"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit"
name="valider" id="valider" value="Valider"/></td>
</tr>
</table>
</form>
</body>
</html>