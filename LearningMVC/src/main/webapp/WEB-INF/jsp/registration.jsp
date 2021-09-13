<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration</title>
</head>
<body>

<%@ include file="header.jspf" %>
<div  class="container">
<div class="text-center">
	<h1>Registration Page</h1>
	</div>
	<form action="register" method="post">
		<hr>
		Student Information <br/>
		<br />  Name:        <input type="text" value="" name="name" /> <br /> <br />
		 Email: <input type="text" value="" name="email" /> <br /> <br />
		 Password: <input type="password" value="" name="password" /> <br /> <br />
		 Address: <input type="text" value="" name="address" /> <br /> <br />
		 Mobile: <input type="text" value="" name="mobile" />
		<hr>
		<button type="submit"> Register Student</button>
	</form>
	<c:if test="${message ne null}"> <!-- NE Not Equal, eq Equal -->
	<div class="alert alert-success">
		<strong> ${message } </strong>
	</div>
	</c:if>
</div>
</body>
</html>