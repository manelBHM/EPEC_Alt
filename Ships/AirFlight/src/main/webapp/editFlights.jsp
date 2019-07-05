<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    	<head>
    		<%@page import="java.util.List"%>
    		<%@page import="java.util.ArrayList"%>
    		<%@page import="com.Entity.*" %>
    		<title>Airlane's Lane</title>
    		<meta charset="UTF-8">
    		<link href="https://fonts.googleapis.com/css?family=Montserrat:100,300,400,700" rel="stylesheet">
    		<link rel="stylesheet" href="style.css">
    		<style>
     			.backPic { 
     				background-image: url("person1.jpg"); 
     				color: white; 
     				position: absolute;
     				height: 600px;
     				width: 100%;
      				z-index: -1; 
					top: 205px;
					left: 0;
					filter: blur(2px);
     			} 
     			.edit_details {
     				background-color: rgba(0, 0, 0, 0.8);
     				color: white;
     			}
     			
    		</style>
    	</head>
    	<body>
    		<div class="main">
    			<header>
    				<h1>Group of Persons</h1>
    				<nav>
    					<ul>
    						<li><a href="FlightServlet">Home</a></li>
    						<li><a href="#">Admin</a></li>
    					</ul>
    				</nav>
    			</header>
    			<div class="backPic"></div>
    			<div class="container">
    				<h3>Edit details</h3>
    				<div class="edit_details">
    					<form action="EditFlServlet" method="POST">
    						
    							<% String strValue = (String)request.getAttribute("id_Str"); %>
    						
    						<section class="left">
    							<input type="hidden" name="id_edit" value="<%=strValue %>">
    							<label>Departure : </label>
    							<input type="text" id="depart" name="depart" required placeholder="Ex: Paris">
    							<label>Arrival : </label>
    							<input type="text" id="arrive" name="arrive" required placeholder="Ex: London">
    							<label>Plane : </label>
    							<input type="number" id="plane" name="plane" required placeholder="Ex: 1">
    							<label>Pilot(first name) : </label>
    							<input type="number" id="pilot" name="pilot" required placeholder="Ex: 2">
    						</section>
    						<section class="right">
    							<label>Flight no : </label>
    							<input type="text" id="flightNo" name="flightNo" required placeholder="Ex: XD908">
    						</section>
    						<button type="submit">Submit</button>
    					</form>
    				</div>
    			</div>
    			<footer>
    				<marquee>Person group dataTable| copyrights reserved - 2019 © Ships</marquee>
    			</footer>
    		</div>
    	</body>
    </html>