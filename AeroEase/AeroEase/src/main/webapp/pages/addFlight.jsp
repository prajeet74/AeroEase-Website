<%@page import="util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/addFlight.css" />
</head>
<body>

	<div class="container">
		<h1>FLIGHT DETAILS</h1>
		<form action="../AddFlights" method="post">
			<div class="two-fields">
				<div class="form-group">
					<label for="flightID">Flight ID:</label> <input type="text"
						id="flightID" name="flightID" required>
				</div>

				<div class="form-group">
					<label for="aircraft">Aircraft:</label> <input type="text"
						id="aircraft" name="aircraftName" required>
				</div>
				<div class="form-group">
					<label for="price">Price:</label> <input type="number" id="price"
						name="ticketPrice" required>
				</div>

			</div>

			<div class="form-group">
				<label for="date">Date:</label> <input type="date" id="date"
					name="date" required>
			</div>
			<div class="two-fields">
				<div class="form-group">
					<label for="departureTime">Departure Time:</label> <input
						type="time" id="departureTime" name="departureTime" required>
				</div>

				<div class="form-group">
					<label for="arrivalTime">Arrival Time:</label> <input type="time"
						id="arrivalTime" name="arrivalTime" required>
				</div>
			</div>
			<div class="two-fields">

				<div class="form-group">
					<label for="destination">Origin Airport:</label> <select
						class="form-input" name="originAirport" id="gameGenre">
						<option value="TIA">TIA</option>
						<option value="Biratnagar Airport">Biratnagar Airport</option>
						<option value=">Bharatpur Airport">Bharatpur Airport</option>
						<option value="Nepalgunj Airport">Nepalgunj Airport</option>
						<option value="Tenzing-Hillary Airport">Tenzing-Hillary Airport</option>
						<option value="Simara Airport">Simara Airport</option>
						<option value="Surkhet Airport">Surkhet Airport</option>
						<option value="Dhangadhi Airport">Dhangadhi Airport</option>
						<option value="Janakpur Airport">Janakpur Airport</option>
						<option value="Rajbiraj Airport">Rajbiraj Airport</option>
						<option value="Dolpo Airport">Dolpo Airport</option>
						<option value="Doti Airport">Doti Airport</option>
						<option value="Salle Airport">Salle Airport</option>
						<option value="Rolpa Airport">Rolpa Airport</option>
						<option value="Balewa Airport">Balewa Airport</option>


					</select>


				</div>


				<div class="form-group">
					<label for="destination">Destination Airport:</label> <select
						class="form-input" name="destinationAirport" id="destinationPlace">
							<option value="TIA">TIA</option>
						<option value="Biratnagar Airport">Biratnagar Airport</option>
						<option value=">Bharatpur Airport">Bharatpur Airport</option>
						<option value="Nepalgunj Airport">Nepalgunj Airport</option>
						<option value="Tenzing-Hillary Airport">Tenzing-Hillary Airport</option>
						<option value="Simara Airport">Simara Airport</option>
						<option value="Surkhet Airport">Surkhet Airport</option>
						<option value="Dhangadhi Airport">Dhangadhi Airport</option>
						<option value="Janakpur Airport">Janakpur Airport</option>
						<option value="Rajbiraj Airport">Rajbiraj Airport</option>
						<option value="Dolpo Airport">Dolpo Airport</option>
						<option value="Doti Airport">Doti Airport</option>
						<option value="Salle Airport">Salle Airport</option>
						<option value="Rolpa Airport">Rolpa Airport</option>
						<option value="Balewa Airport">Balewa Airport</option>
					</select>
				</div>


				<div class="form-group">
					<label for="seatsAvailable">Seats Available:</label> <input
						type="number" id="seatsAvailable" name="availableSeat" required>
				</div>

		<%
			String errMsg = (String) request.getAttribute(StringUtil.MESSAGE_ERROR);
			String successMsg = (String) request.getAttribute(StringUtil.MESSAGE_SUCCESS);

			if (errMsg != null) {
				// print
			%>
			<h4 class="error-msg">
				<%
				out.println(errMsg);
				%>
			</h4>
			<%
			}
			if (successMsg != null) {
			// print
			%>
			<h4 class="success-msg1">
				<%
				out.println(successMsg);
				%>
			</h4>
			<%
			}
			%>



			</div>
			<a href="${pageContext.request.contextPath}/pages/adminDashboard.jsp">
				<input type="submit" value="ADD DETAILS">
			</a>

	

		</form>
	</div>

</body>
</html>
