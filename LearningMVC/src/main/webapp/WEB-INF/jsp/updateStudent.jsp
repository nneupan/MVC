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
	<form action="updateStudent" method="post">
	<input type="hidden" value="${student.studentId}" name="studentId" />
		<hr>
		Student Information <br/>
		<br />  Name:        <input type="text" value="${student.name }" name="name" /> <br /> <br />
		 Email: <input type="text" value="${student.email }" name="email" /> <br /> <br />
		 Password: <input type="password"  value="${student.password }" name="password" /> <br /> <br />
		 Address: <input type="text" value="${student.address }" name="address" /> <br /> <br />
		 Mobile: <input type="text"value="${student.mobile }" name="mobile" />
		<hr>
		<button type="submit"> Update Student</button>
	</form>
	<c:if test="${message ne null}"> <!-- NE Not Equal, eq Equal -->
	<div class="alert alert-success">
		<strong> ${message } </strong>
	</div>
	</c:if>
</div>
</body>
</html>