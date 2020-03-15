<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<form action="/job-board/login" method="Post">
	
		<table>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email"></td>
			</tr>

			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
				
			</tr>
			<tr><td><input type="submit" value="submit"></td></tr>
		</table>
</body>
</html>