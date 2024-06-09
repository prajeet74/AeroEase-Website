<%@page import="util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/adminDashboard.css" />
</head>
<%@ include file="/pages/header.jsp"%>
<body>
	<main class="table">

		<section class="table__header">
			<h1>FlIGHT DETAILS</h1>
			<div class="button-container">
				<a href="${pageContext.request.contextPath}/pages/addFlight.jsp"><button>ADD
						FLIGHTS</button></a>

			</div>
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
								<td>
									<form id="updateForm-${flight.flightID}"
										action="<%=contextPath + StringUtil.SERVLET_URL_MODIFY_FLIGHTS %>">
										<input type="hidden" name="<%=StringUtil.UPDATE_ID %>"
											value="${flight.flightID}" />
										<button onclick="confirmUpdate('${flight.flightID}')">
											UPDATE</button>
									</form>
								</td>

								<td>
									<form id="deleteForm-${flight.flightID}" method="post"
										action="<%=contextPath + StringUtil.SERVLET_URL_MODIFY_FLIGHTS %>">
										<input type="hidden" name="<%=StringUtil.DELETE_ID %>"
											value="${flight.flightID}" />

										<button onclick="confirmDelete('${flight.flightID}')">
											DELETE</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>



				</tbody>
			</table>
		</section>



		<!-- Duplicate the table below -->
		<section class="table__header">
			<h1>USER DETAILS</h1>
			<div class="button-container"></div>
		</section>
		<section class="table__body">
			<table>
				<thead>
					<tr>

						<th>Username</th>
						<th>Phone Number</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>DOB</th>

					</tr>
				</thead>
				<tbody>
					<c:if test="${empty userList}">
						<p>No users found.</p>
					</c:if>

					<c:if test="${not empty userList}">
						<c:forEach var="user" items="${userList}">

							<tr>

								<td>${user.userName}</td>
								<td>${user.phoneNumber}</td>
								<td>${user.firstName}</td>
								<td>${user.lastName}</td>
								<td>${user.dob}</td>
							</tr>
						</c:forEach>
					</c:if>




				</tbody>
			</table>
		</section>


	</main>

</body>
<script>
	function confirmDelete(flightID) {
		if (confirm("Are you sure you want to delete this flight details: "
				+ flightID + "?")) {
			document.getElementById("deleteForm-" + flightID).submit();
		} else {
			return false; // Prevent form submission
		}
	}
</script>

<script>
	function confirmUpdate(flightID) {

		document.getElementById("updateForm-" + flightID).submit();
	}
</script>
</html>
<%@ include file="/pages/footer.jsp"%>