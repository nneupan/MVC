<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Student</title>
</head>

<body>
	<%@ include file="header.jspf"%>
		<div class="container">
		<div class="text-center">
			<h1>Student Information Page</h1>
		</div>
		<c:if test="${message ne null }">  <!-- ne -not equal , eq->equal -->
			<div class="alert alert-success">
				<strong>${message }</strong>
			</div>
		</c:if>
		<table class="table table-bordered table-hover">
			<thead class="thead-light">
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Mobile</th>
				<th>Action</th>
			</thead>
			<tbody>
				
					<tr>
						<td>${student.name }</td>
						<td>${student.email }</td>
						<td>${student.address }</td>
						<td>${student.mobile}</td>
						<td>
							<a href="StudentDetail?studentId=${student.studentId}">Student Details</a>
							<a href="deleteStudent?studentId=${student.studentId}"><img src="img/delete.jpg" style="height:40px"/></a>
							<a href="updateStudent?studentId=${student.studentId}"><img src="img/edit.png" style="height:40px"/></a>
						</td>
					</tr>
				
			</tbody>
		</table>
	</div>
	
</body>
</html>