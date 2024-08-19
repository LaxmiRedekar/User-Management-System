<%@page import="com.model.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<title>user form</title>
<style type="text/css">
	body{
		background-color: #f5efef;
		font-family: cursive;
	}
	.container{
		background-color: #e2cfcf;
		width: 700px;
		height: auto;
		margin-top: 70px;
	}
	.container:hover {
		transform: scale(1.2);
		z-index: 2;
	}
	 .btn{
	 	background-color: transparent;
	 	border-color: white;
	 }
	.btn:hover {
		background-color: #f5efef;
	}
</style>
</head>
<body>
 
  <div class="container" align="center">
  
  <c:if test="${list==null }">
  	<form action="insert" method="post">
  </c:if>
  
  <c:if test="${list!=null }">
  	<form action="update" method="post">
  </c:if>
  <br>
  <h2 align="center">
  	<c:if test="${list==null }">
  	ADD USER INFORMATION
  	</c:if>
  	<c:if test="${list!=null }">
  	EDIT USER INFORMATION
  	</c:if>
  </h2>
  <%User user = (User)request.getAttribute("list"); %>
 
    <input type="hidden" class="form-control" id = "id1" name="id" value="${list.id }" placeholder="Enter Your Id" style="width: 300px">
  <br>
  
    <label for="name" class="form-label">Name</label>
    <input type="text" class="form-control" id = "name" name="name" value="${list.name }" placeholder="Enter Your Name" style="width: 300px">
  <br>
 
    <label for="email" class="form-label">Email</label>
    <input type="email" class="form-control" id = "email" name="email" value="${list.email }" placeholder="Enter Your Email" style="width: 300px">
  <br>
 
    <label for="city" class="form-label">City</label>
    <input type="text" class="form-control" id = "city" name="city" value="${list.city }" placeholder="Enter Your City" style="width: 300px">
  	<br>
  
    <input type="submit" id="btnSub" value="Save" class="btn" style="width: 100px"><br>
    Added Successfully? View User Information &nbsp;
    <a class="btn" aria-current="page" href="<%= request.getContextPath()%>/list">User List</a>
  </form><br>
  </div>
</body>
</html>