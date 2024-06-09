<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/home.css" />
</head>
<%@ include file="/pages/header.jsp"%>
<body>





	<main class="table">
		<section class="table__header">
			<h1>TICKET DETAILS</h1>
		</section>
		<section class="table__body">
			<table>
				<thead>
					<tr>
						<th>FlightID</th>
						<th>Date</th>
						<th>Origin</th>
						<th>Destination</th>
						<th>Departure Time</th>
						<th>Arrival Time</th>
						<th>Aircraft</th>
						<th>Seat Available</th>
						<th>Price</th>

						<th></th>
					</tr>

				</thead>
				<tbody>
				
					<c:if test="${empty flightList}">
						<p>No flights found.</p>
					</c:if>

					<c:if test="${not empty flightList}">
						<c:forEach var="flight" items="${flightList}">
							<tr>
								<td>${flight.flightID}</td>
								<td>${flight.date}</td>
								<td>${flight.origin}</td>
								<td>${flight.destination}</td>
								<td>${flight.departureTime}</td>
								<td>${flight.arrivalTime}</td>
								<td>${flight.aircraft}</td>
								<td>${flight.availableSeat}</td>
								<td><strong>Rs.${flight.price}</strong></td>
								<td><button>BUY</button></td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</section>
	</main>

</body>

</html>
<%@ include file="/pages/footer.jsp"%>