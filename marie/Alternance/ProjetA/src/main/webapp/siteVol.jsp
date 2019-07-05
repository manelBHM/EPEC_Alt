<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SiteVol</title>
<style type="text/css">
body{
font-family: Arial;
}
h1{
text-align: center;
}
h2{
text-align: center;
}
p{
text-align: center;
}
</style>
</head>
<body>
<h1>Welcome</h1>
<br>
<h2>Liste  des pilote</h2>
<br>
<h2>Liste des vols</h2>
		<p>
			<%
				out.println(request.getAttribute("afficherProduit"));
			%>
		</p>
</body>
</html>