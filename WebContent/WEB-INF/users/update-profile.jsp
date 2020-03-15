<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
</head>
<body>

<%
String email=(String)session.getAttribute("email");
%>

<table align="center" cellpadding = "10">

<tr>
<td>First Name</td>
<td>
<input type="text" name="first-name" placeholder="First Name" />
</td>
</tr>

<tr>
<td>Last Name</td>
<td><input type="text" name="last-name" placeholder="Last Name"/>
</td>
</tr>

<tr>
<td>Email ID</td>
<td><input type="email" name="email" value=<%=email %>
 placeholder="example@gmail.com"/></td>
</tr>

<tr>
<td>Mobile Number</td>
<td>
<input type="text" name="mobile" maxlength="10" placeholder="7842xxxxxx"/>
(10 Digits Allowed)
</td>
</tr>

<tr>
<td>Gender</td>
<td>
<input type="radio" name="gender" value="Male" />
Male
<input type="radio" name="gender" value="Female" />
Female
</td>
</tr>

<tr>
<td>Date of Birth(DOB)</td>
<td>
<input type="date" name="date">
</td>
</tr>
<tr>
<td>
Qualification :
</td>
<td>

</td>
</tr>


</table>
</body>
</html>