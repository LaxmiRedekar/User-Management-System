<%@page import="java.util.ArrayList"%>
<%@page import="com.model.User" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="a" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous"><link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<style type="text/css">
	body{
		background-color: rgb(159, 96, 96);
		color: white;
		font-family: cursive;
	}
	.table{
		border: 2px;
		border-color: white;
	}
	.container{
		background-color: #804d4d;
		width: 700px;
		height: auto;
		border-radius: 20px;
		box-shadow: 20px;
		border-color: white;
	}
	#id{
		margin-left: 200px;
		background-color: transparent;
		border-color: white;
		color: white;
	}
	
	.container:hover {
		transform: scale(1.1);
		z-index: 2;
	}
	#id:hover {
		background-color: rgb(159, 96, 96);
	}
</style>
</head>
<body>

 <br>
	
 <div class="container">
   
   <h2 align="center">USER INFORMATION</h2><br>
   <table align="center" >
     <thead>
        <th>ID</th>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>CITY</th>
        <th>ACTION</th>
     </thead>
     <tbody>
        <%ArrayList<User> al=(ArrayList<User>)request.getAttribute("display");  %>
        <%for(User user:al) {%>
           <tr>
             <td><%= user.getId()%>&nbsp;&nbsp;</td>
             <td><%= user.getName()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
             <td><%= user.getEmail()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
             <td><%= user.getCity()%>&nbsp;&nbsp;</td>
             <td>
             <a href="<%= request.getContextPath()%>/edit?id=<%=user.getId()%>">EDIT</a>&nbsp;
             <a href="<%= request.getContextPath()%>/delete?id=<%=user.getId()%>">DELETE</a></td>
           </tr>
        <%}
        %>
     </tbody>
   </table> <br>
   <a href="<%= request.getContextPath()%>/add" class="btn" id="id" >ADD USER</a><br><br>
   <br>
 </div>
</body>
</html>
