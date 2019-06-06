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
    						<li><a href="#">Pilot</a></li>
    						<li><a href="addflight.jsp">Add flight</a></li>
    					</ul>
    				</nav>
    			</header>
    			<div class="container">
    				<h3>Flight List</h3>
    				<table>
    					<thead>
    						<tr>
    							<th>Flight no</th>
    							<th>Departure</th>
    							<th>Arrival</th>
    							<th>Pilot</th>
    							<th>Plane</th>
    							<th>Edit/Delete</th>
    						</tr>
    					</thead>
    					<tbody>
    							<% if ((ArrayList<?>)request.getAttribute("flightsList") != null) {
    								@SuppressWarnings("unchecked")
    								ArrayList<Flights>flightsList = (ArrayList<Flights>)request.getAttribute("flightsList");
    								for(int i = 0; i < flightsList.size(); i++){
    									Flights flight = flightsList.get(i);%>
    									<tr>
    										<td><%= flight.getFlightNo().toUpperCase() %></td>
    										<td><%= flight.getDepart().toUpperCase() %></td>
    										<td><%= flight.getArrive() %></td>
    										<td><%= flight.getPilotFname() + " " + flight.getPilotLname() %></td>
    										<td><%= flight.getPlane() %></td>
    										<td>
    											<form method="get" action="FlightServlet">
    												<input type="hidden" name="id_edit" value="<%= flight.getId() %>">
    												<button class="btn_edit" type="submit">Edit</button>
    											</form>
    											<form method="get" action="FlightServlet">
    												<input type="hidden" name="id_delete" value="<%= flight.getId() %>">
    												<button class="btn_delete" type="submit">Delete</button>
    											</form>
    										</td>
    									</tr>			
    								<%}%>
    							<%}%>
    					</tbody>
    				</table>
    				<div class="filter">
    					<h3>Filter flight</h3>
    					<form action="FlightServlet" method="get">
    						<div class="inputs">
		    					<label>Get by flight no :</label>
		    					<input type="text" name="fligthNo" id="fligthNo" required>
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    					<form action="FlightServlet" method="get">
    						<div class="inputs">
		    					<label>Get by departure :</label>
		    					<input type="text" name="depart" id="depart" required>
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    					<form action="FlightServlet" method="get">
    						<div class="inputs">
		    					<label>Get by arrival :</label>
		    					<input type="text" name="arrive" id="arrive" required>
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    					<form action="FlightServlet" method="get">
    						<div class="inputs">
		    					<label>Get by Pilot :</label>
		    					<input type="text" name="pilotName" id="pilotName" required>
		    				</div>
		    				<br>
		    				<button type="submit">Submit</button>
    					</form>
    				</div>
    			</div>
    			<footer>
    				<marquee>Airlines dataTable| copyrights reserved - 2019 © Ships</marquee>
    			</footer>
    		</div>
    	</body>
    </html>