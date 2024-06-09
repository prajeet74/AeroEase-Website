<%@page import="util.StringUtil"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>

<%
    // Get the session and request objects
    HttpSession userSession = request.getSession(false);
    String currentUser = (String) userSession.getAttribute(StringUtil.USERNAME);
    String contextPath = request.getContextPath();
%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/stylesheets/header.css" />
</head>
<body>
	<nav>
		<input type="checkbox" id="nav-toggle">
		<div class="logo">
			Aero<strong>Ease</strong>
		</div>
		<ul class="links">
		
			 <% if (currentUser != null && currentUser.equals("admin")) { %>
			 <li><a href="${pageContext.request.contextPath}/pages/adminDashboard.jsp">Dashboard</a></li>

			<li><a href="${pageContext.request.contextPath}/Profile">Profile</a></li>
                <% } else { %>
				<li><a href="${pageContext.request.contextPath}/pages/home.jsp">Home</a></li>

			<li><a href="${pageContext.request.contextPath}/Profile">Profile</a></li>
					<% } %>

			<li>

				<form
					action="<%
                    // Conditionally set the action URL based on user session
                    if (currentUser != null) {
                        out.print(contextPath + StringUtil.SERVLET_URL_LOGOUT);
                    } else {
                        out.print(contextPath + StringUtil.PAGE_URL_LOGIN);
                    }
                %>"
					method="post">
					<button type="submit" class="sigin-btn" value="">
						<%
                        // Conditionally set the button label based on user session
                        if (currentUser != null) {
                            out.print(StringUtil.LOGOUT);
                        } else {
                            out.print(StringUtil.LOGIN);
                        }
                    %>
					</button>
				</form>
			</li>


		</ul>
	
	</nav>
</body>
</html>