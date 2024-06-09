<%@page import="util.StringUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>






<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title></title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/profilePage.css" />

</head>
<%@ include file="/pages/header.jsp"%>
<body>
<form id="updateForm-${userModel.userName}"
									action="<%=contextPath + StringUtil.SERVLET_URL_PROFILE%>"
									method="POST">
		<h2>USER PROFILE</h2>
		<div class="glass-frame">
			<div class="profile-info" id="profilePicContainer">
				<img src="resources/images/users/${userModel.imageUrlFromPath}" alt="Profile Picture"> <input type="file"
					id="profilePic" accept="image/*" onchange="displayImage(this)"  >
			</div>
			<div class="two-fields">
				<div class="profile-info">
					<label for="username">Username</label><br> <input type="text"
						id="username" name="userName" value="${userModel.userName}" readonly>
				</div>
				<div class="profile-info">
					<label for="phone">Phone Number</label><br> <input type="tel"
						id="phone" value="${userModel.phoneNumber}" name="phoneNumber">
				</div>
			</div>
			<div class="two-fields">
				<div class="profile-info">
					<label for="firstName">First Name</label><br> <input
						type="text" id="firstName" value="${userModel.firstName}"
						name="firstName">
				</div>
				<div class="profile-info">
					<label for="lastName">Last Name</label><br> <input type="text"
						id="lastName" value="${userModel.lastName}" name="lastName">
				</div>
			</div>
			<div class="profile-info">
				<label for="dob">Date of Birth</label><br> <input type="date"
					id="dob" value="${userModel.dob}" name="date">
			</div>
			<input type="hidden" name="<%=StringUtil.UPDATE_ID %>"
				value="${userModel.userName}" />
				
				<button onclick="confirmUpdate('${userModel.userName}')">UPDATE INFORMATION</button>
		
		</div>
	</form>

</body>


<script>
	function confirmUpdate(userName) {
		if (confirm("Are you sure you want to update your detail: " + userName
				+ "?")) {
			document.getElementById("updateForm-" + userName).submit();
		}
	}
</script>
</html>
<%@ include file="/pages/footer.jsp"%>