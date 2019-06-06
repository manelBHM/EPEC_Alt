<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    	<head>
    		<%@page import="java.util.List"%>
    		<%@page import="java.util.ArrayList"%>
    		<%@page import="com.Entity.*" %>
    		<title>Managing Airline</title>
    		<meta charset="UTF-8">
    		<link href="https://fonts.googleapis.com/css?family=Montserrat:100,300,400,700" rel="stylesheet">
    		<link rel="stylesheet" href="style.css">
    	</head>
    	<body>
    		<div class="main">
    			<header>
    				<h1>Airline's Lane</h1>
    				<nav>
    					<ul>
    						<li><a href="FlightServlet">Home</a></li>
    						<li><a href="#">Add flight</a></li>
    						
    					</ul>
    				</nav>
    			</header>
    			<div class="container">
    				<h3>Add details</h3>
    				<div class="add_details">
    					<form action="FlightServlet" method="POST">
    						<section class="left">
    							<label>From : </label>
    							<input type="text" id="depart" name="depart" required placeholder="Ex: Berlin">
    							<label>To : </label>
    							<input type="text" id="arrive" name="arrive" required placeholder="Ex: Paris">
    							<label>Plane : </label>
    							<input type="number" id="plane" name="plane" required placeholder="Ex: 1">
    							<label>Pilot : </label>
    							<input type="number" id="pilot" name="pilot" required placeholder="Ex: 1">
    						</section>
    						<section class="right">
    							<label>Flight number : </label>
    							<input type="text" id="flightNo" name="flightNo" required placeholder="Ex: DX909">			
    						</section>
    						<button type="submit" class="addDetails">Submit</button>
    					</form>
    				</div>
    			</div>
    			<footer>
    				<marquee>Person group dataTable| copyrights reserved - 2019 © Ships</marquee>
    			</footer>
    		</div>
    	</body>
    </html>