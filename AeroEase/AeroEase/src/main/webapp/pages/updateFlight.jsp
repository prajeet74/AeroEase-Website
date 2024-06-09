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
		<form action="${pageContext.request.contextPath}/ModifyFlights" method="post">
			<div class="two-fields">
				<div class="form-group">
					<label for="flightID">Flight ID:</label> <input type="text"
						id="flightID" name="flightID" value="${flight.flightID}" readonly>
				</div>

				<div class="form-group">
					<label for="aircraft">Aircraft:</label> <input type="text"
						id="aircraft" name="aircraftName" value="${flight.aircraft}"required>
				</div>
				<div class="form-group">
					<label for="price">Price:</label> <input type="number" id="price"
						name="ticketPrice" value="${flight.price}" required>
				</div>

			</div>

			<div class="form-group">
				<label for="date">Date:</label> <input type="date" id="date"
					name="date" value="${flight.date}" required>
			</div>
			<div class="two-fields">
				<div class="form-group">
					<label for="departureTime">Departure Time:</label> <input
						type="time" id="departureTime" name="departureTime"
						value="${flight.departureTime}" required>
				</div>

				<div class="form-group">
					<label for="arrivalTime">Arrival Time:</label> <input type="time"
						id="arrivalTime" name="arrivalTime"
						value="${flight.arrivalTime}"required>
				</div>
			</div>
			<div class="two-fields">

				<div class="form-group">
					<label for="destination">Origin Airport:</label> <select
						class="form-input" name="originAirport" id="gameGenre"
						value="${flight.origin}">
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
						class="form-input" name="destinationAirport" id="destinationPlace"
						value="${flight.destination}">
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
					<label for="seatsAvailable">Seats
						Available:</label> <input type="number" id="seatsAvailable"  value="${flight.availableSeat}"
						name="availableSeat" required>
				</div>

			</div>
			<input type="hidden" name="<%=StringUtil.UPDATE_ID %>"
				value="${flight.flightID}" />

				<button onclick="confirmUpdate('${flight.flightID}')">UPDATE FLIGHTS</button>
		</form>

	</div>

</body>

<script>
	function confirmUpdate(flightID) {
		if (confirm("Are you sure you want to update this flight details: " + flightID
				+ "?")) {
			document.getElementById("updateForm-" + flightID).submit();
		}
	}
</script>
</html>
