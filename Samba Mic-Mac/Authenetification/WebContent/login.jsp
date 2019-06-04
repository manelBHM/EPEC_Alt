<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link href="css/style.css" type="text/css" rel="stylesheet"/>
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Welcome</title>
</head>
<body>
    <h1>Welcome to the home page</h1>
    
    
    <body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-form-title" style="background-image: url(images/bg-01.jpg);">
					<span class="login100-form-title-1">
						Sign In
					</span>
				</div>

				<form action="menber.jsp" method="post"  class="login100-form validate-form">
					<div class="wrap-input100 validate-input m-b-26" data-validate="Username is required">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="username" placeholder="Enter username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-18" data-validate = "Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="password" placeholder="Enter password">
						<span class="focus-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-b-30">
						<div class="contact100-form-checkbox">
							<input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
							<label class="label-checkbox100" for="ckb1">
								Remember me
							</label>
						</div>

						<div>
							<a href="#" class="txt1">
								Forgot Password?
							</a>
						</div>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" type="submit" value="login">
							Login
						</button>
						
					</div>
				</form>
			</div>
		</div>
	</div>	

</body>
    
    <!-- <form action="LoginCheck" method="post">
          
          <table>
          <tr>
             <td>
                Please enter your username 
                <input type="text" name="username"/><br>
             </td>
            </tr>
            
          <tr>
             <td>
             Please enter your password
			<input type="password" name="password"/>
             </td>
          </tr>
		   
		      <tr>
		         <td>
		         Please enter your password
		         	<input type="submit" value="login"/>
		        </td>
		      </tr>
					
		</table>
		</form>
</body>-->
</html>