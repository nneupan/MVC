<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>







<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
	crossorigin="anonymous"></script>
<script type="text/javascript"
	src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
	
	
</head>
<body>

	<!--  %@ include file="header.jspf" %>
-->
	<div class="container">
		<div class="test-center">


			<h1>
				<strong>Login Page</strong>
			</h1>
		</div>
		<br>

		<c:if test="${message ne null }">
			<div class="alert alert-success">
				<strong>${message }</strong>
			</div>
		</c:if>


		<img src="img/school.jpg " style="height: 200px" />

		<form action="authentication" method="post">
			<hr>
			<div class="row">
				<div class="col-md-3">UserId:</div>
				<div class="col-md-4">
				
					<input type="text" name="email" />
				</div>
			</div>

			<br />
			<div class="row">


			 	<div class="col-md-3">Password:</div> 
				<!-- <div class="col-md-4"> -->
				
				<!-- After learning JAVASCRIPT this is copied from internet  -->
				<!-- <label for="password"></label> -->
				<!-- https://www.codejava.net/coding/how-to-code-login-and-logout-with-java-servlet-jsp-and-mysql -->
				
				
				
				<input type="password" name="password" />
				<!-- </div> -->
			</div>
			
			<br> <a class="nav-link" href="welcome.jsp"><strong><button
						type="submit" class="btn btn-primary">
						<div class="col-md-9">Login</div>
					</button></strong></a>

			<hr>
		</form>

	</div>


</body>

<!-- After learning JAVASCRIPT this is copied from internet  -->
<script type="text/javascript">
	$(document).ready(function() {
		$("#login").validate({
			rules : {
				email : {
					required : true,
					email : true
				},

				password : "required",
			},

			messages : {
				email : {
					required : "Please enter email",
					email : "Please enter a valid email address"
				},

				password : "Please enter password"
			}
		});

	});
</script>

</html>







