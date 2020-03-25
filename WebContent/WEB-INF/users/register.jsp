<%@ page import="java.util.List"%>
<%@ page import="users.entities.CountryEntity" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Register in Just 2 Minutes</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/bootstrap.min.css" rel="stylesheet" />

<!-- Custom fonts for this template -->
<link href="css/all.min.css" rel="stylesheet">
<link href="css/simple-line-icons.css" rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- Custom styles for this template -->
<link href="css/landing-page.min.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="validation/user-register.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/JobPortal/">MY JobBoard</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/JobPortal/">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="/JobPortal/">About
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="/JobPortal/">Services
						<span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item active"><a class="nav-link" href="JobPortal/login1">Login
						<span class="sr-only">(current)</span>
				</a></li>

				<li class="nav-item active"><a class="nav-link" href="/JobPortal/create-user">Register</a></li>
			</ul>
		</div>
	</nav>
	<div id="errors" style="color:red"></div>
	<form action="/JobPortal/create-user" method="Post">
<!-- onsubmit="doRegister()" -->

		<table align="center" cellpadding="10">
			<tr>
				<td>First Name :</td>
				<td><input type="text" onblur="return isEmpty(this)" maxlength="15" name="firstName"
				id="firstName"></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><input type="text" onblur="return isEmpty(this)" maxlength="15" name="lastName"
				id="lastName"></td>
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><input type="text" onblur="return isValidPhone(this)" name="mobile"
					id="mobile"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="text" onblur="isValidEmail(this)" name="email"
					id="email" ></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" 
			onblur="return isEmpty(this)" name="password" id="password" >
			</tr>
			<tr>
			<td>
			Gender :
			</td>
			<td>
			<input type="radio" name="gender" value="Mae">Male &emsp;
			<input type="radio" name="gender" value="Female">Female &emsp;
			</td>	
			</tr>			
			<tr>
			<td>Current Country:</td>	
			<td>
			<select name="country" id="country" onchange="getStates()">
			<option select="selected" value="">Select Country</option>
			<c:forEach items="${countries}"  var="country">
			 <option value="${country.id}">${country.name}</option>
			</c:forEach> 
			</select>
			</td>
			</tr>
			<tr>
				<td>Current State:</td>
				<td><select name="state" id="state" onblur="isEmpty(this)">
				<c:forEach items="${states}" var="state">
				<option value="${state.name}">${state.name}</option>
				</c:forEach>
				</select>
				</td>
			</tr>
			<tr>
			<td></td>
				<td><input type="submit" class="primary button" value="Register" /></td>
			</tr>
		</table>
	</form>
	<div id="success" style="color:green"></div>
	<%@ include file="/WEB-INF/common/footer.jsp"%>