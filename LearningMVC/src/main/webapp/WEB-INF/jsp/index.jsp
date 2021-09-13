<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Web App</title>
</head>
<body>

<div class="container">
<div class="text-center">
<h1>Web Project Using HiberNate. </h1>
</div>

<%@ include file="header.jspf" %>

<br>
 <form action="getAllStudent">
         <button type="submit">Get All Student</button>
      </form>

 <form action="Registration">
         <button type="submit">Register New Student</button>
      </form>
      
  <form action=StudentDetail>
   Student Id : <input type="text" name="studentId" />
         <button type="submit">Find Student by Id</button>
      </form>   
      
   <form action=deleteStudent>
   Student Id : <input type="text" name="studentId" />
         <button type="submit">Delete Student by Id</button>
      </form>  
        
</div>

</body>
</html>