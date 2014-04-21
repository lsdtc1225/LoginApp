<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ page import="org.koushik.javabrains.dto.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success</title>
</head>
<body>

	<h3>Log in Successful !</h3>
	
	
	<%
		//User user = (User) session.getAttribute("user");
		//User user = (User) request.getAttribute("user");	
	%>
	
	
	<jsp:useBean id="user" class="org.koushik.javabrains.dto.User" scope="request"> <!-- this is equivalent to the previous 4 lines of code -->
		<jsp:setProperty property="userName" name="user" value="NewUser" /> <!-- if useBean not reatrieve the existing user, it is going to call this line -->
	</jsp:useBean>
	
	
	<!--Hello --><% //=user.getUserName() %>
	
	Hello <jsp:getProperty property="userName" name="user"/>

</body>
</html>