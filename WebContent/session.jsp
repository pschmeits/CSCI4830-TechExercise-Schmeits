<%--  Kasun Dharmasdasa (https://medium.com/@kasunpdh/session-management-in-java-using-servlet-filters-and-cookies-7c536b40448f) --%>

<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Welcome Page</title>
	</head>
	<body>
		<%
		String validLogin = null;
		String sessionID = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("validCredentials")) validLogin = cookie.getValue();
				if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
			}
		}
		if (validLogin == null || validLogin.equals("")) {
			response.sendRedirect(request.getContextPath() + "/login.html");
		}
		%>
		<h3>Welcome, <%=validLogin%></h3> <br>
		<h4>Session ID = <%=sessionID %></h4>
		<br><br>
		<form action="LogoutServlet" method="post">
			<input type="submit" value="Logout" >
		</form>
	</body>
</html>