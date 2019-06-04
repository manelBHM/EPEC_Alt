<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.1/animate.css" />
	<link rel="stylesheet" href="style.css">
</head>
<body>
	<div class="cr"> 
		<p>copyright Ships©2019</p>
	</div>
 <div class="main">
	<h2>Authentification Prototype</h2>
	<form class="top" action="servletMain" method="POST">
		<label>User name : </label>
		<input type="text" name="user" required>
		<label>Password :</label>
		<input type="password" name="pass" required>
		<br>
		<button class="btn_top" type="submit">Submit</button>
	</form>
	<form action="regServ" method="GET">
		<button class="btn-bottom" type="submit">Create account</button>
	</form>
 </div>
</body>
</html>
