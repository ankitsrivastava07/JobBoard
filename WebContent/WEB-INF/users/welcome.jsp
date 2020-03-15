<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
</head>
<body>
<%
String email=(String)request.getAttribute("email");
response.getWriter().print("Welcome "+email);
%>
<a href="/job-board/update-profile">Update Profile</a>
</body>
</html>